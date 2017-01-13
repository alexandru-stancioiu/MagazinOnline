package ro.upb.cs.dai.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by stancioi on 1/11/2017.
 */

@Controller
public class LogoutController {

    @RequestMapping("/logout")
    public ModelAndView logout(HttpSession httpSession) {
        httpSession.setAttribute("logged", false);
        httpSession.setAttribute("role", null);
        httpSession.setAttribute("user", null);
        httpSession.setAttribute("shoppingCart", null);

        return new ModelAndView("login");
    }

}
