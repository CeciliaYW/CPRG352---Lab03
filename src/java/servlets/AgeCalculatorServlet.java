package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AgeCalculatorServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/ageCalculator.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String age = request.getParameter("age_");
        String displaymessage;
        
        
        
        if (age == null || age.equals("")){
            displaymessage = "You must give your current age.";
            request.setAttribute("displayMessage",displaymessage);   
            getServletContext().getRequestDispatcher("/WEB-INF/ageCalculator.jsp").forward(request, response);
        }else {
            try {
                int agevalue = Integer.parseInt(age);
                displaymessage = "Your age next birthday will be " + ( agevalue + 1 );
                request.setAttribute("displayMessage",displaymessage);  
            }catch (NumberFormatException e){
                displaymessage = "You must enter a number.";
                request.setAttribute("displayMessage",displaymessage);
            }        
            getServletContext().getRequestDispatcher("/WEB-INF/ageCalculator.jsp").forward(request, response);
        }
    }

} 
