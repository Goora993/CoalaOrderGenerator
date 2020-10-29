package pl.coalatransport.controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;


public class MainContainerController {

    @FXML
    private JFXButton carrierButton;

    @FXML
    private JFXButton clientButton;


    public void initialize(){
        clientButton.setOnAction(actionEvent -> {
            System.out.println(new ClientOrderFormController().getStage());
        });
        carrierButton.setOnAction(actionEvent -> new CarrierOrderFormController().getStage());
    }
}
