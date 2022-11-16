package ua.vadym.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.vadym.course.dao.PersoneDAO;

@Controller
@RequestMapping("/people")
public class PeopleController {

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
}
