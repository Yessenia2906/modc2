package pe.com.bn.modc.dao.impl;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.bn.modc.common.LoggerEECC;
import pe.com.bn.modc.model.ParametrosComp;
import pe.com.bn.modc.services.impl.HttpClientjdk;

@Service
public class EnvioCorreoValidacion {

	@Autowired
	private ParametrosComp parametrosComp;
	private   LoggerEECC log = LoggerEECC
			.getInstance(EnvioCorreoValidacion.class.getName());
	
	public  boolean enviarCorreoOTP(String correoCliente, String nombreCliente, String codigo) {
		
		boolean resultado = false;
		
		
		try {
			
			HttpClientjdk msjOTP = new HttpClientjdk(nombreCliente,codigo);
			msjOTP.setUrl(new URL(parametrosComp.getServicewscorreoHost()));
			msjOTP.setTokenBearerWS(parametrosComp.getServicewscorreoToken());
			msjOTP.setCorreoEmisor(parametrosComp.getServicewscorreoCorreoemisor());
			
			// ENVIO CORREO POR ALDEAMO
			resultado = msjOTP.enviarCorreoVal(correoCliente);

			
		} catch (MalformedURLException e) {
			log.error(e, "ERROR EN ENVIAR MSJ POR SERVICIO");
			e.printStackTrace();
			
		}
		

		return resultado;
	}

}
