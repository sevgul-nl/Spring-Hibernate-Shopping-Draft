
<p class="lead">Shop Name</p>
<div class="list-group">
	<c:forEach items="${categories}" var="cat">
		<a id="a_${cat.category}" href="${contextRoot}/category/${cat.id}/products" class="list-group-item">${cat.category}</a>
	</c:forEach>
</div>
