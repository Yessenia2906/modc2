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
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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


<script>
$(document).ready(function () {
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
   
    function validarDatosIngresados() {
    var numeroP = document.getElementById("numprestamo").value;
		mensajes ="";

        if (numeroP.length !== 13) {
        mensajes = "El Número de prestamo debe tener 13 dígitos."; 
          
            return mensajes;
        }
    return mensajes;
}
    
   $("#consultarDatos").click(function () {
    const numPres = $("#numprestamo").val();
    const mensajeError = validarDatosIngresados();

    if (mensajeError) {
        mostrarMensaje("error", mensajeError); // Mostrar mensaje de error
        console.log(mensajeError);
        return;
    }

    // Limpiar campos solo si no hay errores
    $("#numprestamo").val("");
    $("#nombres").val("");
    $("#tipoDoc").val("");
    $("#numDoc").val("");
    $("#correo").val("");

    const url = "/modc/getConsultaPrestamo/";
    console.log("Consultando en URL:", url);

    const datos = { numero: numPres };
	console.log(datos);

    $.ajax({
        url: url,
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(datos),
        success: function (response) {
           /*  const data = typeof response === "string" ? JSON.parse(response) : response;
            const nombreData = data.nom;
            $("#nombres").val(nombreData); */
            console.log("ENVIO DE DATOS BIEN");
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.error("Error en la solicitud:", textStatus, errorThrown);
            mostrarMensaje("error", "Ocurrió un error al consultar los datos.");
        }
    });
});

 });  
</script>

<script type="text/javascript">


function soloNumeros(e){
alert(e);
	var key = window.Event ? e.which : e.keyCode
	return (key >= 48 && key <= 57)
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
										align="center">&nbsp; &nbsp; &nbsp;&nbsp; &nbsp;
										&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;
										&nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
										&nbsp;&nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
										&nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;
										&nbsp;&nbsp; Enviar Documentos - Pr&eacute;stamo Multired</th>

								</tr>
								<tr>
									<td class="rxcontainer">

										<table cellpadding="4" width="100%">
											<tr></tr>
											<tr>
												<td align="center">

													<table width="100%">
														<tr>
															<td width="15%" align="center">&nbsp;&nbsp;</td>
														</tr>
														<tr>
															<td width="10%" align="center">&nbsp;&nbsp;</td>
															<td width="20%" align="center">N&uacute;mero de Prestamo:</td>
															<td><input type="text" id="numprestamo" name="numprestamo"
																value="" onKeyPress="return checkIt(event)"
																style="width: 200px;" maxlength="13" /></td>

															<td width="40%" align="center">Nombres y Apellidos:</td>
															<td><input type="text" id="nombres" name="nombres"
																style="width: 200px;" readonly="readonly"/></td>
															<td width="20%" align="center">&nbsp;&nbsp;</td>

														</tr>

														<tr>
															<td width="10%" align="center">&nbsp;&nbsp;</td>
														</tr>
														<tr>
															<td width="10%" align="center">&nbsp;&nbsp;</td>
															<td width="24%" align="center">Tipo de Documento:</td>
															<td><input type="text" id="tipoDoc" name="tipoDoc"
																value="" readonly="readonly" style="width: 200px;" /></td>

															<td width="40%" align="center">N&uacute;mero de Documento:</td>
															<td><input type="text" id="numDoc" name="numDoc"
																value="" readonly="readonly" style="width: 200px;"
																 /></td>
															<td width="20%" align="center">&nbsp;&nbsp;</td>
														</tr>
														<tr>
															<td width="10%" align="center">&nbsp;&nbsp;</td>
														</tr>
														<tr>
														</tr>
														<tr>

															<td width="10%" align="center">&nbsp;&nbsp;</td>
															<td width="20%" align="center">Correo
																electr&oacute;nico:</td>
															<td><input type="text" id="correo" name="correo"
																value="" style="width: 200px;" readonly="readonly"/></td>

															<td width="15%" align="center">&nbsp;&nbsp;</td>
															<td width="20%" align="center">&nbsp;&nbsp;</td>
															<td width="20%" align="center">&nbsp;&nbsp;</td>
														</tr>

														<tr>
															<td width="10%" high="30%" align="center">&nbsp;&nbsp;</td>
														</tr>
														<tr>

															<td width="10%" colspan="6" align="center"><span
																id="mensaje"></span></td>

														</tr>
														<tr>
															<td width="10%" high="10%" align="center">&nbsp;&nbsp;</td>
														</tr>
														<tr>

															<td width="10%" align="center">&nbsp;&nbsp;</td>
															<td width="10%" align="center">&nbsp;&nbsp;<input
																id="consultarDatos" type="button" class="buttonCls"
																style="width: 140px" value="CONSULTAR" /></td>
															<td width="10%" align="center" colspan="2" align="center">

																<input id="verDoc" type="button" class="buttonCls"
																style="width: 140px" value="VER DOCUMENTO"
																disabled="disabled" />
															</td>


															<td width="5%" align="center">&nbsp;&nbsp;<input
																id="enviarDoc" type="button" class="buttonCls"
																submit="true" style="width: 140px"
																value="ENVIAR DOCUMENTO" disabled="disabled" /></td>
															<td width="5%" align="center">&nbsp;&nbsp;</td>
														</tr>

														<tr>
															<td></td>
														</tr>

														<tr>




															<c:if test="${msje eq 'Error 99'}">
																<center>
																<table width="60%" align="center" class="small">
																	<tr>
																		<td style="height: 20px"></td>
																	</tr>
																	<tr>
																		<td align="center"><strong> No se
																				encontraron resultados </strong></td>
																	</tr>
																</table>
																</center>
															</c:if>
															<td></td>




															<c:if test="${msje eq 'Error 98'}">
																<center>
																<table width="60%" align="center" class="small">
																	<tr>
																		<td style="height: 20px"></td>
																	</tr>
																	<tr>
																		<td align="center"><strong> No se
																				encontraron resultados </strong></td>
																	</tr>
																</table>
																</center>
															</c:if>



															<c:if test="${msje eq 'Error 50'}">
																<center>
																<table width="60%" align="center" bgcolor="white">
																	<tr>
																		<td style="height: 20px"></td>
																	</tr>
																	<tr>
																		<td align="center"><strong>Error:
																				DPAHF01</strong></td>
																	</tr>
																</table>
																</center>
															</c:if>


															<c:if test="${msje eq 'Error 14'}">
																<center>
																<table width="60%" align="center" bgcolor="white">
																	<tr>
																		<td style="height: 20px"></td>
																	</tr>
																	<tr>
																		<td align="center"><strong>No se
																				encuentra registrado en SITC, VERIFICAR.</strong></td>
																	</tr>
																	<tr>
																		<td align="center"><strong>Codigo de
																				Error 14 : F18-ERROR ACCESO</strong></td>
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
