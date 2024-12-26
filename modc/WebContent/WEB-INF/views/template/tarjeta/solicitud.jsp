<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml2/DTD/xhtml1-strict.dtd">
<%@page import="pe.com.bn.modc.common.Util"%><title>Titulo</title>
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

<title>PRESTAMO MULTIRED</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/fontTableroPic1.css" type="text/css"></link>
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/fontTableroPic2.css" type="text/css"></link>
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/styles.css" type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/displaytag.css" type="text/css"></link>

<tag:scripts />

<script type="text/javascript">


function soloNumeros(e){
alert(e);
	var key = window.Event ? e.which : e.keyCode
	return (key >= 48 && key <= 57)
}

function limpiar(){	
	document.getElementById("divResultBuscar").innerHTML=document.getElementById("divVacio").innerHTML;
	document.getElementById("buttonExportar").style.display='block';	
}



function enviar(){


   document.exSolicitudEnviar.submit();
}



function exportar(numero){


   document.exSolicitud.submit();
   

   
}



function validar(){

if (document.frmLogin.tipo.value.length > 5) {
     alert("Seleccionar tipo");
     return false;
    } 
	
	 if (document.frmLogin.numero.value.length < 12) {
     alert("Documento m\u00EDnimo 12 digitos");
     return false;
    }  
	

   if(document.frmLogin.numero.value==''){
		alert('Ingrese su Documento.');
		
		return false;
	} 
	
	return true;
}

function iniciarSesion(){
	 
	
	if(validar()){
	

    
     
		document.frmLogin.submit();
	}
	
	
	
}

function checkIt(evt) {

    evt = (evt) ? evt : window.event
    var charCode = (evt.which) ? evt.which : evt.keyCode
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        status = "Solo numeros"
        return false
    }
    status = ""
    return true
}
    
 
</script>



</head>
<body class="" style="background-color: #F0F0F0F;">

<c:url var="url" value="/" />

<form  id="enviar2" name="enviar2" method="post" action="<c:out value='${url}'/>enviar2" runat="server"   >
	<input name="method" value="" type="hidden">
	<input type="hidden" name="id" >
</form>
  
<form id="exSolicitud" name="exSolicitud" method="post" action="<c:out value='${url}'/>exSolicitud"   runat="server" >
	<input	id="numero" name="numero" value = "<c:out value="${solicitud.NROTARJETA}"  />" type="hidden" /> 
	<input	id="tipo" name="tipo" value = "<c:out value="${solicitud.NUMDOC}"  />" type="hidden" /> 
	<input	id="enviar" name="enviar" value = "NO" type="hidden" /> 
	<input	id="pol1" name="pol1" type="hidden" /> 
	<input	id="sol1" name="sol1" type="hidden"  />
</form>

<form id="exSolicitudEnviar" name="exSolicitudEnviar" method="post" action="<c:out value='${url}'/>enviar2"   runat="server" >
	<input	id="numero" name="numero" value = "<c:out value="${solicitud.NUMDOC}"  />" type="hidden" /> 
	<input	id="enviar" name="enviar" value = "SI" type="hidden" /> 
	<input	id="pol1" name="pol1" type="hidden" /> 
	<input	id="sol1" name="sol1" type="hidden" /> 
</form>


<form  id="frmLogin" name="frmLogin" method="post" action="<c:out value='${url}'/>solicitudG" runat="server"   >
	<input name="method" value="" type="hidden">
	<input type="hidden" name="id" >
	 
	 
	<table class="rxsviewport" cellpadding="0" cellspacing="0" width="100%"  border="0"  height="100%" >
	     
	
	    <tr><td style="height: 5px"></td></tr>
		<tr>
			<td valign="middle" align="center" style="height: 100%;"  height="100%" >
					<table class="rxbn" cellpadding="4" cellspacing="1" 	style="width:900px" align="center">
						<tr>
							<th  class="rxtitle" style="height: 14px;font-size:15px;" align="center"  > 
							&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;
						&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
						&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp; Emisi&oacute;n de Solicitud - Tarjeta de Cr&eacute;dito
							</th>
							
						</tr>
						<tr>
							<td class="rxcontainer">

								<table cellpadding="4" width="100%">
			 						<tr></tr>	
									<tr>
										<td align="left">

											<table width="100%">
												
												
												<tr>
													
												
													<td width="24%" align="center">Tipo de Tarjeta:&nbsp;&nbsp; 
													<select id="tipo" name="tipo" onchange="mostrar_control()">
		                                            <option value="Seleccionar">Seleccionar</option>
                                                    <option value="1">Cl&aacute;sica - 5450</option>
                                                    <option value="2">Oro - 5227</option>
                                                    <option value="3">Platinum - 5216</option>             
                                                    </select>



													
												</tr>
												
												<tr>
													
												
													<td width="24%" align="center">N&ordm; de Tarjeta:&nbsp;&nbsp; &nbsp;&nbsp; 
													<input type="text" id="numero" name="numero" value="" onKeyPress="return checkIt(event)" style="width: 110px;"  maxlength="12"/></td>
												
													
												</tr>
			
												<tr><td style="height: 10px" ></td></tr>
												
												
											<tr>
													<td colspan="2" align="center"><input type="button" class="buttonCls" submit="true" style="width: 140px" value="CONSULTAR"  onclick="iniciarSesion();" /></td>
												</tr>

														</tr>

									<tr>




<c:if test="${msje eq 'Error 99'}">
<center>
<table width="60%" align="center" class="small">
<tr><td style="height: 20px" ></td></tr>
	<tr>
		<td  align="center"><strong> No se encontraron resultados </strong></td>
	</tr>
</table>
</center>
</c:if>	




<c:if test="${msje eq 'Error 98'}">
<center>
<table width="60%" align="center" class="small">
<tr><td style="height: 20px" ></td></tr>
	<tr>
		<td  align="center"><strong> No se encontraron resultados </strong></td>
	</tr>
</table>
</center>
</c:if>	



<c:if test="${msje eq 'Error 50'}">
<center>
<table width="60%" align="center"  bgcolor="white">
<tr><td style="height: 20px" ></td></tr>
	<tr>
		<td  align="center"><strong>Error: DPAHF01</strong></td>
	</tr>
</table>
</center>
</c:if>
									
									
<c:if test="${msje eq 'Error 14'}">
<center>
<table width="60%" align="center"  bgcolor="white">
<tr><td style="height: 20px" ></td></tr>
	<tr>
		<td  align="center"><strong>No se encuentra registrado en SITC, VERIFICAR.</strong></td>
	</tr>
	<tr>
		<td  align="center"><strong>Codigo de Error 14 : F18-ERROR ACCESO</strong></td>
	</tr>
</table>
</center>
</c:if>									
			
<!-- 
<c:if test="${msje eq 'Error 60'}">
<center>
<table width="60%" align="center"  bgcolor="white">
<tr><td style="height: 20px" ></td></tr>
	<tr>
		<td  align="center"><strong>El servicio de IZIPAY no responde favor de consultar en unos minutos</strong></td>
	</tr>

</table>
</center>
</c:if>		
 -->			
									
									


						
									
									
<c:if test="${msje eq 'Haga Clic en Abrir para Confirmar la Exportación' }">
<center>
<table width="60%" align="center" class="small">
<tr><td style="height: 20px" ></td></tr>
	<tr>
		<td  align="center"><strong> Abrir Solicitud de Tarjeta de Credito </strong></td>
	</tr>
</table>
</center>

<center>
<table width="80%" align="center" bgcolor="white">
	<tr>
		<td  align="center" bgcolor="white"><strong>
		<input type="button" onclick="exportar(<c:out value="${solicitud.NROTARJETA}"  />)"    class= "small"	value="Generar">
		
		
		

	
	
	
	
		
		</strong></td>
	</tr>
	
</table>
</center>



<c:if test="${respuesta eq 'Error 60'}">
<center>
<table width="60%" align="center"  bgcolor="white">
<tr><td style="height: 20px" ></td></tr>
	<tr>
		<td  align="center"><strong> Estimado(a)</strong></td>
	</tr>
	<tr>
		<td  align="center"><strong>No se ha completado la Habilitación/deshabilitación de los atributos de la</strong></td>
	</tr>
	<tr>
		<td  align="center"><strong>Tarjeta de Crédito,por favor remita el screenshot de la pantalla SITC-04 </strong></td>
	</tr>
	<tr>
		<td  align="center"><strong> y/o SITC-05 al correo soporteoperativotc@bn.com.pe</strong></td>
	</tr>
</table>
</center>

</c:if>	


	<c:if test="${respuesta != 'Error 60' }">
	<center>
	<table width="60%" align="center" class="small">
	<tr><td style="height: 20
	px" ></td></tr>
		<tr>
			<td  align="center"><strong> Solicitud correcta</strong></td>
		</tr>
	</table>
	</center>
	</c:if>	

	
	

</c:if>	
		
	

											
											
												
												
												
											
												
											
												
												
											</table>
										</td>
									</tr>
									
								</table>
							</td>
						</tr>
						<tr>
						<td>
						 &nbsp;
						</td>
						</tr>
					</table>
			</td>
		</tr>
	    <tr><td style="height: 50px"></td></tr>		
	</table>
							
</form>


</body>
</html>

