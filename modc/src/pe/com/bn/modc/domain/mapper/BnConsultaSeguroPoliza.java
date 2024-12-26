package pe.com.bn.modc.domain.mapper;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;

public class BnConsultaSeguroPoliza {
	private String filas;
	
	
	private String codigo;
	private String descripcion;
	private Blob documento;
	private String fecha;
	private String indicador;
	
	
	 InputStream doc = null;
	 
	public InputStream getDoc() {
		return doc;
	}
	public void setDoc(InputStream doc) {
		this.doc = doc;
	}
	
	
	
	public Blob getDocumento() {
		return documento;
	}
	public void setDocumento(Blob documento) {
		this.documento = documento;
	}
	public String getFilas() {
		return filas;
	}
	public void setFilas(String filas) {
		this.filas = filas;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getIndicador() {
		return indicador;
	}
	public void setIndicador(String indicador) {
		this.indicador = indicador;
	}
	
	
	
}
