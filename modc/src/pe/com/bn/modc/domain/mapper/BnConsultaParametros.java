package pe.com.bn.modc.domain.mapper;

import java.sql.Blob;

public class BnConsultaParametros {
	
	
	private String codigo;
	private String descripcion;
	private Blob documento;
	private String fecha;
	private String identificador;
	
	
	public BnConsultaParametros() {
		this.codigo = "";
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
	public Blob getDocumento() {
		return documento;
	}
	public void setDocumento(Blob documento) {
		this.documento = documento;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
	
	
	
}
