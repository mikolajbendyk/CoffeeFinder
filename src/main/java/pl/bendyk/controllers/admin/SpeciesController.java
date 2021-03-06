package pl.bendyk.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.bendyk.model.coffee.Species;
import pl.bendyk.repository.CoffeeRepository;
import pl.bendyk.repository.SpeciesRepository;
import pl.bendyk.service.SpeciesService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/species")
public class SpeciesController {

    private final SpeciesService speciesService;
    private final CoffeeRepository coffeeRepository;

    public SpeciesController(SpeciesService speciesService, CoffeeRepository coffeeRepository) {
        this.speciesService = speciesService;
        this.coffeeRepository = coffeeRepository;
    }

    @RequestMapping("/all")
    public String all(Model model) {
        List<Species> species = speciesService.findAll();
        model.addAttribute("species", species);
        return "admin/species/showAll";
    }

    @GetMapping("/add")
    public String getAddForm(Species species) {
        return "admin/species/add";
    }

    @PostMapping("/add")
    public String postAddForm(@Valid Species species, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/species/add";
        }
        speciesService.save(species);
        return "redirect:/admin/species/all";
    }

    @GetMapping("/edit/{id}")
    public String getEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("species", speciesService.findOne(id));
        return "admin/species/edit";
    }

    @PostMapping("edit/{id}")
    public String postEditForm(@Valid Species species, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/species/edit";
        }
        speciesService.save(species);
        return "redirect:/admin/species/all";
    }

    @RequestMapping("/confirm")
    public String confirm(@RequestParam Long id) {
        if (coffeeRepository.existsBySpeciesId(id)) {
            return "admin/species/confirmIfCoffee";
        }
        return "admin/species/confirm";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        speciesService.delete(id);
        return "redirect:/admin/species/all";
    }


}
