package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import model.Card;
import model.Faction;
import view.CardListCellFactory;

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

        for (Card card : Faction.getFactionByName("Skellige").getCards()) {
            for (int i = 0; i < card.getCountOfCard(); i++) {
                skelligeCards.add(card);
            }
        }

        cardsListView.setItems(skelligeCards);
        cardsListView.setCellFactory(new CardListCellFactory());

        userDeckListView.setItems(userDeck);
        userDeckListView.setCellFactory(new CardListCellFactory());

        cardsListView.setOnMouseClicked(event -> {
            Card selectedCard = cardsListView.getSelectionModel().getSelectedItem();
            if (selectedCard != null) {
                userDeck.add(selectedCard);
                skelligeCards.remove(selectedCard);
//                processMovingCardToDeck(selectedCard);
            }
        });

        userDeckListView.setOnMouseClicked(event -> {
            Card selectedCard = userDeckListView.getSelectionModel().getSelectedItem();
            if (selectedCard != null) {
                userDeck.remove(selectedCard);
                skelligeCards.add(selectedCard);
//                processMovingCardFromDeck(selectedCard);
            }
        });
    }

//    private void processMovingCardToDeck(Card card) {
//        System.out.println("Card moved to deck: " + card.getID());
//    }
//
//    // Example method for processing model changes when moving a card from the deck
//    private void processMovingCardFromDeck(Card card) {
//        // Implement your logic here to update model fields when a card is moved from the deck
//        System.out.println("Card moved from deck: " + card.getID());
//        // Example: Update user's deck count or any other relevant fields
//    }
}
