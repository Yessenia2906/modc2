package pe.com.bn.modc.dao.inte;

import java.sql.SQLException;
import java.util.List;

import pe.com.bn.modc.config.CustomUser;
import pe.com.bn.modc.domain.mapper.BnAuditoriaPM;



public interface LogAuditoriaPM {
	
	//public List<AudiLog> showLog() throws SQLException;
	
	public List<BnAuditoriaPM> forDniPM(String forDni) throws SQLException;
	
	//public List<AudiLog> forFechas(String forFechaInicio, String forFechaFin) throws SQLException;
	
	//public List<AudiLog> forDia(String forDia) throws SQLException;
	
 }
