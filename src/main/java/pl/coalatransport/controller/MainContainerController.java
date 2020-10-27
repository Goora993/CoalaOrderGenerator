package pl.coalatransport.controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import pl.coalatransport.util.NewWindowCreator;


public class MainContainerController {



    @FXML
    private JFXButton carrierButton;

    @FXML
    private JFXButton clientButton;

    NewWindowCreator newWindowCreator = new NewWindowCreator();

    public void initialize(){
        clientButton.setOnAction(actionEvent -> newWindowCreator.openNewWindow("/fxml/clientOrderForm.fxml",
                "Zlecenie dla klienta", 750, 600, false));
        carrierButton.setOnAction(actionEvent -> newWindowCreator.openNewWindow("/fxml/carrierOrderForm.fxml",
                "Zlecenie dla przewoźnika", 750, 600, false));
    }
}
