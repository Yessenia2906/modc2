package pe.com.bn.modc.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pe.com.bn.modc.common.Constant;
import pe.com.bn.modc.common.DatosSesion;
import pe.com.bn.modc.common.LoggerBn;
import pe.com.bn.modc.common.Util;
import pe.com.bn.modc.common.View;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import seguridad.service.AutenticaRegProxy;

@Controller
public class LoginController {

	private static LoggerBn log3 = LoggerBn.getInstance(LoginController.class.getName());

//	 @Autowired
//	 public AdministracionController administracionController; 
	
//	@RequestMapping("inicio")   
//	   public String inicio(ModelMap model,List arrVal) throws Exception {
//		
//		return "login";
//	}
	
//   @RequestMapping("login")   
//   public String login(ModelMap model,DatosSesion datosSesion,HttpServletRequest request,HttpServletResponse response) throws Exception {
//	   		String[] arrayDatos=null;	
//	   		String mensaje=null;
//	   		String cadenaPermisos=null;
//	   		List<String> arrayPermisos=null;
//	   		
//			request.getSession().invalidate();
//			Cookie[] cookies = request.getCookies();
//			if(null != cookies &&cookies.length> 0){
//				for(Cookie cookie: cookies){
//					cookie.setMaxAge(0);
//				}
//			} 
//	   		
//	   		if(datosSesion.getCodUsuario()==null || datosSesion.getCodUsuario().trim().equals("")){ 
//	  			model.addAttribute("mensaje","Ingrese Usuario");
//	  			return "template/login";
//	   		}
//	   		if(datosSesion.getClave()==null || datosSesion.getClave().trim().equals("")){ 
//	   			model.addAttribute("mensaje","Ingrese clave");
//	  			return "template/login";
//	   		}
//	   		datosSesion.setCodUsuario(datosSesion.getCodUsuario().toUpperCase());
//	   		
//	   		arrayDatos=validaUsuario(datosSesion);
//	   		if(!arrayDatos[0].equals("00")){
//	  			if(arrayDatos.length==1){
//	   				mensaje=arrayDatos[0].toString();
//	   				}
//	   			else{
//	   				mensaje=arrayDatos[1].toString();
//	   			}
//	  			model.addAttribute("mensaje",mensaje);
//	  			return "template/login";
//	   		}
//    		
//	   	  	
//	   		
   //		datosSesion.setCodAgencia(arrayDatos[1].trim());
//			datosSesion.setCodEmpleado(arrayDatos[3].trim());				
//			cadenaPermisos=arrayDatos[4].toString();
//			datosSesion.setNombres(arrayDatos[5].trim());
//			datosSesion.setDesAgencia(arrayDatos[6].trim());
//			arrayPermisos=new ArrayList<String>();
//			for(int j=2;j<cadenaPermisos.length();j++){
//	    		if(cadenaPermisos.substring(j,j+1).equals("S")){
//	    			arrayPermisos.add(cadenaPermisos.substring(j-2,j));
//	    		}
//	    		j=j+2;
//	    	}
//			 
//			datosSesion.setPermisos(arrayPermisos);
//
//			HttpSession sesion = request.getSession(true);
//			sesion.setAttribute("datosSesion",datosSesion);
//
//           return welcome(model,request,response);
//           
//   }   
   
  
//   @RequestMapping("welcome")   
//   public String welcome(ModelMap model,HttpServletRequest request,HttpServletResponse response) throws Exception {
//   	   String path =  View.returnJsp(model,null);
//	  return path;   
//   }
   
//	@RequestMapping("cerrarSesion")
//	public String cerrarSesion(ModelMap model, HttpServletRequest request) throws Exception {
//
//		HttpSession session = request.getSession(false);
//		
//		if (session != null) {
//			
//			java.util.Enumeration<java.lang.String> atributos = session.getAttributeNames();
//			
//			while (atributos != null && atributos.hasMoreElements()) {
//				String key = (String) atributos.nextElement();
//				session.removeAttribute(key);
//			}
//			session.invalidate();
//		}
//
//		return "template/login";
//	}
   
//	private  String[] validaUsuario(DatosSesion datosSesion) throws Exception{
//		
//		String[] arrayDatos=null;
//		String cadenaHost=null;
//   		AutenticaRegProxy proxy=new AutenticaRegProxy();
//		 
//   		datosSesion.setCodUsuario(Util.lpad(datosSesion.getCodUsuario(),4));
//		datosSesion.setClave(Util.lpad(datosSesion.getClave(),8));
//		try {
//			cadenaHost=proxy.claveHost(datosSesion.getCodUsuario().toUpperCase()+
//			datosSesion.getClave().toUpperCase()+
//						Constant.VAR_GLB_COD_APLICATIVO+Constant.CONST_ID_DESA);
//			
//	                  //0 |  1 |2|   3   |                                     4                                                    |              5                    |             6               |                                7                 |8|    9   | 10 |
//
//					//cadenaHost="00|0372|1|0000000|01S02S03S04S05S06S07S08S09S10S11S12S13S14S15N16N17N18N19N20N21N22N23N24N25N26N27N28N29N30N|FIORELLA GALVAN                    |MEDIOS ELECTRONICOS          |Su acceso ha sido exitoso                         |1|00000000|000 |                         |";
//			arrayDatos=cadenaHost.split("\\|");
//		} catch (Exception e) {
//			log3.error(e,Constant.ERR_LOGICA_NEGOCIO,"");		
//    		arrayDatos=new String[8];   		 
//	   		arrayDatos[0]="99";
//	   		arrayDatos[1]="El Sistema de claves esta inactivo "; 
//		}
//		
//		 return arrayDatos;
//		
//		
//	}

}
