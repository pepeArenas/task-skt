<%@include file="commons/header.jspf"%>
<%@include file="commons/navigation.jspf"%>
<div class="container">
	<form:form method="post" commandName="product">
		<fieldset class="form-group">
			<form:label path="name">Name:</form:label>
			<form:input path="name" type="text" class="form-control"
				required="required" />
				<form:label path="name">Model:</form:label>
			<form:input path="model" type="text" class="form-control"
				required="required" />
				<form:label path="name">Price:</form:label>
			<form:input path="price" type="text" class="form-control"
				required="required" />
			<form:errors path="name" cssClass="text-warning"></form:errors>
		</fieldset>
		<button class="btn btn-success" type="submit">Add</button>

	</form:form>
</div>
<%@include file="commons/footer.jspf"%>