package pe.com.bn.modc.trama.interactive;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ResourceBundle;

import pe.bn.service.bean.RequestGateway;
import pe.bn.service.bean.ResponseGateway;
import pe.bn.service.interfaz.GatewayInterfaceProxy;
import pe.com.bn.modc.common.Constante;
import pe.com.bn.modc.common.Funciones;
import pe.com.bn.modc.model.BodyCronograma;
import pe.com.bn.modc.model.BodyGeneracionCronograma;
import pe.com.bn.modc.model.BodyGeneracionCronogramaRepro;
import pe.com.bn.modc.model.BodyHojaResumen;
import pe.com.bn.modc.model.BodyIndicador;
import pe.com.bn.modc.model.BodyLetraCambio;
import pe.com.bn.modc.model.BodyPase;
import pe.com.bn.modc.model.BodyPolizaPrestamo;
import pe.com.bn.modc.model.BodySolicitudPrestamo;
import pe.com.bn.modc.model.Head;
import pe.com.bn.modc.model.HeadCronograma;




import pe.com.bn.comun.log.LoggerMODC;

public class CicsSoapConnection {

	//private static Logger log=(LoggerUtil.getInstance()).getLogger(CicsSoapConnection.class);
	private static LoggerMODC log3 = LoggerMODC.getInstance(CicsSoapConnection.class.getName());
	
	
	
	
	
	
	//----------------------POLIZA 06 TIPO------------------
	public BodyPolizaPrestamo enviarTramaPoliza (
			BodyCronograma cabecera, 
			BodyCronograma bodyIn
		) throws Exception {

		
		// Input
		BodyPolizaPrestamo bodyOut = null;
		String head = cabecera.toString();
		head = Funciones.validar_texto(head);
		String trama = head + bodyIn;
		String out = null;
		
		GatewayInterfaceProxy proxy = new GatewayInterfaceProxy();
		RequestGateway peticion = new RequestGateway();

		peticion.setLongitud("9999");
		//peticion.setTransid("WS52");
		peticion.setTransid("WS85");
		peticion.setDatos(trama);
		System.out.println("Trama A enviar "+trama);
		//peticion.setFiller("00000000000000000");
		peticion.setFiller("");
		bodyOut = new BodyPolizaPrestamo();
		
		log3.debug("trama In:", trama,"2");
		
		// respuesta 
		ResponseGateway respuesta = new ResponseGateway();
		respuesta = proxy.enviarTramaConsulta(peticion);
		
		System.out.println("respuesta.getMensaje()"+respuesta.getMensaje());
		System.out.println("respuesta.getMsgno()"+respuesta.getMsgno());
		
		//RESPONSE HOST TRADICIONAL DESARROLLO CASO 0438160762911
		    //respuesta.setDatos("06043816076291100000000350000060MARCELO HUAMALI YOLANDA                      CJ VILLA SOLEDAD 1 MZ Z LT 02 SECTOR OESTE JI0000000DNI      0020902766  06/04/196000000000000000-000507991920/10/20230001200000000000000000000000014748700000000000000000000000014748700000000004063500000984000000000029000000001161000016/10/20280001200000          5713683   FPERUANA        SOLTERO   0068 UNIDAD DE GESTION ED                    3340-                                        CRCO    00000000000000000000000000000000000 0000000000ANGEL ARMIJO HIDALGO          LIZETTE CHAMOCHUMBI           000000CARABAYLLO               LIMA                     LIMA                     022452672YMARCELO@GMAIL.COM                                0000                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    *");
	
		//RESPONSE HOST TRADICIONAL DESARROLLO CASO 0438160762911

		
		//RESPONSE HOST RETORNO DESARROLLO CASO 0401135346601

		   ////respuesta.setDatos("06040113534660100000000260000060YANALLALLI SARMIENTO MARYBEL LILIANA         CO UMAMARCA  MZ M LT 3                       4872554DNI      0009581695  03/08/197000000000000000-000507992020/10/20230001330000000000000000000000012190000000000000000000000000012190000000000003018600000984000000000029000000001161000018/10/20280001330000          5713683   FPERUANA        SOLTERO   0000 BANCO DE LA NACION                      3340-                                        CRCO    00000000000000000000000000000000000 0000000000ANGEL ARMIJO HIDALGO          LIZETTE CHAMOCHUMBI           000000SAN JUAN DE MIRAFLORES   LIMA                     LIMA                     022452673MARY3870@LIVE.COM                                 0000                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    *");
		
		//RESPONSE HOST RETORNO DESARROLLO CASO 0401135346601
		
		//TODO: PRESTAMO 06 MELANIE
		respuesta.setDatos("06040134034870300000000450000072FARRO VIDARTE GRIDELINA                       MZR LT9G MCDO CTRAL PACHACUTEC VENT  MZ R LT4875222DNI      0080544424  11/01/197500000000000000-000063755715/01/20250001200000000000000000000000023277400000000000000000000000023277400000000000000000000984000000000029000000001161000016/01/20310001200000          5713683   FPERUANA        SOLTERO   1725 UND DE GESTION EDU L                    3111-SECCION APERTURA                        CRCO    00000000000000000000000000000000000 0000000000ANGEL ARMIJO HIDALGO          LIZETTE CHAMOCHUMBI           000000VENTANILLA               PROV  CONST CALLAO       PROV CONSTITUCIONAL      022453981GRIDELINAFARROVIDARTE@GMAIL.COM                   0000                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    *");
		System.out.println("respuesta.getDatos():"+respuesta.getDatos());
		
		
		try {
			
			if (("0000".equals(respuesta.getMsgno())) && (!respuesta.getDatos().equals(""))) {
				
				log3.debug("trama Out:", respuesta.getDatos(),"2");
				
				HeadCronograma cabOut  = new HeadCronograma();
				if(respuesta.getDatos().length()< cabOut.LongitudTrama()){
					throw new Exception("La cabecera del cics soap no es invalida.");	
				}
				
														
			     out = respuesta.getDatos();
			     
			    
			     bodyOut.FillBoby(out);
			     bodyOut.setByTag("W-WS-CERROR",respuesta.getMsgno());

			     bodyOut.setByTag("W-WS-MSJ",respuesta.getMensaje());


			     bodyOut.toShowData();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	

		return bodyOut;		
	}
	
	//----------------------Hoja 08 TIPO------------------

	public BodyHojaResumen enviarTramaHojaResumen(
			BodyHojaResumen cabecera,
			BodyHojaResumen body
		) throws Exception {

		
		// Input
		BodyHojaResumen bodyOut = null;
		String head = cabecera.toString();
		head = Funciones.validar_texto(head);
		String trama = head + body;
		String out = null;
		String outMsgnoHost =  null;
		String outMsjeHost = null;
		
		GatewayInterfaceProxy proxy = new GatewayInterfaceProxy();
		RequestGateway peticion = new RequestGateway();

		peticion.setLongitud("9999");
	//	peticion.setTransid("WS52");
		peticion.setTransid("WS85");
		peticion.setDatos(trama);
		//peticion.setFiller("00000000000000000");
		peticion.setFiller("");
		bodyOut = new BodyHojaResumen();
		
		// respuesta 
		ResponseGateway respuesta = new ResponseGateway();
		respuesta = proxy.enviarTramaConsulta(peticion);
		
		System.out.println("respuesta.getMensaje()"+respuesta.getMensaje());
		System.out.println("respuesta.getMsgno()"+respuesta.getMsgno());
		//RESPONSE HOST TRADICIONAL DESARROLLO CASO 0438160762911
		    //respuesta.setDatos("08043816076291100000000350000000000000161782201699000000058273600PACIFICO SEGUROS DE VIDA                          000120000000000000000000000001474870005079919             LA POSITIVA SEGUROS Y REASEGUROS                  0000000000334250000000000010150005713683 - 0005079919000000000040635000000000003000000000000000600NONO0000                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                *");
		//RESPONSE HOST TRADICIONAL DESARROLLO CASO 0438160762911
		//RESPONSE HOST RETORNO DESARROLLO CASO 0401135346601
		   ////respuesta.setDatos("08040113534660100000000260000000000000120650001699000000058273600PACIFICO SEGUROS DE VIDA                          000133000000000000000000000001219000005079920             LA POSITIVA SEGUROS Y REASEGUROS                  0000000000248300000000000007540005713683 - 0005079920000000000030186000000000003000000000000000600NONO0000                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                *");

		//RESPONSE HOST RETORNO DESARROLLO CASO 0401135346601
		
		
		
		//TODO: PRESTAMO 08 MELANIE 
		respuesta.setDatos("08040134034870300000000450000000000000248331101649000000058273600PACIFICO SEGUROS DE VIDA                          000120000000000000000000000002327740000637557                                                               0000000000000000000000000000000000000000   0000637557000000000000000000000000003000000000000000600NONO0000                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                *");
		
		
		
		System.out.println("respuesta.getDatos():"+respuesta.getDatos());
		
		String msgnoHost = "";
		String msjeHost = "";
		String tramaMensajes = "";
		
		
		try {
			
			if (("0000".equals(respuesta.getMsgno())) && (!respuesta.getDatos().equals(""))) {
				
				//log3.debug("trama Out:", respuesta.getDatos(),Constante.LOGGER_DEBUG_NIVEL_2);
				
				BodyHojaResumen cabOut  = new BodyHojaResumen();
				
				System.out.println("LONGITUD DATOS: "+respuesta.getDatos().length());
				System.out.println("LONGITUD TRAMA: "+cabOut.LongitudTrama());
				
				
				if(respuesta.getDatos().length()< cabOut.LongitudTrama()){
					
					throw new Exception("La cabecera del cics soap no es válida.");	
				}
				
				 msgnoHost = respuesta.getMsgno();
			   	 msjeHost = respuesta.getMensaje();
			   	
			   	 tramaMensajes = msgnoHost+msjeHost;
			   	 
			   	 System.out.println("TRAMA MENSAJES B: "+tramaMensajes);
			   	 System.out.println("LONGITUD TRAMA MENSAJES B: "+tramaMensajes.length());
					
			     out = respuesta.getDatos()+tramaMensajes;
			     
			     System.out.println("LONGITUD TRAMA TOTAL: "+out.length());
			     
			     bodyOut.FillBoby(out);
			     //bodyOut.FillBobyHost(tramaMensajes);
			     bodyOut.toShowData();
			}
		
		   if(("9995".equals(respuesta.getMsgno())) && (respuesta.getDatos().equals(""))){
				
			   	msgnoHost = respuesta.getMsgno();
			   	msjeHost = respuesta.getMensaje();
			   	
			   	tramaMensajes = msgnoHost+msjeHost;
			   	
			   	System.out.println("TRAMA MENSAJES M: "+tramaMensajes);
			   	System.out.println("LONGITUD TRAMA MENSAJES M: "+tramaMensajes.length());
				
			
			    bodyOut.FillBoby(tramaMensajes);
			    bodyOut.toShowData();
		   }
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Verificar si hubo error a nivel de interfaz			
	

		return bodyOut;		
	}
	
	
	public BodyIndicador enviarTramaIndicador(
			BodyIndicador cabecera,
			BodyIndicador body
		) throws Exception {

		
		// Input
		BodyIndicador bodyOut = null;
		String head = cabecera.toString();
		head = Funciones.validar_texto(head);
		String trama = head + body;
		String out = null;
		String outMsgnoHost =  null;
		String outMsjeHost = null;
		
		GatewayInterfaceProxy proxy = new GatewayInterfaceProxy();
		RequestGateway peticion = new RequestGateway();

		peticion.setLongitud("9999");
	//	peticion.setTransid("WS52");
		peticion.setTransid("WS85");
		peticion.setDatos(trama);
		//peticion.setFiller("00000000000000000");
		peticion.setFiller("");
		bodyOut = new BodyIndicador();
		
		// respuesta 
		ResponseGateway respuesta = new ResponseGateway();
		respuesta = proxy.enviarTramaConsulta(peticion);
		
		System.out.println("respuesta.getMensaje()"+respuesta.getMensaje());
		System.out.println("respuesta.getMsgno()"+respuesta.getMsgno());
		
		
		System.out.println("respuesta.getDatos():"+respuesta.getDatos());
		
		String msgnoHost = "";
		String msjeHost = "";
		String tramaMensajes = "";
		
		
		try {
			
			if (("0000".equals(respuesta.getMsgno())) && (!respuesta.getDatos().equals(""))) {
				
				//log3.debug("trama Out:", respuesta.getDatos(),Constante.LOGGER_DEBUG_NIVEL_2);
				
				BodyIndicador cabOut  = new BodyIndicador();
				
				System.out.println("LONGITUD DATOS: "+respuesta.getDatos().length());
				System.out.println("LONGITUD TRAMA: "+cabOut.LongitudTrama());
				
				
				if(respuesta.getDatos().length()< cabOut.LongitudTrama()){
					
					throw new Exception("La cabecera del cics soap no es válida.");	
				}
				
				 msgnoHost = respuesta.getMsgno();
			   	 msjeHost = respuesta.getMensaje();
			   	
			   	 tramaMensajes = msgnoHost+msjeHost;
			   	 
			   	 System.out.println("TRAMA MENSAJES B: "+tramaMensajes);
			   	 System.out.println("LONGITUD TRAMA MENSAJES B: "+tramaMensajes.length());
					
			     out = respuesta.getDatos()+tramaMensajes;
			     
			     System.out.println("LONGITUD TRAMA TOTAL: "+out.length());
			     
			     bodyOut.FillBoby(out);
			     //bodyOut.FillBobyHost(tramaMensajes);
			     bodyOut.toShowData();
			}
		
		   if(("9995".equals(respuesta.getMsgno())) && (respuesta.getDatos().equals(""))){
				
			   	msgnoHost = respuesta.getMsgno();
			   	msjeHost = respuesta.getMensaje();
			   	
			   	tramaMensajes = msgnoHost+msjeHost;
			   	
			   	System.out.println("TRAMA MENSAJES M: "+tramaMensajes);
			   	System.out.println("LONGITUD TRAMA MENSAJES M: "+tramaMensajes.length());
				
			
			    bodyOut.FillBoby(tramaMensajes);
			    bodyOut.toShowData();
		   }
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Verificar si hubo error a nivel de interfaz			
	

		return bodyOut;		
	}
	

	
	//----------------------05 TIPO------------------

	public BodyGeneracionCronograma enviarTrama (
			BodyGeneracionCronograma cabecera,
			//Head cabecera,
			BodyGeneracionCronograma body
		) throws Exception {

		
		// Input
		BodyGeneracionCronograma bodyOut = null;
		String head = cabecera.toString();
		head = Funciones.validar_texto(head);
		String trama = head + body;
		String out = null;
		String outMsgnoHost =  null;
		String outMsjeHost = null;
		
		GatewayInterfaceProxy proxy = new GatewayInterfaceProxy();
		RequestGateway peticion = new RequestGateway();

		peticion.setLongitud("9999");
	//	peticion.setTransid("WS52");
		peticion.setTransid("WS85");
		peticion.setDatos(trama);
		System.out.println("TRAMA HOJA RESUMEN : "+trama);

		//peticion.setFiller("00000000000000000");
		peticion.setFiller("");
		bodyOut = new BodyGeneracionCronograma();
		
		//log3.debug("trama In:", trama,Constante.LOGGER_DEBUG_NIVEL_2);
		
		// respuesta 
		ResponseGateway respuesta = new ResponseGateway();
		respuesta = proxy.enviarTramaConsulta(peticion);
		
		System.out.println("respuesta.getMensaje()111"+respuesta.getMensaje());
		System.out.println("respuesta.getMsgno()111"+respuesta.getMsgno());
		
		
		//RESPONSE HOST TRADICIONAL DESARROLLO CASO 0438160762911
		    //respuesta.setDatos("050438160762911202310200000000035000000000000000000000000000035000000000000035000000601VIG20231116000000002000425410004143400003780000877551VIG20231216000000002000380980004550800004149000877551VIG20240116000000002000369980004651700004240000877551VIG20240216000000002000375470004601400004194000877551VIG20240316000000002000413260004254900003880000877551VIG20240416000000002000387180004494100004096000877551VIG20240516000000002000408650004297200003918000877551VIG20240616000000002000398990004385800003998000877551VIG20240716000000002000420250004190900003821000877551VIG20240816000000002000411150004274400003896000877551VIG20240916000000002000417250004218500003845000877551VIG20241016000000002000438180004026600003671000877551VIG20241116000000002000429950004102100003739000877551VIG20241216000000002000450650003912300003567000877551VIG20250116000000002000443020003982300003630000877551VIG20250216000000002000449600003922000003575000877551VIG20250316000000002000497270003484900003179000877551VIG20250416000000002000463660003793200003457000877551VIG20250516000000002000483750003609000003290000877551VIG20250616000000002000477720003664300003340000877551VIG20250716000000002000497550003482500003175000877551VIG20250816000000002000492200003531600003219000877551VIG20250916000000002000499500003464700003158000877551VIG20251016000000002000518950003286400002996000877551VIG20251116000000002000514620003326100003032000877551VIG20251216000000002000533790003150400002872000877551VIG20260116000000002000530180003183500002902000877551VIG20260216000000002000538050003111400002836000877551VIG20260316000000002000578300002742400002501000877551VIG20260416000000002000554620002959500002698000877551VIG20260516000000002000573070002790400002544000877551VIG20260616000000002000571360002806100002558000877551VIG20260716000000002000589500002639800002407000877551VIG20260816000000002000588590002648200002414000877551VIG20260916000000002000597330002568100002341000877551VIG20261016000000002000615000002406100002194000877551VIG20261116000000002000615330002403200002190000877551VIG20261216000000002000632680002244100002046000877551VIG20270116000000002000633850002233400002036000877551VIG20270216000000002000643260002147200001957000877551VIG20270316000000002000674680001859100001696000877551VIG20270416000000002000662820001967900001794000877551VIG20270516000000002000679320001816700001656000877551VIG20270616000000002000682750001785300001627000877551VIG20270716000000002000698880001637400001493000877551VIG20270816000000002000703260001597300001456000877551VIG20270916000000002000713700001501600001369000877551VIG20271016000000002000729260001359000001239000877551VIG20271116000000002000735120001305300001190000877551VIG20271216000000002000750300001166200001063000877551VIG20280116000000002000757160001103300001006000877551VIG20280216000000002000768400001000300000912000877551VIG20280316000000002000786150000837600000764000877551VIG20280416000000002000791480000788800000719000877551VIG20280516000000002000805640000659000000601000877551VIG20280616000000002000815190000571500000521000877551VIG20280716000000002000828920000445700000406000877551VIG20280816000000002000839600000347800000317000877551VIG20280916000000002000852060000233600000213000877551VIG2028101600000000200086521000011390000010400087764                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            MARCELO HUAMALI YOLANDA                      DNI 0020902766  0000000   CJ VILLA SOLEDAD 1 MZ Z LT 02 SECTOR OESTE JI                SIN AVAL                                                                                  1699000001930000000000000000406350000                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        *");
		//RESPONSE HOST TRADICIONAL DESARROLLO CASO 0438160762911

		
		//RESPONSE HOST RETORNO DESARROLLO CASO 0401135346601

		   ////respuesta.setDatos("050401135346601202310200000000026000000000000000000000000000026000000000000026000000601VIG20231118000000002000290570003307400003343000654741VIG20231218000000002000282150003384000003419000654741VIG20240118000000002000273870003459200003495000654741VIG20240218000000002000277980003421900003457000654741VIG20240318000000002000306320003164400003198000654741VIG20240418000000002000286730003342400003377000654741VIG20240518000000002000302830003196100003230000654741VIG20240618000000002000295560003262200003296000654741VIG20240718000000002000311500003117400003150000654741VIG20240818000000002000304660003179600003212000654741VIG20240918000000002000309220003138200003170000654741VIG20241018000000002000324910002995600003027000654741VIG20241118000000002000318720003051900003083000654741VIG20241218000000002000334240002910900002941000654741VIG20250118000000002000328500002963100002993000654741VIG20250218000000002000333420002918400002948000654741VIG20250318000000002000369190002593300002622000654741VIG20250418000000002000343940002822800002852000654741VIG20250518000000002000359010002685900002714000654741VIG20250618000000002000354470002727200002755000654741VIG20250718000000002000369350002592000002619000654741VIG20250818000000002000365310002628700002656000654741VIG20250918000000002000370790002579000002605000654741VIG20251018000000002000385370002446500002472000654741VIG20251118000000002000382120002476100002501000654741VIG20251218000000002000396500002345400002370000654741VIG20260118000000002000393780002370200002394000654741VIG20260218000000002000399680002316600002340000654741VIG20260318000000002000429900002042000002064000654741VIG20260418000000002000412100002203800002226000654741VIG20260518000000002000425940002078000002100000654741VIG20260618000000002000424650002089800002111000654741VIG20260718000000002000438270001966000001987000654741VIG20260818000000002000437570001972400001993000654741VIG20260918000000002000444130001912900001932000654741VIG20261018000000002000457400001792300001811000654741VIG20261118000000002000457630001790200001809000654741VIG20261218000000002000470660001671900001689000654741VIG20270118000000002000471540001663900001681000654741VIG20270218000000002000478600001599800001616000654741VIG20270318000000002000502220001385200001400000654741VIG20270418000000002000493300001466300001481000654741VIG20270518000000002000505680001353800001368000654741VIG20270618000000002000508260001330400001344000654741VIG20270718000000002000520380001220300001233000654741VIG20270818000000002000523660001190500001203000654741VIG20270918000000002000531500001119300001131000654741VIG20271018000000002000543200001013000001024000654741VIG20271118000000002000547600000973100000983000654741VIG20271218000000002000559020000869400000878000654741VIG20280118000000002000564180000822500000831000654741VIG20280218000000002000572630000745800000753000654741VIG20280318000000002000585980000624500000631000654741VIG20280418000000002000589990000588100000594000654741VIG20280518000000002000600630000491400000497000654741VIG20280618000000002000607810000426200000431000654741VIG20280718000000002000618150000332300000336000654741VIG20280818000000002000626180000259400000262000654741VIG20280918000000002000635560000174200000176000654741VIG2028101800000000200064499000008490000008600065434                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            YANALLALLI SARMIENTO MARYBEL LILIANA         DNI 0009581695  4872554   CO UMAMARCA  MZ M LT 3                                       SIN AVAL                                                                                  1699000001930000000000000000301860000                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        *");
		
		//RESPONSE HOST RETORNO DESARROLLO CASO 0401135346601
		
		
		// TODO PRESTAMO 05 MELANIE
		respuesta.setDatos("050401340348703202501150000000045000000000000000000000000000045000000000000045000000721VIG20250216000000002000329930006147000005760001002231VIG20250316000000002000418730005334700005003001002231VIG20250416000000002000361900005854600005487001002231VIG20250516000000002000387740005618200005267001002231VIG20250616000000002000372750005755400005394001002231VIG20250716000000002000398390005520900005175001002231VIG20250816000000002000383900005653400005299001002231VIG20250916000000002000389460005602600005251001002231VIG20251016000000002000414790005370900005035001002231VIG20251116000000002000401100005496200005151001002231VIG20251216000000002000426220005266400004937001002231VIG20260116000000002000413070005386700005049001002231VIG20260216000000002000419050005332100004997001002231VIG20260316000000002000481260004763000004467001002231VIG20260416000000002000432070005213000004886001002231VIG20260516000000002000456630004988400004676001002231VIG20260616000000002000444930005095400004776001002231VIG20260716000000002000469250004873000004568001002231VIG20260816000000002000458160004974500004662001002231VIG20260916000000002000464800004913800004605001002231VIG20261016000000002000488740004694800004401001002231VIG20261116000000002000478590004787700004487001002231VIG20261216000000002000502280004571000004285001002231VIG20270116000000002000492780004657900004366001002231VIG20270216000000002000499920004592700004304001002231VIG20270316000000002000555320004085900003832001002231VIG20270416000000002000515180004453100004174001002231VIG20270516000000002000538200004242600003977001002231VIG20270616000000002000530430004313700004043001002231VIG20270716000000002000553160004105800003849001002231VIG20270816000000002000546100004170400003909001002231VIG20270916000000002000554010004098100003841001002231VIG20271016000000002000576300003894200003651001002231VIG20271116000000002000570360003948600003701001002231VIG20271216000000002000592360003747400003513001002231VIG20280116000000002000587190003794700003557001002231VIG20280216000000002000595680003717100003484001002231VIG20280316000000002000630120003402100003190001002231VIG20280416000000002000613420003554900003332001002231VIG20280516000000002000634620003361000003151001002231VIG20280616000000002000631480003389800003177001002231VIG20280716000000002000652350003198900002999001002231VIG20280816000000002000650060003219900003018001002231VIG20280916000000002000659470003133900002937001002231VIG20281016000000002000679830002947700002763001002231VIG20281116000000002000678850002956700002771001002231VIG20281216000000002000698850002773800002600001002231VIG20290116000000002000698790002774400002600001002231VIG20290216000000002000708890002682000002514001002231VIG20290316000000002000746700002336200002191001002231VIG20290416000000002000729960002489400002333001002231VIG20290516000000002000749020002315100002170001002231VIG20290616000000002000751360002293700002150001002231VIG20290716000000002000770020002123100001990001002231VIG20290816000000002000773380002092400001961001002231VIG20290916000000002000784570001990100001865001002231VIG20291016000000002000802610001825100001711001002231VIG20291116000000002000807540001780100001668001002231VIG20291216000000002000825150001619000001518001002231VIG20300116000000002000831160001564100001466001002231VIG20300216000000002000843180001454200001363001002231VIG20300316000000002000869670001211900001137001002231VIG20300416000000002000867980001227500001150001002231VIG20300516000000002000884480001076600001009001002231VIG20300616000000002000893330000995700000933001002231VIG20300716000000002000909370000849000000796001002231VIG20300816000000002000919410000757200000710001002231VIG20300916000000002000932720000635500000596001002231VIG20301016000000002000948030000495500000465001002231VIG20301116000000002000959940000386700000362001002231VIG20301216000000002000974740000251300000236001002231VIG2031011600000000200098822000013070000012300100252FARRO VIDARTE GRIDELINA                      DNI 0080544424  4875222    MZR LT9G MCDO CTRAL PACHACUTEC VENT  MZ R LT                SIN AVAL                                                                                  1649000001816000000000000000000000000                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        *");
		System.out.println("respuesta.getDatos()111:"+respuesta.getDatos());
		
		String msgnoHost = "";
		String msjeHost = "";
		String tramaMensajes = "";
		
	//	  respuesta.setMsgno("0004");
		try {
			
			if (("0000".equals(respuesta.getMsgno())) && (!respuesta.getDatos().equals(""))) {
				
				//log3.debug("trama Out:", respuesta.getDatos(),Constante.LOGGER_DEBUG_NIVEL_2);
				
				BodyGeneracionCronograma cabOut  = new BodyGeneracionCronograma();
				
				System.out.println("LONGITUD DATOS: "+respuesta.getDatos().length());
				System.out.println("LONGITUD TRAMA: "+cabOut.LongitudTrama());
				
				
				if(respuesta.getDatos().length()< cabOut.LongitudTrama()){
					
					throw new Exception("La cabecera del cics soap no es válida.");	
				}
				
				 msgnoHost = respuesta.getMsgno();
			   	 msjeHost = respuesta.getMensaje();
			   	
			   	 tramaMensajes = msgnoHost+msjeHost;
			   	 
			   	 System.out.println("TRAMA MENSAJES B: "+tramaMensajes);
			   	 System.out.println("LONGITUD TRAMA MENSAJES B: "+tramaMensajes.length());
					
			     out = respuesta.getDatos()+tramaMensajes;
			     
			     System.out.println("LONGITUD TRAMA TOTAL: "+out.length());
			     
			     bodyOut.FillBobyOk(out);
			     //bodyOut.FillBobyHost(tramaMensajes);
			     bodyOut.toShowData();
			}
		
		   if(("9995".equals(respuesta.getMsgno())) && (respuesta.getDatos().equals(""))){
				
			   	msgnoHost = respuesta.getMsgno();
			   	msjeHost = respuesta.getMensaje();
			   	
			   	tramaMensajes = msgnoHost+msjeHost;
			   	
			   	System.out.println("TRAMA MENSAJES M: "+tramaMensajes);
			   	System.out.println("LONGITUD TRAMA MENSAJES M: "+tramaMensajes.length());
				
				//outMsgnoHost = msgnoHost;
				//outMsjeHost = msjeHost;
			    bodyOut.FillBobyHost(tramaMensajes);
			    bodyOut.toShowData();
		   }
		   
		 
		   
		   
		   if(((     !(respuesta.getMsgno()).equals("0000") ))){
				
			   	msgnoHost = respuesta.getMsgno();
			   	msjeHost = respuesta.getMensaje();
			   	
			   	tramaMensajes = msgnoHost+msjeHost;
			   	
			//   	System.out.println("TRAMA MENSAJES M1111: "+tramaMensajes);
			 //  	System.out.println("LONGITUD TRAMA MENSAJES M1111: "+tramaMensajes.length());
				
			   	System.out.println("TRAMA MENSAJES M1111: ");
				System.out.println("LONGITUD TRAMA MENSAJES M1111: "+tramaMensajes.length());
			   	
				//outMsgnoHost = msgnoHost;
				//outMsjeHost = msjeHost;
				
				
				
			    bodyOut.FillBobyHost(respuesta.getMsgno()+respuesta.getMensaje());
			   // bodyOut.toShowData();
		   }
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Verificar si hubo error a nivel de interfaz			
	

		return bodyOut;		
	}
	
	public BodyLetraCambio enviarLetra (
			BodyLetraCambio cabecera,
			BodyLetraCambio bodyIn
		) throws Exception {

		
		// Input
		BodyLetraCambio bodyOut = null;
		String head = cabecera.toString();
		head = Funciones.validar_texto(head);
		String trama = head + bodyIn;
		String out = null;
		String outMsgnoHost =  null;
		String outMsjeHost = null;
				
		
		GatewayInterfaceProxy proxy = new GatewayInterfaceProxy();
		RequestGateway peticion = new RequestGateway();

		peticion.setLongitud("9999");
	//	peticion.setTransid("WS52");
		peticion.setTransid("WS85");
		peticion.setDatos(trama);
		//peticion.setFiller("00000000000000000");
		peticion.setFiller("");
		bodyOut = new BodyLetraCambio();
		
		//log3.debug("trama In:", trama,Constante.LOGGER_DEBUG_NIVEL_2);
		
		// respuesta 
		ResponseGateway respuesta = new ResponseGateway();
		respuesta = proxy.enviarTramaConsulta(peticion);
		
		System.out.println("respuesta.getMensaje()"+respuesta.getMensaje());
		System.out.println("respuesta.getMsgno()"+respuesta.getMsgno());
		
		
		System.out.println("respuesta.getDatos():"+respuesta.getDatos());
		
		String msgnoHost = "";
		String msjeHost = "";
		String tramaMensajes = "";
		
		
		try {
			
			if (("0000".equals(respuesta.getMsgno())) && (!respuesta.getDatos().equals(""))) {
				
				//log3.debug("trama Out:", respuesta.getDatos(),Constante.LOGGER_DEBUG_NIVEL_2);
				
				BodyLetraCambio cabOut  = new BodyLetraCambio();
				
				System.out.println("LONGITUD DATOS: "+respuesta.getDatos().length());
				System.out.println("LONGITUD TRAMA: "+cabOut.LongitudTrama());
				
				
				if(respuesta.getDatos().length()< cabOut.LongitudTrama()){
					
					throw new Exception("La cabecera del cics soap no es válida.");	
				}
				
				 msgnoHost = respuesta.getMsgno();
			   	 msjeHost = respuesta.getMensaje();
			   	
			   	 tramaMensajes = msgnoHost+msjeHost;
			   	 
			   	 System.out.println("TRAMA MENSAJES B: "+tramaMensajes);
			   	 System.out.println("LONGITUD TRAMA MENSAJES B: "+tramaMensajes.length());
					
			     out = respuesta.getDatos()+tramaMensajes;
			     
			     System.out.println("LONGITUD TRAMA TOTAL: "+out.length());
			     
			   
			     
			     bodyOut.FillBoby(out);
			     //bodyOut.FillBobyHost(tramaMensajes);
			     bodyOut.toShowData();
			}
		
		   if(("9995".equals(respuesta.getMsgno())) && (respuesta.getDatos().equals(""))){
				
			   	msgnoHost = respuesta.getMsgno();
			   	msjeHost = respuesta.getMensaje();
			   	
			   	tramaMensajes = msgnoHost+msjeHost;
			   	
			   	System.out.println("TRAMA MENSAJES M: "+tramaMensajes);
			   	System.out.println("LONGITUD TRAMA MENSAJES M: "+tramaMensajes.length());
				
				//outMsgnoHost = msgnoHost;
				//outMsjeHost = msjeHost;
			 
			    
			    bodyOut.FillBoby(tramaMensajes);
			    bodyOut.toShowData();
		   }
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Verificar si hubo error a nivel de interfaz			
	

		return bodyOut;		
	}
	

	
	public BodyPase enviarPase (
			BodyPase cabecera,
			BodyPase bodyIn
		) throws Exception {

		
		// Input
		BodyPase bodyOut = null;
		String head = cabecera.toString();
		head = Funciones.validar_texto(head);
		String trama = head + bodyIn;
		String out = null;
		String outMsgnoHost =  null;
		String outMsjeHost = null;
				
		
		GatewayInterfaceProxy proxy = new GatewayInterfaceProxy();
		RequestGateway peticion = new RequestGateway();

		peticion.setLongitud("9999");
	//	peticion.setTransid("WS52");
		peticion.setTransid("WS85");
		peticion.setDatos(trama);
		//peticion.setFiller("00000000000000000");
		peticion.setFiller("");
		bodyOut = new BodyPase();
		
		//log3.debug("trama In:", trama,Constante.LOGGER_DEBUG_NIVEL_2);
		
		// respuesta 
		ResponseGateway respuesta = new ResponseGateway();
		respuesta = proxy.enviarTramaConsulta(peticion);
		
		System.out.println("respuesta.getMensaje()"+respuesta.getMensaje());
		System.out.println("respuesta.getMsgno()"+respuesta.getMsgno());
		
		
		System.out.println("respuesta.getDatos():"+respuesta.getDatos());
		
		String msgnoHost = "";
		String msjeHost = "";
		String tramaMensajes = "";
		
		
		try {
			
			if (("0000".equals(respuesta.getMsgno())) && (!respuesta.getDatos().equals(""))) {
				
				//log3.debug("trama Out:", respuesta.getDatos(),Constante.LOGGER_DEBUG_NIVEL_2);
				
				BodyPase cabOut  = new BodyPase();
				
				System.out.println("LONGITUD DATOS: "+respuesta.getDatos().length());
				System.out.println("LONGITUD TRAMA: "+cabOut.LongitudTrama());
				
				
				if(respuesta.getDatos().length()< cabOut.LongitudTrama()){
					
					throw new Exception("La cabecera del cics soap no es válida.");	
				}
				
				 msgnoHost = respuesta.getMsgno();
			   	 msjeHost = respuesta.getMensaje();
			   	
			   	 tramaMensajes = msgnoHost+msjeHost;
			   	 
			   	 System.out.println("TRAMA MENSAJES B: "+tramaMensajes);
			   	 System.out.println("LONGITUD TRAMA MENSAJES B: "+tramaMensajes.length());
					
			     out = respuesta.getDatos()+tramaMensajes;
			     
			     System.out.println("LONGITUD TRAMA TOTAL: "+out.length());
			     
			   
			     
			     bodyOut.FillBoby(out);
			     //bodyOut.FillBobyHost(tramaMensajes);
			     bodyOut.toShowData();
			}
		
		   if(("9995".equals(respuesta.getMsgno())) && (respuesta.getDatos().equals(""))){
				
			   	msgnoHost = respuesta.getMsgno();
			   	msjeHost = respuesta.getMensaje();
			   	
			   	tramaMensajes = msgnoHost+msjeHost;
			   	
			   	System.out.println("TRAMA MENSAJES M: "+tramaMensajes);
			   	System.out.println("LONGITUD TRAMA MENSAJES M: "+tramaMensajes.length());
				
				//outMsgnoHost = msgnoHost;
				//outMsjeHost = msjeHost;
			 
			    
			    bodyOut.FillBoby(tramaMensajes);
			    bodyOut.toShowData();
		   }
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Verificar si hubo error a nivel de interfaz			
	

		return bodyOut;		
	}
	
	
	
	
	
	public BodyGeneracionCronogramaRepro enviarTramaRepro (
			BodyGeneracionCronogramaRepro cabecera,
			//Head cabecera,
			BodyGeneracionCronogramaRepro body
		) throws Exception {

		
		// Input
		BodyGeneracionCronogramaRepro bodyOut = null;
		String head = cabecera.toString();
		head = Funciones.validar_texto(head);
		String trama = head + body;
		String out = null;
		String outMsgnoHost =  null;
		String outMsjeHost = null;
		
		GatewayInterfaceProxy proxy = new GatewayInterfaceProxy();
		RequestGateway peticion = new RequestGateway();

		peticion.setLongitud("9999");
	//	peticion.setTransid("WS52");
		peticion.setTransid("WS85");
		peticion.setDatos(trama);
		//peticion.setFiller("00000000000000000");
		peticion.setFiller("");
		bodyOut = new BodyGeneracionCronogramaRepro();
		
		//log3.debug("trama In:", trama,Constante.LOGGER_DEBUG_NIVEL_2);
		
		// respuesta 
		ResponseGateway respuesta = new ResponseGateway();
		respuesta = proxy.enviarTramaConsulta(peticion);
		
		System.out.println("respuesta.getMensaje()"+respuesta.getMensaje());
		System.out.println("respuesta.getMsgno()"+respuesta.getMsgno());
		
		
		System.out.println("respuesta.getDatos():"+respuesta.getDatos());
		
		String msgnoHost = "";
		String msjeHost = "";
		String tramaMensajes = "";
		
		
		try {
			
			if (("0000".equals(respuesta.getMsgno())) && (!respuesta.getDatos().equals(""))) {
				
				//log3.debug("trama Out:", respuesta.getDatos(),Constante.LOGGER_DEBUG_NIVEL_2);
				
				BodyGeneracionCronogramaRepro cabOut  = new BodyGeneracionCronogramaRepro();
				
				System.out.println("LONGITUD DATOS: "+respuesta.getDatos().length());
				System.out.println("LONGITUD TRAMA: "+cabOut.LongitudTrama());
				
				
				if(respuesta.getDatos().length()< cabOut.LongitudTrama()){
					
					throw new Exception("La cabecera del cics soap no es válida.");	
				}
				
				 msgnoHost = respuesta.getMsgno();
			   	 msjeHost = respuesta.getMensaje();
			   	
			   	 tramaMensajes = msgnoHost+msjeHost;
			   	 
			   	 System.out.println("TRAMA MENSAJES B: "+tramaMensajes);
			   	 System.out.println("LONGITUD TRAMA MENSAJES B: "+tramaMensajes.length());
					
			     out = respuesta.getDatos()+tramaMensajes;
			     
			     System.out.println("LONGITUD TRAMA TOTAL: "+out.length());
			     
			     bodyOut.FillBobyOk(out);
			     //bodyOut.FillBobyHost(tramaMensajes);
			     bodyOut.toShowData();
			}
		
		   if(("9995".equals(respuesta.getMsgno())) && (respuesta.getDatos().equals(""))){
				
			   	msgnoHost = respuesta.getMsgno();
			   	msjeHost = respuesta.getMensaje();
			   	
			   	tramaMensajes = msgnoHost+msjeHost;
			   	
			   	System.out.println("TRAMA MENSAJES M: "+tramaMensajes);
			   	System.out.println("LONGITUD TRAMA MENSAJES M: "+tramaMensajes.length());
				
				//outMsgnoHost = msgnoHost;
				//outMsjeHost = msjeHost;
			    bodyOut.FillBobyHost(tramaMensajes);
			    bodyOut.toShowData();
		   }
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Verificar si hubo error a nivel de interfaz			
	

		return bodyOut;		
	}
	
	
	
	
	
	
	//---------------------- 07 TIPO------------------

	public BodySolicitudPrestamo enviarTrama(
			BodySolicitudPrestamo cabecera,
			//Head cabecera,
			BodySolicitudPrestamo body
		) throws Exception {

		
		// Input
		BodySolicitudPrestamo bodyOut = null;
		String head = cabecera.toString();
		head = Funciones.validar_texto(head);
		String trama = head + body;
		String out = null;
		String outMsgnoHost =  null;
		String outMsjeHost = null;
		
		GatewayInterfaceProxy proxy = new GatewayInterfaceProxy();
		RequestGateway peticion = new RequestGateway();

		peticion.setLongitud("9999");
		//peticion.setTransid("WS52");
		peticion.setTransid("WS85");
		peticion.setDatos(trama);
		//peticion.setFiller("00000000000000000");
		peticion.setFiller("");
		bodyOut = new BodySolicitudPrestamo();
		
		//log3.debug("trama In:", trama,Constante.LOGGER_DEBUG_NIVEL_2);
		
		// respuesta 
		ResponseGateway respuesta = new ResponseGateway();
		respuesta = proxy.enviarTramaConsulta(peticion);
		
		System.out.println("respuesta.getMensaje()"+respuesta.getMensaje());
		System.out.println("respuesta.getMsgno()"+respuesta.getMsgno());
		
		//RESPONSE HOST TRADICIONAL DESARROLLO CASO 0438160762911
	    //respuesta.setDatos("070438160762911NUEVO     20/10/2023PRESTAMO MULTIRED        MARCELO HUAMALI YOLANDA                                               DNI 20902766     06/04/1960S SOLTERO FEMENINO  0000000   945749629 CJ VILLA SOLEDAD 1 MZ Z LT 02 SECTOR OESTE JI                         CARABAYLLO                              LIMA                                    LIMA                                                                                                          YMARCELO@GMAIL.COM                                                    N0INDIVIDUAL        NOMBRADO       0068 UNIDAD DE GESTION ED     01 7284596          000000000392373                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        000000000000000000000003500000000000003459365SNN16001699000000000000000000193004381607629               000000001200000000000000040635060SOL       00000000008775504 381 607629 10000000000000000000000003459365CRCO CRIBILLERO BLAS DELBERT OMAR            CRCO CRIBILLERO BLAS DELBERT OMAR            3340                                         0000                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   *");
		
		//RESPONSE HOST TRADICIONAL DESARROLLO CASO 0438160762911

		
		//RESPONSE HOST RETORNO DESARROLLO CASO 0401135346601

	   ////respuesta.setDatos("070401135346601NUEVO     20/10/2023PRESTAMO MULTIRED        YANALLALLI SARMIENTO MARYBEL LILIANA                                  DNI 09581695     03/08/1970S SOLTERO FEMENINO  4872554   978951598 CO UMAMARCA  MZ M LT 3                                                SAN JUAN DE MIRAFLORES                  LIMA                                    LIMA                                                                                                          MARY3870@LIVE.COM                                                     S1RETORNO           NOMBRADO       0000 BANCO DE LA NACION       01 2583601          000000000400754                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        000000000000000000000002600000000000002569814SNN18001699000000000000000000194804011353466               000000001330000000000000030186060SOL       000000000065474                000000000000000000000002569814CRCO CRIBILLERO BLAS DELBERT OMAR            CRCO CRIBILLERO BLAS DELBERT OMAR            3340                                         0000                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   *");	
		
		//RESPONSE HOST RETORNO DESARROLLO CASO 0401135346601
		
		//TODO PRESTAMO 07 MELANIE
		
		respuesta.setDatos("070401340348703RENOVACION15/01/2025PRESTAMO MULTIRED        FARRO VIDARTE GRIDELINA                                               DNI 80544424     11/01/1975S SOLTERO FEMENINO  4875222   964660320  MZR LT9G MCDO CTRAL PACHACUTEC VENT  MZ R LT                         VENTANILLA                              PROV  CONST CALLAO                      PROV CONSTITUCIONAL                                                                                           GRIDELINAFARROVIDARTE@GMAIL.COM                                       N3TRADICIONAL       NOMBRADO       1725 UND DE GESTION EDU L     01 5248800          000000000218276                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        000000000000000000000004500000000000003695416NNN16001649000000000000000000181604013403487               000000001200000000000000000000072SOL      000000000010022304 013 403487 02000000000804584000000003695416CRCO CRIBILLERO BLAS DELBERT OMAR            CRCO CRIBILLERO BLAS DELBERT OMAR            3111 SECCION APERTURA                        0000                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   *");
		System.out.println("respuesta.getDatos():"+respuesta.getDatos());
		
		String msgnoHost = "";
		String msjeHost = "";
		String tramaMensajes = "";
		
		
		try {
			
			if (("0000".equals(respuesta.getMsgno())) && (!respuesta.getDatos().equals(""))) {
				
				//log3.debug("trama Out:", respuesta.getDatos(),Constante.LOGGER_DEBUG_NIVEL_2);
				
				BodySolicitudPrestamo cabOut  = new BodySolicitudPrestamo();
				
				System.out.println("LONGITUD DATOS: "+respuesta.getDatos().length());
				System.out.println("LONGITUD TRAMA: "+cabOut.LongitudTrama());
				
				
				if(respuesta.getDatos().length()< cabOut.LongitudTrama()){
					
					throw new Exception("La cabecera del cics soap no es válida.");	
				}
				
				 msgnoHost = respuesta.getMsgno();
			   	 msjeHost = respuesta.getMensaje();
			   	
			   	 tramaMensajes = msgnoHost+msjeHost;
			   	 
			   	 System.out.println("TRAMA MENSAJES B: "+tramaMensajes);
			   	 System.out.println("LONGITUD TRAMA MENSAJES B: "+tramaMensajes.length());
					
			     out = respuesta.getDatos()+tramaMensajes;
			     
			     System.out.println("LONGITUD TRAMA TOTAL: "+out.length());
			     
			     bodyOut.FillBobyOk(out);
			     //bodyOut.FillBobyHost(tramaMensajes);
			     bodyOut.toShowData();
			}
		
		   if(("9995".equals(respuesta.getMsgno())) && (respuesta.getDatos().equals(""))){
				
			   	msgnoHost = respuesta.getMsgno();
			   	msjeHost = respuesta.getMensaje();
			   	
			   	tramaMensajes = msgnoHost+msjeHost;
			   	
			   	System.out.println("TRAMA MENSAJES M: "+tramaMensajes);
			   	System.out.println("LONGITUD TRAMA MENSAJES M: "+tramaMensajes.length());
				
				//outMsgnoHost = msgnoHost;
				//outMsjeHost = msjeHost;
			    bodyOut.FillBobyHost(tramaMensajes);
			    bodyOut.toShowData();
		   }
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Verificar si hubo error a nivel de interfaz			
	

		return bodyOut;		
	}
	

	
	public String enviarTrama (
			Head cabecera, 
			String body
		) throws Exception {

		
		// Input
		String head = cabecera.toString();
		head = Funciones.validar_texto(head);
		String trama = head + body;
		String out = null;
		
		GatewayInterfaceProxy proxy = new GatewayInterfaceProxy();
		RequestGateway peticion = new RequestGateway();

		// longitud de la trama
		peticion.setLongitud("9999");
		// nombre del programa
		peticion.setTransid(cabecera.getByTag("HD-TRAN"));
		peticion.setDatos(trama);
		peticion.setFiller(""); 
		
		log3.debug("trama:", trama,Constante.LOGGER_DEBUG_NIVEL_2);
		
	//	ResourceBundle rb = ResourceBundle.getBundle("parametro");
		
	//	String keyPath = rb.getString("bn.claveSegura.gate.keyPath");
	//	byte[] bytes = convertToByte(keyPath);
		
		
		// respuesta 
		ResponseGateway respuesta = new ResponseGateway();	
		respuesta = proxy.enviarTramaConsulta(peticion);
		
		System.out.println("respuesta.getMensaje()"+respuesta.getMensaje());
		System.out.println("respuesta.getMsgno()"+respuesta.getMsgno());
		
		// Verificar si hubo error a nivel de interfaz			
		if (("0000".equals(respuesta.getMsgno())) && (!respuesta.getDatos().equals(""))) {
			
			Head cabOut  = new Head();
			if(respuesta.getDatos().length()< cabOut.LongitudTrama()){
				throw new Exception("La cabecera del cics soap es invalido.");	
			}
			
			String head1 =  respuesta.getDatos().substring(0,cabOut.LongitudTrama());
			
			cabOut.FillBoby(head1);
			log3.debug("cab out:", cabOut.toShowData(),Constante.LOGGER_DEBUG_NIVEL_2);
			
			if(!cabOut.getByTag("HD-COD-RET").equals("00000")){
				
				throw new Exception("La operación cics soap generó un error: (" + cabOut.getByTag("HD-COD-RET") + "/" + cabOut.getByTag("HD-DES-RET") + ").");
			}			
			out = respuesta.getDatos().substring(cabOut.LongitudTrama());
		}

		return out;		
	}
	
	
	
	
	

	public String enviarTramaP (
			Head cabecera, 
			String body
		) throws Exception {

		
		// Input
		String head = cabecera.toString();
		head = Funciones.validar_texto(head);
		String trama = head + body;
		String out = null;
		
		GatewayInterfaceProxy proxy = new GatewayInterfaceProxy();
		RequestGateway peticion = new RequestGateway();

		// longitud de la trama
		peticion.setLongitud("9999");
		// nombre del programa
		peticion.setTransid(cabecera.getByTag("HD-TRAN"));
		peticion.setDatos(trama);
		peticion.setFiller(""); 
		
		log3.debug("trama:", trama,Constante.LOGGER_DEBUG_NIVEL_2);
		
	//	ResourceBundle rb = ResourceBundle.getBundle("parametro");
		
	//	String keyPath = rb.getString("bn.claveSegura.gate.keyPath");
	//	byte[] bytes = convertToByte(keyPath);
		
		
		// respuesta 
		ResponseGateway respuesta = new ResponseGateway();	
		respuesta = proxy.enviarTramaConsulta(peticion);
		
		System.out.println("respuesta.getMensaje()"+respuesta.getMensaje());
		System.out.println("respuesta.getMsgno()"+respuesta.getMsgno());
		
		// Verificar si hubo error a nivel de interfaz			
		if (("0000".equals(respuesta.getMsgno())) && (!respuesta.getDatos().equals(""))) {
			
			Head cabOut  = new Head();
			if(respuesta.getDatos().length()< cabOut.LongitudTrama()){
				throw new Exception("La cabecera del cics soap es invalido.");	
			}
			
			String head1 =  respuesta.getDatos().substring(0,cabOut.LongitudTrama());
			
			cabOut.FillBoby(head1);
			log3.debug("cab out:", cabOut.toShowData(),Constante.LOGGER_DEBUG_NIVEL_2);
			
			if(!cabOut.getByTag("HD-COD-RET").equals("00000")){
				
				throw new Exception("La operación cics soap generó un error: (" + cabOut.getByTag("HD-COD-RET") + "/" + cabOut.getByTag("HD-DES-RET") + ").");
			}			
			out = respuesta.getDatos().substring(cabOut.LongitudTrama());
		}

		return out;		
	}
	
	public static byte[] convertToByte(String filePath)throws Exception {

        File file = new File(filePath);
        FileInputStream fileInputStream;
        byte[] data = null;
        byte[] finalData = null;
        ByteArrayOutputStream byteArrayOutputStream = null;

        try {
           fileInputStream = new FileInputStream(file);
           data = new byte[(int)file.length()];
           finalData = new byte[(int)file.length()];
           byteArrayOutputStream = new ByteArrayOutputStream();

           fileInputStream.read(data);
           byteArrayOutputStream.write(data);
           finalData = byteArrayOutputStream.toByteArray();

           fileInputStream.close(); 

       } catch (FileNotFoundException e) {
          e.printStackTrace();
       } catch (IOException e) {
    	   e.printStackTrace();
       }

       return finalData;

   }

	
}

