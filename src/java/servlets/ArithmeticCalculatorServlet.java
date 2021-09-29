package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ArithmeticCalculatorServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String displaymessage = "---";
        request.setAttribute("displayMessage",displaymessage);
        
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String first_number = request.getParameter("first_number");
        String second_number = request.getParameter("second_number");
        request.setAttribute("firstNumber",first_number);
        request.setAttribute("secondNumber",second_number);
        
        String arithmetic = request.getParameter("arithmetic");
        String displaymessage = "";
        request.setAttribute("displayMessage",displaymessage);   

        int result;
        
        if ((first_number == null || first_number.equals("")) && (second_number == null || second_number.equals(""))){
            displaymessage = "---";
            request.setAttribute("displayMessage",displaymessage);
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
        } else if ( first_number == null || first_number.equals("") || second_number == null || second_number.equals("")){
            displaymessage = "invalid";
            request.setAttribute("displayMessage",displaymessage);
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
        } else {
            try {
                int first = Integer.parseInt(first_number);
                int last = Integer.parseInt(second_number);
                switch(arithmetic){
                case "plus":
                    result = first + last;
                    displaymessage = Integer.toString(result);
                    request.setAttribute("displayMessage",displaymessage);
                    break;    

                case "minus":
                    result = first - last;
                    displaymessage = Integer.toString(result);
                    request.setAttribute("displayMessage",displaymessage);
                    break;

                case "multiply":
                    result = first * last;
                    displaymessage = Integer.toString(result);
                    request.setAttribute("displayMessage",displaymessage);
                    break;

                case "remainder":
                    result = first % last;
                    displaymessage = Integer.toString(result);
                    request.setAttribute("displayMessage",displaymessage);
                    break;
            }
            }catch (NumberFormatException e){
                displaymessage = "invalid";
                request.setAttribute("displayMessage",displaymessage); 
            }
        }

        
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
    }

}
