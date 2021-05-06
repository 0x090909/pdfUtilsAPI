package me.cristigutzu.complianceDocumentGenerator.models;

import io.swagger.annotations.ApiModel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@ApiModel(value="DifferentModel", description="Sample model for the documentation")
@XmlRootElement
public class DocumentMergerInput {
    @XmlElement
    public String doc1;
    @XmlElement
    public String doc2;


}
