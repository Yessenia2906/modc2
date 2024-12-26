package pe.com.bn.modc.model;

import pe.com.bn.modc.model.WSData.Campo;

public class BodyIndicador extends WSData{
	
	public void init(){	
		this.campos = new Campo[4];
		try {
			int num = -1;
			this.campos[++num]	    =   new Campo("DFH-TOPERACION",   Campo.CHARACTER,   2);
			this.campos[++num]	    =   new Campo("DFH-NPRESTAMO",   Campo.CHARACTER,   13);
			this.campos[++num]	    =   new Campo("DFH-CERROR",   Campo.CHARACTER,   4);
			this.campos[++num]	    =   new Campo("DFH-MSJ",   Campo.CHARACTER,   60);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}		
		
	

	 public void cargarData (String  nprestamo) throws Exception {
	
		 int num = -1;
			
			init();
			

			this.campos[++num].setString("10");
			this.campos[++num].setString(nprestamo);
			this.campos[++num].setString("");
			this.campos[++num].setString("");
			
			
	 }
		public void FillBoby(String bodyInPut) throws Exception {
			init();
			super.FillBoby(bodyInPut);
		
		
	}
}
