<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml2/DTD/xhtml1-strict.dtd">
<%@page import="pe.com.bn.modc.common.Util"%>
<%@page import="pe.com.bn.modc.common.DatosSesion"%>
<%@page import="pe.com.bn.modc.common.Constant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", " no-store ");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
%>

<html>
<head>

<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Cache-Control" content="max-age=0" />
<meta http-equiv="Expires" content="0" />

<title><%=Constant.VAR_GLB_COD_APLICATIVO%></title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/fontTableroPic1.css" type="text/css"></link>
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/fontTableroPic2.css" type="text/css"></link>
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/styles.css" type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/displaytag.css" type="text/css"></link>

<tag:scripts />

<script type="text/javascript">

function validar(){
	
	if(document.frmLogin.codUsuario.value==''){
		alert('Ingrese la cuenta de usuario.');
		return false;
	}
	if(document.frmLogin.clave.value==''){
		alert('Ingrese la clave.');
		return false;
	}
	return true;
}

function iniciarSesion(){
	
	if(validar()){
		document.frmLogin.submit();
	}
}

</script>

</head>
<body class="" style="background-color: #F0F0F0;">
  <form  id="frmLogin" name="frmLogin" method="post" action="login" runat="server" >
	<input name="method" value="" type="hidden">
	<input type="hidden" name="id" >
	 
	<table class="rxsviewport" cellpadding="0" cellspacing="0" width="100%"  border="0"  height="100%" >
	     
	    <tr>
		    <td valign="top" >	    
				<table cellSpacing="0" cellPadding="0" width="100%" align="center"   >
					<tr>
						<td colspan=7>
						<table cellSpacing="0" cellPadding="0"  width="100%"  border="0">
							<tr> 
							<td vAlign="top" align="left">
							 
							<IMG src="<%=request.getContextPath()%>/assets/img/header/banner_r1.png" alt=""    />	</td>
							<td vAlign="top"  width="100%"  ><IMG src="<%=request.getContextPath()%>/assets/img/header/banner_r2.png" alt="" height="105"      width="100%" /></td>
							<td vAlign="top" align="right">
							<IMG src="<%=request.getContextPath()%>/assets/img/header/banner_r3.png" alt=""    />						</td>
							</tr>					
						</table> 
		 				 </td>
				  </tr>								  
				</table>    
		    </td>
	    </tr>
	    <tr><td style="height: 30px"></td></tr>
		<tr>
			<td valign="middle" align="center" style="height: 100%;"  height="100%" >
					<table class="rxbn" cellpadding="4" cellspacing="1" 	style="width: 600px" align="center">
						<tr>
							<th  class="rxtitle" style="height: 40px;font-size:18px;"    > 
							<i class="forma-icon fa fa-user" style="color:#d15b47;font-size: 30px;"></i>
							Acceso al Sistema
							</th>
							
						</tr>
						<tr>
							<td class="rxcontainer">

								<table cellpadding="4" width="100%">
			 						<tr><td style="height: 20px"></td></tr>	
									<tr>
										<td align="center">

											<table>
												<tr><td>&nbsp;</td></tr>
												<tr>
													<td width="80px" align="left">Usuario:</td>
													<td><input type="text" id="codUsuario" name="username" value="" style="width: 200px;"  maxlength="4"  onkeypress="return imposeMaxLength(event, this,4,2);" autocomplete="off" /></td>
												</tr>
												<tr>
													<td align="left">Contrase&ntilde;a:</td>
													<td><input type="password" id="clave" name="password" value=""  style="width: 200px;"  onkeypress="return imposeMaxLength(event, this,8,3);" maxlength="8" autocomplete="off" /></td>
												</tr>
												<tr><td style="height: 30px"></td></tr>	
												<tr>
													<td colspan="2"><input type="button" class="buttonCls" submit="true" style="width: 140px" value="Iniciar Sesi&oacute;n"  onclick="iniciarSesion();" /></td>
												</tr>
												<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
													<tr >
														<td style="color:red;" colspan=2 align="center">
	<%-- 														<c:out value="${mensaje}" /> --%>
															<div id="error" class="ErrorMsg">	
																<p style="text-align: center">
																	<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
																</p>
															</div>
														</td>
													</tr>
												</c:if>
											</table>
										</td>
									</tr>
									<tr><td>&nbsp;</td></tr>
								</table>
							</td>
						</tr>
						<tr>
					
						 <td align="rignth">v10</td>
						
						</tr>
					</table>
			</td>
		</tr>
	    <tr><td style="height: 50px"></td></tr>		
	</table>
							
</form>
</body>
</html>