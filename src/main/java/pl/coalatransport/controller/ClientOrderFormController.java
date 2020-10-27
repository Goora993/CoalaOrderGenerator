package pl.coalatransport.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import pl.coalatransport.model.OrderType;
import pl.coalatransport.util.OrderCreator;


public class ClientOrderFormController {

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
    private JFXTextField cNip;

    @FXML
    private JFXTextField cPostalAddress;

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


    OrderCreator orderCreator = new OrderCreator(OrderType.CLIENT);

    private void generateOrder(){
        orderCreator.generateOrder(cargo, orderNumber, orderDate, lTime, lName, lAddress, lAdditionalInfo,
                uTime, uName, uAddress, uAdditionalInfo, vPlates, vType, dName, cAddress, cName, cNip, cContactPerson,
                cPostalAddress, pPrice, pCurrency, pTerm, person, pNumber, pMail);
    }

    public void initialize(){
        generateButton.setOnAction(actionEvent -> generateOrder());
    }



}
