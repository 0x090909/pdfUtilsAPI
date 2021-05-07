package me.cristigutzu.complianceDocumentGenerator.business_logic;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

public class GenerateFilledPDF {
    String source_document;
    Map<String, String> data;

    File filledDocument;

    public GenerateFilledPDF(String source_document, Map<String, String> data) {
        this.source_document = source_document;
        this.data = data;
        File doc1_temp_file = null;
/*
        try {
            doc1_temp_file = File.createTempFile("filldoc_temp", null);
            filledDocument = File.createTempFile("filldocfinal_temp", null);
            OutputStream outStream1 = new FileOutputStream(doc1_temp_file);
            outStream1.write(Base64.getDecoder().decode(source_document.getBytes()));

            PDDocument pdfDocument = PDDocument.load(doc1_temp_file);

            PDDocumentCatalog docCatalog = pdfDocument.getDocumentCatalog();
            PDAcroForm acroForm = docCatalog.getAcroForm();

            // as there might not be an AcroForm entry a null check is necessary
            if (acroForm != null)
            {
                List<PDField> fields = new ArrayList<>();
                for (Map.Entry<String, String> entry : data.entrySet()) {

                    PDField field = (PDField) acroForm.getField( entry.getKey() );
                    field.setValue(entry.getValue());
                    fields.add(field);

                    System.out.println(entry.getKey() + "/" + entry.getValue());
                }
                acroForm.flatten();
                pdfDocument.save(filledDocument);
                pdfDocument.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    public static Map<String, String> generateDataMap(String[] parameters, String[] values) {
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < parameters.length; i++) {
            map.put(parameters[i], values[i]);
        }

        return map;
    }

    public GenerateFilledPDF() {

    }

    /**
     * Return base64 encoded PDF
     *
     * @return PDF
     */
    public String getPDFdocument() {
        try {
            byte[] data_document = FileUtils.readFileToByteArray(this.filledDocument);

            return new String(Base64.getEncoder().encode(data_document));

        } catch (IOException e) {
            return "{\"error\": \"" + e.getMessage() + "\"}";
        }
    }
}
