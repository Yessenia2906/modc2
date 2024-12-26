package pe.com.bn.modc.model;

import pe.com.bn.modc.model.WSData.Campo;

public class BodyPase extends WSData{
	

	public void initHost(String bodyInPut){
		this.campos = new Campo[2];
		try {
			
			int num = -1;
			
										this.campos[++num]		=	new Campo("msgnoHost",     Campo.CHARACTER,   4);
										this.campos[++num]		=	new Campo("msjeHost",     Campo.CHARACTER,   (bodyInPut.length()-4));
			
		} catch (Exception e) {
			
		} 
	}


public void init(){
		
		this.campos = new Campo[44];
		try {
			
			int num = -1;
			
		
			
			this.campos[++num]		=	new Campo("DFH-TOPERACION-76",     Campo.CHARACTER,   2); 
			this.campos[++num]		=	new Campo("DFH-NPRESTAMO-76",     Campo.CHARACTER,   13);										
     	 	this.campos[++num]	    =   new Campo("W-FDSBOLSO",   Campo.CHARACTER,   8);		
			this.campos[++num]	    =   new Campo("W-SPRESTAMO",   Campo.CHARACTER,   15);
			this.campos[++num]	    =   new Campo("W-SACTUAL",   Campo.CHARACTER,   15);
			this.campos[++num]	    =   new Campo("W-NCUOTAS",   Campo.CHARACTER,   3);
			this.campos[++num]		=	new Campo("W-NCUOTAS_PDTS",   Campo.CHARACTER,  3);					
			this.campos[++num]	    =   new Campo("W-TASA",   Campo.CHARACTER,   9);	
			this.campos[++num]	    =   new Campo("W-TCEA",   Campo.CHARACTER,   9);	
			this.campos[++num]	    =   new Campo("W-TSEG",   Campo.CHARACTER,   9);	
			this.campos[++num]	    =   new Campo("W-FVENCMTO",   Campo.CHARACTER,   8);	
			this.campos[++num]	    =   new Campo("W-FJUDICIAL",   Campo.CHARACTER,   8);							
			this.campos[++num]	    =   new Campo("W-FDEMANDA",   Campo.CHARACTER,   8);		
			this.campos[++num]	    =   new Campo("W-FCTACTE",   Campo.CHARACTER,   8);		
			this.campos[++num]	    =   new Campo("W-NCTACTE",   Campo.CHARACTER,   18);		
			this.campos[++num]	    =   new Campo("W-ACLIENTE",   Campo.CHARACTER,   45);		
			this.campos[++num]	    =   new Campo("W-DCLIENTE",   Campo.CHARACTER,   45);		
			this.campos[++num]	    =   new Campo("W-DOCUMENTO",   Campo.CHARACTER,   16);			
			this.campos[++num]	    =   new Campo("W-FNACMTO",   Campo.CHARACTER,   8);		
			this.campos[++num]	    =   new Campo("W-SEXO",   Campo.CHARACTER,   1);		
			this.campos[++num]	    =   new Campo("W-TELEFONO",   Campo.CHARACTER,   10);		
			this.campos[++num]	    =   new Campo("W-CORREO",   Campo.CHARACTER,   50);		
			this.campos[++num]	    =   new Campo("W-CCUENTA",   Campo.CHARACTER,   11);		
			this.campos[++num]	    =   new Campo("W-ENTIDAD",   Campo.CHARACTER,   50);						           
			this.campos[++num]	    =   new Campo("W-DATRASOS",   Campo.CHARACTER,   7);	
			this.campos[++num]	    =   new Campo("W-SJUDICIAL",   Campo.CHARACTER,   15);	
			this.campos[++num]	    =   new Campo("W-SINTVENC",   Campo.CHARACTER,   15);	
			this.campos[++num]	    =   new Campo("W-SINTCOMP",   Campo.CHARACTER,   15);	
			this.campos[++num]	    =   new Campo("W-SINTMORA",   Campo.CHARACTER,   15);	
			this.campos[++num]	    =   new Campo("W-SSEGURO",   Campo.CHARACTER,   15);	
			this.campos[++num]	    =   new Campo("W-NCUOTAS_JUD",   Campo.CHARACTER,   3);				
			this.campos[++num]	    =   new Campo("W-SCUOTAP_JUD",   Campo.CHARACTER,   15);
			this.campos[++num]	    =   new Campo("W-COMENT1",   Campo.CHARACTER,   50);
			this.campos[++num]	    =   new Campo("W-COMENT2",   Campo.CHARACTER,   50);
			
			this.campos[++num]	    =   new Campo("W-NCUOTAS_PAG",   Campo.CHARACTER,   3);
			this.campos[++num]	    =   new Campo("W-SCUOTAS",   Campo.CHARACTER,   15);
			this.campos[++num]	    =   new Campo("W-CAGENCIA",   Campo.CHARACTER,  4);
			this.campos[++num]	    =   new Campo("W-SABONOS",   Campo.CHARACTER,   15);
			this.campos[++num]	    =   new Campo("W-QSBS",   Campo.CHARACTER,   1);
			this.campos[++num]	    =   new Campo("W-SINTERES",   Campo.CHARACTER,   15);
			this.campos[++num]	    =   new Campo("W-SDESGRAV",   Campo.CHARACTER,   15);
			this.campos[++num]	    =   new Campo("W-SCONLAB",   Campo.CHARACTER,   15);
			
			
			
			
			
			this.campos[++num]	    =   new Campo("W-CERROR",   Campo.CHARACTER,   4);
			this.campos[++num]	    =   new Campo("W-MSJ",   Campo.CHARACTER,   60);
			
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

public void cargarData (String tipo_prestamo, String desembolso) throws Exception {
	
	int num = -1;
	
	init();

	this.campos[++num].setString(tipo_prestamo);
	this.campos[++num].setString(desembolso);
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

public void FillBoby(String bodyInPut) throws Exception {
	init();
	super.FillBoby(bodyInPut);
	
}
	


}
