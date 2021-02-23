package pl.bendyk.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.bendyk.model.others.ShipmentType;
import pl.bendyk.repository.ShipmentRepository;
import pl.bendyk.repository.ShipmentTypeRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/shipment-types")
public class ShipmentTypeController {

    private final ShipmentTypeRepository shipmentTypeRepository;
    private final ShipmentRepository shipmentRepository;

    public ShipmentTypeController(ShipmentTypeRepository shipmentTypeRepository, ShipmentRepository shipmentRepository) {
        this.shipmentTypeRepository = shipmentTypeRepository;
        this.shipmentRepository = shipmentRepository;
    }

    @RequestMapping("/all")
    public String all(Model model) {
        List<ShipmentType> shipmentTypes = shipmentTypeRepository.findAll();
        model.addAttribute("shipmentTypes", shipmentTypes);
        return "admin/shipmentTypes/showAll";
    }

    @GetMapping("/add")
    public String getAddForm(ShipmentType shipmentType) {
        return "admin/shipmentTypes/add";
    }

    @PostMapping("/add")
    public String postAddForm(@Valid ShipmentType shipmentType, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/shipmentTypes/add";
        }
        shipmentTypeRepository.save(shipmentType);
        return "redirect:/admin/shipment-types/all";
    }

    @GetMapping("/edit/{id}")
    public String getEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("shipmentType", shipmentTypeRepository.findById(id));
        return "admin/shipmentTypes/edit";
    }

    @PostMapping("edit/{id}")
    public String postEditForm(@Valid ShipmentType shipmentType, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/shipmentTypes/add";
        }
        shipmentTypeRepository.save(shipmentType);
        return "redirect:/admin/shipment-types/all";
    }

    @RequestMapping("/confirm")
    public String confirm(@RequestParam Long id) {
        if (shipmentRepository.existsByShipmentTypeId(id)) {
            return "admin/shipmentTypes/confirmIfCoffee";
        }
        return "admin/shipmentTypes/confirm";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        shipmentTypeRepository.deleteById(id);
        return "redirect:/admin/shipment-types/all";
    }


}
