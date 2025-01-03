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

        // Ocultar el mensaje después de 5 segundos
        setTimeout(() => {
            $mensaje.fadeOut();
        }, 5000);
    }

    $("#enviarCorreo").click(function () {
        const numeroDoc = $("#numero").val();
        const nombreCompleto = $("#nombres").val();
        const correoDestino = $("#correo").val();

        if (!correoDestino) {
            mostrarMensaje("error", "El correo no está disponible.");
            return;
        }

        const datosCorreo = {
            numDocCli: numeroDoc,
            nombreCli: nombreCompleto,
            correoCli: correoDestino
        };

        const url2 = "/modc/getEnviarCorreoOTP/";
        console.log("Enviando a URL:", url2);

        $.ajax({
            url: url2,
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(datosCorreo),
            success: function (respuesta) {
                const mensaje = typeof respuesta === "string" ? JSON.parse(respuesta) : respuesta;
                mostrarMensaje("exito", mensaje.msj || "Correo enviado con éxito.");
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.error("Error al enviar el mensaje:", textStatus, errorThrown);
                mostrarMensaje("error", "Ocurrió un error al enviar el correo.");
            }
        });
    });

    $("#consultarCorreo").click(function () {
        const numdoc = $("#numero").val();
        const tipodoc = $("#tipo").val();

        if (!numdoc || !tipodoc) {
            mostrarMensaje("error", "Debe completar todos los campos para consultar.");
            return;
        }

        const url = "/modc/getConsultaCorreo/";
        console.log("Consultando en URL:", url);

        const datos = {
            numero: numdoc,
            tipo: tipodoc
        };

        $.ajax({
            url: url,
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(datos),
            success: function (response) {
                const data = typeof response === "string" ? JSON.parse(response) : response;
                if (data) {
                    $("#nombres").val(data.nombreCompleto);
                    $("#correo").val(data.email);
                    mostrarMensaje("exito", "Datos consultados con éxito.");
                } else {
                    mostrarMensaje("error", "No se encontraron datos para el cliente.");
                }
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

function validarConsultaCorreo() {
    var tipoDocumento = document.getElementById("tipo").value;
    var numeroDocumento = document.getElementById("numero").value;

    if (tipoDocumento === "Seleccionar") {
        alert("Por favor, seleccione un tipo de documento.");
        return false;
    }

    if (tipoDocumento === "1") { 
        if (numeroDocumento.length !== 8) {
            alert("El DNI debe tener 8 dígitos.");
            return false;
        }
    } else if (tipoDocumento === "4") {
        if (numeroDocumento.length !== 12) {
            alert("El Carnet de Extranjería debe tener 12 dígitos.");
            return false;
        }
    }

    return true; // Si todo está correcto
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
		action="<c:out value='${url}'/>validarCorreo" runat="server">
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
										&nbsp;&nbsp; Validar Correo - Pr&eacute;stamo Multired</th>

								</tr>
								<tr>
									<td class="rxcontainer">

										<table cellpadding="4" width="100%">
											<tr></tr>
											<tr>
												<td align="left">

													<table width="100%">
														<tr>
															<td width="20%" align="center">&nbsp;&nbsp;</td>
														</tr>
														<tr>
															<td width="20%" align="center">&nbsp;&nbsp;</td>
															<td width="10%" align="center">&nbsp;&nbsp;</td>
															<td width="40%" align="center">Tipo de
																Documento:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <select
																id="tipo" name="tipo" style="width: 150px;">
																	<option value="Seleccionar">Seleccionar</option>
																	<option value="1">Dni</option>
																	<option value="4">Carnet de extranjer&iacute;a</option>
															</select>
																<td width="10%" align="center">&nbsp;&nbsp;</td>
																<td width="20%" align="center">&nbsp;&nbsp;</td>
														</tr>

														<tr>

															<td width="20%" align="center">&nbsp;&nbsp;</td>
															<td width="10%" align="center">&nbsp;&nbsp;</td>
															<td width="24%" align="center">N&ordm; de
																Documento:&nbsp;&nbsp;&nbsp; <input type="text"
																id="numero" name="numero" style="width: 150px;"
																onkeypress="return checkIt(event)" maxlength="" />
															</td>
															<td width="10%" align="center">&nbsp;&nbsp;</td>
															<td width="20%" align="center">&nbsp;&nbsp;</td>

														</tr>

														<tr>

															<td width="20%" align="center">&nbsp;&nbsp;</td>
															<td width="10%" align="center">&nbsp;&nbsp;</td>
															<td width="24%" align="center">Nombres y
																Apellidos:&nbsp;&nbsp; &nbsp;&nbsp; <input type="text"
																id="nombres" name="nombres" value="" readonly
																onKeyPress=" " readonly style="width: 150px;" />
															</td>
															<td width="10%" align="center">&nbsp;&nbsp;</td>
															<td width="20%" align="center">&nbsp;&nbsp;</td>

														</tr>

														<tr>

															<td width="20%" align="center">&nbsp;&nbsp;</td>
															<td width="10%" align="center">&nbsp;&nbsp;</td>
															<td width="30%" align="center">&nbsp;&nbsp;Correo
																electr&oacute;nico:&nbsp;&nbsp; &nbsp;&nbsp; <input
																type="text" id="correo" name="correo" value="" readonly
																onKeyPress=" " style="width: 150px;" maxlength="30" />
															</td>
															<td width="10%" align="center">&nbsp;&nbsp;</td>
															<td width="20%" align="center">&nbsp;&nbsp;</td>

														</tr>

														<tr>

															<td width="20%" align="center">&nbsp;&nbsp;</td>
															<td width="10%" align="center">&nbsp;&nbsp;</td>
															<td width="30%" align="center">Ingresar
																c&oacute;digo OTP:&nbsp;&nbsp; &nbsp;&nbsp; <input
																type="text" id="codigo" name="codigo" value=""
																onKeyPress="return checkIt(event)" style="width: 150px;"
																maxlength="6" />
															</td>
															<td width="10%" align="center">&nbsp;&nbsp;</td>
															<td width="20%" align="center">&nbsp;&nbsp;</td>
														</tr>

														<tr>
															<td width="20%" align="center">&nbsp;&nbsp;</td>
															<center> <span style="height: 14px" id="mensaje"></span>

															</center>
														</tr>


														<tr>


															<td width="30%" align="center" colspan="2" align="center">
																<input id="consultarCorreo" type="button"
																class="buttonCls" style="width: 140px"
																value="CONSULTAR CORREO" />
															</td>

															<td width="30%" align="center" colspan="1" align="center">
																<input id="enviarCorreo" type="button" class="buttonCls"
																style="width: 140px" value="ENVIAR / REENVIAR OTP"
																onclick=" " />
															</td>

															<td width="30%" align="center" colspan="1" align="center"><input
																type="button" class="buttonCls" submit="true"
																style="width: 140px" value="VALIDAR CORREO" onclick=" " /></td>

														</tr>

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
