package pl.coalatransport.app;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.coalatransport.util.StageCreator;


public class MainCoalaTransportApp extends Application {

    private final String WINDOW_URL = "/fxml/mainContainer.fxml";
    private final String ICON_URL = "koala.png";
    private final String WINDOW_TITLE = "Coalowy generator zleceń";
    private final int WINDOW_WIDTH = 400;
    private final int WINDOW_HEIGHT = 120;
    private final boolean IS_RESIZEABLE = false;

    @Override
    public void start(Stage stage) throws Exception {
        Stage mainStage = new StageCreator().createNewStage
                (WINDOW_URL, ICON_URL, WINDOW_TITLE, WINDOW_HEIGHT, WINDOW_WIDTH, IS_RESIZEABLE);
    }

    public static void main(String[] args){
        launch(args);
    }



}
