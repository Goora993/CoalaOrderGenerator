module pl.coalatransport {
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires com.sun.jna;
    requires com.sun.jna.platform;
    requires poi;
    requires poi.ooxml;
    requires ooxml.schemas;
    requires fr.opensagres.xdocreport.converter;
    requires fr.opensagres.xdocreport.document.docx;
    requires fr.opensagres.poi.xwpf.converter.pdf;
    requires fr.opensagres.poi.xwpf.converter.core;
    requires fr.opensagres.xdocreport.core;

    opens pl.coalatransport.controller to javafx.fxml;
    exports pl.coalatransport.controller;
    exports pl.coalatransport.app;
    exports pl.coalatransport.util;

}