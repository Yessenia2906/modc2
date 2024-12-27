<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1-strict.dtd">
<%@page import="pe.com.bn.modc.common.Util"%><title>Título</title>
<%@page import="pe.com.bn.modc.common.DatosSesion"%>
<%@page import="pe.com.bn.modc.common.Constant"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
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

<title>PRÉSTAMO MULTIRED</title>
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
<link href='<c:url value="/assets/css/datepicker.css"/>'
	rel="stylesheet" />

<script src='<c:url value="/assets/js/datepicker.js"/>'></script>
<script src='<c:url value="/assets/js/datepicker-es.js"/>'></script>
<tag:scripts />

<script type="text/javascript">
	window.addEventListener('load', function() {
 function generarOpciones(selectId, desde, hasta) {
    var select = document.getElementById(selectId);

    // Iterar desde el año "desde" hasta el año "hasta"
    for (var i = desde; i <= hasta; i++) {
      // Crear una opción con el año y agregarla al select
      var option = document.createElement("option");
      option.value = i;
      option.text = i;
      select.appendChild(option);
    }
  }

  // Obtener el año actual
  var anioActual = new Date().getFullYear();

  // Llamar a la función para generar opciones de años para cada select
  generarOpciones("selectAgeCorteInicio", 2013, anioActual);
  generarOpciones("selectAgeCorte", 2013, anioActual);
  
document.getElementById('loading').style.display = 'none'; // Muestra la ventana de carga
  
  var span = document.getElementsByClassName("close")[0];
            var modal = document.getElementById("pdfModal");

            // Cuando se hace clic en la "X", se cierra el modal
            span.onclick = function() {
                modal.style.display = "none";
            };

            // Cuando se hace clic fuera del modal, se cierra
            window.onclick = function(event) {
                if (event.target == modal) {
                    modal.style.display = "none";
                }
            };  
	});
	
	
</script>

<script type="text/javascript">
function validar(){

 if (!document.frmLogin.numeroDniTarjeta.value) {
     alert("Ingrese el DNI");
     return false;
    } 

 if (document.frmLogin.numeroDniTarjeta.value.length < 8) {
     alert("Recuerde el documento tiene un mínimo 8 dígitos");
     return false;
    } 
    
    
    
    if (!document.frmLogin.selectMesCorteInicio.value) {
     alert("Seleccione el mes inicial de la búsqueda");
     return false;
    }
    
    
     if (!document.frmLogin.selectAgeCorteInicio.value) {
     alert("Seleccione año inicial de la búsqueda");
     return false;
    }  
    
         if (!document.frmLogin.selectMesCorte.value) {
     alert("Seleccione mes final de la búsqueda");
     return false;
    }  
             if (!document.frmLogin.selectAgeCorte.value) {
     alert("Seleccione año final de la búsqueda");
     return false;
    }  
	const AgeCorte = document.getElementById("selectAgeCorte").value;
    const AgeCorteInicio = document.getElementById("selectAgeCorteInicio").value;
	var numeroAgeini = parseInt(AgeCorteInicio);
	var numeroAgeFin= parseInt(AgeCorte);
	
	if (numeroAgeini>numeroAgeFin) {
     alert("Recuerde el año final de la búsqueda no puede ser mayor al año inicial");
     return false;
    } 
	
	if (numeroAgeFin == numeroAgeini+1 || numeroAgeFin == numeroAgeini || numeroAgeFin == numeroAgeini-1) {
		return true;	
	} else {
		alert('Fecha fin como máximo un año de diferencia.');		
		return false;
	}
		
}

function buscareecc(){
    var loadingElement = document.getElementById('loading');

	if(validar()){
	if (loadingElement) {
            loadingElement.style.display = 'flex'; // Cambia esto a 'flex' para respetar el estilo dado
        }
 		document.frmLogin.submit();
	}
		
	
}
var fileName = "valorInicial";
async function buscareeccindi(event,nombrearchivo){
event.preventDefault(); // Prevenir el comportamiento por defecto del enlace
    var loadingElement = document.getElementById('loading');

 
     loadingElement.style.display = 'flex'; // Cambia esto a 'flex' para respetar el estilo dado
       
             try {
                const response = await fetch('/modc/buscarestadopdf/pdf', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: nombrearchivo
                });

                if (!response.ok) throw new Error('Error fetching the PDF');
 				
                const data = await response.json();
                if (!data.hasOwnProperty('base64Content') || data.base64Content === " ") {
				    throw new Error('FTP - 0300');
				}

                
                fileName = data.fileName;
                const base64Pdf = data.base64Content;
			//	console.log({data});
                // Convertir la cadena base64 a un array de bytes
                const byteCharacters = atob(base64Pdf);
                const byteNumbers = new Array(byteCharacters.length);
                for (let i = 0; i < byteCharacters.length; i++) {
                    byteNumbers[i] = byteCharacters.charCodeAt(i);
                }
                const byteArray = new Uint8Array(byteNumbers);

                // Crear un Blob con los bytes del PDF
                const blob = new Blob([byteArray], { type: 'application/pdf' });


		        const pdfDataUri = URL.createObjectURL(blob) ; // Ocultar toolbar

			  // Crear un URI data: con el PDF en base64
			   //     const pdfDataUri = 'data:application/pdf;base64,'+base64Pdf;

                document.getElementById('pdfEmbed').src = pdfDataUri;
                document.getElementById('pdfModal').style.display = "block";

            } catch (error) {
                alert(error);
            } finally {
                loadingElement.style.display = 'none';
            }
        }
  

function checkIt(evt) {

    evt = (evt) ? evt : window.event
    var charCode = (evt.which) ? evt.which : evt.keyCode
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        status = "Solo números";
        return false;
    }
    status = "";
    return true;
}

function enviarCorreo(){
	
   let listchx = document.querySelectorAll('input[type="checkbox"]:checked');
    let valorInput = document.getElementById("inputCorreoCliente").value;
   if(valorInput.trim() === ""){
   alert("Ingrese un correo primero!!!");
   }else{
   if (listchx.length > 0) {
    let valores = "";
      var loadingElement = document.getElementById('loading');

 
     loadingElement.style.display = 'flex'; // Cambia esto a 'flex' para respetar el estilo dado
       
   listchx.forEach(function(ch,index){ 
   		
   		valores += ch.value;
   		console.log("valor "+ ch.value);
    if (index < listchx.length - 1) {
            valores += "|";
        }
   });
   // Establecer la cadena de valores como el valor del input tipo hidden
    document.getElementById("eeccEnviar").value = valores;

    // Mostrar la cadena de valores en la consola (opcional)
    console.log("Valores de los checkboxes seleccionados:", valores);
   		document.frmCorreo.submit();
   }else{
   		alert("Seleccione al menos un Estado a enviar");
   }
   
   }
   
}
 function descargarPDF() {
    const pdfEmbed = document.getElementById('pdfEmbed');
    const pdfSrc = pdfEmbed.src;

    // Crear un enlace temporal para descargar el archivo
    const link = document.createElement('a');
    link.href = pdfSrc;
    link.download = fileName; // Nombre del archivo descargado
    link.click();
}
 
</script>


<script>
$(document).ready(function() {
    $("#btnEnviar").click(function() {
        $("#loading").show(); // Muestra el indicador de carga antes de hacer la llamada AJAX
    
        // Obtener el valor del correo electrónico (puedes obtenerlo de un formulario u otra fuente)
        var dni = $("#numeroDniTarjeta").val();

        // Configurar la URL de la solicitud con el parámetro 'email'
        var url = "/modc/getEmail/" + dni;
		//console.log(url);
        // Realizar la solicitud AJAX con jQuery
        $.ajax({
            url: url,
            type: "GET",
            dataType: "json",
            success: function(data) {
            var valorEmail = '';
            if(data.email === "NO EMAIL" || data.email === "" ){
            valorEmail = 'No se encontró Email, Actualice los datos en BDUC';
            alert(valorEmail);
            }else{
            valorEmail = data.email;
            	$("#inputCorreoCliente").val(valorEmail).text(valorEmail);
				$("#correoCliente").val(data.email);
            }
             $("#loading").hide(); // Oculta el indicador de carga
				
             },
            error: function(jqXHR, textStatus, errorThrown) {
                // Manejar errores de la solicitud
                valorEmail = 'Error al consumir Servicio de Bduc';
            	alert(valorEmail);
            	 $("#loading").hide(); // Oculta el indicador de carga
                console.error('Error:', textStatus, errorThrown);
            }
        });
    });
 
          
            
            
            
            
            
    
    
    
});
</script>
<!-- Código para el círculo de carga -->
 <style type="text/css">
#loading {
    display: none;
    position: fixed;
    z-index: 1050;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(255, 255, 255, 0.7);
    display: flex;
    align-items: center;
    justify-content: center;
}

.spinner {
    position: relative;
    width: 120px; 
    height: 120px;
}

.spinner-border {
    border: 16px solid rgba(255,0,0,0.1); /* Aumenta el ancho del borde y cambia a color rojo claro */
    border-radius: 50%;
    border-top: 16px solid red; /* Color rojo */
    width: 100%; 
    height: 100%;
    animation: spin 2s linear infinite;
}

@keyframes spin {
    0% { transform: rotate(0deg); }
    100% { transform: rotate(360deg); }
}

.spinner-text {
    position: absolute;
    top: 60%;
    left: 60%;
    transform: translate(-50%, -50%);
    color: black;
    font-size: 16px;
    font-weight: bold;
}
 /* Estilos para el modal */
        .modal {
    display: none;
    position: fixed;
    z-index: 1050;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    overflow: auto;
    background-color: rgba(0, 0, 0, 0.5);
}

.modal-content {
    background-color: #fefefe;
    margin: 5% auto;
    border: 1px solid red; /* Borde rojo */
    width: 80%;
    max-width: 700px;
    position: relative;
    display: flex;
    flex-direction: column;
    height: 80%;
}

/* Barra superior */
.modal-header {
    background-color: #ffffff; /* Fondo blanco */
    color: red; /* Letras rojas */
    font-weight: bold; /* Letras en negrita */
    padding: 10px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    border-bottom: 1px solid red; /* Borde inferior rojo */
}

/* Botón de cierre */
.close {
    color: red; /* Color rojo */
    font-size: 28px;
    font-weight: bold;
    cursor: pointer;
}

.close:hover,
.close:focus {
    color: darkred; /* Color rojo más oscuro al pasar el mouse */
    text-decoration: none;
    cursor: pointer;
}

/* Contenedor del PDF */
.modal-body {
    flex: 1;
    overflow: hidden;
}

.modal-body embed,
.modal-body iframe {
    width: 100%;
    height: 100%;
}

/* Barra inferior */
.modal-footer {
    background-color: #f1f1f1;
    padding: 10px;
    display: flex;
    justify-content: flex-end;
    border-top: 1px solid #ddd;
}

.modal-footer button {
    margin-left: 10px;
}

</style>


</head>
<body class="" style="background-color: #F0F0F0;">


	<c:url var="url" value="/" />
	<form id="frmCorreo" name="frmCorreo" method="post"
		action="<c:out value='${url}'/>enviarestadopdfcorreo" runat="server">
		<input type="hidden" id="numeroDniTarjeta" name="numeroDniTarjeta" value="${dniCliente}" />
		<input type="hidden" name="fechaInicioCorreo" value="${fechacorteInicio}" />
		<input type="hidden" name="fechaFinCorreo" value="${fechacorteFin}" />
		<input type="hidden" name="correoCliente" id="correoCliente" value="" />
		<input type="hidden" name="eeccEnviar" id="eeccEnviar" value="" />
	</form>

	<form id="frmLogin" name="frmLogin" method="post"
		action="<c:out value='${url}'/>buscarestadopdf" runat="server">
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
									<th class="rxtitle" style="height: 14px; text-align: center;font-size: 15px;" >                                           
										              								Estado de Cuenta - Tarjeta de
										Crédito</th>

								</tr>
								<tr>
									<td class="rxcontainer">
										<table cellpadding="4" width="100%">
											<tr></tr>
											<tr>
												<td align="left">
													<table width="100%">
														<tr>
															<td align="center">N&ordm; de DNI :</td>
															<td><input type="text" id="numeroDniTarjeta"
																name="numeroDniTarjeta" value="${dniCliente}"
																onKeyPress="return checkIt(event)" style="width: 110px;"
																maxlength="10" /></td>
														</tr>
														<tr>
															<td width="400px" align="center">Fecha Inicio :</td>


															<td align="left"><select class="form-control"
																name="selectMesCorteInicio" id="selectMesCorteInicio">
																	<option value="">MES</option>
																	<option value="01">Enero</option>
																	<option value="02">Febrero</option>
																	<option value="03">Marzo</option>
																	<option value="04">Abril</option>
																	<option value="05">Mayo</option>
																	<option value="06">Junio</option>
																	<option value="07">Julio</option>
																	<option value="08">Agosto</option>
																	<option value="09">Septiembre</option>
																	<option value="10">Octubre</option>
																	<option value="11">Noviembre</option>
																	<option value="12">Diciembre</option>
															</select> / <select class="form-control"
																name="selectAgeCorteInicio" id="selectAgeCorteInicio">
																	<option value="">AÑO</option>


															</select></td>
														</tr>
														<tr>
															<td height="10px" align="center"></td>
															<td></td>
														</tr>
														<tr>



															<td width="400px" align="center">Fecha Fin :</td>


															<td align="left"><select class="form-control"
																name="selectMesCorte" id="selectMesCorte">
																	<option value="">MES</option>
																	<option value="01">Enero</option>
																	<option value="02">Febrero</option>
																	<option value="03">Marzo</option>
																	<option value="04">Abril</option>
																	<option value="05">Mayo</option>
																	<option value="06">Junio</option>
																	<option value="07">Julio</option>
																	<option value="08">Agosto</option>
																	<option value="09">Septiembre</option>
																	<option value="10">Octubre</option>
																	<option value="11">Noviembre</option>
																	<option value="12">Diciembre</option>
															</select> / <select class="form-control" name="selectAgeCorte"
																id="selectAgeCorte">
																	<option value="">AÑO</option>

															</select></td>
														</tr>
														<tr>
															<td style="height: 10px"></td>
															<td></td>
														</tr>

														<c:if test="${!fn:endsWith(msje, 'Error consulte con el administrador')}">
														<tr>
															<td align="center" colspan="2"><input type="button"
																class="buttonCls" submit="true" style="width: 200px"
																value="BUSCAR ESTADO" onclick="buscareecc();" /></td>
														</tr>
														</c:if>
															<tr  >
															<td align="center" colspan="2">  
														<!-- 	CÍRCULO DE CARGA  -->
															<div id="loading">
															    <div class="spinner">
															        <div class="spinner-border"></div>
															        <div class="spinner-text">Cargando...</div>
															    </div>
															</div>

															</td>
															</tr>
														<tr>
															<c:if test="${estadoCorreoEnvio != null}">

																<center>
																<table width="60%" align="center" class="small">
																	<tr>
																		<td style="height: 20px"></td>
																	</tr>
																	<tr>
																		<td align="center"><strong> Estimado(a)
																		</strong></td>
																	</tr>
																	<tr>
																		<td align="center"><strong>
																				${estadoCorreoEnvio}</strong></td>
																	</tr>
																</table>
																</center>


															</c:if>

															<c:if test="${respuesta == false}">

																<center>
																<table width="60%" align="center" class="small">
																	<tr>
																		<td style="height: 20px"></td>
																	</tr>
																	 <tr>
																		<td align="center"><strong> Estimado(a)
																		</strong></td>
																	</tr>
																	<tr>
																		<td align="center"><strong> ${msje}</strong></td>
																	</tr>
																</table>
																</center>




															</c:if>


															<c:if
																test="${!estados.equals(null) && msje eq 'Exito buscando EECC'}">

																<table width="60%" align="center" class="small">
																	<tr>
																		<td style="height: 20px"></td>
																	</tr>

																	<tr>
																		<td style="height: 30px" align="center" colspan="2"
																			BGCOLOR="#EFF5FB"><font face="Verdana" SIZE=4>
																			<strong>Estado de Cuenta</strong></font></td>
																	</tr>

																	<tr>
																		<td style="height: 20px"></td>
																	</tr>

																	<tr>
																	</tr>
																</table>

																<table align="center" width="85%" border="0">

																	<tr>
																		<td><display:table class="headerDisplay"
																				name="${estados}" id="estado" cellpadding="0"
																				cellspacing="0" requestURI="">

																				<display:column title="Selecciona">
																					<input type="checkbox" id="chxEECC" name="chxEECC"
																						value="${estado.nombrearchivo}">
																				</display:column>
																				<display:column title="Fecha Corte">
																					<c:out value="${estado.fecha}" />
																				</display:column>


																				<display:column title="DNI">
																					<c:out value="${estado.dni}" />
																				</display:column>
																			 
																				<display:column title="ESTADO PDF">
																					<a type="button"
																						download="EECC_${estado.nombrearchivo}"
																						onclick="buscareeccindi(event,'${estado.nombrearchivo}');"
																						style="width: 140px; text-decoration: none;"
																						class="buttonCls"
																						id="${estado.nombrearchivo}"
																						href="#" >VER</a>
																				</display:column>
																				 
																 

																			</display:table></td>


																	</tr>

																	<tr>
																		<td style="height: 20px"></td>
																	</tr>
																</table>



																<table align="right" width="100%" border="0">

																	<tr>
																		<td width="60%" align="right"><input
																			type="button" class="buttonCls" value="Ver Correo"
																			name="" id="btnEnviar" onclick="" /></td>
																		<td align="right" width="200px">
																		<c:set var="readOnlyMode" value="true" />
																	 
															<input   type="text" id="inputCorreoCliente" name="inputCorreoCliente" placeholder="example@gmail.com" style="width: 250px;" maxlength="50"  readonly/>
																			
 																			 <input
																			type="button" class="buttonCls" submit="true"
																			value="Enviar" name="" id=""
																			onclick="enviarCorreo();" />
																			
																			</td>

																	</tr>
																 

																</table>

															</c:if>
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

<div id="pdfModal" class="modal">
        <div class="modal-content">
            <div class="modal-header">
                <span>PDF Documento</span>
                <span class="close">&times;</span>
            </div>
            <div class="modal-body">
                <embed id="pdfEmbed" type="application/pdf">
            </div>
            <div class="modal-footer">
<button id="downloadBtn" class="buttonCls" onclick="descargarPDF()">Descargar</button>
            </div>
        </div>
    </div>





</body>
</html>
