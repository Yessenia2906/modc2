/*
 * Creado el 30/04/2009
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package pe.com.bn.modc.listener;

import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import pe.com.bn.modc.common.Constant;
import pe.com.bn.modc.common.LoggerBn;
import pe.com.bn.modc.common.ParamConfig;
import pe.com.bn.modc.common.Row;
import pe.com.bn.modc.listener.contextListenerProperties;
 
/**
 * @author 
 *
 * TODO Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public class contextListenerProperties implements ServletContextListener,Runnable {

	ServletContextEvent arg;
	private static LoggerBn log3 = LoggerBn.getInstance(contextListenerProperties.class.getName());
	
	public void contextInitialized(ServletContextEvent arg0) {

		arg = arg0;
		Thread connectThread = new Thread(this);
        connectThread.start();
		
	}

    public void run() {
		try{
			log3.debug("INIT LOAD DB PARAMETRO111",Constant.LOGGER_DEBUG_NIVEL_1);
	   		
		} catch (Exception e) {
			e.printStackTrace();
			log3.error(e, Constant.ERR_LOGICA_NEGOCIO, "");
	    }
		
    }
    
	

	
	public void contextDestroyed(ServletContextEvent arg0) {
		
  
	}

}
