package com.example.personnes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonneMvcController {

    @GetMapping("helloMVC")
    public String sayHello(){

        return "hello.html";
    }
}
