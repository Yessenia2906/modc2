package pe.com.bn.modc.model;

import pe.com.bn.comun.log.LoggerMODC;
import pe.com.bn.modc.model.WSData.Campo;


public class BodySolicitud extends WSData{
	
	private static LoggerMODC log3 = LoggerMODC
	.getInstance(BodySolicitud.class.getName());

	
	public void init(){
		
		this.campos = new Campo[151];
		try {
			
			int num = -1;
			this.campos[++num]		=	new Campo("W-TIPDOC",     Campo.CHARACTER,   1); //tipo bin
            this.campos[++num]		=	new Campo("W-NUMDOC",     Campo.CHARACTER,   12); //digito de las tarjetas
			this.campos[++num]		=	new Campo("W-APELLTIT",  Campo.CHARACTER, 30);
			this.campos[++num]		=	new Campo("W-NOMBRTIT",   Campo.CHARACTER,  30);
			this.campos[++num]		=	new Campo("W-ESTCV",     Campo.CHARACTER, 1);
			this.campos[++num]		=	new Campo("W-SEXO",       Campo.CHARACTER,  1);
			this.campos[++num]		=	new Campo("W-TIPVIV",     Campo.CHARACTER, 1);
			this.campos[++num]		=	new Campo("W-DEPENDI",     Campo.CHARACTER,  02);			
			this.campos[++num]		=	new Campo("W-MAIL",     Campo.CHARACTER, 30);			
			this.campos[++num]		=	new Campo("W-CODVIA",       Campo.CHARACTER, 2);
			this.campos[++num]		=	new Campo("W-NOMVIA",       Campo.CHARACTER, 30);
			this.campos[++num]		=	new Campo("W-NUMVIA",       Campo.CHARACTER, 37);			
			this.campos[++num]		=	new Campo("W-CODZON",       Campo.CHARACTER, 02);
			this.campos[++num]		=	new Campo("W-NOMZON",       Campo.CHARACTER, 30);			
			this.campos[++num]		=	new Campo("W-UBGCLI",       Campo.CHARACTER, 06);			
			this.campos[++num]		=	new Campo("W-REFEREN",        Campo.CHARACTER, 55);			
			this.campos[++num]		=	new Campo("W-TLFCASA",         Campo.CHARACTER, 10);
			this.campos[++num]		=	new Campo("W-TLFCELL",	      Campo.CHARACTER, 10);
			this.campos[++num]		=	new Campo("W-EMPLAB-TIT",	  Campo.CHARACTER, 30);			
			this.campos[++num]		=	new Campo("W-FCHING",	       Campo.CHARACTER, 8);			
			this.campos[++num]		=	new Campo("W-CODVIA-LAB",       Campo.CHARACTER, 2);
			this.campos[++num]		=	new Campo("W-NOMVIA-LAB",       Campo.CHARACTER, 30);
			this.campos[++num]		=	new Campo("W-NUMVIA-LAB",       Campo.CHARACTER, 37);			
			this.campos[++num]		=	new Campo("W-CODZON-LAB",       Campo.CHARACTER, 02);
			this.campos[++num]		=	new Campo("W-NOMZON-LAB",       Campo.CHARACTER, 30);
			this.campos[++num]		=	new Campo("W-UBGDOM-LAB",       Campo.CHARACTER, 06);			
			this.campos[++num]		=	new Campo("W-REFEREN-LAB",      Campo.CHARACTER, 55);
			this.campos[++num]		=	new Campo("W-TLFLAB",           Campo.CHARACTER, 10);
			this.campos[++num]		=	new Campo("W-ANXLAB",           Campo.CHARACTER, 4);
			this.campos[++num]		=	new Campo("W-REFERENPER",        Campo.CHARACTER, 55);
			this.campos[++num]		=	new Campo("W-TLFREF",            Campo.CHARACTER,  10);
			this.campos[++num]		=	new Campo("W-NOMBRE-CYG",	      Campo.CHARACTER, 30);	
			this.campos[++num]		=	new Campo("W-EMPLAB-CYG",	      Campo.CHARACTER, 30);	
			this.campos[++num]		=	new Campo("W-TLFTRA-CYG",            Campo.CHARACTER, 10);
			this.campos[++num]		=	new Campo("W-ANXTRA-CYG",	          Campo.CHARACTER, 4);			
			this.campos[++num]		=	new Campo("W-LINCRE-GLB",         Campo.CHARACTER, 9);
			this.campos[++num]		=	new Campo("W-CCLO-FAC",	          Campo.CHARACTER, 2);			
			this.campos[++num]		=	new Campo("W-TIPCTA-CAR",	       Campo.CHARACTER, 1);
			this.campos[++num]		=	new Campo("W-MON-CAR",	          Campo.CHARACTER, 1);
			this.campos[++num]		=	new Campo("W-CTA-CAR",	          Campo.CHARACTER, 17);
			this.campos[++num]		=	new Campo("W-NOMCOR-CLI",	       Campo.CHARACTER,15);			
			this.campos[++num]		=	new Campo("W-LINCRE-CTA",         Campo.CHARACTER, 9);			
			this.campos[++num]		=	new Campo("W-CCLOFAC-CTA",	      Campo.CHARACTER, 2);
			this.campos[++num]		=	new Campo("W-FCH-NAC",	          Campo.CHARACTER, 8);
			this.campos[++num]		=	new Campo("W-SLD-CLI",	          Campo.CHARACTER, 9);
			this.campos[++num]		=	new Campo("W-BLQ-CAR",	          Campo.CHARACTER, 1);
			this.campos[++num]		=	new Campo("W-BLQ-CTA ",	          Campo.CHARACTER, 1);
			this.campos[++num]		=	new Campo("W-PLAN-CAS",	          Campo.CHARACTER, 5);
			this.campos[++num]		=	new Campo("W-PLAN-RET",	          Campo.CHARACTER, 5);
			this.campos[++num]		=	new Campo("W-COD-AGE",	          Campo.CHARACTER, 5);
			this.campos[++num]		=	new Campo("W-CODCTR-EVA",	      Campo.CHARACTER, 5);
			this.campos[++num]		=	new Campo("W-CODPROMOTOR",	      Campo.CHARACTER, 11);
			this.campos[++num]		=	new Campo("W-CODFUNCION",	      Campo.CHARACTER, 4);
			this.campos[++num]		=	new Campo("W-NOM-EN-PLAST",	      Campo.CHARACTER, 26);
			this.campos[++num]		=	new Campo("W-NOM-EMP-PLAST",	  Campo.CHARACTER, 26);			
			this.campos[++num]		=	new Campo("W-TIPDIR-ENT",       Campo.CHARACTER, 1);
			this.campos[++num]		=	new Campo("W-CODVIA-ENT",       Campo.CHARACTER, 2);
			this.campos[++num]		=	new Campo("W-NOMVIA-ENT",       Campo.CHARACTER, 30);
			this.campos[++num]		=	new Campo("W-NUMVIA-ENT",       Campo.CHARACTER, 37);			
			this.campos[++num]		=	new Campo("W-CODZON-ENT",       Campo.CHARACTER, 02);
			this.campos[++num]		=	new Campo("W-NOMZON-ENT",       Campo.CHARACTER, 30);
			this.campos[++num]		=	new Campo("W-UBGDOM-ENT",       Campo.CHARACTER, 06);			
			this.campos[++num]		=	new Campo("W-REFEREN-ENT",      Campo.CHARACTER, 55);		
			this.campos[++num]		=	new Campo("W-MANDATR-01",       Campo.CHARACTER, 55);
			this.campos[++num]		=	new Campo("W-MANDATR-02",       Campo.CHARACTER, 55);
			this.campos[++num]	    =   new Campo("W-UBG-CLI-DEP",      Campo.CHARACTER,  30);
			this.campos[++num]	    =   new Campo("W-UBG-CLI-PRO",      Campo.CHARACTER,  30);
			this.campos[++num]	    =   new Campo("W-UBG-CLI-DIS",      Campo.CHARACTER,  30);
			this.campos[++num]	    =   new Campo("W-UBG-DOM-LAB-DEP",  Campo.CHARACTER,  30);
			this.campos[++num]	    =   new Campo("W-UBG-DOM-LAB-PRO",  Campo.CHARACTER,  30);
			this.campos[++num]	    =   new Campo("W-UBG-DOM-LAB-DIS",  Campo.CHARACTER,  30);
			this.campos[++num]	    =   new Campo("W-UBG-ZON-ENT-DEP",  Campo.CHARACTER,  30);
			this.campos[++num]	    =   new Campo("W-UBG-ZON-ENT-PRO",  Campo.CHARACTER,  30);
			this.campos[++num]	    =   new Campo("W-UBG-ZON-ENT-DIS",  Campo.CHARACTER,  30);
			this.campos[++num]		=	new Campo("W-LCORRES",	       Campo.CHARACTER, 1);
			this.campos[++num]		=	new Campo("W-DISPOS",	       Campo.CHARACTER, 1);
			this.campos[++num]		=	new Campo("W-ENDOSO",	       Campo.CHARACTER, 1);
			this.campos[++num]		=	new Campo("W-NOTIFICA",	       Campo.CHARACTER, 1);
			this.campos[++num]		=	new Campo("W-OEXTERIO",	       Campo.CHARACTER, 1);
			this.campos[++num]		=	new Campo("W-MVIRTUAL",	       Campo.CHARACTER, 1);
			this.campos[++num]		=	new Campo("W-NPOLIZA",	       Campo.CHARACTER, 10);
			this.campos[++num]		=	new Campo("W-TIPTARJETA",	   Campo.CHARACTER, 10);
			this.campos[++num]		=	new Campo("W-CONDLABORA",	   Campo.CHARACTER, 25);
			this.campos[++num]		=	new Campo("W-CTAAHORRO",	   Campo.CHARACTER, 11);
			this.campos[++num]		=	new Campo("W-NROTARJETA",	   Campo.CHARACTER, 16);
			this.campos[++num]		=	new Campo("W-CELL-SMS",	       Campo.CHARACTER, 16);
			this.campos[++num]		=	new Campo("W-FCH-SOLICITA",   Campo.CHARACTER, 10);
			this.campos[++num]		=	new Campo("W-NOM-TECNICO",	   Campo.CHARACTER, 35);
			this.campos[++num]		=	new Campo("W-NOM-FUNCIONARIO", Campo.CHARACTER, 35);
			this.campos[++num]		=	new Campo("W-NOM-AGENCIA",	   Campo.CHARACTER, 35);
			this.campos[++num]		=	new Campo("W-COD-AGENCIA",	    Campo.CHARACTER, 04);
			this.campos[++num]		=	new Campo("W-NOB-VIA-TIT",	   Campo.CHARACTER, 10);
			this.campos[++num]		=	new Campo("W-NOB-VIA-LAB",	    Campo.CHARACTER, 10);			
			this.campos[++num]		=	new Campo("W-SECTOR",	        Campo.CHARACTER, 04);
			this.campos[++num]		=	new Campo("W-SDESGRAVA",	    Campo.CHARACTER, 10);
			this.campos[++num]		=	new Campo("W-DDEPEND",	        Campo.CHARACTER, 30);
			this.campos[++num]		=	new Campo("W-NTELEF-DEPEND",	Campo.CHARACTER, 10);
			this.campos[++num]		=	new Campo("W-NROTARJDEB",	    Campo.CHARACTER, 16);
			this.campos[++num]		=	new Campo("W-CORRELATIVO",	   Campo.CHARACTER, 10);
			this.campos[++num]		=	new Campo("W-ANEXOLABOR",	   Campo.CHARACTER, 06);
			this.campos[++num]		=	new Campo("W-IND-ARRAY",   Campo.CHARACTER, 02);
			this.campos[++num]		=	new Campo("W-TIPOCARDADI-01",  Campo.CHARACTER, 10);
			this.campos[++num]		=	new Campo("W-NUMECARDADI-01",  Campo.CHARACTER, 16);
			this.campos[++num]		=	new Campo("W-LINECARDADI-01",  Campo.CHARACTER, 17);
			this.campos[++num]		=	new Campo("W-TIPDOC-ADI-01",   Campo.CHARACTER, 01);
			this.campos[++num]		=	new Campo("W-NUMDOC-ADI-01",   Campo.CHARACTER, 12);
			this.campos[++num]		=	new Campo("W-APELL-ADI-01",	   Campo.CHARACTER, 30);
			this.campos[++num]		=	new Campo("W-NOMBR-ADI-01",	   Campo.CHARACTER, 30);
			this.campos[++num]		=	new Campo("W-FCHNAC-ADI-01",   Campo.CHARACTER, 8);
			this.campos[++num]		=	new Campo("W-SEXO-ADI-01",	   Campo.CHARACTER, 1);
			this.campos[++num]		=	new Campo("W-DISPOS-ADI-01",   Campo.CHARACTER, 1);
			this.campos[++num]		=	new Campo("W-FECHAOPER-ADI-01",  Campo.CHARACTER, 10);
			this.campos[++num]		=	new Campo("W-TIPOCARDADI-02",  Campo.CHARACTER, 10);
			this.campos[++num]		=	new Campo("W-NUMECARDADI-02",  Campo.CHARACTER, 16);
			this.campos[++num]		=	new Campo("W-LINECARDADI-02",  Campo.CHARACTER, 17);
			this.campos[++num]		=	new Campo("W-TIPDOC-ADI-02",   Campo.CHARACTER, 01);
			this.campos[++num]		=	new Campo("W-NUMDOC-ADI-02",   Campo.CHARACTER, 12);
			this.campos[++num]		=	new Campo("W-APELL-ADI-02",	   Campo.CHARACTER, 30);
			this.campos[++num]		=	new Campo("W-NOMBR-ADI-02",	   Campo.CHARACTER, 30);
			this.campos[++num]		=	new Campo("W-FCHNAC-ADI-02",   Campo.CHARACTER, 8);
			this.campos[++num]		=	new Campo("W-SEXO-ADI-02",	   Campo.CHARACTER, 1);
			this.campos[++num]		=	new Campo("W-DISPOS-ADI-02",   Campo.CHARACTER, 1);
			this.campos[++num]		=	new Campo("W-FECHAOPER-ADI-02",  Campo.CHARACTER, 10);
			this.campos[++num]		=	new Campo("W-TIPOCARDADI-03",  Campo.CHARACTER, 10);
			this.campos[++num]		=	new Campo("W-NUMECARDADI-03",  Campo.CHARACTER, 16);
			this.campos[++num]		=	new Campo("W-LINECARDADI-03",  Campo.CHARACTER, 17);
			this.campos[++num]		=	new Campo("W-TIPDOC-ADI-03",   Campo.CHARACTER, 01);
			this.campos[++num]		=	new Campo("W-NUMDOC-ADI-03",   Campo.CHARACTER, 12);
			this.campos[++num]		=	new Campo("W-APELL-ADI-03",	   Campo.CHARACTER, 30);
			this.campos[++num]		=	new Campo("W-NOMBR-ADI-03",	   Campo.CHARACTER, 30);
			this.campos[++num]		=	new Campo("W-FCHNAC-ADI-03",   Campo.CHARACTER, 8);
			this.campos[++num]		=	new Campo("W-SEXO-ADI-03",	   Campo.CHARACTER, 1);
			this.campos[++num]		=	new Campo("W-DISPOS-ADI-03",   Campo.CHARACTER, 1);
			this.campos[++num]		=	new Campo("W-FECHAOPER-ADI-03",  Campo.CHARACTER, 10);
			this.campos[++num]		=	new Campo("W-TIPOCARDADI-04",  Campo.CHARACTER, 10);
			this.campos[++num]		=	new Campo("W-NUMECARDADI-04",  Campo.CHARACTER, 16);
			this.campos[++num]		=	new Campo("W-LINECARDADI-04",  Campo.CHARACTER, 17);
			this.campos[++num]		=	new Campo("W-TIPDOC-ADI-04",   Campo.CHARACTER, 01);
			this.campos[++num]		=	new Campo("W-NUMDOC-ADI-04",   Campo.CHARACTER, 12);
			this.campos[++num]		=	new Campo("W-APELL-ADI-04",	   Campo.CHARACTER, 30);
			this.campos[++num]		=	new Campo("W-NOMBR-ADI-04",	   Campo.CHARACTER, 30);
			this.campos[++num]		=	new Campo("W-FCHNAC-ADI-04",   Campo.CHARACTER, 8);
			this.campos[++num]		=	new Campo("W-SEXO-ADI-04",	   Campo.CHARACTER, 1);
			this.campos[++num]		=	new Campo("W-DISPOS-ADI-04",   Campo.CHARACTER, 1);
			this.campos[++num]		=	new Campo("W-FECHAOPER-ADI-04",  Campo.CHARACTER, 10);
			this.campos[++num]		=	new Campo("W-PERSONA-AUTOR",  Campo.CHARACTER, 30);
			this.campos[++num]		=	new Campo("W-TDOCUM-AUTOR",  Campo.CHARACTER, 02);
			this.campos[++num]		=	new Campo("W-NDOCUM-AUTOR",  Campo.CHARACTER, 15);
			this.campos[++num]		=	new Campo("W-NOMBRE-GRABAR",  Campo.CHARACTER, 35);
			this.campos[++num]	    =   new Campo("W-CODRESP",          Campo.CHARACTER,   2);
			this.campos[++num]	    =   new Campo("W-MSGRESP",          Campo.CHARACTER,  50);
			
			
			
		} catch (Exception e) {
			log3.error(e, "", "");
		}

	}
	

	
	public void cargarData (String tipo,String dni) throws Exception {
		
		int num = -1;
		
		init();
		

		this.campos[++num].setString(tipo);
		this.campos[++num].setString(dni);
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");		
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");		
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");		
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");		
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");		
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");		
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");
		this.campos[++num].setString("");	
		
	}
}