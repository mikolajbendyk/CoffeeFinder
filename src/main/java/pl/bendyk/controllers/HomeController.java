package pl.bendyk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.bendyk.model.coffee.Coffee;
import pl.bendyk.repository.CoffeeRepository;
import pl.bendyk.repository.RoasteryRepository;

import java.util.List;

@Controller
public class HomeController {

    private final CoffeeRepository coffeeRepository;
    private final RoasteryRepository roasteryRepository;

    public HomeController(CoffeeRepository coffeeRepository, RoasteryRepository roasteryRepository) {
        this.coffeeRepository = coffeeRepository;
        this.roasteryRepository = roasteryRepository;
    }

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("coffees", coffeeRepository.findAllByActiveTrue());
        model.addAttribute("roasteries", roasteryRepository.findAllByOrderByName());
        return "home/coffees/showAll";
    }

    @PostMapping("/")
    public String getFilters(@RequestParam String sort, @RequestParam List<Long> roasteriesIds, Model model) {
        model.addAttribute("coffees", prepareFilter(roasteriesIds));
        return "home/coffees/showFiltered";
    }

    private List<Coffee> prepareFilter(List<Long> roasteriesIds) {
//        if (request.equals("priceAsc")) {
//            return coffeeRepository.findAllByOrderByPriceAsc();
//        } else if (request.equals("priceDesc")) {
//            return coffeeRepository.findAllByOrderByPriceDesc();
//        }
        if (roasteriesIds != null) {
            return coffeeRepository.findAllByRoasteries(roasteriesIds);
        }
        return coffeeRepository.findAll();
    }

}
