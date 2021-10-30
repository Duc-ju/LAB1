<div class="left-nav">
	<div class="category">
		<h2 class="category-title">Category</h2>
		<ul class="list-category">
			<c:forEach items="${categories}" var="category">
				<li
					class="category-item <c:if test = "${category.getID()==selectedCatelogyID}">selected-category</c:if>"><a
					href="${pageContext.request.contextPath}/category?id=${category.getID()}">${category.getCategoryName() }</a></li>
			</c:forEach>
		</ul>
	</div>
</div>