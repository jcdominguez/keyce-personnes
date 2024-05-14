package com.example.personnes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PersonneMvcController {

    @Autowired
    PersonneDbService personneDbService;

    @GetMapping("helloMVC")
    public String sayHello(Model model){

        String monPrenom = "Jean-Christophe";
        model.addAttribute("prenom", monPrenom);

        return "hello.html";
    }

    @GetMapping("personnes.html")
    public String getPersonnes(Model model){

        List<Personne> personnes = personneDbService.getAll();

        model.addAttribute("personnes", personnes);

        return "personnes.html";
    }
}
