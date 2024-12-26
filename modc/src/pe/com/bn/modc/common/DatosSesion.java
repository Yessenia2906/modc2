package pe.com.bn.modc.common;

import java.util.List;

 

public class DatosSesion {

	
	private String codUsuario;	
	private String codAgencia;
	private String desAgencia;
	private String codEmpleado;
	private String nombres;
	private String clave;
	private String ubidacion;
	private String numero;
	public String codigoHost;
	
	
	public String getCodigoHost() {
		return codigoHost;
	}
	public void setCodigoHost(String codigoHost) {
		this.codigoHost = codigoHost;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public List<String> permisos;
	
	public String getDesAgencia() {
		return desAgencia;
	}
	public void setDesAgencia(String desAgencia) {
		this.desAgencia = desAgencia;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}
	public String getCodAgencia() {
		return codAgencia;
	}
	public void setCodAgencia(String codAgencia) {
		this.codAgencia = codAgencia;
	}
	public String getCodEmpleado() {
		return codEmpleado;
	}
	public void setCodEmpleado(String codEmpleado) {
		this.codEmpleado = codEmpleado;
	}
	public List<String> getPermisos() {
		return permisos;
	}
	public void setPermisos(List<String> permisos) {
		this.permisos = permisos;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getUbidacion() {
		return ubidacion;
	}
	public void setUbidacion(String ubidacion) {
		this.ubidacion = ubidacion;
	}

	
	
	
	
	
	
	
	
	 
	
}
