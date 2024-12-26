package pe.com.bn.modc.dao.impl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import pe.com.bn.modc.common.Constante;
import pe.com.bn.modc.common.LoggerBn;
import pe.com.bn.modc.common.LoggerWS;
import pe.com.bn.modc.controller.AdministracionController;
import pe.com.bn.modc.dao.pool.ConexionJndi;
import pe.com.bn.modc.domain.mapper.BnConsultaParametros;
import pe.com.bn.modc.domain.mapper.BnConsultaPrestamo;
import pe.com.bn.modc.domain.mapper.BnConsultaSeguroPoliza;
import pe.com.bn.modc.domain.mapper.BnConsultaTarjeta;
import pe.com.bn.modc.listener.contextListenerProperties;

public class ConsultaDocumentoImpl {
	
	private static LoggerWS log3 = LoggerWS.getInstance(ConsultaDocumentoImpl.class.getName());
	private static LoggerBn log4 = LoggerBn.getInstance(ConsultaDocumentoImpl.class.getName());
	
	ConexionJndi dss = new ConexionJndi();
	Connection conn = null;
	
	
	
	
	public boolean actualizarFirmaImagen(InputStream inputStream, String codigoTabla) throws Exception {
		
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE BNMODCF01_PARAMETROS SET F01_VALOR_TABLA = ?, F01_FECHA = SYSDATE WHERE F01_COD_TABLA = ?");

		try {

			conn = dss.connect();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setBlob(1, inputStream);
			pstmt.setString(2, codigoTabla);
			
			int fa = pstmt.executeUpdate();

			if (fa > 0) {
				result = true;
				conn.commit();
			} else {
				result = false;
				conn.rollback();
			}

		} catch (Exception e) {
			if (conn != null) {
				conn.rollback();
			}
			
			log4.error(e, "", e.getMessage());
			
			throw e;
			
		} finally {
			if (conn != null)
				conn.setAutoCommit(true);
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
				}
				
				pstmt = null;
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
				}
				
				conn = null;
			}
		}

		return result;

	}

	
	
public List poliza3126(String numero) throws Exception {
		
		
		
        String sms = "ENVIADO";
		
	
		
		ResultSet rs = null;
		List registros = null;
		Connection conn = null;																		
	 	PreparedStatement pstmt = null;	
	 	StringBuffer sql = new  StringBuffer();
	 	  InputStream input = null;
	 	
	 	String query = "";
	 	

	 	 
	 		 sql.append("ORDER BY  F01_COD_TABLA ASC '"+numero+"'ORDER BY  F01_COD_TABLA ASC");
	 	 
	 	
	 	
	 	try {
	 		
	 		
	 		conn =    dss.connect();
	 		conn.setAutoCommit(false);	
	 		pstmt= conn.prepareStatement(sql.toString());
	 		BnConsultaSeguroPoliza item =new BnConsultaSeguroPoliza();
	 		registros=new ArrayList(); 
			rs = pstmt.executeQuery();
			
			while(rs.next()){	
				 item =new BnConsultaSeguroPoliza();				 
				
				 item.setCodigo(rs.getString(1));
				 item.setDescripcion(rs.getString(2));
				 item.setDocumento(rs.getBlob(3));			
				 item.setFecha(rs.getString(4));
				 item.setIndicador(rs.getString(5));
			
				 	 
				  registros.add(item);    
	
				
					
		
		}
	 	
			
	     
	 		
	 		conn =    dss.connect();
			
	 	} catch (Exception e) {	
	 		if (conn != null) conn.rollback();
	 	//log3.error(e,"","");	
	
	 		throw e;
	 	}finally {
	 		if (conn != null) conn.setAutoCommit(true);	
	 		if (pstmt != null) {try{pstmt.close();}catch(Exception e){}; pstmt = null; }			
	 		if (conn != null) { try{conn.close();}catch(Exception e){}; conn = null;}				
	 	}
	 	
	 
	 	
	return registros;
}


	
	
	
	
public List prestamoConsulta(String desembolso) throws Exception {
		
		
		
        String sms = "ENVIADO";
		
		String tabla = "BN_MODC.BNMODCF02_DOCPRESTAMO";
		
		ResultSet rs = null;
		List registros = null;
		Connection conn = null;																		
	 	PreparedStatement pstmt = null;	
	 	StringBuffer sql = new  StringBuffer();
	 	  InputStream input = null;
	 	
	 	String query = "";
	 	String fechaSistema = "SYSDATE()";

	
	 	
	 	 
	 //	 sql.append("SELECT F02_DESEMBOLSO, F02_TIPO, F02_DOCUMENTO, F02_EMAIL, F02_FECHA_ENVIO,F02_HORA_ENVIO, F02_FECHA_LECTURA,F02_HORA_LECTURA, " +
	 	// 		   " F02_IP_PC_LECTURA, F02_ESTADO, F02_CAMPO1, F02_CAMPO2,F02_FECHA_CARGA" +
	 	 //		   " FROM   "+tabla+" WHERE             F02_DESEMBOLSO = '"+desembolso+"'");
	 	 
	 		 sql.append("SELECT F02_DESEMBOLSO, F02_TIPO, F02_DOCUMENTO, F02_EMAIL, F02_FECHA_ENVIO,F02_HORA_ENVIO, F02_FECHA_LECTURA,F02_HORA_LECTURA, " +
	 			   " F02_IP_PC_LECTURA, F02_ESTADO, F02_CAMPO1, F02_CAMPO2,F02_FECHA_CARGA" +
	 	           " FROM   BN_MODC.BNMODCF02_DOCPRESTAMO WHERE  rowid in(select max(rowid) from  BN_MODC.BNMODCF02_DOCPRESTAMO     WHERE        F02_DESEMBOLSO = '"+desembolso+"')");
	 	 
	 	
	 	
	 	try {
	 		
	 		
	 		conn =    dss.connect();
	 		conn.setAutoCommit(false);	
	 		pstmt= conn.prepareStatement(sql.toString());
	 		BnConsultaPrestamo item =new BnConsultaPrestamo();
	 		registros=new ArrayList(); 
			rs = pstmt.executeQuery();
			
			while(rs.next()){	
				 item =new BnConsultaPrestamo();				 
				
				 item.setDesembolso(rs.getString(1));
				 item.setTipo(rs.getString(2));
				 item.setDocumento(rs.getBlob(3));
				// input = rs.getBinaryStream("F02_DOCUMENTO");
				// item.setDoc(rs.getBinaryStream("F02_DOCUMENTO"));
				 item.setEmail(rs.getString(4));
				 item.setFechaEnvio(rs.getString(5));
				 item.setHoraEnvio(rs.getString(6));
				 item.setFechaLec(rs.getString(7));
				 item.setHoraLec(rs.getString(8));
				 item.setIpLec(rs.getString(9));
				 item.setEstado(rs.getString(10));
				 item.setCampo1(rs.getString(11));
				 item.setCampo2(rs.getString(12));
				 item.setFechaCarga(rs.getString(13));
				 
				 	 
				  registros.add(item);    
	
				
					
		
		}
	 	
			
	     
	 		
	 		conn =    dss.connect();
			
	 	} catch (Exception e) {	
	 		if (conn != null) conn.rollback();
	 	//log3.error(e,"","");	
	
	 		throw e;
	 	}finally {
	 		if (conn != null) conn.setAutoCommit(true);	
	 		if (pstmt != null) {try{pstmt.close();}catch(Exception e){}; pstmt = null; }			
	 		if (conn != null) { try{conn.close();}catch(Exception e){}; conn = null;}				
	 	}
	 	
	 
	 	
	return registros;
}



public List prestamoConsultaCronograma(String desembolso) throws Exception {
	
	
	
    String sms = "ENVIADO";
   
	String tabla = "BN_MODC.BNMODCF04_DOCPRESTAMOCRO";
	
	ResultSet rs = null;
	List registros = null;
	Connection conn = null;																		
 	PreparedStatement pstmt = null;	
 	StringBuffer sql = new  StringBuffer();
 	  InputStream input = null;
 	
 	String query = "";
 	String fechaSistema = "SYSDATE()";

 	
		 sql.append("SELECT  F04_DESEMBOLSO ,F04_TIPO   , F04_DOCUMENTO  , F04_EMAIL  , F04_FECHA_ENVIO  , F04_HORA_ENVIO  ,  F04_FECHA_LECTURA , " +
 			   " F04_HORA_LECTURA , F04_IP_PC_LECTURA , F04_ESTADO  , F04_USUARIO   , F04_CAMPO1  ,  F04_CAMPO2   ,  F04_FECHA_CARGA" +
 	           " FROM   BN_MODC.BNMODCF04_DOCPRESTAMOCRO WHERE  rowid in(select max(rowid) from  BN_MODC.BNMODCF04_DOCPRESTAMOCRO  WHERE  F04_DESEMBOLSO = '"+desembolso+"')");
 	 
 	
 	
 	try {
 		
 		
 		conn =    dss.connect();
 		conn.setAutoCommit(false);	
 		pstmt= conn.prepareStatement(sql.toString());
 		BnConsultaPrestamo item =new BnConsultaPrestamo();
 		registros=new ArrayList(); 
		rs = pstmt.executeQuery();
		
		while(rs.next()){	
			 item =new BnConsultaPrestamo();				 
			
			 item.setDesembolso(rs.getString(1));
			 item.setTipo(rs.getString(2));
			 item.setDocumento(rs.getBlob(3));
			// input = rs.getBinaryStream("F02_DOCUMENTO");
			// item.setDoc(rs.getBinaryStream("F02_DOCUMENTO"));
			 item.setEmail(rs.getString(4));
			 item.setFechaEnvio(rs.getString(5));
			 item.setHoraEnvio(rs.getString(6));
			 item.setFechaLec(rs.getString(7));
			 item.setHoraLec(rs.getString(8));
			 item.setIpLec(rs.getString(9));
			 item.setEstado(rs.getString(10));
			 item.setUsuario(rs.getString(11));
			 item.setCampo1(rs.getString(12));
			 item.setCampo2(rs.getString(13));
			 item.setFechaCarga(rs.getString(14));
			 
			 	 
			  registros.add(item);    

			
				
	
	}
 	
		
     
 		
 		conn =    dss.connect();
		
 	} catch (Exception e) {	
 		if (conn != null) conn.rollback();
 //	log3.error(e,"","");	

 		throw e;
 	}finally {
 		if (conn != null) conn.setAutoCommit(true);	
 		if (pstmt != null) {try{pstmt.close();}catch(Exception e){}; pstmt = null; }			
 		if (conn != null) { try{conn.close();}catch(Exception e){}; conn = null;}				
 	}
 	
 
 	
return registros;
}

public List tarjetaConsulta(String dni) throws Exception {
	
	
	
    String sms = "ENVIADO";
	
	String tabla = "BN_MODC.BNMODCF03_DOCTARJETA";
	
	
	ResultSet rs = null;
	List registros = null;
	Connection conn = null;																		
 	PreparedStatement pstmt = null;	
 	StringBuffer sql = new  StringBuffer();
 	  InputStream input = null;
 	
 	String query = "";
 	String fechaSistema = "SYSDATE()";


 	
 	 
 	 sql.append("SELECT F03_DNI, F03_TIPO, F03_DOCUMENTO, F03_EMAIL, F03_FECHA_ENVIO,F03_HORA_ENVIO, F03_FECHA_LECTURA,F03_HORA_LECTURA, " +
 	 		   " F03_IP_PC_LECTURA, F03_ESTADO, F03_CAMPO1, F03_CAMPO2,F03_FECHA_CARGA FROM   "+tabla+" WHERE F03_DNI = '"+dni+"'");
 	
 	try {
 		
 		
 		conn =    dss.connect();
 		conn.setAutoCommit(false);	
 		pstmt= conn.prepareStatement(sql.toString());
 		BnConsultaTarjeta item =new BnConsultaTarjeta();
 		registros=new ArrayList(); 
		rs = pstmt.executeQuery();
		
		while(rs.next()){	
			 item =new BnConsultaTarjeta();				 
			
			 item.setDesembolso(rs.getString(1));
			 item.setTipo(rs.getString(2));
			 item.setDocumento(rs.getBlob(3));
			
			 item.setEmail(rs.getString(4));
			 item.setFechaEnvio(rs.getString(5));
			 item.setHoraEnvio(rs.getString(6));
			 item.setFechaLec(rs.getString(7));
			 item.setHoraLec(rs.getString(8));
			 item.setIpLec(rs.getString(9));
			 item.setEstado(rs.getString(10));
			 item.setCampo1(rs.getString(11));
			 item.setCampo2(rs.getString(12));
			 item.setFechaCarga(rs.getString(13));
			 
			 	 
			  registros.add(item);    

			
				
	
	}
 	
		
     
 		
 		conn =    dss.connect();
		
 	} catch (Exception e) {	
 		if (conn != null) conn.rollback();
 	//log3.error(e,"","");	

 		throw e;
 	}finally {
 		if (conn != null) conn.setAutoCommit(true);	
 		if (pstmt != null) {try{pstmt.close();}catch(Exception e){}; pstmt = null; }			
 		if (conn != null) { try{conn.close();}catch(Exception e){}; conn = null;}				
 	}
 	
 
 	
return registros;
}
	
	
	
	
	public List prestamoConsultaTodo() throws Exception {
		
		
		ResultSet rs = null;
		List registros = null;
		Connection conn = null;																		
	 	PreparedStatement pstmt = null;	
	 	StringBuffer sql = new  StringBuffer();
	 	  InputStream input = null;
	 	
	 	String query = "";
	 	String fechaSistema = "SYSDATE()";

	 	log3.debug("SELECT BNMODCF02_DOCPRESTAMO", "BNMODCF02_DOCPRESTAMO",Constante.LOGGER_DEBUG_NIVEL_2);
		log4.debug("SELECT BNMODCF02_DOCPRESTAMO",Constante.LOGGER_DEBUG_NIVEL_2);
	 	
	 	 
	 	 sql.append("SELECT rownum,  F02_DESEMBOLSO, F02_TIPO, F02_DOCUMENTO, F02_EMAIL, F02_FECHA_ENVIO,F02_HORA_ENVIO, F02_FECHA_LECTURA,F02_HORA_LECTURA, " +
	 	 		"F02_IP_PC_LECTURA, F02_ESTADO, F02_CAMPO1, F02_CAMPO2,F02_FECHA_CARGA FROM  (SELECT  F02_DESEMBOLSO, F02_TIPO, F02_DOCUMENTO, F02_EMAIL, F02_FECHA_ENVIO,F02_HORA_ENVIO, F02_FECHA_LECTURA,F02_HORA_LECTURA, " +
	 	 		"F02_IP_PC_LECTURA, F02_ESTADO, F02_CAMPO1, F02_CAMPO2,F02_FECHA_CARGA FROM  BN_MODC.BNMODCF02_DOCPRESTAMO ORDER BY F02_FECHA_CARGA ASC)" );
	 	
	 	try {
	 		
	 		
	 		conn =    dss.connect();
	 		conn.setAutoCommit(false);	
	 		pstmt= conn.prepareStatement(sql.toString());
	 		BnConsultaPrestamo item =new BnConsultaPrestamo();
	 		registros=new ArrayList(); 
			rs = pstmt.executeQuery();
			
			while(rs.next()){	
				 item =new BnConsultaPrestamo();
				 
				 item.setFilas(rs.getString(1));
				 item.setDesembolso(rs.getString(2));
				 item.setTipo(rs.getString(3));
				 item.setDocumento(rs.getBlob(4));
				// input = rs.getBinaryStream("F02_DOCUMENTO");
				// item.setDoc(rs.getBinaryStream("F02_DOCUMENTO"));
				 item.setEmail(rs.getString(5));
				 item.setFechaEnvio(rs.getString(6));
				 item.setHoraEnvio(rs.getString(7));
				 item.setFechaLec(rs.getString(8));
				 item.setHoraLec(rs.getString(9));
				 item.setIpLec(rs.getString(10));
				 item.setEstado(rs.getString(11));
				 item.setCampo1(rs.getString(12));
				 item.setCampo2(rs.getString(13));
				 item.setFechaCarga(rs.getString(14));
				 
				 	 
				  registros.add(item);    
	
				
					
		
		}
	 	
	 
	 		
	 		conn =    dss.connect();
			
	 	} catch (Exception e) {	
	 		if (conn != null) conn.rollback();
	 //	log3.error(e,"","");
	 //	log3.error(e, "error select", "error");
	 //	log3.error(e, "error select", "error");
	 	
	 	
	 	log3.debug("ENTRO AL SELECT DE LA EXCEPTION", "EXCEPTION",Constante.LOGGER_DEBUG_NIVEL_2);
		log4.debug("ENTRO AL SELECT DE LA EXCEPTIO",Constante.LOGGER_DEBUG_NIVEL_2);
	 	
	    
	 	
	
	 		throw e;
	 	}finally {
	 		if (conn != null) conn.setAutoCommit(true);	
	 		if (pstmt != null) {try{pstmt.close();}catch(Exception e){}; pstmt = null; }			
	 		if (conn != null) { try{conn.close();}catch(Exception e){}; conn = null;}				
	 	}
	 	
	 	log3.debug("genero registro", "genero registro",Constante.LOGGER_DEBUG_NIVEL_2);
		
		log4.debug("genero registro",Constante.LOGGER_DEBUG_NIVEL_2);
	 	
	return registros;
	
	
	
}
	
	
	
	
	
	public List parametrosConsultaTodo() throws Exception {
		
		
		ResultSet rs = null;
		List registros = null;
		Connection conn = null;																		
	 	PreparedStatement pstmt = null;	
	 	StringBuffer sql = new  StringBuffer();
	 	  InputStream input = null;
	 	
	 	String query = "";
	 	String fechaSistema = "SYSDATE()";

	 	log3.debug("TABLE PARAMETROS ", "TABLA PARAMETROS",Constante.LOGGER_DEBUG_NIVEL_2);
		log4.debug("TABLA PARAMETROS",Constante.LOGGER_DEBUG_NIVEL_2);
	 	
	 	 
	 	 sql.append("select * from bnmodcf01_parametros order by F01_COD_TABLA" );
	 	
	 	try {
	 		
	 		
	 		conn =    dss.connect();
	 		conn.setAutoCommit(false);	
	 		pstmt= conn.prepareStatement(sql.toString());
	 		BnConsultaParametros item =new BnConsultaParametros();
	 		registros=new ArrayList(); 
			rs = pstmt.executeQuery();
			
			while(rs.next()){	
				 item =new BnConsultaParametros();
				 
				 item.setCodigo(rs.getString(1));
				 item.setDescripcion(rs.getString(2));
				
				 item.setDocumento(rs.getBlob(3));
			
				 item.setFecha(rs.getString(4));
				 item.setIdentificador(rs.getString(5));
				
				 
				 	 
				  registros.add(item);    
	
				
					
		
		}
	 	
	 
	 		
	 		conn =    dss.connect();
			
	 	} catch (Exception e) {	
	 		if (conn != null) conn.rollback();
	 //	log3.error(e,"","");
	 //	log3.error(e, "error select", "error");
	 //	log3.error(e, "error select", "error");
	 	
	 	
	 	log3.debug("ENTRO AL SELECT DE LA EXCEPTION", "EXCEPTION",Constante.LOGGER_DEBUG_NIVEL_2);
		log4.debug("ENTRO AL SELECT DE LA EXCEPTIO",Constante.LOGGER_DEBUG_NIVEL_2);
	 	
	    
	 	
	
	 		throw e;
	 	}finally {
	 		if (conn != null) conn.setAutoCommit(true);	
	 		if (pstmt != null) {try{pstmt.close();}catch(Exception e){}; pstmt = null; }			
	 		if (conn != null) { try{conn.close();}catch(Exception e){}; conn = null;}				
	 	}
	 	
	 	log3.debug("genero registro", "genero registro",Constante.LOGGER_DEBUG_NIVEL_2);
		
		log4.debug("genero registro",Constante.LOGGER_DEBUG_NIVEL_2);
	 	
	return registros;
	
	
	
}
	
	

	
	
	
public List prestamoConsultaTodoCronograma() throws Exception {
		
		
		ResultSet rs = null;
		List registros = null;
		Connection conn = null;																		
	 	PreparedStatement pstmt = null;	
	 	StringBuffer sql = new  StringBuffer();
	 	  InputStream input = null;
	 	
	 	String query = "";
	 	String fechaSistema = "SYSDATE()";

	 	log3.debug("SELECT BNMODCF02_DOCPRESTAMO", "BNMODCF02_DOCPRESTAMO",Constante.LOGGER_DEBUG_NIVEL_2);
		log4.debug("SELECT BNMODCF02_DOCPRESTAMO",Constante.LOGGER_DEBUG_NIVEL_2);
	 
		 
	 	 
	 	 sql.append("SELECT rownum,  F04_DESEMBOLSO ,F04_TIPO   , F04_DOCUMENTO  , F04_EMAIL  , F04_FECHA_ENVIO  , F04_HORA_ENVIO  ,  F04_FECHA_LECTURA , " +
	 	 		"F04_HORA_LECTURA , F04_IP_PC_LECTURA , F04_ESTADO  , F04_USUARIO   , F04_CAMPO1  ,  F04_CAMPO2   ,  F04_FECHA_CARGA FROM  (SELECT F04_DESEMBOLSO ,F04_TIPO   , F04_DOCUMENTO  , F04_EMAIL  , F04_FECHA_ENVIO  , F04_HORA_ENVIO  ,  F04_FECHA_LECTURA , " +
	 	 		"F04_HORA_LECTURA , F04_IP_PC_LECTURA , F04_ESTADO  , F04_USUARIO   , F04_CAMPO1  ,  F04_CAMPO2   ,  F04_FECHA_CARGA FROM  BN_MODC.BNMODCF04_DOCPRESTAMOCRO ORDER BY F04_FECHA_CARGA ASC)" );
	 	
	 	try {
	 		
	 		
	 		conn =    dss.connect();
	 		conn.setAutoCommit(false);	
	 		pstmt= conn.prepareStatement(sql.toString());
	 		BnConsultaPrestamo item =new BnConsultaPrestamo();
	 		registros=new ArrayList(); 
			rs = pstmt.executeQuery();
			
			while(rs.next()){	
				 item =new BnConsultaPrestamo();
				 
				 item.setFilas(rs.getString(1));
				 item.setDesembolso(rs.getString(2));
				 item.setTipo(rs.getString(3));
				 item.setDocumento(rs.getBlob(4));
				// input = rs.getBinaryStream("F02_DOCUMENTO");
				// item.setDoc(rs.getBinaryStream("F02_DOCUMENTO"));
				 item.setEmail(rs.getString(5));
				 item.setFechaEnvio(rs.getString(6));
				 item.setHoraEnvio(rs.getString(7));
				 item.setFechaLec(rs.getString(8));
				 item.setHoraLec(rs.getString(9));
				 item.setIpLec(rs.getString(10));
				 item.setEstado(rs.getString(11));
				 item.setUsuario(rs.getString(12));
				 item.setCampo1(rs.getString(13));
				 item.setCampo2(rs.getString(14));
				 item.setFechaCarga(rs.getString(15));
				 
				 	 
				  registros.add(item);    
	
				
					
		
		}
	 	
	 
	 		
	 		conn =    dss.connect();
			
	 	} catch (Exception e) {	
	 		if (conn != null) conn.rollback();
	 	//og3.error(e, "error select", "error");
	 	//log3.error(e, "error select", "error");
	 	
	 	
	 	log3.debug("ENTRO AL SELECT DE LA EXCEPTION", "EXCEPTION",Constante.LOGGER_DEBUG_NIVEL_2);
		log4.debug("ENTRO AL SELECT DE LA EXCEPTIO",Constante.LOGGER_DEBUG_NIVEL_2);
	 	
	    
	 	
	
	 		throw e;
	 	}finally {
	 		if (conn != null) conn.setAutoCommit(true);	
	 		if (pstmt != null) {try{pstmt.close();}catch(Exception e){}; pstmt = null; }			
	 		if (conn != null) { try{conn.close();}catch(Exception e){}; conn = null;}				
	 	}
	 	
	 	log3.debug("genero registro", "genero registro",Constante.LOGGER_DEBUG_NIVEL_2);
		
		log4.debug("genero registro",Constante.LOGGER_DEBUG_NIVEL_2);
	 	
	return registros;
	
	
	
}
	
public List tarjetaConsultaTodo() throws Exception {
		
		
		ResultSet rs = null;
		List registros = null;
		Connection conn = null;																		
	 	PreparedStatement pstmt = null;	
	 	StringBuffer sql = new  StringBuffer();
	 	  InputStream input = null;
	 	
	 	String query = "";
	 	String fechaSistema = "SYSDATE()";

	
	 	
	 	 
	 	 sql.append("select rownum, F03_DNI, F03_TIPO, F03_DOCUMENTO, F03_EMAIL, F03_FECHA_ENVIO,F03_HORA_ENVIO, F03_FECHA_LECTURA,F03_HORA_LECTURA, " +
	 	 		"F03_IP_PC_LECTURA, F03_ESTADO, F03_CAMPO1, F03_CAMPO2,F03_FECHA_CARGA from (SELECT F03_DNI, F03_TIPO, F03_DOCUMENTO, F03_EMAIL, F03_FECHA_ENVIO,F03_HORA_ENVIO, F03_FECHA_LECTURA,F03_HORA_LECTURA, " +
	 	 		"F03_IP_PC_LECTURA, F03_ESTADO, F03_CAMPO1, F03_CAMPO2,F03_FECHA_CARGA,rownum FROM  BN_MODC.BNMODCF03_DOCTARJETA ORDER BY F03_FECHA_CARGA ASC)"); 

	 	
	 	try {
	 		
	 		
	 		conn =    dss.connect();
	 		conn.setAutoCommit(false);	
	 		pstmt= conn.prepareStatement(sql.toString());
	 		BnConsultaTarjeta item =new BnConsultaTarjeta();
	 		registros=new ArrayList(); 
			rs = pstmt.executeQuery();
			
			while(rs.next()){	
				 item =new BnConsultaTarjeta();
				 
				 item.setFilas(rs.getString(1));
				 item.setDesembolso(rs.getString(2));
				 item.setTipo(rs.getString(3));
				 item.setDocumento(rs.getBlob(4));
				
				 item.setEmail(rs.getString(5));
				 item.setFechaEnvio(rs.getString(6));
				 item.setHoraEnvio(rs.getString(7));
				 item.setFechaLec(rs.getString(8));
				 item.setHoraLec(rs.getString(9));
				 item.setIpLec(rs.getString(10));
				 item.setEstado(rs.getString(11));
				 item.setCampo1(rs.getString(12));
				 item.setCampo2(rs.getString(13));
				 item.setFechaCarga(rs.getString(14));
				 
				 	 
				  registros.add(item);    
	
				
					
		
		}
	 	
	 
	 		
	 		conn =    dss.connect();
			
	 	} catch (Exception e) {	
	 		if (conn != null) conn.rollback();
	 //	log3.error(e,"","");	
	
	 		throw e;
	 	}finally {
	 		if (conn != null) conn.setAutoCommit(true);	
	 		if (pstmt != null) {try{pstmt.close();}catch(Exception e){}; pstmt = null; }			
	 		if (conn != null) { try{conn.close();}catch(Exception e){}; conn = null;}				
	 	}
	 	
	return registros;
}
		
	
public InputStream consultaDoc(String desembolso) throws Exception {
		
		
		
        String sms = "ENVIADO";
		
		String tabla = "BN_MODC.BNMODCF02_DOCPRESTAMO";
		
		ResultSet rs = null;
		List registros = null;
		Connection conn = null;																		
	 	PreparedStatement pstmt = null;	
	 	StringBuffer sql = new  StringBuffer();
	 	 InputStream input = null;
	        FileOutputStream output = null;
	 	
	 	String query = "";
	 	String fechaSistema = "SYSDATE()";

	
	 	
	 	 
	 	 sql.append("SELECT F02_DOCUMENTO FROM   "+tabla+" WHERE F02_DESEMBOLSO = '"+desembolso+"'");
	 	
	 	try {
	 		
	 		
	 		conn =    dss.connect();
	 		conn.setAutoCommit(false);	
	 		pstmt= conn.prepareStatement(sql.toString());
	 		BnConsultaPrestamo item =new BnConsultaPrestamo();
	 		registros=new ArrayList(); 
			rs = pstmt.executeQuery();
			
			 File file = new File("reporte_db2.pdf");
	            output = new FileOutputStream(file);
			
	            if (rs.next()) {
	                input = rs.getBinaryStream("F02_DOCUMENTO");
	                System.out.println("Leyendo archivo desde la base de datos...");
	                byte[] buffer = new byte[1024]; 
	                int a =input.read(buffer);
	                while (input.read(buffer) > 0) {
	                    output.write(buffer);
	                    
	                    
	                    System.out.println("> entra while base de datos : ");
	                }
	            	
	                System.out.println("> Archivo guardado en : " + file.getAbsolutePath());
	            }
	 	
	 
	 		
	 		conn =    dss.connect();
			
	 	} catch (Exception e) {	
	 		if (conn != null) conn.rollback();
	// 	log3.error(e,"","");	
	
	 		throw e;
	 	}finally {
            try {
                if (input != null) {
                    input.close();
                }
                if (output != null) {
                    output.close();
                }
                if (pstmt != null) {
                	pstmt.close();
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
	 	
	
}
	 	return input;
}



public  Map<String,InputStream> buscarPdf(int i) throws Exception {


	 Connection connection = null;
	 InputStream pdf = null;
	 String key = null;
	 Map<String,InputStream> resultado = new  HashMap<String,InputStream>();
     try {
         // 1. Establecer la conexión a la base de datos (usando tu propia lógica)
         connection = dss.connect(); // Implementa tu propia lógica de conexión

         // 2. Recuperar el PDF desde la base de datos
         String sql = "SELECT * FROM bnmodcf01_parametros where f01_cod_tabla = ?";
         PreparedStatement preparedStatement = connection.prepareStatement(sql);
         preparedStatement.setString(1, "007"+i); // Reemplaza 1 con la clave primaria del registro que contiene el PDF

         ResultSet resultSet = preparedStatement.executeQuery();
         if (resultSet.next()) {
            pdf = resultSet.getBinaryStream("F01_VALOR_TABLA");

            key = resultSet.getString("F01_DES_TABLA");

             System.out.println("PDF enviado con exito ");
         } else {
             System.out.println("No se encontró un PDF en la base de datos para el registro especificado.");
         }

     } catch (SQLException  e) {
         e.printStackTrace();
     } finally {
         try {
             if (connection != null) {
                 connection.close();
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
	resultado.put(key, pdf);
	
	return resultado;
}








public BnConsultaParametros verparametro(String codparametro) throws Exception {
	
	
	
	ResultSet rs = null;
	Connection conn = null;																		
 	PreparedStatement pstmt = null;	
 	StringBuffer sql = new  StringBuffer();
	BnConsultaParametros parametro = new BnConsultaParametros();
	
	
	
    try {
        // 1. Establecer la conexión a la base de datos (usando tu propia lógica)
    	conn = dss.connect(); 

        // 2. Recuperar el PDF desde la base de datos
        sql.append("SELECT * FROM BN_MODC.bnmodcf01_parametros where f01_cod_tabla = '"+codparametro+"'");
 		conn.setAutoCommit(false);	
 		pstmt= conn.prepareStatement(sql.toString());
		rs = pstmt.executeQuery();

 		
 		
        System.out.println("Parametro encontrado");

        if (rs.next()) {
        	parametro.setCodigo( rs.getString(1));
        	parametro.setDescripcion( rs.getString(2));
        	parametro.setDocumento( rs.getBlob(3));
        	parametro.setFecha( "dd/mm/aaaa");
        	parametro.setIdentificador( rs.getString(5));

            System.out.println("Parametro encontrado fin");

        } else {
            System.out.println("No se encontró un PDF en la base de datos para el registro especificado.");
        }

    } catch (SQLException  e) {
    	parametro = null;
System.out.println(e.getMessage());   
} finally {
        try {
            if (conn != null) {
            	conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	return parametro;
}
	public static void main(String[] args) throws Exception {
		ConsultaDocumentoImpl consultaDocPrestamos = new ConsultaDocumentoImpl();
		Map result = consultaDocPrestamos.buscarPdf(0);
		
		System.out.println(result.toString());
		
		
	}

}
