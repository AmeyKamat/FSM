package fsm.controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by TUSHAR on 16-09-2016.
 */
public class LogoutHandler extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession logoutSession = request.getSession();
        logoutSession.invalidate();
        response.sendRedirect(request.getContextPath()+"/login.jsp");


    }

    @Override
    public void init() throws ServletException {
        super.init();
    }


    @Override
    public void destroy() {
        super.destroy();
    }
}
