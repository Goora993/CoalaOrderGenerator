open module pl.coalatransport {
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires poi.ooxml.schemas;
    requires poi.ooxml;
    requires poi;
    requires com.sun.jna;
    requires com.sun.jna.platform;

    exports pl.coalatransport.controller;
    exports pl.coalatransport.app;

}