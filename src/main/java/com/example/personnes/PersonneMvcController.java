package com.example.personnes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonneMvcController {

    @GetMapping("helloMVC")
    public String sayHello(Model model){

        String monPrenom = "Jean-Christophe";
        model.addAttribute("prenom", monPrenom);

        return "hello.html";
    }
}
