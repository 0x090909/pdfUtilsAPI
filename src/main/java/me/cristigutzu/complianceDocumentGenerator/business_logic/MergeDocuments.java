package me.cristigutzu.complianceDocumentGenerator.business_logic;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.*;
import java.util.Base64;

public class MergeDocuments {
    String doc1;
    String doc2;

    public MergeDocuments(String doc1, String doc2) {
        this.doc1 = doc1;
        this.doc2 = doc2;
    }

    public String merge() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            ByteInputStream doc1_in = new ByteInputStream();
            ByteInputStream doc2_in = new ByteInputStream();

            doc1_in.setBuf(Base64.getDecoder().decode(this.doc1));
            doc2_in.setBuf(Base64.getDecoder().decode(this.doc2));

            File doc1_temp_file = File.createTempFile("doc1_temp", null);
            File doc2_temp_file = File.createTempFile("doc1_temp", null);

            OutputStream outStream1 = new FileOutputStream(doc1_temp_file);
            outStream1.write(doc1_in.getBytes());


            OutputStream outStream2 = new FileOutputStream(doc2_temp_file);
            outStream2.write(doc2_in.getBytes());


            PDFMergerUtility ut = new PDFMergerUtility();

            ut.addSource(doc1_temp_file);
            ut.addSource(doc2_temp_file);
            ut.setDestinationStream(byteArrayOutputStream);

            ut.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());

            String baseMerged =
                    new String(Base64.getEncoder().encode(byteArrayOutputStream.toByteArray()));

            System.out.println(baseMerged);

            return baseMerged;
        } catch (IOException e) {
            return "{\"error\": \"" + e.getMessage() + "\"}";
        }


    }
}
