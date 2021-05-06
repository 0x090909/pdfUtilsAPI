# PDFUtilsAPI
REST Based API microservice for filling on the fly your PDF documents and merge up to 2 documents.

# Generate Filled PDF Document

Generate filled PDF with parameters and values

**URL** : `/api/generate/`

**Method** : `POST`

**Auth required** : NO

**Parameters** : `{"parameters":["one","two"],"values":["123","3243"], "base64PDF":"pdf file in base64 format"}`

## Success Responses


**Code** : `200 OK`

**Content** : `base64 encoded PDF Filled with form values`


# Generate Merged PDF Document

Merge 2 documents in one document

and return Base64 Encoded PDF File

**URL** : `/api/generate/merged/`

**Method** : `POST`

**Auth required** : NO

**Parameters** : `{"doc1":"pdf file in base64 format","doc2":"pdf file in base64 format"}`

## Success Responses

**Code** : `200 OK`

**Content** : `base64 encoded PDF Merged documents` 
 


 


