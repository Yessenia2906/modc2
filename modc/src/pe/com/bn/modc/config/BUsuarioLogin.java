package pe.com.bn.modc.config;

import java.util.List;

public class BUsuarioLogin {

	private String login;
	private String password;
	private String nombre;
	private String desAgencia;
	private String codAgencia;
	
	private String codUsuario;
	private String codEmpleado;

	private List<BOpcion> listaOpciones;

	public BUsuarioLogin() {
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDesAgencia() {
		return desAgencia;
	}

	public void setDesAgencia(String desAgencia) {
		this.desAgencia = desAgencia;
	}

	public String getCodAgencia() {
		return codAgencia;
	}

	public void setCodAgencia(String codAgencia) {
		this.codAgencia = codAgencia;
	}

	public String getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getCodEmpleado() {
		return codEmpleado;
	}

	public void setCodEmpleado(String codEmpleado) {
		this.codEmpleado = codEmpleado;
	}

	public List<BOpcion> getListaOpciones() {
		return listaOpciones;
	}

	public void setListaOpciones(List<BOpcion> listaOpciones) {
		this.listaOpciones = listaOpciones;
	}

	@Override
	public String toString() {
		return "BUsuarioLogin [login=" + login + ", password=" + password
				+ ", nombre=" + nombre + ", desAgencia=" + desAgencia
				+ ", codAgencia=" + codAgencia + ", codUsuario=" + codUsuario
				+ ", codEmpleado=" + codEmpleado + ", listaOpciones="
				+ listaOpciones + "]";
	}

	private String listaOpcionesString() {
		String cadena = "";
		for (int i = 0; i < listaOpciones.size(); i++) {
			cadena = cadena + "|" + listaOpciones.get(i).getCodigo();
		}
		return cadena;
	}

}
