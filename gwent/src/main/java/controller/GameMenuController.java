package controller;

import enums.Ability;
import enums.CardType;
import enums.Place;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import model.*;
import view.CardListCellFactory;

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
    public StackPane firstPlayerSiegeBoostPane;
    public StackPane secondPlayerSiegeBoostPane;
    public StackPane firstPlayerRangedBoostPane;
    public StackPane secondPlayerRangedBoostPane;
    public StackPane firstPlayerCloseCombatBoostPane;
    public StackPane secondPlayerCloseCombatBoostPane;
    public StackPane weatherCardPane;

    private Card selectedCard;

    @FXML
    public void initialize() {
        updateGameState();
    }

    private void updateGameState() {
        Game game = User.getLoggedInUser().getCurrentGame();
        game.setGamePlayer2(new EachPlayerGame(game.getPlayer2()));
        Faction factionPlayer1  = game.getPlayer1().getFaction();
        Faction factionPlayer2  = game.getPlayer2().getFaction();
        player1FactionName.setText(factionPlayer1.getName());
        player2FactionName.setText(factionPlayer2.getName());
        showTurnInfo(game);
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

    public void showTurnInfo (Game game){
        EachPlayerGame firstPlayerGame = game.getGamePlayer1();
        EachPlayerGame secondPlayerGame = game.getGamePlayer1();
        if (game.getPlayer1().equals(game.getActivePlayer())) {
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

        currentPlayerHand.setOnMouseClicked(event -> {
            resetRowAndPlaceHighlights();
            Card selectedCard = (Card) currentPlayerHand.getSelectionModel().getSelectedItem();
            if (selectedCard != null) {
                this.selectedCard = selectedCard;
                highlightValidRowsAndPlaces(selectedCard);
            }
        });

    }
    private void highlightValidRowsAndPlaces(Card selectedCard) {
        Game game = User.getLoggedInUser().getCurrentGame();

        if (selectedCard.isSpecial()) {
            if (selectedCard.getCardType().equals(CardType.Weather)) {
                weatherCardPane.getStyleClass().add("stack-highlight");
            } else {
                switch (selectedCard.getName()) {
                    case "Scorch":
                        highlightAllStacks();
                        highlightAllRows();
                        break;
                    case "Commander’s horn":
                    case "Mardoeme":
                        if (game.getActivePlayer().equals(game.getPlayer1())) {
                            highlightStacks(firstPlayerCloseCombatBoostPane, firstPlayerRangedBoostPane, firstPlayerSiegeBoostPane);
                        } else {
                            highlightStacks(secondPlayerCloseCombatBoostPane, secondPlayerRangedBoostPane, secondPlayerSiegeBoostPane);
                        }
                        break;
                    case "Decoy":
                        if (game.getActivePlayer().equals(game.getPlayer1())) {
                            highlightIfNotEmpty(firstPlayerCloseCombatList, game.getGamePlayer1().getCloseCombat());
                            highlightIfNotEmpty(firstPlayerRangedList, game.getGamePlayer1().getRangedCombat());
                            highlightIfNotEmpty(firstPlayerSiegeList, game.getGamePlayer1().getSiege());
                        } else {
                            highlightIfNotEmpty(secondPlayerCloseCombatList, game.getGamePlayer2().getCloseCombat());
                            highlightIfNotEmpty(secondPlayerRangedList, game.getGamePlayer2().getRangedCombat());
                            highlightIfNotEmpty(secondPlayerSiegeList, game.getGamePlayer2().getSiege());
                        }
                        break;
                    default:
                        break;
                }
            }
        } else {
            switch (selectedCard.getPosition()) {
                case closeCombat:
                    unitCardHighlight(selectedCard, game, secondPlayerCloseCombatList, firstPlayerCloseCombatList);
                    break;
                case rangedCombat:
                    unitCardHighlight(selectedCard, game, secondPlayerRangedList, firstPlayerRangedList);
                    break;
                case siege:
                    unitCardHighlight(selectedCard, game, secondPlayerSiegeList, firstPlayerSiegeList);
                    break;
                case agile:
                    unitCardHighlight(selectedCard, game, secondPlayerRangedList, firstPlayerRangedList);
                    unitCardHighlight(selectedCard, game, secondPlayerCloseCombatList, firstPlayerCloseCombatList);
                    break;
                default:
                    break;
            }
        }
    }

    private void unitCardHighlight(Card selectedCard, Game game, ListView secondPlayerList, ListView firstPlayerList) {
        if (selectedCard.getAbility().equals(Ability.Spy)) {
            if (game.getActivePlayer().equals(game.getPlayer1())) {
                secondPlayerList.getStyleClass().add("highlight");
            } else {
                firstPlayerList.getStyleClass().add("highlight");
            }
        } else {
            if (game.getActivePlayer().equals(game.getPlayer1())) {
                firstPlayerList.getStyleClass().add("highlight");
            } else {
                secondPlayerList.getStyleClass().add("highlight");
            }
        }
    }

    private void resetRowAndPlaceHighlights() {
        firstPlayerCloseCombatList.getStyleClass().remove("highlight");
        secondPlayerCloseCombatList.getStyleClass().remove("highlight");
        firstPlayerRangedList.getStyleClass().remove("highlight");
        secondPlayerRangedList.getStyleClass().remove("highlight");
        firstPlayerSiegeList.getStyleClass().remove("highlight");
        secondPlayerSiegeList.getStyleClass().remove("highlight");

        weatherCardPane.getStyleClass().remove("stack-highlight");

        firstPlayerSiegeBoostPane.getStyleClass().remove("stack-highlight");
        secondPlayerSiegeBoostPane.getStyleClass().remove("stack-highlight");
        firstPlayerRangedBoostPane.getStyleClass().remove("stack-highlight");
        secondPlayerRangedBoostPane.getStyleClass().remove("stack-highlight");
        firstPlayerCloseCombatBoostPane.getStyleClass().remove("stack-highlight");
        secondPlayerCloseCombatBoostPane.getStyleClass().remove("stack-highlight");
    }

    private void highlightAllStacks() {
        firstPlayerSiegeBoostPane.getStyleClass().add("stack-highlight");
        firstPlayerRangedBoostPane.getStyleClass().add("stack-highlight");
        firstPlayerCloseCombatBoostPane.getStyleClass().add("stack-highlight");
        secondPlayerSiegeBoostPane.getStyleClass().add("stack-highlight");
        secondPlayerRangedBoostPane.getStyleClass().add("stack-highlight");
        secondPlayerCloseCombatBoostPane.getStyleClass().add("stack-highlight");
    }

    private void highlightStacks(StackPane... stacks) {
        for (StackPane stack : stacks) {
            stack.getStyleClass().add("stack-highlight");
        }
    }

    private void highlightIfNotEmpty(ListView listView, ObservableList<Card> list) {
        if (!list.isEmpty()) {
            listView.getStyleClass().add("highlight");
        }
    }


    private void highlightAllRows() {
        firstPlayerSiegeList.getStyleClass().add("highlight");
        firstPlayerRangedList.getStyleClass().add("highlight");
        firstPlayerCloseCombatList.getStyleClass().add("highlight");
        secondPlayerSiegeList.getStyleClass().add("highlight");
        secondPlayerRangedList.getStyleClass().add("highlight");
        secondPlayerCloseCombatList.getStyleClass().add("highlight");
    }

    public void Exit (MouseEvent mouseEvent){
        LoginRegisterMenuController.saveUsers();
        System.exit(0);
    }

    private void handleListViewClick(ListView<?> listView, Card selectedCard) {
        if (isHighlightedListView(listView)) {
            Function function = new Function();
            function.run(this, listView, selectedCard);
            resetRowAndPlaceHighlights();
        }
    }

    private void handleImageViewClick(ImageView imageView, Card selectedCard) {
        if (isHighlightedImageView(imageView)) {
            Function function = new Function();
            function.run(this, imageView, selectedCard);
            resetRowAndPlaceHighlights();
        }
    }

    private boolean isHighlightedListView(ListView<?> listView) {
        return listView.getStyleClass().contains("highlight");
    }

    private boolean isHighlightedImageView(ImageView imageView) {
        return imageView.getStyleClass().contains("highlight");
    }

    @FXML
    public void currentPlayerHandClicked(MouseEvent event) {
        ListView<?> listView = currentPlayerHand;
        Card selectedCard = this.selectedCard;
        System.out.println("currentPlayerHandClicked: " + selectedCard.getName());
        handleListViewClick(listView, selectedCard);
    }

    @FXML
    public void firstPlayerCloseCombatListClicked(MouseEvent event) {
        ListView<?> listView = firstPlayerCloseCombatList;
        Card selectedCard = this.selectedCard;
        System.out.println("firstPlayerCloseCombatListClicked: " + selectedCard.getName());
        handleListViewClick(listView, selectedCard);
    }

    @FXML
    public void firstPlayerRangedListClicked(MouseEvent event) {
        ListView<?> listView = firstPlayerRangedList;
        Card selectedCard = this.selectedCard;
        System.out.println("firstPlayerRangedListClicked: " + selectedCard.getName());
        handleListViewClick(listView, selectedCard);
    }

    @FXML
    public void firstPlayerSiegeListClicked(MouseEvent event) {
        ListView<?> listView = firstPlayerSiegeList;
        Card selectedCard = this.selectedCard;
        System.out.println("firstPlayerSiegeListClicked: " + selectedCard.getName());
        handleListViewClick(listView, selectedCard);
    }

    @FXML
    public void secondPlayerCloseCombatListClicked(MouseEvent event) {
        ListView<?> listView = secondPlayerCloseCombatList;
        Card selectedCard = this.selectedCard;
        System.out.println("secondPlayerCloseCombatListClicked: " + selectedCard.getName());
        handleListViewClick(listView, selectedCard);
    }

    @FXML
    public void secondPlayerRangedListClicked(MouseEvent event) {
        ListView<?> listView = secondPlayerRangedList;
        Card selectedCard = this.selectedCard;
        System.out.println("secondPlayerRangedListClicked: " + selectedCard.getName());
        handleListViewClick(listView, selectedCard);
    }

    @FXML
    public void secondPlayerSiegeListClicked(MouseEvent event) {
        ListView<?> listView = secondPlayerSiegeList;
        Card selectedCard = this.selectedCard;
        System.out.println("secondPlayerSiegeListClicked: " + selectedCard.getName());
        handleListViewClick(listView, selectedCard);
    }
    @FXML
    public void weatherCardClicked(MouseEvent event) {
        ImageView imageView = weatherCard;
        System.out.println("weatherCardClicked: " + selectedCard.getName());
        if (isHighlightedImageView(weatherCard)) handleImageViewClick(imageView, selectedCard);
        else if (weatherCard != null) showWeatherCardInfo();
    }

    @FXML
    public void firstPlayerSiegeBoostClicked(MouseEvent event) {
        ImageView imageView = firstPlayerSiegeBoost;
        System.out.println("firstPlayerSiegeBoostClicked: " + selectedCard.getName());
        handleImageViewClick(imageView, selectedCard);
    }

    @FXML
    public void firstPlayerRangedBoostClicked(MouseEvent event) {
        ImageView imageView = firstPlayerRangedBoost;
        System.out.println("firstPlayerRangedBoostClicked: " + selectedCard.getName());
        handleImageViewClick(imageView, selectedCard);
    }

    @FXML
    public void firstPlayerCloseCombatBoostClicked(MouseEvent event) {
        ImageView imageView = firstPlayerCloseCombatBoost;
        System.out.println("firstPlayerCloseCombatBoostClicked: " + selectedCard.getName());
        handleImageViewClick(imageView, selectedCard);
    }

    @FXML
    public void secondPlayerCloseCombatBoostClicked(MouseEvent event) {
        ImageView imageView = secondPlayerCloseCombatBoost;
        System.out.println("secondPlayerCloseCombatBoostClicked: " + selectedCard.getName());
        handleImageViewClick(imageView, selectedCard);
    }

    @FXML
    public void secondPlayerRangedBoostClicked(MouseEvent event) {
        ImageView imageView = secondPlayerRangedBoost;
        System.out.println("secondPlayerRangedBoostClicked: " + selectedCard.getName());
        handleImageViewClick(imageView, selectedCard);
    }

    @FXML
    public void secondPlayerSiegeBoostClicked(MouseEvent event) {
        ImageView imageView = secondPlayerSiegeBoost;
        System.out.println("secondPlayerSiegeBoostClicked: " + selectedCard.getName());
        handleImageViewClick(imageView, selectedCard);
    }

    @FXML
    public void firstPlayerPassClicked(MouseEvent mouseEvent) {
        Game game = User.getLoggedInUser().getCurrentGame();
        game.getGamePlayer1().setPassedTheGame(true);
        game.setTurnNo(game.getTurnNo() + 1);
        game.setActivePlayer(game.getPlayer2());
        isRoundEnd();
    }

    @FXML
    public void secondPlayerPassClicked(MouseEvent mouseEvent) {
        Game game = User.getLoggedInUser().getCurrentGame();
        game.getGamePlayer2().setPassedTheGame(true);
        game.setTurnNo(game.getTurnNo() + 1);
        game.setActivePlayer(game.getPlayer1());
        isRoundEnd();
    }

    private void isRoundEnd() {
        isGameEnd();
    }

    private void endOfRound() {

    }

    private void isGameEnd() {
    }

    private void endOfGame() {

    }

    public void secondPlayerLeaderCardClicked(MouseEvent mouseEvent) {
    }

    public void firstPlayerLeaderCardClicked(MouseEvent mouseEvent) {
    }

    private void showWeatherCardInfo() {
    }

}
