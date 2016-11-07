package fsm.controller.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fsm.entity.Users;
import fsm.repository.impl.DataLoader;


/**
 * Created by TUSHAR on 15-09-2016.
 */
public class LoginHandler extends HttpServlet {

    String message;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {




       String id = req.getParameter("user");
        String password = req.getParameter("password");
        PrintWriter outPrintWriter = resp.getWriter();
        DataLoader dataLoader = new DataLoader();
        Users userCheckLogin = dataLoader.getUser(id);
        if(userCheckLogin==null){

            outPrintWriter.println("<script>");
            outPrintWriter.println("document.location.href='"+req.getContextPath()+"/login.jsp'"); // check filename
            outPrintWriter.println("alert('User does not exist');");
            outPrintWriter.println("</script>");

        }
        else{

            if(password.equals(userCheckLogin.getPassword())){

                HttpSession session = req.getSession();
                session.setAttribute("id",id);
                resp.sendRedirect(req.getContextPath()); //check filename

            }
            else {

                outPrintWriter.println("<script>");
                outPrintWriter.println("document.location.href='"+req.getContextPath()+"/login.jsp'"); //check filename
                outPrintWriter.println("alert('Incorrect password');");
                outPrintWriter.println("</script>");

            }

        }


    }

    @Override
    public void init() throws ServletException {

    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
