package controller;

import enums.Ability;
import enums.CardType;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.*;
import view.CardListCellFactory;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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
        firstPlayerCards.setImage(factionPlayer1.getImage());
        secondPlayerCards.setImage(factionPlayer2.getImage());
        updateGameState(game);
    }

    private void updateGameState(Game game) {
        showTurnInfo(game);
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
            if (!selectedCard.equals(Card.getCardByName("Decoy"))) {
                Function function = new Function();
                function.run(this, listView, selectedCard);
                resetRowAndPlaceHighlights();
            } else {
                List<Card> selectableCards = listView.getItems().stream()
                        .filter(card -> card instanceof Card)
                        .map(card -> (Card) card)
                        .collect(Collectors.toList());
                ListView<Card> secondaryListView = new ListView<>();
                secondaryListView.getItems().addAll(selectableCards);
                secondaryListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

                Stage secondaryStage = new Stage();
                secondaryStage.setTitle("Select a Card");
                secondaryStage.setScene(new Scene(secondaryListView));
                secondaryStage.initOwner(listView.getScene().getWindow());
                secondaryStage.show();

                secondaryListView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
                    if (newSelection != null) {
                        Game game = User.getLoggedInUser().getCurrentGame();
                        System.out.println("Selected card from secondary list: " + newSelection);
                        switch (listView.getId()) {
                            case "firstPlayerCloseCombatList" :
                                ObservableList list = game.getGamePlayer1().getCloseCombat();
                                list.remove(selectedCard);
                                game.getGamePlayer1().setCloseCombat(list);
                                list = game.getGamePlayer1().getHand();
                                list.add(selectedCard);
                                game.getGamePlayer1().setHand(list);
                                break;
                            case "firstPlayerRangedList" :
                                list = game.getGamePlayer1().getRangedCombat();
                                list.remove(selectedCard);
                                game.getGamePlayer1().setRangedCombat(list);
                                list = game.getGamePlayer1().getHand();
                                list.add(selectedCard);
                                game.getGamePlayer1().setHand(list);
                                break;
                            case "firstPlayerSiegeList" :
                                list = game.getGamePlayer1().getSiege();
                                list.remove(selectedCard);
                                game.getGamePlayer1().setSiege(list);
                                list = game.getGamePlayer1().getHand();
                                list.add(selectedCard);
                                game.getGamePlayer1().setHand(list);
                                break;
                            case "secondPlayerCloseCombatList" :
                                list = game.getGamePlayer2().getCloseCombat();
                                list.remove(selectedCard);
                                game.getGamePlayer2().setCloseCombat(list);
                                list = game.getGamePlayer2().getHand();
                                list.add(selectedCard);
                                game.getGamePlayer2().setHand(list);
                                break;
                            case "secondPlayerRangedList" :
                                list = game.getGamePlayer2().getRangedCombat();
                                list.remove(selectedCard);
                                game.getGamePlayer2().setRangedCombat(list);
                                list = game.getGamePlayer2().getHand();
                                list.add(selectedCard);
                                game.getGamePlayer2().setHand(list);
                                break;
                            case "secondPlayerSiegeList" :
                                list = game.getGamePlayer2().getSiege();
                                list.remove(selectedCard);
                                game.getGamePlayer2().setSiege(list);
                                list = game.getGamePlayer2().getHand();
                                list.add(selectedCard);
                                game.getGamePlayer2().setHand(list);
                                break;

                        }
                        secondaryStage.close();
                    }
                });
            }
        }
        changeTurn();
    }

    private void handleImageViewClick(ImageView imageView, Card selectedCard) {
        if (isHighlightedImageView(imageView)) {
            Function function = new Function();
            function.run(this, imageView, selectedCard);
        }
        resetRowAndPlaceHighlights();
        changeTurn();
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
        changeTurn();
    }

    @FXML
    public void secondPlayerPassClicked(MouseEvent mouseEvent) {
        Game game = User.getLoggedInUser().getCurrentGame();
        game.getGamePlayer2().setPassedTheGame(true);
        game.setTurnNo(game.getTurnNo() + 1);
        game.setActivePlayer(game.getPlayer1());
        changeTurn();
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

    private void changeTurn() {
        calculateScoresWeather();
        Game game = User.getLoggedInUser().getCurrentGame();
        isRoundEnd();
        game.setTurnNo(game.getTurnNo() + 1);
        if (game.getActivePlayer().equals(game.getPlayer1())) game.setActivePlayer(game.getPlayer2());
        else game.setActivePlayer(game.getPlayer1());
    }


    private void updateScoresByWeatherCard(ObservableList<Card> cards, HashMap<Card, Integer> cardsScore){
        for (Card card : cards) {
            if (!card.isHero() && (card.getPower() != 0)) {
                cardsScore.put(card, 1);
            } else {
                cardsScore.put(card, card.getPower());
            }
        }
    }

    private void calculateScoresWeather() {
        Game game = User.getLoggedInUser().getCurrentGame();
        EachPlayerGame firstPlayerGame = game.getGamePlayer1();
        EachPlayerGame secondPlayerGame = game.getGamePlayer2();

        switch (game.getWeatherCard().getName()) {
            case "Biting Frost":
                updateScoresByWeatherCard(firstPlayerGame.getCloseCombat(), firstPlayerGame.getCloseCombatScores());
                updateScoresByWeatherCard(secondPlayerGame.getCloseCombat(), secondPlayerGame.getCloseCombatScores());
                break;

            case "Impenetrable Fog":
                updateScoresByWeatherCard(firstPlayerGame.getRangedCombat(), firstPlayerGame.getRangedCombatScores());
                updateScoresByWeatherCard(secondPlayerGame.getRangedCombat(), secondPlayerGame.getRangedCombatScores());
                break;

            case "Torrential Rain":
                updateScoresByWeatherCard(firstPlayerGame.getSiege(), firstPlayerGame.getSiegeScores());
                updateScoresByWeatherCard(secondPlayerGame.getSiege(), secondPlayerGame.getSiegeScores());
                break;

            case "Skellige Storm":
                updateScoresByWeatherCard(firstPlayerGame.getRangedCombat(), firstPlayerGame.getRangedCombatScores());
                updateScoresByWeatherCard(secondPlayerGame.getRangedCombat(), secondPlayerGame.getRangedCombatScores());
                updateScoresByWeatherCard(firstPlayerGame.getSiege(), firstPlayerGame.getSiegeScores());
                updateScoresByWeatherCard(secondPlayerGame.getSiege(), secondPlayerGame.getSiegeScores());
                break;
            default:
                break;
        }
    }
}
