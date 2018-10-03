<%@include file="commons/header.jspf"%>
<%@include file="commons/navigation.jspf"%>
<div class="container">
	<table class="table table-striped">
		<caption>Products</caption>
		<thead>
			<tr>
				<th>Name</th>
				<th>Model</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${products}" var="product">
				<tr>
					<td>${product.name}</td>
					<td>${product.model}</td>
					<td>${product.price}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</div>
<%@include file="commons/footer.jspf"%>