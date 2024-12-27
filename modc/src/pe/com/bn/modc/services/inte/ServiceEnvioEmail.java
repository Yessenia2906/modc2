package pe.com.bn.modc.services.inte;

import java.util.List;
import java.util.Map;

import pe.com.bn.modc.listener.PdfOFSftp;
import pe.com.bn.modc.model.EstadoCuentaPdf;
import pe.com.bn.modc.model.ParametrosComp;

public interface ServiceEnvioEmail {

	public   boolean enviarZipToEmail(
			String numeroDniCorreo,
			String correoDniCliente, List<EstadoCuentaPdf> estadostwo,
			ParametrosComp parametrosComp) ;
	
	public   Map<String, String> getEmailDni(String dni,
			ParametrosComp parametrosComp);

	public Map<String, String> getNombreCliente(String tipo, String num, ParametrosComp parametrosComp);
	
	
}
