package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.collections.FXCollections;
import javafx.scene.input.MouseEvent;
import model.User;
import view.ForgetPassword;
import view.LoginMenu;
import view.MainMenu;
import view.QuestionMenu;

import java.net.URL;
import java.util.ResourceBundle;

public class QuestionMenuController implements Initializable {

    @FXML
    private ComboBox<String> questionsComboBox;

    @FXML
    private TextField answerField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize ComboBox items
        questionsComboBox.setItems(FXCollections.observableArrayList(
                "What is your pet's name?",
                "What is your mother's maiden name?",
                "What was your first car?",
                "Where were you born?",
                "What is your favorite book?",
                "Who was your first employer?"
        ));
    }

    @FXML
    private void handleRegisterSubmit() {
        String selectedQuestion = questionsComboBox.getValue();
        String answer = answerField.getText();
        int answerNumber = 0;

        switch (answer) {
            case "What is your pet's name?":
                answerNumber = 1;
                break;
            case "What is your mother's maiden name?":
                answerNumber = 2;
                break;
            case "What was your first car?":
                answerNumber = 3;
                break;
            case "Where were you born?":
                answerNumber = 4;
                break;
            case "What is your favorite book?":
                answerNumber = 5;
                break;
            case "Who was your first employer?":
                answerNumber = 6;
                break;
        }

        if (selectedQuestion == null || selectedQuestion.isEmpty() || answer.isEmpty()) {
            showAlert("Error", "Please select a question and provide an answer.");
        } else {
            User user = User.getLoggedInUser();
            user.setSelectedQuestion(selectedQuestion);
            user.setAnswerNumber(answerNumber);
            user.setAnswer(answer);
            //go to main menu
            MainMenu mainMenu = new MainMenu();
            try {
                mainMenu.start(QuestionMenu.stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void backToLoginFromQuestionMenu(MouseEvent mouseEvent) {
        LoginMenu loginMenu = new LoginMenu();
        try {
            loginMenu.start(QuestionMenu.stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}