package pl.coalatransport.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class StageCreator {


    public Stage createNewStage(String windowUrl, String windowTitle, int windowHeight, int windowWidth, boolean isResizeable){
        Stage newStage = new Stage();

        try {
            Parent root = FXMLLoader.load(getClass().getResource(windowUrl));
            newStage.setTitle(windowTitle);
            newStage.setScene(new Scene(root, windowWidth, windowHeight));
            newStage.setResizable(isResizeable);
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return newStage;
    }

    public Stage createNewStage(String windowUrl, String iconUrl, String windowTitle, int windowHeight, int windowWidth, boolean isResizeable){
        Stage newStage = new Stage();

        try {
            Parent root = FXMLLoader.load(getClass().getResource(windowUrl));
            newStage.setTitle(windowTitle);
            newStage.setScene(new Scene(root, windowWidth, windowHeight));
            newStage.getIcons().add(new Image("file:"+iconUrl));
            newStage.setResizable(isResizeable);
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return newStage;
    }


}
