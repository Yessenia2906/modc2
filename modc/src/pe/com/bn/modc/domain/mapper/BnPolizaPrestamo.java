package pe.com.bn.modc.domain.mapper;


import java.io.Serializable;

import javax.servlet.ServletOutputStream;




public class BnPolizaPrestamo implements Serializable{

	private static final long serialVersionUID = 1L;
	
   private String tipo;
   private String ccuenta;
   private String correo;

   private String cdsbolso; 
   private String importe; 
   private String ncuotas;  
   private String acliente; 
   private String direccion; 
   private String telefono;  
   private String tdoc; 
   private String ndoc; 
   private String fecha_nac; 
   private String nsecuencia; 
   private String ngenerico;  
   private String filler1;  
   private String sec_poliza; 
   private String fini_vigencia;  
   private String tasa; 
   private String tasa_demis; 
   private String prima_neta; 
   private String derecho_emision; 
   private String sgravamen;  
   private String sprima_des;  
   private String tasa_des;  
   private String demi_des; 
   private String igv_des;  
   private String fter_vigencia;  
   private String tasa_total; 
   private String telefono_bn; 
   private String poliza_des; 
   private String sexo; 
   private String nacionalidad;  
   private String ecivil; 
   private String claboral; 
   private String cagencia;  
   private String fagencia; 
   private String aagencia; 
   private String cusuario;  
   private String ccuenta_a; 
   private String cdsbolso_a;  
   private String prima_neta_a; 
   private String ngenerico_a;
   private String filler2;  
   private String sec_poliza_a;
   private String nombre1; 
   private String nombre2;
   private String ubigeo;
   private String distrito;
   private String provincia;
   private String dpto;
   private String celular;
   private String email;
   private String cerror;
   
   private String coderror;
   private String msj;
   
   private String msjeTotal;
   
   
   
public String getMsjeTotal() {
	return msjeTotal;
}
public void setMsjeTotal(String msjeTotal) {
	this.msjeTotal = msjeTotal;
}
public String getCoderror() {
	return coderror;
}
public void setCoderror(String coderror) {
	this.coderror = coderror;
}
public String getMsj() {
	return msj;
}
public void setMsj(String msj) {
	this.msj = msj;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}
public String getCcuenta() {
	return ccuenta;
}
public void setCcuenta(String ccuenta) {
	this.ccuenta = ccuenta;
}
public String getCorreo() {
	return correo;
}
public void setCorreo(String correo) {
	this.correo = correo;
}
public String getCdsbolso() {
	return cdsbolso;
}
public void setCdsbolso(String cdsbolso) {
	this.cdsbolso = cdsbolso;
}
public String getImporte() {
	return importe;
}
public void setImporte(String importe) {
	this.importe = importe;
}
public String getNcuotas() {
	return ncuotas;
}
public void setNcuotas(String ncuotas) {
	this.ncuotas = ncuotas;
}
public String getAcliente() {
	return acliente;
}
public void setAcliente(String acliente) {
	this.acliente = acliente;
}
public String getDireccion() {
	return direccion;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}
public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}
public String getTdoc() {
	return tdoc;
}
public void setTdoc(String tdoc) {
	this.tdoc = tdoc;
}
public String getNdoc() {
	return ndoc;
}
public void setNdoc(String ndoc) {
	this.ndoc = ndoc;
}
public String getFecha_nac() {
	return fecha_nac;
}
public void setFecha_nac(String fecha_nac) {
	this.fecha_nac = fecha_nac;
}
public String getNsecuencia() {
	return nsecuencia;
}
public void setNsecuencia(String nsecuencia) {
	this.nsecuencia = nsecuencia;
}
public String getNgenerico() {
	return ngenerico;
}
public void setNgenerico(String ngenerico) {
	this.ngenerico = ngenerico;
}
public String getFiller1() {
	return filler1;
}
public void setFiller1(String filler1) {
	this.filler1 = filler1;
}
public String getSec_poliza() {
	return sec_poliza;
}
public void setSec_poliza(String sec_poliza) {
	this.sec_poliza = sec_poliza;
}
public String getFini_vigencia() {
	return fini_vigencia;
}
public void setFini_vigencia(String fini_vigencia) {
	this.fini_vigencia = fini_vigencia;
}
public String getTasa() {
	return tasa;
}
public void setTasa(String tasa) {
	this.tasa = tasa;
}
public String getTasa_demis() {
	return tasa_demis;
}
public void setTasa_demis(String tasa_demis) {
	this.tasa_demis = tasa_demis;
}
public String getPrima_neta() {
	return prima_neta;
}
public void setPrima_neta(String prima_neta) {
	this.prima_neta = prima_neta;
}
public String getDerecho_emision() {
	return derecho_emision;
}
public void setDerecho_emision(String derecho_emision) {
	this.derecho_emision = derecho_emision;
}
public String getSgravamen() {
	return sgravamen;
}
public void setSgravamen(String sgravamen) {
	this.sgravamen = sgravamen;
}
public String getSprima_des() {
	return sprima_des;
}
public void setSprima_des(String sprima_des) {
	this.sprima_des = sprima_des;
}
public String getTasa_des() {
	return tasa_des;
}
public void setTasa_des(String tasa_des) {
	this.tasa_des = tasa_des;
}
public String getDemi_des() {
	return demi_des;
}
public void setDemi_des(String demi_des) {
	this.demi_des = demi_des;
}
public String getIgv_des() {
	return igv_des;
}
public void setIgv_des(String igv_des) {
	this.igv_des = igv_des;
}
public String getFter_vigencia() {
	return fter_vigencia;
}
public void setFter_vigencia(String fter_vigencia) {
	this.fter_vigencia = fter_vigencia;
}
public String getTasa_total() {
	return tasa_total;
}
public void setTasa_total(String tasa_total) {
	this.tasa_total = tasa_total;
}
public String getTelefono_bn() {
	return telefono_bn;
}
public void setTelefono_bn(String telefono_bn) {
	this.telefono_bn = telefono_bn;
}
public String getPoliza_des() {
	return poliza_des;
}
public void setPoliza_des(String poliza_des) {
	this.poliza_des = poliza_des;
}
public String getSexo() {
	return sexo;
}
public void setSexo(String sexo) {
	this.sexo = sexo;
}
public String getNacionalidad() {
	return nacionalidad;
}
public void setNacionalidad(String nacionalidad) {
	this.nacionalidad = nacionalidad;
}
public String getEcivil() {
	return ecivil;
}
public void setEcivil(String ecivil) {
	this.ecivil = ecivil;
}
public String getClaboral() {
	return claboral;
}
public void setClaboral(String claboral) {
	this.claboral = claboral;
}
public String getCagencia() {
	return cagencia;
}
public void setCagencia(String cagencia) {
	this.cagencia = cagencia;
}
public String getFagencia() {
	return fagencia;
}
public void setFagencia(String fagencia) {
	this.fagencia = fagencia;
}
public String getAagencia() {
	return aagencia;
}
public void setAagencia(String aagencia) {
	this.aagencia = aagencia;
}
public String getCusuario() {
	return cusuario;
}
public void setCusuario(String cusuario) {
	this.cusuario = cusuario;
}
public String getCcuenta_a() {
	return ccuenta_a;
}
public void setCcuenta_a(String ccuenta_a) {
	this.ccuenta_a = ccuenta_a;
}
public String getCdsbolso_a() {
	return cdsbolso_a;
}
public void setCdsbolso_a(String cdsbolso_a) {
	this.cdsbolso_a = cdsbolso_a;
}
public String getPrima_neta_a() {
	return prima_neta_a;
}
public void setPrima_neta_a(String prima_neta_a) {
	this.prima_neta_a = prima_neta_a;
}
public String getNgenerico_a() {
	return ngenerico_a;
}
public void setNgenerico_a(String ngenerico_a) {
	this.ngenerico_a = ngenerico_a;
}
public String getFiller2() {
	return filler2;
}
public void setFiller2(String filler2) {
	this.filler2 = filler2;
}
public String getSec_poliza_a() {
	return sec_poliza_a;
}
public void setSec_poliza_a(String sec_poliza_a) {
	this.sec_poliza_a = sec_poliza_a;
}
public String getNombre1() {
	return nombre1;
}
public void setNombre1(String nombre1) {
	this.nombre1 = nombre1;
}
public String getNombre2() {
	return nombre2;
}
public void setNombre2(String nombre2) {
	this.nombre2 = nombre2;
}
public String getUbigeo() {
	return ubigeo;
}
public void setUbigeo(String ubigeo) {
	this.ubigeo = ubigeo;
}
public String getDistrito() {
	return distrito;
}
public void setDistrito(String distrito) {
	this.distrito = distrito;
}
public String getProvincia() {
	return provincia;
}
public void setProvincia(String provincia) {
	this.provincia = provincia;
}
public String getDpto() {
	return dpto;
}
public void setDpto(String dpto) {
	this.dpto = dpto;
}
public String getCelular() {
	return celular;
}
public void setCelular(String celular) {
	this.celular = celular;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getCerror() {
	return cerror;
}
public void setCerror(String cerror) {
	this.cerror = cerror;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
}

