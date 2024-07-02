package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import model.Card;
import model.Faction;
import model.User;
import view.CardListCellFactory;

import java.util.Comparator;
import java.util.Map;

public class PregameMenuScController extends BasePregameController {

    public ImageView leaderImage;
    public ChoiceBox<String> leaderChoiceBox;
    @FXML
    private ListView<Card> cardsListView;

    @FXML
    private ListView<Card> userDeckListView;

    private ObservableList<Card> scoiataelCards;
    private ObservableList<Card> userDeck;

    @Override
    protected void initializeController() {
        User user = User.getLoggedInUser();

        ObservableList<String> leaderNames = FXCollections.observableArrayList();
        for (Card leader : Faction.getFactionByName("Scoia'tael").getLeaderCards()) {
            leaderNames.add(leader.getName());
        }
        leaderChoiceBox.setItems(leaderNames);
        leaderChoiceBox.setValue(user.getLeaderCard().getName());
        leaderChoiceBox.setOnAction(event -> handleLeaderChange());

        leaderImage.setImage(user.getLeaderCard().getImage());

        scoiataelCards = FXCollections.observableArrayList();
        userDeck = FXCollections.observableArrayList();

        for (Map.Entry<Card, Integer> entry : user.getDeck().entrySet()) {
            Card card = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                userDeck.add(card);
            }
        }

        for (Card card : Faction.getFactionByName("Scoia'tael").getCards()) {
            int cardInDeck = 0;
            if (userDeck.contains(card)) cardInDeck = user.getDeck().get(card);
            for (int i = 0; i < card.getCountOfCard() - cardInDeck ; i++) {
                scoiataelCards.add(card);
            }
        }

        SortedList<Card> sortedScoiataelCards = new SortedList<>(scoiataelCards, Comparator.comparingInt(Card::getID));
        SortedList<Card> sortedUserDeck = new SortedList<>(userDeck, Comparator.comparingInt(Card::getID));

        cardsListView.setItems(sortedScoiataelCards);
        cardsListView.setCellFactory(new CardListCellFactory());

        userDeckListView.setItems(sortedUserDeck);
        userDeckListView.setCellFactory(new CardListCellFactory());

        cardsListView.setOnMouseClicked(event -> {
            Card selectedCard = cardsListView.getSelectionModel().getSelectedItem();
            if (selectedCard != null) {
                userDeck.add(selectedCard);
                scoiataelCards.remove(selectedCard);
                User.getLoggedInUser().addToDeck(selectedCard);
                updateLabels();
            }
        });

        userDeckListView.setOnMouseClicked(event -> {
            Card selectedCard = userDeckListView.getSelectionModel().getSelectedItem();
            if (selectedCard != null) {
                userDeck.remove(selectedCard);
                scoiataelCards.add(selectedCard);
                User.getLoggedInUser().removeFromDeck(selectedCard);
                updateLabels();
            }
        });
    }

    private void handleLeaderChange() {
        String selectedLeaderName = leaderChoiceBox.getValue();
        Card selectedLeader = Faction.getFactionByName("Scoia'tael").getLeaderCardByName(selectedLeaderName);

        if (selectedLeader != null) {
            User.getLoggedInUser().setLeaderCard(selectedLeader);
            leaderImage.setImage(selectedLeader.getImage());
        }
    }
}
