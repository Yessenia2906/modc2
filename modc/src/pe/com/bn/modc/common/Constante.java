package pe.com.bn.modc.common;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


import pe.com.bn.modc.domain.mapper.BnwsParametro.ParamSimm;

public class Constante {
	
	public static final String ERR_LOGICA_NEGOCIO  			= "5000";
	
	public static ParamSimm BN_PARAM_SIMM= null;
	public static final String ASUNTO_TCSOLICITUD ="SOLICICITUD DE TARJETA DE CREDITO";
	public static final int REQUE_SOLICITD = 171;
	public static final String ASUNTO_TCCANCELACION ="SOLICICITUD DE PAGO TOTAL DE PRESTAMO MULTIRED";
	public static final int REQUE_CANCELACION = 172;
	public static final String ASUNTO_PRESTAMO ="DOCUMENTOS CONTRACTUALES DEL PRÉSTAMO MULTIRED";
	public static final int REQUE_PRESTAMO = 173;
	
	public final static String FIRMA1	    	= 			"0001";	
	public final static String FIRMA2	    	= 			"0002";	
	
	public final static String NOMBRE1	    	= 			"0003";	
	public final static String NOMBRE2	    	= 			"0004";	

	//public static final String APP_ID_DESA								= "SECM";
	public static final String APP_ID_DESA								= "SECM";
	public static final String CONST_ID_DESA							= "00";
	//public static final String APP_ID_DESA2								= "SECM1";
	public static final String APP_ID_DESA2								= "SECM";
	public static final String CONST_ID_DESA2							= "00";
	public static final String CONST_ERROR_DESAHIS						= "Servicio de claves Inactivo";
	public final static String gBN_CONST_MENSAJE_PARAMETROS				= "PARAMETROS DEL SISTEMA VACIO";
	public final static String gBN_CONST_MENSAJE_ESTADOCARGA01			= "LA CARGA DE DATOS NO SE COMPLETO";
	public final static String gBN_CONST_MENSAJE_ESTADOCARGA00			= "NO SE CARGARON LOS DATOS";
	public final static String gBN_CONST_MENSAJE_NORESULTADO			= "NO SE ENCONTRARON RESULTADOS";
	
	//public final static int gBN_DB_SECM								= 1;
	public final static int gBN_DB_SECM								= 1;
	//public final static int gBN_DB_SECM_ORACLE						= 2;
	public final static int gBN_DB_SECM_SQL			= 2;
	public final static int gBN_DB_SBS							    = 3;	
	
	public final static int gBN_PARAM_DB_APP					    = 1; //1 DATA COM - 2 ORACLE
	
	public final static String gBN_TABLA_CLIENTE_FILTRO_BUSQUEDA	= "1";
	public final static String gBN_TABLA_CLIENTE_TIPO_DOCUMENTO		= "2";
	
	public final static String gBN_ITEM_FILTRO_BUSQUEDA_1_IDC					= "2";
	
//	reportes
	public final static String gBN_ITEM_FILTRO_BUSQUEDA_1_AGENCIA				= "1";
	public final static String gBN_ITEM_FILTRO_BUSQUEDA_2_REGION	 		    = "2";
	public final static String gBN_ITEM_FILTRO_BUSQUEDA_3_UNIDADEJECUTORA  			= "3";
	public final static String gBN_ITEM_FILTRO_BUSQUEDA_4_DEPARTAMENTO				= "4";
	public final static String gBN_ITEM_FILTRO_BUSQUEDA_5_PROVINCIA		= "5";
	public final static String gBN_ITEM_FILTRO_BUSQUEDA_6_DISTRITO		= "6";

	public static final int REQUE_EECC = 312; 
	
	public final static String gBN_ITEM_IDC_DNI_TIPO_DOCUMENTO					= "1";
	//public final static String gBN_ITEM_IDC_CPN_TIPO_DOCUMENTO					= "2";
	//public final static String gBN_ITEM_IDC_SWIFT_TIPO_DOCUMENTO				= "3";
	public final static String gBN_ITEM_IDC_CE_TIPO_DOCUMENTO					= "4";
	public final static String gBN_ITEM_IDC_PASAP_TIPO_DOCUMENTO				= "5";
	public final static String gBN_ITEM_IDC_RUC_TIPO_DOCUMENTO					= "6";
	//public final static String gBN_ITEM_IDC_BP_TIPO_DOCUMENTO					= "7";
	//public final static String gBN_ITEM_IDC_BPN_TIPO_DOCUMENTO					= "8";
	//public final static String gBN_ITEM_IDC_BPJ_TIPO_DOCUMENTO					= "9";
	
	public final static String gBN_FETCH_FIRST_ROWS_ONLY						= "100";
	
	public final static String gBN_TIPO_PERSONA_NATURAL						    = "1";
	public final static String gBN_TIPO_PERSONA_JURIDICA						= "3";
	
	public final static String gBN_AHORROS_MN_ACTIVA							= "1";
	public final static String gBN_AHORROS_MN_CERRADA							= "2";
	public final static String gBN_AHORROS_MN_ANULADA							= "3";
	public final static String gBN_AHORROS_MN_BLOQUEADA							= "5";
	public final static String gBN_AHORROS_MN_VIGILADA							= "6";
	public final static String gBN_AHORROS_MN_PARALIZADA						= "7";
	
	public final static String gBN_MENSAJE_NO_PRESENTA							= "No Presenta";
	public final static String gBN_MENSAJE_NO_DISPONIBLE						= "No Disponible";
	
	public  static HashMap CONST_LISNATURALEZA									=null;
	public  static HashMap CONST_LISMONEDA										=null;
	public  static HashMap CONST_LISTIPOCUENTA									=null;
	public  static HashMap CONST_LISESTADOCUENTA								=null;
	public  static HashMap CONST_LISUBCTAMAYOR									=null;
	public  static HashMap CONST_LISOFICINA										=null;
	public  static HashMap CONST_LISPRODUCTO									=null;
	public  static HashMap CONST_LISSITUACIONCUENTA 							=null;
	public  static HashMap CONST_LISESTADOCONTABLE	 							=null;
	public  static HashMap CONST_TIPOCAMBIO			 							=null;
	//public  static HashMap CONST_LISCUENTAS			 							=null;
	
	public final static String CONST_COD_RPTA_NATURALEZA_NO_ENCONTRADO			= "N001";
    public final static String  CONST_DES_RPTA_NATURALEZA_NO_ENCONTRADO			= "NATURALEZA NO ENCONTRADO";
    
    public final static String CONST_COD_RPTA_MONEDA_NO_ENCONTRADO				= "M001";
    public final static String  CONST_DES_RPTA_MONEDA_NO_ENCONTRADO				= "MONEDA NO ENCONTRADO";
    
    public final static String CONST_COD_RPTA_TIPO_CUENTA_NO_ENCONTRADO			= "T001";
    public final static String  CONST_DES_RPTA_TIPO_CUENTA_NO_ENCONTRADO		= "TIPO CUENTA NO ENCONTRADO";
	
    public final static String CONST_COD_RPTA_ESTADO_CUENTA_NO_ENCONTRADO		= "E001";
    public final static String  CONST_DES_RPTA_ESTADO_CUENTA_NO_ENCONTRADO		= "ESTADO NO ENCONTRADO";
    
    public final static String CONST_COD_RPTA_SUBCTA_NO_ENCONTRADO				= "5001";
    public final static String  CONST_DES_RPTA_SUBCTA_ENCONTRADO				= "SUB CUENTA NO ENCONTRADA";
    
    public final static String CONST_COD_RPTA_OFIC_NO_ENCONTRADO				= "O001";
    public final static String CONST_DES_RPTA_OFIC_ENCONTRADO					= "OFICINA NO ENCONTRADA";
    
    public final static String CONST_COD_RPTA_PROD_NO_ENCONTRADO				= "P001";
    public final static String CONST_DES_RPTA_PROD_ENCONTRADO					= "PRODUCTO NO ENCONTRADO";
    
    public final static String CONST_COD_RPTA_SITUACION_NO_ENCONTRADO			= "S001";
    public final static String CONST_DES_RPTA_SITUACION_ENCONTRADO				= "SITUACION NO ENCONTRADA";
    
    public final static String CONST_COD_RPTA_ESTADO_CONTABLE_NO_ENCONTRADO		= "C001";
    public final static String CONST_DES_RPTA_ESTADO_CONTABLE_ENCONTRADO		= "ESTADO CONTABLE NO ENCONTRADA";
    
    public final static String CONST_COD_RPTA_CUENTA_NO_ENCONTRADO				= "F001";
    public final static String CONST_DES_RPTA_CUENTA_ENCONTRADO					= "CUENTA NO ENCONTRADA";
    
    public final static String CONST_COD_RPTA_CLIENTE_RESTRINGIDO				= "CLI1";
    public final static String CONST_DES_RPTA_CLIENTE_RESTRINGIDO				= "CLIENTE RESTRINGIDO";
    
    public final static String CONTROLLER_MENSAJE_OPERACION_DES_ALERTA			= "Existe un Defecto en la Operacion: ";
    public final static String CONTROLLER_MENSAJE_OPERACION_COD_OK				= "desMsjOk";
    public final static String CONTROLLER_MENSAJE_OPERACION_COD_ALERTA			= "desMsjAl";
    public final static String CONTROLLER_MENSAJE_OPERACION_COD_HIPOTECARIO		= "desMsjAlHIPOTECARIO";
    public final static String CONTROLLER_MENSAJE_OPERACION_COD_ALERTA_CICS		= "";
    public final static String CONTROLLER_MENSAJE_OPERACION_COD_ALERTA_RENIEC	= "desMsjAlRECA";
    
    
    
    public final static String CONTROLLER_MENSAJE_DBDATACOM 					= "No hay conexión con la base de datos";
    public final static String CONTROLLER_MENSAJE_TRAMA							= "Problemas recepción de la trama";
    public final static String CONTROLLER_MENSAJE_ORA							= "No se pudo establecer la conexión con ORACLE, error al grabar datos";
    public final static String CONTROLLER_MENSAJE_NO_EXISTE                     = "El DNI ingresado no existe";
    public final static String CONTROLLER_MENSAJE_EXCEPCION						= "Se ha generado una excepción";
    public final static String CONTROLLER_MENSAJE_EXCEPCION_RENIEC				= "Problemas recepción trama RENIEC";
    public final static String CONTROLLER_MENSAJE_EXCEPCION_LISTAS				= "Error al llenar la lista de cuentas";
    public final static String CONTROLLER_MENSAJE_EXCEPCION_SBS					= "Error en la conexión con la BD SBS";
    public static String CONTROLLER_MENSAJE_DBDATACOM_LOGIN				= null;
    
    public final static String CONTROLLER_MENSAJE_REPORTE_VACIO					= "NO SE ENCONTRARON RESULTADOS";
    public final static String CONTROLLER_MENSAJE_REPORTE_LLENO				    = "Haga Clic en Abrir para Confirmar la Exportación";
    public final static String CONTROLLER_MENSAJE_REPORTE_MUESTRA_DATOS		    = "Eliga una Opción";
    public final static String CONTROLLER_MENSAJE_REPORTE_FECHA_NO_VALIDA       = "NO SE ENCONTRARON RESULTADOS"; 
    public final static String CONTROLLER_MENSAJE_REPORTE				    = "";
    
    public final static String LOG_TIPO_BITACORA_01			= "001";
    public final static String LOG_TIPO_BITACORA_02			= "002";
    public final static String LOG_TIPO_BITACORA_03			= "003";
    public final static String LOG_TIPO_BITACORA_04			= "004";
    public final static String LOG_TIPO_BITACORA_05			= "005";
    public final static String LOG_TIPO_BITACORA_06			= "006";
    
    public final static String LOG_DES_BITACORA_01			= "Consulta de ingreso a la aplicación";
    public final static String LOG_DES_BITACORA_02			= "Búsqueda del cliente";
    public final static String LOG_DES_BITACORA_03			= "Consulta de cliente seleccionado";
    public final static String LOG_DES_BITACORA_04			= "Consulta del cierre";
    public final static String LOG_DES_BITACORA_05			= "Consulta de Reportes";
    public final static String LOG_DES_BITACORA_06			= "Consulta de Indicadores";
    
    public final static String NIVEL_CONSULTA_00 = "0";
    public final static String NIVEL_CONSULTA_01 = "1";
    public final static String NIVEL_CONSULTA_02 = "2";
    public final static String NIVEL_CONSULTA_03 = "3";
    public final static String DNI_EN_CONSULTA = "";
    
    
    public final static String MODULO_OPCION_ACTIVAS = "0001";
    public final static String MODULO_OPCION_PASIVAS = "0002";
    public final static String MODULO_OPCION_GARANTIAS = "0003";
    public final static String MODULO_OPCION_AVALES = "0004";
    public final static String MODULO_OPCION_LINEAS = "0005";
    public final static String MODULO_OPCION_OTROS = "0006";
    public final static String MODULO_OPCION_PROVISIONES = "0007";
    public final static String MODULO_OPCION_DATOS_GEN = "0008";
    public final static String MODULO_OPCION_BUSQUEDA = "0009";
    public final static String MODULO_OPCION_POSICION_CLIENTE = "0010";
    public final static String MODULO_OPCION_CIERRE_SESION = "0011";
    public final static String MODULO_OPCION_SBS = "0012";
    public final static String MODULO_OPCION_REPORTES = "0013";
    public final static String MODULO_OPCION_INDICADORES = "0014";
    
    public static String BN_PARAM_BANCO = null;
    public static String BN_PARAM_AGENCIA = null;
    public static String BN_PARAM_CAJERO = null;
    public static String BN_PARAM_CANAL = null;
    public static String BN_PARAM_APLICACION = null;
    public static String BN_PARAM_ESTRUCTURA = null;
    public static String BN_PARAM_COD_TRX = null;
    public static String BN_PARAM_OPERACION = null;
    public static String BN_PARAM_ESTADO_INI_PROC = null;
    public static String BN_PARAM_FORMATO = null;
    public static String BN_PARAM_MONEDA = null;
    public static String BN_PARAM_TIPO_MENSAJE = null;
    public static String BN_PARAM_TIMEOUT = null;
    public static String BN_PARAM_PURGAR = null;
    public static String BN_PARAM_FILLER = null;
    
  
    //public static ConnectionPool BN_POOL_DATACOM_SECM = null;
  

    //public static ParamConJDNI BN_PARAM_SECM_JDNI = null;
 

    
    public static String ERR_CONECTION_DATACOM = "3000";
    public static String ERR_OUT_CONECTION_BDUC = "3001";
    public static String ERR_OUT_MEMORY  ="3002";
    public static String ERR_INTERRUPTED="3003";
    
    public static String CONST_PROCESO_OK = "00000";
    
    public static String BN_USUARIO_APP = null;
    
    //PARA GENERACION DE REPORTES
    public static String BN_VISTA_REPORTE = null; //RIESGOS CREDITOS ALINEAMIENTO
    public static String BN_PROCESO_1800 = null;  //EXITOSO RECHAZADO NOREALIZADO
    public static String BN_PROCESAMIENTO= null;  //EXITOSO RECHAZADO     
    
    //parametros del LOg
    
	//Registro Parametro
	public static final String LOGGER_DEBUG_NIVEL_1 = "1";
	public static final String LOGGER_DEBUG_NIVEL_2 = "2";
	public static String BN_LOGGER_PRINT_ERROR = null;
	public static String BN_LOGGER_PRINT_DEBUG_NIVEL_1 = null;
	public static String BN_LOGGER_PRINT_DEBUG_NIVEL_2 = null;
	
	public static String BN_ERR_LOGGER_FILE = null; 
	public static String BN_ERR_LOGGER_CONSOLE = null;
	public static String BN_ERR_LOGGER_PATH = null;
	
	public static String BN_PROC_LOGGER_FILE = null;
	public static String BN_PROC_LOGGER_CONSOLE = null;
	public static String BN_PROC_LOGGER_PATH = null;
	
	// Version SECM
	//public final static String gBN_VERSION_SECM = "1.2";
	public final static String gBN_VERSION_SECM = "1.1";
	public final static int gBN_INDICADOR_MESES = 11;
	
	
	public static String CT_ERR_MODC_BD = "0200";
	public static String CT_ERR_MODC_FTP = "0300";
	public static String CT_ERR_MODC_CORREO = "0400";
	public static String CT_ERR_MODC_ITF = "0500";
	public static String CT_ERR_MODC_PARAMETROS = "0600";
	public static String CT_ERR_MODC_MSS = "Error consulte con el administrador";

	public static String CT_ERR_BD = "0200";
	public static String CT_ERR_FTP = "0300";
	public static String CT_ERR_SERVICE_EXTERNAL_CORREO = "0400";
	public static String CT_ERR_SERVICE_EXTERNAL_BUDC = "0500";
	public static String CT_ERR_SERVICE_EXTERNAL_PARAMETROS = "0600";
	public static String CT_ERR_INTERNO = "0700";
	public static String CT_ERR_FTP_ARCHIVO = "0800";
	public static String CT_ERR_USUARIO= " Error consulte con el administrador";

    public static final Map<String, String> ERROR_MAP;
    
    static {
        Map<String, String> map = new HashMap<>();
        map.put(CT_ERR_BD, "Problemas en la conexión a la base de datos");
        map.put(CT_ERR_FTP, "Error en la conexión FTP");
        map.put(CT_ERR_SERVICE_EXTERNAL_CORREO, "Error en el servicio externo de correo");
        map.put(CT_ERR_SERVICE_EXTERNAL_BUDC, "Error en el servicio externo BUDC");
        map.put(CT_ERR_SERVICE_EXTERNAL_PARAMETROS, "Error en el servicio externo de parámetros");
        map.put(CT_ERR_INTERNO, "Error dentro del flujo del aplicativo");
        map.put(CT_ERR_FTP_ARCHIVO, "Error al encontrar el archivo");
        ERROR_MAP = Collections.unmodifiableMap(map); // Hacer el mapa inmutable
    }
}
