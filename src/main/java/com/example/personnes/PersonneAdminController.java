package com.example.personnes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class PersonneAdminController {

    @Autowired
    private PersonneService personneService;

    @GetMapping("/personnes")
    public List<Personne> getPersonnes(){
        return personneService.getAll();
    }
}
