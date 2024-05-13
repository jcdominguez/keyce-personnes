package com.example.personnes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity findById(@PathVariable("id") Integer id){
        Personne p = personneService.findById(id);
        if(p == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(p);
    }

    // DELETE /personnes/{id}
    @DeleteMapping("/personnes/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        Personne p = personneService.findById(id);
        if(p == null){
            return ResponseEntity.notFound().build();
        }

        personneService.delete(id);
        return ResponseEntity.ok().build();

    }

    // PUT /personnes/{id}
    @PutMapping("/personnes/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody Personne personne){
        personneService.update(id, personne);
    }
}
