package pe.com.bn.modc.services.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.entity.StringEntity;
import org.json.JSONException;
import org.json.JSONObject;

import com.itextpdf.text.DocumentException;

import pe.com.bn.modc.common.Constant;
import pe.com.bn.modc.common.Constante;
import pe.com.bn.modc.common.LoggerEECC;
import pe.com.bn.modc.dao.impl.ConsultaEmailCliente;
import pe.com.bn.modc.listener.PdfOFSftp;
import pe.com.bn.modc.model.EstadoCuentaPdf;
import www.bn.simm.ws.open.bean.Adjunto;
import www.bn.simm.ws.open.bean.DatosCorreo;
import www.bn.simm.ws.open.bean.DatosParametro;
import www.bn.simm.ws.open.bean.ReqListMessage;
import www.bn.simm.ws.open.bean.RequestMessage;
import www.bn.simm.ws.open.bean.ResponseMessage;
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

}
