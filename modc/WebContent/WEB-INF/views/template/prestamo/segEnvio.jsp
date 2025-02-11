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

 function habilitarEnvio() {
        // Habilita el botón "REENVIAR DOCUMENTO"
      setTimeout(habilitarEnvio2, 1500);
    }
    

function habilitarEnvio2() {
    document.getElementById("reenviardoc").disabled = false;
}
    
</script>

<script type="text/javascript">
    
    function mostrarMensaje(tipo, texto) {
        const $mensaje = $("#mensaje");
        $mensaje.text(texto); 
        $mensaje.removeClass("exito error"); 
        $mensaje.addClass(tipo); 
        $mensaje.fadeIn(); 

      $mensaje.delay(5000).fadeOut();
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

function exportarpdf(){ 
		document.verDocumentosR.submit();
		
		
}

$(document).ready(function () {

 $("#consultar").click(function () {
        const numprestamo = $("#numero").val();
      
        const mensajeError = validarConsultaDatos();

        if (!numprestamo) {
            mostrarMensaje("error", "Debe ingresar el número de prestamo.");
            return;
        }

        if (mensajeError) {
            mostrarMensaje("error", mensajeError);
            console.log(mensajeError);
            return;
        }

        const url = "/modc/getConsultarREEnvio/";
        console.log("Consultando en URL:", url);

        const datos = {
            numerop: numprestamo
           
        };

        $.ajax({
            url: url,
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(datos),
            success: function (response) {
                const data = typeof response === "string" ? JSON.parse(response) : response;
                const desembolso = data.prestamo;
                const nombres = data.nombres;
                const tipo_doc =  data.tipodoc;
                const numdoc = data.numdoc;
                const correo = data.correo;
                const estado = data.estado;
				
				console.log("tipo:", tipo_doc);
                if (data.cod=="0000") {
                	
                    mostrarMensaje("exito", data.msj);
                    
                    $("#numero").val(desembolso);
                    $("#nombres").val(nombres);
                                      
                     if (tipo_doc =="1"){
                    $("#tipoDocumento").val("DNI");
                    }else if(tipo_doc=="4"){
                    $("#tipoDocumento").val("Carnet de Extranjería");
                    } 
                    
                    $("#numDoc").val(numdoc);
                    $("#correo").val(correo);
                    $("#estadoenvio").val(estado);
                    $("#verdoc").prop("disabled", false);
                  
                } else {
                    mostrarMensaje("error", "No se encontraron datos para el cliente.");
                    $("#verdoc").prop("disabled", true);
                    $("#reenviardoc").prop("disabled", true);
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.error("Error en la solicitud:", textStatus, errorThrown);
                mostrarMensaje("error", "Ocurrió un error al consultar los datos.");
            }
        });


});

 $("#reenviardoc").click(function () {
        const correo = $("#correo").val();
 
 
        if (!correo) {
         	$("#reenviardoc").prop("disabled", true);
            mostrarMensaje("error", "No cuenta con dato de correo electronico..");
            return;
        }

        const url = "/modc/getEnviarREEnvio/";
        console.log("Consultando en URL:", url);

        const datos = {
            correop: correo
        };

        $.ajax({
            url: url,
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(datos),
            success: function (response) {
                const data = typeof response === "string" ? JSON.parse(response) : response;
                const mensaje = data.mensaje;
                const codigo = data.codigo
				
				console.log("codigo:", codigo);
                if (data.codigo=="0000") {
                	
                    mostrarMensaje("exito", mensaje);
                     $("#verdoc").prop("disabled", true);
                    $("#reenviardoc").prop("disabled", true);
                     } else {
                    mostrarMensaje("error", mensaje);
                   
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.error("Error en la solicitud:", textStatus, errorThrown);
                mostrarMensaje("error", "Ocurrió un error al enviar el correo.");
            }
        });
	});
	
	
});

function validarConsultaDatos() {
    var numerop = document.getElementById("numero").value;
		mensajes ="";
   
        if (numerop.length !== 13) {
        mensajes = "El número de prestamo debe tener 13 digítos"; 
          
            return mensajes;
        }

    return mensajes;
}    
</script>

</head>
<body class="" style="background-color: #F0F0F0;">

	<c:url var="url" value="/" />
	
	 <form id="verDocumentosR" name="verDocumentosR" method="post"
	action="<c:out value='${url}'/>verDocumentosR" runat="server">
	<script type="text/javascript">
   $(document).ready(function() {
	 const dniR = $("#numDoc").val();
	 $("#verDocumentosR").append(`<input type="hidden" name="dni" value="${dniR}">`);
	 });
 	</script>
	</form>
	
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
										                         Seguimiento de Envio - Préstamo
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
															<td><input type="text" id="tipoDocumento" name="tipoDocumento"
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
															<td width="24%" align="center">Correo
																electr&oacute;nico:</td>
															<td><input type="text" id="correo" name="correo"
																value="" style="width: 200px;" readonly="readonly" /></td>

															<td width="40%" align="center">Estado de envio:</td>
															<td><input type="text" id="estadoenvio" name="estadoenvio"
																value="" style="width: 200px;" readonly="readonly" /></td>
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
															<td width="10%" align="center">&nbsp;&nbsp;
															<input type="button" class="buttonCls" submit="true" style="width: 140px"
																value="CONSULTAR" onclick="" 
																id= "consultar"/></td>
																<td width="10%" align="center" colspan="2" align="center">

																<input type="button" class="buttonCls"
																style="width: 140px" value="VER DOCUMENTO" onclick="habilitarEnvio(); exportarpdf()"
																id="verdoc"
																disabled="disabled" />
															</td>
															<td width="5%" align="center">&nbsp;&nbsp;<input
																id="reenviardoc" type="button" class="buttonCls"
																submit="true" style="width: 140px"
																value="REENVIAR DOCUMENTO" disabled="disabled" 
																id= "reenviar"/></td>
															<td width="5%" align="center">&nbsp;&nbsp;</td>
														
														
														</tr>

														<tr>

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

