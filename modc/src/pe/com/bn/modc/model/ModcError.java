package pe.com.bn.modc.model;

public class ModcError  extends  Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String mensaje;
	public String codigo;
	
	public ModcError(String mensaje,String codigo){
		super( codigo  + " - " + mensaje);
		this.mensaje = mensaje;
		this.codigo = codigo;
	}
	
	
}
