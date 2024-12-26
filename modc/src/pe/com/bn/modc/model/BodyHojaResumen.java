package pe.com.bn.modc.model;






public class BodyHojaResumen extends WSData{
	
	public void init(){	
		

		this.campos = new Campo[24];
		try {
			
			int num = -1;
			
			this.campos[++num]	    =   new Campo("DFH-TOPERACION",   Campo.CHARACTER,   2);
			this.campos[++num]	    =   new Campo("DFH-NPRESTAMO",   Campo.CHARACTER,   13);
			this.campos[++num]	    =   new Campo("DFH-SPRESTAMO",   Campo.CHARACTER,   15);
			this.campos[++num]	    =   new Campo("DFH-SINTERES",   Campo.CHARACTER,   15);
			this.campos[++num]	    =   new Campo("DFH-STAS-IC",   Campo.CHARACTER,   10);
			this.campos[++num]	    =   new Campo("DFH-STASA-IM",   Campo.CHARACTER,   10);
			this.campos[++num]	    =   new Campo("DFH-CIA-SEG-DESGV",   Campo.CHARACTER,   50);
			this.campos[++num]	    =   new Campo("DFH-PSEGURO-DESGV",   Campo.CHARACTER,   10);
			this.campos[++num]	    =   new Campo("DFH-PEMISION-DESGV",   Campo.CHARACTER,   10);
			this.campos[++num]	    =   new Campo("DFH-SSEGURO-DESGV",   Campo.CHARACTER,   15);
			this.campos[++num]	    =   new Campo("DFH-NPOLIZA-DESGV",   Campo.CHARACTER,   23);
			this.campos[++num]	    =   new Campo("DFH-CIA-ASEG-CP",   Campo.CHARACTER,   50);
			this.campos[++num]	    =   new Campo("DFH-SPRIMA-CP",   Campo.CHARACTER,   15);
			this.campos[++num]	    =   new Campo("DFH-SEMISION-CP",   Campo.CHARACTER,   15);
			this.campos[++num]	    =   new Campo("DFH-PREFIJO-CP",   Campo.CHARACTER,   10);
			this.campos[++num]	    =   new Campo("DFH-FILLER-CP",   Campo.CHARACTER,   3);
			this.campos[++num]	    =   new Campo("DFH-NPOLIZA-CP",   Campo.CHARACTER,   10);
			this.campos[++num]	    =   new Campo("DFH-SSEGURO-CP",   Campo.CHARACTER,   15);
			this.campos[++num]	    =   new Campo("DFH-SENDOSO",   Campo.CHARACTER,   15);
			this.campos[++num]	    =   new Campo("DFH-SENVIO",   Campo.CHARACTER,   15);
			this.campos[++num]	    =   new Campo("DFH-NO-AMORTCAP",   Campo.CHARACTER,   2);
			this.campos[++num]	    =   new Campo("DFH-SI-PAGINT",   Campo.CHARACTER,   2);
			this.campos[++num]	    =   new Campo("DFH-CERROR",   Campo.CHARACTER,   4);
			this.campos[++num]	    =   new Campo("DFH-MSJ",   Campo.CHARACTER,   60);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}		
		
	

	 public void cargarData (  String  nprestamo) throws Exception {
	
		 int num = -1;
			
			init();
			

			this.campos[++num].setString("08");
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
			this.campos[++num].setString("");
			this.campos[++num].setString("");
			this.campos[++num].setString("");
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
