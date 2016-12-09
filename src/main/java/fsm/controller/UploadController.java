package fsm.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UploadController {

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String showUploadFilePage(HttpServletRequest request, Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername();

        model.addAttribute("username", name);

        /*CsrfToken csrfToken = (CsrfToken) request.getAttribute("_csrf");
        model.addAttribute("csrfTokenParameter", csrfToken.getParameterName());
        model.addAttribute("csrfToken", csrfToken.getToken());

        System.out.println("Token Parameter: " + csrfToken.getParameterName());
        System.out.println("Token Header: " + csrfToken.getParameterName());
        System.out.println("Token: " + csrfToken.getToken());*/

        return "upload";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadFile(HttpServletRequest request, Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername();

        model.addAttribute("username", name);

        return "index";
    }
}