package pl.coalatransport.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class ControlSupport {

    NativePathExtractor nativePathExtractor = new NativePathExtractor();

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

    public String getSavePath(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(nativePathExtractor.extractDesktopPath()));
        fileChooser.setTitle("Zapisz plik");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("docx", "*.docx"),
                new FileChooser.ExtensionFilter("pdf", "*.pdf") //zaimplementowac konwerter docx->pdf
        );
        File file = fileChooser.showSaveDialog(new Stage());
        return file.getPath();
    }

}
