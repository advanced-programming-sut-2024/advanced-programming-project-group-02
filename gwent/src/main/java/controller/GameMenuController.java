package controller;

import enums.Ability;
import enums.CardType;
import enums.Statement;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.*;
import view.CardListCellFactory;
import view.EndOfTheGame;
import view.GameMenu;

import java.util.*;
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
    public  ImageView secondPlayerLeaderActive;
    @FXML
    public  ImageView firstPlayerLeaderActive;
    @FXML
    public Label firstPlayerCountOfCards;
    @FXML
    public Label secondPlayerCountOfCards;
    @FXML
    public StackPane firstPlayerSiegeBoostPane;
    @FXML
    public StackPane secondPlayerSiegeBoostPane;
    @FXML
    public StackPane firstPlayerRangedBoostPane;
    @FXML
    public StackPane secondPlayerRangedBoostPane;
    @FXML
    public StackPane firstPlayerCloseCombatBoostPane;
    @FXML
    public StackPane secondPlayerCloseCombatBoostPane;
    @FXML
    public StackPane weatherCardPane;
    public Label firstPlayerTotalDiscard;
    public Label secondPlayerTotalDiscard;
    public ImageView secondPlayerSiegeWeather;
    public ImageView secondPlayerRangedWeather;
    public ImageView secondPlayerCloseCombatLWeather;
    public ImageView firstPlayerCloseCombatWeather;
    public ImageView firstPlayerRangedWeather;
    public ImageView firstPlayerSiegeWeather;
    public Rectangle turnInfo2;
    public Rectangle turnInfo1;


    private Popup leaderCard1Popup;
    private boolean isPopupShowing1 = false;

    private Popup leaderCard2Popup;
    private boolean isPopupShowing2 = false;

    private Card selectedCard;

    private Random random = new Random();


    @FXML
    public void initialize() {

        Game game = User.getLoggedInUser().getCurrentGame();
        game.setGamePlayer2(new EachPlayerGame(game.getPlayer2()));
        Faction factionPlayer1 = game.getPlayer1().getFaction();
        Faction factionPlayer2 = game.getPlayer2().getFaction();

        player1FactionName.setText(factionPlayer1.getName());
        player2FactionName.setText(factionPlayer2.getName());
        firstPlayerFactionImage.setImage(factionPlayer1.getImage());
        secondPlayerFactionImage.setImage(factionPlayer2.getImage());
        firstPlayerLeaderCard.setImage(game.getPlayer1().getLeaderCard().getImage());
        secondPlayerLeaderCard.setImage(game.getPlayer2().getLeaderCard().getImage());
        firstPlayerCards.setImage(factionPlayer1.getImage());
        secondPlayerCards.setImage(factionPlayer2.getImage());
        if (game.getActivePlayer().equals(game.getPlayer1())) {
            firstPlayerLeaderActive.setVisible(true);
            secondPlayerLeaderActive.setVisible(false);
        } else {
            secondPlayerLeaderActive.setVisible(true);
            firstPlayerLeaderActive.setVisible(false);
        }
        firstPlayerCrystal1.setVisible(true);
        secondPlayerCrystal1.setVisible(true);
        firstPlayerCrystal2.setVisible(true);
        secondPlayerCrystal2.setVisible(true);

        secondPlayerSiegeWeather.setVisible(false);
        secondPlayerRangedWeather.setVisible(false);
        secondPlayerCloseCombatLWeather.setVisible(false);
        firstPlayerSiegeWeather.setVisible(false);
        firstPlayerRangedWeather.setVisible(false);
        firstPlayerCloseCombatWeather.setVisible(false);

        if (factionPlayer1.equals(Faction.getFactionByName("Scoia'tael"))) {
            if (factionPlayer2.equals(Faction.getFactionByName("Scoia'tael"))) {
                boolean random = this.random.nextBoolean();
                if (random) game.setActivePlayer(game.getPlayer1());
                else game.setActivePlayer(game.getPlayer2());
            } else {
                game.setActivePlayer(game.getPlayer1());
            }
        } else {
            if (factionPlayer2.equals(Faction.getFactionByName("Scoia'tael"))) {
                game.setActivePlayer(game.getPlayer2());
            } else {
                boolean random = this.random.nextBoolean();
                if (random) game.setActivePlayer(game.getPlayer1());
                else game.setActivePlayer(game.getPlayer2());
            }
        }
        updateGameState(game);
    }

    public void updateGameState(Game game) {
        resetRowAndPlaceHighlights();
        showTurnInfo(game);
        ObservableList<Card> burnedCards = game.getGamePlayer1().getBurnedCards();
        if (burnedCards != null && !burnedCards.isEmpty()) {
            Card lastBurnedCard = burnedCards.get(burnedCards.size() - 1);
            firstPlayerBurnedCards.setImage(lastBurnedCard.getImage());
        } else {
            firstPlayerBurnedCards.setImage(null);
        }
        burnedCards = game.getGamePlayer2().getBurnedCards();
        if (!burnedCards.isEmpty()) {
            Card lastBurnedCard = burnedCards.get(burnedCards.size() - 1);
            secondPlayerBurnedCards.setImage(lastBurnedCard.getImage());
        } else {
            secondPlayerBurnedCards.setImage(null);
        }
        firstPlayerTotalDiscard.setText(String.valueOf(game.getGamePlayer1().getBurnedCards().size()));
        secondPlayerTotalDiscard.setText(String.valueOf(game.getGamePlayer2().getBurnedCards().size()));
        firstPlayerCountOfCards.setText(String.valueOf(game.getGamePlayer1().getNumberOfCardsInDeck()));
        secondPlayerCountOfCards.setText(String.valueOf(game.getGamePlayer2().getNumberOfCardsInDeck()));
        if (game.getGamePlayer1().getCrystals() == 1) firstPlayerCrystal2.setVisible(false);
        if (game.getGamePlayer2().getCrystals() == 1) secondPlayerCrystal2.setVisible(false);
        firstPlayerRemainingCards.setText(String.valueOf(game.getGamePlayer1().getHand().size()));
        secondPlayerRemainingCards.setText(String.valueOf(game.getGamePlayer2().getHand().size()));
        if (game.getWeatherCard() != null) {
            weatherCard.setImage(game.getWeatherCard().getImage());
        } else {
            weatherCard.setImage(null);
        }

        if (game.getGamePlayer1().getMarCoCloseCombat() != null) {
            firstPlayerCloseCombatBoost.setImage(game.getGamePlayer1().getMarCoCloseCombat().getImage());
        } else {
            firstPlayerCloseCombatBoost.setImage(null);
        }

        if (game.getGamePlayer1().getMarCoRangedCombat() != null) {
            firstPlayerRangedBoost.setImage(game.getGamePlayer1().getMarCoRangedCombat().getImage());
        } else {
            firstPlayerRangedBoost.setImage(null);
        }

        if (game.getGamePlayer1().getMarCoSiege() != null) {
            firstPlayerSiegeBoost.setImage(game.getGamePlayer1().getMarCoSiege().getImage());
        } else {
            firstPlayerSiegeBoost.setImage(null);
        }

        if (game.getGamePlayer2().getMarCoCloseCombat() != null) {
            secondPlayerCloseCombatBoost.setImage(game.getGamePlayer2().getMarCoCloseCombat().getImage());
        } else {
            secondPlayerCloseCombatBoost.setImage(null);
        }

        if (game.getGamePlayer2().getMarCoRangedCombat() != null) {
            secondPlayerRangedBoost.setImage(game.getGamePlayer2().getMarCoRangedCombat().getImage());
        } else {
            secondPlayerRangedBoost.setImage(null);
        }

        if (game.getGamePlayer2().getMarCoSiege() != null) {
            secondPlayerSiegeBoost.setImage(game.getGamePlayer2().getMarCoSiege().getImage());
        } else {
            secondPlayerSiegeBoost.setImage(null);
        }

        if (game.getWeatherCard() == null || game.getWeatherCard().equals(Card.getCardByName("Clear Weather"))) {
            firstPlayerTotalBoardStrength.setText(String.valueOf(game.getGamePlayer1().getTotalBoardPower()));
            secondPlayerTotalBoardStrength.setText(String.valueOf(game.getGamePlayer2().getTotalBoardPower()));
            firstPlayerSiege.setText(String.valueOf(game.getGamePlayer1().getSiegeScore()));
            firstPlayerRanged.setText(String.valueOf(game.getGamePlayer1().getRangedCombatScore()));
            firstPlayerCloseCombat.setText(String.valueOf(game.getGamePlayer1().getCloseCombatScore()));
            secondPlayerSiege.setText(String.valueOf(game.getGamePlayer2().getSiegeScore()));
            secondPlayerRanged.setText(String.valueOf(game.getGamePlayer2().getRangedCombatScore()));
            secondPlayerCloseCombat.setText(String.valueOf(game.getGamePlayer2().getCloseCombatScore()));
        } else {
            switch (game.getWeatherCard().getName()) {
                case "Biting Frost":
                    firstPlayerTotalBoardStrength.setText(String.valueOf(game.getGamePlayer1().getSiegeScore() +
                            game.getGamePlayer1().getRangedCombatScore() + game.getGamePlayer1().getCloseCombatScoreWithWeather()));
                    secondPlayerTotalBoardStrength.setText(String.valueOf(game.getGamePlayer2().getSiegeScore() +
                            game.getGamePlayer2().getRangedCombatScore() + game.getGamePlayer2().getCloseCombatScoreWithWeather()));
                    firstPlayerSiege.setText(String.valueOf(game.getGamePlayer1().getSiegeScore()));
                    firstPlayerRanged.setText(String.valueOf(game.getGamePlayer1().getRangedCombatScore()));
                    firstPlayerCloseCombat.setText(String.valueOf(game.getGamePlayer1().getCloseCombatScoreWithWeather()));
                    secondPlayerSiege.setText(String.valueOf(game.getGamePlayer2().getSiegeScore()));
                    secondPlayerRanged.setText(String.valueOf(game.getGamePlayer2().getRangedCombatScore()));
                    secondPlayerCloseCombat.setText(String.valueOf(game.getGamePlayer2().getCloseCombatScoreWithWeather()));

                    break;
                case "Impenetrable Fog":
                    firstPlayerTotalBoardStrength.setText(String.valueOf(game.getGamePlayer1().getSiegeScore() +
                            game.getGamePlayer1().getRangedCombatScoreWithWeather() + game.getGamePlayer1().getCloseCombatScore()));
                    secondPlayerTotalBoardStrength.setText(String.valueOf(game.getGamePlayer2().getSiegeScore() +
                            game.getGamePlayer2().getRangedCombatScoreWithWeather() + game.getGamePlayer2().getCloseCombatScore()));
                    firstPlayerSiege.setText(String.valueOf(game.getGamePlayer1().getSiegeScore()));
                    firstPlayerRanged.setText(String.valueOf(game.getGamePlayer1().getRangedCombatScoreWithWeather()));
                    firstPlayerCloseCombat.setText(String.valueOf(game.getGamePlayer1().getCloseCombatScore()));
                    secondPlayerSiege.setText(String.valueOf(game.getGamePlayer2().getSiegeScore()));
                    secondPlayerRanged.setText(String.valueOf(game.getGamePlayer2().getRangedCombatScoreWithWeather()));
                    secondPlayerCloseCombat.setText(String.valueOf(game.getGamePlayer2().getCloseCombatScore()));

                    break;
                case "Torrential Rain":
                    firstPlayerTotalBoardStrength.setText(String.valueOf(game.getGamePlayer1().getSiegeScoreWithWeather() +
                            game.getGamePlayer1().getRangedCombatScore() + game.getGamePlayer1().getCloseCombatScore()));
                    secondPlayerTotalBoardStrength.setText(String.valueOf(game.getGamePlayer2().getSiegeScoreWithWeather() +
                            game.getGamePlayer2().getRangedCombatScore() + game.getGamePlayer2().getCloseCombatScore()));
                    firstPlayerSiege.setText(String.valueOf(game.getGamePlayer1().getSiegeScoreWithWeather()));
                    firstPlayerRanged.setText(String.valueOf(game.getGamePlayer1().getRangedCombatScore()));
                    firstPlayerCloseCombat.setText(String.valueOf(game.getGamePlayer1().getCloseCombatScore()));
                    secondPlayerSiege.setText(String.valueOf(game.getGamePlayer2().getSiegeScoreWithWeather()));
                    secondPlayerRanged.setText(String.valueOf(game.getGamePlayer2().getRangedCombatScore()));
                    secondPlayerCloseCombat.setText(String.valueOf(game.getGamePlayer2().getCloseCombatScore()));

                    break;
                case "Skellige Storm":
                    firstPlayerTotalBoardStrength.setText(String.valueOf(game.getGamePlayer1().getSiegeScoreWithWeather() +
                            game.getGamePlayer1().getRangedCombatScoreWithWeather() + game.getGamePlayer1().getCloseCombatScore()));
                    secondPlayerTotalBoardStrength.setText(String.valueOf(game.getGamePlayer2().getSiegeScoreWithWeather() +
                            game.getGamePlayer2().getRangedCombatScoreWithWeather() + game.getGamePlayer2().getCloseCombatScore()));
                    firstPlayerSiege.setText(String.valueOf(game.getGamePlayer1().getSiegeScoreWithWeather()));
                    firstPlayerRanged.setText(String.valueOf(game.getGamePlayer1().getRangedCombatScoreWithWeather()));
                    firstPlayerCloseCombat.setText(String.valueOf(game.getGamePlayer1().getCloseCombatScore()));
                    secondPlayerSiege.setText(String.valueOf(game.getGamePlayer2().getSiegeScoreWithWeather()));
                    secondPlayerRanged.setText(String.valueOf(game.getGamePlayer2().getRangedCombatScoreWithWeather()));
                    secondPlayerCloseCombat.setText(String.valueOf(game.getGamePlayer2().getCloseCombatScore()));

                    break;
            }
        }
        setFirstPlayerBoard(game.getGamePlayer1());
        setSecondPlayerBoard(game.getGamePlayer2());
    }

    private void setFirstPlayerBoard(EachPlayerGame game) {
        firstPlayerCloseCombatList.setItems(game.getCloseCombat());
        firstPlayerCloseCombatList.setCellFactory(new CardListCellFactory(74, 39));
        firstPlayerRangedList.setItems(game.getRangedCombat());
        firstPlayerRangedList.setCellFactory(new CardListCellFactory(74, 39));
        firstPlayerSiegeList.setItems(game.getSiege());
        firstPlayerSiegeList.setCellFactory(new CardListCellFactory(74, 39));
    }

    private void setSecondPlayerBoard(EachPlayerGame game) {
        secondPlayerCloseCombatList.setItems(game.getCloseCombat());
        secondPlayerCloseCombatList.setCellFactory(new CardListCellFactory(74, 39));
        secondPlayerRangedList.setItems(game.getRangedCombat());
        secondPlayerRangedList.setCellFactory(new CardListCellFactory(74, 39));
        secondPlayerSiegeList.setItems(game.getSiege());
        secondPlayerSiegeList.setCellFactory(new CardListCellFactory(74, 39));
    }

    public void showTurnInfo(Game game) {
        EachPlayerGame firstPlayerGame = game.getGamePlayer1();
        EachPlayerGame secondPlayerGame = game.getGamePlayer2();
        if (game.getPlayer1().equals(game.getActivePlayer())) {
            currentPlayerHand.setItems(firstPlayerGame.getSortedHand());
            if (firstPlayerGame.isLeaderCardUsed()) firstPlayerLeaderActive.setVisible(false);
            else firstPlayerLeaderActive.setVisible(true);
            secondPlayerLeaderActive.setVisible(false);
            secondPlayerPass.setVisible(false);
            firstPlayerPass.setVisible(!firstPlayerGame.isPassedTheGame());
            turnInfo1.setVisible(!firstPlayerGame.isPassedTheGame());
            turnInfo2.setVisible(false);
        } else {
            currentPlayerHand.setItems(secondPlayerGame.getSortedHand());
            if (secondPlayerGame.isLeaderCardUsed()) secondPlayerLeaderActive.setVisible(false);
            else secondPlayerLeaderActive.setVisible(true);
            firstPlayerLeaderActive.setVisible(false);
            firstPlayerPass.setVisible(false);
            secondPlayerPass.setVisible(!secondPlayerGame.isPassedTheGame());
            turnInfo1.setVisible(false);
            turnInfo2.setVisible(!secondPlayerGame.isPassedTheGame());
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
                    case "Commander's Horn":
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
        if (selectedCard.getAbility() != null) {
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

    public void Exit(MouseEvent mouseEvent) {
        LoginRegisterMenuController.saveUsers();
        System.exit(0);
    }

    private void handleListViewClick(ListView<?> listView, Card selectedCard) {
        if ((selectedCard == null)) return;
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

                secondaryListView.setCellFactory(new CardListCellFactory(100, 75));

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
                            case "firstPlayerCloseCombatList":
                                EachPlayerGame PlayerGame = game.getGamePlayer1();
                                ObservableList<Card> List = PlayerGame.getCloseCombat();
                                HashMap<Card, List<Integer>> Scores = PlayerGame.getCloseCombatScores();

                                List.remove(newSelection);
                                List.add(selectedCard);

                                List<Integer> newSelectionScores = Scores.get(newSelection);
                                if (newSelectionScores != null && newSelectionScores.size() > 1) {
                                    newSelectionScores.remove(Collections.min(newSelectionScores));
                                    Scores.put(newSelection, newSelectionScores);
                                } else {
                                    Scores.remove(newSelection);
                                }

                                Scores.computeIfAbsent(selectedCard, k -> new ArrayList<>()).add(selectedCard.getPower());

                                PlayerGame.setCloseCombat(List);
                                PlayerGame.setCloseCombatScores(Scores);

                                ObservableList<Card> handList = PlayerGame.getHand();
                                handList.add(newSelection);
                                PlayerGame.setHand(handList);
                                break;

                            case "firstPlayerRangedList":
                                PlayerGame = game.getGamePlayer1();
                                List = PlayerGame.getRangedCombat();
                                Scores = PlayerGame.getRangedCombatScores();

                                List.remove(newSelection);
                                List.add(selectedCard);

                                newSelectionScores = Scores.get(newSelection);
                                if (newSelectionScores != null && newSelectionScores.size() > 1) {
                                    newSelectionScores.remove(Collections.min(newSelectionScores));
                                    Scores.put(newSelection, newSelectionScores);
                                } else {
                                    Scores.remove(newSelection);
                                }

                                Scores.computeIfAbsent(selectedCard, k -> new ArrayList<>()).add(selectedCard.getPower());

                                PlayerGame.setRangedCombat(List);
                                PlayerGame.setRangedCombatScores(Scores);

                                handList = PlayerGame.getHand();
                                handList.add(newSelection);
                                PlayerGame.setHand(handList);
                                break;

                            case "firstPlayerSiegeList":
                                PlayerGame = game.getGamePlayer1();
                                List = PlayerGame.getSiege();
                                Scores = PlayerGame.getSiegeScores();

                                List.remove(newSelection);
                                List.add(selectedCard);

                                newSelectionScores = Scores.get(newSelection);
                                if (newSelectionScores != null && newSelectionScores.size() > 1) {
                                    newSelectionScores.remove(Collections.min(newSelectionScores));
                                    Scores.put(newSelection, newSelectionScores);
                                } else {
                                    Scores.remove(newSelection);
                                }

                                Scores.computeIfAbsent(selectedCard, k -> new ArrayList<>()).add(selectedCard.getPower());

                                PlayerGame.setSiege(List);
                                PlayerGame.setSiegeScores(Scores);

                                handList = PlayerGame.getHand();
                                handList.add(newSelection);
                                PlayerGame.setHand(handList);
                                break;

                            case "secondPlayerCloseCombatList":
                                PlayerGame = game.getGamePlayer2();
                                List = PlayerGame.getCloseCombat();
                                Scores = PlayerGame.getCloseCombatScores();

                                List.remove(newSelection);
                                List.add(selectedCard);

                                newSelectionScores = Scores.get(newSelection);
                                if (newSelectionScores != null && newSelectionScores.size() > 1) {
                                    newSelectionScores.remove(Collections.min(newSelectionScores));
                                    Scores.put(newSelection, newSelectionScores);
                                } else {
                                    Scores.remove(newSelection);
                                }

                                Scores.computeIfAbsent(selectedCard, k -> new ArrayList<>()).add(selectedCard.getPower());

                                PlayerGame.setCloseCombat(List);
                                PlayerGame.setCloseCombatScores(Scores);

                                handList = PlayerGame.getHand();
                                handList.add(newSelection);
                                PlayerGame.setHand(handList);
                                break;

                            case "secondPlayerRangedList":
                                PlayerGame = game.getGamePlayer2();
                                List = PlayerGame.getRangedCombat();
                                Scores = PlayerGame.getRangedCombatScores();

                                List.remove(newSelection);
                                List.add(selectedCard);

                                newSelectionScores = Scores.get(newSelection);
                                if (newSelectionScores != null && newSelectionScores.size() > 1) {
                                    newSelectionScores.remove(Collections.min(newSelectionScores));
                                    Scores.put(newSelection, newSelectionScores);
                                } else {
                                    Scores.remove(newSelection);
                                }

                                Scores.computeIfAbsent(selectedCard, k -> new ArrayList<>()).add(selectedCard.getPower());

                                PlayerGame.setRangedCombat(List);
                                PlayerGame.setRangedCombatScores(Scores);

                                handList = PlayerGame.getHand();
                                handList.add(newSelection);
                                PlayerGame.setHand(handList);
                                break;

                            case "secondPlayerSiegeList":
                                PlayerGame = game.getGamePlayer2();
                                List = PlayerGame.getSiege();
                                Scores = PlayerGame.getSiegeScores();

                                List.remove(newSelection);
                                List.add(selectedCard);

                                newSelectionScores = Scores.get(newSelection);
                                if (newSelectionScores != null && newSelectionScores.size() > 1) {
                                    newSelectionScores.remove(Collections.min(newSelectionScores));
                                    Scores.put(newSelection, newSelectionScores);
                                } else {
                                    Scores.remove(newSelection);
                                }

                                Scores.computeIfAbsent(selectedCard, k -> new ArrayList<>()).add(selectedCard.getPower());

                                PlayerGame.setSiege(List);
                                PlayerGame.setSiegeScores(Scores);

                                handList = PlayerGame.getHand();
                                handList.add(newSelection);
                                PlayerGame.setHand(handList);
                                break;
                        }
                        secondaryStage.close();
                    }
                });
            }
            changeTurn();
        }
    }

    private void handleImageViewClick(ImageView imageView, Card selectedCard) {
        if (isHighlightedImageView(imageView)) {
            Function function = new Function();
            function.run(this, imageView, selectedCard);
        }
        updateGameState(User.getLoggedInUser().getCurrentGame());
        changeTurn();
    }

    private boolean isHighlightedListView(ListView<?> listView) {
        return listView.getStyleClass().contains("highlight");
    }

    private boolean isHighlightedImageView(ImageView imageView) {
        switch (imageView.getId()) {
            case "weatherCard":
                return weatherCardPane.getStyleClass().contains("stack-highlight");
            case "secondPlayerSiegeBoost":
                return secondPlayerSiegeBoostPane.getStyleClass().contains("stack-highlight");
            case "secondPlayerRangedBoost":
                return secondPlayerRangedBoostPane.getStyleClass().contains("stack-highlight");
            case "secondPlayerCloseCombatBoost":
                return secondPlayerCloseCombatBoostPane.getStyleClass().contains("stack-highlight");
            case "firstPlayerCloseCombatBoost":
                return firstPlayerCloseCombatBoostPane.getStyleClass().contains("stack-highlight");
            case "firstPlayerRangedBoost":
                return firstPlayerRangedBoostPane.getStyleClass().contains("stack-highlight");
            case "firstPlayerSiegeBoost":
                return firstPlayerSiegeBoostPane.getStyleClass().contains("stack-highlight");
            default:
                return false;
        }
    }

    @FXML
    public void currentPlayerHandClicked(MouseEvent event) {
        ListView<?> listView = currentPlayerHand;
        Card selectedCard = this.selectedCard;
        if (selectedCard != null) System.out.println("currentPlayerHandClicked: " + selectedCard.getName());
        if (selectedCard != null) handleListViewClick(listView, selectedCard);
    }

    @FXML
    public void firstPlayerCloseCombatListClicked(MouseEvent event) {
        ListView<?> listView = firstPlayerCloseCombatList;
        Card selectedCard = this.selectedCard;
        if (selectedCard != null) System.out.println("firstPlayerCloseCombatListClicked: " + selectedCard.getName());
        if (selectedCard != null) handleListViewClick(listView, selectedCard);
    }

    @FXML
    public void firstPlayerRangedListClicked(MouseEvent event) {
        ListView<?> listView = firstPlayerRangedList;
        Card selectedCard = this.selectedCard;
        if (selectedCard != null) System.out.println("firstPlayerRangedListClicked: " + selectedCard.getName());
        if (selectedCard != null) handleListViewClick(listView, selectedCard);
    }

    @FXML
    public void firstPlayerSiegeListClicked(MouseEvent event) {
        ListView<?> listView = firstPlayerSiegeList;
        Card selectedCard = this.selectedCard;
        if (selectedCard != null) System.out.println("firstPlayerSiegeListClicked: " + selectedCard.getName());
        if (selectedCard != null) handleListViewClick(listView, selectedCard);
    }

    @FXML
    public void secondPlayerCloseCombatListClicked(MouseEvent event) {
        ListView<?> listView = secondPlayerCloseCombatList;
        Card selectedCard = this.selectedCard;
        if (selectedCard != null) System.out.println("secondPlayerCloseCombatListClicked: " + selectedCard.getName());
        if (selectedCard != null) handleListViewClick(listView, selectedCard);
    }

    @FXML
    public void secondPlayerRangedListClicked(MouseEvent event) {
        ListView<?> listView = secondPlayerRangedList;
        Card selectedCard = this.selectedCard;
        if (selectedCard != null) System.out.println("secondPlayerRangedListClicked: " + selectedCard.getName());
        if (selectedCard != null) handleListViewClick(listView, selectedCard);
    }

    @FXML
    public void secondPlayerSiegeListClicked(MouseEvent event) {
        ListView<?> listView = secondPlayerSiegeList;
        Card selectedCard = this.selectedCard;
        if (selectedCard != null) System.out.println("secondPlayerSiegeListClicked: " + selectedCard.getName());
        if (selectedCard != null) handleListViewClick(listView, selectedCard);
    }

    @FXML
    public void weatherCardClicked(MouseEvent event) {
        ImageView imageView = weatherCard;
        System.out.println("weatherCardClicked: " + selectedCard.getName());
        if (isHighlightedImageView(imageView)) {
            handleImageViewClick(imageView, selectedCard);
        } else if (weatherCard != null) showWeatherCardInfo();
    }

    @FXML
    public void firstPlayerSiegeBoostClicked(MouseEvent event) {
        ImageView imageView = firstPlayerSiegeBoost;
        if (selectedCard != null) System.out.println("firstPlayerSiegeBoostClicked: " + selectedCard.getName());
        if (selectedCard != null) handleImageViewClick(imageView, selectedCard);
    }

    @FXML
    public void firstPlayerRangedBoostClicked(MouseEvent event) {
        ImageView imageView = firstPlayerRangedBoost;
        if (selectedCard != null) System.out.println("firstPlayerRangedBoostClicked: " + selectedCard.getName());
        if (selectedCard != null) handleImageViewClick(imageView, selectedCard);
    }

    @FXML
    public void firstPlayerCloseCombatBoostClicked(MouseEvent event) {
        ImageView imageView = firstPlayerCloseCombatBoost;
        if (selectedCard != null) System.out.println("firstPlayerCloseCombatBoostClicked: " + selectedCard.getName());
        if (selectedCard != null) handleImageViewClick(imageView, selectedCard);
    }

    @FXML
    public void secondPlayerCloseCombatBoostClicked(MouseEvent event) {
        ImageView imageView = secondPlayerCloseCombatBoost;
        if (selectedCard != null) System.out.println("secondPlayerCloseCombatBoostClicked: " + selectedCard.getName());
        if (selectedCard != null) handleImageViewClick(imageView, selectedCard);
    }

    @FXML
    public void secondPlayerRangedBoostClicked(MouseEvent event) {
        ImageView imageView = secondPlayerRangedBoost;
        if (selectedCard != null) System.out.println("secondPlayerRangedBoostClicked: " + selectedCard.getName());
        if (selectedCard != null) handleImageViewClick(imageView, selectedCard);
    }

    @FXML
    public void secondPlayerSiegeBoostClicked(MouseEvent event) {
        ImageView imageView = secondPlayerSiegeBoost;
        if (selectedCard != null) System.out.println("secondPlayerSiegeBoostClicked: " + selectedCard.getName());
        if (selectedCard != null) handleImageViewClick(imageView, selectedCard);
    }

    @FXML
    public void firstPlayerPassClicked(MouseEvent mouseEvent) {
        Game game = User.getLoggedInUser().getCurrentGame();
        game.getGamePlayer1().setPassedTheGame(true);
        updateGameState(game);
        changeTurn();
    }

    @FXML
    public void secondPlayerPassClicked(MouseEvent mouseEvent) {
        Game game = User.getLoggedInUser().getCurrentGame();
        game.getGamePlayer2().setPassedTheGame(true);
        updateGameState(game);
        changeTurn();
    }

    private void isRoundEnd() {
        Game game = User.getLoggedInUser().getCurrentGame();
        EachPlayerGame firstPlayerGame = game.getGamePlayer1();
        EachPlayerGame secondPlayerGame = game.getGamePlayer2();

        boolean firstPlayerPassed = firstPlayerGame.isPassedTheGame() ||
                (firstPlayerGame.getHand().isEmpty() && firstPlayerGame.isLeaderCardUsed());
        boolean secondPlayerPassed = secondPlayerGame.isPassedTheGame() ||
                (secondPlayerGame.getHand().isEmpty() && secondPlayerGame.isLeaderCardUsed());
        if (firstPlayerPassed && secondPlayerPassed) endOfRound();
    }

    private void endOfRound() {
        Game game = User.getLoggedInUser().getCurrentGame();
        System.out.println("End of round number " + game.getRoundNo());
        EachPlayerGame firstPlayerGame = game.getGamePlayer1();
        EachPlayerGame secondPlayerGame = game.getGamePlayer2();
        firstPlayerGame.setPassedTheGame(false);
        secondPlayerGame.setPassedTheGame(false);

        switch (game.getRoundNo()) {
            case 1:
                processRound(game, firstPlayerGame, secondPlayerGame, 1);
                showNextRoundAlert();
                break;
            case 2:
                processRound(game, firstPlayerGame, secondPlayerGame, 2);
                if (firstPlayerGame.getCrystals() != 0 && secondPlayerGame.getCrystals() != 0) showNextRoundAlert();
                isGameEnd();
                break;
            case 3:
                processRound(game, firstPlayerGame, secondPlayerGame, 3);
                endOfGame();
                break;
        }

        game.setRoundNo(game.getRoundNo() + 1);
        updateGameState(game);
    }

    private void showNextRoundAlert() {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Next Round");
            alert.setHeaderText(null);
            alert.setContentText("The next round is beginning!");

            alert.showAndWait();
        });
    }

    private void processRound(Game game, EachPlayerGame firstPlayerGame, EachPlayerGame secondPlayerGame, int RoundNo) {

        boolean isThereCow1 = (firstPlayerGame.getRangedCombat().contains(Card.getCardByID(610)));
        boolean isThereKambi1 = (firstPlayerGame.getCloseCombat().contains(Card.getCardByID(110)));
        boolean isThereCow2 = (secondPlayerGame.getRangedCombat().contains(Card.getCardByID(610)));
        boolean isThereKambi2 = (secondPlayerGame.getCloseCombat().contains(Card.getCardByID(110)));

        switch (RoundNo) {
            case 1:
                firstPlayerGame.setFirstRoundScore(firstPlayerGame.getTotalBoardPower());
                secondPlayerGame.setFirstRoundScore(secondPlayerGame.getTotalBoardPower());
                break;
            case 2:
                firstPlayerGame.setSecondRoundScore(firstPlayerGame.getTotalBoardPower());
                secondPlayerGame.setSecondRoundScore(secondPlayerGame.getTotalBoardPower());
                break;
            case 3:
                firstPlayerGame.setThirdRoundScore(firstPlayerGame.getTotalBoardPower());
                secondPlayerGame.setThirdRoundScore(secondPlayerGame.getTotalBoardPower());
                break;
        }

        if (firstPlayerGame.getTotalBoardPower() > secondPlayerGame.getTotalBoardPower()) {
            setRoundWinner(game, firstPlayerGame, secondPlayerGame, RoundNo, game.getPlayer1());
        } else if (firstPlayerGame.getTotalBoardPower() < secondPlayerGame.getTotalBoardPower()) {
            setRoundWinner(game, firstPlayerGame, secondPlayerGame, RoundNo, game.getPlayer2());
        } else {
            handleDraw(game, firstPlayerGame, secondPlayerGame, RoundNo);
        }


        switch (RoundNo) {
            case 1:
                northernRealms();
                monsters();
                clearBoard();
                break;
            case 2:
                skellige();
                northernRealms();
                monsters();
                clearBoard();
        }


        isThereCow(firstPlayerGame, isThereCow1);
        isThereCow(secondPlayerGame, isThereCow2);
        isThereKambi(firstPlayerGame, isThereKambi1);
        isThereKambi(secondPlayerGame, isThereKambi2);
        ObservableList discard = firstPlayerGame.getBurnedCards();
        discard.remove(Card.getCardByID(110));
        discard.remove(Card.getCardByID(610));
        discard = addCardIfNotNull(discard,firstPlayerGame.getMarCoSiege());
        discard = addCardIfNotNull(discard,firstPlayerGame.getMarCoCloseCombat());
        discard = addCardIfNotNull(discard,firstPlayerGame.getMarCoRangedCombat());
        firstPlayerGame.setBurnedCards(discard);
        discard = secondPlayerGame.getBurnedCards();
        discard.remove(Card.getCardByID(110));
        discard.remove(Card.getCardByID(610));
        discard = addCardIfNotNull(discard,secondPlayerGame.getMarCoSiege());
        discard = addCardIfNotNull(discard,secondPlayerGame.getMarCoCloseCombat());
        discard = addCardIfNotNull(discard,secondPlayerGame.getMarCoRangedCombat());
        secondPlayerGame.setBurnedCards(discard);
        game.setWeatherCard(null);
        System.out.println(":kjdjshfjkasd");
        firstPlayerGame.setMarCoSiege(null);
        firstPlayerGame.setMarCoRangedCombat(null);
        firstPlayerGame.setMarCoCloseCombat(null);
        secondPlayerGame.setMarCoSiege(null);
        secondPlayerGame.setMarCoRangedCombat(null);
        secondPlayerGame.setMarCoCloseCombat(null);
    }


    private ObservableList<Card> addCardIfNotNull(ObservableList<Card> discard, Card card) {
        if (card != null) {
            discard.add(card);
        }
        return discard;
    }

    private void isThereKambi(EachPlayerGame playerGame, boolean isThereKambi) {
        if (isThereKambi) {
            HashMap<Card, List<Integer>> listScores = playerGame.getCloseCombatScores();
            ObservableList<Card> list = playerGame.getCloseCombat();
            Card kambiCard = Card.getCardByName("Kambi");

            if (list.contains(kambiCard)) {
                List<Integer> scores = listScores.get(kambiCard);
                scores.add(8);
                listScores.put(kambiCard, scores);
            } else {
                list.add(kambiCard);
                List<Integer> scores = new ArrayList<>();
                scores.add(8);
                listScores.put(kambiCard, scores);
            }

            playerGame.setCloseCombatScores(listScores);
            playerGame.setCloseCombat(list);
        }
    }

    private void isThereCow(EachPlayerGame playerGame, boolean isThereCow) {
        if (isThereCow) {
            HashMap<Card, List<Integer>> listScores = playerGame.getRangedCombatScores();
            ObservableList<Card> list = playerGame.getRangedCombat();
            Card cowCard = Card.getCardByName("Cow");

            if (list.contains(cowCard)) {
                List<Integer> scores = listScores.get(cowCard);
                scores.add(8);
                listScores.put(cowCard, scores);
            } else {
                list.add(cowCard);
                List<Integer> scores = new ArrayList<>();
                scores.add(8);
                listScores.put(cowCard, scores);
            }

            playerGame.setRangedCombatScores(listScores);
            playerGame.setRangedCombat(list);
        }
    }

    private void setRoundWinner(Game game, EachPlayerGame firstPlayerGame, EachPlayerGame secondPlayerGame, int RoundNo, User winner) {
        switch (RoundNo) {
            case 1:
                game.setFirstRoundWinner(winner);
                break;
            case 2:
                game.setSecondRoundWinner(winner);
                break;
            case 3:
                game.setThirdRoundWinner(winner);
                break;
        }
        if (winner == null) {
            System.out.println("draw");
            firstPlayerGame.setCrystals(firstPlayerGame.getCrystals() - 1);
            secondPlayerGame.setCrystals(secondPlayerGame.getCrystals() - 1);
        } else if (winner.equals(game.getPlayer1())) {
            System.out.println("first player won the round");
            secondPlayerGame.setCrystals(secondPlayerGame.getCrystals() - 1);
        } else {
            System.out.println("second player won the round");
            firstPlayerGame.setCrystals(firstPlayerGame.getCrystals() - 1);
        }
    }

    private void handleDraw(Game game, EachPlayerGame firstPlayerGame, EachPlayerGame secondPlayerGame, int RoundNo) {
        if (firstPlayerGame.getFaction().equals(Faction.getFactionByName("Nilfgaard"))) {
            if (secondPlayerGame.getFaction().equals(Faction.getFactionByName("Nilfgaard"))) {
                setRoundWinner(game, firstPlayerGame, secondPlayerGame, RoundNo, null);
            } else {
                setRoundWinner(game, firstPlayerGame, secondPlayerGame, RoundNo, game.getPlayer1());
            }
        } else {
            if (secondPlayerGame.getFaction().equals(Faction.getFactionByName("Nilfgaard"))) {
                setRoundWinner(game, firstPlayerGame, secondPlayerGame, RoundNo, game.getPlayer2());
            } else {
                setRoundWinner(game, firstPlayerGame, secondPlayerGame, RoundNo, null);
            }
        }
    }

    private void isGameEnd() {
        Game game = User.getLoggedInUser().getCurrentGame();
        if (game.getGamePlayer1().getCrystals() == 0 || game.getGamePlayer2().getCrystals() == 0) endOfGame();
    }

    private void endOfGame() {
        Game game = User.getLoggedInUser().getCurrentGame();
        EachPlayerGame firstPlayerGame = game.getGamePlayer1();
        EachPlayerGame secondPlayerGame = game.getGamePlayer2();

        if (firstPlayerGame.getCrystals() == 0) {
            if (secondPlayerGame.getCrystals() == 0) game.setStatement(Statement.Tie);
            else game.setStatement(Statement.Player2WonTheGame);
        } else game.setStatement(Statement.Player1WonTheGame);

        ArrayList<Game> games = game.getPlayer1().getGames();
        games.add(game);
        game.getPlayer1().setGames(games);
        games = game.getPlayer2().getGames();
        games.add(game);
        game.getPlayer2().setGames(games);

        EndOfTheGame endOfTheGame = new EndOfTheGame();
        try {
            endOfTheGame.start(GameMenu.stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void changeTurn() {
        Game game = User.getLoggedInUser().getCurrentGame();
        game.setTurnNo(game.getTurnNo() + 1);
        if (game.getActivePlayer().equals(game.getPlayer1()) || game.getGamePlayer1().isPassedTheGame()) {
            game.setActivePlayer(game.getPlayer2());
        } else if (game.getActivePlayer().equals(game.getPlayer2()) || game.getGamePlayer2().isPassedTheGame()) {
            game.setActivePlayer(game.getPlayer1());
        }
        updateGameState(game);
        isRoundEnd();
    }


    public void cheatAddCardToHand() {
        Game game = User.getLoggedInUser().getCurrentGame();
        User user = game.getActivePlayer();
        Card card = null;
        HashMap<Card, Integer> deck;    // this Integer is count
        ObservableList<Card> hand;
        Random random = new Random();
        int count = 0;
        if (user.equals(game.getPlayer1())) {
            deck = game.getGamePlayer1().getDeck();
            int index = random.nextInt(deck.size());
            int i = 0;
            for (Map.Entry<Card, Integer> entry : deck.entrySet()) {
                if (i == index) {
                    card = entry.getKey();
                    count = entry.getValue();
                }
                i++;
            }
            hand = game.getGamePlayer1().getHand();
            for (int j = 0; j < count; j++) {
                hand.add(card);
            }
            game.getGamePlayer1().setHand(hand);
            deck.remove(card);
            if (count != 1) deck.put(card, count - 1);
            game.getGamePlayer1().setDeck(deck);
            int newCountOfDeck = deck.size();
            firstPlayerRemainingCards.setText(String.valueOf(newCountOfDeck));
        }
        if (user.equals(game.getPlayer2())) {
            deck = game.getGamePlayer2().getDeck();
            int index = random.nextInt(deck.size());
            int i = 0;
            for (Map.Entry<Card, Integer> entry : deck.entrySet()) {
                if (i == index) {
                    card = entry.getKey();

                }
                i++;
            }
            hand = game.getGamePlayer2().getHand();
            hand.add(card);
            game.getGamePlayer2().setHand(hand);
            deck.remove(card);
            game.getGamePlayer2().setDeck(deck);
            int newCountOfDeck = deck.size();
            firstPlayerRemainingCards.setText(String.valueOf(newCountOfDeck));
        }
    }

    public void cheatSetDefaultCrystal() {
        Game game = User.getLoggedInUser().getCurrentGame();
        User user = game.getActivePlayer();
        if (user.equals(game.getPlayer1())) {
            game.getGamePlayer1().setCrystals(2);
            updateGameState(game);
        }
        if (user.equals(game.getPlayer2())) {
            game.getGamePlayer2().setCrystals(2);
            updateGameState(game);
        }
    }

    public void cheatReturnTheBurnedCards() {
        Game game = User.getLoggedInUser().getCurrentGame();
        User user = game.getActivePlayer();
        ObservableList<Card> hand;
        ObservableList<Card> burnedCards;
        if (user.equals(game.getPlayer1())) {
            hand = game.getGamePlayer1().getHand();
            burnedCards = game.getGamePlayer1().getBurnedCards();
                hand.addAll(burnedCards);
                game.getGamePlayer1().setHand(hand);
                burnedCards.removeAll();
                game.getGamePlayer1().setBurnedCards(burnedCards);
        }
        if (user.equals(game.getPlayer2())) {
            hand = game.getGamePlayer2().getHand();
            burnedCards = game.getGamePlayer2().getBurnedCards();
                hand.addAll(burnedCards);
                game.getGamePlayer2().setHand(hand);
                burnedCards.removeAll();
                game.getGamePlayer2().setBurnedCards(burnedCards);
        }
    }

    public void cheatLeaderDefault() {
        Game game = User.getLoggedInUser().getCurrentGame();
        User user = game.getActivePlayer();
        if (user.equals(game.getPlayer1())) {
            game.getGamePlayer1().setLeaderCardUsed(false);
        }
        if (user.equals(game.getPlayer2())) {
            game.getGamePlayer2().setLeaderCardUsed(false);
        }
    }

    public void cheatPassRound() {  // pass round harif
        Game game = User.getLoggedInUser().getCurrentGame();
        User user = game.getActivePlayer();
//        if (user.equals(game.getPlayer1())) {
//            game.getGamePlayer2().setPassedTheGame(true);
//        }
//        if (user.equals(game.getPlayer2())) {
//            game.getGamePlayer1().setPassedTheGame(true);
//        }
        endOfRound();
        changeTurn();
    }

    public void cheatPassGame() {   //namayesh e barandeh
        Game game = User.getLoggedInUser().getCurrentGame();
        endOfRound();
        int crystal1 = game.getGamePlayer1().getCrystals();
        int crystal2 = game.getGamePlayer2().getCrystals();
        if (crystal2 > crystal1) game.getGamePlayer1().setCrystals(0);
        if (crystal2 < crystal1) game.getGamePlayer2().setCrystals(0);
        endOfGame();
    }

    public void handleKeyPress(javafx.scene.input.KeyEvent event) {
        if (event.getCode() == KeyCode.A) {
            cheatAddCardToHand();
        }
        if (event.getCode() == KeyCode.S) {
            cheatSetDefaultCrystal();
        }
        if (event.getCode() == KeyCode.R) {
            cheatReturnTheBurnedCards();
        }
        if (event.getCode() == KeyCode.L) {
            cheatLeaderDefault();
        }
        if (event.getCode() == KeyCode.P) {
            cheatPassRound();
        }
        if (event.getCode() == KeyCode.G) {
            cheatPassGame();
        }
    }

    private void clearBoard() {
        Game game = User.getLoggedInUser().getCurrentGame();
        if ((game.getRoundNo() == 2 && !game.getPlayer1().getFaction().equals(Faction.getFactionByName("Skellige")) &&
                !game.getPlayer1().getFaction().equals(Faction.getFactionByName("Northern Realms")) &&
                !game.getPlayer1().getFaction().equals(Faction.getFactionByName("Monsters"))) ||
                (game.getRoundNo() == 1 && !game.getPlayer1().getFaction().equals(Faction.getFactionByName("Northern Realms")) &&
                        !game.getPlayer1().getFaction().equals(Faction.getFactionByName("Monsters")))) {
            HashMap<Card, List<Integer>> list = game.getGamePlayer1().getCloseCombatScores();
            ObservableList<Card> discard = game.getGamePlayer1().getBurnedCards();
            for (Card card : list.keySet()) {
                for (int i = 0; i < list.get(card).size(); i++) {
                    discard.add(card);
                }
            }
            list.clear();
            game.getGamePlayer1().setCloseCombatScores(list);

            ObservableList<Card> cards = game.getGamePlayer1().getCloseCombat();
            cards.clear();
            game.getGamePlayer1().setCloseCombat(cards);

            list = game.getGamePlayer1().getRangedCombatScores();
            for (Card card : list.keySet()) {
                for (int i = 0; i < list.get(card).size(); i++) {
                    discard.add(card);
                }
            }
            list.clear();
            game.getGamePlayer1().setRangedCombatScores(list);

            cards = game.getGamePlayer1().getRangedCombat();
            cards.clear();
            game.getGamePlayer1().setRangedCombat(cards);

            list = game.getGamePlayer1().getSiegeScores();
            for (Card card : list.keySet()) {
                for (int i = 0; i < list.get(card).size(); i++) {
                    discard.add(card);
                }
            }
            list.clear();
            game.getGamePlayer1().setSiegeScores(list);
            game.getGamePlayer1().setBurnedCards(discard);

            cards = game.getGamePlayer1().getSiege();
            cards.clear();
            game.getGamePlayer1().setSiege(cards);
        }
        if ((game.getRoundNo() == 2 && !game.getPlayer2().getFaction().equals(Faction.getFactionByName("Skellige")) &&
                !game.getPlayer2().getFaction().equals(Faction.getFactionByName("Northern Realms")) &&
                !game.getPlayer2().getFaction().equals(Faction.getFactionByName("Monsters"))) ||
                (game.getRoundNo() == 1 && !game.getPlayer2().getFaction().equals(Faction.getFactionByName("Northern Realms")) &&
                        !game.getPlayer2().getFaction().equals(Faction.getFactionByName("Monsters")))) {

            HashMap<Card, List<Integer>> list = game.getGamePlayer2().getCloseCombatScores();
            ObservableList<Card> discard = game.getGamePlayer2().getBurnedCards();
            for (Card card : list.keySet()) {
                for (int i = 0; i < list.get(card).size(); i++) {
                    discard.add(card);
                }
            }
            list.clear();
            game.getGamePlayer2().setCloseCombatScores(list);

            ObservableList<Card> cards = game.getGamePlayer2().getCloseCombat();
            cards.clear();
            game.getGamePlayer2().setCloseCombat(cards);

            list = game.getGamePlayer2().getRangedCombatScores();
            for (Card card : list.keySet()) {
                for (int i = 0; i < list.get(card).size(); i++) {
                    discard.add(card);
                }
            }
            list.clear();
            game.getGamePlayer2().setRangedCombatScores(list);

            cards = game.getGamePlayer2().getRangedCombat();
            cards.clear();
            game.getGamePlayer2().setRangedCombat(cards);

            list = game.getGamePlayer2().getSiegeScores();
            for (Card card : list.keySet()) {
                for (int i = 0; i < list.get(card).size(); i++) {
                    discard.add(card);
                }
            }
            list.clear();
            game.getGamePlayer2().setSiegeScores(list);
            game.getGamePlayer2().setBurnedCards(discard);

            cards = game.getGamePlayer2().getSiege();
            cards.clear();
            game.getGamePlayer2().setSiege(cards);
        }
    }


    private void skellige() {
        Game game = User.getLoggedInUser().getCurrentGame();
        EachPlayerGame firstPlayerGame = game.getGamePlayer1();
        EachPlayerGame secondPlayerGame = game.getGamePlayer2();

        if (game.getPlayer1().getFaction().equals(Faction.getFactionByName("Skellige"))) {
            handleSkelligeFaction(firstPlayerGame);
        }
        if (game.getPlayer2().getFaction().equals(Faction.getFactionByName("Skellige"))) {
            handleSkelligeFaction(secondPlayerGame);
        }
    }

    private void handleSkelligeFaction(EachPlayerGame playerGame) {
        moveTwoRandomCardsFromDiscardToHand(playerGame);
        moveAllBoardCardsToDiscardAndReset(playerGame);
    }

    private void moveTwoRandomCardsFromDiscardToHand(EachPlayerGame playerGame) {
        ObservableList<Card> discard = playerGame.getBurnedCards();
        ObservableList<Card> hand = playerGame.getHand();
        Random random = new Random();

        if (discard.size() < 2) return;

        for (int i = 0; i < 2; i++) {
            int index = random.nextInt(discard.size());
            Card card = discard.remove(index);
            hand.add(card);
        }

        playerGame.setBurnedCards(discard);
        playerGame.setHand(hand);
    }

    private void moveAllBoardCardsToDiscardAndReset(EachPlayerGame playerGame) {
        ObservableList<Card> discard = playerGame.getBurnedCards();

        discard.addAll(playerGame.getCloseCombat());
        playerGame.setCloseCombat(FXCollections.observableArrayList());
        playerGame.setCloseCombatScores(new HashMap<>());

        discard.addAll(playerGame.getRangedCombat());
        playerGame.setRangedCombat(FXCollections.observableArrayList());
        playerGame.setRangedCombatScores(new HashMap<>());

        discard.addAll(playerGame.getSiege());
        playerGame.setSiege(FXCollections.observableArrayList());
        playerGame.setSiegeScores(new HashMap<>());

        playerGame.setBurnedCards(discard);
    }

    private void northernRealms() {
        Game game = User.getLoggedInUser().getCurrentGame();
        EachPlayerGame firstPlayerGame = game.getGamePlayer1();
        EachPlayerGame secondPlayerGame = game.getGamePlayer2();
        if (game.getPlayer1().getFaction().equals(Faction.getFactionByName("Northern Realms"))) {
            if (((game.getRoundNo() == 1) && (game.getFirstRoundWinner() != null) && (game.getFirstRoundWinner().equals(game.getPlayer1()))) ||
                    ((game.getRoundNo() == 2) && (game.getSecondRoundWinner() != null) && (game.getSecondRoundWinner().equals(game.getPlayer1())))) {
                NR(firstPlayerGame);
            }
        }
        if (game.getPlayer2().getFaction().equals(Faction.getFactionByName("Northern Realms"))) {
            if (((game.getRoundNo() == 1) && (game.getFirstRoundWinner() != null) && (game.getFirstRoundWinner().equals(game.getPlayer2()))) ||
                    ((game.getRoundNo() == 2) && (game.getSecondRoundWinner() != null) && (game.getSecondRoundWinner().equals(game.getPlayer2())))) {
                NR(secondPlayerGame);
            }
        }
    }

    private void NR(EachPlayerGame playerGame) {
        HashMap<Card, List<Integer>> list = playerGame.getCloseCombatScores();
        ObservableList<Card> discard = playerGame.getBurnedCards();
        for (Card card : list.keySet()) {
            for (int i = 0; i < list.get(card).size(); i++) {
                discard.add(card);
            }
        }
        list.clear();
        playerGame.setCloseCombatScores(list);

        list = playerGame.getRangedCombatScores();
        for (Card card : list.keySet()) {
            for (int i = 0; i < list.get(card).size(); i++) {
                discard.add(card);
            }
        }
        list.clear();
        playerGame.setRangedCombatScores(list);

        list = playerGame.getSiegeScores();
        for (Card card : list.keySet()) {
            for (int i = 0; i < list.get(card).size(); i++) {
                discard.add(card);
            }
        }
        list.clear();
        playerGame.setSiegeScores(list);
        playerGame.setBurnedCards(discard);

        HashMap<Card, Integer> deck = playerGame.getDeck();
        ObservableList<Card> hand = playerGame.getHand();
        int randomIndex = this.random.nextInt(deck.keySet().size());
        Card randomCard = new ArrayList<>(deck.keySet()).get(randomIndex);
        hand.add(randomCard);
        int count = deck.get(randomCard);
        if (count > 1) {
            deck.put(randomCard, count - 1);
        } else {
            deck.remove(randomCard);
        }
        playerGame.setHand(hand);
        playerGame.setDeck(deck);
    }

    private void monsters() {
        Game game = User.getLoggedInUser().getCurrentGame();
        EachPlayerGame firstPlayerGame = game.getGamePlayer1();
        EachPlayerGame secondPlayerGame = game.getGamePlayer2();

        if (game.getPlayer1().getFaction().equals(Faction.getFactionByName("Monsters"))) {
            handleMonstersFaction(firstPlayerGame);
        }
        if (game.getPlayer2().getFaction().equals(Faction.getFactionByName("Monsters"))) {
            handleMonstersFaction(secondPlayerGame);
        }
    }

    private void handleMonstersFaction(EachPlayerGame playerGame) {
        List<Card> nonHeroNonSpellCards = new ArrayList<>();
        addNonHeroNonSpellCards(playerGame.getCloseCombat(), nonHeroNonSpellCards);
        addNonHeroNonSpellCards(playerGame.getRangedCombat(), nonHeroNonSpellCards);
        addNonHeroNonSpellCards(playerGame.getSiege(), nonHeroNonSpellCards);

        if (!nonHeroNonSpellCards.isEmpty()) {
            Random random = new Random();
            Card cardToKeep = nonHeroNonSpellCards.get(random.nextInt(nonHeroNonSpellCards.size()));

            HashMap<Card, List<Integer>> listScores = playerGame.getCloseCombatScores();
            ObservableList<Card> list = playerGame.getCloseCombat();
            if (!list.contains(cardToKeep)) {
                listScores.clear();
                list.clear();
            } else {
                listScores.clear();
                list.clear();
                list.add(cardToKeep);
                List<Integer> scores = new ArrayList<>();
                scores.add(0, cardToKeep.getPower());
                listScores.put(cardToKeep, scores);
            }
            playerGame.setRangedCombatScores(listScores);
            playerGame.setCloseCombat(list);

            listScores = playerGame.getRangedCombatScores();
            list = playerGame.getRangedCombat();
            if (!list.contains(cardToKeep)) {
                listScores.clear();
                list.clear();
            } else {
                listScores.clear();
                list.clear();
                list.add(cardToKeep);
                List<Integer> scores = new ArrayList<>();
                scores.add(0, cardToKeep.getPower());
                listScores.put(cardToKeep, scores);
            }
            playerGame.setRangedCombatScores(listScores);
            playerGame.setRangedCombat(list);

            listScores = playerGame.getRangedCombatScores();
            list = playerGame.getSiege();
            if (!list.contains(cardToKeep)) {
                listScores.clear();
                list.clear();
            } else {
                listScores.clear();
                list.clear();
                list.add(cardToKeep);
                List<Integer> scores = new ArrayList<>();
                scores.add(0, cardToKeep.getPower());
                listScores.put(cardToKeep, scores);
            }
            playerGame.setSiegeScores(listScores);
            playerGame.setSiege(list);

        }
    }

    private void addNonHeroNonSpellCards(ObservableList<Card> row, List<Card> nonHeroNonSpellCards) {
        for (Card card : row) {
            if (!card.isHero() && !card.isSpecial()) {
                nonHeroNonSpellCards.add(card);
            }
        }
    }

    private void clearWeather() {
        secondPlayerSiegeWeather.setVisible(false);
        secondPlayerRangedWeather.setVisible(false);
        secondPlayerCloseCombatLWeather.setVisible(false);
        firstPlayerCloseCombatWeather.setVisible(false);
        firstPlayerRangedWeather.setVisible(false);
        firstPlayerSiegeWeather.setVisible(false);
    }


    public void secondPlayerLeaderCardClicked(MouseEvent mouseEvent) {
        Game game = User.getLoggedInUser().getCurrentGame();
        if (game.getGamePlayer2().equals(game.getActivePlayer()) && !game.getGamePlayer2().isLeaderCardUsed()){
            System.out.println("hihihihi");
            if (leaderCard1Popup == null) {
                leaderCard1Popup = new Popup();
                StackPane popupContent = new StackPane();
                popupContent.setStyle("-fx-background-color: white; -fx-padding: 10px;");
                ImageView leaderCardImageView = new ImageView();
                Label leaderCardLabel = new Label("Leader Card Name");
                leaderCardLabel.setStyle("-fx-font-weight: bold;");
                VBox popupContentBox = new VBox(10);
                popupContentBox.getChildren().addAll(leaderCardLabel, leaderCardImageView);
                popupContent.getChildren().add(popupContentBox);
                popupContent.setOnMouseClicked(event -> leaderCard1Popup.hide());
                leaderCard1Popup.getContent().add(popupContent);
            }
            Image leaderCardImage = User.getLoggedInUser().getLeaderCard().getImage();
            String leaderCardName = "Leader Card Name";

            if (!isPopupShowing1) {
                System.out.println("hoho");
                ImageView leaderCardImageView = (ImageView) ((VBox) leaderCard1Popup.getContent().get(0)).getChildren().get(1);
                leaderCardImageView.setImage(leaderCardImage);
                Label leaderCardLabel = (Label) ((VBox) leaderCard1Popup.getContent().get(0)).getChildren().get(0);
                leaderCardLabel.setText(leaderCardName);
                Node source = (Node) mouseEvent.getSource();
                Window ownerWindow = source.getScene().getWindow();
                leaderCard1Popup.show(ownerWindow);
                isPopupShowing1 = true;
            } else {
                leaderCard1Popup.hide();
                isPopupShowing1 = false;
            }
        }
    }

    public void firstPlayerLeaderCardClicked(MouseEvent mouseEvent) {
        System.out.println("jsdhfkja");
        Game game = User.getLoggedInUser().getCurrentGame();
        if (game.getGamePlayer1().equals(game.getActivePlayer()) && !game.getGamePlayer1().isLeaderCardUsed()){
            if (leaderCard1Popup == null) {
                leaderCard1Popup = new Popup();
                StackPane popupContent = new StackPane();
                popupContent.setStyle("-fx-background-color: white; -fx-padding: 10px;");
                ImageView leaderCardImageView = new ImageView();
                Label leaderCardLabel = new Label("Leader Card Name");
                leaderCardLabel.setStyle("-fx-font-weight: bold;");
                VBox popupContentBox = new VBox(10);
                popupContentBox.getChildren().addAll(leaderCardLabel, leaderCardImageView);
                popupContent.getChildren().add(popupContentBox);
                popupContent.setOnMouseClicked(event -> leaderCard1Popup.hide());
                leaderCard1Popup.getContent().add(popupContent);
            }
            Image leaderCardImage = User.getLoggedInUser().getLeaderCard().getImage();
            String leaderCardName = "Leader Card Name";

            if (!isPopupShowing1) {
                ImageView leaderCardImageView = (ImageView) ((VBox) leaderCard1Popup.getContent().get(0)).getChildren().get(1);
                leaderCardImageView.setImage(leaderCardImage);
                Label leaderCardLabel = (Label) ((VBox) leaderCard1Popup.getContent().get(0)).getChildren().get(0);
                leaderCardLabel.setText(leaderCardName);
                Node source = (Node) mouseEvent.getSource();
                Window ownerWindow = source.getScene().getWindow();
                leaderCard1Popup.show(ownerWindow);
                isPopupShowing1 = true;
            } else {
                leaderCard1Popup.hide();
                isPopupShowing1 = false;
            }
        }
    }

    private void showWeatherCardInfo() {
    }
}
