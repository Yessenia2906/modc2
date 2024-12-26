package pe.com.bn.modc.domain.mapper;

import java.util.ArrayList;

public class GeneracionCronograma {
	
	private String ccuenta;
	private String cdsbolso;
	
	
	
	public String getCcuenta() {
		return ccuenta;
	}
	public void setCcuenta(String ccuenta) {
		this.ccuenta = ccuenta;
	}
	public String getCdsbolso() {
		return cdsbolso;
	}
	public void setCdsbolso(String cdsbolso) {
		this.cdsbolso = cdsbolso;
	}

	private String TOPERACION;
	private String NPRESTAMO;
	private String FDSBOLSO;
	private String SPRESTAMO;
	private String SAMORTIZADO;
	private String SACTUAL;
	private String SDEUDA_D;
	private String NCUOTAS;
	
	private String ACLIENTE;
	private String DOCUMENTO;
	private String TELEFONO;
	private String DCLIENTE;
	private String DOCUMGAR;
	private String AGARANTE;
	private String DGARANTE;
	
	private String TASA;
	private String TCEA;
	private String SGCPRO;

	private String CERROR;
	private String MSJ;

	
	ArrayList<String> BCUOTA = new ArrayList<String>();
	ArrayList<String> ACUOTA = new ArrayList<String>();
	ArrayList<String> FVCTO = new ArrayList<String>();
	ArrayList<String> FCANCEL = new ArrayList<String>();
	ArrayList<String> GCUOTA = new ArrayList<String>();
	ArrayList<String> SAMORTIZACION = new ArrayList<String>();
	ArrayList<String> SINTERES = new ArrayList<String>();
	ArrayList<String> SDESGRAVAMEN = new ArrayList<String>();
	ArrayList<String> SDCUOTA = new ArrayList<String>();
	
	
	
	private String rutaClasspath;
	
	public String getRutaClasspath() {
		return rutaClasspath;
	}
	public void setRutaClasspath(String rutaClasspath) {
		this.rutaClasspath = rutaClasspath;
	}
	public String getTOPERACION() {
		return TOPERACION;
	}
	public void setTOPERACION(String tOPERACION) {
		TOPERACION = tOPERACION;
	}
	public String getNPRESTAMO() {
		return NPRESTAMO;
	}
	public void setNPRESTAMO(String nPRESTAMO) {
		NPRESTAMO = nPRESTAMO;
	}
	public String getFDSBOLSO() {
		return FDSBOLSO;
	}
	public void setFDSBOLSO(String fDSBOLSO) {
		FDSBOLSO = fDSBOLSO;
	}
	public String getSPRESTAMO() {
		return SPRESTAMO;
	}
	public void setSPRESTAMO(String sPRESTAMO) {
		SPRESTAMO = sPRESTAMO;
	}
	public String getSAMORTIZADO() {
		return SAMORTIZADO;
	}
	public void setSAMORTIZADO(String sAMORTIZADO) {
		SAMORTIZADO = sAMORTIZADO;
	}
	public String getSACTUAL() {
		return SACTUAL;
	}
	public void setSACTUAL(String sACTUAL) {
		SACTUAL = sACTUAL;
	}
	public String getSDEUDA_D() {
		return SDEUDA_D;
	}
	public void setSDEUDA_D(String sDEUDA_D) {
		SDEUDA_D = sDEUDA_D;
	}
	public String getNCUOTAS() {
		return NCUOTAS;
	}
	public void setNCUOTAS(String nCUOTAS) {
		NCUOTAS = nCUOTAS;
	}
	
	public ArrayList<String> getBCUOTA() {
		return BCUOTA;
	}
	public void setBCUOTA(ArrayList<String> bCUOTA) {
		BCUOTA = bCUOTA;
	}
	public ArrayList<String> getACUOTA() {
		return ACUOTA;
	}
	public void setACUOTA(ArrayList<String> aCUOTA) {
		ACUOTA = aCUOTA;
	}
	public ArrayList<String> getFVCTO() {
		return FVCTO;
	}
	public void setFVCTO(ArrayList<String> fVCTO) {
		FVCTO = fVCTO;
	}
	public ArrayList<String> getFCANCEL() {
		return FCANCEL;
	}
	public void setFCANCEL(ArrayList<String> fCANCEL) {
		FCANCEL = fCANCEL;
	}
	public ArrayList<String> getGCUOTA() {
		return GCUOTA;
	}
	public void setGCUOTA(ArrayList<String> gCUOTA) {
		GCUOTA = gCUOTA;
	}
	public ArrayList<String> getSAMORTIZACION() {
		return SAMORTIZACION;
	}
	public void setSAMORTIZACION(ArrayList<String> sAMORTIZACION) {
		SAMORTIZACION = sAMORTIZACION;
	}
	public ArrayList<String> getSINTERES() {
		return SINTERES;
	}
	public void setSINTERES(ArrayList<String> sINTERES) {
		SINTERES = sINTERES;
	}
	public ArrayList<String> getSDESGRAVAMEN() {
		return SDESGRAVAMEN;
	}
	public void setSDESGRAVAMEN(ArrayList<String> sDESGRAVAMEN) {
		SDESGRAVAMEN = sDESGRAVAMEN;
	}
	public ArrayList<String> getSDCUOTA() {
		return SDCUOTA;
	}
	public void setSDCUOTA(ArrayList<String> sDCUOTA) {
		SDCUOTA = sDCUOTA;
	}
	
	
	
	public String getACLIENTE() {
		return ACLIENTE;
	}
	public void setACLIENTE(String aCLIENTE) {
		ACLIENTE = aCLIENTE;
	}
	public String getDOCUMENTO() {
		return DOCUMENTO;
	}
	public void setDOCUMENTO(String dOCUMENTO) {
		DOCUMENTO = dOCUMENTO;
	}
	public String getTELEFONO() {
		return TELEFONO;
	}
	public void setTELEFONO(String tELEFONO) {
		TELEFONO = tELEFONO;
	}
	public String getDCLIENTE() {
		return DCLIENTE;
	}
	public void setDCLIENTE(String dCLIENTE) {
		DCLIENTE = dCLIENTE;
	}
	public String getDOCUMGAR() {
		return DOCUMGAR;
	}
	public void setDOCUMGAR(String dOCUMGAR) {
		DOCUMGAR = dOCUMGAR;
	}
	public String getAGARANTE() {
		return AGARANTE;
	}
	public void setAGARANTE(String aGARANTE) {
		AGARANTE = aGARANTE;
	}
	public String getDGARANTE() {
		return DGARANTE;
	}
	public void setDGARANTE(String dGARANTE) {
		DGARANTE = dGARANTE;
	}
	
	
	public String getTASA() {
		return TASA;
	}
	public void setTASA(String tASA) {
		TASA = tASA;
	}
	public String getTCEA() {
		return TCEA;
	}
	public void setTCEA(String tCEA) {
		TCEA = tCEA;
	}
	public String getSGCPRO() {
		return SGCPRO;
	}
	public void setSGCPRO(String sGCPRO) {
		SGCPRO = sGCPRO;
	}
	public String getCERROR() {
		return CERROR;
	}
	public void setCERROR(String cERROR) {
		CERROR = cERROR;
	}
	public String getMSJ() {
		return MSJ;
	}
	public void setMSJ(String mSJ) {
		MSJ = mSJ;
	}
	
	private String MSGNO_HOST;
	private String MSJE_HOST;

	public String getMSGNO_HOST() {
		return MSGNO_HOST;
	}
	public void setMSGNO_HOST(String mSGNO_HOST) {
		MSGNO_HOST = mSGNO_HOST;
	}
	
	public String getMSJE_HOST() {
		return MSJE_HOST;
	}
	public void setMSJE_HOST(String mSJE_HOST) {
		MSJE_HOST = mSJE_HOST;
	}	

}
