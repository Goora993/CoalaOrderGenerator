package pl.coalatransport.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import pl.coalatransport.model.OrderType;
import pl.coalatransport.util.ControlSupport;
import pl.coalatransport.util.OrderEditor;

public class CarrierOrderFormController {

    @FXML
    private HBox contentHBox;

    @FXML
    private JFXTextField orderNumber;

    @FXML
    private JFXTextField orderDate;

    @FXML
    private JFXTextField lTime;

    @FXML
    private JFXTextField lName;

    @FXML
    private JFXTextField lAddress;

    @FXML
    private JFXTextField lAdditionalInfo;

    @FXML
    private JFXTextField uTime;

    @FXML
    private JFXTextField uName;

    @FXML
    private JFXTextField uAddress;

    @FXML
    private JFXTextField uAdditionalInfo;

    @FXML
    private JFXTextArea cargo;

    @FXML
    private JFXTextField vPlates;

    @FXML
    private JFXTextField vType;

    @FXML
    private JFXTextField dName;

    @FXML
    private JFXTextField cName;

    @FXML
    private JFXTextField cAddress;

    @FXML
    private JFXTextField cContactPerson;

    @FXML
    private JFXTextField pPrice;

    @FXML
    private JFXTextField pTerm;

    @FXML
    private JFXTextField pCurrency;

    @FXML
    private JFXTextField person;

    @FXML
    private JFXTextField pNumber;

    @FXML
    private JFXTextField pMail;

    @FXML
    private JFXButton generateButton;

    OrderEditor orderEditor = new OrderEditor(OrderType.CARRIER);
    ControlSupport controlSupport = new ControlSupport();

    private void generateNewOrder(String path) {
        orderEditor.edit(orderNumber.getId(), orderNumber.getText());
        orderEditor.edit(orderDate.getId(), orderDate.getText());
        orderEditor.edit(lTime.getId(), lTime.getText());
        orderEditor.edit(lName.getId(), lName.getText());
        orderEditor.edit(lAddress.getId(), lAddress.getText());
        orderEditor.edit(lAdditionalInfo.getId(), lAdditionalInfo.getText());
        orderEditor.edit(uTime.getId(), uTime.getText());
        orderEditor.edit(uName.getId(), uName.getText());
        orderEditor.edit(uAddress.getId(), uAddress.getText());
        orderEditor.edit(uAdditionalInfo.getId(), uAdditionalInfo.getText());
        orderEditor.edit(cargo.getId(), cargo.getText());
        orderEditor.edit(vPlates.getId(), vPlates.getText());
        orderEditor.edit(vType.getId(), vType.getText());
        orderEditor.edit(dName.getId(), dName.getText());
        orderEditor.edit(cName.getId(), cName.getText());
        orderEditor.edit(cAddress.getId(), cAddress.getText());
        orderEditor.edit(cContactPerson.getId(), cContactPerson.getText());
        orderEditor.edit(pPrice.getId(), pPrice.getText());
        orderEditor.edit(pTerm.getId(), pTerm.getText());
        orderEditor.edit(pCurrency.getId(), pCurrency.getText());
        orderEditor.edit(person.getId(), person.getText());
        orderEditor.edit(pNumber.getId(), pNumber.getText());
        orderEditor.edit(pMail.getId(), pMail.getText());
        orderEditor.saveDoc(path);
    }

    public void initialize(){
        generateButton.setOnAction(actionEvent -> {
            generateNewOrder(controlSupport.getSavePath());
        });
    }

}
