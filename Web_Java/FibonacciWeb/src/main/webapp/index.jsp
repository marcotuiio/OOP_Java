<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Fibonacci WebApplication</title>
</head>
<body>
<h1 style="text-align: center" >
    <%= "Input the desired position of Fibonacci sequence" %>
</h1>
<br/>
    <form style="text-align:center" action="fibonacci-servlet">
        <label for="position">Position:</label><br><br>
        <input type="text" id="position" name="position" value="0"><br><br>
        <input type="submit" value="Get value in position">
    </form>
</body>
</html>