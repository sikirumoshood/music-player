/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayer;

import com.jfoenix.controls.JFXButton;
import java.io.File;
import static java.lang.System.console;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Window;

/**
 *
 * @author Sikiru Moshood
 */
public class FXMLDocumentController implements Initializable {
    
    private final FileChooser fileChooser = new FileChooser();
    private Media currentMusic = null;
    private MediaPlayer currentPlayer= null;
    private File currentFile = null;
    
    private Label label;
    @FXML
    private JFXButton fileBtn;
    @FXML
    private JFXButton playBtn;
    private JFXButton pauseBtn;
    @FXML
    private JFXButton stopBtn;
    @FXML
    private Label filenameLabel;
    @FXML
    private Label statusLabel;
    @FXML
    private Label statusLabel1;
    @FXML
    private Label durationLabel;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//       
    }    

    @FXML
    private void handleFileAction(ActionEvent event) {
       
        Node src = (Node) event.getSource();
        Window stageWindow = src.getScene().getWindow();
        fileChooser.setTitle("Select music file");
        File file = fileChooser.showOpenDialog(stageWindow);
        if(file != null)
        {
            filenameLabel.setText(file.getName());
            currentFile = file;
            playBtn.setDisable(false);
            
            
        }
    }

    @FXML
    private void handlePlayAction(ActionEvent event) {
        
        if(currentFile != null)
        {
             statusLabel.setText("Playing...");
                playBtn.setDisable(true);
                
                stopBtn.setDisable(false);
                playMusic(currentFile);
                fileBtn.setDisable(true);
        }
        else
        {
            statusLabel.setText("Please select a file...");
        }
       
    }

    @FXML
    private void handleStopAction(ActionEvent event) {
        if(currentFile != null)
        {
            statusLabel.setText("Stopped");
            playBtn.setDisable(false);
            currentPlayer.stop();
            fileBtn.setDisable(false);
        }
        else{
            
            statusLabel.setText("Please select a file...");
        }
    }
    private void playMusic(File file){
        Media music = new Media(file.toURI().toString());
        
        currentMusic = music;
        MediaPlayer musicPlayer = new MediaPlayer(music);
        currentPlayer = musicPlayer;
        musicPlayer.play();
        
        
        
        
    }
}
