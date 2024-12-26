
package pe.com.bn.modc.dao.pool;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.sql.DataSource;


public class ConexionJndi {

	public Connection connect() throws SQLException,Exception	{

		Connection conetion   = null;
		 try {
			 
			 ResourceBundle rb = ResourceBundle.getBundle("parametro");
	         String jdni = rb.getString("database.jndiname.modc");


			conetion = getDinamicConection(jdni);
		 	conetion.setAutoCommit(false);
		 }catch(SQLException e) {
			  
		      	throw e;
		      }catch(Exception e) {
		      	throw e;
		  }
		  return conetion;
	}
	
	private Connection getDinamicConection(String jdni) throws SQLException,Exception	{
		Connection conetion   = null;
		 try {
		 	
		 	Context ic  = new javax.naming.InitialContext();
		 	DataSource dataSource = (javax.sql.DataSource)ic.lookup(jdni); 
		 	
		 	conetion   = dataSource.getConnection();
		 	
		      }catch(SQLException e) {
		      	throw e;
		      }catch(Exception e) {
		      	throw e;
		  }
		  return conetion;
	}

	
	private Connection connection;
	private static ConexionJndi conexionOracle;
	
	public static ConexionJndi getInstance() {
		
		if (conexionOracle == null) {
			conexionOracle = new ConexionJndi();
		}
		
		return conexionOracle;
    }







	public Connection getConnection() {
	
	try {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
//		String urlConexion = "jdbc:oracle:thin:@//" + credentials.getDireccionIPOracle() + ":" + credentials.getPuertoOracle() + "/" + credentials.getNombreServicioOracle();
		 ResourceBundle rb = ResourceBundle.getBundle("parametro");
         String jdni = rb.getString("database.jndiname.modc");
		this.connection =  getDinamicConection(jdni);;
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
		//log.error("createConnection: connection error ", e);
	}
	
	return this.connection;
}

public void cerrarConexion() {
		
		if (this.connection != null) {
			
			try {
				this.connection.close();
			} catch (SQLException e) {

				System.out.println(e.getMessage());
				//log.error("Error cerrarConexion: ", e);
			}
		}
	}

}

