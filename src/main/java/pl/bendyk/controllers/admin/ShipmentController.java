package pl.bendyk.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.bendyk.model.others.Shipment;
import pl.bendyk.model.others.ShipmentType;
import pl.bendyk.repository.RoasteryRepository;
import pl.bendyk.repository.ShipmentRepository;
import pl.bendyk.repository.ShipmentTypeRepository;
import pl.bendyk.service.RoasteryService;
import pl.bendyk.service.ShipmentService;
import pl.bendyk.service.ShipmentTypeService;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/roasteries/{roasteryId}/shipments")
public class ShipmentController {

    private final ShipmentService shipmentService;
    private final ShipmentTypeService shipmentTypeService;
    private final RoasteryService roasteryService;

    public ShipmentController(ShipmentService shipmentService, ShipmentTypeService shipmentTypeService, RoasteryService roasteryService) {
        this.shipmentService = shipmentService;
        this.shipmentTypeService = shipmentTypeService;
        this.roasteryService = roasteryService;
    }

    @GetMapping("/add")
    public String getAddForm(Shipment shipment, Model model) {
        model.addAttribute("shipmentTypes", shipmentTypeService.findAll());
        return "admin/shipments/add";
    }

    @PostMapping("/add")
    public String postAddForm(@PathVariable Long roasteryId, @Valid Shipment shipment, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("shipmentTypes", shipmentTypeService.findAll());
            return "admin/shipments/add";
        }
        shipment.setRoastery(roasteryService.findOne(roasteryId));
        shipmentService.save(shipment);
        return "redirect:/admin/roasteries/edit/{roasteryId}";
    }

    @GetMapping("/edit/{id}")
    public String getEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("shipment", shipmentService.findOne(id));
        model.addAttribute("shipmentTypes", shipmentTypeService.findAll());
        return "admin/shipments/edit";
    }

    @PostMapping("edit/{id}")
    public String postEditForm(@PathVariable Long roasteryId, @Valid Shipment shipment, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("shipmentTypes", shipmentTypeService.findAll());
            return "admin/shipments/edit/" + roasteryId;
        }
        shipment.setRoastery(roasteryService.findOne(roasteryId));
        shipmentService.save(shipment);
        return "redirect:/admin/roasteries/edit/{roasteryId}";
    }

    @RequestMapping("/confirm")
    public String confirm() {
        return "admin/shipments/confirm";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        shipmentService.delete(id);
        return "redirect:/admin/roasteries/edit/{roasteryId}";
    }

}
