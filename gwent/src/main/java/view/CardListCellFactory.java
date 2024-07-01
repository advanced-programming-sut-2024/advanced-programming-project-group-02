package view;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import model.Card;

public class CardListCellFactory implements Callback<ListView<Card>, ListCell<Card>> {

    @Override
    public ListCell<Card> call(ListView<Card> param) {
        return new ListCell<>() {
            private final ImageView imageView = new ImageView();

            @Override
            protected void updateItem(Card card, boolean empty) {
                super.updateItem(card, empty);

                if (empty || card == null) {
                    setGraphic(null);
                } else {
                    imageView.setImage(card.getImage());
                    imageView.setFitHeight(410);
                    imageView.setFitWidth(217);
                    setGraphic(imageView);
                }
            }
        };
    }
}

