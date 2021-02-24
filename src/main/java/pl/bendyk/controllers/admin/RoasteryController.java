package pl.bendyk.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.bendyk.model.coffee.Coffee;
import pl.bendyk.model.others.Roastery;
import pl.bendyk.repository.CoffeeRepository;
import pl.bendyk.repository.RoasteryRepository;
import pl.bendyk.repository.ShipmentRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/roasteries")
public class RoasteryController {

    private final RoasteryRepository roasteryRepository;
    private final ShipmentRepository shipmentRepository;
    private final CoffeeRepository coffeeRepository;

    public RoasteryController(RoasteryRepository roasteryRepository, ShipmentRepository shipmentRepository, CoffeeRepository coffeeRepository) {
        this.roasteryRepository = roasteryRepository;
        this.shipmentRepository = shipmentRepository;
        this.coffeeRepository = coffeeRepository;
    }

    @GetMapping("/all")
    public String showAll(Model model, @RequestParam(required = false) String sort) {
        List<Roastery> roasteries = roasteryRepository.findAllByOrderByName();
        if (sort != null) {
            if (sort.equals("city")) {
                roasteries = roasteryRepository.findAllByOrderByCity();
            }
        }
        model.addAttribute("roasteries", roasteries);
        return "admin/roasteries/showAll";
    }

    @GetMapping("/add")
    public String getAddForm(Roastery roastery) {
        return "admin/roasteries/add";
    }

    @PostMapping("/add")
    public String postAddForm(@Valid Roastery roastery, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/roasteries/add";
        }
        roasteryRepository.save(roastery);
        return "redirect:/admin/roasteries/edit/" + roastery.getId();
    }

    @GetMapping("/edit/{id}")
    public String getEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("roastery", roasteryRepository.findById(id));
        model.addAttribute("shipments", shipmentRepository.findShipmentsForRoastery(id));
        return "admin/roasteries/edit";
    }

    @PostMapping("edit/{id}")
    public String postEditForm(@Valid Roastery roastery, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/roasteries/edit";
        }
        roasteryRepository.save(roastery);
        return "redirect:/admin/roasteries/all";
    }

    @RequestMapping("/confirm")
    public String confirm(@RequestParam Long id) {
        if (coffeeRepository.existsByRoasteryId(id)) {
            return "admin/roasteries/confirmIfCoffee";
        }
        return "admin/roasteries/confirm";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        roasteryRepository.deleteById(id);
        return "redirect:/admin/roasteries/all";
    }
}
