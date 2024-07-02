package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.EachPlayerGame;
import model.Faction;
import model.Game;
import model.User;
import view.*;

import java.sql.Date;
import java.util.Optional;

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
    protected Button startGame;
    @FXML
    protected Button goToMainMenu;

    @FXML
    protected ChoiceBox<String> factionChoiceBox;

    @FXML
    protected void initialize() {
        factionChoiceBox.getItems().addAll("Skellige", "Scoia'tael", "Northern Realms", "Nilfgaard", "Monsters");
        factionChoiceBox.setValue(User.getLoggedInUser().getFaction().getName());
        factionChoiceBox.setOnAction(this::chooseFaction);

        updateLabels();
        initializeController();

        startGame.setOnAction(this::handleStartGame);
        goToMainMenu.setOnAction(this::handleGoToMainMenu);
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
            User.getLoggedInUser().clearDeck();
            switch (faction) {
                case "Skellige":
                    User.getLoggedInUser().setFaction(Faction.getFactionByName("Skellige"));
                    User.getLoggedInUser().setLeaderCard(User.getLoggedInUser().getFaction().getLeaderCArdByID(11));
                    PregameMenuS pregameMenuS = new PregameMenuS();
                    pregameMenuS.start(stage);
                    break;
                case "Scoia'tael":
                    User.getLoggedInUser().setFaction(Faction.getFactionByName("Scoia'tael"));
                    User.getLoggedInUser().setLeaderCard(User.getLoggedInUser().getFaction().getLeaderCArdByID(21));
                    PregameMenuSc pregameMenuSc = new PregameMenuSc();
                    pregameMenuSc.start(stage);
                    break;
                case "Northern Realms":
                    User.getLoggedInUser().setFaction(Faction.getFactionByName("Northern Realms"));
                    User.getLoggedInUser().setLeaderCard(User.getLoggedInUser().getFaction().getLeaderCArdByID(31));
                    PregameMenuNR pregameMenuNR = new PregameMenuNR();
                    pregameMenuNR.start(stage);
                    break;
                case "Nilfgaard":
                    User.getLoggedInUser().setFaction(Faction.getFactionByName("Nilfgaard"));
                    User.getLoggedInUser().setLeaderCard(User.getLoggedInUser().getFaction().getLeaderCArdByID(41));
                    PregameMenuN pregameMenuN = new PregameMenuN();
                    pregameMenuN.start(stage);
                    break;
                case "Monsters":
                    User.getLoggedInUser().setFaction(Faction.getFactionByName("Monsters"));
                    User.getLoggedInUser().setLeaderCard(User.getLoggedInUser().getFaction().getLeaderCArdByID(51));
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

    @FXML
    private void handleStartGame(ActionEvent event) {
        User user = User.getLoggedInUser();
        if (user.getNumberOfUnitCards() < 22) {
            showAlert("Insufficient Unit Cards", "You need at least 22 unit cards to start the game.");
            return;
        }

        if (user.getCurrentGame() != null) {
            startGame();
            return;
        }

        String secondPlayerName = promptSecondPlayerUsername();
        if (secondPlayerName == null) {
            return;
        }

        if (secondPlayerName.equals(user.getUsername())) {
            showAlert("Invalid Username", "You cannot play with yourself. Please enter a different username.");
            return;
        }

        if (!User.isThereUserWithName(secondPlayerName)) {
            showAlert("Username Not Found", "The username '" + secondPlayerName + "' does not exist. Please logout and ask your friend to register.");
        } else {
            promptSecondPlayerLogin(User.getUserWithName(secondPlayerName));
        }
    }

    @FXML
    private void handleGoToMainMenu(ActionEvent event){
        goToMainMenu();
    }

    private void goToMainMenu() {
        MainMenu mainMenu = new MainMenu();
        Stage stage = (Stage) goToMainMenu.getScene().getWindow();
        try {
            mainMenu.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void promptSecondPlayerLogin(User secondUser) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Second Player Login");
        dialog.setHeaderText("Enter Password for " + secondUser.getUsername());
        dialog.setContentText("Password:");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        dialog.getEditor().setVisible(false);
        dialog.getDialogPane().setContent(passwordField);

        dialog.showAndWait().ifPresent(password -> {
            if (secondUser.getPassword().equals(passwordField.getText())) {
                User firstUser = User.getLoggedInUser();
                EachPlayerGame eachPlayerGame1 = new EachPlayerGame(firstUser.getDeck(), User.getLoggedInUser());
                EachPlayerGame eachPlayerGame2 = new EachPlayerGame(secondUser.getDeck(), secondUser);
                Game game = new Game(firstUser, secondUser, eachPlayerGame1, eachPlayerGame2);
                firstUser.setCurrentGame(game);
                secondUser.setCurrentGame(game);
                User.setLoggedInUser(secondUser);
                goToMainMenu();
            } else {
                showAlert("Incorrect Password", "The password entered is incorrect. Please try again.");
            }
        });
    }

    private String promptSecondPlayerUsername() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Second Player Username");
        dialog.setHeaderText("Enter the username of another player");
        dialog.setContentText("Username:");

        Optional<String> result = dialog.showAndWait();
        return result.orElse(null);
    }


    private void startGame() {
        System.out.println("HEHEHEHEHEHEH");
    }
}
