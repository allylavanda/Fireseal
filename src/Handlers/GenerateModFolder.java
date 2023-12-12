package Handlers;

import java.io.File;
import java.io.IOException;

public class GenerateModFolder {
    public GenerateModFolder() throws IOException {
        ConfigFileHandler config = new ConfigFileHandler();
        String workingDir = config.getSavedDir()+"/Red/Content/Paks/~mods";
        File modDir = new File(workingDir);
        modDir.mkdirs();
        if (modDir.exists()){
            System.out.println("Directory has been created.");
        }
    }
}
