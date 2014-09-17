<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Carpoolers</title>
<s:head />
<style type="text/css">
@import url(style.css);
</style>
</head>
<body>

<%
HttpSession objSesion = request.getSession(true);
String user = "USUARIO_X"; //aqui tu identificador de usuario
objSesion.setAttribute("usuario", user );
out.println("Poniendo usuario en sesion ...");
%>
<s:if test="pmethods.size() > 0">
	<div class="content">
	<table class="crudTable" cellpadding="5px">
		<tr class="even">

			<th>
				<s:url id="sortByNameURL" action="sortBy">
					<s:param name="column">byName</s:param>
				</s:url> 
				<s:a href="%{sortByNameURL}">Name</s:a>
			</th>

			<th>Md5</th>
			<th>Body</th>
			<th>Lines</th>

			<th>
				<s:url id="sortByNameURL" action="sortBy">
					<s:param name="column">byLine</s:param>
				</s:url> 
				<s:a href="%{sortByNameURL}">nLines</s:a>
			</th>

			<th>complexity</th>
			<th>Editar</th>
			<th>Borrar</th>
		</tr>
		<s:iterator value="pmethods" status="pmethodStatus">
			<tr
				class="<s:if test="#pmethodStatus.odd == true ">odd</s:if><s:else>even</s:else>">
				<td><s:property value="name" /></td>
				<td><s:property value="md5" /></td>
				<td><s:property value="body" /></td>
				<td><s:property value="lines" /></td>
				<td><s:url id="editURL" action="editPUnit">
					<s:param name="id" value="%{id}"></s:param>
				</s:url> <s:a href="%{editURL}">Editar</s:a></td>
				<td><s:url id="deleteURL" action="deletePUnit">
					<s:param name="id" value="%{id}"></s:param>
				</s:url> <s:a href="%{deleteURL}">Borrar</s:a></td>
			</tr>
		</s:iterator>
	</table>
	</div>
</s:if>
</body>
</html>