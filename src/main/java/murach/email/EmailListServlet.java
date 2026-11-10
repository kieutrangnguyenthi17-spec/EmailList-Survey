package murach.email;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import murach.business.Survey;
import murach.business.User;

public class EmailListServlet extends HttpServlet  {

    @Override
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException {

        String url = "/index.html";

        // get current action - không cho qua controller nếu không qua index.html
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }
        // perform action and set URL to appropriate page
        if (action.equals("join")) {
            url = "/index.html";    // the "join" page
        }
        else if (action.equals("add")) {                
            // get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String dob = request.getParameter("dob");
            
            String source = request.getParameter("source");
            boolean announcements=request.getParameter("announcements") !=null;
            boolean specialOffers=request.getParameter("specialOffers") !=null;
            String contactVia=request.getParameter("contactVia");

            // store data in User object and save User object in db
            User user = new User(firstName, lastName, email, dob);
            Survey survey = new Survey(source, announcements, specialOffers, contactVia);

            // set User object in request object and set URL - Lưu cấu trúc của đối tượng vào request dưới tên "user"
            request.setAttribute("user", user);
            request.setAttribute("survey", survey);
            url = "/thanks.jsp";   // the "thanks" page
        }

        // forward request and response objects to specified URL - Đi từ trang này sang trang khác vẫn giữ nguyên nội dung = RequestDispatcher
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
    }   
    @Override
    protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response) 
                         throws ServletException, IOException {
        doPost(request, response);
    }    
}