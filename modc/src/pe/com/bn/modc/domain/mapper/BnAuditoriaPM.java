package pe.com.bn.modc.domain.mapper;

import java.util.Date;

public class BnAuditoriaPM {

	String prestamo;
	String fecha;
	Date date;
	String Cusuario;
	String Coficina;
	String cliente;
	String tipodoc;
	String numerodoc;
	String celular;
	String correo;
	String sit_envio;
	String accion;
	String DOI;
	
	
	public String getDOI() {
		return DOI;
	}
	public void setDOI(String dOI) {
		DOI = dOI;
	}
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
	public String getTipodoc() {
		return tipodoc;
	}
	public void setTipodoc(String tipodoc) {
		this.tipodoc = tipodoc;
	}
	public String getNumerodoc() {
		return numerodoc;
	}
	public void setNumerodoc(String numerodoc) {
		this.numerodoc = numerodoc;
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
	
	public BnAuditoriaPM() {
		super();
	}
	
}