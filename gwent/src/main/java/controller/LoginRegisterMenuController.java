package controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.User;
import view.LoginMenu;
import view.MainMenu;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginRegisterMenuController {
    public PasswordField password;
    public TextField username;

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

    private static Matcher getCommandMatcher(String input, String regex) {
        return (Pattern.compile(regex).matcher(input));
    }

    public static void showCommands() {
    }


    public void registerUser(Matcher matcher) {
        Scanner scanner = new Scanner(System.in);
        String username = this.username.getText();
        String password = this.password.getText();
        if (usersMap.containsKey(username)) {
            System.out.println("Username already exists. Please choose another.");
            return;
        } else if (!isPasswordWeak(password)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Security error");
            alert.setHeaderText("Your password is not strong!");
            alert.setContentText("You must use at least eight characters including upper and lower" +
                    " case letters, numbers and special characters.");
            alert.show();
        }

        usersMap.put(username, new User(username, password));
        System.out.println("User registered successfully.");
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

    public static void forgotPassword(Matcher matcher) {
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

    public static void questionHandler(Matcher matcher) {
    }
}