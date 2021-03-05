package pl.bendyk.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.bendyk.model.coffee.Coffee;
import pl.bendyk.model.others.Roastery;
import pl.bendyk.model.others.Shipment;
import pl.bendyk.repository.CoffeeRepository;
import pl.bendyk.repository.RoasteryRepository;
import pl.bendyk.repository.ShipmentRepository;
import pl.bendyk.service.RoasteryService;
import pl.bendyk.service.ShipmentService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/roasteries")
public class RoasteryController {

    private final RoasteryService roasteryService;
    private final ShipmentService shipmentService;
    private final CoffeeRepository coffeeRepository;

    public RoasteryController(RoasteryService roasteryService, ShipmentService shipmentService, CoffeeRepository coffeeRepository) {
        this.roasteryService = roasteryService;
        this.shipmentService = shipmentService;
        this.coffeeRepository = coffeeRepository;
    }

    @GetMapping("/all")
    public String showAll(Model model, @RequestParam(required = false) String sort) {
        List<Roastery> roasteries = roasteryService.findAll();
        if (sort != null) {
            if (sort.equals("city")) {
                roasteries = roasteryService.findAllOrderedByCity();
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
        roasteryService.save(roastery);
        return "redirect:/admin/roasteries/edit/" + roastery.getId();
    }

    @GetMapping("/edit/{id}")
    public String getEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("roastery", roasteryService.findOne(id));
        model.addAttribute("shipments", shipmentService.findShipmentsForRoastery(id));
        return "admin/roasteries/edit";
    }

    @PostMapping("edit/{id}")
    public String postEditForm(@Valid Roastery roastery, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/roasteries/edit";
        }
        roasteryService.save(roastery);
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
        List<Shipment> shipments = shipmentService.findShipmentsForRoastery(id);
        for (Shipment s : shipments) {
            shipmentService.delete(s.getId());
        }
        roasteryService.delete(id);
        return "redirect:/admin/roasteries/all";
    }
}
