package pl.bendyk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.bendyk.repository.CoffeeRepository;

@Controller
public class HomeController {

    private final CoffeeRepository coffeeRepository;

    public HomeController(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("coffees", coffeeRepository.findAll());
        return "user/coffees/showAll";
    }

}
