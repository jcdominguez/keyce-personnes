package com.example.personnes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonneController {

    @Autowired
    private PersonneService personneService;

    // GET /hello
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello SpringBoot";
    }

    // API REST:
    // GET /personnes
    @GetMapping("/personnes")
    public List<Personne> getPersonnes(){
        return personneService.getAll();
    }
    // POST /personnes
    @PostMapping("/personnes")
    public void addPersonn(@RequestBody Personne personne){
        personneService.add(personne);
    }

    // GET /personnes/{id}
    // exemple : /personnes/2
    @GetMapping("/personnes/{id}")
    public Personne findById(@PathVariable("id") Integer id){
        return personneService.findById(id);
    }
    // PUT /personnes/{id}
    // DELETE /personnes/{id}

}
