package pe.com.bn.modc.domain.mapper;

import java.util.ArrayList;

public class BnLetraCambio {
	
	private String TOPERACION;
	private String NPRESTAMO;
	private String FVALOR;
	private String FDSBOLSO;
    private String FDEMANDA;
	private String FCTACTE;
	private String SPRESTAMO;
	private String SAMORTIZADO;
	private String SACTUAL;
	private String SDEUDA_D;
	private String NCUOTAS;
	
	
	ArrayList<String> BCUOTA = new ArrayList<String>();
	ArrayList<String> ACUOTA = new ArrayList<String>();
	ArrayList<String> FVCTO = new ArrayList<String>();
	ArrayList<String> FCANCEL = new ArrayList<String>();
	ArrayList<String> GCUOTA = new ArrayList<String>();
	ArrayList<String> SAMORTIZACION = new ArrayList<String>();
	ArrayList<String> SINTERES = new ArrayList<String>();
	
	
	
	ArrayList<String> SINTCOMP1 = new ArrayList<String>();
	
	ArrayList<String> SINTMORA1 = new ArrayList<String>();

	
	ArrayList<String> SDESGRAVAMEN = new ArrayList<String>();
	ArrayList<String> SDCUOTA = new ArrayList<String>();
	
	
	
	
	public ArrayList<String> getSINTCOMP1() {
		return SINTCOMP1;
	}
	public void setSINTCOMP1(ArrayList<String> sINTCOMP1) {
		SINTCOMP1 = sINTCOMP1;
	}
	public ArrayList<String> getSINTMORA1() {
		return SINTMORA1;
	}
	public void setSINTMORA1(ArrayList<String> sINTMORA1) {
		SINTMORA1 = sINTMORA1;
	}
	private String ACLIENTE;
	private String DOCUMENTO;
	private String TELEFONO;
	private String DCLIENTE;
	private String DOCUMGAR;
	private String AGARANTE;
	private String DGARANTE;
	private String TASA;
	private String TCEA;
	//
	private String TSEG;
	private String SINTVENC;
	private String SINTCOMP;
	private String SINTMORA;
	private String SSEGURO;
	private String SCUOTAP;

	
	
	
	
	public String getSINTVENC() {
		return SINTVENC;
	}
	public void setSINTVENC(String sINTVENC) {
		SINTVENC = sINTVENC;
	}
	public String getSINTCOMP() {
		return SINTCOMP;
	}
	public void setSINTCOMP(String sINTCOMP) {
		SINTCOMP = sINTCOMP;
	}
	public String getSINTMORA() {
		return SINTMORA;
	}
	public void setSINTMORA(String sINTMORA) {
		SINTMORA = sINTMORA;
	}
	public String getSSEGURO() {
		return SSEGURO;
	}
	public void setSSEGURO(String sSEGURO) {
		SSEGURO = sSEGURO;
	}
	public String getSCUOTAP() {
		return SCUOTAP;
	}
	public void setSCUOTAP(String sCUOTAP) {
		SCUOTAP = sCUOTAP;
	}
	public String getTSEG() {
		return TSEG;
	}
	public void setTSEG(String tSEG) {
		TSEG = tSEG;
	}
	//
	private String SGCPRO;
	private String CERROR;
	private String MSJ;
	
	
	private String NCUOTAS_JUD;
	private String SCUOTAP_JUD;
	private String COMENT1;
	private String COMENT2;
	private String NCUOTAS_PAG;
	private String SCUOTAS;
	private String CAGENCIA;
	private String SABONOS;
	private String QSBS;
	private String SINTERES1;
	private String SDESGRAV;
	private String SCONLAB;
	

	
	

	public String getNCUOTAS_JUD() {
		return NCUOTAS_JUD;
	}
	public void setNCUOTAS_JUD(String nCUOTAS_JUD) {
		NCUOTAS_JUD = nCUOTAS_JUD;
	}
	public String getSCUOTAP_JUD() {
		return SCUOTAP_JUD;
	}
	public void setSCUOTAP_JUD(String sCUOTAP_JUD) {
		SCUOTAP_JUD = sCUOTAP_JUD;
	}
	public String getCOMENT1() {
		return COMENT1;
	}
	public void setCOMENT1(String cOMENT1) {
		COMENT1 = cOMENT1;
	}
	public String getCOMENT2() {
		return COMENT2;
	}
	public void setCOMENT2(String cOMENT2) {
		COMENT2 = cOMENT2;
	}
	public String getNCUOTAS_PAG() {
		return NCUOTAS_PAG;
	}
	public void setNCUOTAS_PAG(String nCUOTAS_PAG) {
		NCUOTAS_PAG = nCUOTAS_PAG;
	}
	public String getSCUOTAS() {
		return SCUOTAS;
	}
	public void setSCUOTAS(String sCUOTAS) {
		SCUOTAS = sCUOTAS;
	}
	public String getCAGENCIA() {
		return CAGENCIA;
	}
	public void setCAGENCIA(String cAGENCIA) {
		CAGENCIA = cAGENCIA;
	}
	public String getSABONOS() {
		return SABONOS;
	}
	public void setSABONOS(String sABONOS) {
		SABONOS = sABONOS;
	}
	public String getQSBS() {
		return QSBS;
	}
	public void setQSBS(String qSBS) {
		QSBS = qSBS;
	}
	public String getSINTERES1() {
		return SINTERES1;
	}
	public void setSINTERES1(String sINTERES1) {
		SINTERES1 = sINTERES1;
	}
	public String getSDESGRAV() {
		return SDESGRAV;
	}
	public void setSDESGRAV(String sDESGRAV) {
		SDESGRAV = sDESGRAV;
	}
	public String getSCONLAB() {
		return SCONLAB;
	}
	public void setSCONLAB(String sCONLAB) {
		SCONLAB = sCONLAB;
	}
	private String MSGNO_HOST;
	private String MSJE_HOST;
	
	
	
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
	public String getFVALOR() {
		return FVALOR;
	}
	public void setFVALOR(String fVALOR) {
		FVALOR = fVALOR;
	}
	public String getFDSBOLSO() {
		return FDSBOLSO;
	}
	public void setFDSBOLSO(String fDSBOLSO) {
		FDSBOLSO = fDSBOLSO;
	}
	public String getFDEMANDA() {
		return FDEMANDA;
	}
	public void setFDEMANDA(String fDEMANDA) {
		FDEMANDA = fDEMANDA;
	}
	public String getFCTACTE() {
		return FCTACTE;
	}
	public void setFCTACTE(String fCTACTE) {
		FCTACTE = fCTACTE;
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
