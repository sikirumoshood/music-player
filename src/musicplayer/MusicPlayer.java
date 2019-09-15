/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Sikiru Moshood
 */
public class MusicPlayer extends Application {
    
   @Override
    public void start(Stage stage) throws Exception {
        Parent root;
            try{ 
                
                root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml")); Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
        
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
