package pe.com.bn.modc.model;

import org.springframework.stereotype.Component;


@Component
public class ParametrosComp {
	
	
	// PARAMETROS SFTP ESTADOS CUENTA PDF
	private String stfpHost;
	private String stfpPort;
	private String stfpUsername;
	private String stfpPassword;
	private String stfpRemotepath;
	
	// PARAMETROS SERVICIO DATOS PERSONALES BDUC
	private String serviceHost;
	private String servicePort;
	private String serviceUserApplication;

	// PARAMETROS WS ENVIO CORREO
	private String servicewscorreoHost;
	private String servicewscorreoToken;
	private String servicewscorreoCorreoemisor;
	
	
	public ParametrosComp() {
	}
	
	public ParametrosComp(String stfpHost, String stfpPort,
			String stfpUsername, String stfpPassword, String stfpRemotepath,
			String serviceHost, String servicePort,
			String serviceUserApplication, String servicewscorreoHost,
			String servicewscorreoToken, String servicewscorreoCorreoemisor) {
		this.stfpHost = stfpHost;
		this.stfpPort = stfpPort;
		this.stfpUsername = stfpUsername;
		this.stfpPassword = stfpPassword;
		this.stfpRemotepath = stfpRemotepath;
		this.serviceHost = serviceHost;
		this.servicePort = servicePort;
		this.serviceUserApplication = serviceUserApplication;
		this.servicewscorreoHost = servicewscorreoHost;
		this.servicewscorreoToken = servicewscorreoToken;
		this.servicewscorreoCorreoemisor = servicewscorreoCorreoemisor;
	}
	public String getStfpHost() {
		return stfpHost;
	}
	public void setStfpHost(String stfpHost) {
		this.stfpHost = stfpHost;
	}
	public String getStfpPort() {
		return stfpPort;
	}
	public void setStfpPort(String stfpPort) {
		this.stfpPort = stfpPort;
	}
	public String getStfpUsername() {
		return stfpUsername;
	}
	public void setStfpUsername(String stfpUsername) {
		this.stfpUsername = stfpUsername;
	}
	public String getStfpPassword() {
		return stfpPassword;
	}
	public void setStfpPassword(String stfpPassword) {
		this.stfpPassword = stfpPassword;
	}
	public String getStfpRemotepath() {
		return stfpRemotepath;
	}
	public void setStfpRemotepath(String stfpRemotepath) {
 			this.stfpRemotepath = stfpRemotepath;
			//this.stfpRemotepath = "/in/EC_ELE_FIS"; 
			 

	}
	public String getServiceHost() {
		return serviceHost;
	}
	public void setServiceHost(String serviceHost) {
		this.serviceHost = serviceHost;
	}
	public String getServicePort() {
		return servicePort;
	}
	public void setServicePort(String servicePort) {
		this.servicePort = servicePort;
	}
	public String getServiceUserApplication() {
		return serviceUserApplication;
	}
	public void setServiceUserApplication(String serviceUserApplication) {
		this.serviceUserApplication = serviceUserApplication;
	}
	public String getServicewscorreoHost() {
		return servicewscorreoHost;
	}
	public void setServicewscorreoHost(String servicewscorreoHost) {
		this.servicewscorreoHost = servicewscorreoHost;
	}
	public String getServicewscorreoToken() {
		return servicewscorreoToken;
	}
	public void setServicewscorreoToken(String servicewscorreoToken) {
		this.servicewscorreoToken = servicewscorreoToken;
	}
	public String getServicewscorreoCorreoemisor() {
		return servicewscorreoCorreoemisor;
	}
	public void setServicewscorreoCorreoemisor(String servicewscorreoCorreoemisor) {
		this.servicewscorreoCorreoemisor = servicewscorreoCorreoemisor;
	}


}
