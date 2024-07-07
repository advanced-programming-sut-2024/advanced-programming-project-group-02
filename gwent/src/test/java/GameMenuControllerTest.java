import controller.GameMenuController;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Game;
import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.mockito.Mockito.*;

public class GameMenuControllerTest extends ApplicationTest {

    private GameMenuController controller;
    private Game mockGame;

    @BeforeEach
    public void setUp() throws Exception {
        JFXPanel fxPanel = new JFXPanel();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/GameMenu.fxml"));
        Parent root = loader.load();
        controller = loader.getController();

        mockGame = mock(Game.class);
        User mockUser = mock(User.class);

        when(mockUser.getCurrentGame()).thenReturn(mockGame);

        User.setLoggedInUser(mockUser);

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
