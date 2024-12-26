package pe.com.bn.modc.services.inte;

 import java.util.List;

  
import pe.com.bn.modc.exceptions.ExternalException;
import pe.com.bn.modc.exceptions.FtpException;
import pe.com.bn.modc.model.EstadoCuentaPdf;
 
public interface ServiceSFTP {
	public  List<EstadoCuentaPdf> ObtenerEstadosCuenta(List<EstadoCuentaPdf> eecc) throws FtpException, ExternalException;

	public EstadoCuentaPdf ObtenerEECCindividual(EstadoCuentaPdf estadoCuentaPdf) ;

 
}
