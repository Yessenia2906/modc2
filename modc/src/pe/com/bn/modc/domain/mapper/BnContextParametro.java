package pe.com.bn.modc.domain.mapper;

import pe.com.bn.modc.common.Constante;
import pe.com.bn.modc.common.Funciones;
import pe.com.bn.modc.common.LoggerBn;
import pe.com.bn.modc.controller.AdministracionController;
import pe.com.bn.modc.domain.mapper.BnwsParametro.ParamSimm;



public class BnContextParametro {
	
	
	private static LoggerBn log3 = LoggerBn.getInstance(BnContextParametro.class.getName());

	public static ParamSimm getParamServiceSimm() {
		try {
			
			if(Constante.BN_PARAM_SIMM == null ){
				Constante.BN_PARAM_SIMM = Funciones.invokeWebServiceSimm();
			}
			
			if(Constante.BN_PARAM_SIMM ==null ) 
				throw new Exception("PARAMETRO NO DEFINIDO getParamServiceSimm");

		} catch (Exception e) {
			log3.error(e, "5002", "");
		}
		return Constante.BN_PARAM_SIMM;
	}


}
