package fireseal.Stages;

import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.DirectoryChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DirSetup extends Stage {
    final double height = 200, width = 400;
    private File file;
    public DirSetup(Stage menu){
        this.setTitle("Fireseal - First Time Setup");

        // Labels w/ instructions
        Label l1 = new Label("Choose your Guilty Gear - Strive Install Directory:");
        Text t1 = new Text("Windows:\nC:/Program Files (x86)/Steam/steamapps/common/GUILTY GEAR STRIVE\n"+
        "Linux:\n/home/(user)/.steam/steam/steamapps/common/GUILTY GEAR STRIVE");
        t1.setTextAlignment(TextAlignment.CENTER);
        Text t2 = new Text("No Directory Selected.");

        // FileChooser
        DirectoryChooser dc = new DirectoryChooser();
        Button browse = new Button("Browse");
        Button saveDirButton = new Button("Save Dir");
        
        // Event Handlers
        browse.setOnAction(event -> {
            file = dc.showDialog(this);
            if(file != null){
                t2.setText(file.getAbsolutePath()+" selected.");
            }
        });
        saveDirButton.setOnAction(event -> {
            this.close();
        });
     
        VBox vb1 = new VBox(l1,t1); // contains labels w/ instructions
        vb1.setAlignment(Pos.CENTER);
        vb1.setPadding(new Insets(10));

        // set buttons and space them
        GridPane buttonGrid = new GridPane();
        buttonGrid.add(browse,0,0);
        buttonGrid.add(saveDirButton,1,0);
        buttonGrid.setPadding(new Insets(10));
        buttonGrid.setVgap(5);
        buttonGrid.setHgap(5);
        buttonGrid.setAlignment(Pos.CENTER);

        // set confirmation text on bottom of this
        VBox vb2 = new VBox(t2);
        vb2.setAlignment(Pos.BOTTOM_CENTER);
        vb2.setPadding(new Insets(20));

        // root vbox
        VBox rootVBox = new VBox(vb1,buttonGrid,vb2);
        rootVBox.setStyle("-fx-background-color: darkgray");
        
        //set modality (this makes it so the main menu window is inactive while choosing a directory)
        this.initOwner(menu);
        this.initModality(Modality.APPLICATION_MODAL);

        // Create scene and set on top
        Scene sc = new Scene(rootVBox,width,height);
        this.setScene(sc);
        this.isAlwaysOnTop();
    }
}
