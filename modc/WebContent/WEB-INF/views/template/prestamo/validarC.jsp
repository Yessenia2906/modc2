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
	padding: 10px;
	border-radius: 5px;
	font-size: 14px;
	text-align: center;
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

        function checkIt(evt) {
            evt = (evt) ? evt : window.event;
            var charCode = (evt.which) ? evt.which : evt.keyCode;
            if (charCode > 31 && (charCode < 48 || charCode > 57)) {
                return false;
            }
            return true;
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

            return true;
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
							<div class="rxbn"
								style="width: 900px;  border: 1px solid #fff;  margin: 0 auto; display: flex; flex-direction: column; gap: 1rem;">
								<div class="rxtitle"
									style="height: 14px; font-size: 15px; text-align: center;">
									<strong>Validar Correo - Pr&eacute;stamo Multired</strong>
								</div>

								<div class="rxcontainer"
									style="display: flex; flex-direction: column; gap: 1rem;">
									<div style="display: flex; justify-content: center;">
										<label for="tipo">Tipo de
											Documento:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <select
											id="tipo" name="tipo" style="width: 150px;">
											<option value="Seleccionar">Seleccionar</option>
											<option value="1">Dni</option>
											<option value="4">Carnet de extranjer&iacute;a</option>
										</select>
									</div>

									<div style="display: flex; justify-content: center;">
										<label for="numero">N&ordm; de
											Documento:&nbsp;&nbsp;&nbsp;</label> <input type="text" id="numero"
											name="numero" style="width: 150px;"
											onkeypress="return checkIt(event)" maxlength="" />
									</div>

									<div style="display: flex; justify-content: center;">
										<label for="nombres">Nombres y Apellidos:&nbsp;&nbsp;
											&nbsp;&nbsp;</label> <input type="text" id="nombres" name="nombres"
											value="" readonly style="width: 150px;" />
									</div>

									<div style="display: flex; justify-content: center;">
										<label for="correo">Correo
											electr&oacute;nico:&nbsp;&nbsp; &nbsp;&nbsp;</label> <input
											type="text" id="correo" name="correo" value="" readonly
											style="width: 150px;" maxlength="30" />
									</div>

									<div style="display: flex; justify-content: center;">
										<label for="codigo">Ingresar c&oacute;digo
											OTP:&nbsp;&nbsp; &nbsp;&nbsp;</label> <input type="text" id="codigo"
											name="codigo" value="" onkeypress="return checkIt(event)"
											style="width: 150px;" maxlength="6" />
									</div>

									<div style="display: flex; justify-content: center;">
										<span id="mensaje"></span>
									</div>

									<div style="display: flex; justify-content: center; gap: 1rem;">
										<input id="consultarCorreo" type="button" class="buttonCls"
											style="width: 140px" value="CONSULTAR CORREO" /> <input
											id="enviarCorreo" type="button" class="buttonCls"
											style="width: 140px" value="ENVIAR / REENVIAR OTP" /> <input
											type="button" class="buttonCls" style="width: 140px"
											value="VALIDAR CORREO" />
									</div>
								</div>
							</div>

						</td>
					</tr>
					<tr>
						<td style="height: 50px"></td>
					</tr>
				</table>
	</form>


</body>
</html>

