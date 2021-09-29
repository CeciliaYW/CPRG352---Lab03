<%-- 
    Document   : arithmeticcalculator
    Created on : 23-Sep-2021, 3:23:15 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arithmetic Calculator</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>
        <form method="POST" action="arithmetic">
            <label>First: </label>
            <input type="text" name="first_number" value="${firstNumber}">
            <br>
            <label>Second: </label>
            <input type="text" name="second_number" value="${secondNumber}">
            <br>
            <button type="submit" name="arithmetic" value="plus">+</button>
            <button type="submit" name="arithmetic" value="minus">-</button>
            <button type="submit" name="arithmetic" value="multiply">*</button>
            <button type="submit" name="arithmetic" value="remainder">%</button>
        </form>
        <br>
        Result: ${displayMessage}
        <br>
        <a href="age">Age Calculator</a>
    </body>
</html>
