package seguridad.service;

public class AutenticaRegProxy implements seguridad.service.AutenticaReg {
  private boolean _useJNDI = true;
  private boolean _useJNDIOnly = false;
  private String _endpoint = null;
  private seguridad.service.AutenticaReg __autenticaReg = null;
  
  public AutenticaRegProxy() {
    _initAutenticaRegProxy();
  }
  
  private void _initAutenticaRegProxy() {
  
    if (_useJNDI || _useJNDIOnly) {
      try {
        javax.naming.InitialContext ctx = new javax.naming.InitialContext();
        __autenticaReg = ((seguridad.service.AutenticaRegService)ctx.lookup("java:comp/env/service/AutenticaRegService")).getAutenticaReg();
      }
      catch (javax.naming.NamingException namingException) {
        if ("true".equalsIgnoreCase(System.getProperty("DEBUG_PROXY"))) {
          System.out.println("JNDI lookup failure: javax.naming.NamingException: " + namingException.getMessage());
          namingException.printStackTrace(System.out);
        }
      }
      catch (javax.xml.rpc.ServiceException serviceException) {
        if ("true".equalsIgnoreCase(System.getProperty("DEBUG_PROXY"))) {
          System.out.println("Unable to obtain port: javax.xml.rpc.ServiceException: " + serviceException.getMessage());
          serviceException.printStackTrace(System.out);
        }
      }
    }
    if (__autenticaReg == null && !_useJNDIOnly) {
      try {
        __autenticaReg = (new seguridad.service.AutenticaRegServiceLocator()).getAutenticaReg();
        
      }
      catch (javax.xml.rpc.ServiceException serviceException) {
        if ("true".equalsIgnoreCase(System.getProperty("DEBUG_PROXY"))) {
          System.out.println("Unable to obtain port: javax.xml.rpc.ServiceException: " + serviceException.getMessage());
          serviceException.printStackTrace(System.out);
        }
      }
    }
    if (__autenticaReg != null) {
      if (_endpoint != null)
        ((javax.xml.rpc.Stub)__autenticaReg)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
      else
        _endpoint = (String)((javax.xml.rpc.Stub)__autenticaReg)._getProperty("javax.xml.rpc.service.endpoint.address");
    }
    
  }
  
  
  public void useJNDI(boolean useJNDI) {
    _useJNDI = useJNDI;
    __autenticaReg = null;
    
  }
  
  public void useJNDIOnly(boolean useJNDIOnly) {
    _useJNDIOnly = useJNDIOnly;
    __autenticaReg = null;
    
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (__autenticaReg == null)
      _initAutenticaRegProxy();
    if (__autenticaReg != null)
      ((javax.xml.rpc.Stub)__autenticaReg)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public java.lang.String claveHost(java.lang.String info1) throws java.rmi.RemoteException{
    if (__autenticaReg == null)
      _initAutenticaRegProxy();
    return __autenticaReg.claveHost(info1);
  }
  
  
  public seguridad.service.AutenticaReg getAutenticaReg() {
    if (__autenticaReg == null)
      _initAutenticaRegProxy();
    return __autenticaReg;
  }
  
}