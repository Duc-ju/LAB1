		<header id="header">
			
				<c:choose>
					<c:when
						test="${sessionScope.customer.getNickname().length()>10}">
						<div class="brand-name pointer">
							<i class="ti-user"> </i>
							${sessionScope.customer.getNickname().substring(0, 10)}...
						</div>
					</c:when>
					<c:when test="${(sessionScope.customer==null)}">
							
					</c:when>
					<c:otherwise>
							<div class="brand-name pointer">
								<i class="ti-user"> </i>
								${sessionScope.customer.getNickname()}
							</div>
					</c:otherwise>
				</c:choose>
			
			<div class="nav">
				<ul class="control">
					<li class="control-item <c:if test = "${direction=='home'}">actived</c:if>"><a href="${pageContext.request.contextPath}/home">Home</a></li>
					<c:if test = "${customer.getAccount().getIsAdmin()==1}">
						<li class="control-item <c:if test = "${direction=='bookmanagement'}">actived</c:if>"><a href="${pageContext.request.contextPath}/bookmanagement">Book Management</a></li>
					</c:if>
					<c:if test = "${customer==null}">
						<li class="control-item"><a href="${pageContext.request.contextPath}/login">Login</a></li>
					</c:if>
					<c:if test = "${customer!=null}">
						<li class="control-item"><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
					</c:if>
				</ul>
			</div>
			<form method="get" action="${pageContext.request.contextPath}/search" class="search">
				<input type="text" name="book_name" placeholder="Book name"
					id="search-book-name"> <input type="submit" value="Search"
					id="submit-button">
			</form>
			<c:if test = "${hiddenCart!=1}">
				<div onclick="window.open('${pageContext.request.contextPath}/cart','_self')" class="cart">
					<div class="quantity">${numberOfItems}</div>
					<i class="ti-shopping-cart cart-icon"></i>
				</div>
			</c:if>
		</header>