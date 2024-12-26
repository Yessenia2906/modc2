package pe.com.bn.modc.domain.mapper;

import java.io.InputStream;
import java.sql.Blob;

public class BnConsultaTarjeta {

	private String filas;
	

	public String getFilas() {
		return filas;
	}
	public void setFilas(String filas) {
		this.filas = filas;
	}
	private String desembolso;
	private String tipo;
	private Blob documento;
	
	
	private String email;
	private String fechaEnvio;
	private String horaEnvio;
	private String fechaLec;
	private String horaLec;
	private String ipLec; 
	private String estado;
	private String campo1;
	private String campo2;
	private String fechaCarga;
	
	
	 public String getDesembolso() {
		return desembolso;
	}
	public void setDesembolso(String desembolso) {
		this.desembolso = desembolso;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Blob getDocumento() {
		return documento;
	}
	public void setDocumento(Blob documento) {
		this.documento = documento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFechaEnvio() {
		return fechaEnvio;
	}
	public void setFechaEnvio(String fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}
	public String getHoraEnvio() {
		return horaEnvio;
	}
	public void setHoraEnvio(String horaEnvio) {
		this.horaEnvio = horaEnvio;
	}
	public String getFechaLec() {
		return fechaLec;
	}
	public void setFechaLec(String fechaLec) {
		this.fechaLec = fechaLec;
	}
	public String getHoraLec() {
		return horaLec;
	}
	public void setHoraLec(String horaLec) {
		this.horaLec = horaLec;
	}
	public String getIpLec() {
		return ipLec;
	}
	public void setIpLec(String ipLec) {
		this.ipLec = ipLec;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCampo1() {
		return campo1;
	}
	public void setCampo1(String campo1) {
		this.campo1 = campo1;
	}
	public String getCampo2() {
		return campo2;
	}
	public void setCampo2(String campo2) {
		this.campo2 = campo2;
	}
	public String getFechaCarga() {
		return fechaCarga;
	}
	public void setFechaCarga(String fechaCarga) {
		this.fechaCarga = fechaCarga;
	}
	InputStream doc = null;
		public InputStream getDoc() {
			return doc;
		}
		public void setDoc(InputStream doc) {
			this.doc = doc;
		}
}
