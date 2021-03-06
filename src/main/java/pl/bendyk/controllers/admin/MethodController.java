package pl.bendyk.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.bendyk.model.coffee.Method;
import pl.bendyk.repository.CoffeeRepository;
import pl.bendyk.repository.CountryRepository;
import pl.bendyk.repository.MethodRepository;
import pl.bendyk.service.MethodService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/methods")
public class MethodController {

    private final MethodService methodService;
    private final CoffeeRepository coffeeRepository;

    public MethodController(MethodService methodService, CoffeeRepository coffeeRepository) {
        this.methodService = methodService;
        this.coffeeRepository = coffeeRepository;
    }

    @RequestMapping("/all")
    public String all(Model model) {
        List<Method> methods = methodService.findAll();
        model.addAttribute("methods", methods);
        return "admin/methods/showAll";
    }

    @GetMapping("/add")
    public String getAddForm(Method method) {
        return "admin/methods/add";
    }

    @PostMapping("/add")
    public String postAddForm(@Valid Method method, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/methods/add";
        }
        methodService.save(method);
        return "redirect:/admin/methods/all";
    }

    @GetMapping("/edit/{id}")
    public String getEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("method", methodService.findOne(id));
        return "admin/methods/edit";
    }

    @PostMapping("edit/{id}")
    public String postEditForm(@Valid Method method, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/methods/edit";
        }
        methodService.save(method);
        return "redirect:/admin/methods/all";
    }

    @RequestMapping("/confirm")
    public String confirm(@RequestParam Long id) {
        if (coffeeRepository.existsByMethodsId(id)) {
            return "admin/methods/confirmIfCoffee";
        }
        return "admin/methods/confirm";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        methodService.delete(id);
        return "redirect:/admin/methods/all";
    }

}
