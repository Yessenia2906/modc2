<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml2/DTD/xhtml1-strict.dtd">
<%@page import="pe.com.bn.modc.common.Util"%><title>Titulo</title>
<%@page import="pe.com.bn.modc.common.DatosSesion"%>
<%@page import="pe.com.bn.modc.common.Constant"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
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

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

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
<link href='<c:url value="/assets/css/datepicker.css"/>'
	rel="stylesheet" />

<%-- <script src='<c:url value="/assets/js/datepicker.js"/>'></script>
<script src='<c:url value="/assets/js/datepicker-es.js"/>'></script> --%>
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
	function enviarForm() {
		let
		opt = document.getElementById("slcOpt").value;
		let
		forDni = document.getElementById("forDniTxt");

		let
		enviar = false;
		switch (opt) {
		case '1':
			if (forDni !== null) {
				// Obtener el valor del elemento
				let
				dniValue = forDni.value.trim();

				// Verificar si el valor contiene solo dígitos y tiene una longitud válida
				if (/^\d{8,9}$/.test(dniValue)) {
					// La validación pasó
					enviar = true;
				} else {
					// La validación falló
					mostrarMensaje("error", "El DNI debe tener 8 dígitos numéricos.");
					//alert("El DNI debe tener entre 8 y 9 dígitos numéricos.");
				}
			} else {
				// El elemento no se encontró
				mostrarMensaje("error", "Elemento 'forDniTxt' no encontrado.");
				//alert("Elemento 'forDniTxt' no encontrado.");
			}
			break;
		case '2':
			enviar = validarFechas();
			break;
		case '3':
			enviar = validarFechaDia();
			break;
		case '4':
			enviar = true;
			break;
		default:
			enviar = false;
			break;
		}
		if (enviar) {
			document.frmLogin.submit();

		}

	}
	function validarFechaDia() {
		// Obtener el elemento de fecha
		let
		forDiaDate = document.getElementById("forDiaDate");

		// Obtener la fecha ingresada
		let
		fechaSeleccionada = new Date(forDiaDate.value);

		// Obtener la fecha actual
		let
		fechaActual = new Date();

		// Validar que la fecha no sea nula
		if (!forDiaDate.value) {
			mostrarMensaje("error", "Por favor, ingrese una fecha.");
			//alert("Por favor, ingrese una fecha.");
			return false;
		}

		// Validar que la fecha no sea mayor que la fecha actual
		if (fechaSeleccionada > fechaActual) {
			mostrarMensaje("error", "La fecha seleccionada no puede ser mayor que la fecha actual.");
			//alert("La fecha seleccionada no puede ser mayor que la fecha actual.");
			return false;
		}
 
		return true;
	}
	function validarFechas() {
		// Obtener los elementos de fecha
		let
		forFechaInicio = document.getElementById("forFechaInicio");
		let
		forFechaFin = document.getElementById("forFechaFin");

		// Obtener las fechas ingresadas
		let
		fechaInicio = new Date(forFechaInicio.value);
		let
		fechaFin = new Date(forFechaFin.value);

		// Obtener la fecha actual
		let
		fechaActual = new Date();

		// Validar que las fechas no sean nulas
		if (!forFechaInicio.value || !forFechaFin.value) {
			alert("Por favor, complete ambas fechas.");
			return false;
		}

		// Validar que las fechas no sean mayores a la fecha actual
		if (fechaInicio > fechaActual || fechaFin > fechaActual) {
			alert("Las fechas no pueden ser mayores que la fecha actual.");
			return false;
		}

		// Validar que la fecha inicial no sea mayor a la fecha final
		if (fechaInicio > fechaFin) {
			alert("La fecha de inicio no puede ser mayor que la fecha de fin.");
			return false;
		}

		// Si todas las validaciones pasan, el formulario es válido
		return true;
	}
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#forDni").hide();
		$("#forFechas").hide();
		$("#forDia").hide();
		$("#btnBuscar").hide();

		$("#slcOpt").change(function() {
			let
			seleccion = $(this).val();
			$("#btnBuscar").show();
			switch (seleccion) {
			case '1':
				$("#forDni").show();
				$("#forFechas").hide();
				$("#forDia").hide();
				break;
			case '2':
				$("#forFechas").show();
				$("#forDni").hide();
				$("#forDia").hide();
				break;
			case '3':
				$("#forDia").show();
				$("#forDni").hide();
				$("#forFechas").hide();
				break;
			case '4':
				$("#forDni").hide();
				$("#forFechas").hide();
				$("#forDia").hide();
				$("#btnBuscar").show();
				break;
			default:
				$("#forDni").hide();
				$("#forFechas").hide();
				$("#forDia").hide();
				$("#btnBuscar").hide();
				break;
			}

		});

	});
</script>



</head>
<body class="" style="background-color: #F0F0F0;">

	<c:url var="url" value="/" />


	<form id="frmLogin" name="frmLogin" method="post"
		action="<c:out value='${url}'/>filterlogPM" runat="server">
		<input name="method" value="" type="hidden">

			<table class="rxsviewport" cellpadding="0" cellspacing="0"
				width="100%" border="0" height="100%">


				<tr>
					<td style="height: 10px"></td>
				</tr>


				<tr>
					<td valign="middle" align="center" style="height: 100%;"
						height="100%">

						<table class="rxbn" cellpadding="4" cellspacing="1"
							style="width: 900px" align="center">
							<tr>
								<th class="rxtitle" style="height: 14px; font-size: 15px; text-align:center;"
									align="center"> Log Auditoria PM</th>

							</tr>




							<tr>
								<td class="rxcontainer">

									<table cellpadding="4" width="100%">
										<tr>
											<td style="height: 10px"></td>
										</tr>
										<!-- INICIO -->
										<tr>
											<td width="24%" align="center">Buscar por :&nbsp;&nbsp;
												&nbsp;&nbsp; <select id="slcOpt" name="opt">
													<option value="0">Elija</option>
													<option value="1">DNI</option>
													<option value="2">Entre fechas</option>
													<option value="3">Por d&iacute;a</option>
													<option value="4">Ver todo</option>
											</select>

											</td>
										</tr>
										<tr>
											<td style="height: 10px"></td>
										</tr>
									<!-- 	POR DNI -->
										<tr id="forDni">
											<td width="24%" align="center">Ingresa DNI: <input
												id="forDniTxt" name="forDni" value="" type="text" onkeypress="return checkIt(event)" maxlength="8"></td>
										</tr>
										<!-- entre fechas -->
										<tr id="forFechas">
											<td width="24%" align="center">
												<table cellpadding="4" cellspacing="1">
													<tr>
														<td style="height: 10px">Fecha Inicio:</td>
														<td style="height: 10px"><input name="forFechaInicio"
															id="forFechaInicio" type="date" /></td>
													</tr>
													<tr>
														<td style="height: 10px">Fecha FIN:</td>
														<td style="height: 10px"><input name="forFechaFin"
															id="forFechaFin" type="date" /></td>
													</tr>
												</table>

											</td>
										</tr>
										<!-- por dia -->
										<tr id="forDia">
											<td width="24%" align="center">
												<table cellpadding="4" cellspacing="1">
													<tr>
														<td style="height: 10px">Seleccione dia:</td>
														<td style="height: 10px"><input name="forDia"
															id="forDiaDate" type="date" /></td>
													</tr>

												</table>

											</td>
										</tr>

														<tr>

															<td width="10%" colspan="6" align="center"><span
																id="mensaje"></span></td>

														</tr>
									<!-- 	btn Buscar -->
										<tr id="btnBuscar">
											<td colspan="2" align="center"><input type="button"
												class="buttonCls" style="width: 140px" value="BUSCAR"
												onclick="enviarForm()" /></td>

										</tr>

										<!-- FIN -->
										<tr>
											<td style="height: 30px"></td>
										</tr>



										<tr>
											<td align="center">

												<table align="center" width="100%">
													<tr>
														<c:if test="${not empty contenlog  }">
														
														
														<table align="center" width="85%" border="0">

															<tr>
																<td><display:table id="dataTable"
																		class="headerDisplay" name="${contenlog}"
																		pagesize="20" id=" " cellpadding="0" cellspacing="0"
																		requestURI="">
																<script type="text/javascript">
      															  $(document).ready(function() {
      															   
      															   var numpres = "${contenlog}";
														          
														    
      															  
													console.log("Error", numpres);
															            
															   													            
															      
     																});
   																 </script>																		
																		<display:column property="prestamo" title="N° PRESTAMO"></display:column>
																		<display:column property="fecha" title="FECHA"></display:column>
																		<display:column property="usuario" title="CUSUARIO"></display:column>
																		<display:column property="codAgencia" title="COFICINA."></display:column>
																		<display:column property="cliente" title="CLIENTE."></display:column>
																		<display:column property="doi" title="DOI"></display:column>
																		<display:column property="celular" title="CELULAR"></display:column>
																		<display:column property="correo" title="CORREO"></display:column>
																		<display:column property="envio" title="SIT. ENVÍO"></display:column>
																		<display:column property="accion" title="ACCION"></display:column>
																		
																	</display:table></td>
																																							
																																			
															</tr>

															<tr>
																<td style="height: 20px"></td>
															</tr>
														</table>
														</c:if>
														
														<c:if test="${empty contenlog and first == null}">
															    <!-- Código para cuando la lista está vacía -->
  																	<tr>
																		<td style="height: 20px"></td>
																	</tr>
																	
																	<tr>
																		<td align="center"><strong> Estimado(a)
																		
																		</strong></td>
																	</tr>
																	<tr>
																		<td align="center"><strong>
																				No hay registros de autditoria para la consulta</strong></td>
																	</tr>
																 
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

