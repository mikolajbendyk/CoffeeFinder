package pl.bendyk.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.bendyk.model.coffee.Coffee;
import pl.bendyk.repository.*;
import pl.bendyk.model.coffee.Roast;
import pl.bendyk.model.coffee.Composition;
import pl.bendyk.service.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/coffees")
public class CoffeeController {

    private final CoffeeService coffeeService;
    private final CountryService countryService;
    private final RoasteryService roasteryService;
    private final MethodService methodService;
    private final SpeciesService speciesService;
    private final VolumeService volumeService;
    private final DepulpingProcessService depulpingProcessService;

    public CoffeeController(CoffeeService coffeeService, CountryService countryService, RoasteryService roasteryService,
                            MethodService methodService, SpeciesService speciesService, VolumeService volumeService,
                            DepulpingProcessService depulpingProcessService) {
        this.coffeeService = coffeeService;
        this.countryService = countryService;
        this.roasteryService = roasteryService;
        this.methodService = methodService;
        this.speciesService = speciesService;
        this.volumeService = volumeService;
        this.depulpingProcessService = depulpingProcessService;
    }

    @RequestMapping("/all")
    public String all(Model model, @RequestParam(required = false) String sort) {
        List<Coffee> coffees = coffeeService.findAll();
        if (sort != null) {
            if (sort.equals("country")) {
                coffees = coffeeService.findAllOrderedByCountry();
            } else if (sort.equals("roastery")) {
                coffees = coffeeService.findAllOrderedByRoastery();
            } else if (sort.equals("active")) {
                coffees = coffeeService.findAllOrderedByActive();
            }
        }
        model.addAttribute("coffees", coffees);
        return "admin/coffees/showAll";
    }

    @GetMapping("/add")
    public String getAddForm(Coffee coffee, Model model) {
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("processes", depulpingProcessService.findAll());
        model.addAttribute("roasteries", roasteryService.findAll());
        model.addAttribute("roasts", Roast.values());
        model.addAttribute("methods", methodService.findAll());
        model.addAttribute("compositions", Composition.values());
        model.addAttribute("species", speciesService.findAll());
        model.addAttribute("volumes", volumeService.findAll());
        return "admin/coffees/add";
    }

    @PostMapping("/add")
    public String postAddForm(@Valid Coffee coffee, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("countries", countryService.findAll());
            model.addAttribute("processes", depulpingProcessService.findAll());
            model.addAttribute("roasteries", roasteryService.findAll());
            model.addAttribute("roasts", Roast.values());
            model.addAttribute("methods", methodService.findAll());
            model.addAttribute("compositions", Composition.values());
            model.addAttribute("species", speciesService.findAll());
            model.addAttribute("volumes", volumeService.findAll());
            return "admin/coffees/add";
        }
        coffeeService.save(coffee);
        return "redirect:/admin/coffees/all";
    }

    @GetMapping("/edit/{id}")
    public String getEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("coffee", coffeeService.findOne(id));
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("processes", depulpingProcessService.findAll());
        model.addAttribute("roasteries", roasteryService.findAll());
        model.addAttribute("roasts", Roast.values());
        model.addAttribute("methods", methodService.findAll());
        model.addAttribute("compositions", Composition.values());
        model.addAttribute("species", speciesService.findAll());
        model.addAttribute("volumes", volumeService.findAll());
        return "admin/coffees/edit";
    }

    @PostMapping("edit/{id}")
    public String postEditForm(@Valid Coffee coffee, BindingResult result, @PathVariable Long id, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("coffee", coffeeService.findOne(id));
            model.addAttribute("countries", countryService.findAll());
            model.addAttribute("processes", depulpingProcessService.findAll());
            model.addAttribute("roasteries", roasteryService.findAll());
            model.addAttribute("roasts", Roast.values());
            model.addAttribute("methods", methodService.findAll());
            model.addAttribute("compositions", Composition.values());
            model.addAttribute("species", speciesService.findAll());
            model.addAttribute("volumes", volumeService.findAll());
            return "admin/coffees/edit";
        }
        coffeeService.save(coffee);
        return "redirect:/admin/coffees/all";
    }

    @RequestMapping("/confirm")
    public String confirm() {
        return "admin/coffees/confirm";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        coffeeService.delete(id);
        return "redirect:/admin/coffees/all";
    }


}
