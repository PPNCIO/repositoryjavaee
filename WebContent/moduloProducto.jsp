<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FormAlta</title>
</head>
<s:head />
<sx:head />
<body>
	
<sx:tabbedpanel id="formAlta"> 
		<sx:div label="MODULO PRODUCTO">
			<s:form action="alta.action" method="post">
			<s:push value="producto">
			    <s:hidden key="id" />
				<s:select name="nombre" label="NOMBRE" list="#{'Mouse':'MOUSE','Teclado':'TECLADO','Monitor':'MONITOR','Torre':'TORRE'}" headerKey="1" headerValue="SeleccionaProducto" />
				<s:textfield key="precio" label="PRECIO" />
				<s:textarea key="descripcion" label="DESCRIPCION" />
				<s:submit value="Aceptar" />
			</s:push>
			</s:form>
			
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">NOMBRE</th>
						<th scope="col">PRECIO</th>
						<th scope="col">DESCRIPCION</th>
						<th scope="col">DELETE</th>
						<th scope="col">EDIT</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="listProductos">
						<tr>
							<th scope="row"><s:property value="id" /></th>
							<th><s:property value="nombre" /></th>
							<th><s:property value="precio" /></th>
							<th><s:property value="descripcion" /></th>
							<th>
							<s:url id="deleteURL" action="baja">
								<s:param name="id" value="%{id}" />	
							</s:url>
							<s:a href="%{deleteURL}">Delete</s:a>
							</th>
							<th>
							<s:url id="editURL" action="editar">
								<s:param name="id" value="%{id}" />	
							</s:url>
							<s:a href="%{editURL}">Edit</s:a>
							</th>
						</tr>
					</s:iterator>
				</tbody>
			</table>	
		</sx:div>
	</sx:tabbedpanel>
</body>
</html> 