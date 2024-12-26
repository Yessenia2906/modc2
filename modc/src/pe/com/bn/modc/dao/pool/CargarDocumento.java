package pe.com.bn.modc.dao.pool;

import pe.com.bn.modc.dao.impl.CargarDocumentoImpl;

public class CargarDocumento {
	
	public String tarjetaSolicitud(String dni, String tipo, byte[] a, String mail, String fechaEnv, String horaEnv, String fechaLec,
			String horaLec, String ipLec, String estado, String campo1, String campo2) throws Exception{
		String resultado = "";
		
		
		CargarDocumentoImpl solicitud = new CargarDocumentoImpl ();
		resultado = solicitud.cargaTarjetaSolicitud( dni,  tipo, a,  mail,  fechaEnv,  horaEnv,  fechaLec,
				 horaLec,  ipLec,  estado,  campo1,  campo2);
		
		return resultado;
			
		}
	
	
	
	//ACTUALIZA FECHA DE ENVIO CORREO
	
	public String prestamoActualiza(String fechaEnv,String horaEnv, String desembolso) throws Exception{
		String resultado = "";
		
		
		CargarDocumentoImpl prestamo = new CargarDocumentoImpl ();
		resultado = prestamo.actualizaPrestamoEnvio(fechaEnv,horaEnv, desembolso);
		
		return resultado;
			
		}
	
	public String prestamo(String desembolso, String tipo, byte[] a, String mail, String fechaEnv, String horaEnv, String fechaLec,
			String horaLec, String ipLec, String estado, String campo1, String campo2, String nombres, String age, String usuario, String ope) throws Exception{
		String resultado = "";
		
		
		CargarDocumentoImpl prestamo = new CargarDocumentoImpl ();
		resultado = prestamo.cargaPrestamo( desembolso,  tipo, a,  mail,  fechaEnv,  horaEnv,  fechaLec,
				 horaLec,  ipLec,  estado,  campo1,  campo2, nombres, age, usuario, ope);
		
		return resultado;
			
		}
	
	public String prestamoCronograma(String desembolso, String tipo, byte[] a, String mail, String fechaEnv, String horaEnv, String fechaLec,
			String horaLec, String ipLec, String estado,String usuario,  String campo1, String campo2) throws Exception{
		String resultado = "";
		
		
		CargarDocumentoImpl prestamo = new CargarDocumentoImpl ();
		resultado = prestamo.cargaPrestamoCronograma( desembolso,  tipo, a,  mail,  fechaEnv,  horaEnv,  fechaLec,
				 horaLec,  ipLec,  estado,usuario,   campo1,  campo2);
		
		return resultado;
			
		}
	
	//actualiza documento generado
	
	public String prestamoActualizaDoc(String nro_prestamo, byte[] ba,
			String  correo, String fecha, String hora,  String campo1,String campo2, String nombres, String agencia, String usuario,
			String operacion) throws Exception{
		String resultado = "";
		
		
		CargarDocumentoImpl prestamo = new CargarDocumentoImpl ();
		resultado = prestamo.prestamoActualizaDoc( nro_prestamo,  ba, correo, fecha, hora,  campo1, campo2, nombres, agencia,
				usuario, operacion);
		
		return resultado;
			
		}
	
	public String tarjetaSolicitudConsulta(String dni) throws Exception{
		String resultado = "";
		
		
		CargarDocumentoImpl solicitud = new CargarDocumentoImpl ();
		resultado = solicitud.cargaTarjetaSolicitudConsulta( dni);
		
		return resultado;
			
		}

	public String prestamoConsulta(String desembolso) throws Exception{
		String resultado = "";
		
		
		CargarDocumentoImpl prestamo = new CargarDocumentoImpl ();
		resultado = prestamo.prestamoConsulta(desembolso);
		
		return resultado;
			
		}
	
	
	public String consultaOperacion(String desembolso) throws Exception{
		String resultado = "";
		
		
		CargarDocumentoImpl prestamo = new CargarDocumentoImpl ();
		resultado = prestamo.prestamoConsultaGuardo(desembolso);
		
		return resultado;
			
		}
	
	
	public String prestamoConsultaGuardo(String desembolso) throws Exception{
		String resultado = "";
		
		
		CargarDocumentoImpl prestamo = new CargarDocumentoImpl ();
		resultado = prestamo.prestamoConsultaGuardo(desembolso);
		
		return resultado;
			
		}
	
	
	public String prestamoConsultaCronograma(String desembolso) throws Exception{
		String resultado = "";
		
		
		CargarDocumentoImpl prestamo = new CargarDocumentoImpl ();
		resultado = prestamo.prestamoConsultaCronograma(desembolso);
		
		return resultado;
			
		}
	
}
