package pe.com.bn.modc.model;

import org.springframework.util.Base64Utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;




public class EstadoCuentaPdf {
	

	private String fecha;
	private String dni;
	private String base64;
	private byte[] pdf ;
	private String age;
	private String dia;
	private String mes;	
	private String nombrearchivo;
	private String tipo;
	private String ruta;
	private String base64res;
	
	public String getBase64res() {
		return base64res;
	}
	public void setBase64res(String base64res) {
		this.base64res = base64res;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public String getNombrearchivo() {
		return nombrearchivo;
	}
	public void setNombrearchivo(String nombrearchivo) {
		this.nombrearchivo = nombrearchivo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	
	
	
	
	
	
	public String getBase64() {
		return base64;
	}
	public void setBase64(String base64) {
		this.base64 = base64;
	}
	

	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public byte[] getPdf() {
		return pdf;
	}
	public void setPdf(byte[] pdf) {
		this.pdf = pdf;
		
		this.base64 = Base64Utils.encodeToString(pdf);
		
	}
	public EstadoCuentaPdf(String fechaCorte, String dni, byte[] pdf) {
		
		fecha = fechaCorte;
		this.dni = dni;
		this.pdf = pdf;
	}
	public EstadoCuentaPdf() {

	}
	@Override
	public String toString() {
		JsonObject jsonObject = new JsonObject();
	    jsonObject.add("fecha",  new JsonPrimitive(fecha));
	    jsonObject.add("dni",new JsonPrimitive(dni) );
	    jsonObject.add("base64",new JsonPrimitive(base64) );
	    return jsonObject.toString();
	}
	
}
