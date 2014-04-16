<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vehiculos</title>
<s:head />
<style type="text/css">
@import url(style.css);
</style>
</head>
<body>
<s:form action="saveOrUpdateVehiculo">
	<s:push value="vehiculo">
		<s:hidden name="id" />
		<s:textfield name="patente" label="Patente" />
		<s:textfield name="plazas" label="Plazas" />
		<s:submit />
	</s:push>
</s:form>

<s:if test="vehiculoList.size() > 0">
	<div class="content">
	<table class="crudTable" cellpadding="5px">
		<tr class="even">
			<th>Patente</th>
			<th>Plazas</th>
			<th>Alta</th>
			<th>Editar</th>
			<th>Borrar</th>
		</tr>
		<s:iterator value="vehiculoList" status="vehiculoStatus">
			<tr
				class="<s:if test="#vehiculoStatus.odd == true ">odd</s:if><s:else>even</s:else>">
				<td><s:property value="patente" /></td>
				<td><s:property value="plazas" /></td>
				<td><s:property value="alta" /></td>
				<td><s:url id="editURL" action="editVehiculo">
					<s:param name="id" value="%{id}"></s:param>
				</s:url> <s:a href="%{editURL}">Editar</s:a></td>
				<td><s:url id="deleteURL" action="deleteVehiculo">
					<s:param name="id" value="%{id}"></s:param>
				</s:url> <s:a href="%{deleteURL}">Borrar</s:a></td>
			</tr>
		</s:iterator>
	</table>
	</div>
</s:if>
</body>
</html>