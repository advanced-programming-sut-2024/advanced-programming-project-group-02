package controller;

import com.google.gson.Gson;
import javafx.fxml.FXML;
import com.google.gson.reflect.TypeToken;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.User;
import view.LoginMenu;
import view.MainMenu;
import view.RegisterMenu;

import java.io.*;
import java.lang.reflect.Type;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.FormattableFlags.UPPERCASE;

public class LoginRegisterMenuController {
    //    private static final int LOWERCASE = 0;
    @FXML
    public PasswordField password;
    @FXML
    public PasswordField passwordConfirm;
    @FXML
    public TextField username;
    @FXML
    public TextField email;

    public PasswordField getPassword() {
        return password;
    }

    public void setPassword(PasswordField password) {
        this.password = password;
    }

    public TextField getUsername() {
        return username;
    }

    public void setUsername(TextField username) {
        this.username = username;
    }

    private static Map<String, User> usersMap = new HashMap<>();
    private static final String FILE_PATH = "users.json";
    private static final Gson gson = new Gson();

    //in ha movaghate -> 6 line payyin
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?";

    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final SecureRandom random = new SecureRandom();

    @FXML


    private static Matcher getCommandMatcher(String input, String regex) {
        return (Pattern.compile(regex).matcher(input));
    }


    public void registerUser(MouseEvent mouseEvent) {
        String username = this.username.getText();
        String password = this.password.getText();
        String email = this.email.getText();
        if (usersMap.containsKey(username) && password != null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid username");
            alert.setHeaderText("Invalid username");
            alert.setContentText("This username has already been used");
            alert.show();
        } else if (!isUsableUsername(username)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid username");
            alert.setHeaderText("Invalid username");
            alert.setContentText("Your username can only contain uppercase and lowercase letters, numbers or the dash character");
            alert.show();
        } else if (!isPasswordWeak(password)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Security error");
            alert.setHeaderText("Your password is not strong!");
            alert.setContentText("You must use at least eight characters including upper and lower" +
                    " case letters, numbers and special characters.");
            alert.show();
        } else if (!isValidEmailAddress(email)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid email");
            alert.setHeaderText("Invalid email");
            alert.setContentText("The email entered is invalid.");
            alert.show();
        } else if (!password.equals(this.passwordConfirm.getText())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Wrong password!");
            alert.setHeaderText("Your password was not confirmed!");
            alert.setContentText("Please enter your password correctly for confirm password.");
            alert.show();
        } else {
            usersMap.put(username, new User(username, password));
            System.out.println("User registered successfully.");
        }
    }

    public void loginUser(MouseEvent mouseEvent) {
        if (User.getUserWithName(this.username.getText()) == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Wrong username!");
            alert.setHeaderText("username not found!");
            alert.setContentText("Please enter your username correctly");
            alert.show();
        } else if (!User.getUserWithName(this.username.getText()).getPassword().equals(this.password.getText())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Wrong password!");
            alert.setHeaderText("Wrong password!");
            alert.setContentText("Please enter your password correctly");
            alert.show();
        } else if (this.password.getText() != null && this.username.getText() != null) {
            System.out.println("User logged in successfully.");
            User user = User.getUserWithName(this.username.getText());
            User.setLoggedInUser(user);
            MainMenu mainMenu = new MainMenu();
            try {
                mainMenu.start(LoginMenu.stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void loadUsers() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type userType = new TypeToken<Map<String, User>>() {
            }.getType();
            usersMap = gson.fromJson(reader, userType);
            if (usersMap == null) {
                usersMap = new HashMap<>();
            }
        } catch (FileNotFoundException e) {
            System.out.println("No previous user data found. Starting fresh.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveUsers() {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(usersMap, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void forgotPassword(MouseEvent mouseEvent) {

    }

    public static boolean isPasswordWeak(String password) {
        String checkStrong = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z]).*";
        if (getCommandMatcher(password, checkStrong).matches()) {
            return true;
        }
        return false;
    }

    public static void getRandomPassword() {

    }

    public void goToRegisterMenu(MouseEvent mouseEvent) {
        RegisterMenu registerMenu = new RegisterMenu();
        try {
            registerMenu.start(LoginMenu.stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isValidEmailAddress(String email) {
        String checkEmail = "^(.+)@(\\S+)$";
        if (getCommandMatcher(email, checkEmail).matches()) {
            return true;
        }
        return false;
    }

    public static boolean isUsableUsername(String username) {
        String checkUsable = "(\\d)?[A-Z]?[a-z]?(-)?";
        if (getCommandMatcher(username, checkUsable).matches()) {
            return true;
        }
        return false;
    }

    private void goToQuestionsMenu() {   // not statement
        try {
            Parent questions = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/Questions.fxml")));
            Stage stage = (Stage) username.getScene().getWindow();
            stage.setScene(new Scene(questions));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void questionHandler(MouseEvent mouseEvent) {
    }


    // in do ta method baraye passwoord random ke naghese
    private static String generateRandomPassword() {
        String allCharacters = UPPERCASE + LOWERCASE + DIGITS + SPECIAL_CHARACTERS;
        StringBuilder password = new StringBuilder();
        password.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
        password.append(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));
        for (int i = 4; i < MIN_PASSWORD_LENGTH; i++) {
            password.append(allCharacters.charAt(random.nextInt(allCharacters.length())));
        }
        return shuffleString(password.toString());
    }

    private static String shuffleString(String input) {
        char[] characters = input.toCharArray();
        for (int i = characters.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = characters[i];
            characters[i] = characters[j];
            characters[j] = temp;
        }
        return new String(characters);
    }
}
