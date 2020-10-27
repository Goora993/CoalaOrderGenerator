package pl.coalatransport.model;

public enum OrderType {



    CARRIER(1, "carrierOrderTemp.docx"), CLIENT(2, "clientOrderTemp.docx");

    private int key;
    private String fileName;

    private OrderType(int key, String fileName){
        this.key = key;
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
