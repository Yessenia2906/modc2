package pe.com.bn.modc.config;

import java.util.LinkedList;
import java.util.List;

import pe.com.bn.modc.common.Constant;
import pe.com.bn.modc.common.Constante;
import pe.com.bn.modc.common.Util;
import pe.com.bn.modc.common.LoggerBn;
import seguridad.service.AutenticaRegProxy;

public class NServiciosPermiso implements IServiciosPermiso {
	
	private static LoggerBn log = LoggerBn.getInstance(NServiciosPermiso.class.getName());
	
	public NServiciosPermiso() {
	}
	
	public BUsuarioLogin listarPermisos(BUsuarioLogin objUsuario) throws Exception {
		return validarLoginHost(objUsuario);
	}
	
	private BUsuarioLogin validarLoginHost(BUsuarioLogin objUsuario) throws Exception {
		
		String user = objUsuario.getLogin();
		String password = objUsuario.getPassword();

		List<BOpcion> lista = new LinkedList<BOpcion>();

		String codAgencia = null;
		String codEmpleado = null;
		String nombre = null;
		String desAgencia = null;

		
		AutenticaRegProxy proxi = new AutenticaRegProxy();
		
		String respuesta = "";
		
		try {
			respuesta = proxi.claveHost(Util.lpad(user,4).toUpperCase() + 
										Util.lpad(password,8).toUpperCase() + 
										Constant.VAR_GLB_COD_APLICATIVO + 
									Constant.CONST_ID_DESA);
			
			
		//	respuesta = "00|0372|1|0000000|01S02S03S04S05S06S07S08S09S10S11S12S13S14S15N16N17N18N19N20N21N22N23N24N25N26N27N28N29N30N|FIORELLA GALVAN                    |MEDIOS ELECTRONICOS          |Su acceso ha sido exitoso                         |1|00000000|000 |                         |";
			
		} catch (Exception e) {
			log.error(e, "[NServiciosPermiso/validarLoginHost|ERR: AutenticaRegProxy " + Constante.ERR_LOGICA_NEGOCIO, "");
			throw new Exception("Error interno en AutenticaRegProxy");
		}
		
		log.debug("validarLoginHost | " + respuesta, "1");
		
		/** PRUEBA **/
//		respuesta = "00|0372|1|0000000|01S02S03S04S05S06S07S08S09S10S11S12S13S14S15N16N17N18N19N20N21N22N23N24N25N26N27N28N29N30N|FIORELLA GALVAN                    |MEDIOS ELECTRONICOS          |Su acceso ha sido exitoso                         |1|00000000|000 |                         |";
		/** PRUEBA **/		
		
		/*** Host Operativo ***/
		if (	respuesta != null 
			&& 	respuesta != "") {
			
		//original
			
			String[] res = respuesta.split("\\|");
			
			if (res[0].equals("00")) {
				
				codAgencia = res[1].toString().trim();
				codEmpleado = res[3].toString().trim();
				nombre = recuperarNombres(res[5].toString().trim());
				desAgencia = res[6].toString().trim();
				
				
				String cadenaPermisos = res[4].toString();

				for (int j = 2; j < cadenaPermisos.length(); j++) {
					
					if (cadenaPermisos.substring(j, j + 1).equals("S")) {
												
						BOpcion opcion = new BOpcion();
						opcion.setCodigo(cadenaPermisos.substring(j - 2, j));
						
						lista.add(opcion);
					}
					
					j = j + 2;
				}
				
			} else {
				log.debug("listarRoles: Usuario(" + user + ") " + res[0] + " " + res[1], "1");
				throw new Exception("Error AutenticaRegProxy!!!, Codigo: " + res[0] + ", Mensaje: " + res[1]);
				
//				if (res[1].trim().length() > 2) {
//					BOpcion opcion = new BOpcion();
//					opcion.setCodigo(res[1]);
//					lista.add(opcion);
//				}
			}
		}
		/*** Fin Host Operativo ***/
		
		BUsuarioLogin usuario = new BUsuarioLogin();
		
		usuario.setListaOpciones(lista);
		usuario.setNombre(nombre);
		usuario.setDesAgencia(desAgencia);
		usuario.setCodUsuario(objUsuario.getLogin());
		usuario.setCodAgencia(codAgencia);
		usuario.setCodEmpleado(codEmpleado);
		
		usuario.setLogin(objUsuario.getLogin());
		usuario.setPassword(objUsuario.getPassword());
		
		return usuario;
	}

	private String recuperarNombres(String prmNombreCompleto) {
		
		String result = "";
		
		if (prmNombreCompleto != null) {
			
			String[] nombres = prmNombreCompleto.split("/");
			
			for (int i = 0; i < nombres.length; i++) {
				
				if (!nombres[i].equals("")) {
					
					result += nombres[i] + " ";
				}
			}
			
		}
		
		return result;
	}

}
