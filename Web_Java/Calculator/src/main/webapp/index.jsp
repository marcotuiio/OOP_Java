<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Calculator Ultra HighTech</title>
</head>
    <body>
    <h1>
        <%= "Calculator V1.0.1" %>
    </h1>
        <br/>
        <form action="calculator-servlet">
            <label for="operand1">Operand 1:</label><br>
            <input type="text" id="operand1" name="operand1" value="0"><br>
            <label for="operand2">Operand 2:</label><br>
            <input type="text" id="operand2" name="operand2" value="0"><br>
            <label for="operator"></label><select name="operator" id="operator">
                <option value="add">+</option>
                <option value="sub">-</option>
                <option value="multi">*</option>
                <option value="div">/</option>
            </select>
            <input type="submit" value="Calculate">
        </form>
    </body>
</html>