/**
 * AutenticaRegServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the IBM Web services WSDL2Java emitter.
 * gm1216.01 v41612173829
 */

package seguridad.service;

public class AutenticaRegServiceLocator extends com.ibm.ws.webservices.multiprotocol.AgnosticService implements com.ibm.ws.webservices.multiprotocol.GeneratedService, seguridad.service.AutenticaRegService {

    public AutenticaRegServiceLocator() {
        super(com.ibm.ws.webservices.engine.utils.QNameTable.createQName(
           "http://service.seguridad",
           "AutenticaRegService"));

        context.setLocatorName("seguridad.service.AutenticaRegServiceLocator");
    }

    public AutenticaRegServiceLocator(com.ibm.ws.webservices.multiprotocol.ServiceContext ctx) {
        super(ctx);
        context.setLocatorName("seguridad.service.AutenticaRegServiceLocator");
    }

    // Utilizar para obtener la clase de proxy para autenticaReg
    private final java.lang.String autenticaReg_address = "http://10.7.12.73:9080/WSClaveHost/services/AutenticaReg";

    public java.lang.String getAutenticaRegAddress() {
        if (context.getOverriddingEndpointURIs() == null) {
            return autenticaReg_address;
        }
        String overriddingEndpoint = (String) context.getOverriddingEndpointURIs().get("AutenticaReg");
        if (overriddingEndpoint != null) {
            return overriddingEndpoint;
        }
        else {
            return autenticaReg_address;
        }
    }

    private java.lang.String autenticaRegPortName = "AutenticaReg";

    // The WSDD port name defaults to the port name.
    private java.lang.String autenticaRegWSDDPortName = "AutenticaReg";

    public java.lang.String getAutenticaRegWSDDPortName() {
        return autenticaRegWSDDPortName;
    }

    public void setAutenticaRegWSDDPortName(java.lang.String name) {
        autenticaRegWSDDPortName = name;
    }

    public seguridad.service.AutenticaReg getAutenticaReg() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(getAutenticaRegAddress());
        }
        catch (java.net.MalformedURLException e) {
            return null; // es poco probable ya que URL se ha validado en WSDL2Java
        }
        return getAutenticaReg(endpoint);
    }

    public seguridad.service.AutenticaReg getAutenticaReg(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        seguridad.service.AutenticaReg _stub =
            (seguridad.service.AutenticaReg) getStub(
                autenticaRegPortName,
                (String) getPort2NamespaceMap().get(autenticaRegPortName),
                seguridad.service.AutenticaReg.class,
                "seguridad.service.AutenticaRegSoapBindingStub",
                portAddress.toString());
        if (_stub instanceof com.ibm.ws.webservices.engine.client.Stub) {
            ((com.ibm.ws.webservices.engine.client.Stub) _stub).setPortName(autenticaRegWSDDPortName);
        }
        return _stub;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (seguridad.service.AutenticaReg.class.isAssignableFrom(serviceEndpointInterface)) {
                return getAutenticaReg();
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("WSWS3273E: Error: No hay ninguna implementación de apéndice para la interfaz:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        String inputPortName = portName.getLocalPart();
        if ("AutenticaReg".equals(inputPortName)) {
            return getAutenticaReg();
        }
        else  {
            throw new javax.xml.rpc.ServiceException();
        }
    }

    public void setPortNamePrefix(java.lang.String prefix) {
        autenticaRegWSDDPortName = prefix + "/" + autenticaRegPortName;
    }

    public javax.xml.namespace.QName getServiceName() {
        return com.ibm.ws.webservices.engine.utils.QNameTable.createQName("http://service.seguridad", "AutenticaRegService");
    }

    private java.util.Map port2NamespaceMap = null;

    protected synchronized java.util.Map getPort2NamespaceMap() {
        if (port2NamespaceMap == null) {
            port2NamespaceMap = new java.util.HashMap();
            port2NamespaceMap.put(
               "AutenticaReg",
               "http://schemas.xmlsoap.org/wsdl/soap/");
        }
        return port2NamespaceMap;
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            String serviceNamespace = getServiceName().getNamespaceURI();
            for (java.util.Iterator i = getPort2NamespaceMap().keySet().iterator(); i.hasNext(); ) {
                ports.add(
                    com.ibm.ws.webservices.engine.utils.QNameTable.createQName(
                        serviceNamespace,
                        (String) i.next()));
            }
        }
        return ports.iterator();
    }

    public javax.xml.rpc.Call[] getCalls(javax.xml.namespace.QName portName) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            throw new javax.xml.rpc.ServiceException("WSWS3062E: Error: portName no debe ser nulo.");
        }
        if  (portName.getLocalPart().equals("AutenticaReg")) {
            return new javax.xml.rpc.Call[] {
                createCall(portName, "claveHost", "claveHostRequest"),
            };
        }
        else {
            throw new javax.xml.rpc.ServiceException("WSWS3062E: Error: portName no debe ser nulo.");
        }
    }
}
