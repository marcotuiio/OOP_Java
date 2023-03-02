package com.example.fibonacciweb;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "FibonacciServlet", value = "/fibonacci-servlet")
public class FibonacciTest extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int i, aux1, aux2, def;
        aux1 = 1;
        aux2 = 0;
        int n = Integer.parseInt(request.getParameter("position"));
        if (n == 1) {
            def = aux2;
        } else if (n == 2) {
            def = aux1;
        } else {
            for(i = 1; i <= (n-2); i++) {
                aux1 = aux1 + aux2;
                aux2 = aux1 - aux2;
            }
            def = aux1;
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1 style=\"text-align:center\" >Position " + n + " : " + def + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}