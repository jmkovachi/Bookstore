<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags/"%>
<c:set var="username" value="${book.username}" />
<c:set var="book" value="${book.book}" />
<head>
    <tags:dependency />
    <script type="text/javascript" src="/js/catalog.js"></script>
</head>
<body>
    <tags:nav username="${username}"/>
    <br/>
    <br/>
    <br/>
	<div class="row">
		<div class =  "pl-5 col-md-4"><img src=${book.imageUrl}></div>
		<div class = "col">
			<div class = "col-md-5 h2">${book.title}</div>
			<br/>
			<div class = "col-md-5 h4">${book.author}</div>
			<br/>
			<div class = "col-md-5">ISBN: ${book.isbn}</div>
			<br/>
			<div class = "col-md-5">Category: ${book.category}</div>
			<br/>
			<div class = "col-md-5">Price: $${book.price}</div>
			<br/>
			<div class = "col-md-5">${book.summary}</div>
		</div>
	</div>
    <br/>
    <br/>
    <c:if test="${not empty username}">
        <center><a href="/reserve/view" class = "btn btn-primary">Reserve Book</a><button type="button" class="btn btn-primary cart" data-username="${username}" data-isbn="${book.isbn}">Add to Cart</button></center>
    </c:if>
    <!--Footer-->
    <tags:footer />
    <!--/.Footer-->
</body>
</html>