package fireseal.Stages;

import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenu extends Stage{
    public MainMenu(double width, double height){
        this.setTitle("Fireseal");

        // create menus
        MenuBar mb = new MenuBar();
        BorderPane bp = new BorderPane();
        bp.setTop(mb);

        // file menu
        Menu fileMenu = new Menu("File");
        MenuItem firstTimeSetup = new MenuItem("First Time Setup");
        MenuItem exitItem = new MenuItem("Exit Fireseal");
        fileMenu.getItems().addAll(firstTimeSetup,exitItem);

        // help menu
        Menu helpMenu = new Menu("Help");
        mb.getMenus().addAll(fileMenu,helpMenu);
        MenuItem githubRef = new MenuItem("Github");
        helpMenu.getItems().addAll(githubRef);

        // Event Handlers
        firstTimeSetup.setOnAction(event -> {
            DirSetup dirSetup = new DirSetup(this);
            dirSetup.showAndWait(); // makes main menu frozen while choosing directory
        });
        exitItem.setOnAction(event -> {
            this.close();
        });
        githubRef.setOnAction(event -> {
            //this.getHostServices().showDocument("https://github.com/allylavanda/Fireseal");
        });

        // root vbox
        VBox rootVBox = new VBox(bp);
        rootVBox.setStyle("-fx-background-color: darkgray");

        // Create scene and show stage
        Scene sc = new Scene(rootVBox,width,height);
        this.setScene(sc);
    }

}
