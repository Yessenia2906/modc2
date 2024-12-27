package pe.com.bn.modc.controller;

import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.bn.modc.common.Constant;
import pe.com.bn.modc.common.Constante;

import pe.com.bn.modc.common.LoggerEECC;

import pe.com.bn.modc.common.View;
import pe.com.bn.modc.config.CustomUser;

import pe.com.bn.modc.dao.impl.ConsultaEmailCliente;
import pe.com.bn.modc.dao.impl.ConsultaEstadosCuenta;
import pe.com.bn.modc.dao.inte.EstadosCuentaDAO;
import pe.com.bn.modc.dao.inte.IntLogAuditoria;
import pe.com.bn.modc.dao.pool.SftpConnectionPool;
import pe.com.bn.modc.exceptions.ExternalException;
import pe.com.bn.modc.exceptions.FtpException;
import pe.com.bn.modc.exceptions.ParametrosCompException;
import pe.com.bn.modc.exceptions.PersistenciaException;

import pe.com.bn.modc.listener.CompService;
import pe.com.bn.modc.listener.PdfOFSftp;

import pe.com.bn.modc.model.AudiLog;
import pe.com.bn.modc.model.EstadoCuentaPdf;
import pe.com.bn.modc.model.ModcError;
import pe.com.bn.modc.model.ParametrosComp;
import pe.com.bn.modc.services.inte.ServiceEnvioEmail;
import pe.com.bn.modc.services.inte.ServiceSFTP;


@Controller
public class EstadoCuentaController {

	private static LoggerEECC log = LoggerEECC
			.getInstance(EstadoCuentaController.class.getName());

	@Autowired
	private CompService compService;

	@Autowired
	private ParametrosComp parametrosComp;

	@Autowired
	private IntLogAuditoria LogAuditoria;

	@Autowired
	private EstadosCuentaDAO estadosCuentaDAO;
	@Autowired
	private ServiceEnvioEmail serviceEnvioEmail;
	@Autowired
	private ServiceSFTP serviceSFTP;

	@RequestMapping("estadocuenta")
	public String estadoCuenta(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		String path = "";
		path = View.returnJsp(model, "tarjeta/estadoCuenta");
		boolean respuestaProceso = false;
		try {
					compService.asignarParametros();
			   // TODO inicio del pool de conexiones
					SftpConnectionPool.initialize(10, parametrosComp.getStfpHost(), Integer.parseInt(parametrosComp.getStfpPort()),
							parametrosComp.getStfpUsername(), parametrosComp.getStfpPassword());
				} catch (NumberFormatException e) {
					log.error(e, Constante.CT_ERR_INTERNO+"-"+Constante.ERROR_MAP.get(Constante.CT_ERR_INTERNO));
					request.setAttribute("msje", Constante.CT_ERR_INTERNO+"-"
							+ Constante.CT_ERR_USUARIO);
					request.setAttribute("respuesta", respuestaProceso);
				} catch (ParametrosCompException | ExternalException e) {
					log.error(new Exception(e.getCause()), Constante.CT_ERR_FTP+"-"+Constante.ERROR_MAP.get(Constante.CT_ERR_FTP));
					request.setAttribute("msje", e.getMessage()+"-"	+ Constante.CT_ERR_USUARIO);
					request.setAttribute("respuesta", respuestaProceso);
				}
	        
		return path;
	}

	@RequestMapping("buscarestadopdf")
	public String buscarEstadoPdf(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	    long inicio = System.currentTimeMillis();
	    log.debug("=====>INICIO METODO BUSCAR ESTADOS DE CUENTA", Constant.LOGGER_DEBUG_NIVEL_1);

	    boolean respuestaProceso = false;
	    String path = View.returnJsp(model, "tarjeta/estadoCuenta");

	    CustomUser usuario = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    log.debug("Usuario autenticado: " + usuario.getUsername(), Constant.LOGGER_DEBUG_NIVEL_1);

	    String dniCliente = request.getParameter("numeroDniTarjeta");
	    String AgeCorteInicio = request.getParameter("selectAgeCorteInicio");
	    String MesCorteInicio = request.getParameter("selectMesCorteInicio");
	    String DiaCorteInicio = "01";
	    String FechaCorteInicial = AgeCorteInicio + MesCorteInicio + DiaCorteInicio;

	    String AgeCorte = request.getParameter("selectAgeCorte");
	    String MesCorte = request.getParameter("selectMesCorte");
	    String DiaCorte = " "; // `01 - DD `
	    try {
	        Integer ageTem = Integer.parseInt(AgeCorte);
	        DiaCorte = (ageTem % 4 == 0) ? "29" : "28";
	        log.debug("Fecha de corte fin calculada: " + DiaCorte, Constant.LOGGER_DEBUG_NIVEL_1);
	    } catch (Exception e) {
	        log.error(e, Constante.CT_ERR_INTERNO + "-" + e.getMessage());
	        request.setAttribute("msje", Constante.CT_ERR_INTERNO + "-" + Constante.CT_ERR_USUARIO);
	        request.setAttribute("respuesta", respuestaProceso);
	        log.debug("Error calculando fecha de corte fin", Constant.LOGGER_DEBUG_NIVEL_1);
	        return path;
	    }

	    String FechaCorteFin = AgeCorte + MesCorte + DiaCorte; // `20141101`

	    request.setAttribute("dniCliente", dniCliente);
	    request.setAttribute("fechacorteInicio", FechaCorteInicial);
	    request.setAttribute("fechacorteFin", FechaCorteFin);

	    try {
	        log.debug("Consultando estados de cuenta para DNI: " + dniCliente, Constant.LOGGER_DEBUG_NIVEL_1);
	        List<EstadoCuentaPdf> estadosSinArchivoPdf = estadosCuentaDAO.getEstadosName(FechaCorteInicial, FechaCorteFin, dniCliente);
	        log.debug("Consulta de estados de cuenta completada", Constant.LOGGER_DEBUG_NIVEL_1);

	        LogAuditoria.saveAudiLog(usuario, new AudiLog(
	                Constant.MSJ_BUSQUEDA_EECC + "[" + FechaCorteInicial + "-" + FechaCorteFin + "]", dniCliente));
	        log.debug("Registro de auditoría completado", Constant.LOGGER_DEBUG_NIVEL_1);

	        String mensaje = "";
	        if (!estadosSinArchivoPdf.isEmpty()) {
	            request.setAttribute("estados", estadosSinArchivoPdf);
	            request.getSession().setAttribute("estadoauxilio", estadosSinArchivoPdf); // GUARDANDO LISTA EECC EN SESSION SIN PDF
	            mensaje = "Exito buscando EECC";
	            respuestaProceso = true;
	            log.debug("Estados de cuenta encontrados y almacenados en sesión", Constant.LOGGER_DEBUG_NIVEL_1);
	        } else {
	            mensaje = "El DNI: " + dniCliente + " no presenta estados de cuenta desde " + MesCorteInicio + "/" + AgeCorteInicio + " hasta la fecha " + MesCorte + "/" + AgeCorte;
	            log.debug("No se encontraron estados de cuenta para el rango de fechas especificado", Constant.LOGGER_DEBUG_NIVEL_1);
	        }
	        request.setAttribute("msje", mensaje);
	        request.setAttribute("respuesta", respuestaProceso);

	        long fin = System.currentTimeMillis();
	        long duracion = fin - inicio;
	        double duracionsegundos = duracion / 1000.0;

	        log.debug("El aplicativo se demoró " + duracionsegundos + " segundos en buscar los pdfs en la BD", Constant.LOGGER_DEBUG_NIVEL_1);
	        log.debug("=====>FIN METODO BUSCAR ESTADOS DE CUENTA", Constant.LOGGER_DEBUG_NIVEL_1);
	    } catch (PersistenciaException e) {
	        log.error(e, e.getMessage()+"-"+Constante.ERROR_MAP.get(e.getMessage()));
	        request.setAttribute("msje", e.getMessage() + "-" + Constante.CT_ERR_USUARIO);
	        request.setAttribute("respuesta", respuestaProceso);
	        return path;
	    }

	    return path;
	}

	@RequestMapping(value = "buscarestadopdf/pdf", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> ObtenerPdf(@RequestBody String nombrearchivo,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();

		log.debug(
				"=====>INICIO METODO BUSCAR ESTADOS DE CUENTA INDIVIDUAL",
				Constant.LOGGER_DEBUG_NIVEL_1);

		long inicio = System.currentTimeMillis();

		List<EstadoCuentaPdf> eeccsinpdf = (List<EstadoCuentaPdf>) request
				.getSession().getAttribute("estadoauxilio");

		Map<String, String> respuesta = new HashMap<String, String>();
		respuesta.put("fileName", "Estado_" + nombrearchivo);

		EstadoCuentaPdf eeccwithpdf = null;
		String cadenaSinUltimos4 = nombrearchivo.substring(0,
				nombrearchivo.length() - 4);
		for (EstadoCuentaPdf estadoCuentaPdf : eeccsinpdf) {
			String temporal = estadoCuentaPdf.getNombrearchivo();

			if (temporal.startsWith(cadenaSinUltimos4)) {
				eeccwithpdf = estadoCuentaPdf;
				break;
			}
		}
		if (eeccwithpdf != null) {

			eeccwithpdf = serviceSFTP.ObtenerEECCindividual(eeccwithpdf);

		} else {
			respuesta.put("base64Content", " ");
			return respuesta;
		}

		// Verificar si el usuario tiene el rol 'ROLE_04'
		boolean rol04 = false;
		for (GrantedAuthority authority : authentication.getAuthorities()) {
			if (authority.getAuthority().equals("ROLE_04")) {
				rol04 = true;
				break;
			}
		}

		if (rol04) {
			// solo ver
			respuesta.put("base64Content", eeccwithpdf.getBase64res());

		} else {
			// descargar y ver
			respuesta.put("base64Content", eeccwithpdf.getBase64());
		}

		long fin = System.currentTimeMillis();
		long duracion = fin - inicio;
		double duracionsegundos = duracion / 1000.0;
		log.debug("El aplicativo se demoro " + duracionsegundos
				+ " segundos en traer el pdf del SFTP", "1");
		log.debug(
				"=====>FIN METODO BUSCAR ESTADOS DE CUENTA INDIVIDUAL",
				Constant.LOGGER_DEBUG_NIVEL_1);

		return respuesta;
	}

	@RequestMapping("enviarestadopdfcorreo")
	public String enviarEstadoPdfCorreo(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
	    long inicio = System.currentTimeMillis();
	    String path = View.returnJsp(model, "tarjeta/estadoCuenta");
	    log.debug("=====>INICIO ENVIO POR CORREO EECC", Constant.LOGGER_DEBUG_NIVEL_1);

	    CustomUser usuario = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal(); // USUARIO EN LINEA
	    log.debug("Usuario autenticado: " + usuario.getUsername(), Constant.LOGGER_DEBUG_NIVEL_1);

	    List<EstadoCuentaPdf> attributeOne = (List<EstadoCuentaPdf>) request.getSession().getAttribute("estadoauxilio");
	    List<EstadoCuentaPdf> attribute = new ArrayList<>();

	    // DATOS PARA EL ENVIO DE EECC POR CORREO
	    String numeroDniCorreo = request.getParameter("numeroDniTarjeta");
	    String correoDniCliente = request.getParameter("correoCliente");
	    String eeccEnviar = request.getParameter("eeccEnviar");

	    log.debug("Parametros recibidos - DNI: " + numeroDniCorreo + ", Correo: " + correoDniCliente, Constant.LOGGER_DEBUG_NIVEL_1);

	    String[] listaPdfSelccionados = eeccEnviar.split("\\|");

	    for (EstadoCuentaPdf eecc : attributeOne) {
	        for (String namepdf : listaPdfSelccionados) {
	            if (eecc.getNombrearchivo().equals(namepdf)) {
	                attribute.add(eecc);
	                continue;
	            }
	        }
	    }

	    String estadoCorreoEnvio = "Error envio de correo";
	    List<EstadoCuentaPdf> eeccEnviarWS;

	    try {
	        log.debug("Obteniendo estados de cuenta para envío", Constant.LOGGER_DEBUG_NIVEL_1);
	        eeccEnviarWS = serviceSFTP.ObtenerEstadosCuenta(attribute);
	        log.debug("Estados de cuenta obtenidos para envío: " + eeccEnviarWS.size(), Constant.LOGGER_DEBUG_NIVEL_1);

	        LogAuditoria.saveAudiLog(usuario, new AudiLog(Constant.MSJ_ENVIO_CORREO + attribute.size() + " EECC", numeroDniCorreo));
	        log.debug("Registro de auditoría completado", Constant.LOGGER_DEBUG_NIVEL_1);

	        boolean resultado = false;
	        if (eeccEnviarWS != null) {
	            log.debug("EECC A ENVIAR: " + attribute.size(), Constant.LOGGER_DEBUG_NIVEL_1);
	            resultado = serviceEnvioEmail.enviarZipToEmail(numeroDniCorreo, correoDniCliente, eeccEnviarWS, parametrosComp);
	        }

	        if (resultado) {
	            estadoCorreoEnvio = "El correo fue enviado exitosamente";
	            log.debug("Correo enviado exitosamente", Constant.LOGGER_DEBUG_NIVEL_1);
	        }

 
	        request.getSession().removeAttribute("estadoauxilio"); // ELIMINADO LISTA DE EECC DE LA SESSION
	        log.debug("Lista de EECC eliminada de la sesión", Constant.LOGGER_DEBUG_NIVEL_1);
	        long fin = System.currentTimeMillis();
	        long duracion = fin - inicio;
	        double duracionsegundos = duracion / 1000.0;
	        log.debug("El aplicativo se demoro " + duracionsegundos + " segundos en enviar el correo al cliente", "1");

	        log.debug("=====>FIN ENVIO POR CORREO EECC", Constant.LOGGER_DEBUG_NIVEL_1);
	    
	        model.addAttribute("estadoCorreoEnvio", estadoCorreoEnvio);
	        return path;
	    } catch (FtpException | ExternalException e) {
	        log.error(e, "Error durante el envío por correo: " + e.getMessage());
	        request.setAttribute("msje", e.getMessage() + Constante.CT_ERR_USUARIO);
	        request.setAttribute("respuesta", false);
	        return path;
	    }
	}

	@RequestMapping("log")
	public String logAuditoria(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		List<AudiLog> contenlog = new ArrayList<AudiLog>();
		request.setAttribute("contenlog", contenlog);
		request.setAttribute("first", "first"); 
		String path = View.returnJsp(model, "tarjeta/log");
		return path;
	}

	@RequestMapping("filterlog")
	public String logAuditoriaFiltro(ModelMap model,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException {
		List<AudiLog> contenlog = new ArrayList<AudiLog>();
		String path = View.returnJsp(model, "tarjeta/log");
		String opcion = request.getParameter("opt");

		int opcionint = Integer.parseInt(opcion);
		switch (opcionint) {
		case 1:
			String forDni = request.getParameter("forDni");
			contenlog = LogAuditoria.forDni(forDni);
			break;
		case 2:
			String forFechaInicio = request.getParameter("forFechaInicio");
			String forFechaFin = request.getParameter("forFechaFin");
			contenlog = LogAuditoria.forFechas(forFechaInicio, forFechaFin);

			break;
		case 3:
			String forDia = request.getParameter("forDia");
			contenlog = LogAuditoria.forDia(forDia);

			break;
		case 4:
			contenlog = LogAuditoria.showLog();
			break;
		default:
			return path;
		}

		request.setAttribute("contenlog", contenlog);

		return path;
	}

	// SERVICIO OBTENER CORREO CLIENTE
	@RequestMapping(value = "/getEmail/{dni}", method = RequestMethod.GET)
	@ResponseBody
	public String getDoctorsBySpecialty(@PathVariable String dni)
			throws IOException, JSONException {
		CustomUser usuario = (CustomUser) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		String email = serviceEnvioEmail.getEmailDni(dni, parametrosComp).get(
				"email");

		String json = "{ \"email\": \"" + email + "\" }";
		LogAuditoria.saveAudiLog(usuario, new AudiLog(
				Constant.MSJ_BUSQUEDA_CORREO, dni));
		return json;
	}

}
