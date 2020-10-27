package pl.coalatransport.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class MainCoalaTransportApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/fxml/mainContainer.fxml"));
        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
        stage.setTitle("Generator zleceń");
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args){
//        OrderEditor orderEditor = new OrderEditor();
//        orderEditor.edit("orderNumber", "10/10/2020");
//        orderEditor.edit("orderDate", "10.10.2020");
//        orderEditor.edit("cName", "FirmaDawid");
//        orderEditor.edit("cAddress", "Różana 58");
//        orderEditor.edit("cNip", "1111111111");
//        orderEditor.edit("cPostalAddress", "Owieczki 3030");
//        orderEditor.edit("cContactPerson", "Patrycja T");
//        orderEditor.edit("vPlates", "POB HH58");
//        orderEditor.edit("vType", "VAN");
//        orderEditor.edit("dName", "Józek Z Anglii");
//        orderEditor.edit("pPrice", "321123");
//        orderEditor.edit("pTerm", "50 dni");
//        orderEditor.edit("pCurrency", "EUR");
//        orderEditor.edit("cargo", "3ep");
//        orderEditor.edit("lTime", "11.10.2020 11:30");
//        orderEditor.edit("lName", "VW Piła");
//        orderEditor.edit("lAddress", "Piła ul. Staszica 33");
//        orderEditor.edit("uTime", "12.10.2020 11:30 fix");
//        orderEditor.edit("uName", "Magazyny W Gdyni");
//        orderEditor.edit("uAddress", "Gdynia ul. Owaka 1");
//        orderEditor.edit("lAdditionalInfo", "xd");
//        orderEditor.edit("uAdditionalInfo", "dx");
//        orderEditor.edit("person", "ADAM Z BOGDA");
//        orderEditor.edit("pNumber", "456789998");
//        orderEditor.edit("pMail", "malpa@malpa.mp");
//
//        orderEditor.saveDoc();
        launch(args);
    }



}
