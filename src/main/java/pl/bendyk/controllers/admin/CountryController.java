package pl.bendyk.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.bendyk.model.others.Country;
import pl.bendyk.repository.CoffeeRepository;
import pl.bendyk.repository.CountryRepository;
import pl.bendyk.service.CountryService;
import pl.bendyk.service.CountryServiceImpl;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/countries")
public class CountryController {

    private final CountryService countryService;
    private final CoffeeRepository coffeeRepository;

    public CountryController(CountryService countryService, CoffeeRepository coffeeRepository) {
        this.countryService = countryService;
        this.coffeeRepository = coffeeRepository;
    }

    @RequestMapping("/all")
    public String all(Model model) {
        List<Country> countries = countryService.findAll();
        model.addAttribute("countries", countries);
        return "admin/countries/showAll";
    }

    @GetMapping("/add")
    public String getAddForm(Country country) {
        return "admin/countries/add";
    }

    @PostMapping("/add")
    public String postAddForm(@Valid Country country, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/countries/add";
        }
        countryService.save(country);
        return "redirect:/admin/countries/all";
    }

    @GetMapping("/edit/{id}")
    public String getEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("country", countryService.findOne(id));
        return "admin/countries/edit";
    }

    @PostMapping("edit/{id}")
    public String postEditForm(@Valid Country country, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/countries/edit";
        }
        countryService.save(country);
        return "redirect:/admin/countries/all";
    }

    @RequestMapping("/confirm")
    public String confirm(@RequestParam Long id) {
        if (coffeeRepository.existsByCountryId(id)) {
            return "admin/countries/confirmIfCoffee";
        }
        return "admin/countries/confirm";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        countryService.delete(id);
        return "redirect:/admin/countries/all";
    }

}
