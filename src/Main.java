
import GUI.InstallDir;
import Handlers.ConfigFileHandler;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // check if user has set their directory
        ConfigFileHandler config = new ConfigFileHandler();
        System.out.println(config.getSavedDir());
        if(config.getHasSelectedDir()){
            new InstallDir();
        }
    }
}