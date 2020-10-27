package pl.coalatransport.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NewWindowCreator {


    public Stage openNewWindow(String windowUrl, String windowTitle, int windowHeight, int windowWidth, boolean isResizeable){
        Stage newWindow = new Stage();

        try {
            Parent root = FXMLLoader.load(getClass().getResource(windowUrl));
            newWindow.setTitle(windowTitle);
            newWindow.setScene(new Scene(root, windowWidth, windowHeight));
            newWindow.setResizable(isResizeable);
            newWindow.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return newWindow;
    }


}
