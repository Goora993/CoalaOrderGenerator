package pl.coalatransport.util;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.*;
import pl.coalatransport.model.CarrierOrder;
import pl.coalatransport.model.ClientOrder;
import pl.coalatransport.model.Order;
import pl.coalatransport.model.OrderType;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class OrderCreator {
    static XWPFDocument document;
    OrderType orderType;

    public OrderCreator(OrderType orderType){
        this.orderType = orderType;
            try {
                switch (orderType){
                    case CLIENT:
                    case CARRIER:
                        document = new XWPFDocument(OPCPackage.open(orderType.getFileName()));
                        break;
                }

            } catch (IOException | InvalidFormatException e) {
                e.printStackTrace();
            }
    }


    public Order generateOrder(JFXTextArea textArea, JFXTextField... textFields){
        int argsAmount = textFields.length;
        edit(textArea.getId(), textArea.getText());
        for (int i = 0; i < argsAmount; i++) {
            edit(textFields[i].getId(), textFields[i].getText());
        }
        saveDoc(getSavePath());

        switch(orderType){
            case CLIENT:
                return new ClientOrder();
            case CARRIER:
                return new CarrierOrder();
            default:
                return new Order();
        }
    }


    private void edit(String key, String value){

        for (XWPFParagraph p : document.getParagraphs()) {
            List<XWPFRun> runs = p.getRuns();
            if (runs != null) {
                for (XWPFRun r : runs) {
                    String text = r.getText(0);
                    if (text != null && text.contains(key)) {
                        text = text.replace(key, value);//your content
                        r.setText(text, 0);
                    }
                }
            }
        }

        for (XWPFTable tbl : document.getTables()) {
                for (XWPFTableRow row : tbl.getRows()) {
                    for (XWPFTableCell cell : row.getTableCells()) {
                        for (XWPFParagraph p : cell.getParagraphs()) {
                            for (XWPFRun r : p.getRuns()) {
                                String text = r.getText(0);
                                if (text != null && text.equals(key)) {
                                    text = text.replace(key, value);
                                    r.setText(text, 0);
                                }
                            }
                        }
                    }
                }
            }
    }


    private boolean saveDoc(String savePath){
        boolean isSaved = false;
        try {
            document.write(new FileOutputStream(savePath));
            isSaved = true;
            System.out.println("Wygenerowano na podstawie " + orderType.getFileName());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return isSaved;
    }

    private String getSavePath(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(NativePathExtractor.extractDesktopPath()));
        fileChooser.setTitle("Zapisz plik");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("docx", "*.docx"),
                new FileChooser.ExtensionFilter("pdf", "*.pdf") //zaimplementowac konwerter docx->pdf
        );
        File file = fileChooser.showSaveDialog(new Stage());
        return file.getPath();
    }


}
