package fireseal;

import fireseal.Stages.MainMenu;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main Method for Fireseal application
 */
public class App extends Application {
    final double height = 600, width = 800;
    public void start(@SuppressWarnings("exports") Stage stage) {
        MainMenu mainMenu = new MainMenu(width, height);
        mainMenu.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}