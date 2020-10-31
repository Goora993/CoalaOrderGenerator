package pl.coalatransport.controller;

import com.jfoenix.controls.JFXButton;
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
    private Stage carrierOrderFormStage;
    private Stage clientOrderFormStage;

    public static Stage getMainContainerStage() {
        return mainContainerStage;
    }

    public static void setMainContainerStage(Stage mainContainerStage) {
        MainContainerController.mainContainerStage = mainContainerStage;
    }



    public void initialize() {
        clientButton.setOnAction(actionEvent -> clientOrderFormStage = new ClientOrderFormController().getStage());
        carrierButton.setOnAction(actionEvent -> carrierOrderFormStage = new CarrierOrderFormController().getStage());
    }
}
