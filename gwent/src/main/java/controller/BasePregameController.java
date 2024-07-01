package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Card;
import model.Faction;
import model.User;
import view.*;

public abstract class BasePregameController {
    @FXML
    protected Label totalCardsInDeck;
    @FXML
    protected Label numberOfUnitCards;
    @FXML
    protected Label specialCards;
    @FXML
    protected Label heroCards;
    @FXML
    protected Button downloadDeck;
    @FXML
    protected Button uploadDeck;
    @FXML
    protected Label totalUnitCardsStrength;

    @FXML
    protected ChoiceBox<String> factionChoiceBox;

    @FXML
    protected void initialize() {
        factionChoiceBox.getItems().addAll("Skellige", "Scoia'tael", "Northern Realms", "Nilfgaard", "Monsters");
        factionChoiceBox.setValue(User.getLoggedInUser().getFaction().getName());
        factionChoiceBox.setOnAction(this::chooseFaction);

        updateLabels();
        initializeController();
    }

    @FXML
    protected void chooseFaction(ActionEvent event) {
        String selectedFaction = factionChoiceBox.getValue();
        Stage stage = (Stage) factionChoiceBox.getScene().getWindow();

        try {
            loadFaction(selectedFaction, stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void loadFaction(String faction, Stage stage) throws Exception {
        String currentFactionName = User.getLoggedInUser().getFaction().getName();
        if (!currentFactionName.equals(faction)) {
            switch (faction) {
                case "Skellige":
                    User.getLoggedInUser().setFaction(Faction.getFactionByName("Skellige"));
                    PregameMenuS pregameMenuS = new PregameMenuS();
                    pregameMenuS.start(stage);
                    break;
                case "Scoia'tael":
                    User.getLoggedInUser().setFaction(Faction.getFactionByName("Scoia'tael"));
                    PregameMenuSc pregameMenuSc = new PregameMenuSc();
                    pregameMenuSc.start(stage);
                    break;
                case "Northern Realms":
                    User.getLoggedInUser().setFaction(Faction.getFactionByName("Northern Realms"));
                    PregameMenuNR pregameMenuNR = new PregameMenuNR();
                    pregameMenuNR.start(stage);
                    break;
                case "Nilfgaard":
                    User.getLoggedInUser().setFaction(Faction.getFactionByName("Nilfgaard"));
                    PregameMenuN pregameMenuN = new PregameMenuN();
                    pregameMenuN.start(stage);
                    break;
                case "Monsters":
                    User.getLoggedInUser().setFaction(Faction.getFactionByName("Monsters"));
                    PregameMenuM pregameMenuM = new PregameMenuM();
                    pregameMenuM.start(stage);
                    break;
                default:
                    return;
            }
        }
    }

    protected void updateLabels() {
        User user = User.getLoggedInUser();
        totalCardsInDeck.setText(String.valueOf(user.getTotalCardsInDeck()));
        numberOfUnitCards.setText(String.valueOf(user.getNumberOfUnitCards()));
        specialCards.setText(String.valueOf(user.getSpecialCards()));
        heroCards.setText(String.valueOf(user.getHeroCards()));
        totalUnitCardsStrength.setText(String.valueOf(user.getTotalUnitCardsStrength()));
    }

    protected abstract void initializeController();

    protected void processMovingCardToDeck(Card card) {

    }
}
