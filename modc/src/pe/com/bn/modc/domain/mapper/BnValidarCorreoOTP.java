package pe.com.bn.modc.domain.mapper;

public class BnValidarCorreoOTP {
	private String TIPDOC;
	private String NUMDOC ;
	private String NOMBR_APELL;
	private String CORREO;
	private String OTP;
	private String FECHA;
	private String HORA;
	private String USUARIO;
	
	
	public String getTIPDOC() {
		return TIPDOC;
	}
	public void setTIPDOC(String tIPDOC) {
		TIPDOC = tIPDOC;
	}
	public String getNUMDOC() {
		return NUMDOC;
	}
	public void setNUMDOC(String nUMDOC) {
		NUMDOC = nUMDOC;
	}
	public String getNOMBR_APELL() {
		return NOMBR_APELL;
	}
	public void setNOMBR_APELL(String nOMBR_APELL) {
		NOMBR_APELL = nOMBR_APELL;
	}
	public String getCORREO() {
		return CORREO;
	}
	public void setCORREO(String cORREO) {
		CORREO = cORREO;
	}
	public String getOTP() {
		return OTP;
	}
	public void setOTP(String oTP) {
		OTP = oTP;
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
	@Override
	public String toString() {
		return "BnValidarCorreoOTP [TIPDOC=" + TIPDOC + ", NUMDOC=" + NUMDOC + ", NOMBR_APELL=" + NOMBR_APELL
				+ ", CORREO=" + CORREO + ", OTP=" + OTP + ", FECHA=" + FECHA + ", HORA=" + HORA + ", USUARIO=" + USUARIO
				+ "]";
	}
	
	
	
	
}
