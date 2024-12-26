package pe.com.bn.modc.model;

import pe.com.bn.modc.config.CustomUser;

public class AudiLog {
	
	public AudiLog( String accion) {
		super();

		this.accion = accion;
	}
	public AudiLog( String accion, String dni) {
		super();

		this.accion = accion;
		this.dni = dni;
	}
	private String fecha;
	private String hora;
	private String usuario;
	private String accion;
	private String dni;
	private String codAgencia;
	private String nombreAgencia;

	
	
	
	
	public String getCodAgencia() {
		return codAgencia;
	}
	public void setCodAgencia(String codAgencia) {
		this.codAgencia = codAgencia;
	}
	public String getNombreAgencia() {
		return nombreAgencia;
	}
	public void setNombreAgencia(String nombreAgencia) {
		this.nombreAgencia = nombreAgencia;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setDatosUsuario(CustomUser usuario) {
		this.usuario = usuario.getNombre();
		this.codAgencia = usuario.getCodAgencia();
		this.nombreAgencia = usuario.getDesAgencia().trim();
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	 
 
	@Override
	public String toString() {
		return "AudiLog [fecha=" + fecha + ", hora=" + hora + ", usuario="
				+ usuario + ", accion=" + accion + ", codAgencia=" + codAgencia
				+ ", nombreAgencia=" + nombreAgencia + "]";
	}
	public AudiLog() {
		super();
	}
	
}
