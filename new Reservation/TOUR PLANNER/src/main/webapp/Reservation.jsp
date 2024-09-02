<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Reservation Page</title>
<link rel="stylesheet" href="CSS/header.css">
<link rel="stylesheet" href="CSS/footer.css">
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}rxr

body {
	font-family: sans-serif;
}

h1 {X
	font-size: 2rem;
	font-weight: 700;
	text-align: center;
}

label {
	font-size: 1rem;
	font-weight: 500;
}

input, textarea {
	font-size: 1rem;
	font-weight: 400;
}

form {
	max-width: 1000px;
	margin: 0 auto;
	padding: 1rem;
}

label, input, textarea {
	display: block;
	width: 100%;
	margin-bottom: 1rem;
}

input, textarea {
	padding: 0.5rem;
	border: 1px solid #ccc;
	border-radius: 0.25rem;
}

textarea {
	height: 5rem;
}

input[type="submit"] {
	background-color: #007bff;
	color: #fff;
	border: none;
	border-radius: 0.25rem;
	cursor: pointer;
}

body {
	background-color: #58DC9C;
}

h1 {
	color: #333;
}

input::placeholder,
textarea::placeholder {
    color: #999;
    font-weight: 300;
}

label {
	color: #424141;
}

input, textarea {
	color: #333;
}

input[type="submit"] {
	transition: all 0.2s ease-in-out;
}

input[type="submit"]:hover {
	background-color: #04376a;
}
</style>
</head>
<body>
<%@ include file="header.jsp" %>
<%@ include file="navigation.jsp" %>
<br>
<br>

	<h1>ENTER  RESERVATION  DETAILS</h1>
	<form id="reservationForm" action="ReservationServlet" method="post">
		
		<label for="name">Customer Name:</label> 
		<input type="text" id="name"placeholder="Your name" autocomplete="off" name="name" pattern="[A-Za-z\s]+" minlength="2" maxlength="50" required>
		 
		
		<label for="location" style="color: blue;">Location:</label>
        <select id="location" name="location" style="width:150px;height:26px">
            <option value="matara" selected>Matara</option>
            <option value="galle">Galle</option>
           <option value="yapanaya">Yapanaya</option>
            <option value="polonnaruwa">Polonnaruwa</option>
            <option value="anuradhapuraya">Anuradhapuraya</option>
        </select>
        
        <br>
        <br>
        <br>
        
		
		<label for="checkindate" style="color: blue;">Check in date:</label>
        <input type="date" id="checkindate"placeholder="Check in date" autocomplete="off" min="2024-05-16" max="2024-12-31" name="checkindate" required>
        <br>
        <br>
        <br>
        
        <label for="checkoutday" style="color: blue;">Check out date:</label>
        <input type="date" id="checkoutdate"placeholder="Check out date:" autocomplete="off" min="2024-05-16" max="2024-12-31" name="checkoutdate" required>
        <br>
		<br>
        <br>
        
		<label for="email">Email:</label>
		<input type="email" id="email" placeholder="abc@gmail.com" autocomplete="off" name="email" required>

		<label for="phone">Phone:</label>
		<input type="text" id="phone" placeholder="07XXXXXXXX" pattern='[0-9]{10}' autocomplete="off" name="phone" required> 
		
		<label for="message">Additional Details:</label>
		<textarea id="message" placeholder="AC or Non AC/ room Type" autocomplete="off" name="otherD"></textarea>
		
		<div style="color: red;">User Confirmation :</div>
		<br>
		Username :<input type="text" name="username" autocomplete="off" placeholder="Enter your username" required>
		Password :<input type="password" name="password" autocomplete="off" placeholder="Enter your password" required>

		<input type="submit" name="submit" value="SUBMIT">
		
	</form>
	
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	
	<%@ include file="footer.jsp" %>
</body>
</html>
