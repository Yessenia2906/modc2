package pe.com.bn.modc.domain.mapper;

import lombok.Data;

@Data
public class BnEnviarDoc {
	
	private String NUMPRESTAMO;
	private String TIPDOC;
	private String NUMDOC ;
	private String CORREO;
	private String FECHA;
	private String HORA;
	private String USUARIO;
	private String AGENCIA;
	private String ESTADO;
	private byte[] PDF;
	
	


}
