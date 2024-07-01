package controller;

import com.google.gson.Gson;
import javafx.fxml.FXML;
import com.google.gson.reflect.TypeToken;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import model.User;
import view.*;

import java.io.*;
import java.lang.reflect.Type;
import java.security.SecureRandom;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginRegisterMenuController {
    // handle login and register and forgetPassword
    //login
    @FXML
    public PasswordField loginPassword;
    @FXML
    public TextField loginUsername;
    //register
    @FXML
    public PasswordField password;
    @FXML
    public PasswordField passwordConfirm;
    @FXML
    public TextField username;
    @FXML
    public TextField nickname;
    @FXML
    public TextField email;
    @FXML
    public TextField answer;

    //forgetPassword
    @FXML
    public TextField usernameForget;
    @FXML
    public PasswordField passwordForget;
    @FXML
    public TextField answerForget;

    //Json files :

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
    //generate pass
    boolean showAlertConfirmed = false;
    public String generatedPassword = "#";


    @FXML


    private static Matcher getCommandMatcher(String input, String regex) {
        return (Pattern.compile(regex).matcher(input));
    }


    public void registerUser(MouseEvent mouseEvent) {
        String usernameText = this.username.getText();
        String passwordText = this.password.getText();
        String emailText = this.email.getText();
        String nicknameText = this.nickname.getText();
        if (usersMap.containsKey(usernameText) && usersMap.size() != 0) {
            showAlert("Invalid username", "This username has already been used");
        } else if (!isUsableUsername(usernameText)) {
            System.out.println(usernameText);
            showAlert("Invalid username", "Your username can only contain uppercase and lowercase letters, numbers or the dash character");
        } else if (!isPasswordWeak(passwordText)) {
            showAlert("Security error", "Your password is not strong! You must use at least eight characters including upper and lower" +
                    " case letters, numbers and special characters.");
        } else if (!isValidEmailAddress(emailText)) {
            showAlert("Invalid email", "The email entered is invalid.");
        } else if (!passwordText.equals(this.passwordConfirm.getText())) {
            showAlert("Wrong password!", "Your password was not confirmed! Please enter your password correctly for confirm password.");
        } else {
            User user = new User(usernameText, passwordText, emailText, nicknameText);
            User.addToUsers(user);
            User.setLoggedInUser(user);
            System.out.println("User registered successfully.");
            if (!generatedPassword.equals("#")) {
                user.setPassword(generatedPassword);
            }
            goToQuestionMenu();
        }
        email.clear();
        username.clear();
        password.clear();
        nickname.clear();
        passwordConfirm.clear();
    }

    public void loginUser(MouseEvent mouseEvent) {
        String loginUsernameText = this.loginUsername.getText();
        String loginPasswordText = this.loginPassword.getText();
        if (!Objects.requireNonNull(User.getUserWithName(loginUsernameText)).getPassword().equals(password)) {
            showAlert("Wrong password!", "Please enter your password correctly");
        } else if (User.isThereUserWithName(loginUsernameText)) {
            showAlert("username not found!", "Please enter your username correctly");
        } else if (loginPasswordText != null && loginUsernameText != null) {
            System.out.println("User logged in successfully.");
            User user = User.getUserWithName(loginUsernameText);
            User.setLoggedInUser(user);
            MainMenu mainMenu = new MainMenu();
            try {
                mainMenu.start(LoginMenu.stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        loginPassword.clear();
        loginUsername.clear();
    }

    public static void loadUsers() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            for (Map.Entry<String, User> entry : usersMap.entrySet()) {
                User value = entry.getValue();
                User.addToUsers(value);
            }
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
        ArrayList<User> users = User.getUsers();
        try (Writer writer = new FileWriter(FILE_PATH)) {
            for (User user : users) {
                usersMap.put(user.getUsername(), new User(user.getUsername(), user.getPassword(), user.getEmail(), user.getNickname()));
            }
            gson.toJson(usersMap, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void forgetPassword(MouseEvent mouseEvent) {
        String usernameForgetText = this.usernameForget.getText();
        User user = User.getUserWithName(usernameForgetText);
        String newPasswordForgetText = this.passwordForget.getText();
        String mainAnswer = user.getAnswer();
        String enteredAnswerText = this.answerForget.getText();
        if (user == null) {
            showAlert("username not found!", "Please register first.");
        } else if (usersMap.containsKey(usernameForgetText) && newPasswordForgetText != null) {
            showAlert("Invalid username!", "This username not fond.");
        } else if (!enteredAnswerText.equals(mainAnswer)) {
            showAlert("Wrong Answer!", "Please enter your correct answer");
        } else if ((enteredAnswerText.equals(mainAnswer)) && newPasswordForgetText != null && enteredAnswerText != null) {
            user.setPassword(newPasswordForgetText);
            showAlert("password recovery", "Your password has been changed.");
            goToMainMenu();
        }
        usernameForget.clear();
        passwordForget.clear();
        answerForget.clear();
    }

    public static boolean isPasswordWeak(String password) {
        String checkStrong = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z]).*";
        if (getCommandMatcher(password, checkStrong).matches()) {
            return true;
        }
        return false;
    }

    //go to another menus in 4 method
    public void goToRegisterMenu(MouseEvent mouseEvent) {
        RegisterMenu registerMenu = new RegisterMenu();
        try {
            registerMenu.start(LoginMenu.stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToQuestionMenu() {
        QuestionMenu questionMenu = new QuestionMenu();
        try {
            questionMenu.start(RegisterMenu.stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToForgetPasswordPage(MouseEvent mouseEvent) {
        ForgetPassword forgetPassword = new ForgetPassword();
        try {
            forgetPassword.start(LoginMenu.stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToMainMenu() {
        MainMenu mainMenu = new MainMenu();
        try {
            mainMenu.start(ForgetPassword.stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void backToLoginFromRegisterMenu(MouseEvent mouseEvent) {
        LoginMenu loginMenu = new LoginMenu();
        try {
            loginMenu.start(RegisterMenu.stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void backToLoginFromForgetPasswordMenu(MouseEvent mouseEvent) {
        LoginMenu loginMenu = new LoginMenu();
        try {
            loginMenu.start(ForgetPassword.stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static boolean isValidEmailAddress(String email) {
        String checkEmail = "^(.+)@(\\S+)\\.com$";
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

    public void questionHandler(MouseEvent mouseEvent) {
    }


    // get random password in two method
    public void generateRandomPassword(MouseEvent mouseEvent) {
        String allCharacters = UPPERCASE + LOWERCASE + DIGITS + SPECIAL_CHARACTERS;
        StringBuilder password = new StringBuilder();
        password.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
        password.append(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));
        for (int i = 4; i < MIN_PASSWORD_LENGTH; i++) {
            password.append(allCharacters.charAt(random.nextInt(allCharacters.length())));
        }
        String randomPassword = shuffleString(password.toString());
        boolean OkPassword = showAlertConfirmed("Suggested password", randomPassword);
        if (OkPassword) {
            generatedPassword = randomPassword;
        }
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

    private static void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }

    private boolean showAlertConfirmed(String title, String message) {
        if (showAlertConfirmed) {
            return true;
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.isPresent() && buttonType.get().equals(ButtonType.OK)) {
            showAlertConfirmed = true;
            return true;
        }
        return false;
    }
}
