package pe.com.bn.modc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import pe.com.bn.modc.common.LoggerBn;
import pe.com.bn.modc.common.View;
import pe.com.bn.modc.listener.CompService;

@Controller
public class IndexController {

	private static LoggerBn log = LoggerBn.getInstance(IndexController.class.getName());
	@Autowired
	private CompService compService;
	@RequestMapping("/")
	public String showIndex(Model model) {
		return "redirect:/login";
	}

//	@RequestMapping("/about")
//	public String showAbout(SessionStatus sessionStatus) {
//		sessionStatus.setComplete();
//		return "about";
//	}

	@RequestMapping("/welcome")
	public String welcome(SessionStatus sessionStatus, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path = View.returnJsp(model, null);
		compService.asignarParametros();
		log.debug("IndexController | /welcome | path:" + path, "1");
		
		return path;
	}
	
//	@RequestMapping("/home")
//	public String showHome(SessionStatus sessionStatus, ModelMap model, HttpServletRequest request, HttpServletResponse response) {
//		
//		String path = View.returnJsp(model, null);
//		log.debug("IndexController | /home | path:" + path, "1");
//		
//		return path;
//	}

	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error, Model model) {
		return "template/login";
	}

//	@RequestMapping("/logout")
//	public String logout() {
//		return "/";
//	}
	
	@RequestMapping("/cerrarSesion")
	public String logout() {
		return "/";
	}
	
	@RequestMapping(value = "/403")
	public String accessDenied(ModelMap model) {
		
		String path = View.returnJsp(model, "404");
		log.debug("IndexController | /403 | path:" + path, "1");
		
		return path;
	}
	
}
