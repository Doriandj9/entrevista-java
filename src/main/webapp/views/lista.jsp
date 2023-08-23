<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/css/main.css"  rel="stylesheet" type="text/css" >
<title>Lista de productos</title>
</head>
<body>
<%@page import="models.*" %>
<%@page import="controllers.products" %>
<header class="header">
		
		<div class="logo">
			<span>SIDE</span>
			<span>SOFT</span>
		</div>	
		 
		 <nav class="nav">
		 	<ul>
		 		<li> <a href="products"> Productos </a> </li>
		 	</ul>
		 </nav>
	</header>
<% Product data = (Product) request.getAttribute("data");  %>
<main class="main">
<div>
<strong>Cantidad total de registros: </strong> <span> <%= data.getTotalRows() %> </span>
</div>
<section class="gruop">
<strong>Cantidad total de productos diferentes en el stock:</strong> 
	<% for(Map.Entry<String, Integer> group : data.getCountProductsDifferent().entrySet() ) {%>
<div>
		<% String key = group.getKey();  %>
		<% Integer value = group.getValue();  %>
		<strong> <%= key %> </strong>
		 <span> <%= value.toString() %> </span>
</div>
	<%} %>
</section>


<h2> Productos de SIDESOFT</h2>
<form action="products" method="GET">
	<select name="filter">
		<option value="" selected> Selecione un opción </option>
		<option value="uOM$_identifier" > Productos por "UNIDAD" </option>
		<option value="stock"> Productos en Stock </option>
	</select>
	<button> Filtrar </button>
</form>
<table>
	<thead>
		<tr>
			<th>ID del registro en el stock </th>
			<th>ID del producto </th>
			<th>Nombre del producto </th>
			<th>ID de la ubicación en el almacén </th>
			<th>Nombre de la ubicación en el almacén </th>
			<th>ID del número de serie </th>
			<th>Número de serie </th>
			<th>ID de la unidad de medida </th>
			<th>Nombre de la unidad de medida </th>
			<th>Cantidad disponible </th>
		</tr>
	 </thead>
	 
	 <tbody>
	 	<% for(DataProducts product: data.getDataProducts()){ %>
	 		<tr>
	 			<td> <%= product.getId().toString() %> </td>
	 			<td> <%= product.getProduct().toString() %> </td>
	 			<td> <%= product.getProduct$_identifier() %> </td>
	 			<td> <%= product.getStorageBin() %> </td>
	 			<td> <%= product.getStorageBin$_identifier() %> </td>
	 			<td> <%= product.getAttributeSetValue() %> </td>
	 			<td> <%= product.getAttributeSetValue$_identifier() %> </td>
	 			<td> <%= product.getuOM() %> </td>
	 			<td> <%= product.getuOM$_identifier() %> </td>
	 			<td> <%= Integer.toString(product.getQuantityOnHand()) %> </td>
	 		</tr>
	 	<%} %>
	 </tbody>
</table>

</main>

</body>
</html>