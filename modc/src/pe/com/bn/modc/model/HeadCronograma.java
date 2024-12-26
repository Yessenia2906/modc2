package pe.com.bn.modc.model;



public class HeadCronograma extends WSData{
	
	public void init() {
		
		this.campos = new Campo [12];
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
			this.campos[++num]		=	new Campo("W-TASA",  Campo.CHARACTER, 9);
			this.campos[++num]		=	new Campo("W-TCEA",  Campo.CHARACTER, 9);
			this.campos[++num]	    =   new Campo("W-CERROR", Campo.CHARACTER,   4);
			this.campos[++num]	    =   new Campo("W-MSJ", Campo.CHARACTER,  60);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HeadCronograma() throws Exception {
		init();
	}
	
	public void cargaData (
			 String toperacion,
			 String nprestamo,
			 String fdsbolso,
			 String sprestamo,
			 String samortizado,
			 String sactual,
			 String sdeuda_dia,
			 String ncuotas,
			 String tasa,
			 String tcea,
			 String cerror,
			 String msj
			) throws Exception {
		
    	int num = -1;
    	
    	this.campos[++num].setString("05");
    	this.campos[++num].setString(nprestamo);
    		
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
