 package pe.com.bn.modc.trama.interactive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;




import pe.com.bn.modc.common.Constante;
import pe.com.bn.modc.common.Funciones;
import pe.com.bn.modc.domain.mapper.BnCancelacion;
import pe.com.bn.modc.domain.mapper.BnHojaResumen;
import pe.com.bn.modc.domain.mapper.BnPoliza;
import pe.com.bn.modc.domain.mapper.BnPolizaPrestamo;
import pe.com.bn.modc.domain.mapper.BnSolicitud;
import pe.com.bn.modc.domain.mapper.BnSolicitudPrestamo;
import pe.com.bn.modc.model.BodyCancelacion;
import pe.com.bn.modc.model.BodyCronograma;
import pe.com.bn.modc.model.BodyHojaResumen;
import pe.com.bn.modc.model.BodyPolizaPrestamo;
import pe.com.bn.modc.model.BodySolicitud;
import pe.com.bn.modc.model.BodySolicitud2;
import pe.com.bn.modc.model.BodySolicitudPrestamo;
import pe.com.bn.modc.model.Head;
import pe.com.bn.modc.model.WSData.Campo;

import pe.com.bn.comun.log.LoggerMODC;


public class RequestMensajeHost {
	private static LoggerMODC log3 = LoggerMODC.getInstance(RequestMensajeHost.class.getName());
	
	


	public  BnSolicitud getSolicitud(String tipo, String dni,String user){

		CicsSoapConnection cics =  new CicsSoapConnection();
		
		BnSolicitud solicitud = null;
 try {
	    	Head cabIn = new Head();
			Head cabOut = new Head();
			BodySolicitud solicitudInput = new BodySolicitud();
			BodySolicitud2 solicitudOutPut = new BodySolicitud2();
			
			
			cabIn.cargaData("9999","WS29", "610",user);
			
			solicitudInput.cargarData(tipo,dni);
		    
		    log3.debug("cab in", cabIn.toShowData(),Constante.LOGGER_DEBUG_NIVEL_2);
			log3.debug("body in", solicitudInput.toShowData(),Constante.LOGGER_DEBUG_NIVEL_2);
			
		    String inputSolicitud= (solicitudInput.toString()).trim();
		    
		    System.out.println("entrada :" +solicitudInput.toShowData());
        	
		    String outSolicitud = null;
	        outSolicitud = cics.enviarTrama(cabIn, inputSolicitud);
	        solicitudOutPut.FillBoby(outSolicitud);
			
			log3.debug("body out1", outSolicitud,Constante.LOGGER_DEBUG_NIVEL_2);
			log3.debug("body out", solicitudOutPut.toShowData(),Constante.LOGGER_DEBUG_NIVEL_2);

			 System.out.println("Solicitud");
		 		System.out.println("salida :" +solicitudOutPut.toShowData());
		 		
		 		
		 		
		 		
			
            if (outSolicitud != null){
            	solicitud = new BnSolicitud();
            
            
                solicitud.setTIPDOC(solicitudOutPut.getByTag("W-TIPDOC"));
                solicitud.setNUMDOC(solicitudOutPut.getByTag("W-NUMDOC"));
    			solicitud.setAPELLTIT(solicitudOutPut.getByTag("W-APELLTIT"));
    			solicitud.setNOMBRTIT(solicitudOutPut.getByTag("W-NOMBRTIT"));
    			solicitud.setESTCV(solicitudOutPut.getByTag("W-ESTCV"));
    			solicitud.setSEXO(solicitudOutPut.getByTag("W-SEXO"));
    			solicitud.setTIPVIV(solicitudOutPut.getByTag("W-TIPVIV"));
    			solicitud.setDEPENDI(solicitudOutPut.getByTag("W-DEPENDI"));		
    			
    			String mail1 = (solicitudOutPut.getByTag("W-MAIL")).trim();
    			
    			solicitud.setMAIL(mail1.replace(" ", "@"));	
    			
    			solicitud.setCODVIA(solicitudOutPut.getByTag("W-CODVIA"));
    			solicitud.setNOMVIA(solicitudOutPut.getByTag("W-NOMVIA"));
    			solicitud.setNUMVIA(solicitudOutPut.getByTag("W-NUMVIA"));		
    			solicitud.setCODZON(solicitudOutPut.getByTag("W-CODZON"));
    			solicitud.setNOMZON(solicitudOutPut.getByTag("W-NOMZON"));			
    			solicitud.setUBGCLI(solicitudOutPut.getByTag("W-UBGCLI"));		
    			solicitud.setREFEREN(solicitudOutPut.getByTag("W-REFEREN"));		
    			solicitud.setTLFCASA(solicitudOutPut.getByTag("W-TLFCASA"));
    			solicitud.setTLFCELL(solicitudOutPut.getByTag("W-TLFCELL"));
    			solicitud.setEMPLAB_TIT(solicitudOutPut.getByTag("W-EMPLAB-TIT"));		
    			solicitud.setFCHING(solicitudOutPut.getByTag("W-FCHING"));		
    			solicitud.setCODVIA_LAB(solicitudOutPut.getByTag("W-CODVIA-LAB"));
    			solicitud.setNOMVIA_LAB(solicitudOutPut.getByTag("W-NOMVIA-LAB"));
    			solicitud.setNUMVIA_LAB(solicitudOutPut.getByTag("W-NUMVIA-LAB"));			
    			solicitud.setCODZON_LAB(solicitudOutPut.getByTag("W-CODZON-LAB"));
    			solicitud.setNOMZON_LAB(solicitudOutPut.getByTag("W-NOMZON-LAB"));
    			solicitud.setUBGDOM_LAB(solicitudOutPut.getByTag("W-UBGDOM-LAB"));		
    			solicitud.setREFEREN_LAB(solicitudOutPut.getByTag("W-REFEREN-LAB"));
    			solicitud.setTLFLAB(solicitudOutPut.getByTag("W-TLFLAB"));
    			solicitud.setANXLAB(solicitudOutPut.getByTag("W-ANXLAB"));
    			solicitud.setREFERENPER(solicitudOutPut.getByTag("W-REFERENPER"));
    			solicitud.setTLFREF(solicitudOutPut.getByTag("W-TLFREF"));
    			solicitud.setNOMBRE_CYG(solicitudOutPut.getByTag("W-NOMBRE-CYG"));
    			solicitud.setEMPLAB_CYG(solicitudOutPut.getByTag("W-EMPLAB-CYG"));	
    			solicitud.setTLFTRA_CYG(solicitudOutPut.getByTag("W-TLFTRA-CYG"));
    			solicitud.setANXTRA_CYG(solicitudOutPut.getByTag("W-ANXTRA-CYG"));		
    			solicitud.setLINCRE_GLB(solicitudOutPut.getByTag("W-LINCRE-GLB"));
    			solicitud.setCCLO_FAC(solicitudOutPut.getByTag("W-CCLO-FAC"));		
    			solicitud.setTIPCTA_CAR(solicitudOutPut.getByTag("W-TIPCTA-CAR"));
    			solicitud.setMON_CAR(solicitudOutPut.getByTag("W-MON-CAR"));
    			solicitud.setCTA_CAR(solicitudOutPut.getByTag("W-CTA-CAR"));
    			solicitud.setNOMCOR_CLI(solicitudOutPut.getByTag("W-NOMCOR-CLI"));		
    			solicitud.setLINCRE_CTA(solicitudOutPut.getByTag("W-LINCRE-CTA"));			
    			solicitud.setCCLOFAC_CTA(solicitudOutPut.getByTag("W-CCLOFAC-CTA"));
    			solicitud.setFCH_NAC(solicitudOutPut.getByTag("W-FCH-NAC"));
    			solicitud.setSLD_CLI(solicitudOutPut.getByTag("W-SLD-CLI"));
    			solicitud.setBLQ_CAR(solicitudOutPut.getByTag("W-BLQ-CAR"));
    			solicitud.setBLQ_CTA(solicitudOutPut.getByTag("W-BLQ-CTA"));
    			solicitud.setPLAN_CAS(solicitudOutPut.getByTag("W-PLAN-CAS"));
    			solicitud.setPLAN_RET(solicitudOutPut.getByTag("W-PLAN-RET"));
    			solicitud.setCOD_AGE(solicitudOutPut.getByTag("W-COD-AGE"));
    			solicitud.setCODCTR_EVA(solicitudOutPut.getByTag("W-CODCTR-EVA"));
    			solicitud.setCODPROMOTOR(solicitudOutPut.getByTag("W-CODPROMOTOR"));
    			solicitud.setCODFUNCION(solicitudOutPut.getByTag("W-CODFUNCION"));
    			solicitud.setNOM_EN_PLAST(solicitudOutPut.getByTag("W-NOM-EN-PLAST"));
    			solicitud.setNOM_EMP_PLAST(solicitudOutPut.getByTag("W-NOM-EMP-PLAST"));			
    			solicitud.setTIPDIR_ENT(solicitudOutPut.getByTag("W-TIPDIR-ENT"));
    			solicitud.setCODVIA_ENT(solicitudOutPut.getByTag("W-CODVIA-ENT"));
    			solicitud.setNOMVIA_ENT(solicitudOutPut.getByTag("W-NOMVIA-ENT"));
    			solicitud.setNUMVIA_ENT(solicitudOutPut.getByTag("W-NUMVIA-ENT"));		
    			solicitud.setCODZON_ENT(solicitudOutPut.getByTag("W-CODZON-ENT"));
    			solicitud.setNOMZON_ENT(solicitudOutPut.getByTag("W-NOMZON-ENT"));
    			solicitud.setUBGDOM_ENT(solicitudOutPut.getByTag("W-UBGDOM-ENT"));		
    			solicitud.setREFEREN_ENT(solicitudOutPut.getByTag("W-REFEREN-ENT"));	
    			solicitud.setMANDATR_01(solicitudOutPut.getByTag("W-MANDATR-01"));
    			solicitud.setMANDATR_02(solicitudOutPut.getByTag("W-MANDATR-02"));
    			solicitud.setUBG_CLI_DEP(solicitudOutPut.getByTag("W-UBG-CLI-DEP"));
    			solicitud.setUBG_CLI_PRO(solicitudOutPut.getByTag("W-UBG-CLI-PRO"));
    			solicitud.setUBG_CLI_DIS(solicitudOutPut.getByTag("W-UBG-CLI-DIS"));
    			solicitud.setUBG_DOM_LAB_DEP(solicitudOutPut.getByTag("W-UBG-DOM-LAB-DEP"));
    			solicitud.setUBG_DOM_LAB_PRO(solicitudOutPut.getByTag("W-UBG-DOM-LAB-PRO"));
    			solicitud.setUBG_DOM_LAB_DIS(solicitudOutPut.getByTag("W-UBG-DOM-LAB-DIS"));
    			solicitud.setUBG_ZON_ENT_DEP(solicitudOutPut.getByTag("W-UBG-ZON-ENT-DEP"));
    			solicitud.setUBG_ZON_ENT_PRO(solicitudOutPut.getByTag("W-UBG-ZON-ENT-PRO"));
    			solicitud.setUBG_ZON_ENT_DIS(solicitudOutPut.getByTag("W-UBG-ZON-ENT-DIS"));
    			solicitud.setLCORRES(solicitudOutPut.getByTag("W-LCORRES"));
    			solicitud.setDISPOS(solicitudOutPut.getByTag("W-DISPOS"));
    			solicitud.setENDOSO(solicitudOutPut.getByTag("W-ENDOSO"));
    			solicitud.setNOTIFICA(solicitudOutPut.getByTag("W-NOTIFICA"));
    			solicitud.setOEXTERIO(solicitudOutPut.getByTag("W-OEXTERIO"));
    			solicitud.setMVIRTUAL(solicitudOutPut.getByTag("W-MVIRTUAL"));
    			solicitud.setNPOLIZA(solicitudOutPut.getByTag("W-NPOLIZA"));
    			solicitud.setTIPTARJETA(solicitudOutPut.getByTag("W-TIPTARJETA"));
    			solicitud.setCONDLABORA(solicitudOutPut.getByTag("W-CONDLABORA"));
    			solicitud.setCTAAHORRO(solicitudOutPut.getByTag("W-CTAAHORRO"));
    			solicitud.setNROTARJETA(solicitudOutPut.getByTag("W-NROTARJETA"));
    			solicitud.setCELL_SMS(solicitudOutPut.getByTag("W-CELL-SMS"));
    			solicitud.setFCH_SOLICITA(solicitudOutPut.getByTag("W-FCH-SOLICITA"));
    			solicitud.setNOM_TECNICO(solicitudOutPut.getByTag("W-NOM-TECNICO"));
    			solicitud.setNOM_FUNCIONARIO(solicitudOutPut.getByTag("W-NOM-FUNCIONARIO"));
    			solicitud.setNOM_AGENCIA(solicitudOutPut.getByTag("W-NOM-AGENCIA"));
    			solicitud.setCOD_AGENCIA(solicitudOutPut.getByTag("W-COD-AGENCIA"));
    			solicitud.setNOB_VIA_TIT(solicitudOutPut.getByTag("W-NOB-VIA-TIT"));
    			solicitud.setNOB_VIA_LAB(solicitudOutPut.getByTag("W-NOB-VIA-LAB"));		
    			solicitud.setSECTOR(solicitudOutPut.getByTag("W-SECTOR"));
    			
    			//solicitud.setSDESGRAVA(solicitudOutPut.getByTag("W-SDESGRAVA"));
    			
    		/*	
    			String seguroDesgravamen = solicitudOutPut.getByTag("W-SDESGRAVA");
				
				if(seguroDesgravamen.equals("")){
					seguroDesgravamen = " ";
				}else{
						int longDes = seguroDesgravamen.length();
						//0000350000
					//000000013300000
						
						   
				        //   00419 00890
				        
				        //0.419%Max.S/8.90
				        
						
					String parte1 = seguroDesgravamen.substring(0,5);
					String parte2 = seguroDesgravamen.substring(5,10);
					
				
				String part1 = 	 parte1.substring(0,2);
				String part11 =  parte1.substring(2,5);
				
				String part2 = 	 parte2.substring(0,3);
				String part22 =  parte2.substring(3,5);
				
				String parte1T = part1 +"."+ part11;
				String parte2T = part2 +"."+ part22;
				
			//00.419
			//008.90	
				
				String enteroPart1 = part1.substring(0,1);
				String enteroPart11 = part1.substring(1,3);
				
				String primerP ="";
				
				if(enteroPart1.equalsIgnoreCase("0") && enteroPart11.equalsIgnoreCase("0")){
					
					 primerP = enteroPart11 + "."+part11;
				}else{
					
					primerP = Funciones.eliminarCerosAlaIzquierda(part1) + " ."+part11;
				}
				
					
					
				//	System.out.println("primer entero "+primerP);
			//		System.out.println("primer entero "+parte2T);
					
					
					solicitud.setSDESGRAVA("0.419%Max.S/8.90");
				}
    			*/
				
    			
    			solicitud.setSDESGRAVA("0.419%Max.S/8.90");
    			
    			solicitud.setDDEPEND(solicitudOutPut.getByTag("W-DDEPEND"));
    			solicitud.setNTELEF_DEPEND(solicitudOutPut.getByTag("W-NTELEF-DEPEND"));
    			solicitud.setNROTARJDEB(solicitudOutPut.getByTag("W-NROTARJDEB"));
    			solicitud.setCORRELATIVO(solicitudOutPut.getByTag("W-CORRELATIVO"));
    			solicitud.setANEXOLABOR(solicitudOutPut.getByTag("W-ANEXOLABOR"));
    			solicitud.setIND_ARRAY(solicitudOutPut.getByTag("W-IND-ARRAY"));
    			solicitud.setTIPOCARDADI_01(solicitudOutPut.getByTag("W-TIPOCARDADI-01"));
    			solicitud.setNUMECARDADI_01(solicitudOutPut.getByTag("W-NUMECARDADI-01"));
    			solicitud.setLINECARDADI_01(solicitudOutPut.getByTag("W-LINECARDADI-01"));
    			solicitud.setTIPDOC_ADI_01(solicitudOutPut.getByTag("W-TIPDOC-ADI-01"));
    			solicitud.setNUMDOC_ADI_01(solicitudOutPut.getByTag("W-NUMDOC-ADI-01"));
    			solicitud.setAPELL_ADI_01(solicitudOutPut.getByTag("W-APELL-ADI-01"));
    			solicitud.setNOMBR_ADI_01(solicitudOutPut.getByTag("W-NOMBR-ADI-01"));
    			solicitud.setFCHNAC_ADI_01(solicitudOutPut.getByTag("W-FCHNAC-ADI-01"));
    			solicitud.setSEXO_ADI_01(solicitudOutPut.getByTag("W-SEXO-ADI-01"));
    			solicitud.setDISPOS_ADI_01(solicitudOutPut.getByTag("W-DISPOS-ADI-01"));
    			solicitud.setFECHAOPER_ADI_01(solicitudOutPut.getByTag("W-FECHAOPER-ADI-01"));
    			
    			
    			
    			
                String mail1Adi1 = (solicitudOutPut.getByTag("W-MAIL-ADI-01")).trim();    	
                
              
                
                
                solicitud.setMAIL_ADI_01(mail1Adi1.replace(" ", "@"));	
                
              
                
    			
    			
    			solicitud.setNOTIFICA_ADI_01(solicitudOutPut.getByTag("W-NOTIFICA-ADI-01"));
    			solicitud.setOEXTERIO_ADI_01(solicitudOutPut.getByTag("W-OEXTERIO-ADI-01"));
    			solicitud.setMVIRTUAL_ADI_01(solicitudOutPut.getByTag("W-MVIRTUAL-ADI-01"));
    			solicitud.setTLF_CEL_ADI_01(solicitudOutPut.getByTag("W-TLF-CEL-ADI-01"));
    			
    		
    			
    			
    			solicitud.setTIPOCARDADI_02(solicitudOutPut.getByTag("W-TIPOCARDADI-02"));
    			solicitud.setNUMECARDADI_02(solicitudOutPut.getByTag("W-NUMECARDADI-02"));
    			solicitud.setLINECARDADI_02(solicitudOutPut.getByTag("W-LINECARDADI-02"));
    			solicitud.setTIPDOC_ADI_02(solicitudOutPut.getByTag("W-TIPDOC-ADI-02"));
    			solicitud.setNUMDOC_ADI_02(solicitudOutPut.getByTag("W-NUMDOC-ADI-02"));
    			solicitud.setAPELL_ADI_02(solicitudOutPut.getByTag("W-APELL-ADI-02"));
    			solicitud.setNOMBR_ADI_02(solicitudOutPut.getByTag("W-NOMBR-ADI-02"));
    			solicitud.setFCHNAC_ADI_02(solicitudOutPut.getByTag("W-FCHNAC-ADI-02"));
    			solicitud.setSEXO_ADI_02(solicitudOutPut.getByTag("W-SEXO-ADI-02"));
    			solicitud.setDISPOS_ADI_02(solicitudOutPut.getByTag("W-DISPOS-ADI-02"));
    			solicitud.setFECHAOPER_ADI_02(solicitudOutPut.getByTag("W-FECHAOPER-ADI-02"));
    			
    				
    			 String mail1Adi2 = (solicitudOutPut.getByTag("W-MAIL-ADI-02")).trim();    			
                 solicitud.setMAIL_ADI_02(mail1Adi2.replace(" ", "@"));	
    			
    			solicitud.setNOTIFICA_ADI_02(solicitudOutPut.getByTag("W-NOTIFICA-ADI-02"));
    			solicitud.setOEXTERIO_ADI_02(solicitudOutPut.getByTag("W-OEXTERIO-ADI-02"));
    			solicitud.setMVIRTUAL_ADI_02(solicitudOutPut.getByTag("W-MVIRTUAL-ADI-02"));
    			solicitud.setTLF_CEL_ADI_02(solicitudOutPut.getByTag("W-TLF-CEL-ADI-02"));
    			
    			solicitud.setTIPOCARDADI_03(solicitudOutPut.getByTag("W-TIPOCARDADI-03"));
    			solicitud.setNUMECARDADI_03(solicitudOutPut.getByTag("W-NUMECARDADI-03"));
    			solicitud.setLINECARDADI_03(solicitudOutPut.getByTag("W-LINECARDADI-03"));
    			solicitud.setTIPDOC_ADI_03(solicitudOutPut.getByTag("W-TIPDOC-ADI-03"));
    			solicitud.setNUMDOC_ADI_03(solicitudOutPut.getByTag("W-NUMDOC-ADI-03"));
    			solicitud.setAPELL_ADI_03(solicitudOutPut.getByTag("W-APELL-ADI-03"));
    			solicitud.setNOMBR_ADI_03(solicitudOutPut.getByTag("W-NOMBR-ADI-03"));
    			solicitud.setFCHNAC_ADI_03(solicitudOutPut.getByTag("W-FCHNAC-ADI-03"));
    			solicitud.setSEXO_ADI_03(solicitudOutPut.getByTag("W-SEXO-ADI-03"));
    			solicitud.setDISPOS_ADI_03(solicitudOutPut.getByTag("W-DISPOS-ADI-03"));
    			solicitud.setFECHAOPER_ADI_03(solicitudOutPut.getByTag("W-FECHAOPER-ADI-03"));
    			
    			
    			
    			 String mail1Adi3 = (solicitudOutPut.getByTag("W-MAIL-ADI-03")).trim();    			
                 solicitud.setMAIL_ADI_03(mail1Adi3.replace(" ", "@"));	
    			
    			solicitud.setNOTIFICA_ADI_03(solicitudOutPut.getByTag("W-NOTIFICA-ADI-03"));
    			solicitud.setOEXTERIO_ADI_03(solicitudOutPut.getByTag("W-OEXTERIO-ADI-03"));
    			solicitud.setMVIRTUAL_ADI_03(solicitudOutPut.getByTag("W-MVIRTUAL-ADI-03"));
    			solicitud.setTLF_CEL_ADI_03(solicitudOutPut.getByTag("W-TLF-CEL-ADI-03"));
    			
    			solicitud.setTIPOCARDADI_04(solicitudOutPut.getByTag("W-TIPOCARDADI-04"));
    			solicitud.setNUMECARDADI_04(solicitudOutPut.getByTag("W-NUMECARDADI-04"));
    			solicitud.setLINECARDADI_04(solicitudOutPut.getByTag("W-LINECARDADI-04"));
    			solicitud.setTIPDOC_ADI_04(solicitudOutPut.getByTag("W-TIPDOC-ADI-04"));
    			solicitud.setNUMDOC_ADI_04(solicitudOutPut.getByTag("W-NUMDOC-ADI-04"));
    			solicitud.setAPELL_ADI_04(solicitudOutPut.getByTag("W-APELL-ADI-04"));
    			solicitud.setNOMBR_ADI_04(solicitudOutPut.getByTag("W-NOMBR-ADI-04"));
    			solicitud.setFCHNAC_ADI_04(solicitudOutPut.getByTag("W-FCHNAC-ADI-04"));
    			solicitud.setSEXO_ADI_04(solicitudOutPut.getByTag("W-SEXO-ADI-04"));
    			solicitud.setDISPOS_ADI_04(solicitudOutPut.getByTag("W-DISPOS-ADI-04"));
    			solicitud.setFECHAOPER_ADI_04(solicitudOutPut.getByTag("W-FECHAOPER-ADI-04"));
    			
    		
    			
    			 String mail1Adi4 = (solicitudOutPut.getByTag("W-MAIL-ADI-04")).trim();    			
                 solicitud.setMAIL_ADI_04(mail1Adi4.replace(" ", "@"));	
    			
    			solicitud.setNOTIFICA_ADI_04(solicitudOutPut.getByTag("W-NOTIFICA-ADI-04"));
    			solicitud.setOEXTERIO_ADI_04(solicitudOutPut.getByTag("W-OEXTERIO-ADI-04"));
    			solicitud.setMVIRTUAL_ADI_04(solicitudOutPut.getByTag("W-MVIRTUAL-ADI-04"));
    			solicitud.setTLF_CEL_ADI_04(solicitudOutPut.getByTag("W-TLF-CEL-ADI-04"));
    			
    			solicitud.setPERSONA_AUTOR(solicitudOutPut.getByTag("W-PERSONA-AUTOR"));
    			solicitud.setTDOCUM_AUTOR(solicitudOutPut.getByTag("W-TDOCUM-AUTOR"));
    			solicitud.setNDOCUM_AUTOR(solicitudOutPut.getByTag("W-NDOCUM-AUTOR"));
    			solicitud.setNOMBRE_GRABAR(solicitudOutPut.getByTag("W-NOMBRE-GRABAR"));
    			solicitud.setCODRESP(solicitudOutPut.getByTag("W-CODRESP"));
    			solicitud.setMSGRESP(solicitudOutPut.getByTag("W-MSGRESP"));
            	
            	
            	
            	

            	
            	
           
              
         	}
			
		} catch (Exception e) {
			log3.error(e,"","");
		}
		return solicitud;
	}
	
	

	
	public  BnCancelacion getCancelacion(String dni,String user){

		CicsSoapConnection cics =  new CicsSoapConnection();
		
		BnCancelacion cancelacion = null;
 try {
	    	Head cabIn = new Head();
			Head cabOut = new Head();
			BodyCancelacion cancelacionInput = new BodyCancelacion();
			BodyCancelacion cancelacionOutPut = new BodyCancelacion();
			
			cabIn.cargaData("9999","WS29", "625",user);
			
			cancelacionInput.cargarData(dni);
		    
		    log3.debug("cab in", cabIn.toShowData(),Constante.LOGGER_DEBUG_NIVEL_2);
			log3.debug("body in", cancelacionInput.toShowData(),Constante.LOGGER_DEBUG_NIVEL_2);
			
		    String inputSolicitud= (cancelacionInput.toString()).trim();
        	
		    String outCancelacion = null;
	        outCancelacion = cics.enviarTrama(cabIn, inputSolicitud);
	        cancelacionOutPut.FillBoby(outCancelacion);
			
			log3.debug("body out1", outCancelacion,Constante.LOGGER_DEBUG_NIVEL_2);
			log3.debug("body out", cancelacionOutPut.toShowData(),Constante.LOGGER_DEBUG_NIVEL_2);

            if (outCancelacion != null){
            	cancelacion = new BnCancelacion();;
            
            
            	cancelacion.setTIPDOC(cancelacionOutPut.getByTag("W-TIPDOC"));
                cancelacion.setNUMDOC(cancelacionOutPut.getByTag("W-NUMDOC"));
    			cancelacion.setAPELLTIT(cancelacionOutPut.getByTag("W-APELLTIT"));
    			cancelacion.setNOMBRTIT(cancelacionOutPut.getByTag("W-NOMBRTIT"));
    			cancelacion.setESTCV(cancelacionOutPut.getByTag("W-ESTCV"));
    			cancelacion.setSEXO(cancelacionOutPut.getByTag("W-SEXO"));
    			cancelacion.setTIPVIV(cancelacionOutPut.getByTag("W-TIPVIV"));
    			cancelacion.setDEPENDI(cancelacionOutPut.getByTag("W-DEPENDI"));			
    			cancelacion.setMAIL(cancelacionOutPut.getByTag("W-MAIL"));		
    			cancelacion.setCODVIA(cancelacionOutPut.getByTag("W-CODVIA"));
    			cancelacion.setNOMVIA(cancelacionOutPut.getByTag("W-NOMVIA"));
    			cancelacion.setNUMVIA(cancelacionOutPut.getByTag("W-NUMVIA"));		
    			cancelacion.setCODZON(cancelacionOutPut.getByTag("W-CODZON"));
    			cancelacion.setNOMZON(cancelacionOutPut.getByTag("W-NOMZON"));			
    			cancelacion.setUBGCLI(cancelacionOutPut.getByTag("W-UBGCLI"));		
    			cancelacion.setREFEREN(cancelacionOutPut.getByTag("W-REFEREN"));		
    			cancelacion.setTLFCASA(cancelacionOutPut.getByTag("W-TLFCASA"));
    			cancelacion.setTLFCELL(cancelacionOutPut.getByTag("W-TLFCELL"));
    			cancelacion.setEMPLAB_TIT(cancelacionOutPut.getByTag("W-EMPLAB-TIT"));		
    			cancelacion.setFCHING(cancelacionOutPut.getByTag("W-FCHING"));		
    			cancelacion.setCODVIA_LAB(cancelacionOutPut.getByTag("W-CODVIA-LAB"));
    			cancelacion.setNOMVIA_LAB(cancelacionOutPut.getByTag("W-NOMVIA-LAB"));
    			cancelacion.setNUMVIA_LAB(cancelacionOutPut.getByTag("W-NUMVIA-LAB"));			
    			cancelacion.setCODZON_LAB(cancelacionOutPut.getByTag("W-CODZON-LAB"));
    			cancelacion.setNOMZON_LAB(cancelacionOutPut.getByTag("W-NOMZON-LAB"));
    			cancelacion.setUBGDOM_LAB(cancelacionOutPut.getByTag("W-UBGDOM-LAB"));		
    			cancelacion.setREFEREN_LAB(cancelacionOutPut.getByTag("W-REFEREN-LAB"));
    			cancelacion.setTLFLAB(cancelacionOutPut.getByTag("W-TLFLAB"));
    			cancelacion.setANXLAB(cancelacionOutPut.getByTag("W-ANXLAB"));
    			cancelacion.setREFERENPER(cancelacionOutPut.getByTag("W-REFERENPER"));
    			cancelacion.setTLFREF(cancelacionOutPut.getByTag("W-TLFREF"));
    			cancelacion.setNOMBRE_CYG(cancelacionOutPut.getByTag("W-NOMBRE-CYG"));
    			cancelacion.setEMPLAB_CYG(cancelacionOutPut.getByTag("W-EMPLAB-CYG"));	
    			cancelacion.setTLFTRA_CYG(cancelacionOutPut.getByTag("W-TLFTRA-CYG"));
    			cancelacion.setANXTRA_CYG(cancelacionOutPut.getByTag("W-ANXTRA-CYG"));		
    			cancelacion.setLINCRE_GLB(cancelacionOutPut.getByTag("W-LINCRE-GLB"));
    			cancelacion.setCCLO_FAC(cancelacionOutPut.getByTag("W-CCLO-FAC"));		
    			cancelacion.setTIPCTA_CAR(cancelacionOutPut.getByTag("W-TIPCTA-CAR"));
    			cancelacion.setMON_CAR(cancelacionOutPut.getByTag("W-MON-CAR"));
    			cancelacion.setCTA_CAR(cancelacionOutPut.getByTag("W-CTA-CAR"));
    			cancelacion.setNOMCOR_CLI(cancelacionOutPut.getByTag("W-NOMCOR-CLI"));		
    			cancelacion.setLINCRE_CTA(cancelacionOutPut.getByTag("W-LINCRE-CTA"));			
    			cancelacion.setCCLOFAC_CTA(cancelacionOutPut.getByTag("W-CCLOFAC-CTA"));
    			cancelacion.setFCH_NAC(cancelacionOutPut.getByTag("W-FCH-NAC"));
    			cancelacion.setSLD_CLI(cancelacionOutPut.getByTag("W-SLD-CLI"));
    			cancelacion.setBLQ_CAR(cancelacionOutPut.getByTag("W-BLQ-CAR"));
    			cancelacion.setBLQ_CTA(cancelacionOutPut.getByTag("W-BLQ-CTA"));
    			cancelacion.setPLAN_CAS(cancelacionOutPut.getByTag("W-PLAN-CAS"));
    			cancelacion.setPLAN_RET(cancelacionOutPut.getByTag("W-PLAN-RET"));
    			cancelacion.setCOD_AGE(cancelacionOutPut.getByTag("W-COD-AGE"));
    			cancelacion.setCODCTR_EVA(cancelacionOutPut.getByTag("W-CODCTR-EVA"));
    			cancelacion.setCODPROMOTOR(cancelacionOutPut.getByTag("W-CODPROMOTOR"));
    			cancelacion.setCODFUNCION(cancelacionOutPut.getByTag("W-CODFUNCION"));
    			cancelacion.setNOM_EN_PLAST(cancelacionOutPut.getByTag("W-NOM-EN-PLAST"));
    			cancelacion.setNOM_EMP_PLAST(cancelacionOutPut.getByTag("W-NOM-EMP-PLAST"));			
    			cancelacion.setTIPDIR_ENT(cancelacionOutPut.getByTag("W-TIPDIR-ENT"));
    			cancelacion.setCODVIA_ENT(cancelacionOutPut.getByTag("W-CODVIA-ENT"));
    			cancelacion.setNOMVIA_ENT(cancelacionOutPut.getByTag("W-NOMVIA-ENT"));
    			cancelacion.setNUMVIA_ENT(cancelacionOutPut.getByTag("W-NUMVIA-ENT"));		
    			cancelacion.setCODZON_ENT(cancelacionOutPut.getByTag("W-CODZON-ENT"));
    			cancelacion.setNOMZON_ENT(cancelacionOutPut.getByTag("W-NOMZON-ENT"));
    			cancelacion.setUBGDOM_ENT(cancelacionOutPut.getByTag("W-UBGDOM-ENT"));		
    			cancelacion.setREFEREN_ENT(cancelacionOutPut.getByTag("W-REFEREN-ENT"));	
    			cancelacion.setMANDATR_01(cancelacionOutPut.getByTag("W-MANDATR-01"));
    			cancelacion.setMANDATR_02(cancelacionOutPut.getByTag("W-MANDATR-02"));
    			cancelacion.setUBG_CLI_DEP(cancelacionOutPut.getByTag("W-UBG-CLI-DEP"));
    			cancelacion.setUBG_CLI_PRO(cancelacionOutPut.getByTag("W-UBG-CLI-PRO"));
    			cancelacion.setUBG_CLI_DIS(cancelacionOutPut.getByTag("W-UBG-CLI-DIS"));
    			cancelacion.setUBG_DOM_LAB_DEP(cancelacionOutPut.getByTag("W-UBG-DOM-LAB-DEP"));
    			cancelacion.setUBG_DOM_LAB_PRO(cancelacionOutPut.getByTag("W-UBG-DOM-LAB-PRO"));
    			cancelacion.setUBG_DOM_LAB_DIS(cancelacionOutPut.getByTag("W-UBG-DOM-LAB-DIS"));
    			cancelacion.setUBG_ZON_ENT_DEP(cancelacionOutPut.getByTag("W-UBG-ZON-ENT-DEP"));
    			cancelacion.setUBG_ZON_ENT_PRO(cancelacionOutPut.getByTag("W-UBG-ZON-ENT-PRO"));
    			cancelacion.setUBG_ZON_ENT_DIS(cancelacionOutPut.getByTag("W-UBG-ZON-ENT-DIS"));
    			cancelacion.setLCORRES(cancelacionOutPut.getByTag("W-LCORRES"));
    			cancelacion.setDISPOS(cancelacionOutPut.getByTag("W-DISPOS"));
    			cancelacion.setENDOSO(cancelacionOutPut.getByTag("W-ENDOSO"));
    			cancelacion.setNOTIFICA(cancelacionOutPut.getByTag("W-NOTIFICA"));
    			cancelacion.setOEXTERIO(cancelacionOutPut.getByTag("W-OEXTERIO"));
    			cancelacion.setMVIRTUAL(cancelacionOutPut.getByTag("W-MVIRTUAL"));
    			cancelacion.setNPOLIZA(cancelacionOutPut.getByTag("W-NPOLIZA"));
    			cancelacion.setTIPTARJETA(cancelacionOutPut.getByTag("W-TIPTARJETA"));
    			cancelacion.setCONDLABORA(cancelacionOutPut.getByTag("W-CONDLABORA"));
    			cancelacion.setCTAAHORRO(cancelacionOutPut.getByTag("W-CTAAHORRO"));
    			cancelacion.setNROTARJETA(cancelacionOutPut.getByTag("W-NROTARJETA"));
    			cancelacion.setCELL_SMS(cancelacionOutPut.getByTag("W-CELL-SMS"));
    			cancelacion.setFCH_SOLICITA(cancelacionOutPut.getByTag("W-FCH-SOLICITA"));
    			cancelacion.setNOM_TECNICO(cancelacionOutPut.getByTag("W-NOM-TECNICO"));
    			cancelacion.setNOM_FUNCIONARIO(cancelacionOutPut.getByTag("W-NOM-FUNCIONARIO"));
    			cancelacion.setNOM_AGENCIA(cancelacionOutPut.getByTag("W-NOM-AGENCIA"));
    			cancelacion.setCOD_AGENCIA(cancelacionOutPut.getByTag("W-COD-AGENCIA"));
    			cancelacion.setNOB_VIA_TIT(cancelacionOutPut.getByTag("W-NOB-VIA-TIT"));
    			cancelacion.setNOB_VIA_LAB(cancelacionOutPut.getByTag("W-NOB-VIA-LAB"));		
    			cancelacion.setSECTOR(cancelacionOutPut.getByTag("W-SECTOR"));
    			cancelacion.setSDESGRAVA(cancelacionOutPut.getByTag("W-SDESGRAVA"));
    			cancelacion.setDDEPEND(cancelacionOutPut.getByTag("W-DDEPEND"));
    			cancelacion.setNTELEF_DEPEND(cancelacionOutPut.getByTag("W-NTELEF-DEPEND"));
    			cancelacion.setNROTARJDEB(cancelacionOutPut.getByTag("W-NROTARJDEB"));
    			cancelacion.setCORRELATIVO(cancelacionOutPut.getByTag("W-CORRELATIVO"));
    			cancelacion.setANEXOLABOR(cancelacionOutPut.getByTag("W-ANEXOLABOR"));
    			cancelacion.setIND_ARRAY(cancelacionOutPut.getByTag("W-IND-ARRAY"));
    			cancelacion.setTIPOCARDADI_01(cancelacionOutPut.getByTag("W-TIPOCARDADI-01"));
    			cancelacion.setNUMECARDADI_01(cancelacionOutPut.getByTag("W-NUMECARDADI-01"));
    			cancelacion.setLINECARDADI_01(cancelacionOutPut.getByTag("W-LINECARDADI-01"));
    			cancelacion.setTIPDOC_ADI_01(cancelacionOutPut.getByTag("W-TIPDOC-ADI-01"));
    			cancelacion.setNUMDOC_ADI_01(cancelacionOutPut.getByTag("W-NUMDOC-ADI-01"));
    			cancelacion.setAPELL_ADI_01(cancelacionOutPut.getByTag("W-APELL-ADI-01"));
    			cancelacion.setNOMBR_ADI_01(cancelacionOutPut.getByTag("W-NOMBR-ADI-01"));
    			cancelacion.setFCHNAC_ADI_01(cancelacionOutPut.getByTag("W-FCHNAC-ADI-01"));
    			cancelacion.setSEXO_ADI_01(cancelacionOutPut.getByTag("W-SEXO-ADI-01"));
    			cancelacion.setDISPOS_ADI_01(cancelacionOutPut.getByTag("W-DISPOS-ADI-01"));
    			cancelacion.setFECHAOPER_ADI_01(cancelacionOutPut.getByTag("W-FECHAOPER-ADI-01"));
    			cancelacion.setTIPOCARDADI_02(cancelacionOutPut.getByTag("W-TIPOCARDADI-02"));
    			cancelacion.setNUMECARDADI_02(cancelacionOutPut.getByTag("W-NUMECARDADI-02"));
    			cancelacion.setLINECARDADI_02(cancelacionOutPut.getByTag("W-LINECARDADI-02"));
    			cancelacion.setTIPDOC_ADI_02(cancelacionOutPut.getByTag("W-TIPDOC-ADI-02"));
    			cancelacion.setNUMDOC_ADI_02(cancelacionOutPut.getByTag("W-NUMDOC-ADI-02"));
    			cancelacion.setAPELL_ADI_02(cancelacionOutPut.getByTag("W-APELL-ADI-02"));
    			cancelacion.setNOMBR_ADI_02(cancelacionOutPut.getByTag("W-NOMBR-ADI-02"));
    			cancelacion.setFCHNAC_ADI_02(cancelacionOutPut.getByTag("W-FCHNAC-ADI-02"));
    			cancelacion.setSEXO_ADI_02(cancelacionOutPut.getByTag("W-SEXO-ADI-02"));
    			cancelacion.setDISPOS_ADI_02(cancelacionOutPut.getByTag("W-DISPOS-ADI-02"));
    			cancelacion.setFECHAOPER_ADI_02(cancelacionOutPut.getByTag("W-FECHAOPER-ADI-02"));
    			cancelacion.setTIPOCARDADI_03(cancelacionOutPut.getByTag("W-TIPOCARDADI-03"));
    			cancelacion.setNUMECARDADI_03(cancelacionOutPut.getByTag("W-NUMECARDADI-03"));
    			cancelacion.setLINECARDADI_03(cancelacionOutPut.getByTag("W-LINECARDADI-03"));
    			cancelacion.setTIPDOC_ADI_03(cancelacionOutPut.getByTag("W-TIPDOC-ADI-03"));
    			cancelacion.setNUMDOC_ADI_03(cancelacionOutPut.getByTag("W-NUMDOC-ADI-03"));
    			cancelacion.setAPELL_ADI_03(cancelacionOutPut.getByTag("W-APELL-ADI-03"));
    			cancelacion.setNOMBR_ADI_03(cancelacionOutPut.getByTag("W-NOMBR-ADI-03"));
    			cancelacion.setFCHNAC_ADI_03(cancelacionOutPut.getByTag("W-FCHNAC-ADI-03"));
    			cancelacion.setSEXO_ADI_03(cancelacionOutPut.getByTag("W-SEXO-ADI-03"));
    			cancelacion.setDISPOS_ADI_03(cancelacionOutPut.getByTag("W-DISPOS-ADI-03"));
    			cancelacion.setFECHAOPER_ADI_03(cancelacionOutPut.getByTag("W-FECHAOPER-ADI-03"));
    			cancelacion.setTIPOCARDADI_04(cancelacionOutPut.getByTag("W-TIPOCARDADI-04"));
    			cancelacion.setNUMECARDADI_04(cancelacionOutPut.getByTag("W-NUMECARDADI-04"));
    			cancelacion.setLINECARDADI_04(cancelacionOutPut.getByTag("W-LINECARDADI-04"));
    			cancelacion.setTIPDOC_ADI_04(cancelacionOutPut.getByTag("W-TIPDOC-ADI-04"));
    			cancelacion.setNUMDOC_ADI_04(cancelacionOutPut.getByTag("W-NUMDOC-ADI-04"));
    			cancelacion.setAPELL_ADI_04(cancelacionOutPut.getByTag("W-APELL-ADI-04"));
    			cancelacion.setNOMBR_ADI_04(cancelacionOutPut.getByTag("W-NOMBR-ADI-04"));
    			cancelacion.setFCHNAC_ADI_04(cancelacionOutPut.getByTag("W-FCHNAC-ADI-04"));
    			cancelacion.setSEXO_ADI_04(cancelacionOutPut.getByTag("W-SEXO-ADI-04"));
    			cancelacion.setDISPOS_ADI_04(cancelacionOutPut.getByTag("W-DISPOS-ADI-04"));
    			cancelacion.setFECHAOPER_ADI_04(cancelacionOutPut.getByTag("W-FECHAOPER-ADI-04"));
    			cancelacion.setPERSONA_AUTOR(cancelacionOutPut.getByTag("W-PERSONA-AUTOR"));
    			cancelacion.setTDOCUM_AUTOR(cancelacionOutPut.getByTag("W-TDOCUM-AUTOR"));
    			cancelacion.setNDOCUM_AUTOR(cancelacionOutPut.getByTag("W-NDOCUM-AUTOR"));
    			cancelacion.setNOMBRE_GRABAR(cancelacionOutPut.getByTag("W-NOMBRE-GRABAR"));
    			cancelacion.setCODRESP(cancelacionOutPut.getByTag("W-CODRESP"));
    			cancelacion.setMSGRESP(cancelacionOutPut.getByTag("W-MSGRESP"));     
            	
            	
           
              
         	}
			
		} catch (Exception e) {
			log3.error(e,"","");
		}
		return cancelacion;
	}
	
	

	public  BnPoliza getPoliza(String tipo, String dni,String user){

		CicsSoapConnection cics =  new CicsSoapConnection();
		
		BnPoliza solicitud = null;
 try {
	    	Head cabIn = new Head();
			Head cabOut = new Head();
			BodySolicitud solicitudInput = new BodySolicitud();
			BodySolicitud2 solicitudOutPut = new BodySolicitud2();
			
			
			cabIn.cargaData("9999","WS29", "610",user);
			
			solicitudInput.cargarData(tipo,dni);
		    
		    log3.debug("cab in", cabIn.toShowData(),Constante.LOGGER_DEBUG_NIVEL_2);
			log3.debug("body in", solicitudInput.toShowData(),Constante.LOGGER_DEBUG_NIVEL_2);
			
		    String inputSolicitud= (solicitudInput.toString()).trim();
		    
		    System.out.println("entrada :" +solicitudInput.toShowData());
        	
		    String outSolicitud = null;
	        outSolicitud = cics.enviarTramaP(cabIn, inputSolicitud);
	        solicitudOutPut.FillBoby(outSolicitud);
			
			log3.debug("body out1", outSolicitud,Constante.LOGGER_DEBUG_NIVEL_2);
			log3.debug("body out", solicitudOutPut.toShowData(),Constante.LOGGER_DEBUG_NIVEL_2);

			 System.out.println("poliza");
		 		System.out.println("poliza :" +solicitudOutPut.toShowData());
		 		
		 		
		 		
		 		
			
            if (outSolicitud != null){
            	solicitud = new BnPoliza();
            
            
                solicitud.setTIPDOC(solicitudOutPut.getByTag("W-TIPDOC"));
                solicitud.setNUMDOC(solicitudOutPut.getByTag("W-NUMDOC"));
    			solicitud.setAPELLTIT(solicitudOutPut.getByTag("W-APELLTIT"));
    			solicitud.setNOMBRTIT(solicitudOutPut.getByTag("W-NOMBRTIT"));
    			solicitud.setESTCV(solicitudOutPut.getByTag("W-ESTCV"));
    			solicitud.setSEXO(solicitudOutPut.getByTag("W-SEXO"));
    			solicitud.setTIPVIV(solicitudOutPut.getByTag("W-TIPVIV"));
    			solicitud.setDEPENDI(solicitudOutPut.getByTag("W-DEPENDI"));		
    			
    			String mail1 = (solicitudOutPut.getByTag("W-MAIL")).trim();
    			
    			solicitud.setMAIL(mail1.replace(" ", "@"));	
    			
    			solicitud.setCODVIA(solicitudOutPut.getByTag("W-CODVIA"));
    			solicitud.setNOMVIA(solicitudOutPut.getByTag("W-NOMVIA"));
    			solicitud.setNUMVIA(solicitudOutPut.getByTag("W-NUMVIA"));		
    			solicitud.setCODZON(solicitudOutPut.getByTag("W-CODZON"));
    			solicitud.setNOMZON(solicitudOutPut.getByTag("W-NOMZON"));			
    			solicitud.setUBGCLI(solicitudOutPut.getByTag("W-UBGCLI"));		
    			solicitud.setREFEREN(solicitudOutPut.getByTag("W-REFEREN"));		
    			solicitud.setTLFCASA(solicitudOutPut.getByTag("W-TLFCASA"));
    			solicitud.setTLFCELL(solicitudOutPut.getByTag("W-TLFCELL"));
    			solicitud.setEMPLAB_TIT(solicitudOutPut.getByTag("W-EMPLAB-TIT"));		
    			solicitud.setFCHING(solicitudOutPut.getByTag("W-FCHING"));		
    			solicitud.setCODVIA_LAB(solicitudOutPut.getByTag("W-CODVIA-LAB"));
    			solicitud.setNOMVIA_LAB(solicitudOutPut.getByTag("W-NOMVIA-LAB"));
    			solicitud.setNUMVIA_LAB(solicitudOutPut.getByTag("W-NUMVIA-LAB"));			
    			solicitud.setCODZON_LAB(solicitudOutPut.getByTag("W-CODZON-LAB"));
    			solicitud.setNOMZON_LAB(solicitudOutPut.getByTag("W-NOMZON-LAB"));
    			solicitud.setUBGDOM_LAB(solicitudOutPut.getByTag("W-UBGDOM-LAB"));		
    			solicitud.setREFEREN_LAB(solicitudOutPut.getByTag("W-REFEREN-LAB"));
    			solicitud.setTLFLAB(solicitudOutPut.getByTag("W-TLFLAB"));
    			solicitud.setANXLAB(solicitudOutPut.getByTag("W-ANXLAB"));
    			solicitud.setREFERENPER(solicitudOutPut.getByTag("W-REFERENPER"));
    			solicitud.setTLFREF(solicitudOutPut.getByTag("W-TLFREF"));
    			solicitud.setNOMBRE_CYG(solicitudOutPut.getByTag("W-NOMBRE-CYG"));
    			solicitud.setEMPLAB_CYG(solicitudOutPut.getByTag("W-EMPLAB-CYG"));	
    			solicitud.setTLFTRA_CYG(solicitudOutPut.getByTag("W-TLFTRA-CYG"));
    			solicitud.setANXTRA_CYG(solicitudOutPut.getByTag("W-ANXTRA-CYG"));		
    			solicitud.setLINCRE_GLB(solicitudOutPut.getByTag("W-LINCRE-GLB"));
    			solicitud.setCCLO_FAC(solicitudOutPut.getByTag("W-CCLO-FAC"));		
    			solicitud.setTIPCTA_CAR(solicitudOutPut.getByTag("W-TIPCTA-CAR"));
    			solicitud.setMON_CAR(solicitudOutPut.getByTag("W-MON-CAR"));
    			solicitud.setCTA_CAR(solicitudOutPut.getByTag("W-CTA-CAR"));
    			solicitud.setNOMCOR_CLI(solicitudOutPut.getByTag("W-NOMCOR-CLI"));		
    			solicitud.setLINCRE_CTA(solicitudOutPut.getByTag("W-LINCRE-CTA"));			
    			solicitud.setCCLOFAC_CTA(solicitudOutPut.getByTag("W-CCLOFAC-CTA"));
    			solicitud.setFCH_NAC(solicitudOutPut.getByTag("W-FCH-NAC"));
    			solicitud.setSLD_CLI(solicitudOutPut.getByTag("W-SLD-CLI"));
    			solicitud.setBLQ_CAR(solicitudOutPut.getByTag("W-BLQ-CAR"));
    			solicitud.setBLQ_CTA(solicitudOutPut.getByTag("W-BLQ-CTA"));
    			solicitud.setPLAN_CAS(solicitudOutPut.getByTag("W-PLAN-CAS"));
    			solicitud.setPLAN_RET(solicitudOutPut.getByTag("W-PLAN-RET"));
    			solicitud.setCOD_AGE(solicitudOutPut.getByTag("W-COD-AGE"));
    			solicitud.setCODCTR_EVA(solicitudOutPut.getByTag("W-CODCTR-EVA"));
    			solicitud.setCODPROMOTOR(solicitudOutPut.getByTag("W-CODPROMOTOR"));
    			solicitud.setCODFUNCION(solicitudOutPut.getByTag("W-CODFUNCION"));
    			solicitud.setNOM_EN_PLAST(solicitudOutPut.getByTag("W-NOM-EN-PLAST"));
    			solicitud.setNOM_EMP_PLAST(solicitudOutPut.getByTag("W-NOM-EMP-PLAST"));			
    			solicitud.setTIPDIR_ENT(solicitudOutPut.getByTag("W-TIPDIR-ENT"));
    			solicitud.setCODVIA_ENT(solicitudOutPut.getByTag("W-CODVIA-ENT"));
    			solicitud.setNOMVIA_ENT(solicitudOutPut.getByTag("W-NOMVIA-ENT"));
    			solicitud.setNUMVIA_ENT(solicitudOutPut.getByTag("W-NUMVIA-ENT"));		
    			solicitud.setCODZON_ENT(solicitudOutPut.getByTag("W-CODZON-ENT"));
    			solicitud.setNOMZON_ENT(solicitudOutPut.getByTag("W-NOMZON-ENT"));
    			solicitud.setUBGDOM_ENT(solicitudOutPut.getByTag("W-UBGDOM-ENT"));		
    			solicitud.setREFEREN_ENT(solicitudOutPut.getByTag("W-REFEREN-ENT"));	
    			solicitud.setMANDATR_01(solicitudOutPut.getByTag("W-MANDATR-01"));
    			solicitud.setMANDATR_02(solicitudOutPut.getByTag("W-MANDATR-02"));
    			solicitud.setUBG_CLI_DEP(solicitudOutPut.getByTag("W-UBG-CLI-DEP"));
    			solicitud.setUBG_CLI_PRO(solicitudOutPut.getByTag("W-UBG-CLI-PRO"));
    			solicitud.setUBG_CLI_DIS(solicitudOutPut.getByTag("W-UBG-CLI-DIS"));
    			solicitud.setUBG_DOM_LAB_DEP(solicitudOutPut.getByTag("W-UBG-DOM-LAB-DEP"));
    			solicitud.setUBG_DOM_LAB_PRO(solicitudOutPut.getByTag("W-UBG-DOM-LAB-PRO"));
    			solicitud.setUBG_DOM_LAB_DIS(solicitudOutPut.getByTag("W-UBG-DOM-LAB-DIS"));
    			solicitud.setUBG_ZON_ENT_DEP(solicitudOutPut.getByTag("W-UBG-ZON-ENT-DEP"));
    			solicitud.setUBG_ZON_ENT_PRO(solicitudOutPut.getByTag("W-UBG-ZON-ENT-PRO"));
    			solicitud.setUBG_ZON_ENT_DIS(solicitudOutPut.getByTag("W-UBG-ZON-ENT-DIS"));
    			solicitud.setLCORRES(solicitudOutPut.getByTag("W-LCORRES"));
    			solicitud.setDISPOS(solicitudOutPut.getByTag("W-DISPOS"));
    			solicitud.setENDOSO(solicitudOutPut.getByTag("W-ENDOSO"));
    			solicitud.setNOTIFICA(solicitudOutPut.getByTag("W-NOTIFICA"));
    			solicitud.setOEXTERIO(solicitudOutPut.getByTag("W-OEXTERIO"));
    			solicitud.setMVIRTUAL(solicitudOutPut.getByTag("W-MVIRTUAL"));
    			solicitud.setNPOLIZA(solicitudOutPut.getByTag("W-NPOLIZA"));
    			solicitud.setTIPTARJETA(solicitudOutPut.getByTag("W-TIPTARJETA"));
    			solicitud.setCONDLABORA(solicitudOutPut.getByTag("W-CONDLABORA"));
    			solicitud.setCTAAHORRO(solicitudOutPut.getByTag("W-CTAAHORRO"));
    			solicitud.setNROTARJETA(solicitudOutPut.getByTag("W-NROTARJETA"));
    			solicitud.setCELL_SMS(solicitudOutPut.getByTag("W-CELL-SMS"));
    			solicitud.setFCH_SOLICITA(solicitudOutPut.getByTag("W-FCH-SOLICITA"));
    			solicitud.setNOM_TECNICO(solicitudOutPut.getByTag("W-NOM-TECNICO"));
    			solicitud.setNOM_FUNCIONARIO(solicitudOutPut.getByTag("W-NOM-FUNCIONARIO"));
    			solicitud.setNOM_AGENCIA(solicitudOutPut.getByTag("W-NOM-AGENCIA"));
    			solicitud.setCOD_AGENCIA(solicitudOutPut.getByTag("W-COD-AGENCIA"));
    			solicitud.setNOB_VIA_TIT(solicitudOutPut.getByTag("W-NOB-VIA-TIT"));
    			solicitud.setNOB_VIA_LAB(solicitudOutPut.getByTag("W-NOB-VIA-LAB"));		
    			solicitud.setSECTOR(solicitudOutPut.getByTag("W-SECTOR"));
    			
    			//solicitud.setSDESGRAVA(solicitudOutPut.getByTag("W-SDESGRAVA"));
    			
    			
    			String seguroDesgravamen = solicitudOutPut.getByTag("W-SDESGRAVA");
				
				if(seguroDesgravamen.equals("")){
					seguroDesgravamen = " ";
				}else{
						int longDes = seguroDesgravamen.length();
						//0000350000
					//000000013300000
					String decimal = seguroDesgravamen.substring(longDes-5);
					String deci = decimal.substring(0,2);
					
					String entero = seguroDesgravamen.substring(0, 5);
					
				//	System.out.println("primer entero "+entero);
				
					if (entero.equalsIgnoreCase("000000")){
						entero = "0";
					}else{
						entero = Funciones.eliminarCerosAlaIzquierda(entero);
					}
					
					if(entero.equalsIgnoreCase("")){
						entero = "0";
					}
					
			
					String segDes = entero+"."+deci;
					
					seguroDesgravamen = segDes;
					
					solicitud.setSDESGRAVA(seguroDesgravamen);
				}
    			
				
    			
    			
    			
    			solicitud.setDDEPEND(solicitudOutPut.getByTag("W-DDEPEND"));
    			solicitud.setNTELEF_DEPEND(solicitudOutPut.getByTag("W-NTELEF-DEPEND"));
    			solicitud.setNROTARJDEB(solicitudOutPut.getByTag("W-NROTARJDEB"));
    			solicitud.setCORRELATIVO(solicitudOutPut.getByTag("W-CORRELATIVO"));
    			solicitud.setANEXOLABOR(solicitudOutPut.getByTag("W-ANEXOLABOR"));
    			solicitud.setIND_ARRAY(solicitudOutPut.getByTag("W-IND-ARRAY"));
    			solicitud.setTIPOCARDADI_01(solicitudOutPut.getByTag("W-TIPOCARDADI-01"));
    			solicitud.setNUMECARDADI_01(solicitudOutPut.getByTag("W-NUMECARDADI-01"));
    			solicitud.setLINECARDADI_01(solicitudOutPut.getByTag("W-LINECARDADI-01"));
    			solicitud.setTIPDOC_ADI_01(solicitudOutPut.getByTag("W-TIPDOC-ADI-01"));
    			solicitud.setNUMDOC_ADI_01(solicitudOutPut.getByTag("W-NUMDOC-ADI-01"));
    			solicitud.setAPELL_ADI_01(solicitudOutPut.getByTag("W-APELL-ADI-01"));
    			solicitud.setNOMBR_ADI_01(solicitudOutPut.getByTag("W-NOMBR-ADI-01"));
    			solicitud.setFCHNAC_ADI_01(solicitudOutPut.getByTag("W-FCHNAC-ADI-01"));
    			solicitud.setSEXO_ADI_01(solicitudOutPut.getByTag("W-SEXO-ADI-01"));
    			solicitud.setDISPOS_ADI_01(solicitudOutPut.getByTag("W-DISPOS-ADI-01"));
    			solicitud.setFECHAOPER_ADI_01(solicitudOutPut.getByTag("W-FECHAOPER-ADI-01"));
    			
    			
    			solicitud.setMAIL_ADI_01(solicitudOutPut.getByTag("W-MAIL-ADI-01"));
    			solicitud.setNOTIFICA_ADI_01(solicitudOutPut.getByTag("W-NOTIFICA-ADI-01"));
    			solicitud.setOEXTERIO_ADI_01(solicitudOutPut.getByTag("W-OEXTERIO-ADI-01"));
    			solicitud.setMVIRTUAL_ADI_01(solicitudOutPut.getByTag("W-MVIRTUAL-ADI-01"));
    			solicitud.setTLF_CEL_ADI_01(solicitudOutPut.getByTag("W-TLF-CEL-ADI-01"));
    			
    		
    			
    			
    			solicitud.setTIPOCARDADI_02(solicitudOutPut.getByTag("W-TIPOCARDADI-02"));
    			solicitud.setNUMECARDADI_02(solicitudOutPut.getByTag("W-NUMECARDADI-02"));
    			solicitud.setLINECARDADI_02(solicitudOutPut.getByTag("W-LINECARDADI-02"));
    			solicitud.setTIPDOC_ADI_02(solicitudOutPut.getByTag("W-TIPDOC-ADI-02"));
    			solicitud.setNUMDOC_ADI_02(solicitudOutPut.getByTag("W-NUMDOC-ADI-02"));
    			solicitud.setAPELL_ADI_02(solicitudOutPut.getByTag("W-APELL-ADI-02"));
    			solicitud.setNOMBR_ADI_02(solicitudOutPut.getByTag("W-NOMBR-ADI-02"));
    			solicitud.setFCHNAC_ADI_02(solicitudOutPut.getByTag("W-FCHNAC-ADI-02"));
    			solicitud.setSEXO_ADI_02(solicitudOutPut.getByTag("W-SEXO-ADI-02"));
    			solicitud.setDISPOS_ADI_02(solicitudOutPut.getByTag("W-DISPOS-ADI-02"));
    			solicitud.setFECHAOPER_ADI_02(solicitudOutPut.getByTag("W-FECHAOPER-ADI-02"));
    			
    			solicitud.setMAIL_ADI_02(solicitudOutPut.getByTag("W-MAIL-ADI-02"));
    			solicitud.setNOTIFICA_ADI_02(solicitudOutPut.getByTag("W-NOTIFICA-ADI-02"));
    			solicitud.setOEXTERIO_ADI_02(solicitudOutPut.getByTag("W-OEXTERIO-ADI-02"));
    			solicitud.setMVIRTUAL_ADI_02(solicitudOutPut.getByTag("W-MVIRTUAL-ADI-02"));
    			solicitud.setTLF_CEL_ADI_02(solicitudOutPut.getByTag("W-TLF-CEL-ADI-02"));
    			
    			solicitud.setTIPOCARDADI_03(solicitudOutPut.getByTag("W-TIPOCARDADI-03"));
    			solicitud.setNUMECARDADI_03(solicitudOutPut.getByTag("W-NUMECARDADI-03"));
    			solicitud.setLINECARDADI_03(solicitudOutPut.getByTag("W-LINECARDADI-03"));
    			solicitud.setTIPDOC_ADI_03(solicitudOutPut.getByTag("W-TIPDOC-ADI-03"));
    			solicitud.setNUMDOC_ADI_03(solicitudOutPut.getByTag("W-NUMDOC-ADI-03"));
    			solicitud.setAPELL_ADI_03(solicitudOutPut.getByTag("W-APELL-ADI-03"));
    			solicitud.setNOMBR_ADI_03(solicitudOutPut.getByTag("W-NOMBR-ADI-03"));
    			solicitud.setFCHNAC_ADI_03(solicitudOutPut.getByTag("W-FCHNAC-ADI-03"));
    			solicitud.setSEXO_ADI_03(solicitudOutPut.getByTag("W-SEXO-ADI-03"));
    			solicitud.setDISPOS_ADI_03(solicitudOutPut.getByTag("W-DISPOS-ADI-03"));
    			solicitud.setFECHAOPER_ADI_03(solicitudOutPut.getByTag("W-FECHAOPER-ADI-03"));
    			
    			solicitud.setMAIL_ADI_03(solicitudOutPut.getByTag("W-MAIL-ADI-03"));
    			solicitud.setNOTIFICA_ADI_03(solicitudOutPut.getByTag("W-NOTIFICA-ADI-03"));
    			solicitud.setOEXTERIO_ADI_03(solicitudOutPut.getByTag("W-OEXTERIO-ADI-03"));
    			solicitud.setMVIRTUAL_ADI_03(solicitudOutPut.getByTag("W-MVIRTUAL-ADI-03"));
    			solicitud.setTLF_CEL_ADI_03(solicitudOutPut.getByTag("W-TLF-CEL-ADI-03"));
    			
    			solicitud.setTIPOCARDADI_04(solicitudOutPut.getByTag("W-TIPOCARDADI-04"));
    			solicitud.setNUMECARDADI_04(solicitudOutPut.getByTag("W-NUMECARDADI-04"));
    			solicitud.setLINECARDADI_04(solicitudOutPut.getByTag("W-LINECARDADI-04"));
    			solicitud.setTIPDOC_ADI_04(solicitudOutPut.getByTag("W-TIPDOC-ADI-04"));
    			solicitud.setNUMDOC_ADI_04(solicitudOutPut.getByTag("W-NUMDOC-ADI-04"));
    			solicitud.setAPELL_ADI_04(solicitudOutPut.getByTag("W-APELL-ADI-04"));
    			solicitud.setNOMBR_ADI_04(solicitudOutPut.getByTag("W-NOMBR-ADI-04"));
    			solicitud.setFCHNAC_ADI_04(solicitudOutPut.getByTag("W-FCHNAC-ADI-04"));
    			solicitud.setSEXO_ADI_04(solicitudOutPut.getByTag("W-SEXO-ADI-04"));
    			solicitud.setDISPOS_ADI_04(solicitudOutPut.getByTag("W-DISPOS-ADI-04"));
    			solicitud.setFECHAOPER_ADI_04(solicitudOutPut.getByTag("W-FECHAOPER-ADI-04"));
    			
    			solicitud.setMAIL_ADI_04(solicitudOutPut.getByTag("W-MAIL-ADI-04"));
    			solicitud.setNOTIFICA_ADI_04(solicitudOutPut.getByTag("W-NOTIFICA-ADI-04"));
    			solicitud.setOEXTERIO_ADI_04(solicitudOutPut.getByTag("W-OEXTERIO-ADI-04"));
    			solicitud.setMVIRTUAL_ADI_04(solicitudOutPut.getByTag("W-MVIRTUAL-ADI-04"));
    			solicitud.setTLF_CEL_ADI_04(solicitudOutPut.getByTag("W-TLF-CEL-ADI-04"));
    			
    			solicitud.setPERSONA_AUTOR(solicitudOutPut.getByTag("W-PERSONA-AUTOR"));
    			solicitud.setTDOCUM_AUTOR(solicitudOutPut.getByTag("W-TDOCUM-AUTOR"));
    			solicitud.setNDOCUM_AUTOR(solicitudOutPut.getByTag("W-NDOCUM-AUTOR"));
    			solicitud.setNOMBRE_GRABAR(solicitudOutPut.getByTag("W-NOMBRE-GRABAR"));
    			solicitud.setCODRESP(solicitudOutPut.getByTag("W-CODRESP"));
    			solicitud.setMSGRESP(solicitudOutPut.getByTag("W-MSGRESP"));
            	
            	
            	
            	

            	
            	
           
              
         	}
			
		} catch (Exception e) {
			log3.error(e,"","");
		}
		return solicitud;
	}
	
	

	
	public  BnSolicitud getSolicitud(String dni,String user){

		CicsSoapConnection cics =  new CicsSoapConnection();
		
		BnSolicitud solicitud = null;
 try {
	    	Head cabIn = new Head();
			Head cabOut = new Head();
			BodySolicitud solicitudInput = new BodySolicitud();
			BodySolicitud2 solicitudOutPut = new BodySolicitud2();
			String tipo="1";
			
			cabIn.cargaData("9999","WS29", "610",user);
			
			String dn1 = dni.substring(4);
			
			solicitudInput.cargarData(tipo,dn1);
		    
		    log3.debug("cab in", cabIn.toShowData(),Constante.LOGGER_DEBUG_NIVEL_2);
			log3.debug("body in", solicitudInput.toShowData(),Constante.LOGGER_DEBUG_NIVEL_2);
			
		    String inputSolicitud= (solicitudInput.toString()).trim();
        	
		    String outSolicitud = null;
	        outSolicitud = cics.enviarTrama(cabIn, inputSolicitud);
	        solicitudOutPut.FillBoby(outSolicitud);
	        
	        System.out.print(outSolicitud);
	        
	//System.out.println("Hoja de Resumen input :" +hojaResumenInput.toShowData());
		 	
		 	;
	 		System.out.println("salida :" +solicitudOutPut.toShowData());
	        
	        
			
			log3.debug("body out1", outSolicitud,Constante.LOGGER_DEBUG_NIVEL_2);
			log3.debug("body out", solicitudOutPut.toShowData(),Constante.LOGGER_DEBUG_NIVEL_2);

            if (outSolicitud != null){
            	solicitud = new BnSolicitud();
            
            
                solicitud.setTIPDOC(solicitudOutPut.getByTag("W-TIPDOC"));
                solicitud.setNUMDOC(solicitudOutPut.getByTag("W-NUMDOC"));
    			solicitud.setAPELLTIT(solicitudOutPut.getByTag("W-APELLTIT"));
    			solicitud.setNOMBRTIT(solicitudOutPut.getByTag("W-NOMBRTIT"));
    			solicitud.setESTCV(solicitudOutPut.getByTag("W-ESTCV"));
    			solicitud.setSEXO(solicitudOutPut.getByTag("W-SEXO"));
    			solicitud.setTIPVIV(solicitudOutPut.getByTag("W-TIPVIV"));
    			solicitud.setDEPENDI(solicitudOutPut.getByTag("W-DEPENDI"));		
    			
    			String mail1 = (solicitudOutPut.getByTag("W-MAIL")).trim();
    			
    			solicitud.setMAIL(mail1.replace(" ", "@"));	
    			
    			solicitud.setCODVIA(solicitudOutPut.getByTag("W-CODVIA"));
    			solicitud.setNOMVIA(solicitudOutPut.getByTag("W-NOMVIA"));
    			solicitud.setNUMVIA(solicitudOutPut.getByTag("W-NUMVIA"));		
    			solicitud.setCODZON(solicitudOutPut.getByTag("W-CODZON"));
    			solicitud.setNOMZON(solicitudOutPut.getByTag("W-NOMZON"));			
    			solicitud.setUBGCLI(solicitudOutPut.getByTag("W-UBGCLI"));		
    			solicitud.setREFEREN(solicitudOutPut.getByTag("W-REFEREN"));		
    			solicitud.setTLFCASA(solicitudOutPut.getByTag("W-TLFCASA"));
    			solicitud.setTLFCELL(solicitudOutPut.getByTag("W-TLFCELL"));
    			solicitud.setEMPLAB_TIT(solicitudOutPut.getByTag("W-EMPLAB-TIT"));		
    			solicitud.setFCHING(solicitudOutPut.getByTag("W-FCHING"));		
    			solicitud.setCODVIA_LAB(solicitudOutPut.getByTag("W-CODVIA-LAB"));
    			solicitud.setNOMVIA_LAB(solicitudOutPut.getByTag("W-NOMVIA-LAB"));
    			solicitud.setNUMVIA_LAB(solicitudOutPut.getByTag("W-NUMVIA-LAB"));			
    			solicitud.setCODZON_LAB(solicitudOutPut.getByTag("W-CODZON-LAB"));
    			solicitud.setNOMZON_LAB(solicitudOutPut.getByTag("W-NOMZON-LAB"));
    			solicitud.setUBGDOM_LAB(solicitudOutPut.getByTag("W-UBGDOM-LAB"));		
    			solicitud.setREFEREN_LAB(solicitudOutPut.getByTag("W-REFEREN-LAB"));
    			solicitud.setTLFLAB(solicitudOutPut.getByTag("W-TLFLAB"));
    			solicitud.setANXLAB(solicitudOutPut.getByTag("W-ANXLAB"));
    			solicitud.setREFERENPER(solicitudOutPut.getByTag("W-REFERENPER"));
    			solicitud.setTLFREF(solicitudOutPut.getByTag("W-TLFREF"));
    			solicitud.setNOMBRE_CYG(solicitudOutPut.getByTag("W-NOMBRE-CYG"));
    			solicitud.setEMPLAB_CYG(solicitudOutPut.getByTag("W-EMPLAB-CYG"));	
    			solicitud.setTLFTRA_CYG(solicitudOutPut.getByTag("W-TLFTRA-CYG"));
    			solicitud.setANXTRA_CYG(solicitudOutPut.getByTag("W-ANXTRA-CYG"));		
    			solicitud.setLINCRE_GLB(solicitudOutPut.getByTag("W-LINCRE-GLB"));
    			solicitud.setCCLO_FAC(solicitudOutPut.getByTag("W-CCLO-FAC"));		
    			solicitud.setTIPCTA_CAR(solicitudOutPut.getByTag("W-TIPCTA-CAR"));
    			solicitud.setMON_CAR(solicitudOutPut.getByTag("W-MON-CAR"));
    			solicitud.setCTA_CAR(solicitudOutPut.getByTag("W-CTA-CAR"));
    			solicitud.setNOMCOR_CLI(solicitudOutPut.getByTag("W-NOMCOR-CLI"));		
    			solicitud.setLINCRE_CTA(solicitudOutPut.getByTag("W-LINCRE-CTA"));			
    			solicitud.setCCLOFAC_CTA(solicitudOutPut.getByTag("W-CCLOFAC-CTA"));
    			solicitud.setFCH_NAC(solicitudOutPut.getByTag("W-FCH-NAC"));
    			solicitud.setSLD_CLI(solicitudOutPut.getByTag("W-SLD-CLI"));
    			solicitud.setBLQ_CAR(solicitudOutPut.getByTag("W-BLQ-CAR"));
    			solicitud.setBLQ_CTA(solicitudOutPut.getByTag("W-BLQ-CTA"));
    			solicitud.setPLAN_CAS(solicitudOutPut.getByTag("W-PLAN-CAS"));
    			solicitud.setPLAN_RET(solicitudOutPut.getByTag("W-PLAN-RET"));
    			solicitud.setCOD_AGE(solicitudOutPut.getByTag("W-COD-AGE"));
    			solicitud.setCODCTR_EVA(solicitudOutPut.getByTag("W-CODCTR-EVA"));
    			solicitud.setCODPROMOTOR(solicitudOutPut.getByTag("W-CODPROMOTOR"));
    			solicitud.setCODFUNCION(solicitudOutPut.getByTag("W-CODFUNCION"));
    			solicitud.setNOM_EN_PLAST(solicitudOutPut.getByTag("W-NOM-EN-PLAST"));
    			solicitud.setNOM_EMP_PLAST(solicitudOutPut.getByTag("W-NOM-EMP-PLAST"));			
    			solicitud.setTIPDIR_ENT(solicitudOutPut.getByTag("W-TIPDIR-ENT"));
    			solicitud.setCODVIA_ENT(solicitudOutPut.getByTag("W-CODVIA-ENT"));
    			solicitud.setNOMVIA_ENT(solicitudOutPut.getByTag("W-NOMVIA-ENT"));
    			solicitud.setNUMVIA_ENT(solicitudOutPut.getByTag("W-NUMVIA-ENT"));		
    			solicitud.setCODZON_ENT(solicitudOutPut.getByTag("W-CODZON-ENT"));
    			solicitud.setNOMZON_ENT(solicitudOutPut.getByTag("W-NOMZON-ENT"));
    			solicitud.setUBGDOM_ENT(solicitudOutPut.getByTag("W-UBGDOM-ENT"));		
    			solicitud.setREFEREN_ENT(solicitudOutPut.getByTag("W-REFEREN-ENT"));	
    			solicitud.setMANDATR_01(solicitudOutPut.getByTag("W-MANDATR-01"));
    			solicitud.setMANDATR_02(solicitudOutPut.getByTag("W-MANDATR-02"));
    			solicitud.setUBG_CLI_DEP(solicitudOutPut.getByTag("W-UBG-CLI-DEP"));
    			solicitud.setUBG_CLI_PRO(solicitudOutPut.getByTag("W-UBG-CLI-PRO"));
    			solicitud.setUBG_CLI_DIS(solicitudOutPut.getByTag("W-UBG-CLI-DIS"));
    			solicitud.setUBG_DOM_LAB_DEP(solicitudOutPut.getByTag("W-UBG-DOM-LAB-DEP"));
    			solicitud.setUBG_DOM_LAB_PRO(solicitudOutPut.getByTag("W-UBG-DOM-LAB-PRO"));
    			solicitud.setUBG_DOM_LAB_DIS(solicitudOutPut.getByTag("W-UBG-DOM-LAB-DIS"));
    			solicitud.setUBG_ZON_ENT_DEP(solicitudOutPut.getByTag("W-UBG-ZON-ENT-DEP"));
    			solicitud.setUBG_ZON_ENT_PRO(solicitudOutPut.getByTag("W-UBG-ZON-ENT-PRO"));
    			solicitud.setUBG_ZON_ENT_DIS(solicitudOutPut.getByTag("W-UBG-ZON-ENT-DIS"));
    			solicitud.setLCORRES(solicitudOutPut.getByTag("W-LCORRES"));
    			solicitud.setDISPOS(solicitudOutPut.getByTag("W-DISPOS"));
    			solicitud.setENDOSO(solicitudOutPut.getByTag("W-ENDOSO"));
    			solicitud.setNOTIFICA(solicitudOutPut.getByTag("W-NOTIFICA"));
    			solicitud.setOEXTERIO(solicitudOutPut.getByTag("W-OEXTERIO"));
    			solicitud.setMVIRTUAL(solicitudOutPut.getByTag("W-MVIRTUAL"));
    			solicitud.setNPOLIZA(solicitudOutPut.getByTag("W-NPOLIZA"));
    			solicitud.setTIPTARJETA(solicitudOutPut.getByTag("W-TIPTARJETA"));
    			solicitud.setCONDLABORA(solicitudOutPut.getByTag("W-CONDLABORA"));
    			solicitud.setCTAAHORRO(solicitudOutPut.getByTag("W-CTAAHORRO"));
    			solicitud.setNROTARJETA(solicitudOutPut.getByTag("W-NROTARJETA"));
    			solicitud.setCELL_SMS(solicitudOutPut.getByTag("W-CELL-SMS"));
    			solicitud.setFCH_SOLICITA(solicitudOutPut.getByTag("W-FCH-SOLICITA"));
    			solicitud.setNOM_TECNICO(solicitudOutPut.getByTag("W-NOM-TECNICO"));
    			solicitud.setNOM_FUNCIONARIO(solicitudOutPut.getByTag("W-NOM-FUNCIONARIO"));
    			solicitud.setNOM_AGENCIA(solicitudOutPut.getByTag("W-NOM-AGENCIA"));
    			solicitud.setCOD_AGENCIA(solicitudOutPut.getByTag("W-COD-AGENCIA"));
    			solicitud.setNOB_VIA_TIT(solicitudOutPut.getByTag("W-NOB-VIA-TIT"));
    			solicitud.setNOB_VIA_LAB(solicitudOutPut.getByTag("W-NOB-VIA-LAB"));		
    			solicitud.setSECTOR(solicitudOutPut.getByTag("W-SECTOR"));
    			
    			//solicitud.setSDESGRAVA(solicitudOutPut.getByTag("W-SDESGRAVA"));
    			

    			String seguroDesgravamen = solicitudOutPut.getByTag("W-SDESGRAVA");
				
				if(seguroDesgravamen.equals("")){
					seguroDesgravamen = " ";
				}else{
						int longDes = seguroDesgravamen.length();
						//0000350000
					//000000013300000
					String decimal = seguroDesgravamen.substring(longDes-5);
					String deci = decimal.substring(0,2);
					
					String entero = seguroDesgravamen.substring(0, 5);
					
				//	System.out.println("primer entero "+entero);
				
					if (entero.equalsIgnoreCase("000000")){
						entero = "0";
					}else{
						entero = Funciones.eliminarCerosAlaIzquierda(entero);
					}
					
					if(entero.equalsIgnoreCase("")){
						entero = "0";
					}
					
			
					String segDes = entero+"."+deci;
					
					seguroDesgravamen = segDes;
					
					solicitud.setSDESGRAVA(seguroDesgravamen);
				}
    			
    			
    			
    			
    			solicitud.setDDEPEND(solicitudOutPut.getByTag("W-DDEPEND"));
    			solicitud.setNTELEF_DEPEND(solicitudOutPut.getByTag("W-NTELEF-DEPEND"));
    			solicitud.setNROTARJDEB(solicitudOutPut.getByTag("W-NROTARJDEB"));
    			solicitud.setCORRELATIVO(solicitudOutPut.getByTag("W-CORRELATIVO"));
    			solicitud.setANEXOLABOR(solicitudOutPut.getByTag("W-ANEXOLABOR"));
    			solicitud.setIND_ARRAY(solicitudOutPut.getByTag("W-IND-ARRAY"));
    			
    			solicitud.setTIPOCARDADI_01(solicitudOutPut.getByTag("W-TIPOCARDADI-01"));
    			solicitud.setNUMECARDADI_01(solicitudOutPut.getByTag("W-NUMECARDADI-01"));
    			solicitud.setLINECARDADI_01(solicitudOutPut.getByTag("W-LINECARDADI-01"));
    			solicitud.setTIPDOC_ADI_01(solicitudOutPut.getByTag("W-TIPDOC-ADI-01"));
    			solicitud.setNUMDOC_ADI_01(solicitudOutPut.getByTag("W-NUMDOC-ADI-01"));
    			solicitud.setAPELL_ADI_01(solicitudOutPut.getByTag("W-APELL-ADI-01"));
    			solicitud.setNOMBR_ADI_01(solicitudOutPut.getByTag("W-NOMBR-ADI-01"));
    			solicitud.setFCHNAC_ADI_01(solicitudOutPut.getByTag("W-FCHNAC-ADI-01"));
    			solicitud.setSEXO_ADI_01(solicitudOutPut.getByTag("W-SEXO-ADI-01"));
    			solicitud.setDISPOS_ADI_01(solicitudOutPut.getByTag("W-DISPOS-ADI-01"));
    			solicitud.setFECHAOPER_ADI_01(solicitudOutPut.getByTag("W-FECHAOPER-ADI-01"));
    			
    			String maiAdi1 = (solicitudOutPut.getByTag("W-MAIL-ADI-01")).trim();
    			
    			solicitud.setMAIL_ADI_01(maiAdi1.replace(" ", "@"));	
    			
    			solicitud.setNOTIFICA_ADI_01(solicitudOutPut.getByTag("W-NOTIFICA-ADI-01"));
    			solicitud.setOEXTERIO_ADI_01(solicitudOutPut.getByTag("W-OEXTERIO-ADI-01"));
    			solicitud.setMVIRTUAL_ADI_01(solicitudOutPut.getByTag("W-MVIRTUAL-ADI-01"));
    			solicitud.setTLF_CEL_ADI_01(solicitudOutPut.getByTag("W-TLF-CEL-ADI-01"));
    		
    					
    				
    			
    		
    			
    			solicitud.setTIPOCARDADI_02(solicitudOutPut.getByTag("W-TIPOCARDADI-02"));
    			solicitud.setNUMECARDADI_02(solicitudOutPut.getByTag("W-NUMECARDADI-02"));
    			solicitud.setLINECARDADI_02(solicitudOutPut.getByTag("W-LINECARDADI-02"));
    			solicitud.setTIPDOC_ADI_02(solicitudOutPut.getByTag("W-TIPDOC-ADI-02"));
    			solicitud.setNUMDOC_ADI_02(solicitudOutPut.getByTag("W-NUMDOC-ADI-02"));
    			solicitud.setAPELL_ADI_02(solicitudOutPut.getByTag("W-APELL-ADI-02"));
    			solicitud.setNOMBR_ADI_02(solicitudOutPut.getByTag("W-NOMBR-ADI-02"));
    			solicitud.setFCHNAC_ADI_02(solicitudOutPut.getByTag("W-FCHNAC-ADI-02"));
    			solicitud.setSEXO_ADI_02(solicitudOutPut.getByTag("W-SEXO-ADI-02"));
    			solicitud.setDISPOS_ADI_02(solicitudOutPut.getByTag("W-DISPOS-ADI-02"));
    			solicitud.setFECHAOPER_ADI_02(solicitudOutPut.getByTag("W-FECHAOPER-ADI-02"));
    			
    		
                 String maiAdi2 = (solicitudOutPut.getByTag("W-MAIL-ADI-02")).trim();
    			
    			solicitud.setMAIL_ADI_02(maiAdi2.replace(" ", "@"));	
    			
    			solicitud.setNOTIFICA_ADI_02(solicitudOutPut.getByTag("W-NOTIFICA-ADI-02"));
    			solicitud.setOEXTERIO_ADI_02(solicitudOutPut.getByTag("W-OEXTERIO-ADI-02"));
    			solicitud.setMVIRTUAL_ADI_02(solicitudOutPut.getByTag("W-MVIRTUAL-ADI-02"));
    			solicitud.setTLF_CEL_ADI_02(solicitudOutPut.getByTag("W-TLF-CEL-ADI-02"));
    			
    			solicitud.setTIPOCARDADI_03(solicitudOutPut.getByTag("W-TIPOCARDADI-03"));
    			solicitud.setNUMECARDADI_03(solicitudOutPut.getByTag("W-NUMECARDADI-03"));
    			solicitud.setLINECARDADI_03(solicitudOutPut.getByTag("W-LINECARDADI-03"));
    			solicitud.setTIPDOC_ADI_03(solicitudOutPut.getByTag("W-TIPDOC-ADI-03"));
    			solicitud.setNUMDOC_ADI_03(solicitudOutPut.getByTag("W-NUMDOC-ADI-03"));
    			solicitud.setAPELL_ADI_03(solicitudOutPut.getByTag("W-APELL-ADI-03"));
    			solicitud.setNOMBR_ADI_03(solicitudOutPut.getByTag("W-NOMBR-ADI-03"));
    			solicitud.setFCHNAC_ADI_03(solicitudOutPut.getByTag("W-FCHNAC-ADI-03"));
    			solicitud.setSEXO_ADI_03(solicitudOutPut.getByTag("W-SEXO-ADI-03"));
    			solicitud.setDISPOS_ADI_03(solicitudOutPut.getByTag("W-DISPOS-ADI-03"));
    			solicitud.setFECHAOPER_ADI_03(solicitudOutPut.getByTag("W-FECHAOPER-ADI-03"));
    			
    			
    			
    		       String maiAdi3 = (solicitudOutPut.getByTag("W-MAIL-ADI-03")).trim();
       			
       			solicitud.setMAIL_ADI_03(maiAdi3.replace(" ", "@"));
    			
    			solicitud.setNOTIFICA_ADI_03(solicitudOutPut.getByTag("W-NOTIFICA-ADI-03"));
    			solicitud.setOEXTERIO_ADI_03(solicitudOutPut.getByTag("W-OEXTERIO-ADI-03"));
    			solicitud.setMVIRTUAL_ADI_03(solicitudOutPut.getByTag("W-MVIRTUAL-ADI-03"));
    			solicitud.setTLF_CEL_ADI_03(solicitudOutPut.getByTag("W-TLF-CEL-ADI-03"));
    			
    			solicitud.setTIPOCARDADI_04(solicitudOutPut.getByTag("W-TIPOCARDADI-04"));
    			solicitud.setNUMECARDADI_04(solicitudOutPut.getByTag("W-NUMECARDADI-04"));
    			solicitud.setLINECARDADI_04(solicitudOutPut.getByTag("W-LINECARDADI-04"));
    			solicitud.setTIPDOC_ADI_04(solicitudOutPut.getByTag("W-TIPDOC-ADI-04"));
    			solicitud.setNUMDOC_ADI_04(solicitudOutPut.getByTag("W-NUMDOC-ADI-04"));
    			solicitud.setAPELL_ADI_04(solicitudOutPut.getByTag("W-APELL-ADI-04"));
    			solicitud.setNOMBR_ADI_04(solicitudOutPut.getByTag("W-NOMBR-ADI-04"));
    			solicitud.setFCHNAC_ADI_04(solicitudOutPut.getByTag("W-FCHNAC-ADI-04"));
    			solicitud.setSEXO_ADI_04(solicitudOutPut.getByTag("W-SEXO-ADI-04"));
    			solicitud.setDISPOS_ADI_04(solicitudOutPut.getByTag("W-DISPOS-ADI-04"));
    			solicitud.setFECHAOPER_ADI_04(solicitudOutPut.getByTag("W-FECHAOPER-ADI-04"));
    			
    			
    		       String maiAdi4 = (solicitudOutPut.getByTag("W-MAIL-ADI-04")).trim();
       			
       			solicitud.setMAIL_ADI_04(maiAdi4.replace(" ", "@"));
       			
    			solicitud.setNOTIFICA_ADI_04(solicitudOutPut.getByTag("W-NOTIFICA-ADI-04"));
    			solicitud.setOEXTERIO_ADI_04(solicitudOutPut.getByTag("W-OEXTERIO-ADI-04"));
    			solicitud.setMVIRTUAL_ADI_04(solicitudOutPut.getByTag("W-MVIRTUAL-ADI-04"));
    			solicitud.setTLF_CEL_ADI_04(solicitudOutPut.getByTag("W-TLF-CEL-ADI-04"));
    			
    			solicitud.setPERSONA_AUTOR(solicitudOutPut.getByTag("W-PERSONA-AUTOR"));
    			solicitud.setTDOCUM_AUTOR(solicitudOutPut.getByTag("W-TDOCUM-AUTOR"));
    			solicitud.setNDOCUM_AUTOR(solicitudOutPut.getByTag("W-NDOCUM-AUTOR"));
    			solicitud.setNOMBRE_GRABAR(solicitudOutPut.getByTag("W-NOMBRE-GRABAR"));
    			solicitud.setCODRESP(solicitudOutPut.getByTag("W-CODRESP"));
    			solicitud.setMSGRESP(solicitudOutPut.getByTag("W-MSGRESP"));
            	
            	
            	
            	

            	
            	
           
              
         	}
			
		} catch (Exception e) {
			log3.error(e,"","");
		}
		return solicitud;
	}
	
	

 public  BnPolizaPrestamo getEmisionDocumentosPrestamo(String nprestamo) throws Exception{
		 
		 
		 
		 CicsSoapConnection cics =  new CicsSoapConnection();
		
		 
		 BnPolizaPrestamo poliza = null;
		 
		 try {
			 
			BodyCronograma polizaInput =new BodyCronograma();
			
		 		
			 polizaInput.cargarData1(nprestamo);
			 
			 System.out.println("GENERAR DOCUMENTO");
			 
			 System.out.println("Solicitud");
				
		  System.out.println("poliza input :" +polizaInput.toShowData());
		 	
		 	String inputCronograma = polizaInput.toString();
		
	 		BodyCronograma bodyIn = new BodyCronograma();
	 		BodyPolizaPrestamo polizaOutPut = null;
		
	 		polizaOutPut = cics.enviarTramaPoliza(polizaInput,bodyIn);
	 		 System.out.println("Poliza");
	 		System.out.println("Poliza :" +polizaOutPut.toShowData());
	 		
	 		
	 		if (polizaOutPut != null){
	 			poliza = new BnPolizaPrestamo();
            
	 			
	 			poliza.setTipo(polizaOutPut.getByTag("TIPO"));
	 			poliza.setCcuenta(polizaOutPut.getByTag("CCUENTA"));
	 			poliza.setCdsbolso(polizaOutPut.getByTag("CDSBOLSO"));
	 			poliza.setImporte(polizaOutPut.getByTag("IMPORTE"));
	 			poliza.setNcuotas(polizaOutPut.getByTag("NCUOTAS"));
	 			poliza.setAcliente(polizaOutPut.getByTag("ACLIENTE"));
	 			poliza.setDireccion(polizaOutPut.getByTag("DIRECCION"));
	 			poliza.setTelefono(polizaOutPut.getByTag("TELEFONO"));
	 			poliza.setTdoc(polizaOutPut.getByTag("TDOC"));
	 			poliza.setNdoc(polizaOutPut.getByTag("NDOC"));
	 			poliza.setFecha_nac(polizaOutPut.getByTag("FECHA_NAC"));
	 			poliza.setNsecuencia(polizaOutPut.getByTag("NSECUENCIA"));
	 			poliza.setNgenerico(polizaOutPut.getByTag("NGENERICO"));
	 			poliza.setFiller1(polizaOutPut.getByTag("FILLER"));
	 			poliza.setSec_poliza(polizaOutPut.getByTag("SEC_POLIZA"));
	 			poliza.setFini_vigencia(polizaOutPut.getByTag("FINI_VIGENCIA"));
	 			poliza.setTasa(polizaOutPut.getByTag("TASA"));
	 			poliza.setTasa_demis(polizaOutPut.getByTag("TASA_DEMIS"));
	 			poliza.setPrima_neta(polizaOutPut.getByTag("PRIMA_NETA"));
	 			poliza.setDerecho_emision(polizaOutPut.getByTag("DERECHO_EMISION"));
	 			poliza.setSgravamen(polizaOutPut.getByTag("SGRAVAMEN"));
	 			poliza.setSprima_des(polizaOutPut.getByTag("SPRIMA_DES"));
	 			poliza.setTasa_des(polizaOutPut.getByTag("TASA_DES"));
	 			poliza.setDemi_des(polizaOutPut.getByTag("DEMI_DES"));
	 			poliza.setIgv_des(polizaOutPut.getByTag("IGV_DES"));
	 			poliza.setFter_vigencia(polizaOutPut.getByTag("FTER_VIGENCIA"));
	 			poliza.setTasa_total(polizaOutPut.getByTag("TASA_TOTAL"));
	 			poliza.setTelefono_bn(polizaOutPut.getByTag("TELEFONO_BN"));
	 			poliza.setPoliza_des(polizaOutPut.getByTag("POLIZA_DES"));
	 			poliza.setSexo(polizaOutPut.getByTag("SEXO"));
	 			poliza.setNacionalidad(polizaOutPut.getByTag("NACIONALIDAD"));
	 			poliza.setEcivil(polizaOutPut.getByTag("ECIVIL"));
	 			poliza.setClaboral(polizaOutPut.getByTag("CLABORAL"));
	 			poliza.setCagencia(polizaOutPut.getByTag("CAGENCIA"));
	 			poliza.setFagencia(polizaOutPut.getByTag("FAGENCIA"));
	 			poliza.setAagencia(polizaOutPut.getByTag("AAGENCIA"));
	 			poliza.setCusuario(polizaOutPut.getByTag("CUSUARIO"));
	 			poliza.setCcuenta_a(polizaOutPut.getByTag("CCUENTA_A"));
	 			poliza.setCdsbolso_a(polizaOutPut.getByTag("CDSBOLSO_A"));
	 			poliza.setPrima_neta_a(polizaOutPut.getByTag("PRIMA_NETA_A"));
	 			poliza.setNgenerico_a(polizaOutPut.getByTag("NGENERICO_A"));
	 			poliza.setFiller2(polizaOutPut.getByTag("FILLER"));
	 			poliza.setSec_poliza_a(polizaOutPut.getByTag("SEC_POLIZA_A"));
	 			poliza.setNombre1(polizaOutPut.getByTag("NOMBRE1"));
	 			poliza.setNombre2(polizaOutPut.getByTag("NOMBRE2"));
	 			poliza.setUbigeo(polizaOutPut.getByTag("UBIGEO"));
	 			poliza.setDistrito(polizaOutPut.getByTag("DISTRITO"));
	 			poliza.setProvincia(polizaOutPut.getByTag("PROVINCIA"));
	 			poliza.setDpto(polizaOutPut.getByTag("DPTO"));
	 			poliza.setCelular(polizaOutPut.getByTag("CELULAR"));
	 			poliza.setEmail(polizaOutPut.getByTag("EMAIL"));
	 			
	 			
			 
	 		}
		 } catch (Exception e) {
				//log3.error(e,"","");
			}
		 
		 
		 //HojaResumen
		 
		 BnHojaResumen hojaResumen = null;
		 
		 
	 try {
			
		 
	
			 BodyHojaResumen hojaResumenInput = new BodyHojaResumen();
		 		
			 hojaResumenInput.cargarData(nprestamo);
				
		 	System.out.println("Hoja de Resumen input :" +hojaResumenInput.toShowData());
		 	
		 	String inputHojaResumen = hojaResumenInput.toString();
		
	 		BodyHojaResumen bodyIn = new BodyHojaResumen();
	 		BodyHojaResumen hojaResumenOutPut = null;
		
	 		hojaResumenOutPut = cics.enviarTramaHojaResumen(hojaResumenInput,bodyIn);
	 		System.out.println("salida :" +hojaResumenOutPut.toShowData());
	 		
	 	
            
 			
 			poliza.setCoderror(hojaResumenOutPut.getByTag("DFH-CERROR"));
 			poliza.setMsj(hojaResumenOutPut.getByTag("DFH-MSJ"));
 			
 			System.out.println("Coderror :" +hojaResumenOutPut.getByTag("DFH-CERROR"));
 			System.out.println("Msj :" +hojaResumenOutPut.getByTag("DFH-MSJ"));
 			
 			
 		
		 
		 
	
	 
		 } catch (Exception e) {
				//log3.error(e,"","");
			}
		 
		
		 //datos para generacion pdf
		 
		// GeneracionDocumentosController generacionPoliza = new GeneracionDocumentosController();
		 //poliza= generacionPoliza.polizaPdf(poliza);
		 
		
				 
			return poliza;	
			
			
		 
	 }
	 
	 
	 
	 
	//cronograma reprogramado
 
 


	
}
