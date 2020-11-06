package pl.coalatransport.util;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;
import javafx.scene.control.DatePicker;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.*;
import pl.coalatransport.model.CarrierOrder;
import pl.coalatransport.model.ClientOrder;
import pl.coalatransport.model.Order;
import pl.coalatransport.model.OrderType;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class OrderCreator {
    static XWPFDocument document;
    OrderType orderType;

    public OrderCreator(OrderType orderType){
        this.orderType = orderType;
            try(FileInputStream fis = new FileInputStream(orderType.getFileName())) {
                switch (orderType){
                    case CLIENT:
                    case CARRIER:
                        //Old way to do it: document = new XWPFDocument(OPCPackage.open(orderType.getFileName()));
                        document = new XWPFDocument(fis);
                        break;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
    }


    public Order generateOrder(JFXTextArea textArea, DatePicker datePicker, JFXTextField... textFields){
        int argsAmount = textFields.length;
        edit(textArea.getId(), textArea.getText());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        edit(datePicker.getId(), datePicker.getValue().format(formatter));
        for (int i = 0; i < argsAmount; i++) {
            edit(textFields[i].getId(), textFields[i].getText());
        }

        saveFile();

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
                        text = text.replace(key, value); //content
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



    private void saveFile(){
        FileChooser fileChooser = new FileChooser();
        File initialDirectory = new File(NativePathExtractor.extractDesktopPath());

        if(initialDirectory!=null)  //removes NPE when closing file chooser without saving file
            fileChooser.setInitialDirectory(initialDirectory);

        fileChooser.setTitle("Zapisz plik");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("docx", "*.docx"),
                new FileChooser.ExtensionFilter("pdf", "*.pdf")
        );
        File file = fileChooser.showSaveDialog(new Stage());

        String extensionType = fileChooser.getSelectedExtensionFilter().getDescription();

        switch (extensionType){
            case "docx":
                saveDocx(file.getPath());
                break;
            case "pdf":
                savePdf(file.getPath());
                break;
               //add default with exception
        }

    }

    //SAVE DOCX METHOD
    private boolean saveDocx(String savePath){
        boolean isSaved = false;
        try(FileOutputStream fos = new FileOutputStream(savePath)) {
            document.write(fos);
            isSaved = true;
            System.out.println("Wygenerowano na podstawie " + orderType.getFileName());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return isSaved;
    }

    //SAVE PDF METHOD
    private boolean savePdf(String savePath) {

        boolean isSaved = false;

        try(FileOutputStream fos = new FileOutputStream(new File(savePath))) {
            PdfOptions pdfOptions = PdfOptions.create();
            PdfConverter.getInstance().convert(document, fos, pdfOptions);
            isSaved = true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return isSaved;
    }

}
