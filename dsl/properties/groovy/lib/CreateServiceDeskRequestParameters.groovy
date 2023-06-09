
// DO NOT EDIT THIS BLOCK BELOW=== Parameters starts ===
// PLEASE DO NOT EDIT THIS FILE

import com.cloudbees.flowpdf.StepParameters

class CreateServiceDeskRequestParameters {
    /**
    * Label: Service Desk Id, type: entry
    */
    String serviceDeskId
    /**
    * Label: Request Type Id, type: entry
    */
    String requestTypeId
    /**
    * Label: Request Field Values, type: textarea
    */
    String requestFieldValues
    /**
    * Label: Attachment path, type: entry
    */
    String attachmentPath
    /**
    * Label: Result Property path, type: entry
    */
    String resultPropertyPath

    static CreateServiceDeskRequestParameters initParameters(StepParameters sp) {
        CreateServiceDeskRequestParameters parameters = new CreateServiceDeskRequestParameters()

        def serviceDeskId = sp.getRequiredParameter('serviceDeskId').value
        parameters.serviceDeskId = serviceDeskId

        def requestTypeId = sp.getRequiredParameter('requestTypeId').value
        parameters.requestTypeId = requestTypeId

        def requestFieldValues = sp.getRequiredParameter('requestFieldValues').value
        parameters.requestFieldValues = requestFieldValues  ?: '{ "summary": "", "description": "" }'

        def attachmentPath = sp.getParameter('attachmentPath').value
        parameters.attachmentPath = attachmentPath

        def resultPropertyPath = sp.getParameter('resultPropertyPath').value
        parameters.resultPropertyPath = resultPropertyPath  ?: '/myJob/result'

        return parameters
    }
}
// DO NOT EDIT THIS BLOCK ABOVE ^^^=== Parameters ends, checksum: 93830e1dc4cd4c022229c43749b53187 ===
