let subtractElements = document.querySelectorAll("#content .book-subtract");
let plusElements = document.querySelectorAll("#content .book-plus");
subtractElements.forEach(function (subtractElement) {
	subtractElement.onclick = function () {
		let quantityElement = subtractElement.parentElement.querySelector(".book-quantity");
		let quantity = parseInt(quantityElement.innerHTML);
		if (quantity == 1) {
			return;
		}
		else {
			quantityElement.innerHTML = quantity - 1;
		}
	}
})
plusElements.forEach(function (plusElement) {
	plusElement.onclick = function () {
		let quantityElement = plusElement.parentElement.querySelector(".book-quantity");
		let quantity = parseInt(quantityElement.innerHTML);
		quantityElement.innerHTML = quantity + 1;
	}
})
let addBookElements = document.querySelectorAll("#content .book-add-button")
addBookElements.forEach(function (addBookElement) {
	addBookElement.onclick = function (e) {
		let bookID = addBookElement.parentElement.parentElement.querySelector(".book-id").innerHTML;
		let bookQuantity = addBookElement.parentElement.parentElement.querySelector(".book-quantity").innerHTML;
		//Khởi tạo data
		let formData = new FormData();
		formData.append("id", bookID);
		formData.append("quantity", bookQuantity);

		//Khởi tạo object
		let xhr = new XMLHttpRequest();
		//Cài đặt thông tin request
		xhr.open("GET", `/LAB1/bookadding?id=${bookID}&quantity=${bookQuantity}`, true);
		//Thiết lập event listener
		xhr.onreadystatechange = function () {
			if (xhr.readyState == 4 && xhr.status == 200) {
				console.log(xhr.responseText);
				let quantity = document.querySelector("#header .quantity");

				if (quantity != null) {
					quantity.innerHTML = parseInt(quantity.textContent) + parseInt(bookQuantity);
				}
			}

		}
		xhr.send()
	}
})