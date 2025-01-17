<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml2/DTD/xhtml1-strict.dtd">
<%@page import="pe.com.bn.modc.common.Util"%><title>Titulo</title>
<%@page import="pe.com.bn.modc.common.DatosSesion"%>
<%@page import="pe.com.bn.modc.common.Constant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/fontTableroPic1.css"
	type="text/css"></link>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/fontTableroPic2.css"
	type="text/css"></link>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/styles.css"
	type="text/css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/displaytag.css"
	type="text/css"></link>

<tag:scripts />
<style>
#mensaje {
	display: none;
	margin-top: 10px;
	margin-bottom: 20px;
	padding: 10px;
	border-radius: 5px;
	font-size: 14px;
}

.exito {
	color: #155724;
	background-color: #d4edda;
	border: 1px solid #c3e6cb;
}

.error {
	color: #721c24;
	background-color: #f8d7da;
	border: 1px solid #f5c6cb;
}
</style>

<script type="text/javascript">
    
    function mostrarMensaje(tipo, texto) {
        const $mensaje = $("#mensaje");
        $mensaje.text(texto); // Actualizar el texto del mensaje
        $mensaje.removeClass("exito error"); // Remover clases previas
        $mensaje.addClass(tipo); // Agregar la clase correspondiente
        $mensaje.fadeIn(); // Mostrar el mensaje

        setTimeout(() => {
            $mensaje.fadeOut();
        }, 5000);
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
	if(document.frmLogin.numero.value==''){
   mostrarMensaje("error", "Ingrese número de prestamo")
		//alert('Ingrese Desembolso');
		return false;
	} 
	
	 if (document.frmLogin.numero.value.length < 13) {
	 mostrarMensaje("error", "Número de prestamo m\u00EDnimo 13 digitos")
   //  alert("Documento m\u00EDnimo 13 digitos");
     return false;
    }  
		return true;
}

function iniciarSesion(){
	 	
	if(validar()){
	
	document.frmLogin.submit();
		//document.testpdf.submit();
	}
	
}
function testclasulapdfenviar(){ 
		document.testpdf.submit();
}

 function testclasulaserver(){ 
document.testearclauu.submit();
}
    
</script>

<script type="text/javascript">
$(document).ready(function () {
$("#verdoc").click(function () {
      	var numpres = "${cronograma.NPRESTAMO}";
		var nombrecli = "${cronograma.ACLIENTE}";
		var numerodoc = "${cronograma.DOCUMENTO}";
		var correocli = "${correo}"

        const datosCorreo = {
            numpres: numeroDoc,
            nombre: nombreCompleto,
            numero: correoDestino,
            correo: correocli
        };

        const url = "/modc/getVerDoc/";
        console.log("Enviando a URL:", url);

        $.ajax({
            url: url,
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(datosCorreo),
            success: function (respuesta) {
                const data = typeof respuesta === "string" ? JSON.parse(respuesta) : respuesta;
                
                
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.error("Error al enviar el mensaje:", textStatus, errorThrown);
                mostrarMensaje("error", "Ocurrió un error al descargar el documento.");
            }
        });
    });

});

</script>


</head>
<body class="" style="background-color: #F0F0F0;">

	<c:url var="url" value="/" />



	<%-- <form id="exPagare" name="exPagare" method="post"
		action="<c:out value='${url}'/>exPagare" runat="server">
		<input id="cta" name="cta"
			value="<c:out value="${cronograma.ccuenta}"  />" type="hidden" />
		<input id="numero" name="numero"
			value="<c:out value="${cronograma.cdsbolso}"  />" type="hidden" />
		<input id="pol1" name="pol1" type="hidden" />
		<input id="sol1" name="sol1" type="hidden" />
	</form>


	<form id="exPrestamo" name="exPrestamo" method="post"
		action="<c:out value='${url}'/>exPrestamo" runat="server">
		<input id="cta" name="cta"
			value="<c:out value="${cronograma.ccuenta}"  />" type="hidden" />
		<input id="numero" name="numero"
			value="<c:out value="${cronograma.cdsbolso}"  />" type="hidden" />
		<input id="pol1" name="pol1" type="hidden" />
		<input id="sol1" name="sol1" type="hidden" />
	</form>

	<form id="testpdf" name="testpdf" method="post"
		action="<c:out value='${url}'/>testpdf" runat="server">
		<input id="pol1" name="pol1" type="hidden" />
		<input id="sol1" name="sol1" type="hidden" />
	</form>
	<form id="exPrestamoAct" name="exPrestamoAct" method="post"
		action="<c:out value='${url}'/>exPrestamoAct" runat="server">
		<input id="cta" name="cta"
			value="<c:out value="${cronograma.ccuenta}"  />" type="hidden" />
		<input id="numero" name="numero"
			value="<c:out value="${cronograma.cdsbolso}"  />" type="hidden" />
		<input id="pol1" name="pol1" type="hidden" />
		<input id="sol1" name="sol1" type="hidden" />
	</form> --%>




	<form id="frmLogin" name="frmLogin" method="post"
		action="<c:out value='${url}'/>enviarDoc" runat="server">
		<input name="method" value="" type="hidden"> <input
			type="hidden" name="id">


				<table class="rxsviewport" cellpadding="0" cellspacing="0"
					width="100%" border="0" height="100%">


					<tr>
						<td style="height: 5px"></td>
					</tr>
					<tr>
						<td valign="middle" align="center" style="height: 100%;"
							height="100%">
							<table class="rxbn" cellpadding="4" cellspacing="1"
								style="width: 900px" align="center">
								<tr>
									<th class="rxtitle" style="height: 14px; font-size: 15px;"
										align="center">                                        
										   Envio virtual de Documentos Contractuales - Préstamo
										Multired</th>

								</tr>
								<tr>
									<td class="rxcontainer">

										<table cellpadding="4" width="100%">
											<tr></tr>
											<tr>
												<td align="left">

													<table width="100%">
														<tr>
															<td width="8%" align="center">&nbsp;&nbsp;</td>
														</tr>
														<tr>
															<td width="8%" align="center">&nbsp;&nbsp;</td>
															<td width="20%" align="center">N&uacute;mero de
																Prestamo:</td>
															<td><input type="text" id="numero" name="numero"
																value="" onkeypress="return checkIt(event)"
																style="width: 200px;" maxlength="13" /></td>

															<td width="40%" align="center">Nombres y Apellidos:</td>
															<td><input type="text" id="nombres" name="nombres"
																style="width: 200px;" readonly="readonly" /></td>
															<td width="20%" align="center">&nbsp;&nbsp;</td>

														</tr>

														<tr>
															<td width="8%" align="center">&nbsp;&nbsp;</td>
														</tr>
														<tr>
															<td width="8%" align="center">&nbsp;&nbsp;</td>
															<td width="24%" align="center">Tipo de Documento:</td>
															<td><input type="text" id="tipoDoc" name="tipoDoc"
																value="" readonly="readonly" style="width: 200px;" /></td>

															<td width="40%" align="center">N&uacute;mero de
																Documento:</td>
															<td><input type="text" id="numDoc" name="numDoc"
																value="" readonly="readonly" style="width: 200px;" /></td>
															<td width="20%" align="center">&nbsp;&nbsp;</td>
														</tr>
														<tr>
															<td width="8%" align="center">&nbsp;&nbsp;</td>
														</tr>
														<tr>
														</tr>
														<tr>

															<td width="8%" align="center">&nbsp;&nbsp;</td>
															<td width="20%" align="center">Correo
																electr&oacute;nico:</td>
															<td><input type="text" id="correo" name="correo"
																value="" style="width: 200px;" readonly="readonly" /></td>

															<td width="15%" align="center">&nbsp;&nbsp;</td>
															<td width="20%" align="center">&nbsp;&nbsp;</td>
															<td width="20%" align="center">&nbsp;&nbsp;</td>
														</tr>

														<tr>
															<td width="8%" high="30%" align="center">&nbsp;&nbsp;</td>
														</tr>
														<tr>

															<td width="10%" colspan="6" align="center"><span
																id="mensaje"></span></td>

														</tr>


														<tr>
															<td style="height: 8px"></td>
														</tr>



														<tr>
															<td width="10%" align="center">&nbsp;&nbsp;</td>
															<td width="10%" align="center">&nbsp;&nbsp;<input type="button"
																class="buttonCls" submit="true" style="width: 140px"
																value="CONSULTAR" onclick="iniciarSesion();" /></td>
																<td width="10%" align="center" colspan="2" align="center">

																<input id="verdoc" type="button" class="buttonCls"
																style="width: 140px" value="VER DOCUMENTO"
																disabled="disabled" />
															</td>
															<td width="5%" align="center">&nbsp;&nbsp;<input
																id="enviardoc" type="button" class="buttonCls"
																submit="true" style="width: 140px"
																value="ENVIAR DOCUMENTO" disabled="disabled" /></td>
															<td width="5%" align="center">&nbsp;&nbsp;</td>
														
														
														</tr>

														<tr>

																<c:if test="${msje eq 'Error 99'}">
																<script type="text/javascript">
      															  $(document).ready(function() {
     															       mostrarMensaje('error', '${cronograma.MSJ}');
     															       });
   																 </script>
															</c:if>


															<c:if test="${msje eq 'Haga Clic en Abrir para Confirmar la Exportación' }">
																<script type="text/javascript">
      															  $(document).ready(function() {
      															   	var numpres = "${cronograma.NPRESTAMO}";
														            var nombrecli = "${cronograma.ACLIENTE}";
														            var numerodoc = "${cronograma.DOCUMENTO}";
      															   	var correocli = "${correo}";
      															  	var mensajeVal = "${valcorreo}";
      															  	 console.log("mensaje del correo:", mensajeVal);
      															   
      															   $("#numero").val(numpres);
      															   $("#nombres").val(nombrecli);
      															   $("#numDoc").val(numerodoc);
     															   $("#correo").val(correocli); 
     															   $("#tipoDoc").val("DNI");  
     															   
      															    if (mensajeVal=="Los correos coinciden") {
															           $("#verdoc").prop("disabled", false);
															           $("#enviardoc").prop("disabled", false);
															            mostrarMensaje("exito", "Datos consultados con exito");
															            
															        }else{
															        
															          $("#verdoc").prop("disabled", true);
															           $("#enviardoc").prop("disabled", true);
															           mostrarMensaje("error", mensajeVal);
															        }
															        
      															    
     																});
   																 </script>
															</c:if>


															
															</tr>
													</table>
												</td>
											</tr>

										</table>
								</td>	
								</tr>
								<tr>
									<td>&nbsp;</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td style="height: 50px"></td>
					</tr>
				</table>
	</form>



</body>
</html>

