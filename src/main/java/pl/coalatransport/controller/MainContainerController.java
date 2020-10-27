package pl.coalatransport.controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import pl.coalatransport.util.ControlSupport;


public class MainContainerController {



    @FXML
    private JFXButton carrierButton;

    @FXML
    private JFXButton clientButton;

    ControlSupport controlSupport = new ControlSupport();

    public void initialize(){
        clientButton.setOnAction(actionEvent -> controlSupport.openNewWindow("/fxml/clientOrderForm.fxml",
                "Zlecenie dla klienta", 750, 600, false));
        carrierButton.setOnAction(actionEvent -> controlSupport.openNewWindow("/fxml/carrierOrderForm.fxml",
                "Zlecenie dla przewoźnika", 750, 600, false));
    }
}
