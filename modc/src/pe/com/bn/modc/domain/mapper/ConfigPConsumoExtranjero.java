package pe.com.bn.modc.domain.mapper;

public class ConfigPConsumoExtranjero {

	private String   estado;
// 	private String   tipoMoneda;
// 	private String   monto;
// 	private String   tipoMonto;
    private String   fechaIda;
    private String   fechaVuelta;
    private String[] listadoCodPaises;
    
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFechaIda() {
		return fechaIda;
	}
	public void setFechaIda(String fechaIda) {
		this.fechaIda = fechaIda;
	}
	public String getFechaVuelta() {
		return fechaVuelta;
	}
	public void setFechaVuelta(String fechaVuelta) {
		this.fechaVuelta = fechaVuelta;
	}
	public String[] getListadoCodPaises() {
		return listadoCodPaises;
	}
	public void setListadoCodPaises(String[] listadoCodPaises) {
		this.listadoCodPaises = listadoCodPaises;
	}
    
    

}

