package pl.bendyk.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.bendyk.model.coffee.Volume;
import pl.bendyk.repository.CoffeeRepository;
import pl.bendyk.repository.VolumeRepository;
import pl.bendyk.service.VolumeService;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/admin/volumes")
public class VolumeController {

    private final VolumeService volumeService;
    private final CoffeeRepository coffeeRepository;

    public VolumeController(VolumeService volumeService, CoffeeRepository coffeeRepository) {
        this.volumeService = volumeService;
        this.coffeeRepository = coffeeRepository;
    }

    @RequestMapping("/all")
    public String all(Model model) {
        List<Volume> volumes = volumeService.findAll();
        model.addAttribute("volumes", volumes);
        return "admin/volumes/showAll";
    }

    @GetMapping("/add")
    public String getAddForm(Volume volume) {
        return "admin/volumes/add";
    }

    @PostMapping("/add")
    public String postAddForm(@Valid Volume volume, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/volumes/add";
        }
        volumeService.save(volume);
        return "redirect:/admin/volumes/all";
    }

    @GetMapping("/edit/{id}")
    public String getEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("volumes", volumeService.findOne(id));
        return "admin/volumes/edit";
    }

    @PostMapping("edit/{id}")
    public String postEditForm(@Valid Volume volume, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/volumes/edit";
        }
        volumeService.save(volume);
        return "redirect:/admin/volumes/all";
    }

    @RequestMapping("/confirm")
    public String confirm(@RequestParam Long id) {
        if (coffeeRepository.existsByVolumeId(id)) {
            return "admin/volumes/confirmIfCoffee";
        }
        return "admin/volumes/confirm";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        volumeService.delete(id);
        return "redirect:/admin/volumes/all";
    }

}
