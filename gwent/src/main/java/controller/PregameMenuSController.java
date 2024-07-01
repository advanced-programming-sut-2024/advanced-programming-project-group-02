package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import model.Card;
import model.Faction;
import model.User;
import view.CardListCellFactory;

import java.util.Comparator;
import java.util.Map;

public class PregameMenuSController extends BasePregameController {

    @FXML
    private ListView<Card> cardsListView;

    @FXML
    private ListView<Card> userDeckListView;

    private ObservableList<Card> skelligeCards;
    private ObservableList<Card> userDeck;

    @Override
    protected void initializeController() {
        skelligeCards = FXCollections.observableArrayList();
        userDeck = FXCollections.observableArrayList();

        User user = User.getLoggedInUser();
        for (Map.Entry<Card, Integer> entry : user.getDeck().entrySet()) {
            Card card = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                userDeck.add(card);
            }
        }

        for (Card card : Faction.getFactionByName("Skellige").getCards()) {
            int cardInDeck = 0;
            if (userDeck.contains(card)) cardInDeck = user.getDeck().get(card);
            for (int i = 0; i < card.getCountOfCard()-cardInDeck ; i++) {
                skelligeCards.add(card);
            }
        }

        SortedList<Card> sortedSkelligeCards = new SortedList<>(skelligeCards, Comparator.comparingInt(Card::getID));
        SortedList<Card> sortedUserDeck = new SortedList<>(userDeck, Comparator.comparingInt(Card::getID));

        cardsListView.setItems(sortedSkelligeCards);
        cardsListView.setCellFactory(new CardListCellFactory());

        userDeckListView.setItems(sortedUserDeck);
        userDeckListView.setCellFactory(new CardListCellFactory());

        cardsListView.setOnMouseClicked(event -> {
            Card selectedCard = cardsListView.getSelectionModel().getSelectedItem();
            if (selectedCard != null) {
                userDeck.add(selectedCard);
                skelligeCards.remove(selectedCard);
                User.getLoggedInUser().addToDeck(selectedCard);
                updateLabels();
            }
        });

        userDeckListView.setOnMouseClicked(event -> {
            Card selectedCard = userDeckListView.getSelectionModel().getSelectedItem();
            if (selectedCard != null) {
                userDeck.remove(selectedCard);
                skelligeCards.add(selectedCard);
                User.getLoggedInUser().removeFromDeck(selectedCard);
                updateLabels();
            }
        });
    }
}
