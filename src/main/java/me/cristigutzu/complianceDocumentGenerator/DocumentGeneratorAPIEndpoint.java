package me.cristigutzu.complianceDocumentGenerator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.cristigutzu.complianceDocumentGenerator.business_logic.GenerateFilledPDF;
import me.cristigutzu.complianceDocumentGenerator.business_logic.MergeDocuments;
import me.cristigutzu.complianceDocumentGenerator.models.DocumentGeneratorInput;
import me.cristigutzu.complianceDocumentGenerator.models.DocumentMergerInput;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class DocumentGeneratorAPIEndpoint {

    @POST
    @Path("/generate/")
    @Consumes("application/json")

    @Produces(MediaType.APPLICATION_JSON)
    public Response generate(final DocumentGeneratorInput input) {
        return Response.ok()
                .entity(new GenerateFilledPDF(input.base64PDF, GenerateFilledPDF.generateDataMap(input.parameters, input.values)).getPDFdocument())
                .build();
    }

    @POST
    @Path("/generate/merged")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response merge(final DocumentMergerInput input) {
        MergeDocuments merger = new MergeDocuments(input.doc1, input.doc2);
        return Response.ok()
                .entity(merger.merge())
                .build();
    }




}