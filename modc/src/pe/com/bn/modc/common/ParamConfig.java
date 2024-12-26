package pe.com.bn.modc.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import pe.com.bn.modc.common.Constant;



public class ParamConfig {
	



	
   public static String getLoggerPrintError() {
	      try {
	        if ((Constant.BN_LOGGER_PRINT_ERROR == null) || (Constant.BN_LOGGER_PRINT_ERROR.equals(""))) {
	          ResourceBundle rb = ResourceBundle.getBundle("parametro");
	          Constant.BN_LOGGER_PRINT_ERROR = rb.getString("modc.logger.error.print");
	          if ((Constant.BN_LOGGER_PRINT_ERROR == null) || (Constant.BN_LOGGER_PRINT_ERROR.equals("")))
	            throw new Exception("Parametro no definido modc.logger.error.print");
	        }
	      } catch (Exception e) {
	    	  e.printStackTrace();
	      }
	      return Constant.BN_LOGGER_PRINT_ERROR;
    }

    public static String getLoggerPrintDebugNivel_1() {
	      try {
	        if ((Constant.BN_LOGGER_PRINT_DEBUG_NIVEL_1 == null) || (Constant.BN_LOGGER_PRINT_DEBUG_NIVEL_1.equals(""))) {
	          ResourceBundle rb = ResourceBundle.getBundle("parametro");
	          Constant.BN_LOGGER_PRINT_DEBUG_NIVEL_1 = rb.getString("modc.logger.debug.print.nivel1");
	          if ((Constant.BN_LOGGER_PRINT_DEBUG_NIVEL_1 == null) || (Constant.BN_LOGGER_PRINT_DEBUG_NIVEL_1.equals("")))
	            throw new Exception("Parametro no definido modc.logger.debug.print.nivel1");
	        }
	      } catch (Exception e) {
	    	 e.printStackTrace();
	      }
	      return Constant.BN_LOGGER_PRINT_DEBUG_NIVEL_1;
    }

	public static String getLoggerPrintDebugNivel_2() {
	      try {
	        if ((Constant.BN_LOGGER_PRINT_DEBUG_NIVEL_2 == null) || (Constant.BN_LOGGER_PRINT_DEBUG_NIVEL_2.equals(""))) {
	        	ResourceBundle rb = ResourceBundle.getBundle("parametro");
	          Constant.BN_LOGGER_PRINT_DEBUG_NIVEL_2 = rb.getString("modc.logger.debug.print.nivel2");
	          if ((Constant.BN_LOGGER_PRINT_DEBUG_NIVEL_2 == null) || (Constant.BN_LOGGER_PRINT_DEBUG_NIVEL_2.equals("")))
	            throw new Exception("Parametro no definido modc.logger.debug.print.nivel2");
	        }
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
	      return Constant.BN_LOGGER_PRINT_DEBUG_NIVEL_2;
	}

	public static String getProcLoggerFile()
	    {
	      try {
	        if ((Constant.BN_PROC_LOGGER_FILE == null) || (Constant.BN_PROC_LOGGER_FILE.equals(""))) {
	        	ResourceBundle rb = ResourceBundle.getBundle("parametro");
	          Constant.BN_PROC_LOGGER_FILE = rb.getString("modc.logger.debug.file.flag");
	          if ((Constant.BN_PROC_LOGGER_FILE == null) || (Constant.BN_PROC_LOGGER_FILE.equals("")))
	            throw new Exception("Parametro no definido modc.logger.debug.file.flag");
	        }
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
	      return Constant.BN_PROC_LOGGER_FILE;
	 }

	 public static String getProcLoggerConsole() {
	      try {
	        if ((Constant.BN_PROC_LOGGER_CONSOLE == null) || (Constant.BN_PROC_LOGGER_CONSOLE.equals(""))) {
	        	ResourceBundle rb = ResourceBundle.getBundle("parametro");
	          Constant.BN_PROC_LOGGER_CONSOLE = rb.getString("modc.logger.debug.console.flag");
	          if ((Constant.BN_PROC_LOGGER_CONSOLE == null) || (Constant.BN_PROC_LOGGER_CONSOLE.equals("")))
	            throw new Exception("Parametro no definido modc.logger.debug.console.flag");
	        }
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
	      return Constant.BN_PROC_LOGGER_CONSOLE;
	 }

	 public static String getProcLoggerPath() {
	      try {
	        if ((Constant.BN_PROC_LOGGER_PATH == null) || (Constant.BN_PROC_LOGGER_PATH.equals(""))) {
	        
	        	Calendar fecha = Calendar.getInstance();
	    	    SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
	    	    String timestamp1 = formato.format(fecha.getTime());
		        ResourceBundle rb = ResourceBundle.getBundle("parametro");
		        String file1 = rb.getString("modc.logger.debug.file.path") + "/modc_info_" + timestamp1 + ".log";
		        Constant.BN_PROC_LOGGER_PATH = file1;
		        if ((Constant.BN_PROC_LOGGER_PATH == null) || (Constant.BN_PROC_LOGGER_PATH.equals("")))
		            throw new Exception("Parametro no definido modc.logger.debug.file.path");
	        }
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
	      return Constant.BN_PROC_LOGGER_PATH;
	 }

	 public static String getErrLoggerFile() {
	      try {
	        if ((Constant.BN_ERR_LOGGER_FILE == null) || (Constant.BN_ERR_LOGGER_FILE.equals(""))) {
	          ResourceBundle rb = ResourceBundle.getBundle("parametro");
	          Constant.BN_ERR_LOGGER_FILE = rb.getString("modc.logger.error.file.flag");
	          if ((Constant.BN_ERR_LOGGER_FILE == null) || (Constant.BN_ERR_LOGGER_FILE.equals("")))
	            throw new Exception("Parametro no definido modc.logger.error.file.flag");
	        }
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
	      return Constant.BN_ERR_LOGGER_FILE;
	 }

	 public static String getErrLoggerConsole()
	    {
	      try {
	        if ((Constant.BN_ERR_LOGGER_CONSOLE == null) || (Constant.BN_ERR_LOGGER_CONSOLE.equals(""))) {
	          ResourceBundle rb = ResourceBundle.getBundle("parametro");
	          Constant.BN_ERR_LOGGER_CONSOLE = rb.getString("modc.logger.error.console.flag");
	          if ((Constant.BN_ERR_LOGGER_CONSOLE == null) || (Constant.BN_ERR_LOGGER_CONSOLE.equals("")))
	            throw new Exception("Parametro no definido modc.logger.error.console.flag");
	        }
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
	      return Constant.BN_ERR_LOGGER_CONSOLE;
	 }

	 public static String getErrLoggerPath()
	    {
	      try {
	        if ((Constant.BN_ERR_LOGGER_PATH == null) || (Constant.BN_ERR_LOGGER_PATH.equals(""))) {

	        	Calendar fecha = Calendar.getInstance();
	    	    SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
	    	    String timestamp1 = formato.format(fecha.getTime());
		        ResourceBundle rb = ResourceBundle.getBundle("parametro");
		        String file1 = rb.getString("modc.logger.error.file.path") + "/modc_err_" + timestamp1 + ".log";
	        	Constant.BN_ERR_LOGGER_PATH = file1;
	          if ((Constant.BN_ERR_LOGGER_PATH == null) || (Constant.BN_ERR_LOGGER_PATH.equals("")))
	            throw new Exception("Parametro no definido modc.logger.error.file.path");
	        }
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
	      return Constant.BN_ERR_LOGGER_PATH;
    }
  }
