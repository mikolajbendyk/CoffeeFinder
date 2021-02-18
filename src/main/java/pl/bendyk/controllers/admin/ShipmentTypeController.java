package pl.bendyk.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.bendyk.model.others.ShipmentType;
import pl.bendyk.repository.ShipmentTypeRepository;

import java.util.List;

@Controller
@RequestMapping("/admin/shipment-types")
public class ShipmentTypeController {

    private final ShipmentTypeRepository shipmentTypeRepository;

    public ShipmentTypeController(ShipmentTypeRepository shipmentTypeRepository) {
        this.shipmentTypeRepository = shipmentTypeRepository;
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
    public String postAddForm(ShipmentType shipmentType) {
        shipmentTypeRepository.save(shipmentType);
        return "redirect:/admin/shipment-types/all";
    }

    @GetMapping("/edit/{id}")
    public String getEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("shipmentType", shipmentTypeRepository.findById(id));
        return "admin/shipmentTypes/edit";
    }

    @PostMapping("edit/{id}")
    public String postEditForm(ShipmentType shipmentType) {
        shipmentTypeRepository.save(shipmentType);
        return "redirect:/admin/shipment-types/all";
    }

    @RequestMapping("/confirm")
    public String confirm() {
        return "admin/shipmentTypes/confirm";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        shipmentTypeRepository.deleteById(id);
        return "redirect:/admin/shipment-types/all";
    }


}
