package com.sejal.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

public class ArithmaticoperationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            int num1 = Integer.parseInt(request.getParameter("num1"));
            int num2 = Integer.parseInt(request.getParameter("num2"));
            String operation = request.getParameter("operation");

            int result = 0;

            switch (operation) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) result = num1 / num2;
                    else {
                        response.getWriter().println("Cannot divide by zero!");
                        return;
                    }
                    break;
                default:
                    response.getWriter().println("Invalid Operation!");
                    return;
            }

            response.setContentType("text/html");
            response.getWriter().println("<h2>Result: " + result + "</h2>");

        } catch (NumberFormatException e) {
            response.getWriter().println("Invalid input. Please enter numbers only.");
        }
    }
}
