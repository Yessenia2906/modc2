package pe.com.bn.modc.dao.impl;

 
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
        // Tareas de inicialización que deseas ejecutar después de la construcción del bean
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
	        // Establecer los valores de los parámetros
	        pstmt.setString(1, app.getFecha() );
	        pstmt.setString(2,	app.getHora()  );
	        pstmt.setString(3, app.getUsuario() );
	        pstmt.setString(4, app.getAccion());
	        pstmt.setString(5, app.getDni());
	        pstmt.setString(6, app.getCodAgencia() );
	        pstmt.setString(7, app.getNombreAgencia() );
	        // Ejecutar la inserción
	        int affectedRows = pstmt.executeUpdate();

	        if (!(affectedRows > 0)) {
	        	throw new SQLException("La inserción del log falló, no se afectaron filas.");
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

}
