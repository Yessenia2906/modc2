package pe.com.bn.modc.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUser extends User {
	
	private static final long serialVersionUID = -4177569885154948770L;

	private String nombre;
	private String codAgencia;
	private String desAgencia;
	private String codUsuario;
	private String codEmpleado;
	
	public CustomUser(	String username, 
						String password, 
						boolean enabled,
						boolean accountNonExpired, 
						boolean credentialsNonExpired,
						boolean accountNonLocked,
						Collection<? extends GrantedAuthority> authorities,
						String nombre, 
						String codAgencia, 
						String desAgencia,
						String codUsuario, 
						String codEmpleado) {
		
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		
		this.nombre = nombre;
		this.codAgencia = codAgencia;
		this.desAgencia = desAgencia;
		this.codUsuario = codUsuario;
		this.codEmpleado = codEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodAgencia() {
		return codAgencia;
	}

	public void setCodAgencia(String codAgencia) {
		this.codAgencia = codAgencia;
	}

	public String getDesAgencia() {
		return desAgencia;
	}

	public void setDesAgencia(String desAgencia) {
		this.desAgencia = desAgencia;
	}

	public String getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getCodEmpleado() {
		return codEmpleado;
	}

	public void setCodEmpleado(String codEmpleado) {
		this.codEmpleado = codEmpleado;
	}

	@Override
	public String toString() {
		return "CustomUser [nombre=" + nombre + ", codAgencia=" + codAgencia
				+ ", desAgencia=" + desAgencia + ", codUsuario=" + codUsuario
				+ ", codEmpleado=" + codEmpleado + "]";
	}
	
}
