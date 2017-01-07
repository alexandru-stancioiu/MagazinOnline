package ro.upb.cs.dai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.upb.cs.dai.model.CredentialsForm;
import ro.upb.cs.dai.service.RegisterService;

/**
 * Created by stancioi on 12/25/2016.
 */

@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @RequestMapping(value = "/register")
    public String register() {

        return "register";
    }

    @RequestMapping(value = "/do_register")
    public String doRegister(@ModelAttribute CredentialsForm credentialsForm) {

        registerService.register(credentialsForm);
        return "login";
    }
}
