package pe.com.bn.comun.log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import pe.com.bn.modc.common.Constante;


public class LoggerMODC {
	
	private String FQCN = "";

	protected LoggerMODC(String name) {
		FQCN = name;
	}

	  public static LoggerMODC getInstance(String name) {
		
		  LoggerMODC hub = new LoggerMODC(name); 
	    return hub; 
	  }
	  
		public void error(Exception e,String codigoError,String mensaje) {

			if(e!=null) 
				e.printStackTrace();
			
			if(!isPrintLogErr("ERROR")) return;
			
			try {
				String formato = "[ERROR/" + FQCN 
				+ "|ERR:" + (codigoError==null?".":codigoError);
				formato = formato + "]-";
				formato = formato + mensaje + "|" ;
				String tracer="";
				if(e!=null){
					formato = formato  + "STRING:" + e.toString() + "|MESSAGE:" + e.getMessage() + "|CAUSA:" + e.getCause(); 
					if(e.getStackTrace()!=null){
						
						for(int i=0;i<e.getStackTrace().length;i++){
							tracer = tracer + e.getStackTrace()[i].toString() + "\n";
						}
					}
					formato = formato  + "|TRACE:\n" + tracer ;
				}
				
				grabarLog(formato,"E");
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}
		
	public void debug(String metdo,String mensaje,String nivel) {

		if(!isPrintLogDebug("DEBUG",nivel)) return;
		
		try {  
			String blk = "";
			for (int f=0;f<25-metdo.length();f++){
				blk += " ";
			}
			String formato = "[DBG/" + metdo + blk + "]\t" ;
			formato = formato + mensaje;
			grabarLog(formato,"D");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void info(String mensaje) {

		try {
			String formato = "|"  + mensaje;
			grabarLog(formato,"I");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
    boolean isPrintLogDebug(String tipo,String nivel){
    
	    try{
    		BnParametroLogger log = new BnParametroLogger();
	    	if(nivel.equals(Constante.LOGGER_DEBUG_NIVEL_1)){
	    		if(tipo.equals("DEBUG") && log.getLoggerPrintDebugNivel_1().equals("true")) return true;
	    	}
	    	if(nivel.equals(Constante.LOGGER_DEBUG_NIVEL_2)){
	    		if(tipo.equals("DEBUG") && log.getLoggerPrintDebugNivel_2().equals("true")) return true;
	    	}	    		
			
		   }catch(Exception e){
		  	    	 e.printStackTrace();
	   }
	   return false;
    	
    }
    
    boolean isPrintLogErr(String tipo){
        
	    try{
	    	BnParametroLogger log = new BnParametroLogger();
			if(tipo.equals("ERROR") && log.getLoggerPrintError().equals("true")) return true;
			
		   }catch(Exception e){
		  	    	 e.printStackTrace();
	   }
	   return false;
    	
    }
    
    
    
     void grabarLog(String mensaje,String tipo){
    	
        String timestamp1="";
        String strMensaje = "";
        Calendar fecha = Calendar.getInstance();
        SimpleDateFormat formato =  new SimpleDateFormat("yyyy/MM/dd HH.mm.ss");
        timestamp1 = formato.format(fecha.getTime());
        strMensaje = "[" + timestamp1 + "]" + mensaje;
        
        BnParametroLogger log = new BnParametroLogger();
        try{
	    	if(tipo.equals("I")){
    			saveFile(log.getProcLoggerPath(),strMensaje);
	    		if (log.getProcLoggerConsole().equals("true")){
	    			System.out.println(strMensaje);
	    		}
	    	}
	    	
	    	if(tipo.equals("E")){
	    		if (log.getErrLoggerFile().equals("true")){
	    			saveFile(log.getErrLoggerPath(),strMensaje);
	    		}
	    		if (log.getErrLoggerConsole().equals("true")){
	    			System.out.println(strMensaje);
	    		}
	    	}
	    	if(tipo.equals("D")){
	    		if (log.getProcLoggerFile().equals("true")){
	    			saveFile(log.getProcLoggerPath(),strMensaje);
	    		}
	    		if (log.getProcLoggerConsole().equals("true")){
	    			System.out.println(strMensaje);
	    		}
	    	}
	    	
  	      }catch(Exception e){
  	    	 e.printStackTrace();
  	      }
  	 }
	
     synchronized void saveFile(String path,String mensaje){
    	 
        BufferedWriter bw = null;
        File fichero =null;
        try{
        	fichero = new File(path);
        	bw = new BufferedWriter(new FileWriter(fichero, true));
        	bw.write(mensaje + "\n");
        	//bw.flush();
        	bw.close();

  	      }catch(Exception e){
  	    	 e.printStackTrace();
  	      }finally{
  	    	if(bw!=null){try {bw.close();bw=null;} catch (Exception e){}}
  	    	if(fichero!=null){try {fichero=null;} catch (Exception e){}}
  	      }
  	 }


}