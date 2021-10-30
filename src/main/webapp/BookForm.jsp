<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Đức Ju</title>
	<link rel="stylesheet" href="assets/css/style.css">
	<link rel="stylesheet" href="assets/project/addbookform/style.css">
	<link rel="stylesheet" href="assets/css/respondsive.css">
	<link rel="stylesheet" href="assets/project/addbookform/respondsive.css">
	<link rel="stylesheet" href="assets/font/themify-icons/themify-icons.css">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Azeret+Mono:wght@600&family=Roboto+Slab:wght@700&display=swap"
		rel="stylesheet">
</head>

<body>
	<div id="main">
	<%@include file="Header.jsp" %>
		<div id="book-form">
			<div class="form-container">
				<div class="book-form">
					<h2 class="form-title">
						<c:if test="${book != null}">
            				Edit Book
            			</c:if>
						<c:if test="${book == null}">
            				Add New Book
            			</c:if>
					</h2>
					<c:if test="${book != null}">
						<form action="${pageContext.request.contextPath}/update-book?id=${book.getID()}" method="post">
					</c:if>
					<c:if test="${book == null}">
						<form action="${pageContext.request.contextPath}/add-book" method="post">
					</c:if>
					<div class="input-container">
						<div class="form-label">
							<div class="label">Title</div>
							<div class="label">Image</div>
							<div class="label">Description</div>
							<div class="label">Author</div>
							<div class="label">Price</div>
							<div class="label">Quantity</div>
						</div>
						<div class="form-input">
							<input type="text" name="title"
								value="<c:if test="${book != null}">${book.getTitle()}</c:if>"
								required placeholder="Title"> <input type="text"
								name="image"
								value="<c:if test="${book != null}">${book.getImage()}</c:if>"
								required placeholder="Image"> <input type="text"
								name="description"
								value="<c:if test="${book != null}">${book.getDescription()}</c:if>"
								required placeholder="Description"> <input type="text"
								name="author"
								value="<c:if test="${book != null}">${book.getAuthor()}</c:if>"
								required placeholder="Author"> <input type="text"
								name="price"
								value="<c:if test="${book != null}">${book.getPrice()}</c:if>"
								required placeholder="Price"> <input type="text"
								name="quantity"
								value="<c:if test="${book != null}">${book.getAvaiableQuantity()}</c:if>"
								required placeholder="Quantity">
						</div>
					</div>
					<div class="category-list">
							<h3 class="choose-category">Choose category</h3>
							<select name="category" id="category">
								<c:forEach items="${categories}" var="category">
									<option value="${category.getID()}" <c:if test="${book.getCategory().getID()==category.getID()}">selected</c:if>>${category.getCategoryName()}</option>
								</c:forEach>
							</select>
						</div>
						<div class="button-container">
							<input type="submit" value="Submit" class="book-submit">
						</div>
					</form>
				</div>
			</div>
		</div>

		<div id="footer">
			<div class="about">
				<p class="author-name">Author : Nguyen Trang Duc</p>
				<p class="author-identity">Student-identity : B18DCCN177</p>
				<p class="author-last-update">Lastest update : 9/6/2021 at 12:55PM</p>
				<p class="author-contact">Contact me <a href="https://www.facebook.com/trangducc/"
						class="contact-icon"><i class="ti-facebook"></i></a></p>
			</div>
		</div>
	</div>
	<c:if test="${notice!=null}">
		<div id="modal" class="modal display">
			<div class="modal-container">
				<div class="modal-notice">
					<h2 class="notice-title">${notice}</h2>
					<div class="modal-confirm">
						<a onclick="cancelAllModal()" class="modal-yes">OK</a>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	<script src="assets/js/script.js"></script>
</body>

</html>