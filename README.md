EC-JIRAServiceDesk Plugin

EC-JIRAServiceDesk
========


Plugin version 1.0.1

Revised on Wed Jul 26 10:17:18 ICT 2023


* * *


Contents
========


*   [Overview](#overview)
*   [Plugin Configurations](#plugin-configurations)
*   [Plugin Procedures](#plugin-procedures)

*   [Create Service Desk Request](#create-service-desk-request)

## Overview
========

JIRA Service Desk api integration




## Plugin Configurations
=====================

Plugin configurations are sets of parameters that can be applied across some, or all, of the plugin procedures. They can reduce the repetition of common values, create predefined parameter sets, and securely store credentials. Each configuration is given a unique name that is entered in the designated parameter for the plugin procedures that use them.  

### Creating Plugin Configurations

*   To create plugin configurations in CloudBees CD/RO, complete the following steps:
*   Navigate to DevOps Essentials  Plugin Management  Plugin configurations.
*   Select Add plugin configuration to create a new configuration.
*   In the New Configuration window, specify a Name for the configuration.
*   Select the Project that the configuration belongs to.
*   Optionally, add a Description for the configuration.
*   Select the appropriate Plugin for the configuration.
*   Configure the parameters per the descriptions below.

Configuration Parameters

| Parameter | Description |
| --- | --- |
| **Configuration Name** | Unique name for the configuration |
| Description | Configuration description |
| **My REST Endpoint** | REST API Endpoint |
| **Bearer token** | Token to connect to...... |
| Check Connection? | If checked, a connection endpoint and credentials will be tested before save. The configuration will not be saved if the test fails. |
| Debug Level | This option sets debug level for logs. If info is selected, only summary information will be shown, for debug, there will be some debug information and for trace the whole requests and responses will be shown. |

## Plugin Procedures
=================

**IMPORTANT** Note that the names of Required parameters are marked in **_bold italics_** in the parameter description table for each procedure.




## Create Service Desk Request
---------------------

This procedure Create a Service Desk Request

### Create Service Desk Request Parameters

| Parameter | Description |
| --- | --- |
| **Configuration Name** | Previously defined configuration for the plugin |
| **serviceDeskId** | The Id of the Service Desk |
| **requestTypeId** | The Type Id of the Request |
| **requestFieldValues** | The field values of the Request, in json format, example:<br>  {<br>    "customfield_22416": "33333333",<br>    "customfield_20400": "444444",<br>    "summary": "Request JSD help via REST",<br>    "description": "I need a new mouse for my Mac",<br>    "customfield_20402": { "value" : "Enterprise Technology", "child": {"value" : "Compliance IT"}},<br>    "customfield_22410": [{"value" : "Asia Pacific"}]<br>  }<br> |
| attachmentPath | The path of the attached file |
| resultPropertyPath | The path of the result property |


#### Output Parameters

| Parameter | Description |
| --- | --- |
| result | rest call result |
