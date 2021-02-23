package pl.bendyk.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.bendyk.model.coffee.DepulpingProcess;
import pl.bendyk.repository.CoffeeRepository;
import pl.bendyk.repository.DepulpingProcessRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/processes")
public class DepulpingProcessController {

    private final DepulpingProcessRepository depulpingProcessRepository;
    private final CoffeeRepository coffeeRepository;

    public DepulpingProcessController(DepulpingProcessRepository depulpingProcessRepository, CoffeeRepository coffeeRepository) {
        this.depulpingProcessRepository = depulpingProcessRepository;
        this.coffeeRepository = coffeeRepository;
    }

    @RequestMapping("/all")
    public String all(Model model) {
        List<DepulpingProcess> processes = depulpingProcessRepository.findAll();
        model.addAttribute("processes", processes);
        return "admin/processes/showAll";
    }

    @GetMapping("/add")
    public String getAddForm(DepulpingProcess depulpingProcess) {
        return "admin/processes/add";
    }

    @PostMapping("/add")
    public String postAddForm(@Valid DepulpingProcess depulpingProcess, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/processes/add";
        }
        depulpingProcessRepository.save(depulpingProcess);
        return "redirect:/admin/processes/all";
    }

    @GetMapping("/edit/{id}")
    public String getEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("depulpingProcess", depulpingProcessRepository.findById(id));
        return "admin/processes/edit";
    }

    @PostMapping("edit/{id}")
    public String postEditForm(@Valid DepulpingProcess depulpingProcess, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/processes/add";
        }
        depulpingProcessRepository.save(depulpingProcess);
        return "redirect:/admin/processes/all";
    }

    @RequestMapping("/confirm")
    public String confirm(@RequestParam Long id) {
        if (coffeeRepository.existsByDepulpingProcessId(id)) {
            return "admin/processes/confirmIfCoffee";
        }
        return "admin/processes/confirm";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        depulpingProcessRepository.deleteById(id);
        return "redirect:/admin/processes/all";
    }
}
