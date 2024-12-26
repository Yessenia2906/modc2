package pe.com.bn.modc.domain.mapper;

import java.util.ArrayList;
import java.util.Collection;

import pe.com.bn.modc.model.WSData.Campo;

public class BnCancelacion {

	private String TIPDOC;
	private String NUMDOC ;
	private String APELLTIT;
	private String NOMBRTIT;
	private String ESTCV;
	private String SEXO;
	private String TIPVIV;
	private String DEPENDI;
	private String MAIL;
	private String CODVIA;
	private String NOMVIA;
	private String CODZON;
	private String NOMZON;
	private String UBGCLI;
	private String REFEREN;
	private String TLFCASA;
	private String TLFCELL;
	private String EMPLAB_TIT;
	private String FCHING;
	private String CODVIA_LAB;
	private String NOMVIA_LAB;
	private String NUMVIA_LAB;
	private String CODZON_LAB;
	private String NOMZON_LAB;
	private String UBGDOM_LAB;
	private String REFEREN_LAB;
	private String TLFLAB;
	private String ANXLAB;
	private String REFERENPER;
	private String TLFREF;
	private String NOMBRE_CYG;
	private String EMPLAB_CYG;
	private String TLFTRA_CYG;
	private String ANXTRA_CYG;
	private String LINCRE_GLB;
	private String CCLO_FAC;
	private String TIPCTA_CAR;
	private String MON_CAR;
	private String CTA_CAR;
	private String NOMCOR_CLI;
	private String LINCRE_CTA;
	private String CCLOFAC_CTA;
	private String FCH_NAC;
	private String SLD_CLI;
	private String BLQ_CAR;
	private String BLQ_CTA;
	private String PLAN_CAS;
	private String PLAN_RET;
	private String COD_AGE;
	private String CODCTR_EVA;
	private String CODPROMOTOR;
	private String CODFUNCION;
	private String NOM_EN_PLAST;
	private String NOM_EMP_PLAST;
	private String TIPDIR_ENT;
	private String CODVIA_ENT;  
	private String NOMVIA_ENT;
	private String NUMVIA_ENT;
	private String CODZON_ENT;
	private String NOMZON_ENT;
	private String UBGDOM_ENT;
	private String REFEREN_ENT;
	private String MANDATR_01;
	private String MANDATR_02;
	private String UBG_CLI_DEP;
	private String UBG_CLI_PRO;   
	private String UBG_CLI_DIS;
	private String UBG_DOM_LAB_DEP;	
	private String UBG_DOM_LAB_PRO;
	private String UBG_DOM_LAB_DIS;	
	private String UBG_ZON_ENT_DEP;	
	private String UBG_ZON_ENT_PRO;
	private String UBG_ZON_ENT_DIS;
	private String LCORRES;
	private String DISPOS;
	private String ENDOSO;	
	private String NOTIFICA;
	private String OEXTERIO;
	private String MVIRTUAL;
	private String NPOLIZA;
	private String TIPTARJETA;
	private String CONDLABORA;
	private String CTAAHORRO;
	private String NROTARJETA;
	private String CELL_SMS;
	private String FCH_SOLICITA;
	private String NOM_TECNICO;
	private String NOM_FUNCIONARIO;	
	private String NOM_AGENCIA;
	private String COD_AGENCIA;
	private String NOB_VIA_TIT;	
	private String NOB_VIA_LAB;
	private String SECTOR;
	private String SDESGRAVA;
	private String DDEPEND;	
	private String NTELEF_DEPEND;
	private String NROTARJDEB;
	private String CORRELATIVO;
	private String ANEXOLABO;	
	private String IND_ARRAY;
	private String TIPOCARDADI_01;
	private String NUMECARDADI_01;	
	private String LINECARDADI_01;
	private String TIPDOC_ADI_01;
	private String NUMDOC_ADI_01;
	private String APELL_ADI_01;	
	private String NOMBR_ADI_01;
	private String FCHNAC_ADI_01;	
	private String SEXO_ADI_01;
	private String DISPOS_ADI_01;
	private String FECHAOPER_ADI_01;
	private String TIPOCARDADI_02;	
	private String NUMECARDADI_02;
	private String LINECARDADI_02;
	private String TIPDOC_ADI_02;
	private String NUMDOC_ADI_02;
	private String APELL_ADI_02;	
	private String NOMBR_ADI_02;
	private String FCHNAC_ADI_02;
	private String SEXO_ADI_02;
	private String DISPOS_ADI_02;
	private String FECHAOPER_ADI_02;	
	private String TIPOCARDADI_03;	
	private String NUMECARDADI_03;
	private String LINECARDADI_03;
	private String TIPDOC_ADI_03;
	private String NUMDOC_ADI_03;
	private String APELL_ADI_03;	
	private String NOMBR_ADI_03;	
	private String FCHNAC_ADI_03;
	private String SEXO_ADI_03;
	private String DISPOS_ADI_03;
	private String FECHAOPER_ADI_03;
	private String TIPOCARDADI_04;
	private String NUMECARDADI_04;
	private String LINECARDADI_04;
	private String TIPDOC_ADI_04;
	private String NUMDOC_ADI_04;
	private String APELL_ADI_04;	
	private String NOMBR_ADI_04;	
	private String FCHNAC_ADI_04;
	private String SEXO_ADI_04;
	private String DISPOS_ADI_04;	
	private String FECHAOPER_ADI_04;
	private String PERSONA_AUTOR;	
	private String TDOCUM_AUTOR;
	private String NDOCUM_AUTOR;
	private String NOMBRE_GRABAR;	
	private String NUMPAGARE;
	private String FDSBOLSO;	
	private String SDSBOLSO;
	private String SDEUDA_T;
	private String FSOLICITUD;
	private String SPENDIENTE;
	private String STASA_T;	
	private String STASA_TA;
	private String SCUOTA;
	private String NCUOTA_T;
	private String CODRESP;
	private String MSGRESP;
	
	private String NUMVIA;
	private String ANEXOLABOR;
	public String getANEXOLABO() {
		return ANEXOLABO;
	}
	public void setANEXOLABO(String anexolabo) {
		ANEXOLABO = anexolabo;
	}
	public String getANXLAB() {
		return ANXLAB;
	}
	public void setANXLAB(String anxlab) {
		ANXLAB = anxlab;
	}
	public String getANXTRA_CYG() {
		return ANXTRA_CYG;
	}
	public void setANXTRA_CYG(String anxtra_cyg) {
		ANXTRA_CYG = anxtra_cyg;
	}
	public String getAPELL_ADI_01() {
		return APELL_ADI_01;
	}
	public void setAPELL_ADI_01(String apell_adi_01) {
		APELL_ADI_01 = apell_adi_01;
	}
	public String getAPELL_ADI_02() {
		return APELL_ADI_02;
	}
	public void setAPELL_ADI_02(String apell_adi_02) {
		APELL_ADI_02 = apell_adi_02;
	}
	public String getAPELL_ADI_03() {
		return APELL_ADI_03;
	}
	public void setAPELL_ADI_03(String apell_adi_03) {
		APELL_ADI_03 = apell_adi_03;
	}
	public String getAPELL_ADI_04() {
		return APELL_ADI_04;
	}
	public void setAPELL_ADI_04(String apell_adi_04) {
		APELL_ADI_04 = apell_adi_04;
	}
	public String getAPELLTIT() {
		return APELLTIT;
	}
	public void setAPELLTIT(String apelltit) {
		APELLTIT = apelltit;
	}
	public String getBLQ_CAR() {
		return BLQ_CAR;
	}
	public void setBLQ_CAR(String blq_car) {
		BLQ_CAR = blq_car;
	}
	public String getBLQ_CTA() {
		return BLQ_CTA;
	}
	public void setBLQ_CTA(String blq_cta) {
		BLQ_CTA = blq_cta;
	}
	public String getCCLO_FAC() {
		return CCLO_FAC;
	}
	public void setCCLO_FAC(String cclo_fac) {
		CCLO_FAC = cclo_fac;
	}
	public String getCCLOFAC_CTA() {
		return CCLOFAC_CTA;
	}
	public void setCCLOFAC_CTA(String cclofac_cta) {
		CCLOFAC_CTA = cclofac_cta;
	}
	public String getCELL_SMS() {
		return CELL_SMS;
	}
	public void setCELL_SMS(String cell_sms) {
		CELL_SMS = cell_sms;
	}
	public String getCOD_AGE() {
		return COD_AGE;
	}
	public void setCOD_AGE(String cod_age) {
		COD_AGE = cod_age;
	}
	public String getCOD_AGENCIA() {
		return COD_AGENCIA;
	}
	public void setCOD_AGENCIA(String cod_agencia) {
		COD_AGENCIA = cod_agencia;
	}
	public String getCODCTR_EVA() {
		return CODCTR_EVA;
	}
	public void setCODCTR_EVA(String codctr_eva) {
		CODCTR_EVA = codctr_eva;
	}
	public String getCODFUNCION() {
		return CODFUNCION;
	}
	public void setCODFUNCION(String codfuncion) {
		CODFUNCION = codfuncion;
	}
	public String getCODPROMOTOR() {
		return CODPROMOTOR;
	}
	public void setCODPROMOTOR(String codpromotor) {
		CODPROMOTOR = codpromotor;
	}
	public String getCODRESP() {
		return CODRESP;
	}
	public void setCODRESP(String codresp) {
		CODRESP = codresp;
	}
	public String getCODVIA() {
		return CODVIA;
	}
	public void setCODVIA(String codvia) {
		CODVIA = codvia;
	}
	public String getCODVIA_ENT() {
		return CODVIA_ENT;
	}
	public void setCODVIA_ENT(String codvia_ent) {
		CODVIA_ENT = codvia_ent;
	}
	public String getCODVIA_LAB() {
		return CODVIA_LAB;
	}
	public void setCODVIA_LAB(String codvia_lab) {
		CODVIA_LAB = codvia_lab;
	}
	public String getCODZON() {
		return CODZON;
	}
	public void setCODZON(String codzon) {
		CODZON = codzon;
	}
	public String getCODZON_ENT() {
		return CODZON_ENT;
	}
	public void setCODZON_ENT(String codzon_ent) {
		CODZON_ENT = codzon_ent;
	}
	public String getCODZON_LAB() {
		return CODZON_LAB;
	}
	public void setCODZON_LAB(String codzon_lab) {
		CODZON_LAB = codzon_lab;
	}
	public String getCONDLABORA() {
		return CONDLABORA;
	}
	public void setCONDLABORA(String condlabora) {
		CONDLABORA = condlabora;
	}
	public String getCORRELATIVO() {
		return CORRELATIVO;
	}
	public void setCORRELATIVO(String correlativo) {
		CORRELATIVO = correlativo;
	}
	public String getCTA_CAR() {
		return CTA_CAR;
	}
	public void setCTA_CAR(String cta_car) {
		CTA_CAR = cta_car;
	}
	public String getCTAAHORRO() {
		return CTAAHORRO;
	}
	public void setCTAAHORRO(String ctaahorro) {
		CTAAHORRO = ctaahorro;
	}
	public String getDDEPEND() {
		return DDEPEND;
	}
	public void setDDEPEND(String ddepend) {
		DDEPEND = ddepend;
	}
	public String getDEPENDI() {
		return DEPENDI;
	}
	public void setDEPENDI(String dependi) {
		DEPENDI = dependi;
	}
	public String getDISPOS() {
		return DISPOS;
	}
	public void setDISPOS(String dispos) {
		DISPOS = dispos;
	}
	public String getDISPOS_ADI_01() {
		return DISPOS_ADI_01;
	}
	public void setDISPOS_ADI_01(String dispos_adi_01) {
		DISPOS_ADI_01 = dispos_adi_01;
	}
	public String getDISPOS_ADI_02() {
		return DISPOS_ADI_02;
	}
	public void setDISPOS_ADI_02(String dispos_adi_02) {
		DISPOS_ADI_02 = dispos_adi_02;
	}
	public String getDISPOS_ADI_03() {
		return DISPOS_ADI_03;
	}
	public void setDISPOS_ADI_03(String dispos_adi_03) {
		DISPOS_ADI_03 = dispos_adi_03;
	}
	public String getDISPOS_ADI_04() {
		return DISPOS_ADI_04;
	}
	public void setDISPOS_ADI_04(String dispos_adi_04) {
		DISPOS_ADI_04 = dispos_adi_04;
	}
	public String getEMPLAB_CYG() {
		return EMPLAB_CYG;
	}
	public void setEMPLAB_CYG(String emplab_cyg) {
		EMPLAB_CYG = emplab_cyg;
	}
	public String getEMPLAB_TIT() {
		return EMPLAB_TIT;
	}
	public void setEMPLAB_TIT(String emplab_tit) {
		EMPLAB_TIT = emplab_tit;
	}
	public String getENDOSO() {
		return ENDOSO;
	}
	public void setENDOSO(String endoso) {
		ENDOSO = endoso;
	}
	public String getESTCV() {
		return ESTCV;
	}
	public void setESTCV(String estcv) {
		ESTCV = estcv;
	}
	public String getFCH_NAC() {
		return FCH_NAC;
	}
	public void setFCH_NAC(String fch_nac) {
		FCH_NAC = fch_nac;
	}
	public String getFCH_SOLICITA() {
		return FCH_SOLICITA;
	}
	public void setFCH_SOLICITA(String fch_solicita) {
		FCH_SOLICITA = fch_solicita;
	}
	public String getFCHING() {
		return FCHING;
	}
	public void setFCHING(String fching) {
		FCHING = fching;
	}
	public String getFCHNAC_ADI_01() {
		return FCHNAC_ADI_01;
	}
	public void setFCHNAC_ADI_01(String fchnac_adi_01) {
		FCHNAC_ADI_01 = fchnac_adi_01;
	}
	public String getFCHNAC_ADI_02() {
		return FCHNAC_ADI_02;
	}
	public void setFCHNAC_ADI_02(String fchnac_adi_02) {
		FCHNAC_ADI_02 = fchnac_adi_02;
	}
	public String getFCHNAC_ADI_03() {
		return FCHNAC_ADI_03;
	}
	public void setFCHNAC_ADI_03(String fchnac_adi_03) {
		FCHNAC_ADI_03 = fchnac_adi_03;
	}
	public String getFCHNAC_ADI_04() {
		return FCHNAC_ADI_04;
	}
	public void setFCHNAC_ADI_04(String fchnac_adi_04) {
		FCHNAC_ADI_04 = fchnac_adi_04;
	}
	public String getFDSBOLSO() {
		return FDSBOLSO;
	}
	public void setFDSBOLSO(String fdsbolso) {
		FDSBOLSO = fdsbolso;
	}
	public String getFECHAOPER_ADI_01() {
		return FECHAOPER_ADI_01;
	}
	public void setFECHAOPER_ADI_01(String fechaoper_adi_01) {
		FECHAOPER_ADI_01 = fechaoper_adi_01;
	}
	public String getFECHAOPER_ADI_02() {
		return FECHAOPER_ADI_02;
	}
	public void setFECHAOPER_ADI_02(String fechaoper_adi_02) {
		FECHAOPER_ADI_02 = fechaoper_adi_02;
	}
	public String getFECHAOPER_ADI_03() {
		return FECHAOPER_ADI_03;
	}
	public void setFECHAOPER_ADI_03(String fechaoper_adi_03) {
		FECHAOPER_ADI_03 = fechaoper_adi_03;
	}
	public String getFECHAOPER_ADI_04() {
		return FECHAOPER_ADI_04;
	}
	public void setFECHAOPER_ADI_04(String fechaoper_adi_04) {
		FECHAOPER_ADI_04 = fechaoper_adi_04;
	}
	public String getFSOLICITUD() {
		return FSOLICITUD;
	}
	public void setFSOLICITUD(String fsolicitud) {
		FSOLICITUD = fsolicitud;
	}
	public String getIND_ARRAY() {
		return IND_ARRAY;
	}
	public void setIND_ARRAY(String ind_array) {
		IND_ARRAY = ind_array;
	}
	public String getLCORRES() {
		return LCORRES;
	}
	public void setLCORRES(String lcorres) {
		LCORRES = lcorres;
	}
	public String getLINCRE_CTA() {
		return LINCRE_CTA;
	}
	public void setLINCRE_CTA(String lincre_cta) {
		LINCRE_CTA = lincre_cta;
	}
	public String getLINCRE_GLB() {
		return LINCRE_GLB;
	}
	public void setLINCRE_GLB(String lincre_glb) {
		LINCRE_GLB = lincre_glb;
	}
	public String getLINECARDADI_01() {
		return LINECARDADI_01;
	}
	public void setLINECARDADI_01(String linecardadi_01) {
		LINECARDADI_01 = linecardadi_01;
	}
	public String getLINECARDADI_02() {
		return LINECARDADI_02;
	}
	public void setLINECARDADI_02(String linecardadi_02) {
		LINECARDADI_02 = linecardadi_02;
	}
	public String getLINECARDADI_03() {
		return LINECARDADI_03;
	}
	public void setLINECARDADI_03(String linecardadi_03) {
		LINECARDADI_03 = linecardadi_03;
	}
	public String getLINECARDADI_04() {
		return LINECARDADI_04;
	}
	public void setLINECARDADI_04(String linecardadi_04) {
		LINECARDADI_04 = linecardadi_04;
	}
	public String getMAIL() {
		return MAIL;
	}
	public void setMAIL(String mail) {
		MAIL = mail;
	}
	public String getMANDATR_01() {
		return MANDATR_01;
	}
	public void setMANDATR_01(String mandatr_01) {
		MANDATR_01 = mandatr_01;
	}
	public String getMANDATR_02() {
		return MANDATR_02;
	}
	public void setMANDATR_02(String mandatr_02) {
		MANDATR_02 = mandatr_02;
	}
	public String getMON_CAR() {
		return MON_CAR;
	}
	public void setMON_CAR(String mon_car) {
		MON_CAR = mon_car;
	}
	public String getMSGRESP() {
		return MSGRESP;
	}
	public void setMSGRESP(String msgresp) {
		MSGRESP = msgresp;
	}
	public String getMVIRTUAL() {
		return MVIRTUAL;
	}
	public void setMVIRTUAL(String mvirtual) {
		MVIRTUAL = mvirtual;
	}
	public String getNCUOTA_T() {
		return NCUOTA_T;
	}
	public void setNCUOTA_T(String ncuota_t) {
		NCUOTA_T = ncuota_t;
	}
	public String getNDOCUM_AUTOR() {
		return NDOCUM_AUTOR;
	}
	public void setNDOCUM_AUTOR(String ndocum_autor) {
		NDOCUM_AUTOR = ndocum_autor;
	}
	public String getNOB_VIA_LAB() {
		return NOB_VIA_LAB;
	}
	public void setNOB_VIA_LAB(String nob_via_lab) {
		NOB_VIA_LAB = nob_via_lab;
	}
	public String getNOB_VIA_TIT() {
		return NOB_VIA_TIT;
	}
	public void setNOB_VIA_TIT(String nob_via_tit) {
		NOB_VIA_TIT = nob_via_tit;
	}
	public String getNOM_AGENCIA() {
		return NOM_AGENCIA;
	}
	public void setNOM_AGENCIA(String nom_agencia) {
		NOM_AGENCIA = nom_agencia;
	}
	public String getNOM_EMP_PLAST() {
		return NOM_EMP_PLAST;
	}
	public void setNOM_EMP_PLAST(String nom_emp_plast) {
		NOM_EMP_PLAST = nom_emp_plast;
	}
	public String getNOM_EN_PLAST() {
		return NOM_EN_PLAST;
	}
	public void setNOM_EN_PLAST(String nom_en_plast) {
		NOM_EN_PLAST = nom_en_plast;
	}
	public String getNOM_FUNCIONARIO() {
		return NOM_FUNCIONARIO;
	}
	public void setNOM_FUNCIONARIO(String nom_funcionario) {
		NOM_FUNCIONARIO = nom_funcionario;
	}
	public String getNOM_TECNICO() {
		return NOM_TECNICO;
	}
	public void setNOM_TECNICO(String nom_tecnico) {
		NOM_TECNICO = nom_tecnico;
	}
	public String getNOMBR_ADI_01() {
		return NOMBR_ADI_01;
	}
	public void setNOMBR_ADI_01(String nombr_adi_01) {
		NOMBR_ADI_01 = nombr_adi_01;
	}
	public String getNOMBR_ADI_02() {
		return NOMBR_ADI_02;
	}
	public void setNOMBR_ADI_02(String nombr_adi_02) {
		NOMBR_ADI_02 = nombr_adi_02;
	}
	public String getNOMBR_ADI_03() {
		return NOMBR_ADI_03;
	}
	public void setNOMBR_ADI_03(String nombr_adi_03) {
		NOMBR_ADI_03 = nombr_adi_03;
	}
	public String getNOMBR_ADI_04() {
		return NOMBR_ADI_04;
	}
	public void setNOMBR_ADI_04(String nombr_adi_04) {
		NOMBR_ADI_04 = nombr_adi_04;
	}
	public String getNOMBRE_CYG() {
		return NOMBRE_CYG;
	}
	public void setNOMBRE_CYG(String nombre_cyg) {
		NOMBRE_CYG = nombre_cyg;
	}
	public String getNOMBRE_GRABAR() {
		return NOMBRE_GRABAR;
	}
	public void setNOMBRE_GRABAR(String nombre_grabar) {
		NOMBRE_GRABAR = nombre_grabar;
	}
	public String getNOMBRTIT() {
		return NOMBRTIT;
	}
	public void setNOMBRTIT(String nombrtit) {
		NOMBRTIT = nombrtit;
	}
	public String getNOMCOR_CLI() {
		return NOMCOR_CLI;
	}
	public void setNOMCOR_CLI(String nomcor_cli) {
		NOMCOR_CLI = nomcor_cli;
	}
	public String getNOMVIA() {
		return NOMVIA;
	}
	public void setNOMVIA(String nomvia) {
		NOMVIA = nomvia;
	}
	public String getNOMVIA_ENT() {
		return NOMVIA_ENT;
	}
	public void setNOMVIA_ENT(String nomvia_ent) {
		NOMVIA_ENT = nomvia_ent;
	}
	public String getNOMVIA_LAB() {
		return NOMVIA_LAB;
	}
	public void setNOMVIA_LAB(String nomvia_lab) {
		NOMVIA_LAB = nomvia_lab;
	}
	public String getNOMZON() {
		return NOMZON;
	}
	public void setNOMZON(String nomzon) {
		NOMZON = nomzon;
	}
	public String getNOMZON_ENT() {
		return NOMZON_ENT;
	}
	public void setNOMZON_ENT(String nomzon_ent) {
		NOMZON_ENT = nomzon_ent;
	}
	public String getNOMZON_LAB() {
		return NOMZON_LAB;
	}
	public void setNOMZON_LAB(String nomzon_lab) {
		NOMZON_LAB = nomzon_lab;
	}
	public String getNOTIFICA() {
		return NOTIFICA;
	}
	public void setNOTIFICA(String notifica) {
		NOTIFICA = notifica;
	}
	public String getNPOLIZA() {
		return NPOLIZA;
	}
	public void setNPOLIZA(String npoliza) {
		NPOLIZA = npoliza;
	}
	public String getNROTARJDEB() {
		return NROTARJDEB;
	}
	public void setNROTARJDEB(String nrotarjdeb) {
		NROTARJDEB = nrotarjdeb;
	}
	public String getNROTARJETA() {
		return NROTARJETA;
	}
	public void setNROTARJETA(String nrotarjeta) {
		NROTARJETA = nrotarjeta;
	}
	public String getNTELEF_DEPEND() {
		return NTELEF_DEPEND;
	}
	public void setNTELEF_DEPEND(String ntelef_depend) {
		NTELEF_DEPEND = ntelef_depend;
	}
	public String getNUMDOC() {
		return NUMDOC;
	}
	public void setNUMDOC(String numdoc) {
		NUMDOC = numdoc;
	}
	public String getNUMDOC_ADI_01() {
		return NUMDOC_ADI_01;
	}
	public void setNUMDOC_ADI_01(String numdoc_adi_01) {
		NUMDOC_ADI_01 = numdoc_adi_01;
	}
	public String getNUMDOC_ADI_02() {
		return NUMDOC_ADI_02;
	}
	public void setNUMDOC_ADI_02(String numdoc_adi_02) {
		NUMDOC_ADI_02 = numdoc_adi_02;
	}
	public String getNUMDOC_ADI_03() {
		return NUMDOC_ADI_03;
	}
	public void setNUMDOC_ADI_03(String numdoc_adi_03) {
		NUMDOC_ADI_03 = numdoc_adi_03;
	}
	public String getNUMDOC_ADI_04() {
		return NUMDOC_ADI_04;
	}
	public void setNUMDOC_ADI_04(String numdoc_adi_04) {
		NUMDOC_ADI_04 = numdoc_adi_04;
	}
	public String getNUMECARDADI_01() {
		return NUMECARDADI_01;
	}
	public void setNUMECARDADI_01(String numecardadi_01) {
		NUMECARDADI_01 = numecardadi_01;
	}
	public String getNUMECARDADI_02() {
		return NUMECARDADI_02;
	}
	public void setNUMECARDADI_02(String numecardadi_02) {
		NUMECARDADI_02 = numecardadi_02;
	}
	public String getNUMECARDADI_03() {
		return NUMECARDADI_03;
	}
	public void setNUMECARDADI_03(String numecardadi_03) {
		NUMECARDADI_03 = numecardadi_03;
	}
	public String getNUMECARDADI_04() {
		return NUMECARDADI_04;
	}
	public void setNUMECARDADI_04(String numecardadi_04) {
		NUMECARDADI_04 = numecardadi_04;
	}
	public String getNUMPAGARE() {
		return NUMPAGARE;
	}
	public void setNUMPAGARE(String numpagare) {
		NUMPAGARE = numpagare;
	}
	public String getNUMVIA_ENT() {
		return NUMVIA_ENT;
	}
	public void setNUMVIA_ENT(String numvia_ent) {
		NUMVIA_ENT = numvia_ent;
	}
	public String getNUMVIA_LAB() {
		return NUMVIA_LAB;
	}
	public void setNUMVIA_LAB(String numvia_lab) {
		NUMVIA_LAB = numvia_lab;
	}
	public String getOEXTERIO() {
		return OEXTERIO;
	}
	public void setOEXTERIO(String oexterio) {
		OEXTERIO = oexterio;
	}
	public String getPERSONA_AUTOR() {
		return PERSONA_AUTOR;
	}
	public void setPERSONA_AUTOR(String persona_autor) {
		PERSONA_AUTOR = persona_autor;
	}
	public String getPLAN_CAS() {
		return PLAN_CAS;
	}
	public void setPLAN_CAS(String plan_cas) {
		PLAN_CAS = plan_cas;
	}
	public String getPLAN_RET() {
		return PLAN_RET;
	}
	public void setPLAN_RET(String plan_ret) {
		PLAN_RET = plan_ret;
	}
	public String getREFEREN() {
		return REFEREN;
	}
	public void setREFEREN(String referen) {
		REFEREN = referen;
	}
	public String getREFEREN_ENT() {
		return REFEREN_ENT;
	}
	public void setREFEREN_ENT(String referen_ent) {
		REFEREN_ENT = referen_ent;
	}
	public String getREFEREN_LAB() {
		return REFEREN_LAB;
	}
	public void setREFEREN_LAB(String referen_lab) {
		REFEREN_LAB = referen_lab;
	}
	public String getREFERENPER() {
		return REFERENPER;
	}
	public void setREFERENPER(String referenper) {
		REFERENPER = referenper;
	}
	public String getSCUOTA() {
		return SCUOTA;
	}
	public void setSCUOTA(String scuota) {
		SCUOTA = scuota;
	}
	public String getSDESGRAVA() {
		return SDESGRAVA;
	}
	public void setSDESGRAVA(String sdesgrava) {
		SDESGRAVA = sdesgrava;
	}
	public String getSDEUDA_T() {
		return SDEUDA_T;
	}
	public void setSDEUDA_T(String sdeuda_t) {
		SDEUDA_T = sdeuda_t;
	}
	public String getSDSBOLSO() {
		return SDSBOLSO;
	}
	public void setSDSBOLSO(String sdsbolso) {
		SDSBOLSO = sdsbolso;
	}
	public String getSECTOR() {
		return SECTOR;
	}
	public void setSECTOR(String sector) {
		SECTOR = sector;
	}
	public String getSEXO() {
		return SEXO;
	}
	public void setSEXO(String sexo) {
		SEXO = sexo;
	}
	public String getSEXO_ADI_01() {
		return SEXO_ADI_01;
	}
	public void setSEXO_ADI_01(String sexo_adi_01) {
		SEXO_ADI_01 = sexo_adi_01;
	}
	public String getSEXO_ADI_02() {
		return SEXO_ADI_02;
	}
	public void setSEXO_ADI_02(String sexo_adi_02) {
		SEXO_ADI_02 = sexo_adi_02;
	}
	public String getSEXO_ADI_03() {
		return SEXO_ADI_03;
	}
	public void setSEXO_ADI_03(String sexo_adi_03) {
		SEXO_ADI_03 = sexo_adi_03;
	}
	public String getSEXO_ADI_04() {
		return SEXO_ADI_04;
	}
	public void setSEXO_ADI_04(String sexo_adi_04) {
		SEXO_ADI_04 = sexo_adi_04;
	}
	public String getSLD_CLI() {
		return SLD_CLI;
	}
	public void setSLD_CLI(String sld_cli) {
		SLD_CLI = sld_cli;
	}
	public String getSPENDIENTE() {
		return SPENDIENTE;
	}
	public void setSPENDIENTE(String spendiente) {
		SPENDIENTE = spendiente;
	}
	public String getSTASA_T() {
		return STASA_T;
	}
	public void setSTASA_T(String stasa_t) {
		STASA_T = stasa_t;
	}
	public String getSTASA_TA() {
		return STASA_TA;
	}
	public void setSTASA_TA(String stasa_ta) {
		STASA_TA = stasa_ta;
	}
	public String getTDOCUM_AUTOR() {
		return TDOCUM_AUTOR;
	}
	public void setTDOCUM_AUTOR(String tdocum_autor) {
		TDOCUM_AUTOR = tdocum_autor;
	}
	public String getTIPCTA_CAR() {
		return TIPCTA_CAR;
	}
	public void setTIPCTA_CAR(String tipcta_car) {
		TIPCTA_CAR = tipcta_car;
	}
	public String getTIPDIR_ENT() {
		return TIPDIR_ENT;
	}
	public void setTIPDIR_ENT(String tipdir_ent) {
		TIPDIR_ENT = tipdir_ent;
	}
	public String getTIPDOC() {
		return TIPDOC;
	}
	public void setTIPDOC(String tipdoc) {
		TIPDOC = tipdoc;
	}
	public String getTIPDOC_ADI_01() {
		return TIPDOC_ADI_01;
	}
	public void setTIPDOC_ADI_01(String tipdoc_adi_01) {
		TIPDOC_ADI_01 = tipdoc_adi_01;
	}
	public String getTIPDOC_ADI_02() {
		return TIPDOC_ADI_02;
	}
	public void setTIPDOC_ADI_02(String tipdoc_adi_02) {
		TIPDOC_ADI_02 = tipdoc_adi_02;
	}
	public String getTIPDOC_ADI_03() {
		return TIPDOC_ADI_03;
	}
	public void setTIPDOC_ADI_03(String tipdoc_adi_03) {
		TIPDOC_ADI_03 = tipdoc_adi_03;
	}
	public String getTIPDOC_ADI_04() {
		return TIPDOC_ADI_04;
	}
	public void setTIPDOC_ADI_04(String tipdoc_adi_04) {
		TIPDOC_ADI_04 = tipdoc_adi_04;
	}
	public String getTIPOCARDADI_01() {
		return TIPOCARDADI_01;
	}
	public void setTIPOCARDADI_01(String tipocardadi_01) {
		TIPOCARDADI_01 = tipocardadi_01;
	}
	public String getTIPOCARDADI_02() {
		return TIPOCARDADI_02;
	}
	public void setTIPOCARDADI_02(String tipocardadi_02) {
		TIPOCARDADI_02 = tipocardadi_02;
	}
	public String getTIPOCARDADI_03() {
		return TIPOCARDADI_03;
	}
	public void setTIPOCARDADI_03(String tipocardadi_03) {
		TIPOCARDADI_03 = tipocardadi_03;
	}
	public String getTIPOCARDADI_04() {
		return TIPOCARDADI_04;
	}
	public void setTIPOCARDADI_04(String tipocardadi_04) {
		TIPOCARDADI_04 = tipocardadi_04;
	}
	public String getTIPTARJETA() {
		return TIPTARJETA;
	}
	public void setTIPTARJETA(String tiptarjeta) {
		TIPTARJETA = tiptarjeta;
	}
	public String getTIPVIV() {
		return TIPVIV;
	}
	public void setTIPVIV(String tipviv) {
		TIPVIV = tipviv;
	}
	public String getTLFCASA() {
		return TLFCASA;
	}
	public void setTLFCASA(String tlfcasa) {
		TLFCASA = tlfcasa;
	}
	public String getTLFCELL() {
		return TLFCELL;
	}
	public void setTLFCELL(String tlfcell) {
		TLFCELL = tlfcell;
	}
	public String getTLFLAB() {
		return TLFLAB;
	}
	public void setTLFLAB(String tlflab) {
		TLFLAB = tlflab;
	}
	public String getTLFREF() {
		return TLFREF;
	}
	public void setTLFREF(String tlfref) {
		TLFREF = tlfref;
	}
	public String getTLFTRA_CYG() {
		return TLFTRA_CYG;
	}
	public void setTLFTRA_CYG(String tlftra_cyg) {
		TLFTRA_CYG = tlftra_cyg;
	}
	public String getUBG_CLI_DEP() {
		return UBG_CLI_DEP;
	}
	public void setUBG_CLI_DEP(String ubg_cli_dep) {
		UBG_CLI_DEP = ubg_cli_dep;
	}
	public String getUBG_CLI_DIS() {
		return UBG_CLI_DIS;
	}
	public void setUBG_CLI_DIS(String ubg_cli_dis) {
		UBG_CLI_DIS = ubg_cli_dis;
	}
	public String getUBG_CLI_PRO() {
		return UBG_CLI_PRO;
	}
	public void setUBG_CLI_PRO(String ubg_cli_pro) {
		UBG_CLI_PRO = ubg_cli_pro;
	}
	public String getUBG_DOM_LAB_DEP() {
		return UBG_DOM_LAB_DEP;
	}
	public void setUBG_DOM_LAB_DEP(String ubg_dom_lab_dep) {
		UBG_DOM_LAB_DEP = ubg_dom_lab_dep;
	}
	public String getUBG_DOM_LAB_DIS() {
		return UBG_DOM_LAB_DIS;
	}
	public void setUBG_DOM_LAB_DIS(String ubg_dom_lab_dis) {
		UBG_DOM_LAB_DIS = ubg_dom_lab_dis;
	}
	public String getUBG_DOM_LAB_PRO() {
		return UBG_DOM_LAB_PRO;
	}
	public void setUBG_DOM_LAB_PRO(String ubg_dom_lab_pro) {
		UBG_DOM_LAB_PRO = ubg_dom_lab_pro;
	}
	public String getUBG_ZON_ENT_DEP() {
		return UBG_ZON_ENT_DEP;
	}
	public void setUBG_ZON_ENT_DEP(String ubg_zon_ent_dep) {
		UBG_ZON_ENT_DEP = ubg_zon_ent_dep;
	}
	public String getUBG_ZON_ENT_DIS() {
		return UBG_ZON_ENT_DIS;
	}
	public void setUBG_ZON_ENT_DIS(String ubg_zon_ent_dis) {
		UBG_ZON_ENT_DIS = ubg_zon_ent_dis;
	}
	public String getUBG_ZON_ENT_PRO() {
		return UBG_ZON_ENT_PRO;
	}
	public void setUBG_ZON_ENT_PRO(String ubg_zon_ent_pro) {
		UBG_ZON_ENT_PRO = ubg_zon_ent_pro;
	}
	public String getUBGCLI() {
		return UBGCLI;
	}
	public void setUBGCLI(String ubgcli) {
		UBGCLI = ubgcli;
	}
	public String getUBGDOM_ENT() {
		return UBGDOM_ENT;
	}
	public void setUBGDOM_ENT(String ubgdom_ent) {
		UBGDOM_ENT = ubgdom_ent;
	}
	public String getUBGDOM_LAB() {
		return UBGDOM_LAB;
	}
	public void setUBGDOM_LAB(String ubgdom_lab) {
		UBGDOM_LAB = ubgdom_lab;
	}
	public String getANEXOLABOR() {
		return ANEXOLABOR;
	}
	public void setANEXOLABOR(String anexolabor) {
		ANEXOLABOR = anexolabor;
	}
	public String getNUMVIA() {
		return NUMVIA;
	}
	public void setNUMVIA(String numvia) {
		NUMVIA = numvia;
	}


}
