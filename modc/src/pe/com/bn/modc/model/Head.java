package pe.com.bn.modc.model;



import javax.servlet.ServletContext;
import com.ibm.ejs.ras.SystemOutStream;

import pe.com.bn.comun.log.LoggerMODC;
//import Util.clsConstantes;
import pe.com.bn.modc.common.Funciones;

public class Head extends WSData{
	
	private static LoggerMODC log3 = LoggerMODC.getInstance(Head.class.getName());
	
public void init() {
		
		this.campos = new Campo [11];
		try {
			int num = -1;
			this.campos[++num]		= new Campo("HD-LONG",	        Campo.NUMBER,4); 
            this.campos[++num]      = new Campo("HD-TRAN",          Campo.NUMBER,4); 
			this.campos[++num]		= new Campo("HD-TIMESTAMP",	    Campo.CHARACTER,26); 
			this.campos[++num]		= new Campo("HD-COD-TRAN",	    Campo.NUMBER,4); 
			this.campos[++num]		= new Campo("HD-COD-USER",		Campo.NUMBER,6);
		    this.campos[++num]		= new Campo("HD-COD-RET",		Campo.NUMBER,5); 
			this.campos[++num]		= new Campo("HD-DES-RET",		Campo.CHARACTER,25); 
			this.campos[++num]		= new Campo("HD-COD-CANAL",		Campo.NUMBER,4); 
		    this.campos[++num]		= new Campo("HD-COD-TERM ",		Campo.NUMBER,6); 
			this.campos[++num]		= new Campo("HD-COD-RET-LOG",   Campo.NUMBER,5);
			this.campos[++num]		= new Campo("HD-DES-RET-LOG",	Campo.CHARACTER,22); 

			
			
		} catch (Exception e) {
			log3.error(e,"","");
		}
	}
	
public Head() throws Exception {
	init();
}

public void cargaData (
		String longitud
		,String trax
		,String traxEspec
		,String user
		) throws Exception {
	
	int num = -1;
	
	this.campos[++num].setString(longitud);
	this.campos[++num].setString(trax);
	String timestamp = Funciones.getTimeStamp();
	this.campos[++num].setString(timestamp);
	//this.campos[++num].setString("2011-09-20-17-3-57-999999");
	this.campos[++num].setString(traxEspec);
	this.campos[++num].setString(user);
	this.campos[++num].setString("9999");
	this.campos[++num].setString("");
	this.campos[++num].setString("0004");
	this.campos[++num].setString("");
	this.campos[++num].setString("");
	this.campos[++num].setString("");
}
	
public void FillBoby(String bodyInPut) throws Exception {
	init();
	super.FillBoby(bodyInPut);
}


}
