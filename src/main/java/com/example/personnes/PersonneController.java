package com.example.personnes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonneController {


    // GET /hello
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello SpringBoot";
    }

    // API REST:
    // GET /personnes
    // POST /personnes
    // GET /personnes/{id}
    // PUT /personnes/{id}
    // DELETE /personnes/{id}

}