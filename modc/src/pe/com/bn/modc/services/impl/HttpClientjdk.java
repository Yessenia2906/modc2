package pe.com.bn.modc.services.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.itextpdf.text.DocumentException;

import pe.com.bn.modc.common.Constant;
import pe.com.bn.modc.common.Constante;
import pe.com.bn.modc.common.LoggerEECC;
import pe.com.bn.modc.listener.PdfOFSftp;
import pe.com.bn.modc.model.EstadoCuentaPdf;
import www.bn.simm.ws.open.bean.Adjunto;
import www.bn.simm.ws.open.bean.DatosCorreo;
import www.bn.simm.ws.open.bean.DatosParametro;
import www.bn.simm.ws.open.bean.ReqListMessage;
import www.bn.simm.ws.open.bean.RequestMessage;
import www.bn.simm.ws.open.service.ArrayOfTns1ReqListMessage;
import www.bn.simm.ws.open.service.ServiceMessageProxy;

public class HttpClientjdk {

	private URL url;
	private String tokenBearerWS;
	private String correoEmisor;
	private String mensajeMod;
	private static LoggerEECC log = LoggerEECC
			.getInstance(HttpClientjdk.class.getName());
	public HttpClientjdk(String nombre) throws MalformedURLException {
		this.mensajeMod = generarMensaje(nombre);
	}

	public HttpClientjdk(String nombre, String codigo) throws MalformedURLException {
		this.mensajeMod = generarMensajeOTP (nombre, codigo);
	}
	
	public HttpClientjdk(String nombre, String pdf, String fecha) {
		this.mensajeMod = generarMensajePDF (nombre, pdf, fecha);
	}

	private String generarMensajePDF(String nombre, String pdf, String fecha) {
		String mensajepdf =	
				"<div>" + 
			            "<p></p>" +
			            "<p>Estimado (a):<b> " + nombre + "</b></p>" +
			            "<p>¡Gracias por adquirir tu Pr&eacute;stamo Multired! </p>" +				
			            "<p>Nos complace enormemente que conf&iacute;es en el Banco de la Naci&oacute;n.</p>" +
			            "<p>Ante ello, de acuerdo a lo autorizado por usted y en cumplimiento del art&iacute;culo 49° del Reglamento de Gesti&oacute;n de Conducta de Mercado del Sistema Financiero, le remitimos los formularios contractuales y cronograma de pago suscritos, como parte del otorgamiento del Pr&eacute;stamo Multired realizado v&iacute;a Red de Agencias el d&iacute;a "+fecha+ " : (i) Solicitud de Pr&eacute;stamo, (ii) Hoja Resumen, (iii) Cronograma de Pagos y (iv) P&oacute;liza de Seguros de Desgravamen y de Cuota Protegida; asimismo, se le recuerda que las Cl&aacute;usulas Generales y Espec&iacute;ficas del Pr&eacute;stamo las puede descargar a trav&eacute;s de la p&aacute;gina web del Banco: www.bn.com.pe.</p>" +
			            "<p>Si tienes alguna consulta llámanos a nuestra Mesa de Consultas al 440-5305 / 442-4470, o tambi&eacute;n a nuestra l&iacute;nea gratuita desde tel&eacute;fono fijos al 0800-10700, o ingresa a www.bn.com.pe</p>"+
			            "<p><b>Por tu seguridad:</b> Recuerda que el Banco de la Naci&oacute;n nunca te solicitar&aacute; informaci&oacute;n, ni datos relacionados con tu cuenta o tarjetas, tampoco la clave de ingreso a canales como el: cajero autom&aacute;tico, canal app e internet o de, DNI o tu n&uacute;mero de celular, mediante correo electr&oacute;nico y/o llamadas telef&oacute;nicas.</p>"+
			            "<p>Por favor, no respondas a este correo electr&oacute;nico.</p>"+
			            "</div>";
		
		return mensajepdf;
	}

	private String generarMensajeOTP(String nombre, String codigo) {
		//TODO: Contenido del mensaje - validar correo
		String mensajeOTP =	
				"<div>" + 
			            "<p></p>" +
			            "<p>Estimado (a): " + nombre + "</p>" +
			            "<p>Para validar tu correo electr&oacute;nico, ingresa este <b>c&oacute;digo de verificaci&oacute;n</b> en el m&oacute;dulo de impresiones:</p>" +				
			            "<p>Tu c&oacute;digo de verificaci&oacute;n es: <b>" + codigo + "</b></p>" +
			            "<p>Tiempo de expiraci&oacute;n: 2 min</p>" +
			     "</div>";
		
		return mensajeOTP;
	}

	public boolean enviarZiptoEmail(List<EstadoCuentaPdf> estadostwo,
			String correoDniCliente, String numeroDniCorreo,
			String fechaFinCorreo, String fechaInicioCorreo,PdfOFSftp Sftp) {
		boolean resultadoEnvio = true;
		HttpURLConnection connection = null;
	
		try {

			connection = (HttpURLConnection) url.openConnection();
			connection.setConnectTimeout(20000);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Authorization", "Bearer "
					+ tokenBearerWS);
			// connection.setRequestProperty("Authorization", "Bearer "+
			// "8df7e333.a0d24c6587a56d43104f5ca4"); // TOKEN FUNCIONANDO PARA
			// ENVIO ARCHIVOS ALDEAMO
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setDoOutput(true);

			JSONObject json = generarJsonBody(correoDniCliente, correoEmisor,
					mensajeMod, fechaInicioCorreo, fechaFinCorreo, estadostwo,
					numeroDniCorreo,Sftp);

			/*
			 * JSONObject json = generarJsonBody("mivansansanchez@gmail.com",
			 * correoEmisor, mensajeMod, fechaInicioCorreo, fechaFinCorreo,
			 * estadostwo, numeroDniCorreo);
			 */

			System.out.println(json.toString());

			OutputStream os = connection.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
			osw.write(json.toString());
			osw.flush();

			int statusCode = connection.getResponseCode();

			if (statusCode == HttpURLConnection.HTTP_OK) {
				// Leer la respuesta
				BufferedReader in = new BufferedReader(new InputStreamReader(
						connection.getInputStream()));
				String inputLine;
				StringBuilder response = new StringBuilder();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}

				// Imprimir la respuesta
				System.out.println("Respuesta del servicio: "
						+ response.toString());

				in.close();

			} else {
				resultadoEnvio = false;
				BufferedReader in = new BufferedReader(new InputStreamReader(
						connection.getInputStream()));
				String inputLine;
				StringBuilder response = new StringBuilder();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}

				// Imprimir la respuesta
				System.out.println("Respuesta del servicio: "
						+ response.toString());

				in.close();

			}
		} catch (Exception e) {
			System.out.println("Fail envio correo :" + e.getMessage());
			resultadoEnvio = false;
		} finally {
			connection.disconnect();
		}
		return resultadoEnvio;
	}

	private JSONObject generarJsonBody(String correoDniCliente,
			String correoEmisor, String mensajeMod2, String fechaInicioCorreo,
			String fechaFinCorreo, List<EstadoCuentaPdf> estadostwo,
			String numeroDniCorreo,PdfOFSftp Sftp) throws IOException, JSONException,
			DocumentException {

		JSONObject jsonBody = new JSONObject();

		JSONObject jsonToEmail = new JSONObject();
		jsonToEmail.put("email", correoDniCliente);

		List<JSONObject> listTo = new ArrayList<JSONObject>();
		listTo.add(jsonToEmail);

		jsonBody.put("to", listTo);

		JSONObject jsonFrom = new JSONObject();
		jsonFrom.put("email", correoEmisor);
		jsonFrom.put("name", "Banco de la Nacion");

		jsonBody.put("from", jsonFrom);

		JSONObject jsonReplyTo = new JSONObject();
		jsonReplyTo.put("email", correoEmisor);
		jsonReplyTo.put("name", "Banco de la Nacion");

		jsonBody.put("replyTo", jsonReplyTo);

		jsonBody.put("subject", "Banco de la Nacion - Estados de Cuenta");
		jsonBody.put("body", mensajeMod2);

		JSONObject jsonAttachments = new JSONObject();
		/*
		 * jsonAttachments.put("filename", "EstadoCuenta_" + fechaInicioCorreo +
		 * "_" + fechaFinCorreo + "_DNI_" + numeroDniCorreo + ".pdf");
		 */
		jsonAttachments.put("filename",
				"EstadoCuenta_" + fechaInicioCorreo.substring(0, 6) + "_"
						+ fechaFinCorreo.substring(0, 6) + "_DNI_"
						+ numeroDniCorreo + ".pdf");
		// String zipBase64 = PdfOFSftp.getZipPdf(estadostwo);

		// jsonAttachments.put("path", "data:application/zip;base64," +
		// zipBase64);
		String zipBase64 = Sftp.unificarEstadosOnePdf(estadostwo);

		jsonAttachments.put("path", "data:application/pdf;base64," + zipBase64);
		List<JSONObject> listAttachments = new ArrayList<JSONObject>();
		listAttachments.add(jsonAttachments);

		jsonBody.put("attachments", listAttachments);

		return jsonBody;
	}

	private static String generarMensaje(String nombreCliente) {
		String mensaje = "<div><p>Estimado "
				+ nombreCliente
				+ "</p>"
				+ "<p>De acuerdo a tu requerimiento, adjuntamos el Estado de Cuenta de tu Tarjeta de Crédito correspondiente a la fecha de facturación solicitada.</p>"
				+ "<p>Para abrir el archivo adjunto, debes ingresar el número de tu DNI o los 8 últimos números de tu Carnet de Extranjería.</p>"
				+ "<p>Recuerda que solo se emitirán estados de cuenta si el sistema registra algún consumo durante el periodo de facturación correspondiente de tu Tarjeta de Crédito o la de sus Tarjetas Adicionales.</p>"
				+ "<p>Asimismo, puedes consultar los 3 últimos estados de cuenta de tu Tarjeta de Crédito a través de Multired Virtual ingresando: <a href='www.bn.com.pe'>www.bn.com.pe</a>.</p>"
				+ "<p>Para cualquier consulta, reclamo o para el bloqueo de tu tarjeta, puedes comunicarte a nuestra Mesa de Consultas a los números telefónicos (511)442-4470 y 0-800-10-700 o puede acercarse a cualquiera de nuestras Agencias del Banco de la Nación.</p>"
				+ "<p>Atentamente,</p>" + "</div>";

		return mensaje;
	}

	public boolean enviarpdfCompletoEmailSIMM(List<EstadoCuentaPdf> estadostwo,
	        String correoDniCliente, String numeroDniCorreo, String nombre, PdfOFSftp Sftp)
	        throws IOException, DocumentException {

	    log.debug("====INICIO ENVIO EMAIL POR SERVICIO=====", Constant.LOGGER_DEBUG_NIVEL_1);
	    boolean resultadoEnviar = true;

	    try {
	        // -------------CONSUMO SERVICIO SIMM  BN------------------------------------------------
	        log.debug("Configurando el servicio SIMM", Constant.LOGGER_DEBUG_NIVEL_1);
	        ServiceMessageProxy serviceMessage = new ServiceMessageProxy();

	        // Elección de plantilla
	        RequestMessage requestMessage = new RequestMessage();
	        requestMessage.setCodRequermiento(Constante.REQUE_EECC);
	        log.debug("Plantilla seleccionada con código: " + Constante.REQUE_EECC, Constant.LOGGER_DEBUG_NIVEL_1);

	        // Cuerpo correo
	        ReqListMessage rm = new ReqListMessage();

	        // ADJUNTO DATOS DOCUMENTO A ENVIAR
	        Adjunto adjunto = new Adjunto();
	        adjunto.setFlagAdjunto(1);
	        log.debug("Unificando PDFs para adjuntar al correo", Constant.LOGGER_DEBUG_NIVEL_1);
	        adjunto.setDocAdjunto(Sftp.unificarPDFsByte(estadostwo, numeroDniCorreo));

	        rm.setAdjunto(adjunto);

	        // DATOS CORREO A ENTREGAR
	        DatosCorreo datosCorreo = new DatosCorreo();
	        datosCorreo.setAsunto("Banco de la Nacion - Estados de Cuenta");
	        // TODO CORREO LOCAL 
	        datosCorreo.setCorreoDestinatario(correoDniCliente);
	      //  datosCorreo.setCorreoDestinatario("pra_msanchezs@bn.com.pe");
	       //log.debug("Datos del correo configurados: Asunto - " + datosCorreo.getAsunto(), Constant.LOGGER_DEBUG_NIVEL_1);

	        rm.setDatosCorreo(datosCorreo);

	        // PARAMETROS CORREO
	        DatosParametro datosParametro = new DatosParametro();
	        datosParametro.setParametro1(nombre);
	        datosParametro.setParametro5("10");
	        //log.debug("Parámetros del correo configurados: Parametro1 - " + nombre + ", Parametro5 - 10", Constant.LOGGER_DEBUG_NIVEL_1);

	        rm.setDatosParametro(datosParametro);

	        ArrayOfTns1ReqListMessage array = new ArrayOfTns1ReqListMessage();
	        array.getItem().add(rm);
	        requestMessage.setReqListMessage(array);

	        // Enviando el mensaje
	        log.debug("Enviando el mensaje al servicio SIMM", Constant.LOGGER_DEBUG_NIVEL_1);
	        serviceMessage.sendMessageAsync(requestMessage);

	        // ---------------FIN CONSUMO SERVICIO----------------------
	        log.debug("====FIN ENVIO EMAIL POR SERVICIO=====", Constant.LOGGER_DEBUG_NIVEL_1);
	    } catch (IOException | DocumentException e) {
	        log.error(e, "Error durante el envío del correo por el servicio SIMM:");
	        resultadoEnviar = false;
	    }

	    return resultadoEnviar;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public String getTokenBearerWS() {
		return tokenBearerWS;
	}

	public void setTokenBearerWS(String tokenBearerWS) {
		this.tokenBearerWS = tokenBearerWS;
	}

	public String getCorreoEmisor() {
		return correoEmisor;
	}

	public void setCorreoEmisor(String correoEmisor) {
		this.correoEmisor = correoEmisor;
	}

	public String getMensajeMod() {
		return mensajeMod;
	}

	public void setMensajeMod(String mensajeMod) {
		this.mensajeMod = mensajeMod;
	}

	public boolean enviarCorreoVal(String correoCliente) {
	    boolean resultadoEnvio = true;
	    HttpURLConnection connection = null;

	    try {
	        connection = (HttpURLConnection) url.openConnection();
	        connection.setConnectTimeout(20000);
	        connection.setRequestMethod("POST");
	        // TODO: TOKEN 
	        connection.setRequestProperty("Authorization", "Bearer " + tokenBearerWS);
	        //String token ="78d0f0ba.8d264b6c9ce5511ed197f908";
	        //connection.setRequestProperty("Authorization", "Bearer " + token);
	        connection.setRequestProperty("Content-Type", "application/json");
	        connection.setDoOutput(true);

	        JSONObject json = generarJsonBodyOTP(correoCliente, correoEmisor);

	        OutputStream os = connection.getOutputStream();
	        OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
	        osw.write(json.toString());
	        osw.flush();
	        osw.close();

	        int statusCode = connection.getResponseCode();

	        if (statusCode == HttpURLConnection.HTTP_OK) {
	            // Leer la respuesta del servidor
	            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	            String inputLine;
	            StringBuilder response = new StringBuilder();

	            while ((inputLine = in.readLine()) != null) {
	                response.append(inputLine);
	            }

	            System.out.println("Respuesta del servicio: " + response.toString());
	            in.close();
	        } else {
	            resultadoEnvio = false;
	            // Capturar el cuerpo del error
	            InputStream errorStream = connection.getErrorStream();
	            if (errorStream != null) {
	                BufferedReader errorReader = new BufferedReader(new InputStreamReader(errorStream));
	                String inputLine;
	                StringBuilder errorResponse = new StringBuilder();

	                while ((inputLine = errorReader.readLine()) != null) {
	                    errorResponse.append(inputLine);
	                }

	                System.out.println("Error del servicio: " + errorResponse.toString());
	                errorReader.close();
	            } else {
	                System.out.println("Error del servicio: Código de estado " + statusCode);
	            }
	        }
	    } catch (Exception e) {
	        // Imprime el stack trace del error
	        System.out.println("Fallo en el envío del correo: " + e.getMessage());
	        e.printStackTrace();
	        resultadoEnvio = false;
	    } finally {
	        if (connection != null) {
	            connection.disconnect();
	        }
	    }

	    return resultadoEnvio;
	}


	private JSONObject generarJsonBodyOTP(String correoCliente, String correoEmisor) throws IOException, JSONException, DocumentException {

	    JSONObject jsonBodyOTP = new JSONObject();

	    // Campo "to"
	    List<JSONObject> listTo = new ArrayList<>();
	    JSONObject jsonTo = new JSONObject();
	    jsonTo.put("email", correoCliente);
	    listTo.add(jsonTo);
	    jsonBodyOTP.put("to", listTo);
	    
	    // Campo "options"
	     
	     
	    JSONObject jsonOptions = new JSONObject();
	    List<JSONObject> listacc = new ArrayList<>();
	    JSONObject tempo = new JSONObject();
	    tempo.put("email", "prestamomultiredcc@bn.com.pe");  	    
	    listacc.add(tempo);
	    jsonOptions.put("cc", listacc);
	    jsonBodyOTP.put("options", jsonOptions);

	    //TODO:  Campo "from"
	    JSONObject jsonFrom = new JSONObject();
	    jsonFrom.put("email", "notificaciones@bn.com.pe");
	    jsonFrom.put("name", "Banco de la Nacion");
	    jsonBodyOTP.put("from", jsonFrom);

	    // Campo "replyTo"
	    JSONObject jsonReplyTo = new JSONObject();
	    jsonReplyTo.put("email", "notificaciones@bn.com.pe");
	    jsonReplyTo.put("name", "Banco de la Nacion");
	    jsonBodyOTP.put("replyTo", jsonReplyTo);

	    // Campo "subject"
	    jsonBodyOTP.put("subject", "Prestamos Multired via Red de Agencias");

	    // Campo "body"
	   // String mensajeMod = "hola"; 
	    jsonBodyOTP.put("body", mensajeMod);

	    // Campo "attachments"
	    List<JSONObject> listAttachments = new ArrayList<>();
	    jsonBodyOTP.put("attachments", listAttachments);
	    
        System.out.println(jsonBodyOTP.toString(4));
	    return jsonBodyOTP;
	}

	public boolean enviarPDF(String correoCliente, String pdf, String num) {
	    boolean resultadoEnvio = true;
	    HttpURLConnection connection = null;

	    try {
	        connection = (HttpURLConnection) url.openConnection();
	        connection.setConnectTimeout(20000);
	        connection.setRequestMethod("POST");
	        // TODO: TOKEN 
	        connection.setRequestProperty("Authorization", "Bearer " + tokenBearerWS);
	        //String token ="78d0f0ba.8d264b6c9ce5511ed197f908";
	       // connection.setRequestProperty("Authorization", "Bearer " + token);
	        connection.setRequestProperty("Content-Type", "application/json");
	        connection.setDoOutput(true);

	        JSONObject json = generarJsonBodyPDF(correoCliente, pdf, num);

	        OutputStream os = connection.getOutputStream();
	        OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
	        osw.write(json.toString());
	        osw.flush();
	        osw.close();

	        int statusCode = connection.getResponseCode();

	        if (statusCode == HttpURLConnection.HTTP_OK) {
	            // Leer la respuesta del servidor
	            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	            String inputLine;
	            StringBuilder response = new StringBuilder();

	            while ((inputLine = in.readLine()) != null) {
	                response.append(inputLine);
	            }

	            System.out.println("Respuesta del servicio: " + response.toString());
	            in.close();
	        } else {
	            resultadoEnvio = false;
	            // Capturar el cuerpo del error
	            InputStream errorStream = connection.getErrorStream();
	            if (errorStream != null) {
	                BufferedReader errorReader = new BufferedReader(new InputStreamReader(errorStream));
	                String inputLine;
	                StringBuilder errorResponse = new StringBuilder();

	                while ((inputLine = errorReader.readLine()) != null) {
	                    errorResponse.append(inputLine);
	                }

	                System.out.println("Error del servicio: " + errorResponse.toString());
	                errorReader.close();
	            } else {
	                System.out.println("Error del servicio: Código de estado " + statusCode);
	            }
	        }
	    } catch (Exception e) {
	        // Imprime el stack trace del error
	        System.out.println("Fallo en el envío del correo: " + e.getMessage());
	        e.printStackTrace();
	        resultadoEnvio = false;
	    } finally {
	        if (connection != null) {
	            connection.disconnect();
	        }
	    }

	    return resultadoEnvio;
	}

	private JSONObject generarJsonBodyPDF(String correoCliente, String pdf, String num) throws IOException, JSONException, DocumentException {

	    JSONObject jsonBodyPDF = new JSONObject();

	    // Campo "to"
	    List<JSONObject> listTo = new ArrayList<>();
	    JSONObject jsonTo = new JSONObject();
	    jsonTo.put("email", correoCliente);
	    listTo.add(jsonTo);
	    jsonBodyPDF.put("to", listTo);
	    
	    // Campo "options"
	     
	     
	    JSONObject jsonOptions = new JSONObject();
	    List<JSONObject> listacc = new ArrayList<>();
	    JSONObject tempo = new JSONObject();
	    tempo.put("email", "prestamomultiredcc@bn.com.pe");  	    
	    listacc.add(tempo);
	    jsonOptions.put("cc", listacc);
	    jsonBodyPDF.put("options", jsonOptions);

	    //TODO:  Campo "from"
	    JSONObject jsonFrom = new JSONObject();
	    jsonFrom.put("email", "notificaciones@bn.com.pe");
	    jsonFrom.put("name", "Banco de la Nacion");
	    jsonBodyPDF.put("from", jsonFrom);

	    // Campo "replyTo"
	    JSONObject jsonReplyTo = new JSONObject();
	    jsonReplyTo.put("email", "notificaciones@bn.com.pe");
	    jsonReplyTo.put("name", "Banco de la Nacion");
	    jsonBodyPDF.put("replyTo", jsonReplyTo);

	    // Campo "subject"
	    jsonBodyPDF.put("subject", "Prestamos Multired via Red de Agencias");

	    // Campo "body"
	   // String mensajeMod = "hola"; 
	    jsonBodyPDF.put("body", mensajeMod);

	    
	    JSONObject jsonAttachments = new JSONObject();
	 
		jsonAttachments.put("filename", "FORM_35/Prestamo_Multired_"+num+".pdf");
	 
		jsonAttachments.put("path", "data:application/pdf;base64," + pdf);
		List<JSONObject> listAttachments = new ArrayList<JSONObject>();
		listAttachments.add(jsonAttachments);

		jsonBodyPDF.put("attachments", listAttachments);	    
	       
        System.out.println(jsonBodyPDF.toString(4));
	    return jsonBodyPDF;
	}
}
