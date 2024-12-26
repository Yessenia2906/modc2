package seguridad.service;

import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class XssAndSqlHttpServletRequestWrapper extends HttpServletRequestWrapper
{
	HttpServletRequest orgRequest = null;

	public XssAndSqlHttpServletRequestWrapper(HttpServletRequest request)
	{
		super(request);
		orgRequest = request;
	}

	/**
	  * Superar el método GetParameter, haga que XSS & SQL filtre los nombres de los parámetros y los valores de los parámetros. <br/>
	  * Si se requiere el valor original, se obtiene por super.GetParamETervalues ​​(nombre).
	  * GetParameternames, GetParamETervalues ​​y GetParamEtermap también puede ser sobrescrito
	 */
	@Override
	public String getParameter(String name)
	{
		String value = super.getParameter(xssEncode(name));
		if (value != null)
		{
			value = xssEncode(value);
		}
		return value;
	}

	/**
	  * Superar el método GetTeader, haga nombres de parámetros de filtrado XSS y SQL de filtrado y parámetros. <br/>
	  * Si necesita obtener el valor original, puede obtener Super.Geteaders (Nombre).
	  * Los nombres de getTERNUMN también pueden estar cubiertos
	 */
	@Override
	public String getHeader(String name)
	{
		String value = super.getHeader(xssEncode(name));
		if (value != null)
		{
			value = xssEncode(value);
		}
		return value;
	}

	/**
	  * El carácter de medio ángulo que facilitará la vulnerabilidad XSS y SQL, reemplácela directamente en carácter de ancho completo
	 * 
	 * @param s
	 * @return
	 */
	private static String xssEncode(String s)
	{
		if (s == null || s.isEmpty())
		{
			return s;
		}
		else
		{
			s = stripXSSAndSql(s);
		}
		StringBuilder sb = new StringBuilder(s.length() + 16);
		for (int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			switch (c) {
			case '<':
				sb.append("&lt;");
				break;
			case '>':
				sb.append("&gt;");
				break;
			case '"':
				sb.append("&quot;");
				break;
			case '\'':
				sb.append("&#39;");
				break;
			case '%':
				sb.append("&#37;");
				break;
			case ';':
				sb.append("&#59;");
				break;
			case '(':
				sb.append("&#40;");
				break;
			case ')':
				sb.append("&#41;");
				break;
			case '&':
				sb.append("&amp;");
				break;
			case '+':
				sb.append("&#43;");
				break;
			default:
				sb.append(c);
				break;
		}			
		}
		return sb.toString();
	}

	/**
	  * Obtén la solicitud más original.
	 * 
	 * @return
	 */
	public HttpServletRequest getOrgRequest()
	{
		return orgRequest;
	}

	/**
	  * Obtenga el método estático de solicitud más original.
	 * 
	 * @return
	 */
	public static HttpServletRequest getOrgRequest(HttpServletRequest req)
	{
		if (req instanceof XssAndSqlHttpServletRequestWrapper)
		{
			return ((XssAndSqlHttpServletRequestWrapper) req).getOrgRequest();
		}
		return req;
	}

	/**
	 * 
	  * Evite el ataque XSS CROSS-SCRIPT (Reemplace, ajuste de acuerdo con las condiciones reales)
	 */
	public static String stripXSSAndSql(String value)
	{
		if (value != null)
		{
	        value = value.replaceAll("eval\\((.*)\\)", "");
	        value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");

	        value = value.replaceAll("(?i)<script.*?>.*?<script.*?>", "");
	        value = value.replaceAll("(?i)<script.*?>.*?</script.*?>", "");
	        value = value.replaceAll("(?i)<.*?javascript:.*?>.*?</.*?>", "");
	        value = value.replaceAll("(?i)<.*?\\s+on.*?>.*?</.*?>", "");
	        
			Pattern scriptPattern = Pattern.compile(
					"<[\r\n| | ]*script[\r\n| | ]*>(.*?)</[\r\n| | ]*script[\r\n| | ]*>", Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");
			scriptPattern = Pattern.compile("src[\r\n| | ]*=[\r\n| | ]*[\\\"|\\\'](.*?)[\\\"|\\\']",
					Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");
			scriptPattern = Pattern.compile("</[\r\n| | ]*script[\r\n| | ]*>", Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");
			scriptPattern = Pattern.compile("<[\r\n| | ]*script(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
					| Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");
			scriptPattern = Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
					| Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");
			scriptPattern = Pattern.compile("e-xpression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
					| Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");
			scriptPattern = Pattern.compile("javascript[\r\n| | ]*:[\r\n| | ]*", Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");
			scriptPattern = Pattern.compile("vbscript[\r\n| | ]*:[\r\n| | ]*", Pattern.CASE_INSENSITIVE);
			value = scriptPattern.matcher(value).replaceAll("");
			scriptPattern = Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
					| Pattern.DOTALL);
			value = scriptPattern.matcher(value).replaceAll("");
		}
		return value;
	}
}

