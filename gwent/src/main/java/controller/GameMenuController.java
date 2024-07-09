package controller;

import enums.Ability;
import enums.CardType;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.*;
import view.CardListCellFactory;

import java.awt.event.KeyEvent;
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
    public static ImageView secondPlayerLeaderActive;
    @FXML
    public static ImageView firstPlayerLeaderActive;
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

    private Card selectedCard;


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
        updateGameState(game);
    }

    public void updateGameState(Game game) {
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
            ObservableList<Card> burnedCards = firstPlayerGame.getBurnedCards();
            if (!burnedCards.isEmpty()) {
                Card lastBurnedCard = burnedCards.get(burnedCards.size() - 1);
                firstPlayerBurnedCards.setImage(lastBurnedCard.getImage());
            } else {
                firstPlayerBurnedCards.setImage(null);
            }
            if (firstPlayerGame.isLeaderCardUsed()) firstPlayerLeaderActive.setVisible(false);
            secondPlayerPass.setVisible(false);
            if (firstPlayerGame.isPassedTheGame()) firstPlayerPass.setVisible(false);
        } else {
            currentPlayerHand.setItems(secondPlayerGame.getSortedHand());
            ObservableList<Card> burnedCards = secondPlayerGame.getBurnedCards();
            if (!burnedCards.isEmpty()) {
                Card lastBurnedCard = burnedCards.get(burnedCards.size() - 1);
                secondPlayerBurnedCards.setImage(lastBurnedCard.getImage());
            } else {
                secondPlayerBurnedCards.setImage(null);
            }
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

    }

    private void endOfRound() {
        isGameEnd();
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
        if (User.getLoggedInUser().getCurrentGame().getWeatherCard() != null) calculateScoresWeather();
        isRoundEnd();
        Game game = User.getLoggedInUser().getCurrentGame();
        game.setTurnNo(game.getTurnNo() + 1);
        if (game.getActivePlayer().equals(game.getPlayer1())) game.setActivePlayer(game.getPlayer2());
        else game.setActivePlayer(game.getPlayer1());
        updateGameState(game);
    }

    private void updateScoresByWeatherCard(ObservableList<Card> cards, HashMap<Card, List<Integer>> cardsScore) {
        for (Card card : cards) {
            if (!card.isHero() && card.getPower() != 0) {
                List<Integer> scores = cardsScore.computeIfAbsent(card, k -> new ArrayList<>());
                scores.clear();
                for (int i = 0; i < cards.size(); i++) {
                    scores.add(1);
                }
            } else {
                List<Integer> scores = cardsScore.computeIfAbsent(card, k -> new ArrayList<>());
                scores.clear();
                for (int i = 0; i < cards.size(); i++) {
                    scores.add(card.getPower());
                }
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
        }
    }

    public void cheatSetDefaultCrystal() {
        Game game = User.getLoggedInUser().getCurrentGame();
        User user = game.getActivePlayer();
        if (user.equals(game.getPlayer1())) {
            game.getGamePlayer1().setCrystals(2);
        }
        if (user.equals(game.getPlayer2())) {
            game.getGamePlayer2().setCrystals(2);
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
            game.getGamePlayer1().setBurnedCards(null);
        }
        if (user.equals(game.getPlayer2())) {
            hand = game.getGamePlayer2().getHand();
            burnedCards = game.getGamePlayer2().getBurnedCards();
            hand.addAll(burnedCards);
            game.getGamePlayer2().setHand(hand);
            game.getGamePlayer2().setBurnedCards(null);
        }
    }

    public void cheatLeaderDefault() {
        Game game = User.getLoggedInUser().getCurrentGame();
        User user = game.getActivePlayer();
        if (user.equals(game.getPlayer1())) {
            game.getGamePlayer1().setLeaderCardUsed(false);
            firstPlayerLeaderActive.setVisible(true);
        }
        if (user.equals(game.getPlayer2())) {
            game.getGamePlayer2().setLeaderCardUsed(false);
            secondPlayerLeaderActive.setVisible(true);

        }
    }

    public void cheatPassRound() {  // pass round harif
        Game game = User.getLoggedInUser().getCurrentGame();
        User user = game.getActivePlayer();
        if (user.equals(game.getPlayer1())) {
            game.getGamePlayer2().setPassedTheGame(true);
        }
        if (user.equals(game.getPlayer2())) {
            game.getGamePlayer1().setPassedTheGame(true);
        }
        changeTurn();
    }

    public void cheatPassGame(){   //namayesh e barandeh
        Game game = User.getLoggedInUser().getCurrentGame();
        User user = game.getActivePlayer();
        changeTurn();
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
        if (event.getCode() == KeyCode.G){
            cheatPassGame();
        }
    }


}
