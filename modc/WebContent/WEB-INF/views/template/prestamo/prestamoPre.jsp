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

function limpiar(){	
	document.getElementById("divResultBuscar").innerHTML=document.getElementById("divVacio").innerHTML;
	document.getElementById("buttonExportar").style.display='block';	
}

function exportar(){


   document.exPrestamo.submit();
}

function exportarActualizar(){


   document.exPrestamoAct.submit();
}

function exportarP(){


   document.exPagare.submit();
}

function validar(){
	
	 if (document.frmLogin.numero.value.length < 13) {
     alert("Documento m\u00EDnimo 13 digitos");
     return false;
    }  
	

   if(document.frmLogin.numero.value==''){
		alert('Ingrese Desembolso');
		
		return false;
	} 
	
	return true;
}



function iniciarSesion(){
	 
	
	if(validar()){
	

    
     
		document.frmLogin.submit();
	}
	
	
	
}

function testearclau(){
document.testearclau.submit();
}
    
 
</script>



</head>
<body class="" style="background-color: #F0F0F0;">

<c:url var="url" value="/" />

<form id="exPagare" name="exPagare" method="post" action="<c:out value='${url}'/>exPagare"   runat="server" >
    <input	id="cta" name="cta" value = "<c:out value="${prestamo.ccuenta}"  />" type="hidden" /> 
	<input	id="numero" name="numero" value = "<c:out value="${prestamo.cdsbolso}"  />" type="hidden" /> 
	<input	id="pol1" name="pol1" type="hidden" /> 
	<input	id="sol1" name="sol1" type="hidden" /> 
</form>


<form id="exPrestamo" name="exPrestamo" method="post" action="<c:out value='${url}'/>exPrestamoPre"   runat="server" >
    <input	id="cta" name="cta" value = "<c:out value="${prestamo.ccuenta}"  />" type="hidden" /> 
	<input	id="numero" name="numero" value = "<c:out value="${prestamo.cdsbolso}"  />" type="hidden" /> 
	<input	id="pol1" name="pol1" type="hidden" /> 
	<input	id="sol1" name="sol1" type="hidden" /> 
</form>

<form id="exPrestamoAct" name="exPrestamoAct" method="post" action="<c:out value='${url}'/>exPrestamoActPre"   runat="server" >
    <input	id="cta" name="cta" value = "<c:out value="${prestamo.ccuenta}"  />" type="hidden" /> 
	<input	id="numero" name="numero" value = "<c:out value="${prestamo.cdsbolso}"  />" type="hidden" /> 
	<input	id="pol1" name="pol1" type="hidden" /> 
	<input	id="sol1" name="sol1" type="hidden" /> 
</form>



  <form  id="frmLogin" name="frmLogin" method="post" action="<c:out value='${url}'/>prestamoGPre" runat="server"   >
	<input name="method" value="" type="hidden">
	<input type="hidden" name="id" >
	 
	 
	<table class="rxsviewport" cellpadding="0" cellspacing="0" width="100%"  border="0"  height="100%" >
	     
	
	    <tr><td style="height: 5px"></td></tr>
		<tr>
			<td valign="middle" align="center" style="height: 100%;"  height="100%" >
					<table class="rxbn" cellpadding="4" cellspacing="1" 	style="width:900px" align="center">
						<tr>
							<th  class="rxtitle" style="height: 14px;font-size:15px;" align="center"  > 
							
						&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
						&nbsp; Emisi&oacute;n de Documentos Pre Impresos - Pr&eacute;stamo Multired
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
													
												
													<td width="24%" align="center">N&ordm; de Desembolso:&nbsp;&nbsp; &nbsp;&nbsp; 
													<input type="text" id="numero" name="numero" value="" onKeyPress="return checkIt(event)" style="width: 90px;"  maxlength="13"   /></td>
												
													
												</tr>
												
											
												
												
												
											
												
												
												<tr><td style="height: 10px" ></td></tr>
												
												
											<tr>
													<td colspan="2" align="center"><input type="button" class="buttonCls" submit="true" style="width: 140px" value="CONSULTARRR"  onclick="iniciarSesion();" /></td>
													
											
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
									
<c:if test="${msje eq 'Error 10'}">
<center>
<table width="60%" align="center"  bgcolor="white">
<tr><td style="height: 20px" ></td></tr>
	<tr>
		<td  align="center">PRESTAMO NO ES DEL DIA</strong></td>
	</tr>
	
</table>
</center>

</c:if>									
									
									
<c:if test="${msje eq 'Error 20'}">
<center>
<table width="60%" align="center"  bgcolor="white">
<tr><td style="height: 20px" ></td></tr>
	<tr>
		<td  align="center">Tiene que Genear los documentos</strong></td>
	</tr>

</table>
</center>

</c:if>	

<c:if test="${msje eq 'Error 21'}">
<center>
<table width="60%" align="center"  bgcolor="white">
<tr><td style="height: 20px" ></td></tr>
	<tr>
		<td  align="center">Documento actualizado en la base de datos.</strong></td>
	</tr>

</table>
</center>

</c:if>								
									
									
<c:if test="${msje eq 'Haga Clic en Abrir para Confirmar la Exportación' }">
<center>
<table width="60%" align="center" class="small">
<tr><td style="height: 20px" ></td></tr>
<tr><td style="height: 20px" ></td></tr>
<tr><td style="height: 20px" ></td></tr>
	<tr>
		<td  align="center"><strong>Documentos de Prestamo Multired - Desembolso <c:out value="${prestamo.ccuenta}"  /> - <c:out value="${prestamo.cdsbolso}"  /> </strong></td>
	</tr>
	
	<tr><td style="height: 30px" ></td></tr>

	
</table>
</center>
<center>
<table width="60%" align="center" bgcolor="white">
	<tr>
		<td  align="center" bgcolor="white"><strong>
		<input type="button" onclick="exportar()"    class= "small"	value="Generar Documento">
		<input type="button" onclick="exportarP()"    class= "small"	value="Imprimir Pagaré">
		</strong></td>
		<td  align="right" bgcolor="white"><strong>
		<input type="button" onclick="exportarActualizar()"    class= "small"	value="Actualizar Documento">		
		</strong></td>
	</tr>
</table>
</center>


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

