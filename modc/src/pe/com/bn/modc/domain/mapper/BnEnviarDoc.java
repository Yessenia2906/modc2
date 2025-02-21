package pe.com.bn.modc.domain.mapper;

import java.sql.Date;

public class BnEnviarDoc {
	
	private String NUMPRESTAMO;
	private String TIPDOC;
	private String NOMBRES;
	private String NUMDOC ;
	private String CORREO;
	private String FECHA;
	private String HORA;
	private String USUARIO;
	private String AGENCIA;
	private String ESTADO;
	private byte[] PDF;
	private Date fechaope;
	
	
	public Date getFechaope() {
		return fechaope;
	}
	public void setFechaope(Date fechaope) {
		this.fechaope = fechaope;
	}
	public String getNUMPRESTAMO() {
		return NUMPRESTAMO;
	}
	public void setNUMPRESTAMO(String nUMPRESTAMO) {
		NUMPRESTAMO = nUMPRESTAMO;
	}
	public String getTIPDOC() {
		return TIPDOC;
	}
	public void setTIPDOC(String tIPDOC) {
		TIPDOC = tIPDOC;
	}
	public String getNOMBRES() {
		return NOMBRES;
	}
	public void setNOMBRES(String nOMBRES) {
		NOMBRES = nOMBRES;
	}
	public String getNUMDOC() {
		return NUMDOC;
	}
	public void setNUMDOC(String nUMDOC) {
		NUMDOC = nUMDOC;
	}
	public String getCORREO() {
		return CORREO;
	}
	public void setCORREO(String cORREO) {
		CORREO = cORREO;
	}
	public String getFECHA() {
		return FECHA;
	}
	public void setFECHA(String fECHA) {
		FECHA = fECHA;
	}
	public String getHORA() {
		return HORA;
	}
	public void setHORA(String hORA) {
		HORA = hORA;
	}
	public String getUSUARIO() {
		return USUARIO;
	}
	public void setUSUARIO(String uSUARIO) {
		USUARIO = uSUARIO;
	}
	public String getAGENCIA() {
		return AGENCIA;
	}
	public void setAGENCIA(String aGENCIA) {
		AGENCIA = aGENCIA;
	}
	public String getESTADO() {
		return ESTADO;
	}
	public void setESTADO(String eSTADO) {
		ESTADO = eSTADO;
	}
	public byte[] getPDF() {
		return PDF;
	}
	public void setPDF(byte[] pDF) {
		PDF = pDF;
	}
	
	
	
}
