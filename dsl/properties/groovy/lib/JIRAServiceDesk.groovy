import com.cloudbees.flowpdf.*

/**
* JIRAServiceDesk
*/
class JIRAServiceDesk extends FlowPlugin {

    @Override
    Map<String, Object> pluginInfo() {
        return [
                pluginName     : '@PLUGIN_KEY@',
                pluginVersion  : '@PLUGIN_VERSION@',
                configFields   : ['config'],
                configLocations: ['ec_plugin_cfgs'],
                defaultConfigValues: [:]
        ]
    }
// === check connection ends ===
/**
     * Auto-generated method for the procedure Create Service Desk Request/Create Service Desk Request
     * Add your code into this method and it will be called when step runs* Parameter: config* Parameter: serviceDeskId* Parameter: requestTypeId* Parameter: requestFieldValues* Parameter: attachmentPath
     */
    def createServiceDeskRequest(StepParameters p, StepResult sr) {
        CreateServiceDeskRequestParameters sp = CreateServiceDeskRequestParameters.initParameters(p)
        ECJIRAServiceDeskRESTClient rest = genECJIRAServiceDeskRESTClient()
        Map restParams = [:]
        Map requestParams = p.asMap
        restParams.put('serviceDeskId', requestParams.get('serviceDeskId'))
        restParams.put('attachmentPath', requestParams.get('attachmentPath'))
        def attachmentId
        def slurper = new JsonSlurper()

        if(requestParams.get('attachmentPath') && !requestParams.get('attachmentPath').trim().equals("")) {
            def response = rest.attachTemporaryFile(restParams)
            log.info "Got response from server for attach temporary file: $response"
            attachmentId = slurper.parseText(response).temporaryAttachments[0].temporaryAttachmentId
        }

        restParams.put('requestTypeId', requestParams.get('requestTypeId'))

        def requestFieldValues = slurper.parseText(requestParams.get('requestFieldValues'))
        if(attachmentId){
            def attachList = [attachmentId]
            requestFieldValues.put("attachment", attachList)
            log.debug "request Field Values with Attachment is: " + JsonOutput.toJson(requestFieldValues)
        }

        restParams.put('requestFieldValues', requestFieldValues)
        def response = rest.createRequest(restParams)
        log.info "Got response from server: $response"

        if(requestParams.get('resultPropertyPath') && !requestParams.get('resultPropertyPath').trim().equals("")){
            FlowAPI.setFlowProperty(requestParams.get('resultPropertyPath'), response)
        }

        //step result output parameters
        sr.setOutputParameter("result", response)
        sr.apply()
        log.info "Create Service Desk Request step finished"
    }
/**
     * This method returns REST Client object
     */
    ECJIRAServiceDeskRESTClient genECJIRAServiceDeskRESTClient() {
        Context context = getContext()
        ECJIRAServiceDeskRESTClient rest = ECJIRAServiceDeskRESTClient.fromConfig(context.getConfigValues(), this)
        return rest
    }
// === step ends ===

}