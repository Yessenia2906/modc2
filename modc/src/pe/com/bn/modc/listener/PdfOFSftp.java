package pe.com.bn.modc.listener;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;

import pe.com.bn.modc.common.Constant;
import pe.com.bn.modc.common.Constante;
import pe.com.bn.modc.common.LoggerEECC;
import pe.com.bn.modc.dao.inte.EstadosCuentaDAO;
import pe.com.bn.modc.dao.pool.SftpConnectionPool;
import pe.com.bn.modc.exceptions.ExternalException;
import pe.com.bn.modc.exceptions.FtpException;
import pe.com.bn.modc.model.EstadoCuentaPdf;
import pe.com.bn.modc.model.ParametrosComp;
import pe.com.bn.modc.model.SftpConnection;
import pe.com.bn.modc.services.inte.ServiceSFTP;

@Service
public class PdfOFSftp implements ServiceSFTP {

	private LoggerEECC log = LoggerEECC.getInstance(PdfOFSftp.class.getName());

	@Autowired
	private EstadosCuentaDAO estadosCuentaDAO;
	@Autowired
	private ParametrosComp parametrosComp;

	private final Map<String, String> mapaMeses = new HashMap<String, String>();

	{
		// Agregar los meses al mapa
		mapaMeses.put("01", "ENE");
		mapaMeses.put("02", "FEB");
		mapaMeses.put("03", "MAR");
		mapaMeses.put("04", "ABR");
		mapaMeses.put("05", "MAY");
		mapaMeses.put("06", "JUN");
		mapaMeses.put("07", "JUL");
		mapaMeses.put("08", "AGO");
		mapaMeses.put("09", "SET");
		mapaMeses.put("10", "OCT");
		mapaMeses.put("11", "NOV");
		mapaMeses.put("12", "DIC");

	}

	@PostConstruct
	public void init() {
		// TODO Descomentar para obtener el log de la conexion
		//JSch.setLogger(new JSchLogger());
	}

	@Override
	public EstadoCuentaPdf ObtenerEECCindividual(EstadoCuentaPdf estadoCuentaPdf) {
		log.debug("***********INICIO OBTENCION DE EECC DE FTP************",
				Constant.LOGGER_DEBUG_NIVEL_1);
		
		String remoteFolder = parametrosComp.getStfpRemotepath();

		

		SftpConnectionPool pool = null;
	    SftpConnection connection = null;
	    ChannelSftp sftpChannel = null;
		try {
			log.debug("Configurando la conexión SFTP",
					Constant.LOGGER_DEBUG_NIVEL_1);

	        // Obtener la instancia del pool
	        pool = SftpConnectionPool.getInstance();

	        // Obtener una conexión del pool
	        connection = pool.getConnection();
	        sftpChannel = connection.getChannel();


			log.debug(
					"EECC A TRAER DE FTP ===> "
							+ estadoCuentaPdf.getNombrearchivo(),
					Constant.LOGGER_DEBUG_NIVEL_1);
			String fileName = estadoCuentaPdf.getNombrearchivo();
			String ruta = remoteFolder + "/" + estadoCuentaPdf.getAge()
					+ "_ELE_FIS/" + mapaMeses.get(estadoCuentaPdf.getMes())
					+ estadoCuentaPdf.getAge() + "_ELEC_FIS/"
					+ estadoCuentaPdf.getDia()
					+ mapaMeses.get(estadoCuentaPdf.getMes())
					+ estadoCuentaPdf.getAge() + "_ELEC_FIS/"
					+ estadoCuentaPdf.getTipo();

			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

			log.debug("Cambiando al directorio remoto: " + ruta,
					Constant.LOGGER_DEBUG_NIVEL_1);
			// sftpChannel.cd(ruta);

			log.debug("Descargando el archivo: " + fileName,
					Constant.LOGGER_DEBUG_NIVEL_1);
			sftpChannel.get(ruta + "/" + fileName, outputStream);
			byte[] fileContent = outputStream.toByteArray();

			estadoCuentaPdf.setPdf(fileContent);
			estadoCuentaPdf.setBase64res(aplicacionRestriccionPdf(fileContent));

			log.debug("Archivo descargado y procesado correctamente",
					Constant.LOGGER_DEBUG_NIVEL_1);

		}catch (SftpException e) {
	        log.error(e, "Error al obtener archivo SFTP: ");
	    } catch (IOException | DocumentException e) {
	        log.error(e, "Error procesando el archivo PDF: ");
	    } catch (InterruptedException e) {
	        log.error(e, "Error al obtener la conexión SFTP del pool: ");
	    } catch (ExternalException e) {
	    	log.error(e, Constante.ERROR_MAP.get(Constante.CT_ERR_FTP));
		} finally {
	        if (connection != null) {
	            pool.releaseConnection(connection);
	            log.debug("Conexión SFTP devuelta al pool", "1");
	        }
	    }


		log.debug("***********FIN OBTENCION DE EECC DE FTP************",
				Constant.LOGGER_DEBUG_NIVEL_1);
		return estadoCuentaPdf;
	}

	@Override
	public List<EstadoCuentaPdf> ObtenerEstadosCuenta(List<EstadoCuentaPdf> eecc)
	        throws FtpException, ExternalException {

	    log.debug("***********INICIO OBTENCION DE EECC DE FTP************", Constant.LOGGER_DEBUG_NIVEL_1);
	    String remoteFolder = parametrosComp.getStfpRemotepath();
	    SftpConnectionPool pool = null;
	    SftpConnection connection = null;
	    ChannelSftp sftpChannel = null;

	    try {
	        pool = SftpConnectionPool.getInstance();
	        connection = pool.getConnection();
	        sftpChannel = connection.getChannel();
	        log.debug("EECC A TRAER DE FTP ===> " + eecc.size(), Constant.LOGGER_DEBUG_NIVEL_1);
	        Iterator<EstadoCuentaPdf> iterator = eecc.iterator();
	        while (iterator.hasNext()) {
	            EstadoCuentaPdf estadoCuentaPdf = iterator.next();
	            String fileName = estadoCuentaPdf.getNombrearchivo();
	            String ruta = remoteFolder + "/" + estadoCuentaPdf.getAge() + "_ELE_FIS/" +
	                    mapaMeses.get(estadoCuentaPdf.getMes()) + estadoCuentaPdf.getAge() + "_ELEC_FIS/" +
	                    estadoCuentaPdf.getDia() + mapaMeses.get(estadoCuentaPdf.getMes()) + estadoCuentaPdf.getAge() +
	                    "_ELEC_FIS/" + estadoCuentaPdf.getTipo();

	            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	            try {
	                sftpChannel.cd(ruta);
	                sftpChannel.get(fileName, outputStream);
	                byte[] fileContent = outputStream.toByteArray();
	                estadoCuentaPdf.setPdf(fileContent);
	                estadoCuentaPdf.setBase64res(aplicacionRestriccionPdf(fileContent));
	                log.debug("Archivo descargado: " + fileName, Constant.LOGGER_DEBUG_NIVEL_1);
	            } catch (SftpException e) {
	                log.error(e,"No se pudo encontrar o descargar el archivo: " + fileName + " en la ruta: " + ruta);
	                iterator.remove(); // Eliminar de la lista si no se encuentra el archivo
	            } catch (IOException | DocumentException e) {
	                log.error(e,"Error procesando el archivo PDF: " + fileName);
	                throw new FtpException(Constante.CT_ERR_INTERNO, e);
	            }
	        }
	        if (!eecc.isEmpty()) {
	            log.debug("EXITO TRAYENDO EECC DE FTP ===> " + eecc.size(), Constant.LOGGER_DEBUG_NIVEL_1);
	        }
	        log.debug("***********FIN OBTENCION DE EECC DE FTP************", Constant.LOGGER_DEBUG_NIVEL_1);
	    } catch (InterruptedException e) {
	        log.error(e,Constante.ERROR_MAP.get(Constante.CT_ERR_FTP));
	        throw new ExternalException(Constante.CT_ERR_FTP, e);
	    } finally {
	        if (connection != null) {
	            pool.releaseConnection(connection);
	            log.debug("Conexión SFTP devuelta al pool", "1");
	        }
	    }
	    return eecc;
	}

	private String aplicacionRestriccionPdf(byte[] pdfBytes)
			throws IOException, DocumentException {

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		PdfReader reader = new PdfReader(new ByteArrayInputStream(pdfBytes));
		PdfStamper stamper = new PdfStamper(reader, outputStream);

		// Establecer los permisos para evitar la impresión y la descarga
		int permisos = 0; // Sin permisos
		stamper.setEncryption(null, null, permisos,
				PdfWriter.ENCRYPTION_AES_128);

		// Establecer restricciones de impresión y descarga
		stamper.setViewerPreferences(PdfWriter.HideMenubar);
		stamper.close();
		return Base64Utils.encodeToString(outputStream.toByteArray());
	}

	public String getZipPdf(List<EstadoCuentaPdf> estadostwo)
			throws IOException {
		// Lista de PDF en formato base 64
		// Crear archivo zip
		ByteArrayOutputStream zipOutputStream = new ByteArrayOutputStream();
		ZipOutputStream zip = new ZipOutputStream(zipOutputStream);

		// Agregar los PDF al archivo zip
		for (EstadoCuentaPdf pdfBase64 : estadostwo) {
			ZipEntry entry = new ZipEntry("EstadoCuenta_" + pdfBase64.getDni()
					+ "_" + pdfBase64.getFecha() + ".pdf");
			zip.putNextEntry(entry);

			// Decodificar el PDF base 64
			byte[] pdfBytes = Base64Utils.decodeFromString(pdfBase64
					.getBase64());

			// Agregar el PDF al archivo zip
			zip.write(pdfBytes);
		}
		// Establecer la contraseña del archivo zip
		zip.setMethod(ZipOutputStream.DEFLATED);
		zip.setComment(estadostwo.get(0).getDni());
		// cerrar Stream del ZIP
		zip.close();
		// Obtener archivo zip
		byte[] zipBytes = zipOutputStream.toByteArray();
		String zipBase64 = Base64Utils.encodeToString(zipBytes);
		return zipBase64;
	}

	// UNIFICAR ESTADOS PDF
	public String unificarEstadosOnePdf(List<EstadoCuentaPdf> estadostwo)
			throws IOException, DocumentException {

		List<byte[]> listaArchivosPDF = new ArrayList<byte[]>();

		for (EstadoCuentaPdf estadoCuentaPdf : estadostwo) {
			listaArchivosPDF.add(estadoCuentaPdf.getPdf());
		}

		// Unificar los PDFs
		byte[] pdfUnificadoBytes = unificarPDFs(listaArchivosPDF);

		String pdfUnificadoBase64 = convertirABase64(pdfUnificadoBytes);

		return pdfUnificadoBase64;
	}

	private String convertirABase64(byte[] bytes) {
		return Base64Utils.encodeToString(bytes);
	}

	private byte[] unificarPDFs(List<byte[]> listaArchivosPDF)
			throws IOException, DocumentException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Document document = new Document();
		PdfCopy copy = new PdfCopy(document, baos);

		document.open();
		try {
			for (byte[] pdfBytes : listaArchivosPDF) {
				PdfReader reader = new PdfReader(pdfBytes);
				int numberOfPages = reader.getNumberOfPages();

				for (int page = 1; page <= numberOfPages; page++) {
					copy.addPage(copy.getImportedPage(reader, page));
				}

				reader.close();
			}
		} catch (DocumentException e) {
			log.error(e, "ERROR AL UNIFICAR EL ARCHIVO PDF ");
		} finally {
			document.close();
		}

		return baos.toByteArray();
	}

	public byte[] unificarPDFsByte(List<EstadoCuentaPdf> listaArchivos,
			String numeroDniCorreo) throws IOException, DocumentException {

		List<byte[]> listaArchivosPDF = new ArrayList<byte[]>();

		for (EstadoCuentaPdf estadoCuentaPdf : listaArchivos) {
			listaArchivosPDF.add(estadoCuentaPdf.getPdf());
		}

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		Document document = new Document();
		PdfCopy copy = new PdfCopy(document, baos);

		// Configurar la encriptación con la contraseña
		copy.setEncryption(numeroDniCorreo.getBytes(),
				numeroDniCorreo.getBytes(), PdfWriter.ALLOW_PRINTING,
				PdfWriter.ENCRYPTION_AES_128);

		document.open();
		try {
			for (byte[] pdfBytes : listaArchivosPDF) {
				PdfReader reader = new PdfReader(pdfBytes);
				int numberOfPages = reader.getNumberOfPages();

				for (int page = 1; page <= numberOfPages; page++) {
					copy.addPage(copy.getImportedPage(reader, page));
				}

				reader.close();
			}
		} catch (DocumentException e) {
			log.error(e, "ERROR AL UNIFICAR EL ARCHIVO PDF ");

		} finally {
			document.close();
		}

		return baos.toByteArray();
	}

}

/*class JSchLogger implements Logger {
	private static final org.apache.log4j.Logger logger = LogManager
			.getLogger(JSchLogger.class);

	@Override
	public boolean isEnabled(int level) {
		Level log4jLevel = convertLevel(level);
		return logger.isEnabledFor(log4jLevel);
	}

	@Override
	public void log(int level, String message) {
		Level log4jLevel = convertLevel(level);
		logger.log(log4jLevel, message);
	}

	private Level convertLevel(int level) {
		switch (level) {
		case Logger.DEBUG:
			return Level.DEBUG;
		case Logger.INFO:
			return Level.INFO;
		case Logger.WARN:
			return Level.WARN;
		case Logger.ERROR:
			return Level.ERROR;
		case Logger.FATAL:
			return Level.FATAL;
		default:
			return Level.ERROR;
		}
	}
}*/
