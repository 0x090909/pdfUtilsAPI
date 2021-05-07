package me.cristigutzu.complianceDocumentGenerator.business_logic;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.ReaderProperties;
import com.itextpdf.kernel.utils.PdfMerger;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import org.apache.commons.io.FileUtils;

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

            File doc1_temp_file = File.createTempFile("doc1_temp", null);
            File doc2_temp_file = File.createTempFile("doc2_temp", null);
            File dest_temp_file = File.createTempFile("dest_temp", null);

            OutputStream outStream1 = new FileOutputStream(doc1_temp_file);
            outStream1.write(Base64.getDecoder().decode(this.doc1));



            OutputStream outStream2 = new FileOutputStream(doc2_temp_file);
            outStream2.write(Base64.getDecoder().decode(this.doc2));


            PdfDocument document1 = new PdfDocument(new PdfReader(doc1_temp_file), new PdfWriter(dest_temp_file));
            PdfDocument document2 = new PdfDocument(new PdfReader(doc2_temp_file));

            PdfMerger merger = new PdfMerger(document1);

            merger.merge(document2, 1, document2.getNumberOfPages());
            merger.close();

            String baseMerged =
                    new String(Base64.getEncoder().encode(FileUtils.readFileToByteArray(dest_temp_file)));

            System.out.println(baseMerged);

            return baseMerged;
        } catch (IOException e) {
            return "{\"error\": \"" + e.getMessage() + "\"}";
        }


    }
}
