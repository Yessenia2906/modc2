package pe.com.bn.modc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

 
import pe.com.bn.modc.common.Constante;
import pe.com.bn.modc.dao.inte.EstadosCuentaDAO;
import pe.com.bn.modc.dao.pool.ConexionJndi;
import pe.com.bn.modc.exceptions.PersistenciaException;
import pe.com.bn.modc.model.EstadoCuentaPdf;

@Service
public class ConsultaEstadosCuenta implements EstadosCuentaDAO{

	ConexionJndi dss = new ConexionJndi();
	static Connection conn = null;

	@Override
	public List<EstadoCuentaPdf> getEstadosName(
			String fechaCorteInicial, String fechaCorteFin, String dniCliente) throws PersistenciaException
			  {

		List<EstadoCuentaPdf> estadosConsultarPdf = new ArrayList<EstadoCuentaPdf>();
		List<EstadoCuentaPdf> listaSinDuplicados = new ArrayList<EstadoCuentaPdf>();
 		String sql = null;
 
		String mesInicio = fechaCorteInicial.substring(4, 6);
		String AgeInicio = fechaCorteInicial.substring(0, 4);
 
		String mesFin = fechaCorteFin.substring(4, 6);
		String AgeFin = fechaCorteFin.substring(0, 4);
		if (AgeInicio.equals(AgeFin)) {
			sql = "SELECT * FROM BNMODCf06_ESTADOS_CUENTA_PATH WHERE f06_dni  = '"
					+ dniCliente
					+ "' AND f06_age = '"
					+ AgeInicio
					+ "' AND f06_mes >= '"
					+ mesInicio
					+ "' AND f06_mes <= '"
					+ mesFin + "' order by f06_age ASC, f06_mes ASC ";

		} else {
			sql = "SELECT * FROM BNMODCf06_ESTADOS_CUENTA_PATH WHERE f06_dni  = '"
					+ dniCliente
					+ "' AND ((f06_age = '"
					+ AgeInicio
					+ "' AND f06_mes >= '"
					+ mesInicio
					+ "') OR (f06_age = '"
					+ AgeFin
					+ "' AND f06_mes <= '"
					+ mesFin
					+ "')) order by f06_age ASC, f06_mes ASC";

		}

 
  
			Statement statement = null;
			try {
				statement = ConexionJndi.getInstance().connect() .createStatement();
			} catch (Exception e) {
 				throw new PersistenciaException(Constante.CT_ERR_BD,e);
			
			}

			ResultSet rsResultSet = null;
			try {
				rsResultSet = statement.executeQuery(sql);
			} catch (SQLException e) {
 				throw new PersistenciaException(Constante.CT_ERR_BD,e);
			}

			try {
				while (rsResultSet.next()) {
					EstadoCuentaPdf estadoCuenta = new EstadoCuentaPdf();
					estadoCuenta.setDni(rsResultSet.getString("f06_DNI"));
					estadoCuenta.setFecha((rsResultSet.getString("f06_AGE")
							+ rsResultSet.getString("f06_MES") + rsResultSet
							.getString("f06_DIA")));
					estadoCuenta.setAge(rsResultSet.getString("f06_AGE"));

					estadoCuenta.setMes(rsResultSet.getString("f06_MES"));
					estadoCuenta.setDia(rsResultSet.getString("f06_DIA"));
					estadoCuenta.setNombrearchivo(rsResultSet
							.getString("f06_NOMBREARCHIVO"));
					estadoCuenta.setTipo(rsResultSet.getString("f06_TIPO"));
					estadoCuenta.setRuta(rsResultSet.getString("f06_RUTA"));
					estadosConsultarPdf.add(estadoCuenta);

				}
			} catch (SQLException e) {
 				throw new PersistenciaException("Problemas en la recepcion de los datos",e);
				}

	 
			for (EstadoCuentaPdf objeto : estadosConsultarPdf) {
				boolean encontrado = false;
				for (EstadoCuentaPdf objetoExistente : listaSinDuplicados) {
					if (objeto.getFecha().equals(objetoExistente.getFecha())) {
						encontrado = true;
						break;
					}
				}
				if (!encontrado) {
					listaSinDuplicados.add(objeto);
				}
			}

		

		return listaSinDuplicados;
	}


}
