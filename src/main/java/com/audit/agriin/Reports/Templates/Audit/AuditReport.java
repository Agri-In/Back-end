package com.audit.agriin.Reports.Templates.Audit;

import com.audit.agriin.Reports._Report;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSaver;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.io.InputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@Component
public class AuditReport extends _Report {


    @Override
    public void compile() throws JRException {
        if (getClass().getResource("AuditReport.jasper") != null)
            return;
        System.out.println("Compiling Audit Report");
        InputStream employeeReportStream
                = getClass().getResourceAsStream("/AuditReport.jrxml");
        JasperReport jasperReport
                = JasperCompileManager.compileReport(employeeReportStream);
        JRSaver.saveObject(jasperReport, "AuditReport.jasper");
    }

    @Override
    public void export(String type, JRBeanCollectionDataSource dataSource) throws ParseException, SQLException, JRException {

        Map<String, Object> parameters = new HashMap<>();
        Map<String, String> temp = new HashMap<>();
        compile();
        parameters.put("Created by", "NOUHI Sidati");
        String file = "/AuditReport.jasper";
        System.out.println(STR."Current working directory : \{file}");
        JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(file);
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, dataSource);
        if (type.equalsIgnoreCase("pdf")) {
            exportToPDF(jasperPrint, "AuditReport", "NOUHI Sidati");
        } else if (type.equalsIgnoreCase("excel")) {
            exportToExcel(jasperPrint, "AuditReport", "NOUHI Sidati");
        } else if (type.equalsIgnoreCase("csv")) {
            exportToCsv(jasperPrint, "AuditReport", "NOUHI Sidati");
        }
//        JFrame frame = new JFrame("Report");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().add(new JRViewer(jasperPrint));
//        frame.pack();
//        frame.setVisible(true);
    }
}



