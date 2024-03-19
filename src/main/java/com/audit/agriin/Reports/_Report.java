package com.audit.agriin.Reports;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.*;

import java.sql.SQLException;
import java.text.ParseException;

public abstract class _Report {

    protected void exportToPDF(JasperPrint jasperPrint, String fileName, String author) throws JRException {
        JRPdfExporter exporter = new JRPdfExporter();

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(
                new SimpleOutputStreamExporterOutput(STR."\{fileName}.pdf"));

        SimplePdfReportConfiguration reportConfig
                = new SimplePdfReportConfiguration();
        reportConfig.setSizePageToContent(true);
        reportConfig.setForceLineBreakPolicy(false);

        SimplePdfExporterConfiguration exportConfig
                = new SimplePdfExporterConfiguration();
        exportConfig.setMetadataAuthor(author);
        exportConfig.setEncrypted(true);
        exportConfig.setAllowedPermissionsHint("PRINTING");

        exporter.setConfiguration(reportConfig);
        exporter.setConfiguration(exportConfig);

        exporter.exportReport();

    }

    protected void exportToExcel(JasperPrint jasperPrint, String fileName, String author) throws JRException {

        JRXlsxExporter exporter = new JRXlsxExporter();

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(
                new SimpleOutputStreamExporterOutput(STR."\{fileName}.xlsx"));

        SimplePdfReportConfiguration reportConfig = new SimplePdfReportConfiguration();
        reportConfig.setSizePageToContent(true);
        reportConfig.setForceLineBreakPolicy(false);

        SimpleXlsxReportConfiguration config = new SimpleXlsxReportConfiguration();
        config.setSheetNames(new String[] { "Audit Data" });

        exporter.setConfiguration(config);
        exporter.exportReport();

    }

    private void exportToWord() {}

    protected void exportToHtml() {}

    protected void exportToCsv(JasperPrint jasperPrint, String fileName, String author) throws JRException {

        JRCsvExporter exporter = new JRCsvExporter();

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(
                new SimpleWriterExporterOutput(STR."\{fileName}.csv"));

        SimplePdfReportConfiguration reportConfig = new SimplePdfReportConfiguration();
        reportConfig.setSizePageToContent(true);
        reportConfig.setForceLineBreakPolicy(false);
        exporter.setExporterOutput(
                new SimpleWriterExporterOutput(STR."\{fileName}.csv"));

        exporter.exportReport();

    }

    public abstract void compile() throws JRException;

    public abstract void export(String type, JRBeanCollectionDataSource dataSource) throws ParseException, SQLException, JRException;
}
