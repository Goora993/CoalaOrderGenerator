package pl.coalatransport.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import pl.coalatransport.model.OrderType;
import pl.coalatransport.util.StageCreator;
import pl.coalatransport.util.OrderCreator;


public class ClientOrderFormController {

    @FXML
    private ScrollPane sp;

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

    private final String WINDOW_URL = "/fxml/clientOrderForm.fxml";
    private final String ICON_URL = "koala.png";
    private final String WINDOW_TITLE = "Zlecenie dla klienta";
    private final int WINDOW_WIDTH = 600;
    private final int WINDOW_HEIGHT = 750;
    private final boolean IS_RESIZEABLE = false;

    OrderCreator orderCreator = new OrderCreator(OrderType.CLIENT);
    StageCreator stageCreator = new StageCreator();

    private static Stage stage;

    private void generateOrder(){
        orderCreator.generateOrder(cargo, orderNumber, orderDate, lTime, lName, lAddress, lAdditionalInfo,
                uTime, uName, uAddress, uAdditionalInfo, vPlates, vType, dName, cAddress, cName, cNip, cContactPerson,
                cPostalAddress, pPrice, pCurrency, pTerm, person, pNumber, pMail);
    }

    public Stage getStage() {
        //if(stage==null)
            stage = stageCreator.createNewStage(WINDOW_URL, ICON_URL, WINDOW_TITLE, WINDOW_HEIGHT, WINDOW_WIDTH, IS_RESIZEABLE);

        return stage;
    }

    public void sharpTextArea(){
        sp = (ScrollPane)cargo.getChildrenUnmodifiable().get(0);
        for (Node n : sp.getChildrenUnmodifiable()) {
            n.setCache(false);
        }
    }

    public void initialize(){
        Platform.runLater(this::sharpTextArea);
        generateButton.setOnAction(actionEvent ->{
            generateOrder();
            stage.close();
        } );
    }



}
