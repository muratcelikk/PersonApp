package com.muratcelik.controller;

import com.muratcelik.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @Autowired
    private IPersonService personService;

    @GetMapping("/")
    public String redirectHome() {
        return "redirect:/home";
    }
    @GetMapping("/home")
    public String home() {
        return "home";
    }
    @GetMapping(value = "/addPerson")
    public String addPerson() {
        return "addPerson";
    }
    @GetMapping(value = "/detailPerson/{id}")
    public String detailPerson(@PathVariable Long id, Model model) {
        model.addAttribute("personId", id);
        return "detailPerson";
    }

}
