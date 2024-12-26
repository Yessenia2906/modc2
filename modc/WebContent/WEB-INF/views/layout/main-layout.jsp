<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml2/DTD/xhtml1-strict.dtd">
<%@page import="pe.com.bn.modc.common.Util"%>
<%@page import="pe.com.bn.modc.common.Constant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

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

<title><%=Constant.VAR_GLB_COD_APLICATIVO%></title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/fontTableroPic1.css" type="text/css"></link>
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/fontTableroPic2.css" type="text/css"></link>
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/stylesTable.css" type="text/css"></link>
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/styles.css" type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/displaytag.css" type="text/css"></link>

<tag:scripts />

<script type="text/javascript">
	function endSesion() {
		document.frmAction.submit();
	}
</script>

<script type="text/javascript">

	document.onkeypress = stopKey;
</script>

<script type="text/javascript">
	window.history.forward();

	function cargaInitMain() {
		window.history.forward();
		if (typeof (window.execProcessMain) == 'function') {
			execProcessMain();
		}
	}
	
</script>


</head>
<body ondragstart="return false;" ondrop="return false;" onkeydown="return stopKey(event);" onload="cargaInitMain();">

	<c:url var="url" value="/" />
	
	<form id="frmAction" name="frmAction" method="post" action="<c:out value='${url}'/>cerrarSesion" >
		<input type="hidden" name="proceso" value="" />
	</form>
	
	<div class="rxsviewport">
		<table class="rxsviewport" style="width: 100%" cellpadding="0"
			cellspacing="0">
			<tr>
				<td>
					<table class="rxBordeMenu" style="width: 100%;" bgcolor="white">
						<tr>
							<th colspan="2"><jsp:include page="../partials/header.jsp"></jsp:include></th>
						</tr>
						<tr>
							<td style="vertical-align: text-top;" style="width: 80%;"><jsp:include
									page="../partials/menu.jsp"></jsp:include></td>

							<td style="width: 40%;" align="right">

								<div class="cysSessionbar">
									<table>
										<tr>
											<td><span class="cysUsername">Usuario:</span></td>
											<td><span>[<sec:authentication property="principal.nombre" />]
											</span></td>
											<td><span onclick="endSesion();"><img alt=""
													src="<%=request.getContextPath()%>/assets/img/icon/closeSession.jpg"
													title="" style="cursor: hand;" />
													</span></td>
										</tr>
									</table>
								</div>
							</td>

						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td valign="top" height="100%">
					<div class="rxverticalview">
						<!-- vertical view -->

						<table border="0" class="rxsview" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td>
									<!--  Interfase -->

									<table class="rxsviewport">
										<tr>
											<td valign="top">
<!-- App container --> 
<%
 String htmlfilename = "../template/"
 +(request.getAttribute("page") == null ? "bienvenida/welcome": request.getAttribute("page").toString()) 
 + ".jsp";

 %><jsp:include page="<%=htmlfilename%>" /> 
 <!-- End App container -->
											</td>
										</tr>
									</table> <!-- End Interfase -->
								</td>
								<td>&nbsp;</td>
							</tr>

						</table>

						<!-- End vertical view -->
					</div>
				</td>
			</tr>
		</table>
	</div>

<!-- 	<iframe width=196 height=189 -->
<!-- 		name="gToday:normal:assets/calendar/agenda.js" -->
<!-- 		id="gToday:normal:assets/calendar/agenda.js" -->
<%-- 		src="<%=request.getContextPath()%>/assets/calendar/normal.html" --%>
<!-- 		scrolling="no" frameborder="0" -->
<!-- 		style="visibility:visible; z-index:999; position:absolute; left:-500px; top:0px;"> -->
<!-- 	</iframe> -->

</body>
</html>