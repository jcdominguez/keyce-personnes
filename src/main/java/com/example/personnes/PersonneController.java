package com.example.personnes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public List<PersonneDTO> getPersonnes(){
        List<Personne> personnes = personneService.getAll();
        List<PersonneDTO> dtos = new ArrayList<>();
        for(Personne p: personnes){
            dtos.add(PersonneMapper.toDTO(p));
        }
        return dtos;
    }
    // POST /personnes
    @PostMapping("/personnes")
    public void addPersonn(@RequestBody Personne personne){
        System.out.println(personne);
        personneService.add(personne);
    }

    // GET /personnes/{id}
    // exemple : /personnes/2
    @GetMapping("/personnes/{id}")
    public ResponseEntity<PersonneDTO> findById(@PathVariable("id") Integer id){
        Personne p = personneService.findById(id);
        if(p == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(PersonneMapper.toDTO(p));
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
    public ResponseEntity update(@PathVariable("id") Integer id, @RequestBody Personne personne){
        if(! id.equals(personne.getId()))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        Personne p = personneService.findById(id);
        if(p == null){
            return ResponseEntity.status(404).build();
        }

        personneService.update(id, personne);
        return ResponseEntity.ok().build();
    }
}
