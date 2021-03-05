package pl.bendyk.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.bendyk.model.others.ShipmentType;
import pl.bendyk.repository.ShipmentRepository;
import pl.bendyk.repository.ShipmentTypeRepository;
import pl.bendyk.service.ShipmentService;
import pl.bendyk.service.ShipmentTypeService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/shipment-types")
public class ShipmentTypeController {

    private final ShipmentTypeService shipmentTypeService;
    private final ShipmentService shipmentService;

    public ShipmentTypeController(ShipmentTypeService shipmentTypeService, ShipmentService shipmentService) {
        this.shipmentTypeService = shipmentTypeService;
        this.shipmentService = shipmentService;
    }

    @RequestMapping("/all")
    public String all(Model model) {
        List<ShipmentType> shipmentTypes = shipmentTypeService.findAll();
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
        shipmentTypeService.save(shipmentType);
        return "redirect:/admin/shipment-types/all";
    }

    @GetMapping("/edit/{id}")
    public String getEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("shipmentType", shipmentTypeService.findOne(id));
        return "admin/shipmentTypes/edit";
    }

    @PostMapping("edit/{id}")
    public String postEditForm(@Valid ShipmentType shipmentType, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/shipmentTypes/edit";
        }
        shipmentTypeService.save(shipmentType);
        return "redirect:/admin/shipment-types/all";
    }

    @RequestMapping("/confirm")
    public String confirm(@RequestParam Long id) {
        if (shipmentService.exists(id)) {
            return "admin/shipmentTypes/confirmIfCoffee";
        }
        return "admin/shipmentTypes/confirm";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        shipmentTypeService.delete(id);
        return "redirect:/admin/shipment-types/all";
    }


}
