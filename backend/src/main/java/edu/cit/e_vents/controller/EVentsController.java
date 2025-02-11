package edu.cit.e_vents.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EVentsController {

    @RequestMapping("/")
    public String welcome() {
        return "Welcome to E-vents: Event Management and Ticketing System!";
    }
}
