package pe.com.bn.modc.dao.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.bn.modc.common.Constant;
import pe.com.bn.modc.common.LoggerEECC;
import pe.com.bn.modc.listener.PdfOFSftp;
import pe.com.bn.modc.model.EstadoCuentaPdf;
import pe.com.bn.modc.model.ParametrosComp;
import pe.com.bn.modc.services.impl.HttpClientjdk;
import pe.com.bn.modc.services.inte.ServiceEnvioEmail;
import pe.com.bn.modc.services.inte.ServiceSFTP;

@Service
public class ConsultaEmailCliente implements ServiceEnvioEmail{

	private   LoggerEECC log = LoggerEECC
			.getInstance(ConsultaEmailCliente.class.getName());

	
	@Autowired
	private ServiceSFTP serviceSFTP;
	
	
	private JSONObject buscarEmail(String dni, ParametrosComp parametrosComp) throws JSONException {
	    HttpURLConnection connection = null;
	    StringBuilder response = null;
	    
	/*    String host = "10.7.12.75";
        int port = 80 ;
        String userApplication = "modc" ;*/   
	    
	    String host = parametrosComp.getServiceHost();
	    int port = Integer.parseInt(parametrosComp.getServicePort());
	    String userApplication = parametrosComp.getServiceUserApplication();

	    try {
	        log.debug("Iniciando conexión con servicio externo para buscar email", Constant.LOGGER_DEBUG_NIVEL_1);
	        URL url = new URL("http://" + host + ":" + port + "/msdataclients/client/v1/search/TYPENUMDOC?typeDoc=1&numDoc=" + dni);
	        //log.debug("URL construida: " + url.toString(), Constant.LOGGER_DEBUG_NIVEL_1);

	        // Abrir la conexión
	        connection = (HttpURLConnection) url.openConnection();

	        // Configurar la solicitud
	        connection.setRequestMethod("GET");
	        connection.setRequestProperty("Application", "SACL");
	        connection.setRequestProperty("Channel", "ATM");
	        connection.setRequestProperty("ChannelCode", "1");
	        connection.setRequestProperty("userApplication", userApplication);
	        connection.setRequestProperty("Content-Type", "application/json");
	        //log.debug("Solicitud configurada con headers necesarios", Constant.LOGGER_DEBUG_NIVEL_1);

	        // Obtener la respuesta del servidor
	        int responseCode = connection.getResponseCode();
	        log.debug("Código de respuesta del servidor: " + responseCode, Constant.LOGGER_DEBUG_NIVEL_1);
	        if (responseCode == 200) {
	            // Leer la respuesta del servidor
	            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	            String line;
	            response = new StringBuilder();

	            while ((line = reader.readLine()) != null) {
	                response.append(line);
	            }

	            // Cerrar la conexión
	            reader.close();
	            log.debug("Respuesta del servidor leída correctamente", Constant.LOGGER_DEBUG_NIVEL_1);
	        } else {
	            response = new StringBuilder();

	            // Agrega los datos al StringBuilder
	            response.append("{");
	            response.append("\"codResult\": \"");
	            response.append("00020");
	            response.append("\",");
	            response.append("\"data\": null,");
	            response.append("\"msg\": \"");
	            response.append("Error: numDoc debe tener un valor entre 1 y 8 caracteres.");
	            response.append("\",");
	            response.append("\"msgError\": \"");
	            response.append("Error: numDoc debe tener un valor entre 1 y 8 caracteres.");
	            response.append("\"}");

	            log.debug("Respuesta del servidor no fue exitosa, código: " + responseCode, Constant.LOGGER_DEBUG_NIVEL_1);
	        }

	    } catch (Exception e) {
	        log.error(e, "Error Api DATOS PERSONALES:");
	    } finally {
	        if (connection != null) {
	            connection.disconnect();
	            log.debug("Conexión cerrada", Constant.LOGGER_DEBUG_NIVEL_1);
	        }
	    }
	    return new JSONObject(response.toString());
	}

	public   Map<String, String> getEmailDni(String dni,
			ParametrosComp parametrosComp){

		Map<String, String> informacionUsuario = new HashMap<String, String>();

		try{
			String Email = "NO EMAIL";
			String nombreCompleto = "";

			JSONObject response = buscarEmail(dni, parametrosComp);
			String clave = response.getString("codResult");
			if (clave.equals("00000")) {
				JSONObject data = response.getJSONObject("data");
				JSONObject clientNaturalPerson = data.getJSONObject("clientNaturalPerson");
				JSONObject clientGeneralPerson = data.getJSONObject("clientGeneral");
				
				Email = clientNaturalPerson.getString("personalEmail");
				nombreCompleto = clientGeneralPerson.getString("fullName");

			}

			informacionUsuario.put("email", Email);
			informacionUsuario.put("nombreCompleto", nombreCompleto);
			
		}catch(JSONException  e){
			
		}
		return informacionUsuario;
	}
	
	@Override
	public   boolean enviarZipToEmail(
			String numeroDniCorreo,
			String correoDniCliente, List<EstadoCuentaPdf> estadostwo,
			ParametrosComp parametrosComp ) {

		boolean resultadoEnvio = true;
		try {

			String nombreCompletoString = getEmailDni(numeroDniCorreo,
					parametrosComp).get("nombreCompleto");
			String wsEnvioCorreoAldema = parametrosComp
					.getServicewscorreoHost();
			String tokenws = parametrosComp.getServicewscorreoToken();
			String correoEmisor = parametrosComp
					.getServicewscorreoCorreoemisor();

			HttpClientjdk cliente = new HttpClientjdk(nombreCompletoString);
			cliente.setUrl(new URL(wsEnvioCorreoAldema));
			cliente.setTokenBearerWS(tokenws);
			cliente.setCorreoEmisor(correoEmisor);

			// ENVIO CORREO POR ALDEAMO
			// resultadoEnvio =
			// cliente.enviarZiptoEmail(estadostwo,correoDniCliente,numeroDniCorreo,fechaFinCorreo,fechaInicioCorreo);

			// ENVIO CORREO POR SIMM
			resultadoEnvio = cliente.enviarpdfCompletoEmailSIMM(estadostwo,
					correoDniCliente, numeroDniCorreo , nombreCompletoString,(PdfOFSftp) serviceSFTP);

		} catch (Exception e) {
			log.error(e, "ERROR EN ENVIAR CORREO POR SERVICIO");
			resultadoEnvio = false;
		}
		return resultadoEnvio;
	}

	@Override
	public Map<String, String> getNombreCliente(String tipo, String num, ParametrosComp parametrosComp) {
		// TODO Apéndice de método generado automáticamente
		
		Map<String, String> informacionCliente = new HashMap<String, String>();

		try{
			String correo = "NO EMAIL";
			String nombreCompleto = "";

			JSONObject response = buscarCorreoCliente(tipo,num, parametrosComp);
			String clave = response.getString("codResult");
			if (clave.equals("00000")) {
				JSONObject data = response.getJSONObject("data");
				JSONObject clientNaturalPerson = data.getJSONObject("clientNaturalPerson");
				JSONObject clientGeneralPerson = data.getJSONObject("clientGeneral");
				
				correo = clientNaturalPerson.getString("personalEmail");
				nombreCompleto = clientGeneralPerson.getString("fullName");

			}

			informacionCliente.put("email", correo);
			informacionCliente.put("nombreCompleto", nombreCompleto);
			
		}catch(JSONException  e){
		
			
		}
		return informacionCliente;
		
	}
	
	

	private JSONObject buscarCorreoCliente(String tipo, String num, ParametrosComp parametrosComp) throws JSONException {
	    HttpURLConnection connection = null;
	    StringBuilder response = null;

	    String host = parametrosComp.getServiceHost();
	    int port = Integer.parseInt(parametrosComp.getServicePort());
	    String userApplication = parametrosComp.getServiceUserApplication();
	 
	    /* String host = "10.7.12.75";
        int port = 80 ;
        String userApplication = "modc" ;*/
	    try {
	        log.debug("Iniciando conexión con servicio externo para buscar nombre del cliente y correo", Constant.LOGGER_DEBUG_NIVEL_1);
	        URL url = new URL("http://" + host + ":" + port + "/msdataclients/client/v1/search/TYPENUMDOC?typeDoc="+tipo+"&numDoc=" + num);
	        //log.debug("URL construida: " + url.toString(), Constant.LOGGER_DEBUG_NIVEL_1);

	        // Abrir la conexión
	        connection = (HttpURLConnection) url.openConnection();

	        // Configurar la solicitud
	        connection.setRequestMethod("GET");
	        connection.setRequestProperty("Application", "SACL");
	        connection.setRequestProperty("Channel", "ATM");
	        connection.setRequestProperty("ChannelCode", "1");
	        connection.setRequestProperty("userApplication", userApplication);
	        connection.setRequestProperty("Content-Type", "application/json");
	        //log.debug("Solicitud configurada con headers necesarios", Constant.LOGGER_DEBUG_NIVEL_1);

	        // Obtener la respuesta del servidor
	        int responseCode = connection.getResponseCode();
	        log.debug("Código de respuesta del servidor: " + responseCode, Constant.LOGGER_DEBUG_NIVEL_1);
	        if (responseCode == 200) {
	            // Leer la respuesta del servidor
	            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	            String line;
	            response = new StringBuilder();

	            while ((line = reader.readLine()) != null) {
	                response.append(line);
	            }

	            // Cerrar la conexión
	            reader.close();
	            log.debug("Respuesta del servidor leída correctamente", Constant.LOGGER_DEBUG_NIVEL_1);
	        } else {
	            response = new StringBuilder();

	            // Agrega los datos al StringBuilder
	            response.append("{");
	            response.append("\"codResult\": \"");
	            response.append("00020");
	            response.append("\",");
	            response.append("\"data\": null,");
	            response.append("\"msg\": \"");
	            response.append("Error: numDoc debe tener un valor entre 1 y 8 caracteres.");
	            response.append("\",");
	            response.append("\"msgError\": \"");
	            response.append("Error: numDoc debe tener un valor entre 1 y 12 caracteres.");
	            response.append("\"}");

	            log.debug("Respuesta del servidor no fue exitosa, código: " + responseCode, Constant.LOGGER_DEBUG_NIVEL_1);
	        }

	    } catch (Exception e) {
	        log.error(e, "Error Api DATOS PERSONALES:");
	    } finally {
	        if (connection != null) {
	            connection.disconnect();
	            log.debug("Conexión cerrada", Constant.LOGGER_DEBUG_NIVEL_1);
	        }
	    }
	    return new JSONObject(response.toString());
	}
	
	
	
	@Override
	public Map<String, String> getDatoCliente(String num, ParametrosComp parametrosComp) {
		// TODO Apéndice de método generado automáticamente
		
		Map<String, String> informacionCliente = new HashMap<String, String>();

		try{
			String correo = "";
			String nombreCompleto = "";
			JSONObject response = buscarCorreoDato(num, parametrosComp);
			String clave = response.getString("codResult");
			if (clave.equals("00000")) {
				JSONObject data = response.getJSONObject("data");
				JSONObject clientNaturalPerson = data.getJSONObject("clientNaturalPerson");
				JSONObject clientGeneralPerson = data.getJSONObject("clientGeneral");
				
				correo = clientNaturalPerson.getString("personalEmail");
				nombreCompleto = clientGeneralPerson.getString("fullName");

			}

			informacionCliente.put("email", correo);
			informacionCliente.put("nombreCompleto", nombreCompleto);
			
		}catch(JSONException  e){
		
			
		}
		return informacionCliente;
		
	}
	
	private JSONObject buscarCorreoDato(String num, ParametrosComp parametrosComp) throws JSONException {
	    HttpURLConnection connection = null;
	    StringBuilder response = null;

	    String host = parametrosComp.getServiceHost();
	    int port = Integer.parseInt(parametrosComp.getServicePort());
	    String userApplication = parametrosComp.getServiceUserApplication();
	 
	    /* String host = "10.7.12.75";
        int port = 80 ;
        String userApplication = "modc" ;*/
	    try {
	        log.debug("Iniciando conexión con servicio externo para buscar nombre del cliente y correo", Constant.LOGGER_DEBUG_NIVEL_1);
	        URL url = new URL("http://" + host + ":" + port + "/msdataclients/client/v1/search/TYPENUMDOC?typeDoc=1&numDoc=" + num);
	        //log.debug("URL construida: " + url.toString(), Constant.LOGGER_DEBUG_NIVEL_1);

	        // Abrir la conexión
	        connection = (HttpURLConnection) url.openConnection();

	        // Configurar la solicitud
	        connection.setRequestMethod("GET");
	        connection.setRequestProperty("Application", "SACL");
	        connection.setRequestProperty("Channel", "ATM");
	        connection.setRequestProperty("ChannelCode", "1");
	        connection.setRequestProperty("userApplication", userApplication);
	        connection.setRequestProperty("Content-Type", "application/json");
	        //log.debug("Solicitud configurada con headers necesarios", Constant.LOGGER_DEBUG_NIVEL_1);

	        // Obtener la respuesta del servidor
	        int responseCode = connection.getResponseCode();
	        log.debug("Código de respuesta del servidor: " + responseCode, Constant.LOGGER_DEBUG_NIVEL_1);
	        if (responseCode == 200) {
	            // Leer la respuesta del servidor
	            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	            String line;
	            response = new StringBuilder();

	            while ((line = reader.readLine()) != null) {
	                response.append(line);
	            }

	            // Cerrar la conexión
	            reader.close();
	            log.debug("Respuesta del servidor leída correctamente", Constant.LOGGER_DEBUG_NIVEL_1);
	        } else {
	            response = new StringBuilder();

	            // Agrega los datos al StringBuilder
	            response.append("{");
	            response.append("\"codResult\": \"");
	            response.append("00020");
	            response.append("\",");
	            response.append("\"data\": null,");
	            response.append("\"msg\": \"");
	            response.append("Error: numDoc debe tener un valor entre 1 y 8 caracteres.");
	            response.append("\",");
	            response.append("\"msgError\": \"");
	            response.append("Error: numDoc debe tener un valor entre 1 y 12 caracteres.");
	            response.append("\"}");

	            log.debug("Respuesta del servidor no fue exitosa, código: " + responseCode, Constant.LOGGER_DEBUG_NIVEL_1);
	        }

	    } catch (Exception e) {
	        log.error(e, "Error Api DATOS PERSONALES:");
	    } finally {
	        if (connection != null) {
	            connection.disconnect();
	            log.debug("Conexión cerrada", Constant.LOGGER_DEBUG_NIVEL_1);
	        }
	    }
	    return new JSONObject(response.toString());
	}
	
}


