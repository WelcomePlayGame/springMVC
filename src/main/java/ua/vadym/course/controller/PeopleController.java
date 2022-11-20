package ua.vadym.course.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.vadym.course.dao.PersoneDAO;
import ua.vadym.course.models.Person;

import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class PeopleController {

    static final String MESSAGE = "Have are you good day";

    @Autowired
    private final PersoneDAO personeDAO;

    public PeopleController(PersoneDAO personeDAO) {
        this.personeDAO = personeDAO;
    }


    @GetMapping("/index")
    public String getListPeople(Model model) {

        model.addAttribute("people", personeDAO.getPeople());

        return "people/index";
    }

    @GetMapping("/{id}")
    public String showPersone(@PathVariable("id") int id, Model model) {

        model.addAttribute("person", personeDAO.getPersone(id));

        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("person", new Person());
        return "people/new";
    }

    @PostMapping()
    public String create(@Valid @ModelAttribute("person") Person person,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "people/new";

        personeDAO.save(person);
        return "redirect:people/index";
    }

}
