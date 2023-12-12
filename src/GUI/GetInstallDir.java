package GUI;// This class handles the First Launch GUI to get the user's install directory
import Handlers.ConfigFileHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class GetInstallDir implements ActionListener{
    private ConfigFileHandler config = new ConfigFileHandler();
    private JLabel saveMessage;
    private JFrame frame;
    private JPanel panel;
    private JButton saveDir;
    private JLabel dirMessage;
    public GetInstallDir() throws IOException {
        frame = new JFrame("Fireseal - GGS Mod Loader"); // title


        JLabel l1 = new JLabel("Choose your Guilty Gear - Strive Install Directory:",SwingConstants.CENTER);
        String exampleDirString = "Windows:\nC://Program Files (x86)/Steam/steamapps/common/GUILTY GEAR STRIVE\n"+
                "Linux:\n/home/(user)/.steam/steam/steamapps/common/GUILTY GEAR STRIVE";
        String[] lines = exampleDirString.split("\n");

        /*
         * "Example:\n C://Program Files (x86)/Steam/steamapps/common/GUILTY GEAR STRIVE"+
         *                 "\n/home/.steam/steam/steamapps/common/GUILTY GEAR STRIVE"
         */

        saveDir = new JButton("Browse"); // get user file dir
        saveDir.addActionListener(this);
        saveMessage = new JLabel("");
        dirMessage = new JLabel("");

        // Add elements to JPanel instance
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(l1);
        panel.add(saveDir);
        for(String line : lines){ // iterate through string for examples and print to JPanel
            JLabel exampleDir = new JLabel(line,SwingConstants.CENTER);
            panel.add(exampleDir);
        }
        panel.add(saveMessage);
        panel.add(dirMessage);

        // display and set frame to user
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Fireseal - GGS Mod Loader");
        frame.pack();
        frame.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==saveDir){ // file browser
            JFileChooser fileBrowser = new JFileChooser();
            fileBrowser.setDialogTitle("Select Guilty Gear - Strive Install Directory");
            fileBrowser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int response = fileBrowser.showOpenDialog(null);
            fileBrowser.setAcceptAllFileFilterUsed(false);
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileBrowser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try {
                    config.setHasSelectedDir(true);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    config.setSavedDir(String.valueOf(file));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                saveMessage.setText("DIRECTORY HAS BEEN SELECTED!");
                dirMessage.setText("Selected dir: "+file);
            } else {
                saveMessage.setText("DIRECTORY SELECTION HAS BEEN CANCELED!");
            }
        }
    }
}
