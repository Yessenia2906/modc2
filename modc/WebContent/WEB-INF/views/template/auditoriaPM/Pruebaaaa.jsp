<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml2/DTD/xhtml1-strict.dtd">
<%@page import="pe.com.bn.modc.common.Util"%><title>Titulo</title>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
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

<script>

function EnviarAccion1(pagina,action){
alert(pagina);
alert(action);
alert('prueba');
document.Accion.action=pagina;
document.Accion.method.value=action;
document.Accion.submit();
}
</script>

<script type="text/javascript">

function iniciarSesion(){
	 
	
	if(validar()){
	 
		document.frmLogin.submit();
	}
}


function validar(){
	 var select = document.getElementById("myselect");

	
	if(select.options[select.selectedIndex].value == "1"){
	return true;
	}else{
	
	if(document.frmLogin.Numero.value <13){
		alert(' m\u00EDnimo 13 digitos');
		
		return false;
	}

   if(document.frmLogin.Numero.value==''){
		alert('Ingrese el .');
		
		return false;
	} 
	}
	
	return true;
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



function verTodo(desembolso){
	
	 document.getElementById('desembolso').value = desembolso;
		document.verPrestamoT.submit();
	
}

function ver(){
	 
		document.docPrestamo.submit();
	
}


function verExportar(){
	 
		document.docPrestamoEx.submit();
	
}

 function mostrar_control(){
        var select = document.getElementById("myselect");
        var inputText = document.getElementById("Numero");
        if(select.options[select.selectedIndex].value == "Nuevo"){
            inputText.style.visibility = "visible";
        }else{
            inputText.style.visibility = "hidden";
        }
    }
    
    
    function enviar(){


   document.exPrestamoEnviar.submit();
}   
 
</script>



</head>
<body class="" style="background-color: #F0F0F0;">

<c:url var="url" value="/" />

<form id="exPrestamoEnviar" name="exPrestamoEnviar" method="post" action="<c:out value='${url}'/>exPrestamoEnviar"   runat="server" >
<input	id="numero" name="numero" value = "<c:out value="${desembolso}"  />" type="hidden" /> 
	<input	id="enviar" name="enviar" value = "SI" type="hidden" /> 
	<input	id="pol1" name="pol1" type="hidden" /> 
	<input	id="sol1" name="sol1" type="hidden" /> 
</form>

<form id="docPrestamoEx" name="docPrestamoEx" method="post" action="<c:out value='${url}'/>docPrestamoEx"   runat="server" >
   
	<input	id="enviar" name="enviar" value = "SI" type="hidden" /> 
	<input	id="pol1" name="pol1" type="hidden" /> 
	<input	id="sol1" name="sol1" type="hidden" /> 
</form> 

<form id="verPrestamoT" name="verPrestamoT" method="post" action="<c:out value='${url}'/>verPrestamoT"   runat="server" >
    <input type="hidden" name="desembolso" value="" id="desembolso" />	
	<input	id="enviar" name="enviar" value = "SI" type="hidden" /> 
	<input	id="pol1" name="pol1" type="hidden" /> 
	<input	id="sol1" name="sol1" type="hidden" /> 
</form> 


<form id="docPrestamo" name="docPrestamo" method="post" action="<c:out value='${url}'/>docPrestamo"   runat="server" >
	<input	id="numero" name="numero" value = "<c:out value="${desembolso}"  />" type="hidden" /> 
	<input	id="enviar" name="enviar" value = "SI" type="hidden" /> 
	<input	id="pol1" name="pol1" type="hidden" /> 
	<input	id="sol1" name="sol1" type="hidden" /> 
</form>




<form  id="frmLogin" name="frmLogin" method="post" action="<c:out value='${url}'/>consulPM" runat="server"   >
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
						&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp; 
						&nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;PRUEBAAAA 
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
													
												
													<td width="24%" align="center">Buscar:&nbsp;&nbsp; &nbsp;&nbsp; 
													<select id="myselect" onchange="mostrar_control()">
													  <option value="0"></option>
                                                      <option value="1">Todo</option>
                                                      <option value="Nuevo">Desembolso</option>          
                                                      </select>
											
												<input id="Numero" name="Numero" type="text" style="visibility: hidden; width: 90px; " onKeyPress="return checkIt(event)"  maxlength="13" /></td>	
												
													
												</tr>
												
												<tr><td style="height: 10px" ></td></tr>
												
												
											<tr>
													<td colspan="1" align="center">
                                                       <input type="button" class="buttonCls" submit="true" style="width: 140px" value="CONSULTAR"  onclick="iniciarSesion();" />
													
													</td>
																	
									<td  align="right">
		<input type="button" class="buttonCls" submit="true" style="width: 140px" value="enviar" name=""  id="" onclick="enviar()"  />	    
		</td>		
										
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



<c:if test="${msje eq 'Error 30'}">
<center>
<table width="60%" align="center" class="small">
<tr><td style="height: 20px" ></td></tr>
	<tr>
		<td  align="center"><strong> Se envio el correo electrónico. </strong></td>
	</tr>
</table>
</center>
</c:if>	

							
									
<c:if test="${msje eq 'Consultar Todo' }">
<center>
<table width="60%" align="center" class="small">
<tr><td style="height: 20px" ></td></tr>
   
   <tr><td style="height: 30px"  align="center" colspan="2"  BGCOLOR="#EFF5FB">
   <font face="Verdana" SIZE=4 ><strong>Consulta total de generación de documentos</strong></font>
   
   </td></tr>
  
	<tr><td style="height: 20px" ></td></tr>
	<tr><td style="height: 20px" ></td></tr>

	<tr>
		<td  align="center">
			    
		</td>
		<td  align="right">
		<input type="button" class="buttonCls" submit="true" style="width: 140px" value="enviar" name=""  id="" onclick="enviar()"  />	    
		</td>
	</tr>
</table>
</center>
<center>
    <table width="85%" border="0" >
		
				<tr>
					<td>
		
			
  		<display:table     class="headerDisplay"  name="result"    id="result" cellpadding="0" cellspacing="0" requestURI="" pagesize="20"  >
		  
			<display:column title="N&deg;" ><c:out value="${result.filas}" /></display:column>
			<display:column title="DESEMBOLSO" ><c:out value="${result.desembolso}" /></display:column>
			<display:column title="PRODUCTO" ><c:out value="${result.tipo}" /></display:column>
			<display:column title="CORREO" ><c:out value="${result.email}" /></display:column>
			<display:column title="FECHA Y HORA DE ENVIO" ><c:out value="${result.fechaCarga}" /></display:column>
			<display:column title="DOCUMENTO" >		
			<input type="button" class="buttonCls" submit="true" style="width: 140px" value="Ver" name=""  id="" onclick="verTodo('${result.desembolso}')"  />
				    
            </display:column>
			
			
		</display:table>                                                                                                                                                                           
		
		
	    </td>
					
				</tr>
	
	   
		</table>
</center>




</c:if>										
									
									
<c:if test="${msje eq 'Haga Clic en Abrir para Confirmar la Exportación' }">
<center>
<table width="60%" align="center" class="small">
<tr><td style="height: 20px" ></td></tr>

<tr><td style="height: 30px"  align="center" colspan="2"  BGCOLOR="#EFF5FB">
   <font face="Verdana" SIZE=4 ><strong>Consultaa por Desembolso</strong></font>
   <td  align="right">
		<input type="button" class="buttonCls" submit="true" style="width: 140px" value="enviar" name=""  id="" onclick="enviar()"  />	    
		</td>	
   </td></tr>
   
   <tr><td style="height: 20px" ></td></tr>
   <tr><td style="height: 20px" ></td></tr>
		
</table>
</center>
<center>
    <table width="85%" border="0" >
		
				<tr>
					<td>
		
			
  		<display:table     class="headerDisplay"  name="result"    id="result" cellpadding="0" cellspacing="0" requestURI=""  >
		  
			<display:column title="DESEMBOLSO" ><c:out value="${result.desembolso}" /></display:column>
			<display:column title="PRODUCTO" ><c:out value="${result.tipo}" /></display:column>
			<display:column title="CORREO" ><c:out value="${result.email}" /></display:column>
			<display:column title="FECHA Y HORA DE ENVIO" ><c:out value="${result.fechaCarga}" /></display:column>
			<display:column title="DOCUMENTO" >
			<input type="button" class="buttonCls" submit="true" style="width: 140px" value="Ver"  onclick="ver();" />
		    <input type="button" class="buttonCls" submit="true" style="width: 140px" value="Enviar" name=""  id="" onclick="enviar()"  />	    
            </display:column>
		</display:table>
		
		
	    </td>
					
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

