package pl.bendyk.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.bendyk.model.coffee.Coffee;
import pl.bendyk.repository.*;
import pl.bendyk.model.coffee.Roast;
import pl.bendyk.model.coffee.Composition;

import javax.validation.Valid;
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
    private final DepulpingProcessRepository depulpingProcessRepository;

    public CoffeeController(CoffeeRepository coffeeRepository, CountryRepository countryRepository,
                            RoasteryRepository roasteryRepository, MethodRepository methodRepository,
                            SpeciesRepository speciesRepository, VolumeRepository volumeRepository,
                            DepulpingProcessRepository depulpingProcessRepository) {
        this.coffeeRepository = coffeeRepository;
        this.countryRepository = countryRepository;
        this.roasteryRepository = roasteryRepository;
        this.methodRepository = methodRepository;
        this.speciesRepository = speciesRepository;
        this.volumeRepository = volumeRepository;
        this.depulpingProcessRepository = depulpingProcessRepository;
    }

    @RequestMapping("/all")
    public String all(Model model, @RequestParam(required = false) String sort) {
        List<Coffee> coffees = coffeeRepository.findAllByOrderByName();
        if (sort != null) {
            if (sort.equals("country")) {
                coffees = coffeeRepository.findAllByOrderByCountry();
            } else if (sort.equals("roastery")) {
                coffees = coffeeRepository.findAllByOrderByRoastery();
            } else if (sort.equals("active")) {
                coffees = coffeeRepository.findAllByOrderByActive();
            }
        }
        model.addAttribute("coffees", coffees);
        return "admin/coffees/showAll";
    }

    @GetMapping("/add")
    public String getAddForm(Coffee coffee, Model model) {
        model.addAttribute("countries", countryRepository.findAllByOrderByName());
        model.addAttribute("processes", depulpingProcessRepository.findAll());
        model.addAttribute("roasteries", roasteryRepository.findAllByOrderByName());
        model.addAttribute("roasts", Roast.values());
        model.addAttribute("methods", methodRepository.findAll());
        model.addAttribute("compositions", Composition.values());
        model.addAttribute("species", speciesRepository.findAll());
        model.addAttribute("volumes", volumeRepository.findAll());
        return "admin/coffees/add";
    }

    @PostMapping("/add")
    public String postAddForm(@Valid Coffee coffee, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("countries", countryRepository.findAllByOrderByName());
            model.addAttribute("processes", depulpingProcessRepository.findAll());
            model.addAttribute("roasteries", roasteryRepository.findAllByOrderByName());
            model.addAttribute("roasts", Roast.values());
            model.addAttribute("methods", methodRepository.findAll());
            model.addAttribute("compositions", Composition.values());
            model.addAttribute("species", speciesRepository.findAll());
            model.addAttribute("volumes", volumeRepository.findAll());
            return "admin/coffees/add";
        }
        coffeeRepository.save(coffee);
        return "redirect:/admin/coffees/all";
    }

    @GetMapping("/edit/{id}")
    public String getEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("coffee", coffeeRepository.findById(id));
        model.addAttribute("countries", countryRepository.findAllByOrderByName());
        model.addAttribute("processes", depulpingProcessRepository.findAll());
        model.addAttribute("roasteries", roasteryRepository.findAllByOrderByName());
        model.addAttribute("roasts", Roast.values());
        model.addAttribute("methods", methodRepository.findAll());
        model.addAttribute("compositions", Composition.values());
        model.addAttribute("species", speciesRepository.findAll());
        model.addAttribute("volumes", volumeRepository.findAll());
        return "admin/coffees/edit";
    }

    @PostMapping("edit/{id}")
    public String postEditForm(@Valid Coffee coffee, BindingResult result, @PathVariable Long id, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("coffee", coffeeRepository.findById(id));
            model.addAttribute("countries", countryRepository.findAllByOrderByName());
            model.addAttribute("processes", depulpingProcessRepository.findAll());
            model.addAttribute("roasteries", roasteryRepository.findAllByOrderByName());
            model.addAttribute("roasts", Roast.values());
            model.addAttribute("methods", methodRepository.findAll());
            model.addAttribute("compositions", Composition.values());
            model.addAttribute("species", speciesRepository.findAll());
            model.addAttribute("volumes", volumeRepository.findAll());
            return "admin/coffees/edit";
        }
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
