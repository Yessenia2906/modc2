package pe.com.bn.modc.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import pe.com.bn.modc.common.LoggerBn;

public class CustomAuthenticationProvider implements AuthenticationProvider {

	private static LoggerBn log = LoggerBn.getInstance(CustomAuthenticationProvider.class.getName());
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		NServiciosPermiso permiso = new NServiciosPermiso();

		BUsuarioLogin usuario = new BUsuarioLogin();
		usuario.setLogin(authentication.getName());
		usuario.setPassword((String) authentication.getCredentials());

		try {
			usuario = permiso.listarPermisos(usuario);
		} catch (Exception e) {
			log.error(e, "[CustomAuthenticationProvider/authenticate|ERROR usuario = permiso.listarPermisos(usuario);", "");
			throw new BadCredentialsException(e.getMessage());
		}

		if (	usuario.getListaOpciones().size() >= 1
			&& 	usuario.getListaOpciones().get(0).getCodigo().trim().length() == 2) {
			
			log.debug("CustomAuthenticationProvider | Login correcto:" + usuario.getLogin(), "1");
			
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			
			for (BOpcion opcion : usuario.getListaOpciones()) {
				authorities.add(new SimpleGrantedAuthority("ROLE_" + opcion.getCodigo()));
			}

			CustomUser customUser = new CustomUser(	usuario.getLogin(),
													usuario.getPassword(), 
													true, 
													true, 
													true, 
													true, 
													authorities,
													usuario.getNombre(), 
													usuario.getCodAgencia(),
													usuario.getDesAgencia(),
													usuario.getCodUsuario(), 
													usuario.getCodEmpleado());
			
			Authentication auth = new UsernamePasswordAuthenticationToken(customUser, customUser.getPassword(), customUser.getAuthorities());
			
			return auth;

		} else if (usuario != null 
				&& usuario.getListaOpciones().size() == 1
				&& usuario.getListaOpciones().get(0).getCodigo().trim().length() > 2) {
			
			log.debug("CustomAuthenticationProvider | Error de login:" + usuario.getLogin(), "1");
			throw new BadCredentialsException("Usuario y/o clave no son correctos."); //usuario.getListaOpciones().get(0).getCodigo());
		} else {
			log.debug("CustomAuthenticationProvider | Error de login:" + usuario.getLogin(), "1");
			throw new BadCredentialsException("Error no definido");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
