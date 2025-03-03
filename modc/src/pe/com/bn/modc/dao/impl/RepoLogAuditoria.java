package pe.com.bn.modc.dao.impl;

 
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
 

import pe.com.bn.modc.common.LoggerEECC;
import pe.com.bn.modc.config.CustomUser;
import pe.com.bn.modc.dao.inte.IntLogAuditoria;
import pe.com.bn.modc.dao.pool.ConexionJndi;
import pe.com.bn.modc.domain.mapper.BnAuditoriaPM;
import pe.com.bn.modc.domain.mapper.BnEnviarDoc;
import pe.com.bn.modc.domain.mapper.BnLogAuditoriaPM;
import pe.com.bn.modc.domain.mapper.BnValidarCorreoOTP;
import pe.com.bn.modc.model.AudiLog;


@Repository
public class RepoLogAuditoria implements IntLogAuditoria{
	
	
	 

      // Crear un formato de fecha
	private static  SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
      
	private static LoggerEECC log = LoggerEECC.getInstance(RepoLogAuditoria.class
			.getName());
	
	ConexionJndi dss = new ConexionJndi();
	
	@PostConstruct
    public void init() {
        // Tareas de inicializaci�n que deseas ejecutar despu�s de la construcci�n del bean
        log.debug("BEAN PARA REGSITRAR LOG CREADO EXITOSAMENTE "  ,"1");
 
    }
	
	
	@Override
	public AudiLog saveAudiLog(CustomUser usuario,AudiLog app) {
	    String insertSQL = "INSERT INTO BNMODCF07_LOG_EECC" +
	    		" (F07_FECHA, F07_HORA, F07_USUARIO, F07_ACCION, F07_DNI,F07_COD_AGENCIA,F07_NAME_AGENCIA) " +
	    		"VALUES ( TO_DATE(?, 'DD/MM/YYYY'), ?, ?, ?, ?, ?, ?)";

	    try (Connection connection = dss.connect();
	         PreparedStatement pstmt = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS)) {

	        connection.setAutoCommit(false);
	     // Formatear la fecha
	        Date date = new Date();
	        app.setDatosUsuario(usuario);
	        app.setFecha(dateFormat.format(date));
	        app.setHora(timeFormat.format(date));
	        // Establecer los valores de los par�metros
	        pstmt.setString(1, app.getFecha() );
	        pstmt.setString(2,	app.getHora()  );
	        pstmt.setString(3, app.getUsuario() );
	        pstmt.setString(4, app.getAccion());
	        pstmt.setString(5, app.getDni());
	        pstmt.setString(6, app.getCodAgencia() );
	        pstmt.setString(7, app.getNombreAgencia() );
	        // Ejecutar la inserci�n
	        int affectedRows = pstmt.executeUpdate();

	        if (!(affectedRows > 0)) {
	        	throw new SQLException("La inserci�n del log fall�, no se afectaron filas.");
	        } 

	        connection.commit();

	    } catch (SQLException e) {
	        log.error(e, "ERROR AL REGISTRAR EL LOG: " + app.toString());
	        // Manejo de errores y rollback
	        try (Connection connection = dss.connect()) {
	            if (connection != null) {
	                connection.rollback();
	            }
	        } catch (SQLException rollbackEx) {
	            log.error(rollbackEx, "Error al hacer rollback");
	        } catch (Exception e1) {
				// 
				e1.printStackTrace();
			}
	    } catch (Exception e) {
	        log.error(e, "ERROR AL REGISTRAR EL LOG: " + app.toString());
	    }

	    return app;
	}

	
	 

	@Override
	public List<AudiLog> showLog() throws SQLException {

		ResultSet rs = null;
		List<AudiLog> registros = null;	
		Connection conn = null;																		
	 	PreparedStatement pstmt = null;	
	 	StringBuffer sql = new  StringBuffer();
	 	sql.append("SELECT * FROM BNMODCF07_LOG_EECC  ");	 	 
	    // Verificar si el usuario tiene el rol 'ROLE_06'
        boolean rol06 = false;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            if (authority.getAuthority().equals("ROLE_06")) {
            	rol06 = true;
                break;
            }
        }
	 	if (!rol06) {
	 		sql.append("WHERE F07_COD_AGENCIA='"+getAuthenticatedUser().getCodAgencia() +"' ORDER BY  f07_fecha DESC,f07_hora DESC");
		}else{
			sql.append(" ORDER BY  f07_fecha DESC,f07_hora DESC");
		}
	 	try {		
	 		conn =    dss.connect();
	 		conn.setAutoCommit(false);
	 		pstmt= conn.prepareStatement(sql.toString());
	 		AudiLog item = new AudiLog();
	 		registros=new ArrayList<AudiLog>(); 
			rs = pstmt.executeQuery();
			
			while(rs.next()){	
				 item =new AudiLog();				 
				 item.setFecha(formatoFecha(rs.getString(1)));
				 item.setHora(rs.getString(2));
				 item.setUsuario(rs.getString(3));
				 item.setAccion(rs.getString(4));
				 item.setDni(rs.getString(5));	 
				 item.setCodAgencia(rs.getString(6));
				 item.setNombreAgencia(rs.getString(7));	 

				  registros.add(item);    	
		}	
	 	} catch (Exception e) {	
	 		if (conn != null) conn.rollback(); 
	 	}finally {
	 		if (conn != null) conn.setAutoCommit(true);	
	 		if (pstmt != null) {try{pstmt.close();}catch(Exception e){}; pstmt = null; }			
	 		if (conn != null) { try{conn.close();}catch(Exception e){}; conn = null;}				
	 	}	
	return registros;
	}

	private String formatoFecha(String fechaIn) {
		 // Formatear la fecha
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");		
        String formattedDate = "";
        try {
            Date date = inputFormat.parse(fechaIn);
            formattedDate = outputFormat.format(date);
         } catch (ParseException e) {
            e.printStackTrace();
         }return formattedDate;
	}

	@Override
	public List<AudiLog> forDni(String forDni) throws SQLException {

		ResultSet rs = null;
		List<AudiLog> registros = null;	
		Connection conn = null;																		
	 	PreparedStatement pstmt = null;	
	 	StringBuffer sql = new  StringBuffer();
	 	sql.append("SELECT * FROM BNMODCF07_LOG_EECC  WHERE f07_dni ='"+forDni+"'  ");	 	 
	    // Verificar si el usuario tiene el rol 'ROLE_06'
        boolean rol06 = false;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            if (authority.getAuthority().equals("ROLE_06")) {
            	rol06 = true;
                break;
            }
        }
	 	if (!rol06) {
	 		sql.append(" AND F07_COD_AGENCIA='"+getAuthenticatedUser().getCodAgencia() +"' ORDER BY  f07_fecha DESC,f07_hora DESC");
		}else{
			sql.append(" ORDER BY  f07_fecha DESC,f07_hora DESC");
		}
	 	try {		
	 		conn =    dss.connect();
	 		conn.setAutoCommit(false);	
	 		pstmt= conn.prepareStatement(sql.toString());
	 		AudiLog item = new AudiLog();
	 		registros=new ArrayList<AudiLog>(); 
			rs = pstmt.executeQuery();
			
			while(rs.next()){	
				 item =new AudiLog();				 
				 item.setFecha(formatoFecha(rs.getString(1)));
				 item.setHora(rs.getString(2));
				 item.setUsuario(rs.getString(3));
				 item.setAccion(rs.getString(4));
				 item.setDni(rs.getString(5));	 
				 item.setCodAgencia(rs.getString(6));
				 item.setNombreAgencia(rs.getString(7));	 

				  registros.add(item);    	
		}	
	 	} catch (Exception e) {	
	 		if (conn != null) conn.rollback(); 
	 	}finally {
	 		if (conn != null) conn.setAutoCommit(true);	
	 		if (pstmt != null) {try{pstmt.close();}catch(Exception e){}; pstmt = null; }			
	 		if (conn != null) { try{conn.close();}catch(Exception e){}; conn = null;}				
	 	}	
	return registros;
	}

	@Override
	public List<AudiLog> forFechas(String forFechaInicio, String forFechaFin)
			throws SQLException {
		ResultSet rs = null;
		List<AudiLog> registros = null;	
		Connection conn = null;																		
	 	PreparedStatement pstmt = null;	
	 	StringBuffer sql = new  StringBuffer();
	 	sql.append("SELECT * FROM BNMODCF07_LOG_EECC  WHERE f07_fecha BETWEEN  TO_DATE('"+forFechaInicio+"', 'YYYY-MM-DD')  AND  TO_DATE('"+forFechaFin+"', 'YYYY-MM-DD') ");	 	 
	 	
	     // Verificar si el usuario tiene el rol 'ROLE_06'
        boolean rol06 = false;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            if (authority.getAuthority().equals("ROLE_06")) {
            	rol06 = true;
                break;
            }
        }
	 	if (!rol06) {
	 		sql.append(" AND F07_COD_AGENCIA='"+getAuthenticatedUser().getCodAgencia() +"' ORDER BY  f07_fecha DESC,f07_hora DESC");
		}else{
			sql.append(" ORDER BY  f07_fecha DESC,f07_hora DESC");
		}
	 	try {		
	 		conn =    dss.connect();
	 		conn.setAutoCommit(false);	
	 		pstmt= conn.prepareStatement(sql.toString());
	 		AudiLog item = new AudiLog();
	 		registros=new ArrayList<AudiLog>(); 
			rs = pstmt.executeQuery();
			
			while(rs.next()){	
				 item =new AudiLog();				 
				 item.setFecha(formatoFecha(rs.getString(1)));
				 item.setHora(rs.getString(2));
				 item.setUsuario(rs.getString(3));
				 item.setAccion(rs.getString(4));
				 item.setDni(rs.getString(5));	 
				 item.setCodAgencia(rs.getString(6));
				 item.setNombreAgencia(rs.getString(7));	 

				  registros.add(item);    	
		}	
	 	} catch (Exception e) {	
	 		if (conn != null) conn.rollback(); 
	 	}finally {
	 		if (conn != null) conn.setAutoCommit(true);	
	 		if (pstmt != null) {try{pstmt.close();}catch(Exception e){}; pstmt = null; }			
	 		if (conn != null) { try{conn.close();}catch(Exception e){}; conn = null;}				
	 	}	
	return registros;
	}

	@Override
	public List<AudiLog> forDia(String forDia) throws SQLException {
		ResultSet rs = null;
		List<AudiLog> registros = null;	
		Connection conn = null;																		
	 	PreparedStatement pstmt = null;	
	 	StringBuffer sql = new  StringBuffer();
	 	sql.append("SELECT * FROM BNMODCF07_LOG_EECC  WHERE f07_fecha = TO_DATE('"+forDia+"', 'YYYY-MM-DD') ");	 	 
	 	
	    // Verificar si el usuario tiene el rol 'ROLE_06'
        boolean rol06 = false;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        for (GrantedAuthority authority : authentication.getAuthorities()) {
           // TODO Cambiar para pruebas de rol
        	if (authority.getAuthority().equals("ROLE_06")) {
            	rol06 = true;
                break;
            }
        }
	 	if (!rol06) {
	 		sql.append(" AND F07_COD_AGENCIA='"+getAuthenticatedUser().getCodAgencia() +"' ORDER BY  f07_fecha DESC,f07_hora DESC");
		}else{
			sql.append(" ORDER BY  f07_fecha DESC,f07_hora DESC");
		}
	 	try {		
	 		conn =    dss.connect();
	 		conn.setAutoCommit(false);	
	 		pstmt= conn.prepareStatement(sql.toString());
	 		AudiLog item = new AudiLog();
	 		registros=new ArrayList<AudiLog>(); 
			rs = pstmt.executeQuery();
			
			while(rs.next()){	
				 item =new AudiLog();				 
				 item.setFecha(formatoFecha(rs.getString(1)));
				 item.setHora(rs.getString(2));
				 item.setUsuario(rs.getString(3));
				 item.setAccion(rs.getString(4));
				 item.setDni(rs.getString(5));	 
				 item.setCodAgencia(rs.getString(6));
				 item.setNombreAgencia(rs.getString(7));	 

				  registros.add(item);      	
		}	
	 	} catch (Exception e) {	
	 		if (conn != null) conn.rollback(); 
	 	}finally {
	 		if (conn != null) conn.setAutoCommit(true);	
	 		if (pstmt != null) {try{pstmt.close();}catch(Exception e){}; pstmt = null; }			
	 		if (conn != null) { try{conn.close();}catch(Exception e){}; conn = null;}				
	 	}	
	return registros;
	}

	  public CustomUser getAuthenticatedUser() {
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        if (authentication != null && authentication.isAuthenticated() && authentication.getPrincipal() instanceof UserDetails) {
	            return (CustomUser) authentication.getPrincipal();
	        }
	        return null;
	    
	  }

	  
		public String cargaCorreoValidar(BnValidarCorreoOTP valCorreo) throws SQLException {
			
			String sms = "ENVIADO";
			String insertSQL = "INSERT INTO BNMODCF08_CORREO" +
		    		" (F08_TIPO, F08_DOCUMENTO, F08_NOMBRES, F08_CORREO, F08_OTP, F08_FECHAVAL, F08_HORAVAL, F08_USUARIOVAL, F08_CAMPO1, F08_CAMPO2, F08_CAMPO3) " +
		    		"VALUES (?, ?, ?, ?, ?, ?,?,?,?,?,?)";

		    try (Connection connection = dss.connect();
		         PreparedStatement pstmt = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS)) {

		        connection.setAutoCommit(false);
		      	        
		        // Establecer los valores de los par�metros
		        pstmt.setString(1, valCorreo.getTIPDOC() );
		        pstmt.setString(2, valCorreo.getNUMDOC()  );
		        pstmt.setString(3, valCorreo.getNOMBR_APELL() );
		        pstmt.setString(4, valCorreo.getCORREO());
		        pstmt.setString(5, valCorreo.getOTP());
		        pstmt.setString(6, valCorreo.getFECHA() );
		        pstmt.setString(7, valCorreo.getHORA() );
		        pstmt.setString(8, valCorreo.getUSUARIO() );
		        pstmt.setString(9, "" );
		        pstmt.setString(10, "" );
		        pstmt.setString(11, "" );
		        // Ejecutar la inserci�n
		        int affectedRows = pstmt.executeUpdate();

		        if (!(affectedRows > 0)) {
		        	throw new SQLException("La inserci�n del log fall�, no se afectaron filas.");
		        	
		        } 
		        connection.commit();

		    } catch (SQLException e) {
		        log.error(e, "ERROR AL REGISTRAR LOS DATOS DE VALIDACION: " + valCorreo.toString());
		        // Manejo de errores y rollback
		        try (Connection connection = dss.connect()) {
		            if (connection != null) {
		                connection.rollback();
		            }
		        } catch (SQLException rollbackEx) {
		            log.error(rollbackEx, "Error al hacer rollback");
		            sms="Error al hacer rollback";
		            return sms;
		        } catch (Exception e1) {
					// 
					e1.printStackTrace();
				}
		    } catch (Exception e) {
		        log.error(e, "ERROR AL REGISTRAR LOS DATOS DE VALIDACION: " + valCorreo.toString());
		        sms="ERROR AL REGISTRAR LOS DATOS DE VALIDACION";
	            return sms;
		    }

		    return sms;  
	}
		
	
		public String correoValidado(String numero) throws SQLException {
			 //System.out.println("reporlog numerodoc: " + numero); 
		    
			 String correo ="";    
		    ResultSet rs = null;
			Connection conn = null;																		
		 	PreparedStatement pstmt = null;	
		 	StringBuffer sql = new  StringBuffer();
		 	sql.append("SELECT F08_CORREO FROM BNMODCF08_CORREO WHERE F08_DOCUMENTO = '"+numero.trim()+"'");	 	
		    try {
		    		conn =    dss.connect();
			 		conn.setAutoCommit(false);	
			 		pstmt= conn.prepareStatement(sql.toString());		 		
					rs = pstmt.executeQuery();

					if(rs.next()) {
		                 correo = rs.getString("F08_CORREO");
		            }
		        }
		     catch (Exception e) {	
		 		if (conn != null) conn.rollback(); 
		 	}finally {
		 		if (conn != null) conn.setAutoCommit(true);	
		 		if (pstmt != null) {try{pstmt.close();}catch(Exception e){}; pstmt = null; }			
		 		if (conn != null) { try{conn.close();}catch(Exception e){}; conn = null;}				
		 	}	
		    System.out.println("reporlog correo: " + correo); 
		return correo;
		   
		}


		public String cargaDocumentopdf(BnEnviarDoc enviardoc, Date fechasql) {
			String sms = "ENVIADO";
			String insertSQL = "INSERT INTO BNMODCF09_PRESTAMOS_HIS" +
		    		" (B09_NUM_PRESTAO, B09_ARCHIVO, B09_TIPODOC, B09_DOCUMENTO, B09_NOMBRES,B09_CORREO, B09_FECHA_OPER, B09_FECHA_ENVIO, B09_HORA_ENVIO, B09_USUARIO_ENV, B09_AGENCIA, B09_ESTADO,B09_CAMPO1,B09_CAMPO2,B09_CAMPO3) " +
		    		"VALUES (?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,?)";

		    try (Connection connection = dss.connect();
		         PreparedStatement pstmt = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS)) {

		        connection.setAutoCommit(false);
		      	        
		        // Establecer los valores de los par�metros
		        pstmt.setString(1, enviardoc.getNUMPRESTAMO() );
		        pstmt.setBinaryStream(2,new ByteArrayInputStream(enviardoc.getPDF()),enviardoc.getPDF().length);
		        pstmt.setString(3, enviardoc.getTIPDOC());
		        pstmt.setString(4, enviardoc.getNUMDOC());
		        pstmt.setString(5, enviardoc.getNOMBRES().trim());
		        pstmt.setString(6, enviardoc.getCORREO());
		        pstmt.setDate(7, (java.sql.Date) fechasql);
		        pstmt.setString(8, enviardoc.getFECHA());
		        pstmt.setString(9, enviardoc.getHORA());
		        pstmt.setString(10, enviardoc.getUSUARIO());
		        pstmt.setString(11, enviardoc.getAGENCIA());
		        pstmt.setString(12, enviardoc.getESTADO());
		        pstmt.setString(13, "" );
		        pstmt.setString(14, "" );
		        pstmt.setString(15, "" );
		        // Ejecutar la inserci�n
		        int affectedRows = pstmt.executeUpdate();

		        if (!(affectedRows > 0)) {
		        	
		        	throw new SQLException("La inserci�n del log fall�, no se afectaron filas.");
		        	
		        } 
		        connection.commit();

		    } catch (SQLException e) {
		        log.error(e, "ERROR AL REGISTRAR LOS DATOS DE BNSATE09_PRESTAMOS_HIS: " + enviardoc.toString());
		        // Manejo de errores y rollback
		        try (Connection connection = dss.connect()) {
		            if (connection != null) {
		                connection.rollback();
		            }
		        } catch (SQLException rollbackEx) {
		            log.error(rollbackEx, "Error al hacer rollback");
		            sms="Error al hacer rollback";
		            return sms;
		        } catch (Exception e1) {
					// 
					e1.printStackTrace();
				}
		    } catch (Exception e) {
		        log.error(e, "ERROR AL REGISTRAR LOS DATOS BNSATE09_PRESTAMOS_HIS: " + enviardoc.toString());
		        sms="ERROR AL REGISTRAR LOS DATOS BNSATE09_PRESTAMOS_HIS";
	            return sms;
		    }

		    return sms;  
		}
		
		
		public BnEnviarDoc buscardatosReenvio (String numero) throws SQLException {
			 System.out.println("reporlog reenviar numero de prestamo: " + numero); 
			BnEnviarDoc datos = new BnEnviarDoc();
	
		    ResultSet rs = null;
			Connection conn = null;																		
		 	PreparedStatement pstmt = null;	
		 	StringBuffer sql = new  StringBuffer();
		 	sql.append("SELECT B09_NUM_PRESTAO,B09_ARCHIVO, B09_TIPODOC, B09_DOCUMENTO, B09_NOMBRES, B09_CORREO,B09_FECHA_OPER ,B09_FECHA_ENVIO, B09_HORA_ENVIO, B09_USUARIO_ENV,B09_AGENCIA, B09_ESTADO   FROM BNMODCF09_PRESTAMOS_HIS WHERE B09_NUM_PRESTAO = '"+numero.trim()+"'");	 	

		 	try {
		    		conn =    dss.connect();
			 		conn.setAutoCommit(false);	
			 		pstmt= conn.prepareStatement(sql.toString());		 		
					rs = pstmt.executeQuery();

					if(rs.next()) {
						
		                datos.setNUMPRESTAMO(rs.getString("B09_NUM_PRESTAO"));
		                datos.setTIPDOC(rs.getString("B09_TIPODOC"));
		                datos.setNUMDOC(rs.getString("B09_DOCUMENTO"));
		                datos.setNOMBRES(rs.getString("B09_NOMBRES"));
		                datos.setCORREO(rs.getString("B09_CORREO"));
		                datos.setFECHA(rs.getString("B09_FECHA_ENVIO"));
		                datos.setHORA(rs.getString("B09_HORA_ENVIO"));
		                datos.setUSUARIO(rs.getString("B09_USUARIO_ENV"));
		                datos.setAGENCIA(rs.getString("B09_AGENCIA"));
		                datos.setESTADO(rs.getString("B09_ESTADO"));
		                
		                
		                Blob blob = rs.getBlob("B09_ARCHIVO");
		                if (blob != null) {
		                    datos.setPDF(blob.getBytes(1, (int) blob.length()));
		                }         	                 
		            }
		        }
		     catch (Exception e) {	
		 		if (conn != null) conn.rollback(); 
		 	}finally {
		 		if (conn != null) conn.setAutoCommit(true);	
		 		if (pstmt != null) {try{pstmt.close();}catch(Exception e){}; pstmt = null; }			
		 		if (conn != null) { try{conn.close();}catch(Exception e){}; conn = null;}				
		 	}	
		   
		return datos;
		   
		}
		
		public String buscarestado(String numero) throws SQLException {
		    System.out.println("Reporlog buscando el estado de env�o por num prestamo: " + numero);
		    
		    String estado = "";
		    ResultSet rs = null;
		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    StringBuffer sql = new StringBuffer();

		    try {
		        conn = dss.connect();
		        conn.setAutoCommit(false);

		        // Primera b�squeda: Estado "REENVIADO"
		        sql.append("SELECT B09_ESTADO FROM BNMODCF09_PRESTAMOS_HIS ")
		           .append("WHERE B09_NUM_PRESTAO = ? AND B09_ESTADO = 'REENVIADO'");
		        
		        pstmt = conn.prepareStatement(sql.toString());
		        pstmt.setString(1, numero.trim());
		        rs = pstmt.executeQuery();

		        if (rs.next()) {
		            estado = rs.getString("B09_ESTADO");
		        } else {
		           
		            sql.setLength(0); 
		            sql.append("SELECT B09_ESTADO FROM BNMODCF09_PRESTAMOS_HIS ")
		               .append("WHERE B09_NUM_PRESTAO = ? AND B09_ESTADO = 'ENVIADO'");

		            pstmt.close(); 
		            pstmt = conn.prepareStatement(sql.toString());
		            pstmt.setString(1, numero.trim());
		            rs = pstmt.executeQuery();

		            if (rs.next()) {
		                estado = rs.getString("B09_ESTADO");
		            }
		        }

		        conn.commit(); // Confirmar transacci�n

		    } catch (Exception e) {
		        if (conn != null) conn.rollback();
		        e.printStackTrace(); // Imprimir error en consola para depuraci�n
		    } finally {
		        if (conn != null) conn.setAutoCommit(true);
		        if (rs != null) { try { rs.close(); } catch (Exception e) {} }
		        if (pstmt != null) { try { pstmt.close(); } catch (Exception e) {} }
		        if (conn != null) { try { conn.close(); } catch (Exception e) {} }
		    }

		    return estado;
		}

		
		public String buscarfechaEnvio (String numero) throws SQLException {
			 System.out.println("reporlog buscar la fecha del envio por num prestamo: " + numero); 
			String fechaenvio = "";
		    ResultSet rs = null;
			Connection conn = null;																		
		 	PreparedStatement pstmt = null;	
		 	StringBuffer sql = new  StringBuffer();
		 	sql.append("SELECT B09_FECHA_ENVIO FROM BNMODCF09_PRESTAMOS_HIS WHERE B09_NUM_PRESTAO = '")
		    .append(numero.trim())
		    .append("' AND B09_ESTADO = 'ENVIADO'");
		 	try {
		    		conn =    dss.connect();
			 		conn.setAutoCommit(false);	
			 		pstmt= conn.prepareStatement(sql.toString());		 		
					rs = pstmt.executeQuery();

					if(rs.next()) {
						
						fechaenvio = rs.getString("B09_FECHA_ENVIO"); 	                 
		            }
		        }
		     catch (Exception e) {	
		 		if (conn != null) conn.rollback(); 
		 	}finally {
		 		if (conn != null) conn.setAutoCommit(true);	
		 		if (pstmt != null) {try{pstmt.close();}catch(Exception e){}; pstmt = null; }			
		 		if (conn != null) { try{conn.close();}catch(Exception e){}; conn = null;}				
		 	}	
		   
		return fechaenvio;
		   
		}


		public String cargarAuditoriaPM(BnAuditoriaPM au) {
			String sms = "INSERT INTO BNMODCF10_LOGPM ";
			String insertSQL = "INSERT INTO BNMODCF10_LOGPM" +
		    		" (F10_PRESTAMO, F10_FECHA, F10_CUSUARIO, F10_COFICINA, F10_CLIENTE,F10_TIPO, F10_NUMEOR, F10_CELULAR, F10_CORREO, F10_SITUACION, F10_ACCION) " +
		    		"VALUES (?, ?, ?, ?, ?, ?,?,?,?,?,?)";

		    try (Connection connection = dss.connect();
		         PreparedStatement pstmt = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS)) {

		        connection.setAutoCommit(false);
		      	        
		        // Establecer los valores de los par�metros
		        pstmt.setString(1,au.getPrestamo().trim());
		        pstmt.setString(2,au.getFecha().trim());
		        pstmt.setString(3, au.getCusuario());
		        pstmt.setString(4, au.getCoficina());
		        pstmt.setString(5, au.getCliente().trim());
		        pstmt.setString(6, au.getTipodoc().trim());
		        pstmt.setString(7, au.getNumerodoc().trim());
		        pstmt.setString(8, au.getCelular().trim());
		        pstmt.setString(9, au.getCorreo().trim());
		        pstmt.setString(10,au.getSit_envio());
		        pstmt.setString(11,au.getAccion());
		     
		        // Ejecutar la inserci�n
		        int affectedRows = pstmt.executeUpdate();

		        if (!(affectedRows > 0)) {
		        	
		        	throw new SQLException("La inserci�n del log fall�, no se afectaron filas.");
		        	
		        } 
		        connection.commit();

		    } catch (SQLException e) {
		        log.error(e, "ERROR AL REGISTRAR LOS DATOS DE BNMODCF10_LOGPM: ");
		        // Manejo de errores y rollback
		        try (Connection connection = dss.connect()) {
		            if (connection != null) {
		                connection.rollback();
		            }
		        } catch (SQLException rollbackEx) {
		        	sms ="Error al hacer rollback";
		            log.error(rollbackEx, "Error al hacer rollback");
		           
		           
		        } catch (Exception e1) {
					// 
					e1.printStackTrace();
				}
		    } catch (Exception e) {
		    	sms = "ERROR AL REGISTRAR LOS DATOS BNMODCF10_LOGPM ";
		        log.error(e, "ERROR AL REGISTRAR LOS DATOS BNMODCF10_LOGPM: ");
		      
	            
		    }

		   return sms;
			
		}
		
		
		public List<BnLogAuditoriaPM> forFechasPM1(String forFechaInicio, String forFechaFin) throws SQLException {

			ResultSet rs = null;
			List<BnLogAuditoriaPM> registros = null;	
			Connection conn = null;																		
		 	PreparedStatement pstmt = null;	
		 	StringBuffer sql = new  StringBuffer();
		 	sql.append("SELECT F10_PRESTAMO, F10_FECHA, F10_CUSUARIO, F10_COFICINA, F10_CLIENTE, F10_TIPO, F10_NUMEOR, F10_CELULAR, F10_CORREO, F10_SITUACION, F10_ACCION " 
		 				+ "FROM BNMODCF10_LOGPM" + 
		 				"WHERE TO_DATE(F10_FECHA, 'YYYY-MM-DD')" + 
		 				"      BETWEEN TO_DATE( '"+forFechaInicio+"', 'YYYY-MM-DD')" + 
		 				"      AND TO_DATE('"+forFechaFin+"', 'YYYY-MM-DD')");	 	 
		    // Verificar si el usuario tiene el rol 'ROLE_06'
	        boolean rol06 = false;
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        for (GrantedAuthority authority : authentication.getAuthorities()) {
	            if (authority.getAuthority().equals("ROLE_06")) {
	            	rol06 = true;
	                break;
	            }
	        }
		 	if (!rol06) {
		 		sql.append(" AND F10_COFICINA='"+getAuthenticatedUser().getCodAgencia() +"' ORDER BY  F10_FECHA DESC");
			}else{
				sql.append(" ORDER BY  F10_FECHA DESC");
			}
		 	try {		
		 		conn =    dss.connect();
		 		conn.setAutoCommit(false);	
		 		pstmt= conn.prepareStatement(sql.toString());
		 		BnLogAuditoriaPM pm = new BnLogAuditoriaPM();
		 		registros=new ArrayList<BnLogAuditoriaPM>(); 
				rs = pstmt.executeQuery();
				
				while(rs.next()){	
					pm =new BnLogAuditoriaPM();				 
					//pm.setFecha(formatoFecha(rs.getString(1)));
					pm.setPrestamo(rs.getString("F10_PRESTAMO"));
					pm.setFecha(rs.getString("F10_FECHA"));
					pm.setCusuario(rs.getString("F10_CUSUARIO"));
					pm.setCoficina(rs.getString("F10_COFICINA"));	 
					pm.setCliente(rs.getString("F10_CLIENTE"));
					String tipo = rs.getString("F10_TIPO").trim();
					if (tipo == "1") {
						pm.setDoi("DNI - " +rs.getString("F10_NUMEOR"));
						
					} else {
						pm.setDoi("CE - " +rs.getString("F10_NUMEOR"));
					}
					
					pm.setCelular(rs.getString("F10_CELULAR"));
					pm.setCorreo(rs.getString("F10_CORREO"));	 
					pm.setSit_envio(rs.getString("F10_SITUACION"));
					pm.setAccion(rs.getString("F10_ACCION"));

					  registros.add(pm);    	
			}	
		 	} catch (Exception e) {	
		 		if (conn != null) conn.rollback(); 
		 	}finally {
		 		if (conn != null) conn.setAutoCommit(true);	
		 		if (pstmt != null) {try{pstmt.close();}catch(Exception e){}; pstmt = null; }			
		 		if (conn != null) { try{conn.close();}catch(Exception e){}; conn = null;}				
		 	}	
		return registros;
		}

		public List<BnLogAuditoriaPM> forDniPM(String forDni) throws SQLException {

			ResultSet rs = null;
			List<BnLogAuditoriaPM> registros = null;	
			Connection conn = null;																		
		 	PreparedStatement pstmt = null;	
		 	StringBuffer sql = new  StringBuffer();
		 	sql.append("SELECT F10_PRESTAMO, F10_FECHA, F10_CUSUARIO, F10_COFICINA, F10_CLIENTE, F10_TIPO, F10_NUMEOR, F10_CELULAR, F10_CORREO, F10_SITUACION, F10_ACCION " 
		 				+ "FROM BNMODCF10_LOGPM WHERE F10_NUMEOR ='"+forDni+"'");	 	 
		    // Verificar si el usuario tiene el rol 'ROLE_06'
	        boolean rol06 = false;
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        for (GrantedAuthority authority : authentication.getAuthorities()) {
	            if (authority.getAuthority().equals("ROLE_06")) {
	            	rol06 = true;
	                break;
	            }
	        }
		 	if (!rol06) {
		 		sql.append(" AND F10_COFICINA='"+getAuthenticatedUser().getCodAgencia() +"' ORDER BY  F10_FECHA DESC");
			}else{
				sql.append(" ORDER BY  F10_FECHA DESC");
			}
		 	try {		
		 		conn =    dss.connect();
		 		conn.setAutoCommit(false);	
		 		pstmt= conn.prepareStatement(sql.toString());
		 		BnLogAuditoriaPM pm = new BnLogAuditoriaPM();
		 		registros=new ArrayList<BnLogAuditoriaPM>(); 
				rs = pstmt.executeQuery();
				
				while(rs.next()){	
					pm =new BnLogAuditoriaPM();				 
					//pm.setFecha(formatoFecha(rs.getString(1)));
					pm.setPrestamo(rs.getString("F10_PRESTAMO"));
					pm.setFecha(rs.getString("F10_FECHA"));
					pm.setCusuario(rs.getString("F10_CUSUARIO"));
					pm.setCoficina(rs.getString("F10_COFICINA"));	 
					pm.setCliente(rs.getString("F10_CLIENTE"));
					String tipo = rs.getString("F10_TIPO").trim();
					if (tipo.equals("1")) {
						pm.setDoi("DNI - " +rs.getString("F10_NUMEOR"));
						
					} else {
						pm.setDoi("CE - " +rs.getString("F10_NUMEOR"));
					}
					
					pm.setCelular(rs.getString("F10_CELULAR"));
					pm.setCorreo(rs.getString("F10_CORREO"));	 
					pm.setSit_envio(rs.getString("F10_SITUACION"));
					pm.setAccion(rs.getString("F10_ACCION"));

					  registros.add(pm);    	
			}	
		 	} catch (Exception e) {	
		 		if (conn != null) conn.rollback(); 
		 	}finally {
		 		if (conn != null) conn.setAutoCommit(true);	
		 		if (pstmt != null) {try{pstmt.close();}catch(Exception e){}; pstmt = null; }			
		 		if (conn != null) { try{conn.close();}catch(Exception e){}; conn = null;}				
		 	}	
		return registros;
		}


		public List<BnLogAuditoriaPM> forFechasPM(String forFechaInicio, String forFechaFin) throws SQLException {
			ResultSet rs = null;
			List<BnLogAuditoriaPM> registros = null;	
			Connection conn = null;																		
		 	PreparedStatement pstmt = null;	
		 	StringBuffer sql = new  StringBuffer();
		 	sql.append("SELECT F10_PRESTAMO, F10_FECHA, F10_CUSUARIO, F10_COFICINA, F10_CLIENTE, F10_TIPO, F10_NUMEOR, F10_CELULAR, F10_CORREO, F10_SITUACION, F10_ACCION " 
		 				+ "FROM BNMODCF10_LOGPM " + 
		 				"WHERE TO_DATE(F10_FECHA, 'YYYY-MM-DD')" + 
		 				"      BETWEEN TO_DATE( '"+forFechaInicio+"', 'YYYY-MM-DD')" + 
		 				"      AND TO_DATE('"+forFechaFin+"', 'YYYY-MM-DD')");	 	 
		    // Verificar si el usuario tiene el rol 'ROLE_06'
	        boolean rol06 = false;
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        for (GrantedAuthority authority : authentication.getAuthorities()) {
	            if (authority.getAuthority().equals("ROLE_06")) {
	            	rol06 = true;
	                break;
	            }
	        }
		 	if (!rol06) {
		 		sql.append(" AND F10_COFICINA='"+getAuthenticatedUser().getCodAgencia() +"' ORDER BY  F10_FECHA DESC");
			}else{
				sql.append(" ORDER BY  F10_FECHA DESC");
			}
		 	try {		
		 		conn =    dss.connect();
		 		conn.setAutoCommit(false);	
		 		pstmt= conn.prepareStatement(sql.toString());
		 		BnLogAuditoriaPM pm = new BnLogAuditoriaPM();
		 		registros=new ArrayList<BnLogAuditoriaPM>(); 
				rs = pstmt.executeQuery();
				
				while(rs.next()){	
					pm =new BnLogAuditoriaPM();				 
					//pm.setFecha(formatoFecha(rs.getString(1)));
					pm.setPrestamo(rs.getString("F10_PRESTAMO"));
					pm.setFecha(rs.getString("F10_FECHA"));
					pm.setCusuario(rs.getString("F10_CUSUARIO"));
					pm.setCoficina(rs.getString("F10_COFICINA"));	 
					pm.setCliente(rs.getString("F10_CLIENTE"));
					String tipo = rs.getString("F10_TIPO").trim();
					if (tipo.equals("1")) {
						pm.setDoi("DNI - " +rs.getString("F10_NUMEOR"));
						
					} else {
						pm.setDoi("CE - " +rs.getString("F10_NUMEOR"));
					}
					
					pm.setCelular(rs.getString("F10_CELULAR"));
					pm.setCorreo(rs.getString("F10_CORREO"));	 
					pm.setSit_envio(rs.getString("F10_SITUACION"));
					pm.setAccion(rs.getString("F10_ACCION"));

					  registros.add(pm);    	
			}	
		 	} catch (Exception e) {	
		 		if (conn != null) conn.rollback(); 
		 	}finally {
		 		if (conn != null) conn.setAutoCommit(true);	
		 		if (pstmt != null) {try{pstmt.close();}catch(Exception e){}; pstmt = null; }			
		 		if (conn != null) { try{conn.close();}catch(Exception e){}; conn = null;}				
		 	}	
		return registros;
		}


		public List<BnLogAuditoriaPM> forDiaPM(String forDia) throws SQLException {
			ResultSet rs = null;
			List<BnLogAuditoriaPM> registros = null;	
			Connection conn = null;																		
		 	PreparedStatement pstmt = null;	
		 	StringBuffer sql = new  StringBuffer();
		 	sql.append("SELECT F10_PRESTAMO, F10_FECHA, F10_CUSUARIO, F10_COFICINA, F10_CLIENTE, F10_TIPO, F10_NUMEOR, F10_CELULAR, F10_CORREO, F10_SITUACION, F10_ACCION " 
		 				+ "FROM BNMODCF10_LOGPM WHERE TO_DATE(F10_FECHA, 'YYYY-MM-DD') = TO_DATE( '"+forDia+"', 'YYYY-MM-DD')");	 	 
		    // Verificar si el usuario tiene el rol 'ROLE_06'
	        boolean rol06 = false;
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        for (GrantedAuthority authority : authentication.getAuthorities()) {
	            if (authority.getAuthority().equals("ROLE_06")) {
	            	rol06 = true;
	                break;
	            }
	        }
		 	if (!rol06) {
		 		sql.append(" AND F10_COFICINA='"+getAuthenticatedUser().getCodAgencia() +"' ORDER BY  F10_FECHA DESC");
			}else{
				sql.append(" ORDER BY  F10_FECHA DESC");
			}
		 	try {		
		 		conn =    dss.connect();
		 		conn.setAutoCommit(false);	
		 		pstmt= conn.prepareStatement(sql.toString());
		 		BnLogAuditoriaPM pm = new BnLogAuditoriaPM();
		 		registros=new ArrayList<BnLogAuditoriaPM>(); 
				rs = pstmt.executeQuery();
				
				while(rs.next()){	
					pm =new BnLogAuditoriaPM();				 
					//pm.setFecha(formatoFecha(rs.getString(1)));
					pm.setPrestamo(rs.getString("F10_PRESTAMO"));
					pm.setFecha(rs.getString("F10_FECHA"));
					pm.setCusuario(rs.getString("F10_CUSUARIO"));
					pm.setCoficina(rs.getString("F10_COFICINA"));	 
					pm.setCliente(rs.getString("F10_CLIENTE"));
					String tipo = rs.getString("F10_TIPO").trim();
					if (tipo.equals("1")) {
						pm.setDoi("DNI - " +rs.getString("F10_NUMEOR"));
						
					} else {
						pm.setDoi("CE - " +rs.getString("F10_NUMEOR"));
					}
					
					//pm.setCelular(rs.getString("F10_CELULAR"));
					pm.setCorreo(rs.getString("F10_CORREO"));	 
					pm.setSit_envio(rs.getString("F10_SITUACION"));
					pm.setAccion(rs.getString("F10_ACCION"));

					  registros.add(pm);    	
			}	
		 	} catch (Exception e) {	
		 		if (conn != null) conn.rollback(); 
		 	}finally {
		 		if (conn != null) conn.setAutoCommit(true);	
		 		if (pstmt != null) {try{pstmt.close();}catch(Exception e){}; pstmt = null; }			
		 		if (conn != null) { try{conn.close();}catch(Exception e){}; conn = null;}				
		 	}	
		return registros;
		}


		public List<BnLogAuditoriaPM> showLogPM()  throws SQLException {
			ResultSet rs = null;
			List<BnLogAuditoriaPM> registros = null;	
			Connection conn = null;																		
		 	PreparedStatement pstmt = null;	
		 	StringBuffer sql = new  StringBuffer();
		 	sql.append("SELECT F10_PRESTAMO, F10_FECHA, F10_CUSUARIO, F10_COFICINA, F10_CLIENTE, F10_TIPO, F10_NUMEOR, F10_CELULAR, F10_CORREO, F10_SITUACION, F10_ACCION " 
		 				+ " FROM BNMODCF10_LOGPM");	 	 
		    // Verificar si el usuario tiene el rol 'ROLE_06'
	        boolean rol06 = false;
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        for (GrantedAuthority authority : authentication.getAuthorities()) {
	            if (authority.getAuthority().equals("ROLE_06")) {
	            	rol06 = true;
	                break;
	            }
	        }
		 	if (!rol06) {
		 		sql.append(" AND F10_COFICINA='"+getAuthenticatedUser().getCodAgencia() +"' ORDER BY  F10_FECHA DESC");
			}else{
				sql.append(" ORDER BY  F10_FECHA DESC");
			}
		 	try {		
		 		conn =    dss.connect();
		 		conn.setAutoCommit(false);	
		 		pstmt= conn.prepareStatement(sql.toString());
		 		BnLogAuditoriaPM pm = new BnLogAuditoriaPM();
		 		registros=new ArrayList<BnLogAuditoriaPM>(); 
				rs = pstmt.executeQuery();
				
				while(rs.next()){	
					pm =new BnLogAuditoriaPM();				 
					//pm.setFecha(formatoFecha(rs.getString(1)));
					pm.setPrestamo(rs.getString("F10_PRESTAMO"));
					pm.setFecha(rs.getString("F10_FECHA"));
					pm.setCusuario(rs.getString("F10_CUSUARIO"));
					pm.setCoficina(rs.getString("F10_COFICINA"));	 
					pm.setCliente(rs.getString("F10_CLIENTE"));
					String tipo = rs.getString("F10_TIPO").trim();
					if (tipo.equals("1")) {
						pm.setDoi("DNI - " +rs.getString("F10_NUMEOR"));
						
					} else {
						pm.setDoi("CE - " +rs.getString("F10_NUMEOR"));
					}
					
					//pm.setCelular(rs.getString("F10_CELULAR"));
					pm.setCorreo(rs.getString("F10_CORREO"));	 
					pm.setSit_envio(rs.getString("F10_SITUACION"));
					pm.setAccion(rs.getString("F10_ACCION"));

					  registros.add(pm);    	
			}	
		 	} catch (Exception e) {	
		 		if (conn != null) conn.rollback(); 
		 	}finally {
		 		if (conn != null) conn.setAutoCommit(true);	
		 		if (pstmt != null) {try{pstmt.close();}catch(Exception e){}; pstmt = null; }			
		 		if (conn != null) { try{conn.close();}catch(Exception e){}; conn = null;}				
		 	}	
		return registros;
		}


		public String buscaragencias(String num) throws SQLException {
			 System.out.println("reporlog buscar la agencia del primer envio por num prestamo: " + num); 
				String agencia = "";
			    ResultSet rs = null;
				Connection conn = null;																		
			 	PreparedStatement pstmt = null;	
			 	StringBuffer sql = new  StringBuffer();
			 	sql.append("SELECT B09_AGENCIA FROM BNMODCF09_PRESTAMOS_HIS WHERE B09_NUM_PRESTAO = '")
			    .append(num.trim())
			    .append("' AND B09_ESTADO = 'ENVIADO'");
			 	try {
			    		conn =    dss.connect();
				 		conn.setAutoCommit(false);	
				 		pstmt= conn.prepareStatement(sql.toString());		 		
						rs = pstmt.executeQuery();

						if(rs.next()) {
							
							agencia = rs.getString("B09_AGENCIA"); 	                 
			            }
			        }
			     catch (Exception e) {	
			 		if (conn != null) conn.rollback(); 
			 	}finally {
			 		if (conn != null) conn.setAutoCommit(true);	
			 		if (pstmt != null) {try{pstmt.close();}catch(Exception e){}; pstmt = null; }			
			 		if (conn != null) { try{conn.close();}catch(Exception e){}; conn = null;}				
			 	}	
			   
			return agencia;
		}

		
		
}
