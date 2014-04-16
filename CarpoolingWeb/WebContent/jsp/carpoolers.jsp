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
<s:form action="saveOrUpdateCarpooler">
	<s:push value="carpooler">
		<s:hidden name="id" />
		<s:textfield name="nombre" label="Nombre" />
		<s:textfield name="dni" label="Dni" />
		<s:textfield name="telefono" label="Telefono" />
		<s:submit />
	</s:push>
</s:form>

<s:if test="carpoolerList.size() > 0">
	<div class="content">
	<table class="crudTable" cellpadding="5px">
		<tr class="even">
			<th>Nombre</th>
			<th>Dni</th>
			<th>Telefono</th>
			<th>Editar</th>
			<th>Borrar</th>
		</tr>
		<s:iterator value="carpoolerList" status="carpoolerStatus">
			<tr
				class="<s:if test="#carpoolerStatus.odd == true ">odd</s:if><s:else>even</s:else>">
				<td><s:property value="nombre" /></td>
				<td><s:property value="dni" /></td>
				<td><s:property value="telefono" /></td>
				<td><s:url id="editURL" action="editCarpooler">
					<s:param name="id" value="%{id}"></s:param>
				</s:url> <s:a href="%{editURL}">Editar</s:a></td>
				<td><s:url id="deleteURL" action="deleteCarpooler">
					<s:param name="id" value="%{id}"></s:param>
				</s:url> <s:a href="%{deleteURL}">Borrar</s:a></td>
			</tr>
		</s:iterator>
	</table>
	</div>
</s:if>
</body>
</html>