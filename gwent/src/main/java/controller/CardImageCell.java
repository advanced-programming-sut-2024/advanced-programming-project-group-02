package controller;

import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Card;

public class CardImageCell extends ListCell<Card> {
    private ImageView imageView = new ImageView();

    @Override
    protected void updateItem(Card card, boolean empty) {
        super.updateItem(card, empty);
        if (empty || card == null) {
            setText(null);
            setGraphic(null);
        } else {
            Image cardImage = card.getImage();
            imageView.setImage(cardImage);
            imageView.setFitHeight(30);
            imageView.setFitWidth(20);
            setGraphic(imageView);
        }
    }
}
