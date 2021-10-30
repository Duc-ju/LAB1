<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Đức Ju</title>
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet" href="assets/project/cart/style.css">
<link rel="stylesheet" href="assets/css/respondsive.css">
<link rel="stylesheet" href="assets/project/cart/respondsive.css">
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
		<div id="content">
			<div class="empty-cart">
				<h2 class="empty-cart-notice">Cart is empty</h2>
				<a href="${pageContext.request.contextPath}/home" class="go-home-button">Go home</a>
			</div>
			<div class="cart-container">
				<div class="sub-nav">
					<div class="sub-nav-title">
						<h2 class="content-title">Cart and order</h2>
					</div>
					<div class="sub-nav-price">Prices</div>
					<div class="sub-nav-quantity">Quantity</div>
					<div class="sub-nav-amount">Amount</div>
					<div class="sub-nav-action">Action</div>
				</div>
				<div id="cart-id" style="display: none">${cart.getID()}</div>

				<c:forEach items="${cart.getBookItemList()}" var="bookItem">
					<div class="book-item">
						<div class="book-image">
							<img src="${bookItem.getBook().getImage()}"
								alt="Book-image" class="book-image-item">
						</div>
						<div class="book-properties">
							<div class="book-title">${bookItem.getBook().getTitle()}</div>
							<div class="book-author">Author: ${bookItem.getBook().getAuthor()}</div>
						</div>
						<div class="book-price">${bookItem.getBook().getPrice()}$</div>
						<div class="book-quantity">
							<div class="book-update">
								<div onclick="window.open('${pageContext.request.contextPath}/bookitemcontrol?id=${bookItem.getID()}&action=decrease','_self')"
									class="book-subtract pointer">-</div>
								<div class="book-number-quantity">${bookItem.getQuantity() }</div>
								<div onclick="window.open('${pageContext.request.contextPath}/bookitemcontrol?id=${bookItem.getID()}&action=increase','_self')" class="book-plus pointer">+</div>
							</div>
						</div>
						<div class="book-total">
							<div class="book-total-cost"><fmt:formatNumber type="number" pattern="0.00" value="${bookItem.getBookItemCost()}"/>$</div>
						</div>
						<div class="book-action">
							<a class="book-delete-button" href="${pageContext.request.contextPath}/deletebookitem?id=${bookItem.getID()}">Delete</a>
						</div>
					</div>
				</c:forEach>
				
				
				<div class="cart-control">
					<div class="cart-order">
						<div class="cart-total-price">Total price (${cart.getNumberOfItems()} items): <fmt:formatNumber type="number" pattern="0.00" value="${cart.getBooksCost()}"/>$</div>
						<div class="cart-order-button pointer">Order</div>
					</div>
				</div>
			</div>
			<div class="order-container">
				<div class="choose-address">
					<h3 class="choose-address-title">Please choose your address</h3>
					
					<c:forEach items="${sessionScope.customer.getAddressList()}" var="address">
						<div class="user-address">
							<div class="addressid" style="display: none">${address.getID()}</div>
							<div class="address-fullname">Full name: ${address.getFullName() }</div>
							<div class="address-phonenumber">Phone number: ${address.getPhoneNumber() }</div>
							<div class="address-fulladdress">Address: ${address.getFullAddress()}</div>
						</div>
					</c:forEach>	
					
					
					<div class="address-add">
						<a href="" class="address-add-button">Add new address</a>
					</div>
				</div>
				<div class="choose-payment-method">
					<h3 class="payment-title">Please choose a payment method</h3>
					
					<c:forEach items="${payments}" var="payment">
						<div class="payment-item">
							<div class="payment-id" style="display: none">${payment.getID()}</div>
							<div class="payment-method">${payment.getMethod()}</div>
						</div>
					</c:forEach>
					
				</div>
				<div class="order-control">
					<div class="order-info">
						<div class="order-total-price">Total price (${cart.getNumberOfItems()} items): <fmt:formatNumber type="number" pattern="0.00" value="${cart.getBooksCost()}"/>$</div>
						<div class="order-ship-fee">Shipping fee: 2$</div>
						<div class="order-total-payment">Total payment: <fmt:formatNumber type="number" pattern="0.00" value="${cart.getBooksCost()+2}"/>$</div>
						<div class="order-button pointer">Confirm order</div>
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
		<div id="modal" class="modal">
			<div class="modal-container">
				<div class="modal-notice">
					<h2 class="notice-title">You have added book successfully</h2>
					<div class="modal-confirm">
						<a class="modal-cancel" onclick="cancelAllModal()"
							style="cursor: pointer">OK</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="assets/js/script.js"></script>
	<script src="assets/project/cart/script.js"></script>
</body>

</html>