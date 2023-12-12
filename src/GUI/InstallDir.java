package GUI;

import Handlers.ConfigFileHandler;
import Handlers.GenerateModFolder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class InstallDir extends JFrame{
    private JButton browse;
    private JPanel panelMain;
    private JLabel l1;
    private JLabel windowsLabel;
    private JLabel l3;
    private JLabel linuxLabel;
    private JLabel linuxDirLabel;
    private JLabel selectMessage;
    private JLabel dirMessage;
    private JButton saveInstallDirectoryButton;
    private ConfigFileHandler config = new ConfigFileHandler();

    public InstallDir() throws IOException {
        setTitle("Fireseal - Choose your install directory");
        setContentPane(panelMain);
        setSize(600,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        browse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == browse) { // file browser
                    JFileChooser fileBrowser = new JFileChooser();
                    fileBrowser.setDialogTitle("Select Guilty Gear - Strive Install Directory");
                    fileBrowser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    int response = fileBrowser.showOpenDialog(null);
                    fileBrowser.setAcceptAllFileFilterUsed(false);
                    if (response == JFileChooser.APPROVE_OPTION) {
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
                        selectMessage.setText("DIRECTORY HAS BEEN SELECTED!");
                        dirMessage.setText("Selected dir: " + file);
                    }
                }
            }
        });
        saveInstallDirectoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==saveInstallDirectoryButton){
                    try {
                        new GenerateModFolder();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    System.out.println("debug");
                    dispose();
                }
            }
        });
    }
}
