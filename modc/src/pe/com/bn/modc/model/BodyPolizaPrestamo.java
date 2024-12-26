package pe.com.bn.modc.model;


import javax.xml.rpc.holders.StringHolder;






public class BodyPolizaPrestamo extends WSData{
	
	public void init(){	
	

		this.campos = new Campo[53];
		try {
			
			int num = -1;
			
			this.campos[++num]	    =   new Campo("TIPO",   Campo.CHARACTER,   2);
			this.campos[++num]	    =   new Campo("CCUENTA",   Campo.CHARACTER,   11);
			this.campos[++num]	    =   new Campo("CDSBOLSO",   Campo.CHARACTER,   2);
			this.campos[++num]	    =   new Campo("IMPORTE",   Campo.CHARACTER,   15);
			this.campos[++num]	    =   new Campo("NCUOTAS",   Campo.CHARACTER,   2);
			this.campos[++num]	    =   new Campo("ACLIENTE",   Campo.CHARACTER,   45);
			this.campos[++num]	    =   new Campo("DIRECCION",   Campo.CHARACTER,   45);
			this.campos[++num]	    =   new Campo("TELEFONO",   Campo.CHARACTER,   7);
			this.campos[++num]	    =   new Campo("TDOC",   Campo.CHARACTER,   9);
			this.campos[++num]	    =   new Campo("NDOC",   Campo.CHARACTER,   12);
			this.campos[++num]	    =   new Campo("FECHA_NAC",   Campo.CHARACTER,   10);
			this.campos[++num]	    =   new Campo("NSECUENCIA",   Campo.CHARACTER,   7);
			this.campos[++num]	    =   new Campo("NGENERICO",   Campo.CHARACTER,   7);
			this.campos[++num]	    =   new Campo("FILLER1",   Campo.CHARACTER,   1);
			this.campos[++num]	    =   new Campo("SEC_POLIZA",   Campo.CHARACTER,   10);
			this.campos[++num]	    =   new Campo("FINI_VIGENCIA",   Campo.CHARACTER,   10);
			this.campos[++num]	    =   new Campo("TASA",   Campo.CHARACTER,   10);
			this.campos[++num]	    =   new Campo("TASA_DEMIS",   Campo.CHARACTER,   10);
			this.campos[++num]	    =   new Campo("PRIMA_NETA",   Campo.CHARACTER,   15);
			this.campos[++num]	    =   new Campo("DERECHO_EMISION",   Campo.CHARACTER,   15);
			this.campos[++num]	    =   new Campo("SGRAVAMEN",   Campo.CHARACTER,   15);
			this.campos[++num]	    =   new Campo("SPRIMA_DES",   Campo.CHARACTER,   15);
			this.campos[++num]	    =   new Campo("TASA_DES",   Campo.CHARACTER,   12);
			this.campos[++num]	    =   new Campo("DEMI_DES",   Campo.CHARACTER,   12);
			this.campos[++num]	    =   new Campo("IGV_DES",   Campo.CHARACTER,   12);
			this.campos[++num]	    =   new Campo("FTER_VIGENCIA",   Campo.CHARACTER,   10);
			this.campos[++num]	    =   new Campo("TASA_TOTAL",   Campo.CHARACTER,   10);
			this.campos[++num]	    =   new Campo("TELEFONO_BN",   Campo.CHARACTER,   10);
			this.campos[++num]	    =   new Campo("POLIZA_DES",   Campo.CHARACTER,   10);
			this.campos[++num]	    =   new Campo("SEXO",   Campo.CHARACTER,   1);
			this.campos[++num]	    =   new Campo("NACIONALIDAD",   Campo.CHARACTER,   15);
			this.campos[++num]	    =   new Campo("ECIVIL",   Campo.CHARACTER,   10);
			this.campos[++num]	    =   new Campo("CLABORAL",   Campo.CHARACTER,   45);
			this.campos[++num]	    =   new Campo("CAGENCIA",   Campo.CHARACTER,   4);
			this.campos[++num]	    =   new Campo("FAGENCIA",   Campo.CHARACTER,   1);
			this.campos[++num]	    =   new Campo("AAGENCIA",   Campo.CHARACTER,   40);
			this.campos[++num]	    =   new Campo("CUSUARIO",   Campo.CHARACTER,   8);
			this.campos[++num]	    =   new Campo("CCUENTA_A",   Campo.CHARACTER,   11);
			this.campos[++num]	    =   new Campo("CDSBOLSO_A",   Campo.CHARACTER,   2);
			this.campos[++num]	    =   new Campo("PRIMA_NETA_A",   Campo.CHARACTER,   15);
			this.campos[++num]	    =   new Campo("NGENERICO_A",   Campo.CHARACTER,   7);
			this.campos[++num]	    =   new Campo("FILLER2",   Campo.CHARACTER,   1);
			this.campos[++num]	    =   new Campo("SEC_POLIZA_A",   Campo.CHARACTER,   10);
			this.campos[++num]	    =   new Campo("NOMBRE1",   Campo.CHARACTER,   30);
			this.campos[++num]	    =   new Campo("NOMBRE2",   Campo.CHARACTER,   30);
			this.campos[++num]	    =   new Campo("UBIGEO",   Campo.CHARACTER,   6);
			this.campos[++num]	    =   new Campo("DISTRITO",   Campo.CHARACTER,   25);
			this.campos[++num]	    =   new Campo("PROVINCIA",   Campo.CHARACTER,   25);
			this.campos[++num]	    =   new Campo("DPTO",   Campo.CHARACTER,   25);
			this.campos[++num]	    =   new Campo("CELULAR",   Campo.CHARACTER,   9);
			this.campos[++num]	    =   new Campo("EMAIL",   Campo.CHARACTER,   50);
			this.campos[++num]	    =   new Campo("CERROR",   Campo.CHARACTER,   4);
			this.campos[++num]	    =   new Campo("MSJ",   Campo.CHARACTER,   60);
			
       
	
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	 public void cargarData (
			 String  nprestamo
			) throws Exception {
		 
		int num = -1;
	
		init();
		

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
		public void FillBoby(String bodyInPut) throws Exception {
			init();
			super.FillBoby(bodyInPut);
		
		
	}
	
	

}
