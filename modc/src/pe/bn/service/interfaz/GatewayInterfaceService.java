/**
 * GatewayInterfaceService.java
 *
 * This file was auto-generated from WSDL
 * by the IBM Web services WSDL2Java emitter.
 * f5011932.01 v81619102751
 */

package pe.bn.service.interfaz;

public interface GatewayInterfaceService extends javax.xml.rpc.Service {
    public pe.bn.service.interfaz.GatewayInterface getGatewayInterface() throws javax.xml.rpc.ServiceException;

    public java.lang.String getGatewayInterfaceAddress();

    public pe.bn.service.interfaz.GatewayInterface getGatewayInterface(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
