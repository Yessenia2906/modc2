package pe.com.bn.modc.listener;

import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import pe.com.bn.comp.cryto.service.BNClaveSegura;
import pe.com.bn.comp.ws.bean.SistemaParametro;
import pe.com.bn.comp.ws.service.ParametroInterfazProxy;
import pe.com.bn.modc.common.Constante;
import pe.com.bn.modc.common.LoggerEECC;

import pe.com.bn.modc.model.ParametrosComp;

@Service
public class CompServiceImpl implements CompService {

	
	
	@Autowired
	ParametrosComp parametrosComp;
	
	private static LoggerEECC log3 = LoggerEECC.getInstance(CompServiceImpl.class.getName());

	
	@Override
	public void asignarParametros() {
		

		//parametrosComp = ParametrosComp.obtenerInstancia();
		SistemaParametro sistemaParametro = null;
		
		try 
		{
			ResourceBundle rb = ResourceBundle.getBundle("parametro");
			String keyPath = rb.getString("bn.claveSegura.gate.keyPath");
			String keyName = rb.getString("bn.claveSegura.gate.keyName");
			String sistema = rb.getString("bn.claveSegura.gate.sistema");
			String cuenta  = rb.getString("bn.claveSegura.gate.cuenta");
			String semillaKey = rb.getString("bn.claveSegura.gate.semillaKey");
			String usuario = rb.getString("bn.claveSegura.gate.usuario");
			
			
			
			System.out.println("eors_datos:"+keyPath+keyName+sistema+cuenta+semillaKey+usuario);

			String path= keyPath;
			  
			byte[] clave = BNClaveSegura.encrypt(path, semillaKey);
			
			String base64SemillaKey = Base64Utils.encodeToString(clave);
			System.out.println("Clave : "+base64SemillaKey);
			log3.debug(  "INSTANCE  PARAMETRO LLAVE:  "+base64SemillaKey ,"1");
			ParametroInterfazProxy proxi1 = new ParametroInterfazProxy();
			log3.debug(  "INSTANCE SERVICE PARAMETRO ","1");		
			sistemaParametro = proxi1.datoParametroService(sistema, cuenta, clave, usuario);
			log3.debug(  "RESULTADO SERVICE PARAMETRO: "+sistemaParametro.getProceso().getDescripcion(),"1");	
			
			if(sistemaParametro!=null && sistemaParametro.getProceso()!=null)
			{
				String estado = sistemaParametro.getProceso().getCodigo();
				String descest= sistemaParametro.getProceso().getDescripcion();
				if(estado.equals(Constante.CONST_PROCESO_OK)){
					for(int t=0;t<sistemaParametro.getGrupoParametro().length;t++){
						//Configuracion de Db App
  
						if(sistemaParametro.getGrupoParametro()[t].getAliasGrupo().equals("SERVIDOR_EECC")){
							if(sistemaParametro.getGrupoParametro()[t].getParametro() != null){
								for(int m=0;m<sistemaParametro.getGrupoParametro()[t].getParametro().length;m++){
									
									if(sistemaParametro.getGrupoParametro()[t].getParametro()[m].getAliasParam().equals("host".trim())){
										parametrosComp.setStfpHost(sistemaParametro.getGrupoParametro()[t].getParametro()[m].getValorParam());	
									}
								}
								
							}
						}
							
						if(sistemaParametro.getGrupoParametro()[t].getAliasGrupo().equals("PUERTO_EECC")){
							if(sistemaParametro.getGrupoParametro()[t].getParametro() != null){
								for(int m=0;m<sistemaParametro.getGrupoParametro()[t].getParametro().length;m++){
								if(sistemaParametro.getGrupoParametro()[t].getParametro()[m].getAliasParam().equals("port".trim())){
									parametrosComp.setStfpPort(sistemaParametro.getGrupoParametro()[t].getParametro()[m].getValorParam());	
								}
							}}
						}
						
						if(sistemaParametro.getGrupoParametro()[t].getAliasGrupo().equals("USER_EECC")){
							if(sistemaParametro.getGrupoParametro()[t].getParametro() != null){
								for(int m=0;m<sistemaParametro.getGrupoParametro()[t].getParametro().length;m++){
								if(sistemaParametro.getGrupoParametro()[t].getParametro()[m].getAliasParam().equals("username".trim())){
									parametrosComp.setStfpUsername(sistemaParametro.getGrupoParametro()[t].getParametro()[m].getValorParam());	
								}}
							}
						}
						
						if(sistemaParametro.getGrupoParametro()[t].getAliasGrupo().equals("CLAVE_EECC")){
							if(sistemaParametro.getGrupoParametro()[t].getParametro() != null){
								for(int m=0;m<sistemaParametro.getGrupoParametro()[t].getParametro().length;m++){
								if(sistemaParametro.getGrupoParametro()[t].getParametro()[m].getAliasParam().equals("clave".trim())){
									parametrosComp.setStfpPassword(sistemaParametro.getGrupoParametro()[t].getParametro()[m].getValorParam());	
								}}
							}
						}
						
						if(sistemaParametro.getGrupoParametro()[t].getAliasGrupo().equals("RUTA_EECC")){
							if(sistemaParametro.getGrupoParametro()[t].getParametro() != null){
								for(int m=0;m<sistemaParametro.getGrupoParametro()[t].getParametro().length;m++){
								if(sistemaParametro.getGrupoParametro()[t].getParametro()[m].getAliasParam().equals("ruta".trim())){
									parametrosComp.setStfpRemotepath(sistemaParametro.getGrupoParametro()[t].getParametro()[m].getValorParam());	
								}}
							}
						}
						
						if(sistemaParametro.getGrupoParametro()[t].getAliasGrupo().equals("SERVIDOR_BDUC")){
							if(sistemaParametro.getGrupoParametro()[t].getParametro() != null){
								for(int m=0;m<sistemaParametro.getGrupoParametro()[t].getParametro().length;m++){
									if(sistemaParametro.getGrupoParametro()[t].getParametro()[m].getAliasParam().equals("ruta".trim())){
										parametrosComp.setServiceHost(sistemaParametro.getGrupoParametro()[t].getParametro()[m].getValorParam());	
									}
								}
								}
								
							}
						
						if(sistemaParametro.getGrupoParametro()[t].getAliasGrupo().equals("PUERTO_BDUC")){
							if(sistemaParametro.getGrupoParametro()[t].getParametro() != null){
								for(int m=0;m<sistemaParametro.getGrupoParametro()[t].getParametro().length;m++){
									if(sistemaParametro.getGrupoParametro()[t].getParametro()[m].getAliasParam().equals("ruta".trim())){
										parametrosComp.setServicePort(sistemaParametro.getGrupoParametro()[t].getParametro()[m].getValorParam());	
									}
								}
								
							}
						}
						
						if(sistemaParametro.getGrupoParametro()[t].getAliasGrupo().equals("APLICACION_BDUC")){
							if(sistemaParametro.getGrupoParametro()[t].getParametro() != null){
								for(int m=0;m<sistemaParametro.getGrupoParametro()[t].getParametro().length;m++){
									if(sistemaParametro.getGrupoParametro()[t].getParametro()[m].getAliasParam().equals("apliacion".trim())){
										parametrosComp.setServiceUserApplication(sistemaParametro.getGrupoParametro()[t].getParametro()[m].getValorParam());	
									}
								}
								
							}
						}
						
						if(sistemaParametro.getGrupoParametro()[t].getAliasGrupo().equals("SERVIDOR_CORREO")){
							if(sistemaParametro.getGrupoParametro()[t].getParametro() != null){
								for(int m=0;m<sistemaParametro.getGrupoParametro()[t].getParametro().length;m++){
									if(sistemaParametro.getGrupoParametro()[t].getParametro()[m].getAliasParam().equals("servidor".trim())){
										parametrosComp.setServicewscorreoHost(sistemaParametro.getGrupoParametro()[t].getParametro()[m].getValorParam());	
									}
								}
								
							}
						}
						if(sistemaParametro.getGrupoParametro()[t].getAliasGrupo().equals("TOKEN_CORREO")){
							//System.out.println("existe TOKEN_CORREO");
							if(sistemaParametro.getGrupoParametro()[t].getParametro() != null){
								for(int m=0;m<sistemaParametro.getGrupoParametro()[t].getParametro().length;m++){
									
									if(sistemaParametro.getGrupoParametro()[t].getParametro()[m].getAliasParam().equals("token".trim())){
										parametrosComp.setServicewscorreoToken(sistemaParametro.getGrupoParametro()[t].getParametro()[m].getValorParam());	
									}
								}
								
							}
						}
						
						if(sistemaParametro.getGrupoParametro()[t].getAliasGrupo().equals("REMITENTE_CORREO")){
							//System.out.println("existe REMITENTE_CORREO");
							if(sistemaParametro.getGrupoParametro()[t].getParametro() != null){
								for(int m=0;m<sistemaParametro.getGrupoParametro()[t].getParametro().length;m++){
									
									if(sistemaParametro.getGrupoParametro()[t].getParametro()[m].getAliasParam().equals("correo".trim())){
										parametrosComp.setServicewscorreoCorreoemisor(sistemaParametro.getGrupoParametro()[t].getParametro()[m].getValorParam());	
									}
								}
								
							}
						}
		
					}//Fin de FOR
					
				}else{
					log3.debug("====================================================","1");
					log3.debug("PARAMETROS WS RESPUESTA: " + estado+"[ "+descest+" ]","1");
					log3.debug("REVISAR ARGUMENTOS Y COMPROBAR LLAVES  ","1");
					log3.debug("====================================================","1");
				}
			}else{
				log3.debug("====================================================","1");
				log3.debug("RESPUESTA WS NULA","1");
				log3.debug("REVISAR ARGUMENTOS Y COMPROBAR LLAVES  ","1");
				log3.debug("====================================================","1");
			}
				
		} catch (Exception e) {
			
			log3.error(e  ,"ERROR EN WS | REVISAR ARGUMENTOS Y COMPROBAR LLAVES");
		}
		
		
		log3.debug(  "PARAMETROS MODC INICIADOS CORRECTAMENTE" ,"1");
		
		
		
	}

}
