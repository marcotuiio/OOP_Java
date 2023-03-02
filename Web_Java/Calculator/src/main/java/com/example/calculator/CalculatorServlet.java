package com.example.calculator;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "CalculatorServlet", value = "/calculator-servlet")
public class CalculatorServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String op1 = request.getParameter("operand1");
        String op2 = request.getParameter("operand2");
        String operator = request.getParameter("operator");

        int result;

        switch (operator) {
            case "add":
                result = Integer.parseInt(op1) + Integer.parseInt(op2);
                break;
            case "sub":
                result = Integer.parseInt(op1) - Integer.parseInt(op2);
                break;
            case "multi":
                result = Integer.parseInt(op1) * Integer.parseInt(op2);
                break;
            case "div":
                result = Integer.parseInt(op1) / Integer.parseInt(op2);
                break;
            default:
                result = 0;
                break;
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "The result of " + op1 + " " + operator + " " + op2 + " is equal to " + result + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}