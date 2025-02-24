package pe.com.bn.modc.domain.mapper;


public class BnLogAuditoriaPM {
	String prestamo;
	String fecha;
	String Cusuario;
	String Coficina;
	String cliente;
	String celular;
	String correo;
	String sit_envio;
	String accion;
	String DOI;
	
	
	public String getPrestamo() {
		return prestamo;
	}
	public void setPrestamo(String prestamo) {
		this.prestamo = prestamo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getCusuario() {
		return Cusuario;
	}
	public void setCusuario(String cusuario) {
		Cusuario = cusuario;
	}
	public String getCoficina() {
		return Coficina;
	}
	public void setCoficina(String coficina) {
		Coficina = coficina;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getSit_envio() {
		return sit_envio;
	}
	public void setSit_envio(String sit_envio) {
		this.sit_envio = sit_envio;
	}
	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}
	public String getDOI() {
		return DOI;
	}
	public void setDOI(String dOI) {
		DOI = dOI;
	}
	@Override
	public String toString() {
		return "BnLogAuditoriaPM [prestamo=" + prestamo + ", fecha=" + fecha + ", Cusuario=" + Cusuario + ", Coficina="
				+ Coficina + ", cliente=" + cliente + ", celular=" + celular + ", correo=" + correo + ", sit_envio="
				+ sit_envio + ", accion=" + accion + ", DOI=" + DOI + ", getPrestamo()=" + getPrestamo()
				+ ", getFecha()=" + getFecha() + ", getCusuario()=" + getCusuario() + ", getCoficina()=" + getCoficina()
				+ ", getCliente()=" + getCliente() + ", getCelular()=" + getCelular() + ", getCorreo()=" + getCorreo()
				+ ", getSit_envio()=" + getSit_envio() + ", getAccion()=" + getAccion() + ", getDOI()=" + getDOI()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
