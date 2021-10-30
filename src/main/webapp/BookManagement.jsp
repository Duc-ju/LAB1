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
	<link rel="stylesheet" href="assets/project/bookmanagement/style.css">
	<link rel="stylesheet" href="assets/css/respondsive.css">
	<link rel="stylesheet" href="assets/project/bookmanagement/respondsive.css">
	<link rel="stylesheet" href="assets/font/themify-icons/themify-icons.css">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Azeret+Mono:wght@600&family=Roboto+Slab:wght@700&display=swap"
		rel="stylesheet">
</head>

<body>
	<div id="main">
		<%@include file="Header.jsp" %>
		<div id="slider">
			<div class="slider-item"><img src="assets/photo/bookstore.jpg" alt="" class="slider-item-img">
			</div>
		</div>
		<div id="content">
			<div class="container">
				<%@include file="CategoryList.jsp" %>
				<div class="product">
					<div class="row">
						<div class="row-control">
							<h2 class="row-title">List of books</h2>
							<div class="delete-all"><a onclick="showConfirmationAll()"
									style="cursor: pointer">Hidden all books <i
										class="ti-trash"></i></a></div>
							<div class="add-book"><a href="${pageContext.request.contextPath}/add-book">Add a new book <i
										class="ti-plus"></i></a></div>
						</div>
						<c:forEach items="${books}" var="book">
							<div class="book-item <c:if test = "${book.getAvaiableQuantity()==0}">hidden-book</c:if>">
								<div class="book-image">
									<img src="${book.getImage()}" alt="book image">
								</div>
								<div class="book-content">
									<h3 class="book-title">${book.getTitle()}</h3>
									<p class="book-author">Author: ${book.getAuthor()}</p>
									<p class="book-desciption">Description:
										${book.getDescription()}</p>
									<p class="book-price">Price: ${book.getPrice()}</p>
									<p class="book-avaiable-quatity">Quantity:
										${book.getAvaiableQuantity()}</p>
									<p class="book-category">Category:
										${book.getCategory().getCategoryName()}</p>
									<div class="book-control">
										<div class="book-update">
											<a href="${pageContext.request.contextPath}/update-book?id=${book.getID()}">Update information</a>
										</div>
										<c:if test = "${book.getAvaiableQuantity()>0}">
											<div class="book-delete">
												<a style="cursor: pointer" class="book-delete-button">Hidden
													book</a>
												<div class="delete-book-modal modal">
													<div class="modal-container">
														<div class="modal-notice">
															<h2 class="notice-title">Do you confirm to hidden
																this book?</h2>
															<div class="modal-confirm">
																<a href="${pageContext.request.contextPath}/hidden-book?id=${book.getID()}" class="modal-yes">Yes</a> <a
																	class="modal-cancel" style="cursor: pointer">Cancel</a>
															</div>
														</div>
													</div>
												</div>
											</div>
										</c:if>
									</div>

								</div>
							</div>
						</c:forEach>
						

					</div>

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
		<div class="modal" id="modal">
			<div class="modal-container">
				<div class="modal-notice">
					<h2 class="notice-title">Do you confirm to hidden all of your books?</h2>
					<div class="modal-confirm">
						<a href="${pageContext.request.contextPath}/hidden-all-book" class="modal-yes">Yes</a>
						<a class="modal-cancel" onclick="cancelAllModal()"
							style="cursor: pointer">Cancel</a>
					</div>
				</div>
			</div>
		</div>


	</div>

	<script src="assets/js/script.js"></script>
</body>

</html>