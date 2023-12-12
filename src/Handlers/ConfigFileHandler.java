package Handlers;

import java.io.*;
import java.util.Properties;

public class ConfigFileHandler {
    private String HasSelectedDir;
    private String savedDir;
    public ConfigFileHandler() throws IOException {
        Properties prop = new Properties();
        FileInputStream ip = new FileInputStream("src/config.properties");
        prop.load(ip);
        ip.close();
        HasSelectedDir = prop.getProperty("selected");
        savedDir = prop.getProperty("savedDir");
    }
    public boolean getHasSelectedDir(){return HasSelectedDir.equalsIgnoreCase("true");}
    public void setHasSelectedDir(Boolean selected) throws IOException {
        Properties prop = new Properties();
        FileInputStream ip = new FileInputStream("src/config.properties");
        prop.load(ip);
        ip.close();
        FileOutputStream op = new FileOutputStream("src/config.properties");
        prop.put("selected", String.valueOf(selected));
        prop.store(op,"Properties File");
        op.close();
    }
    public String getSavedDir(){return savedDir;}
    public void setSavedDir(String setDir) throws IOException {
        Properties prop = new Properties();
        FileInputStream ip = new FileInputStream("src/config.properties");
        prop.load(ip);
        ip.close();
        FileOutputStream op = new FileOutputStream("src/config.properties");
        prop.put("savedDir",setDir);
        prop.store(op,"Properties File");
        op.close();
    }
}
