/**
 * AutenticaRegSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the IBM Web services WSDL2Java emitter.
 * gm1216.01 v41612173829
 */

package seguridad.service;

public class AutenticaRegSoapBindingStub extends com.ibm.ws.webservices.engine.client.Stub implements seguridad.service.AutenticaReg {
    public AutenticaRegSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws com.ibm.ws.webservices.engine.WebServicesFault {
        if (service == null) {
            super.service = new com.ibm.ws.webservices.engine.client.Service();
        }
        else {
            super.service = service;
        }
        super.engine = ((com.ibm.ws.webservices.engine.client.Service) super.service).getEngine();
        super.messageContexts = new com.ibm.ws.webservices.engine.MessageContext[1];
        java.lang.String theOption = (java.lang.String)super._getProperty("lastStubMapping");
        if (theOption == null || !theOption.equals("seguridad.service.AutenticaRegSoapBinding")) {
                initTypeMapping();
                super._setProperty("lastStubMapping","seguridad.service.AutenticaRegSoapBinding");
        }
        super.cachedEndpoint = endpointURL;
        super.connection = ((com.ibm.ws.webservices.engine.client.Service) super.service).getConnection(endpointURL);
    }

    private void initTypeMapping() {
        javax.xml.rpc.encoding.TypeMapping tm = super.getTypeMapping(com.ibm.ws.webservices.engine.Constants.URI_LITERAL_ENC);
        java.lang.Class javaType = null;
        javax.xml.namespace.QName xmlType = null;
        javax.xml.namespace.QName compQName = null;
        javax.xml.namespace.QName compTypeQName = null;
        com.ibm.ws.webservices.engine.encoding.SerializerFactory sf = null;
        com.ibm.ws.webservices.engine.encoding.DeserializerFactory df = null;
    }

    private static com.ibm.ws.webservices.engine.description.OperationDesc _claveHostOperation0 = null;
    private static com.ibm.ws.webservices.engine.description.OperationDesc _getclaveHostOperation0() {
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
        _claveHostOperation0 = new com.ibm.ws.webservices.engine.description.OperationDesc("claveHost", com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://service.seguridad", "claveHost"), _params0, _returnDesc0, _faults0, "");
        _claveHostOperation0.setOption("inoutOrderingReq","false");
        _claveHostOperation0.setOption("buildNum","gm1216.01");
        _claveHostOperation0.setOption("outputName","claveHostResponse");
        _claveHostOperation0.setOption("ResponseNamespace","http://service.seguridad");
        _claveHostOperation0.setOption("targetNamespace","http://service.seguridad");
        _claveHostOperation0.setOption("outputMessageQName",com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://service.seguridad", "claveHostResponse"));
        _claveHostOperation0.setOption("portTypeQName",com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://service.seguridad", "AutenticaReg"));
        _claveHostOperation0.setOption("ServiceQName",com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://service.seguridad", "AutenticaRegService"));
        _claveHostOperation0.setOption("inputName","claveHostRequest");
        _claveHostOperation0.setOption("ResponseLocalPart","claveHostResponse");
        _claveHostOperation0.setOption("inputMessageQName",com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://service.seguridad", "claveHostRequest"));
        _claveHostOperation0.setUse(com.ibm.ws.webservices.engine.enumtype.Use.LITERAL);
        _claveHostOperation0.setStyle(com.ibm.ws.webservices.engine.enumtype.Style.WRAPPED);
        return _claveHostOperation0;

    }

    private int _claveHostIndex0 = 0;
    private synchronized com.ibm.ws.webservices.engine.client.Stub.Invoke _getclaveHostInvoke0(Object[] parameters) throws com.ibm.ws.webservices.engine.WebServicesFault  {
        com.ibm.ws.webservices.engine.MessageContext mc = super.messageContexts[_claveHostIndex0];
        if (mc == null) {
            mc = new com.ibm.ws.webservices.engine.MessageContext(super.engine);
            mc.setOperation(AutenticaRegSoapBindingStub._claveHostOperation0);
            mc.setUseSOAPAction(true);
            mc.setSOAPActionURI("");
            mc.setEncodingStyle(com.ibm.ws.webservices.engine.Constants.URI_LITERAL_ENC);
            mc.setProperty(com.ibm.wsspi.webservices.Constants.SEND_TYPE_ATTR_PROPERTY, Boolean.FALSE);
            mc.setProperty(com.ibm.wsspi.webservices.Constants.ENGINE_DO_MULTI_REFS_PROPERTY, Boolean.FALSE);
            super.primeMessageContext(mc);
            super.messageContexts[_claveHostIndex0] = mc;
        }
        try {
            mc = (com.ibm.ws.webservices.engine.MessageContext) mc.clone();
        }
        catch (CloneNotSupportedException cnse) {
            throw com.ibm.ws.webservices.engine.WebServicesFault.makeFault(cnse);
        }
        return new com.ibm.ws.webservices.engine.client.Stub.Invoke(connection, mc, parameters);
    }

    public java.lang.String claveHost(java.lang.String info1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new com.ibm.ws.webservices.engine.NoEndPointException();
        }
        java.util.Vector _resp = null;
        try {
            _resp = _getclaveHostInvoke0(new java.lang.Object[] {info1}).invoke();

        } catch (com.ibm.ws.webservices.engine.WebServicesFault wsf) {
            Exception e = wsf.getUserException();
            throw wsf;
        } 
        try {
            return (java.lang.String) ((com.ibm.ws.webservices.engine.xmlsoap.ext.ParamValue) _resp.get(0)).getValue();
        } catch (java.lang.Exception _exception) {
            return (java.lang.String) super.convert(((com.ibm.ws.webservices.engine.xmlsoap.ext.ParamValue) _resp.get(0)).getValue(), java.lang.String.class);
        }
    }

    private static void _staticInit() {
        _claveHostOperation0 = _getclaveHostOperation0();
    }

    static {
       _staticInit();
    }
}
