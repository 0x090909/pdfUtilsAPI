package me.cristigutzu.complianceDocumentGenerator.models;

import io.swagger.annotations.ApiModel;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@ApiModel(value="GeneratorInput", description="Sample model for the documentation")
@XmlRootElement
public class DocumentGeneratorInput {
        @XmlElement
        public String[] parameters;
        @XmlElement
        public String[] values;
        @XmlElement
        public String base64PDF;




}
