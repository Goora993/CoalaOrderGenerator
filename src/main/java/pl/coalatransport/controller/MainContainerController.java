package pl.coalatransport.controller;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class MainContainerController {

    @FXML
    private JFXButton carrierButton;

    @FXML
    private JFXButton clientButton;

    private static Stage mainContainerStage;
    CarrierOrderFormController carrierOrderFormController = new CarrierOrderFormController();
    ClientOrderFormController clientOrderFormController = new ClientOrderFormController();

    public static Stage getMainContainerStage() {
        return mainContainerStage;
    }

    public static void setMainContainerStage(Stage mainContainerStage) {
        MainContainerController.mainContainerStage = mainContainerStage;
    }

    private void closeAllWindows(){
        getMainContainerStage().setOnCloseRequest(windowEvent -> {

            if(carrierOrderFormController.stageStatus()){
                carrierOrderFormController.getStage().close();
            }

            if(clientOrderFormController.stageStatus()){
                clientOrderFormController.getStage().close();
            }

        });
    }

    public void initialize() {
        System.out.println(carrierOrderFormController.stageStatus());
        clientButton.setOnAction(actionEvent -> clientOrderFormController.getStage());
        carrierButton.setOnAction(actionEvent -> carrierOrderFormController.getStage());
        Platform.runLater(this::closeAllWindows);
    }
}
