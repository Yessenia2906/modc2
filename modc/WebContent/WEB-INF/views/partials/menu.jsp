<%@page import="pe.com.bn.modc.common.Constant"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<% 
	response.setHeader("Cache-Control","no-cache"); 
	response.setHeader("Cache-Control"," no-store ");
	response.setHeader("Pragma","no-cache"); 
	response.setDateHeader ("Expires", 0); 
%>
 
<style type="text/css">

/* pone lista inicial en blanco */
#nav ul, 
#nav li:hover ul ul,
#nav li:hover ul li:hover ul ul,
#nav li:hover ul li:hover ul li:hover ul ul,
#nav li:hover ul li:hover ul li:hover ul li:hover ul ul {position:absolute; left:-9999px; top:-9999px; width:0; height:0; margin:0; padding:0; list-style:none;}



/* visualizacion de sublista */

#nav li:hover {position:relative; z-index:200;}

#nav li:hover ul.sub {left:1px; top:38px; background: #fff; padding:3px; border:1px solid #C61316; white-space:nowrap; width:160px; height:auto; z-index:300;}
#nav li:hover ul.sub li {display:block; height:20px; position:relative; float:left; width:160px; font-weight:normal;}
#nav li:hover ul.sub li a {display:block; font-size:11px; height:20px; width:150px; line-height:18px; text-indent:5px; color:#000; text-decoration:none;border:1px solid #fff;}
#nav li ul.sub li a.fly {background:#50b5d0 80px 6px no-repeat;}
#nav li:hover ul.sub li a:hover {background:#C61316; color:#fff;}
#nav li:hover ul.sub li a.fly:hover {background:#C61316 250px 7px no-repeat; color:#fff;}

/* height:0px */
/* Menu principal */
#nav {padding:0; margin:0;list-style:none; width:100%; height:60px; background:#fff repeat-x; position:relative; z-index:500; font-family:arial, verdana, sans-serif; white-space: nowrap;}
#nav li.top {display:block; float:left;}
#nav li a.top_link {display:block; float:left; height:25px;  color:#C61316;border:2px solid #C61316;  text-decoration:none; font-size:11px; font-weight:bold; padding:10px 0 0 10px; cursor:pointer; }
#nav li a.top_link span {float:left; display:block; padding:0 12px 0 12px; height:35px; background: right top no-repeat;}
#nav li a.top_link span.down {float:left; display:block; padding:0 24px 0 12px; height:35px; background: no-repeat right top;}

#nav li:hover a.top_link {background: no-repeat;background:#FFD5D5; color:#C61316;}
#nav li:hover a.top_link span {background: no-repeat right top;}
#nav li:hover a.top_link span.down {background: no-repeat right top; padding-bottom:3px;}


</style>

<script type="text/javascript">

	function iniciarSesion(){
		
		if(validar()){
			document.frmLogin.submit();
		}
		
	}

</script>

<%-- <% --%>
<!--         if(request.getSession().getAttribute("datosSesion")==null) { -->
<%--  %> --%>
<!--        <script type="text/javascript"> endSesion();</script> -->
<%-- <% --%>
<!--         } -->
<%-- %> --%>

<%-- <% --%>
<!--         DatosSesion datosSesion=(DatosSesion)request.getSession().getAttribute("datosSesion"); -->
<%-- %> --%>

<%-- <% if(datosSesion!=null){%> --%>



<ul id="nav">

	<sec:authorize access="hasAnyRole('01')">
		<c:url var="url" value="/" />
		
		<li class="top"><a id="modInfo" href="javascript:void(0)" class="top_link"><span class="down">Pr&eacute;stamo Multired</span></a>

			<ul class="sub">
				
				<sec:authorize url="/prestamo/**">
					<li>
						<a id="conNombre"   href='<c:out value="${url}"/>prestamo/' >
							<span>Emisi&oacute;n Documentos</span>
						</a>
						
					</li>
				</sec:authorize>
				
				<sec:authorize url="/reprogramacion/**">
					<li>
						<a id="conNombre"   href='<c:out value="${url}"/>reprogramacion/' >
							<span>Emisi&oacute;n de Cronograma</span>
						</a>
					</li>
				</sec:authorize>
				
				<sec:authorize url="/emision/**">
					<li>
						<a id="conNombre"   href='<c:out value="${url}"/>emision/' >
							<span>Emisi&oacute;n Liquidac&oacute;n</span>
						</a>
					</li>
				</sec:authorize>
				<!--  -->
				<sec:authorize url="/pase/**">
					<li>
						<a id="conNombre"   href='<c:out value="${url}"/>pase/' >
							<span>Pase Judicial</span>
						</a>
					</li>
				</sec:authorize>
			
				<sec:authorize url="/validarC/**">
				    <li>
				        <a id="conNombre" href='<c:out value="${url}"/>validarC/'>
				            <span>Validar Correo</span>
				        </a>
				    </li>
				</sec:authorize>
				
				<sec:authorize url="/enviarDocVirtual/**">
					<li>
						<a id="conNombre"   href='<c:out value="${url}"/>enviarDocVirtual/' >
							<span>Enviar Documentos</span>
						</a>
					</li>
				</sec:authorize>
				
				<sec:authorize url="/seguimientoEnvio/**">
					<li>
						<a id="conNombre"   href='<c:out value="${url}"/>seguimientoEnvio/' >
							<span>Seguimiento Envio</span>
						</a>
					</li>
				</sec:authorize>
				
			</ul>
			
		</li>
	    <li class="top"><span class="down">&nbsp;</span></li>
			
	</sec:authorize>
		
<%-- <%if(datosSesion.getPermisos().indexOf("01")>=0){%> --%>

<!-- 	<li class="top"><a id="modInfo" href="javascript:void(0)" class="top_link"><span class="down">Pr&eacute;stamo Multired</span></a> -->

<!-- 		<ul class="sub"> -->
				
			
<%-- 				<%if(datosSesion.getPermisos().indexOf("01")>=0){%>	 --%>
<!-- 				<li><a  id="conNombre"   href="javascript:void(0)" onclick="submitsAction('frmMain0','prestamo','N',true)" ><span>Emisi&oacute;n Documentos</span></a></li> -->
<%-- 				<%}%> --%>
<%-- 				<%if(datosSesion.getPermisos().indexOf("01")>=0){%>	 --%>
<!-- 				<li><a  id="conNombre"   href="javascript:void(0)" onclick="submitsAction('frmMain0','reprogramacion','N',true)" ><span>Emisi&oacute;n de Cronograma</span></a></li> -->
<%-- 				<%}%> --%>
			
				
<!-- 		</ul> -->
		
<!-- 	</li> -->
<!--     <li class="top"><span class="down">&nbsp;</span></li> -->
	
<%-- <%}%> --%>

	<sec:authorize access="hasAnyRole('02')">
		<c:url var="url" value="/" />
		
		<li class="top"><a id="modInfo" href="javascript:void(0)" class="top_link"><span class="down">Tarjeta Cr&eacute;dito</span></a>

			<ul class="sub">
				
				<sec:authorize url="/solicitud/**">
					<li>
						<a id="conNombre"   href='<c:out value="${url}"/>solicitud/' >
							<span>Solicitud</span>
						</a>
					</li>
				</sec:authorize>
				
				<sec:authorize url="/consultaTC/**">
					<li>
						<a id="conNombre"   href='<c:out value="${url}"/>consultaTC/' >
							<span>Consultar TC</span>
						</a>
					</li>
				</sec:authorize>
				
				<sec:authorize url="/cancelacion/**">
					<li>
						<a id="conNombre"   href='<c:out value="${url}"/>cancelacion/' >
							<span>Cancelaci&oacute;n</span>
						</a>
					</li>
				</sec:authorize>
				
				<sec:authorize url="/poliza/**">
					<li>
						<a id="conNombre"   href='<c:out value="${url}"/>poliza/' >
							<span>P&oacute;liza de Seguro</span>
						</a>
					</li>
				</sec:authorize>
					<sec:authorize url="/estadocuenta/**">
					<li>
						<a id="conNombre"   href='<c:out value="${url}"/>estadocuenta/' >
							<span>Estado de Cuenta</span>
						</a>
					</li>
				</sec:authorize>
				
				
			</ul>
			
		</li>
	    <li class="top"><span class="down">&nbsp;</span></li>
		
	</sec:authorize>

<%-- <%if(datosSesion.getPermisos().indexOf("02")>=0 ){%> --%>

<!-- 	<li class="top"><a id="modInfo" href="javascript:void(0)" class="top_link"><span class="down">Tarjeta Cr&eacute;dito</span></a> -->

<!-- 		<ul class="sub"> -->
<%-- 				<%if(datosSesion.getPermisos().indexOf("02")>=0){%>			 --%>
<!-- 				<li><a  id="conNombre"   href="javascript:void(0)" onclick="submitsAction('frmMain0','solicitud','S',true)" ><span>Solicitud</span></a></li> -->
<%-- 				<%}%> --%>
<%-- 				<%if(datosSesion.getPermisos().indexOf("02")>=0){%>			 --%>
<!-- 				<li><a  id="conNombre"   href="javascript:void(0)" onclick="submitsAction('frmMain0','cancelacion','S',true)" ><span>Cancelaci&oacute;n</span></a></li> -->
<%-- 				<%}%> --%>
<%-- 				<%if(datosSesion.getPermisos().indexOf("02")>=0){%>			 --%>
<!-- 				<li><a  id="conNombre"   href="javascript:void(0)" onclick="submitsAction('frmMain0','poliza','S',true)" ><span>P&oacute;liza de Seguro</span></a></li> -->
<%-- 				<%}%> --%>
<!-- 		</ul> -->
<!-- 	</li> -->
<!--     <li class="top"><span class="down">&nbsp;</span></li> -->
	
<%-- <%}%> --%>

	<sec:authorize access="hasAnyRole('03')">
		<c:url var="url" value="/" />
		
		<li class="top"><a id="modInfo" href="javascript:void(0)" class="top_link"><span class="down">Consulta</span></a>

			<ul class="sub">
				
				
				
				<sec:authorize url="/consultaPM/**">
					<li>
						<a id="conNombre"   href='<c:out value="${url}"/>consultaPM/' >
							<span>Pr&eacute;stamo Multired</span>
						</a>
					</li>
				</sec:authorize>
				
				<sec:authorize url="/consultaPR/**">
					<li>
						<a id="conNombre"   href='<c:out value="${url}"/>consultaPR/' >
							<span>Pr&eacute;stamo Reprogramado</span>
						</a>
					</li>
				</sec:authorize>
				
				<sec:authorize url="/consultaImagen/**">
					<li>
						<a id="conNombre"   href='<c:out value="${url}"/>consultaImagen/' >
							<span>Consulta Parametros</span>
						</a>
					</li>
				</sec:authorize>
				
				<sec:authorize url="/actualizar/**">
					<li>
						<a id="conNombre"   href='<c:out value="${url}"/>actualizar/' >
							<span>Actualizar</span>
						</a>
					</li>
				</sec:authorize>
				
				
			</ul>
			
		</li>
	    <li class="top"><span class="down">&nbsp;</span></li>
		
	</sec:authorize>
	
	
<%--	<sec:authorize access="hasAnyRole('03')">  --%>
	<%--	<c:url var="url" value="/" />  --%>
		
	<%--	<li class="top"><a id="modInfo" href="javascript:void(0)" class="top_link"><span class="down">Administrador</span></a>  --%>

	<%--		<ul class="sub"> --%>
				
	<%--			<sec:authorize url="/administrarSeguro/**">  --%>
		<%--			<li>  --%>
		<%--				<a id="conNombre"   href='<c:out value="${url}"/>administrarSeguro/' >  --%>
		<%--					<span>Actualizar Polizas</span>  --%>
		<%--				</a>   --%>
		<%--			</li>  --%>
		<%--		</sec:authorize>   --%>
				
		<%--	</ul>   --%>
			
	<%--	</li>  --%>
	<%--    <li class="top"><span class="down">&nbsp;</span></li>   --%>
		
<%--	</sec:authorize>    --%>
	
	
	
	<sec:authorize access="hasAnyRole('06')">
		<c:url var="url" value="/" />
		
		<li class="top"><a id="modInfo" href="javascript:void(0)" class="top_link"><span class="down">Auditor&iacute;a</span></a>

			<ul class="sub">
				
				<sec:authorize url="/log/**">
					<li>
						<a id="conNombre"   href='<c:out value="${url}"/>log/' >
							<span>Log</span>
						</a>
					</li>
				</sec:authorize>
				
			</ul>
			
		</li>
	    <li class="top"><span class="down">&nbsp;</span></li>
		
	</sec:authorize>
	
	
	<sec:authorize access="hasAnyRole('07')">
		<c:url var="url" value="/" />
		
		<li class="top"><a id="modInfo" href="javascript:void(0)" class="top_link"><span class="down">Auditor&iacute;a Agencias</span></a>

			<ul class="sub">
				
				<sec:authorize url="/log/**">
					<li>
						<a id="conNombre"   href='<c:out value="${url}"/>log/' >
							<span>Log</span>
						</a>
					</li>
				</sec:authorize>
		
				 
			</ul>
			
		</li>
	    <li class="top"><span class="down">&nbsp;</span></li>
		
	</sec:authorize>
	
	<sec:authorize access="hasAnyRole('06')">
		<c:url var="url" value="/" />
		
		<li class="top"><a id="modInfo" href="javascript:void(0)" class="top_link"><span class="down">Auditor&iacute;a PM</span></a>

			<ul class="sub">
				
				 <sec:authorize url="/logPM2/**">
					<li>
						<a id="conNombre"   href='<c:out value="${url}"/>logPM2/' >
							<span>Log PM</span>
						</a>
					</li>
				</sec:authorize>
		 
				
			</ul>
			
		</li>
	    <li class="top"><span class="down">&nbsp;</span></li>
		
	</sec:authorize>

<%-- <%if(datosSesion.getPermisos().indexOf("03")>=0 ){%> --%>

<!-- 	<li class="top"><a id="modInfo" href="javascript:void(0)" class="top_link"><span class="down">Consulta</span></a> -->

<!-- 		<ul class="sub"> -->
<%-- 				<%if(datosSesion.getPermisos().indexOf("03")>=0){%>			 --%>
<!-- 				<li><a  id="conNombre"   href="javascript:void(0)" onclick="submitsAction('frmMain0','consultaTC','S',true)" ><span>Tarjeta de Cr&eacute;dito</span></a></li> -->
<%-- 				<%}%> --%>
<%-- 				<%if(datosSesion.getPermisos().indexOf("03")>=0){%>			 --%>
<!-- 				<li><a  id="conNombre"   href="javascript:void(0)" onclick="submitsAction('frmMain0','consultaPM','S',true)" ><span>Pr&eacute;stamo Multired</span></a></li> -->
<%-- 				<%}%> --%>
<%-- 				<%if(datosSesion.getPermisos().indexOf("03")>=0){%>			 --%>
<!-- 				<li><a  id="conNombre"   href="javascript:void(0)" onclick="submitsAction('frmMain0','consultaPR','S',true)" ><span>Pr&eacute;stamo Reprogramado</span></a></li> -->
<%-- 				<%}%> --%>
<!-- 		</ul> -->
<!-- 	</li> -->
<!--     <li class="top"><span class="down">&nbsp;</span></li> -->
	
<%-- <%}%> --%>


</ul>
<%-- <%} %> --%>

 
<!--   <form action="project" method="post" name="frmMain0" id="frmMain0" > -->
<!--  	<input type="hidden" name="option" id="option" value="" /> -->
<!--  </form> -->
 