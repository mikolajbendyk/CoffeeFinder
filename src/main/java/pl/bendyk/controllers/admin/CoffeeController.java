package pl.bendyk.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.bendyk.model.coffee.Coffee;
import pl.bendyk.repository.*;
import pl.bendyk.model.coffee.Process;
import pl.bendyk.model.coffee.Roast;
import pl.bendyk.model.coffee.Composition;

import java.util.List;

@Controller
@RequestMapping("/admin/coffees")
public class CoffeeController {

    private final CoffeeRepository coffeeRepository;
    private final CountryRepository countryRepository;
    private final RoasteryRepository roasteryRepository;
    private final MethodRepository methodRepository;
    private final SpeciesRepository speciesRepository;
    private final VolumeRepository volumeRepository;

    public CoffeeController(CoffeeRepository coffeeRepository, CountryRepository countryRepository,
                            RoasteryRepository roasteryRepository, MethodRepository methodRepository,
                            SpeciesRepository speciesRepository,
                            VolumeRepository volumeRepository) {
        this.coffeeRepository = coffeeRepository;
        this.countryRepository = countryRepository;
        this.roasteryRepository = roasteryRepository;
        this.methodRepository = methodRepository;
        this.speciesRepository = speciesRepository;
        this.volumeRepository = volumeRepository;
    }

    @RequestMapping("/all")
    public String all(Model model) {
        List<Coffee> coffees = coffeeRepository.findAllByOrderByName();
        model.addAttribute("coffees", coffees);
        return "admin/coffees/showAll";
    }

    @GetMapping("/add")
    public String getAddForm(Coffee coffee, Model model) {
        model.addAttribute("countries", countryRepository.findAllByOrderByName());
        model.addAttribute("processes", Process.values());
        model.addAttribute("roasteries", roasteryRepository.findAllByOrderByName());
        model.addAttribute("roasts", Roast.values());
        model.addAttribute("methods", methodRepository.findAll());
        model.addAttribute("compositions", Composition.values());
        model.addAttribute("species", speciesRepository.findAll());
        model.addAttribute("volumes", volumeRepository.findAll());
        return "admin/coffees/add";
    }

    @PostMapping("/add")
    public String postAddForm(Coffee coffee) {
        coffeeRepository.save(coffee);
        return "redirect:/admin/coffees/all";
    }

    @GetMapping("/edit/{id}")
    public String getEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("coffee", coffeeRepository.findById(id));
        model.addAttribute("countries", countryRepository.findAllByOrderByName());
        model.addAttribute("processes", Process.values());
        model.addAttribute("roasteries", roasteryRepository.findAllByOrderByName());
        model.addAttribute("roasts", Roast.values());
        model.addAttribute("methods", methodRepository.findAll());
        model.addAttribute("compositions", Composition.values());
        model.addAttribute("species", speciesRepository.findAll());
        model.addAttribute("volumes", volumeRepository.findAll());
        return "admin/coffees/edit";
    }

    @PostMapping("edit/{id}")
    public String postEditForm(Coffee coffee) {
        coffeeRepository.save(coffee);
        return "redirect:/admin/coffees/all";
    }

    @RequestMapping("/confirm")
    public String confirm() {
        return "admin/coffees/confirm";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        coffeeRepository.deleteById(id);
        return "redirect:/admin/coffees/all";
    }


}
