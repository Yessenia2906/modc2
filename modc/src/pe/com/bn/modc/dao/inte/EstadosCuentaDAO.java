package pe.com.bn.modc.dao.inte;

import java.util.List;

import pe.com.bn.modc.exceptions.PersistenciaException;
import pe.com.bn.modc.model.EstadoCuentaPdf;

public interface EstadosCuentaDAO {
	
	public List<EstadoCuentaPdf> getEstadosName(
			String fechaCorteInicial, String fechaCorteFin, String dniCliente) throws PersistenciaException;
			  
}
