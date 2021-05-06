package me.cristigutzu.complianceDocumentGenerator.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DocumentMergerOutput {
    @XmlElement
    public String docBase64;

    public DocumentMergerOutput(String docBase64) {
        this.docBase64 = docBase64;
    }
}
