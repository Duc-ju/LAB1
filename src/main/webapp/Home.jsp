<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home</title>
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet" href="assets/project/homepage/style.css">
<link rel="stylesheet" href="assets/css/respondsive.css">
<link rel="stylesheet" href="assets/project/homepage/respondsive.css">
<link rel="stylesheet"
	href="assets/font/themify-icons/themify-icons.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Azeret+Mono:wght@600&family=Roboto+Slab:wght@700&display=swap"
	rel="stylesheet">
</head>

<body>
	<div id="main">
		<%@include file="Header.jsp" %>
		<div id="slider">
			<div class="slider-item">
				<img src="assets/photo/bookstore.jpg" alt="" class="slider-item-img">
			</div>
		</div>

		<div id="content">
			<div class="container">
				<%@include file="CategoryList.jsp" %>

				<div class="product">
					<div class="row">
						<div class="row-control">
							<h2 class="row-title">List of books</h2>
							<div class="filter-book">
								<a style="cursor: pointer;">Filter <i class="ti-filter"></i></a>
								<div class="sort-selection">
									<div class="sort-selection-container">
										<div class="sort-increase pointer"
											onclick="window.open('#','_self')">
											Price increase <i class="ti-stats-up"></i>
										</div>
										<div class="sort-decrease pointer"
											onclick="window.open('#','_self')">
											Price decrease <i class="ti-stats-down"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
						<c:forEach items="${books}" var="book">
							<div class="book-item">
								<div class="book-image">
									<img src="${book.getImage()}" alt="">
								</div>
								<div class="book-content">
									<h3 class="book-title">${book.getTitle()}</h3>
									<p class="book-author">Author: ${book.getAuthor()}</p>
									<p class="book-desciption">Description:
										${book.getDescription()}</p>
									<p class="book-price">Price: ${book.getPrice()}$</p>
									<p class="book-avaiable-quatity">Quantity:
										${book.getAvaiableQuantity() }</p>
									<p class="book-category">Category: ${book.getCategory().getCategoryName()}</p>
									<div class="book-control">
										<p class="book-id" style="display: none">${book.getID()}</p>
										<div class="book-update">
											<div class="book-subtract pointer">-</div>
											<div class="book-quantity">1</div>
											<div class="book-plus pointer">+</div>
										</div>
										<div class="book-add">
											<a class="book-add-button pointer">Add to cart</a>
										</div>
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
				<p class="author-last-update">Lastest update : 9/6/2021 at
					12:55PM</p>
				<p class="author-contact">
					Contact me <a href="https://www.facebook.com/trangducc/"
						class="contact-icon"><i class="ti-facebook"></i></a>
				</p>
			</div>
		</div>
	</div>
	<script src="assets/js/script.js"></script>
	<script src="assets/project/homepage/script.js"></script>
</body>

</html>