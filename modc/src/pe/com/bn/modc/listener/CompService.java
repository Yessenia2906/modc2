package pe.com.bn.modc.listener;

import pe.com.bn.modc.exceptions.ExternalException;
import pe.com.bn.modc.exceptions.ParametrosCompException;

public interface  CompService {
	public void asignarParametros() throws ParametrosCompException, ExternalException;

}
