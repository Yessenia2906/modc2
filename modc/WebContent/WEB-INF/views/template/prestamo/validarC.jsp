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

const $numeroDocumento = $("#numero");
const $tipoDocumento = $("#tipo");
const $nombreCliente = $("#nombres");
const $correoCliente = $("#correo");
const $OTPCliente = $("#codigo");

    // Escuchar cambios en el select
    $tipoDocumento.change(function () {
        const tipoSeleccionado = $(this).val();

        if (tipoSeleccionado === "1") { 
            $numeroDocumento.attr("maxlength", 8); 
            $numeroDocumento.val("");
            $nombreCliente.val(""); 
            $correoCliente.val("");
            $OTPCliente.val("");
            $("#enviarCorreo").prop("disabled", true);
            $("#validarCodigo").prop("disabled", true);
           
        } else if (tipoSeleccionado === "4") { 
            $numeroDocumento.attr("maxlength", 12); 
            $numeroDocumento.val(""); 
            $nombreCliente.val(""); 
            $correoCliente.val("");
            $OTPCliente.val("");
            $("#enviarCorreo").prop("disabled", true);
            $("#validarCodigo").prop("disabled", true);
          
        } else if (tipoSeleccionado === "Seleccionar") {
            $numeroDocumento.attr("maxlength", 0); 
            $numeroDocumento.val(""); 
            $nombreCliente.val(""); 
            $correoCliente.val("");
            $OTPCliente.val("");
            $("#enviarCorreo").prop("disabled", true);
            $("#validarCodigo").prop("disabled", true);
        }
    });
    
    
    $("#consultarCorreo").click(function () {
        const numdoc = $("#numero").val();
        const tipodoc = $("#tipo").val();
        const mensajeError = validarConsultaDatos();

        // Limpiar campos
        $("#nombres").val("");
        $("#correo").val("");
        $("#codigo").val("");

        if (!numdoc || !tipodoc) {
            mostrarMensaje("error", "Debe completar todos los campos para consultar.");
            return;
        }

        if (mensajeError) {
            mostrarMensaje("error", mensajeError);
            console.log(mensajeError);
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
                const nombreData = data.nombreCompleto;
                const correoData = data.email;
				
                if (nombreData) {
                	if (!correoData || correoData === "NO EMAIL") {
                    mostrarMensaje("error", "Actualice sus datos de correo electronico");
                    $("#nombres").val(nombreData);
                    $("#correo").val(correoData);
                   // $("#correo").prop("readonly", false);
                   // $("#enviarCorreo").prop("disabled", false);
                  	}else{
                	
                	$("#nombres").val(nombreData);
                    $("#correo").val(correoData);
                    mostrarMensaje("exito", "Datos consultados con exito.");
                	$("#enviarCorreo").prop("disabled", false);
                	}
                    
                } else {
                    mostrarMensaje("error", "No se encontraron datos para el cliente.");
                    $("#enviarCorreo").prop("disabled", true);
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.error("Error en la solicitud:", textStatus, errorThrown);
                mostrarMensaje("error", "Ocurrió un error al consultar los datos.");
            }
        });
    });

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
                const data = typeof respuesta === "string" ? JSON.parse(respuesta) : respuesta;
                const msjEnviar = data.msj;
                const codEnviar = data.cod;


                if (codEnviar === "0000") {
                    mostrarMensaje("exito", msjEnviar);
                    $("#validarCodigo").prop("disabled", false);
                    $("#codigo").prop("disabled", false);
                  
                } else {
                    mostrarMensaje("error", msjEnviar);
                    $("#validarCodigo").prop("disabled", true);
                    $("#codigo").prop("disabled", true);
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.error("Error al enviar el mensaje:", textStatus, errorThrown);
                mostrarMensaje("error", "Ocurrió un error al enviar el correo.");
            }
        });
    });

    $("#validarCodigo").click(function () {
        const codigo = $("#codigo").val();
        const numdoc = $("#numero").val();
	
	const mensajes = validarDigitosOTP();
	
	 if (mensajes) {
            mostrarMensaje("error", mensajes);
            return;
        }

        const datosCodigo = {
            codigoCli: codigo,
            numero: numdoc
        };

        const url3 = "/modc/getValidarCodigoOTP/";
        console.log("Enviando a URL:", url3);

        $.ajax({
            url: url3,
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(datosCodigo),
            success: function (respuesta) {
                console.log("Respuesta recibida:", respuesta);
                const data3 = typeof respuesta === "string" ? JSON.parse(respuesta) : respuesta;
                const msjData = data3.msj;
                const codData = data3.cod;

                console.log("mensj Validación:", msjData);
                console.log("Código validacion:", codData);

                if (codData === "0000") {
                    mostrarMensaje("exito", msjData);
                    // Limpiar campos
			        $("#numero").val("");
			        $("#nombres").val("");
			        $("#correo").val("");
			        $("#codigo").val("");
			        $("#enviarCorreo").prop("disabled", true);
			        $("#validarCodigo").prop("disabled", true);
			        $("#codigo").prop("disabled", true);
                    
                } else {
                    mostrarMensaje("error", msjData);
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.error("Error al validar el mensaje:", textStatus, errorThrown);
                mostrarMensaje("error", "Ocurrió un error al validar el código.");
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


function validarConsultaDatos() {
    var tipoDocumento = document.getElementById("tipo").value;
    var numeroDocumento = document.getElementById("numero").value;
		mensajes ="";
   
    if (tipoDocumento === "Seleccionar") {
        mensajes = "Por favor, seleccione un tipo de documento."; 
      
        return mensajes;
    }

    if (tipoDocumento === "1") { 
        if (numeroDocumento.length !== 8) {
        mensajes = "El DNI debe tener 8 dígitos."; 
          
            return mensajes;
        }
    } else if (tipoDocumento === "4") {
        if (numeroDocumento.length !== 12) {
        mensajes = "El Carnet de Extranjería debe tener 12 dígitos."; 
          
            return mensajes;
        }
    }

    return mensajes;
}

function validarDigitosOTP() {
    var codotp = document.getElementById("codigo").value;
		mensajes ="";
    

        if (codotp == "") {
        mensajes = "Ingrese Codigo OTP."; 
          
            return mensajes;
        }
   	
        else if (codotp.length !== 6) {
        mensajes = "El codigo OTP debe tener 6 dígitos."; 
          
            return mensajes;
        }
    return mensajes;
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
												<td align="center">

													<table width="100%">
														<tr>
															<td width="15%" align="center">&nbsp;&nbsp;</td>
														</tr>
														<tr>
															<td width="10%" align="center">&nbsp;&nbsp;</td>
															<td width="24%" align="center">Tipo de Documento:</td>
															<td><select id="tipo" name="tipo"
																style="width: 200px;">
																	<option value="Seleccionar">Seleccionar</option>
																	<option value="1">Dni</option>
																	<option value="4">Carnet de extranjer&iacute;a</option>
															</select></td>


															<td width="24%" align="center">N&ordm; de Documento:</td>
															<td><input type="text" id="numero" name="numero"
																style="width: 200px;" onkeypress="return checkIt(event)"
																maxlength="12" /></td>
															<td width="20%" align="center">&nbsp;&nbsp;</td>

														</tr>

														<tr>
															<td width="10%" align="center">&nbsp;&nbsp;</td>
														</tr>
														<tr>
															<td width="10%" align="center">&nbsp;&nbsp;</td>
															<td width="24%" align="center">Nombres y Apellidos:</td>
															<td><input type="text" id="nombres" name="nombres"
																value="" readonly="readonly" style="width: 200px;" /></td>

															<td width="24%" align="center">Correo
																electr&oacute;nico:</td>
															<td><input type="text" id="correo" name="correo"
																value="" readonly="readonly" style="width: 200px;"
																maxlength="30" /></td>
															<td width="20%" align="center">&nbsp;&nbsp;</td>
														</tr>
														<tr>
															<td width="10%" align="center">&nbsp;&nbsp;</td>
														</tr>
														<tr>

															<td width="10%" align="center">&nbsp;&nbsp;</td>
															<td width="20%" align="center">Ingresar
																c&oacute;digo OTP:</td>
															<td><input type="text" id="codigo" name="codigo"
																value="" onKeyPress="return checkIt(event)" disabled="disabled"
																style="width: 200px;" maxlength="6" /></td>

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
																id="consultarCorreo" type="button" class="buttonCls"
																style="width: 140px" value="CONSULTAR CORREO" /></td>
															<td width="10%" align="center" colspan="2" align="center">

																<input id="enviarCorreo" type="button" class="buttonCls"
																style="width: 140px" value="ENVIAR / REENVIAR OTP"
																disabled="disabled" />
															</td>


															<td width="5%" align="center">&nbsp;&nbsp;<input
																id="validarCodigo" type="button" class="buttonCls"
																submit="true" style="width: 140px"
																value="VALIDAR CORREO" disabled="disabled" /></td>
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
