package pl.coalatransport.app;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.coalatransport.controller.MainContainerController;
import pl.coalatransport.util.StageCreator;


public class MainCoalaTransportApp extends Application {

    private static final String APP_VERSION = "0.1.1";
    private final String WINDOW_URL = "/fxml/mainContainer.fxml";
    private final String ICON_URL = "koala.png";
    private final String WINDOW_TITLE = "Coalowy generator zleceń";
    private final int WINDOW_WIDTH = 400;
    private final int WINDOW_HEIGHT = 120;
    private final boolean IS_RESIZEABLE = false;


    @Override
    public void start(Stage stage) {
        MainContainerController.setMainContainerStage(new StageCreator().createNewStage
                (WINDOW_URL, ICON_URL, WINDOW_TITLE, WINDOW_HEIGHT, WINDOW_WIDTH, IS_RESIZEABLE));
//        MainContainerController.getMainContainerStage().setOnCloseRequest(windowEvent -> System.out.println("Window is closing"));
    }

    public static void main(String[] args){
        launch(args);
    }
}
