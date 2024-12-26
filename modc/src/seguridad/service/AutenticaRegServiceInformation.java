/**
 * AutenticaRegServiceInformation.java
 *
 * This file was auto-generated from WSDL
 * by the IBM Web services WSDL2Java emitter.
 * gm1216.01 v41612173829
 */

package seguridad.service;

public class AutenticaRegServiceInformation implements com.ibm.ws.webservices.multiprotocol.ServiceInformation {

    private static java.util.Map operationDescriptions;
    private static java.util.Map typeMappings;

    static {
         initOperationDescriptions();
         initTypeMappings();
    }

    private static void initOperationDescriptions() { 
        operationDescriptions = new java.util.HashMap();

        java.util.Map inner0 = new java.util.HashMap();

        java.util.List list0 = new java.util.ArrayList();
        inner0.put("claveHost", list0);

        com.ibm.ws.webservices.engine.description.OperationDesc claveHost0Op = _claveHost0Op();
        list0.add(claveHost0Op);

        operationDescriptions.put("AutenticaReg",inner0);
        operationDescriptions = java.util.Collections.unmodifiableMap(operationDescriptions);
    }

    private static com.ibm.ws.webservices.engine.description.OperationDesc _claveHost0Op() {
        com.ibm.ws.webservices.engine.description.OperationDesc claveHost0Op = null;
        com.ibm.ws.webservices.engine.description.ParameterDesc[]  _params0 = new com.ibm.ws.webservices.engine.description.ParameterDesc[] {
         new com.ibm.ws.webservices.engine.description.ParameterDesc(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "info1"), com.ibm.ws.webservices.engine.description.ParameterDesc.IN, com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false, false, false, true, false), 
          };
        _params0[0].setOption("partQNameString","{http://www.w3.org/2001/XMLSchema}string");
        _params0[0].setOption("inputPosition","0");
        _params0[0].setOption("partName","string");
        com.ibm.ws.webservices.engine.description.ParameterDesc  _returnDesc0 = new com.ibm.ws.webservices.engine.description.ParameterDesc(com.ibm.ws.webservices.engine.utils.QNameTable.createQName("", "claveHostReturn"), com.ibm.ws.webservices.engine.description.ParameterDesc.OUT, com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, true, false, false, false, true, false); 
        _returnDesc0.setOption("partQNameString","{http://www.w3.org/2001/XMLSchema}string");
        _returnDesc0.setOption("outputPosition","0");
        _returnDesc0.setOption("partName","string");
        com.ibm.ws.webservices.engine.description.FaultDesc[]  _faults0 = new com.ibm.ws.webservices.engine.description.FaultDesc[] {
          };
        claveHost0Op = new com.ibm.ws.webservices.engine.description.OperationDesc("claveHost", com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://service.seguridad", "claveHost"), _params0, _returnDesc0, _faults0, null);
        claveHost0Op.setOption("inoutOrderingReq","false");
        claveHost0Op.setOption("buildNum","gm1216.01");
        claveHost0Op.setOption("outputName","claveHostResponse");
        claveHost0Op.setOption("ResponseNamespace","http://service.seguridad");
        claveHost0Op.setOption("targetNamespace","http://service.seguridad");
        claveHost0Op.setOption("outputMessageQName",com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://service.seguridad", "claveHostResponse"));
        claveHost0Op.setOption("portTypeQName",com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://service.seguridad", "AutenticaReg"));
        claveHost0Op.setOption("ServiceQName",com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://service.seguridad", "AutenticaRegService"));
        claveHost0Op.setOption("inputName","claveHostRequest");
        claveHost0Op.setOption("ResponseLocalPart","claveHostResponse");
        claveHost0Op.setOption("inputMessageQName",com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://service.seguridad", "claveHostRequest"));
        claveHost0Op.setStyle(com.ibm.ws.webservices.engine.enumtype.Style.WRAPPED);
        return claveHost0Op;

    }


    private static void initTypeMappings() {
        typeMappings = new java.util.HashMap();
        typeMappings = java.util.Collections.unmodifiableMap(typeMappings);
    }

    public java.util.Map getTypeMappings() {
        return typeMappings;
    }

    public Class getJavaType(javax.xml.namespace.QName xmlName) {
        return (Class) typeMappings.get(xmlName);
    }

    public java.util.Map getOperationDescriptions(String portName) {
        return (java.util.Map) operationDescriptions.get(portName);
    }

    public java.util.List getOperationDescriptions(String portName, String operationName) {
        java.util.Map map = (java.util.Map) operationDescriptions.get(portName);
        if (map != null) {
            return (java.util.List) map.get(operationName);
        }
        return null;
    }

}
