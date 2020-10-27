package pl.coalatransport.util;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.*;
import pl.coalatransport.model.OrderType;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class OrderEditor {
    static XWPFDocument document;

    public OrderEditor(OrderType orderType){
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



    public void edit(String key, String value){

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

    public void saveDoc(String savePath){
        try {
            document.write(new FileOutputStream(savePath));
            System.out.println("Zapisaono");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
