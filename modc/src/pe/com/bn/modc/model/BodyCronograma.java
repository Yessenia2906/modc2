package pe.com.bn.modc.model;

import java.util.Vector;

import pe.com.bn.modc.model.WSData.Campo;



public class BodyCronograma extends WSData{
	

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
		
		this.campos = new Campo[17];
		try {
			
			int num = -1;
			
			this.campos[++num]	    =   new Campo("W-TOPERACION",   Campo.CHARACTER,   2);
			this.campos[++num]	    =   new Campo("W-NPRESTAMO",   Campo.CHARACTER,   13);
			this.campos[++num]	    =   new Campo("W-FDSBOLSO",   Campo.CHARACTER,   8);
			this.campos[++num]		=	new Campo("W-SPRESTAMO",   Campo.CHARACTER,  15);			
			this.campos[++num]		=	new Campo("W-SAMORTIZADO ",  Campo.CHARACTER, 15);
			this.campos[++num]		=	new Campo("W-SACTUAL",  Campo.CHARACTER, 15);
			this.campos[++num]		=	new Campo("W-SDEUDA-DIA",  Campo.CHARACTER, 15);
			this.campos[++num]		=	new Campo("W-NCUOTAS",  Campo.CHARACTER, 3);
			this.campos[++num]	    =   new Campo("W-CRONOGRAMA", Campo.CHARACTER,  3816);
			this.campos[++num]		=	new Campo("W-FILLER",  Campo.CHARACTER, 222);
			this.campos[++num]		=	new Campo("W-TASA",  Campo.CHARACTER, 9);
			this.campos[++num]		=	new Campo("W-TCEA",  Campo.CHARACTER, 9);
			this.campos[++num]		=	new Campo("W-SCPROTEGIDA",  Campo.CHARACTER, 15);
			this.campos[++num]	    =   new Campo("W-CERROR", Campo.CHARACTER,   4);
			this.campos[++num]	    =   new Campo("W-MSJ", Campo.CHARACTER,  60);
			this.campos[++num]	    =   new Campo("W-WS-CERROR", Campo.CHARACTER,   4);
			this.campos[++num]	    =   new Campo("W-WS-MSJ", Campo.CHARACTER,  60);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	 public void cargarData (String prestamo) throws Exception {
	
		int num = -1;
    	
		init();
		this.campos[++num].setString("05");
		
       
		
		this.campos[++num].setString(prestamo);
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
	
	 
	 public void cargarData1 (
			 String desembolso
			) throws Exception {
	
		int num = -1;
    	
		init();
		this.campos[++num].setString("06");
		
      
		//0400041284303
		this.campos[++num].setString(desembolso);
		//this.campos[++num].setString("0400041284303");
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
	 
	 public void FillBobyHost(String bodyInPut) throws Exception {
			initHost(bodyInPut);
			super.FillBoby(bodyInPut);


		}
}
	
	


