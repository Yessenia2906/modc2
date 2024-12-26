package pe.com.bn.modc.dao.inte;

import java.sql.SQLException;
import java.util.List;

import pe.com.bn.modc.config.CustomUser;
import pe.com.bn.modc.model.AudiLog;

public interface IntLogAuditoria {

	public AudiLog saveAudiLog(CustomUser usuario,AudiLog audilog); 
	
	public List<AudiLog> showLog() throws SQLException;
	
	public List<AudiLog> forDni(String forDni) throws SQLException;
	
	public List<AudiLog> forFechas(String forFechaInicio, String forFechaFin) throws SQLException;
	
	public List<AudiLog> forDia(String forDia) throws SQLException;
	
 }
