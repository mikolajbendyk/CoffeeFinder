package pl.bendyk.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.bendyk.model.others.Country;
import pl.bendyk.repository.CoffeeRepository;
import pl.bendyk.repository.CountryRepository;

import java.util.List;

@Controller
@RequestMapping("/admin/countries")
public class CountryController {

    private final CountryRepository countryRepository;
    private final CoffeeRepository coffeeRepository;

    public CountryController(CountryRepository countryRepository, CoffeeRepository coffeeRepository) {
        this.countryRepository = countryRepository;
        this.coffeeRepository = coffeeRepository;
    }

    @RequestMapping("/all")
    public String all(Model model) {
        List<Country> countries = countryRepository.findAllByOrderByName();
        model.addAttribute("countries", countries);
        return "admin/countries/showAll";
    }

    @GetMapping("/add")
    public String getAddForm(Country country) {
        return "admin/countries/add";
    }

    @PostMapping("/add")
    public String postAddForm(Country country) {
        countryRepository.save(country);
        return "redirect:/admin/countries/all";
    }

    @GetMapping("/edit/{id}")
    public String getEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("country", countryRepository.findById(id));
        return "admin/countries/edit";
    }

    @PostMapping("edit/{id}")
    public String postEditForm(Country country) {
        countryRepository.save(country);
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
        countryRepository.deleteById(id);
        return "redirect:/admin/countries/all";
    }

}
