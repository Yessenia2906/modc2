<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="pe.com.bn.modc.common.Util"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", " no-store ");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
<head>

<base href="<%=basePath%>">
<title></title>

<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Cache-Control" content="max-age=0" />
<meta http-equiv="Expires" content="0" />

<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/fontTableroPic1.css" type="text/css"></link>
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/fontTableroPic2.css" type="text/css"></link>
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/stylesTable.css" type="text/css"></link>
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/styles.css" type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/displaytag.css" type="text/css"></link>

<tag:scripts />


</head>
<body style="background-color: white;">
	<table width="100%" border="0">
		<tr>
			<td><img alt=""
				src="<%=request.getContextPath()%>/assets/img/header/banner_r5.gif">
			</td>
		</tr>
		<tr>
			<td class="clsTd8"></td>
		</tr>
	</table>
	<form id="form1" name="form1" method="post" action="" target="_top">
		<table width="600" align="center" border="0" cellspacing="0"
			cellpadding="0">
			<tr>
				<td>
					<div class="clslblDetError">
						<h3>
							<b><u><div
										onclick="verMensajeError('divMensajeErrorMarco');">Error
										en la aplicaci�n</div></u></b>
						</h3>
						<br /> Se ha generado un error en el programa, consulte al
						administrador del sistema <br /> <br />
						<hr size="0" />
						<br />
						<div id="divMensajeErrorMarco"
							style="display: none; visibility: hidden;">
							<div id="idExcepcion" class="clsExcepcion" caption="Error"
								closed=true>
								<%
									if (exception != null) {
								%>
								Message: <%=exception.getMessage()%>
								<%
									}
								%>
							</div>
							<div id="idStackTrace" class="clsExcepcion"
								caption="Pila de Errores" closed=true>
								<%
									if (exception != null) {
								%>
								Trace: <%=Util.exceptionToString(exception)%>
								<%
									}
								%>
							</div>
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td align="center"><br /> <INPUT id=btnIniciar type="button"
					onclick="javascript:document.location.href='login'"
					value="Iniciar Sesi�n" name=btnIniciar></td>
			</tr>
		</table>
	</form>
</body>
</html>
