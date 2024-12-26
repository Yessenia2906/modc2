package pe.com.bn.modc.model;


import pe.com.bn.modc.model.WSData.Campo;

public class BodySolicitudPrestamo extends WSData{
	
	//private static LoggerSITC log3 = LoggerSITC.getInstance(BodyCancelacion.class.getName());
	
	public void initHost(String bodyInPut){
		this.campos = new Campo[2];
		try {
			
			int num = -1;
			
										this.campos[++num]		=	new Campo("msgnoHost",     Campo.CHARACTER,   4);
										this.campos[++num]		=	new Campo("msjeHost",     Campo.CHARACTER,   (bodyInPut.length()-4));
			
		} catch (Exception e) {
			//log3.error(e,"","");
		} 
	}
	
	public void init(){
		this.campos = new Campo[68];
		try {
			
			int num = -1;
										this.campos[++num]		=	new Campo("DFH-TOPERACION",     Campo.CHARACTER,   2);
										this.campos[++num]		=	new Campo("DFH-NPRESTAMO",     Campo.CHARACTER,   13);
										this.campos[++num]		=	new Campo("DFH-TPRESTAMO",     Campo.CHARACTER,   10);
							            this.campos[++num]		=	new Campo("DFH-FSOLICITUD",     Campo.CHARACTER,  10); 
							            this.campos[++num]		=	new Campo("DFH-MODALIDAD",     Campo.CHARACTER,   25); 
							     	 	this.campos[++num]		=	new Campo("DFH-ACLIENTE",     Campo.CHARACTER,   70); 
							     	 	this.campos[++num]		=	new Campo("DFH-DOCUMENTO",     Campo.CHARACTER,   17); 
							     	 	this.campos[++num]		=	new Campo("DFH-FNAC",     Campo.CHARACTER,   10); 
							     	 	this.campos[++num]		=	new Campo("DFH-ECIVIL",     Campo.CHARACTER,   10);
							     	 	this.campos[++num]		=	new Campo("DFH-SEXO",     Campo.CHARACTER,   10);
							     	 	this.campos[++num]		=	new Campo("DFH-TELEFONO",     Campo.CHARACTER,   10);
							     	 	this.campos[++num]		=	new Campo("DFH-CELULAR",     Campo.CHARACTER,   10);
							     	 	this.campos[++num]		=	new Campo("DFH-DCLIENTE",     Campo.CHARACTER,   70);
							     	 	this.campos[++num]		=	new Campo("DFH-DISTRITO",     Campo.CHARACTER,   40);                        
							     	 	this.campos[++num]		=	new Campo("DFH-PROVINCIA",     Campo.CHARACTER,   40);
							     	 	this.campos[++num]		=	new Campo("DFH-DPTO",     Campo.CHARACTER,   40);
							     	 	this.campos[++num]		=	new Campo("DFH-REFERENCIA",     Campo.CHARACTER,   70);
							     	 	this.campos[++num]		=	new Campo("DFH-CORREO",     Campo.CHARACTER,   70);
							     	 	this.campos[++num]		=	new Campo("DFH-CORRESPONDENCIA",     Campo.CHARACTER,   20);
							     	 	this.campos[++num]		=	new Campo("DFH-CLABORAL",     Campo.CHARACTER,   15);
							     	 	this.campos[++num]		=	new Campo("DFH-ENTIDAD",     Campo.CHARACTER,   30);
							     	 	this.campos[++num]		=	new Campo("DFH-TLABORAL",     Campo.CHARACTER,   10);
							     	 	this.campos[++num]		=	new Campo("DFH-FINGRESO",     Campo.CHARACTER,   10);                        
							     	 	this.campos[++num]		=	new Campo("DFH-SINGRESOS",     Campo.CHARACTER,   15);
							     	 	this.campos[++num]		=	new Campo("DFH-ACLIENTE-G",     Campo.CHARACTER,   70);
							     	 	this.campos[++num]		=	new Campo("DFH-DOCUMENTO-G",     Campo.CHARACTER,   17);
							     	 	this.campos[++num]		=	new Campo("DFH-FNAC-G",     Campo.CHARACTER,   10);
							     	 	this.campos[++num]		=	new Campo("DFH-ECIVIL-G",     Campo.CHARACTER,   10);
							     	 	this.campos[++num]		=	new Campo("DFH-SEXO-G",     Campo.CHARACTER,   10);
							     	 	this.campos[++num]		=	new Campo("DFH-TELEFONO-G",     Campo.CHARACTER,   10);
							     	 	this.campos[++num]		=	new Campo("DFH-CELULAR-G",     Campo.CHARACTER,   10);                        
							     	 	this.campos[++num]		=	new Campo("DFH-DCLIENTE-G",     Campo.CHARACTER,   70);
							     	 	this.campos[++num]		=	new Campo("DFH-DISTRITO-G",     Campo.CHARACTER,   40);
							     	 	this.campos[++num]		=	new Campo("DFH-PROVINCIA-G",     Campo.CHARACTER,   40);
							     	 	this.campos[++num]		=	new Campo("DFH-DPTO-G",     Campo.CHARACTER,   40);
							     	 	this.campos[++num]		=	new Campo("DFH-REFERENCIA-G",     Campo.CHARACTER,   70);
							     	 	this.campos[++num]		=	new Campo("DFH-CORREO-G",     Campo.CHARACTER,   70);
							     	 	this.campos[++num]		=	new Campo("DFH-CORRESPONDENCIA-G",     Campo.CHARACTER,   20);
							     	 	this.campos[++num]		=	new Campo("DFH-CLABORAL-G",     Campo.CHARACTER,   15);
							     	 	this.campos[++num]		=	new Campo("DFH-ENTIDAD-G",     Campo.CHARACTER,   30);                        
							     	 	this.campos[++num]		=	new Campo("DFH-TLABORAL-G",     Campo.CHARACTER,   10);
							     	 	this.campos[++num]		=	new Campo("DFH-FINGRESO-G",     Campo.CHARACTER,   10);
							     	 	this.campos[++num]		=	new Campo("DFH-SINGRESOS-G",     Campo.CHARACTER,   15);
							     	 	this.campos[++num]		=	new Campo("DFH-SSOLICITADO",     Campo.CHARACTER,   15);
							     	 	this.campos[++num]		=	new Campo("DFH-SABONADO",     Campo.CHARACTER,   15);
							     	 	this.campos[++num]		=	new Campo("DFH-ICUOTAP",     Campo.CHARACTER,   1);
							     	 	this.campos[++num]		=	new Campo("DFH-IENDOSO",     Campo.CHARACTER,   1);
							     	 	this.campos[++num]		=	new Campo("DFH-IPGRACIA",     Campo.CHARACTER,   1);
							     	 	this.campos[++num]		=	new Campo("DFH-DPAGO",     Campo.CHARACTER,   2);
							     	 	this.campos[++num]		=	new Campo("DFH-TASA",     Campo.CHARACTER,   13);                        
							     	 	this.campos[++num]		=	new Campo("DFH-TCEA",     Campo.CHARACTER,   15);
							     	 	this.campos[++num]		=	new Campo("DFH-CCUENTA",     Campo.CHARACTER,   13);
							     	 	this.campos[++num]		=	new Campo("DFH-CCUENTA-G",     Campo.CHARACTER,   13);
							     	 	this.campos[++num]		=	new Campo("DFH-SDESGRAVAMEN",     Campo.CHARACTER,   15);
							     	 	this.campos[++num]		=	new Campo("DFH-SCUOTAP",     Campo.CHARACTER,   15);
							     	 	this.campos[++num]		=	new Campo("DFH-NCUOTAS",     Campo.CHARACTER,   3);
							     	 	this.campos[++num]		=	new Campo("DFH-CMONEDA",     Campo.CHARACTER,   10);
							     	 	this.campos[++num]		=	new Campo("DFH-SCUOTA",     Campo.CHARACTER,   15);
							     	 	this.campos[++num]		=	new Campo("DFH-NPREST-RENOV",     Campo.CHARACTER,   16);                        
							     	 	this.campos[++num]		=	new Campo("DFH-SDEUDA",     Campo.CHARACTER,   15);
							     	 	this.campos[++num]		=	new Campo("DFH-SNETO",     Campo.CHARACTER,   15);
							     	 	this.campos[++num]		=	new Campo("DFH-GESTOR",     Campo.CHARACTER,   45);
							     	 	this.campos[++num]		=	new Campo("DFH-SUPER",     Campo.CHARACTER,   45);
							     	 	this.campos[++num]		=	new Campo("DFH-AGENCIA",     Campo.CHARACTER,   45);
							     	 	this.campos[++num]		=	new Campo("DFH-CERROR",     Campo.CHARACTER,   4);
							     	 	this.campos[++num]		=	new Campo("DFH-MSJ",     Campo.CHARACTER,   60);
							     	 	this.campos[++num]		=	new Campo("msgnoHost",     Campo.CHARACTER,   4);
							     	 	this.campos[++num]		=	new Campo("msjeHost",     Campo.CHARACTER,   23);
			
			

		} catch (Exception e) {
			//log3.error(e,"","");
		} 

	}
	
	public void initOk(String bodyInPut){
		this.campos = new Campo[69];
		try {
			
			int num = -1;
			                     	 	
			                     	 	this.campos[++num]		=	new Campo("DFH-TOPERACION",     Campo.CHARACTER,   2);
										this.campos[++num]		=	new Campo("DFH-NPRESTAMO",     Campo.CHARACTER,   13);
										this.campos[++num]		=	new Campo("DFH-TPRESTAMO",     Campo.CHARACTER,   10);
							            this.campos[++num]		=	new Campo("DFH-FSOLICITUD",     Campo.CHARACTER,  10); 
							            this.campos[++num]		=	new Campo("DFH-MODALIDAD",     Campo.CHARACTER,   25); 
							     	 	this.campos[++num]		=	new Campo("DFH-ACLIENTE",     Campo.CHARACTER,   70); 
							     	 	this.campos[++num]		=	new Campo("DFH-DOCUMENTO",     Campo.CHARACTER,   17); 
							     	 	this.campos[++num]		=	new Campo("DFH-FNAC",     Campo.CHARACTER,   10); 
							     	 	this.campos[++num]		=	new Campo("DFH-ECIVIL",     Campo.CHARACTER,   10);
							     	 	this.campos[++num]		=	new Campo("DFH-SEXO",     Campo.CHARACTER,   10);
							     	 	this.campos[++num]		=	new Campo("DFH-TELEFONO",     Campo.CHARACTER,   10);
							     	 	this.campos[++num]		=	new Campo("DFH-CELULAR",     Campo.CHARACTER,   10);
							     	 	this.campos[++num]		=	new Campo("DFH-DCLIENTE",     Campo.CHARACTER,   70);
							     	 	this.campos[++num]		=	new Campo("DFH-DISTRITO",     Campo.CHARACTER,   40);                        
							     	 	this.campos[++num]		=	new Campo("DFH-PROVINCIA",     Campo.CHARACTER,   40);
							     	 	this.campos[++num]		=	new Campo("DFH-DPTO",     Campo.CHARACTER,   40);
							     	 	this.campos[++num]		=	new Campo("DFH-REFERENCIA",     Campo.CHARACTER,   70);
							     	 	this.campos[++num]		=	new Campo("DFH-CORREO",     Campo.CHARACTER,   70);
							     	 	this.campos[++num]		=	new Campo("DFH-CORRESPONDENCIA",     Campo.CHARACTER,   20);
							     	 	this.campos[++num]		=	new Campo("DFH-CLABORAL",     Campo.CHARACTER,   15);
							     	 	this.campos[++num]		=	new Campo("DFH-ENTIDAD",     Campo.CHARACTER,   30);
							     	 	this.campos[++num]		=	new Campo("DFH-TLABORAL",     Campo.CHARACTER,   10);
							     	 	this.campos[++num]		=	new Campo("DFH-FINGRESO",     Campo.CHARACTER,   10);                        
							     	 	this.campos[++num]		=	new Campo("DFH-SINGRESOS",     Campo.CHARACTER,   15);
							     	 	this.campos[++num]		=	new Campo("DFH-ACLIENTE-G",     Campo.CHARACTER,   70);
							     	 	this.campos[++num]		=	new Campo("DFH-DOCUMENTO-G",     Campo.CHARACTER,   17);
							     	 	this.campos[++num]		=	new Campo("DFH-FNAC-G",     Campo.CHARACTER,   10);
							     	 	this.campos[++num]		=	new Campo("DFH-ECIVIL-G",     Campo.CHARACTER,   10);
							     	 	this.campos[++num]		=	new Campo("DFH-SEXO-G",     Campo.CHARACTER,   10);
							     	 	this.campos[++num]		=	new Campo("DFH-TELEFONO-G",     Campo.CHARACTER,   10);
							     	 	this.campos[++num]		=	new Campo("DFH-CELULAR-G",     Campo.CHARACTER,   10);                        
							     	 	this.campos[++num]		=	new Campo("DFH-DCLIENTE-G",     Campo.CHARACTER,   70);
							     	 	this.campos[++num]		=	new Campo("DFH-DISTRITO-G",     Campo.CHARACTER,   40);
							     	 	this.campos[++num]		=	new Campo("DFH-PROVINCIA-G",     Campo.CHARACTER,   40);
							     	 	this.campos[++num]		=	new Campo("DFH-DPTO-G",     Campo.CHARACTER,   40);
							     	 	this.campos[++num]		=	new Campo("DFH-REFERENCIA-G",     Campo.CHARACTER,   70);
							     	 	this.campos[++num]		=	new Campo("DFH-CORREO-G",     Campo.CHARACTER,   70);
							     	 	this.campos[++num]		=	new Campo("DFH-CORRESPONDENCIA-G",     Campo.CHARACTER,   20);
							     	 	this.campos[++num]		=	new Campo("DFH-CLABORAL-G",     Campo.CHARACTER,   15);
							     	 	this.campos[++num]		=	new Campo("DFH-ENTIDAD-G",     Campo.CHARACTER,   30);                        
							     	 	this.campos[++num]		=	new Campo("DFH-TLABORAL-G",     Campo.CHARACTER,   10);
							     	 	this.campos[++num]		=	new Campo("DFH-FINGRESO-G",     Campo.CHARACTER,   10);
							     	 	this.campos[++num]		=	new Campo("DFH-SINGRESOS-G",     Campo.CHARACTER,   15);
							     	 	this.campos[++num]		=	new Campo("DFH-SSOLICITADO",     Campo.CHARACTER,   15);
							     	 	this.campos[++num]		=	new Campo("DFH-SABONADO",     Campo.CHARACTER,   15);
							     	 	this.campos[++num]		=	new Campo("DFH-ICUOTAP",     Campo.CHARACTER,   1);
							     	 	this.campos[++num]		=	new Campo("DFH-IENDOSO",     Campo.CHARACTER,   1);
							     	 	this.campos[++num]		=	new Campo("DFH-IPGRACIA",     Campo.CHARACTER,   1);
							     	 	this.campos[++num]		=	new Campo("DFH-DPAGO",     Campo.CHARACTER,   2);
							     	 	this.campos[++num]		=	new Campo("DFH-TASA",     Campo.CHARACTER,   13);                        
							     	 	this.campos[++num]		=	new Campo("DFH-TCEA",     Campo.CHARACTER,   15);
							     	 	this.campos[++num]		=	new Campo("DFH-CCUENTA",     Campo.CHARACTER,   13);
							     	 	this.campos[++num]		=	new Campo("DFH-CCUENTA-G",     Campo.CHARACTER,   13);
							     	 	this.campos[++num]		=	new Campo("DFH-SDESGRAVAMEN",     Campo.CHARACTER,   15);
							     	 	this.campos[++num]		=	new Campo("DFH-SCUOTAP",     Campo.CHARACTER,   15);
							     	 	this.campos[++num]		=	new Campo("DFH-NCUOTAS",     Campo.CHARACTER,   3);
							     	 	this.campos[++num]		=	new Campo("DFH-CMONEDA",     Campo.CHARACTER,   10);
							     	 	this.campos[++num]		=	new Campo("DFH-SCUOTA",     Campo.CHARACTER,   15);
							     	 	this.campos[++num]		=	new Campo("DFH-NPREST-RENOV",     Campo.CHARACTER,   16);                        
							     	 	this.campos[++num]		=	new Campo("DFH-SDEUDA",     Campo.CHARACTER,   15);
							     	 	this.campos[++num]		=	new Campo("DFH-SNETO",     Campo.CHARACTER,   15);
							     	 	this.campos[++num]		=	new Campo("DFH-GESTOR",     Campo.CHARACTER,   45);
							     	 	this.campos[++num]		=	new Campo("DFH-SUPER",     Campo.CHARACTER,   45);
							     	 	this.campos[++num]		=	new Campo("DFH-AGENCIA",     Campo.CHARACTER,   45);
							     	 	this.campos[++num]		=	new Campo("DFH-CERROR",     Campo.CHARACTER,   4);
							     	 	this.campos[++num]		=	new Campo("DFH-MSJ",     Campo.CHARACTER,   60);
							     	 	this.campos[++num]		=	new Campo("BLANCO",     Campo.CHARACTER,   8296);
							     	 	this.campos[++num]		=	new Campo("msgnoHost",     Campo.CHARACTER,   4);
			                     	 	this.campos[++num]		=	new Campo("msjeHost",     Campo.CHARACTER,   (bodyInPut.length()-9886));
			
			

		} catch (Exception e) {
			//log3.error(e,"","");
		} 

	}

public void cargarData (String tipo_prestamo, String nro_prestamo) throws Exception {
	
	int num = -1;
	
	init();

	this.campos[++num].setString(tipo_prestamo);
	this.campos[++num].setString(nro_prestamo);
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

public void FillBoby(String bodyInPut) throws Exception {
	init();
	super.FillBoby(bodyInPut);


}

public void FillBobyOk(String bodyInPut) throws Exception {
	initOk(bodyInPut);
	super.FillBoby(bodyInPut);


}

public void FillBobyHost(String bodyInPut) throws Exception {
	initHost(bodyInPut);
	super.FillBoby(bodyInPut);


}

}
