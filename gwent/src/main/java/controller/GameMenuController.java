package controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import model.*;
import view.CardListCellFactory;

import java.util.regex.Matcher;

public class GameMenuController {

    @FXML
    public ImageView firstPlayerCrystal2;
    @FXML
    public ImageView firstPlayerCrystal1;
    @FXML
    public ImageView secondPlayerCrystal1;
    @FXML
    public ImageView secondPlayerCrystal2;
    @FXML
    public ImageView weatherCard;
    @FXML
    public Button firstPlayerPass;
    @FXML
    public Button secondPlayerPass;
    @FXML
    public ImageView firstPlayerSiegeBoost;
    @FXML
    public ImageView firstPlayerRangedBoost;
    @FXML
    public ImageView firstPlayerCloseCombatBoost;
    @FXML
    public ImageView secondPlayerCloseCombatBoost;
    @FXML
    public ImageView secondPlayerRangedBoost;
    @FXML
    public ImageView secondPlayerSiegeBoost;
    @FXML
    public ImageView secondPlayerCards;
    @FXML
    public ImageView firstPlayerBurnedCards;
    @FXML
    public ImageView firstPlayerCards;
    @FXML
    public ImageView secondPlayerBurnedCards;
    @FXML
    public ListView currentPlayerHand;
    @FXML
    public ListView firstPlayerRangedList;
    @FXML
    public ListView firstPlayerCloseCombatList;
    @FXML
    public ListView secondPlayerCloseCombatList;
    @FXML
    public ListView secondPlayerRangedList;
    @FXML
    public ListView secondPlayerSiegeList;
    @FXML
    public ListView firstPlayerSiegeList;
    @FXML
    public Label firstPlayerSiege;
    @FXML
    public Label firstPlayerRanged;
    @FXML
    public Label secondPlayerRanged;
    @FXML
    public Label secondPlayerCloseCombat;
    @FXML
    public Label firstPlayerCloseCombat;
    @FXML
    public Label firstPlayerTotalBoardStrength;
    @FXML
    public Label secondPlayerRemainingCards;
    @FXML
    public Label firstPlayerRemainingCards;
    @FXML
    public Label secondPlayerTotalBoardStrength;
    @FXML
    public ImageView firstPlayerLeaderCard;
    @FXML
    public ImageView secondPlayerLeaderCard;
    @FXML
    public Label secondPlayerSiege;
    @FXML
    public Label player2FactionName;
    @FXML
    public Label player1FactionName;
    @FXML
    public ImageView secondPlayerFactionImage;
    @FXML
    public ImageView firstPlayerFactionImage;
    @FXML
    public ImageView secondPlayerLeaderActive;
    @FXML
    public ImageView firstPlayerLeaderActive;
    @FXML
    public Label firstPlayerCountOfCards;
    @FXML
    public Label secondPlayerCountOfCards;

    @FXML
    public void initialize() {
        Game game = User.getLoggedInUser().getCurrentGame();
        game.setGamePlayer2(new EachPlayerGame(game.getPlayer2()));
        Faction factionPlayer1  = game.getPlayer1().getFaction();
        Faction factionPlayer2  = game.getPlayer2().getFaction();
        player1FactionName.setText(factionPlayer1.getName());
        player2FactionName.setText(factionPlayer2.getName());
        firstPlayerFactionImage.setImage(factionPlayer1.getImage());
        secondPlayerFactionImage.setImage(factionPlayer2.getImage());
        firstPlayerLeaderCard.setImage(game.getPlayer1().getLeaderCard().getImage());
        secondPlayerLeaderCard.setImage(game.getPlayer2().getLeaderCard().getImage());
        firstPlayerCards.setImage(game.getPlayer1().getFaction().getImage());
        secondPlayerCards.setImage(game.getPlayer2().getFaction().getImage());
        firstPlayerCountOfCards.setText(String.valueOf(game.getPlayer1().getDeck().size()));
        secondPlayerCountOfCards.setText(String.valueOf(game.getPlayer2().getDeck().size()));
        if (game.getGamePlayer1().getCrystals() == 1) firstPlayerCrystal2.setVisible(false);
        if (game.getGamePlayer2().getCrystals() == 1) secondPlayerCrystal2.setVisible(false);
        firstPlayerRemainingCards.setText(String.valueOf(game.getGamePlayer1().getHand().size()));
        secondPlayerRemainingCards.setText(String.valueOf(game.getGamePlayer2().getHand().size()));
        if (game.getWeatherCard() != null) weatherCard.setImage(game.getWeatherCard().getImage());
        if (game.getGamePlayer1().getMarCoCloseCombat() != null) {
            firstPlayerCloseCombatBoost.setImage(game.getGamePlayer1().getMarCoCloseCombat().getImage());
        }
        if (game.getGamePlayer1().getMarCoRangedCombat() != null) {
            firstPlayerRangedBoost.setImage(game.getGamePlayer1().getMarCoRangedCombat().getImage());
        }
        if (game.getGamePlayer1().getMarCoSiege() != null) {
            firstPlayerSiegeBoost.setImage(game.getGamePlayer1().getMarCoSiege().getImage());
        }
        if (game.getGamePlayer2().getMarCoCloseCombat() != null) {
            secondPlayerCloseCombatBoost.setImage(game.getGamePlayer2().getMarCoCloseCombat().getImage());
        }
        if (game.getGamePlayer2().getMarCoRangedCombat() != null) {
            secondPlayerRangedBoost.setImage(game.getGamePlayer2().getMarCoRangedCombat().getImage());
        }
        if (game.getGamePlayer2().getMarCoSiege() != null) {
            secondPlayerSiegeBoost.setImage(game.getGamePlayer2().getMarCoSiege().getImage());
        }
        firstPlayerTotalBoardStrength.setText(String.valueOf(game.getGamePlayer1().getTotalBoardPower()));
        secondPlayerTotalBoardStrength.setText(String.valueOf(game.getGamePlayer2().getTotalBoardPower()));
        firstPlayerSiege.setText(String.valueOf(game.getGamePlayer1().getSiegeScore()));
        firstPlayerRanged.setText(String.valueOf(game.getGamePlayer1().getRangedCombatScore()));
        firstPlayerCloseCombat.setText(String.valueOf(game.getGamePlayer1().getCloseCombatScore()));
        secondPlayerSiege.setText(String.valueOf(game.getGamePlayer2().getSiegeScore()));
        secondPlayerRanged.setText(String.valueOf(game.getGamePlayer2().getRangedCombatScore()));
        secondPlayerCloseCombat.setText(String.valueOf(game.getGamePlayer2().getCloseCombatScore()));
        setFirstPlayerBoard(game.getGamePlayer1());
        setSecondPlayerBoard(game.getGamePlayer2());
        showTurnInfo(game);
    }

    private void setFirstPlayerBoard(EachPlayerGame game) {
        firstPlayerCloseCombatList.setItems(game.getCloseCombat());
        firstPlayerCloseCombatList.setCellFactory(new CardListCellFactory(74,39));
        firstPlayerRangedList.setItems(game.getRangedCombat());
        firstPlayerRangedList.setCellFactory(new CardListCellFactory(74,39));
        firstPlayerSiegeList.setItems(game.getSiege());
        firstPlayerSiegeList.setCellFactory(new CardListCellFactory(74,39));
    }

    private void setSecondPlayerBoard(EachPlayerGame game) {
        secondPlayerCloseCombatList.setItems(game.getCloseCombat());
        secondPlayerCloseCombatList.setCellFactory(new CardListCellFactory(74,39));
        secondPlayerRangedList.setItems(game.getRangedCombat());
        secondPlayerRangedList.setCellFactory(new CardListCellFactory(74,39));
        secondPlayerSiegeList.setItems(game.getSiege());
        secondPlayerSiegeList.setCellFactory(new CardListCellFactory(74,39));
    }

    public Card vetoCard(int ID){
        return null;
    }

    public void inHandDeck (Matcher matcher){

    } // show hand

    public void inHandDeckOption(Matcher matcher){}

    public void remainingCardsToPlay (){} // show remaining

    public void outOfPlayCards(){} //show discard

    public void cardsInRow (Matcher matcher){}

    public void spellsInPlay (){}

    public void commanderPowerPlay (){}

    public void showCommander (){}

    public void showPlayersInfo (){}

    public void showPlayersLive (){}

    public void showNumberOfCardsInHand (){}

    public void showTurnInfo (Game game){
        EachPlayerGame firstPlayerGame = game.getGamePlayer1();
        EachPlayerGame secondPlayerGame = game.getGamePlayer1();
        if (game.getTurnNo() % 2 != 0) {
            currentPlayerHand.setItems(firstPlayerGame.getHand());
            ObservableList<Card> burnedCards = firstPlayerGame.getBurnedCards();
            if (!burnedCards.isEmpty()) {
                Card lastBurnedCard = burnedCards.get(burnedCards.size() - 1);
                    firstPlayerBurnedCards.setImage(lastBurnedCard.getImage());
            } else firstPlayerBurnedCards.setImage(null);
            if (firstPlayerGame.isLeaderCardUsed()) firstPlayerLeaderActive.setVisible(false);
            secondPlayerPass.setVisible(false);
            if (firstPlayerGame.isPassedTheGame()) firstPlayerPass.setVisible(false);
        } else {
            currentPlayerHand.setItems(secondPlayerGame.getHand());
            ObservableList<Card> burnedCards = secondPlayerGame.getBurnedCards();
            if (!burnedCards.isEmpty()) {
                Card lastBurnedCard = burnedCards.get(burnedCards.size() - 1);
                secondPlayerBurnedCards.setImage(lastBurnedCard.getImage());
            } else secondPlayerBurnedCards.setImage(null);
            if (secondPlayerGame.isLeaderCardUsed()) secondPlayerLeaderActive.setVisible(false);
            firstPlayerPass.setVisible(false);
            if (secondPlayerGame.isPassedTheGame()) secondPlayerPass.setVisible(false);
        }
        currentPlayerHand.setCellFactory(new CardListCellFactory(74, 39));

    }

    public void showTotalScoreOfRow (Matcher matcher){}

    public void passRound (){}

    public void placeCard (Matcher matcher){}

    public void startEndRound (){}

    public boolean isEndRound(){return true;}
    public void Exit (MouseEvent mouseEvent){
        LoginRegisterMenuController.saveUsers();
        System.exit(0);
    }


}
