package pl.bendyk.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.bendyk.model.others.Roastery;
import pl.bendyk.model.others.Shipment;
import pl.bendyk.repository.RoasteryRepository;
import pl.bendyk.repository.ShipmentRepository;
import pl.bendyk.repository.ShipmentTypeRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/roasteries/{roasteryId}/shipments")
public class ShipmentController {

    private final ShipmentRepository shipmentRepository;
    private final ShipmentTypeRepository shipmentTypeRepository;
    private final RoasteryRepository roasteryRepository;

    public ShipmentController(ShipmentRepository shipmentRepository, ShipmentTypeRepository shipmentTypeRepository, RoasteryRepository roasteryRepository) {
        this.shipmentRepository = shipmentRepository;
        this.shipmentTypeRepository = shipmentTypeRepository;
        this.roasteryRepository = roasteryRepository;
    }

    @GetMapping("/add")
    public String getAddForm(Shipment shipment, Model model) {
        model.addAttribute("shipmentTypes", shipmentTypeRepository.findAll());
        return "admin/shipments/add";
    }

    @PostMapping("/add")
    public String postAddForm(@PathVariable Long roasteryId, Shipment shipment) {
        shipmentRepository.save(shipment);
        Optional<Roastery> roastery = roasteryRepository.findById(roasteryId);
        List<Shipment> shipmentList = roastery.get().getShipments();
        shipmentList.add(shipment);
        roastery.get().setShipments(shipmentList);
        roasteryRepository.save(roastery.get());
        return "redirect:/admin/roasteries/edit/{roasteryId}";
    }

    @GetMapping("/edit/{id}")
    public String getEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("shipment", shipmentRepository.findById(id));
        return "admin/shipments/edit";
    }

    @PostMapping("edit/{id}")
    public String postEditForm(Shipment shipment) {
        shipmentRepository.save(shipment);
        return "redirect:/admin/roasteries/edit/{roasteryId}";
    }

    @RequestMapping("/confirm")
    public String confirm() {
        return "admin/shipments/confirm";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        shipmentRepository.deleteChild(id);
        shipmentRepository.deleteById(id);
        return "redirect:/admin/roasteries/edit/{roasteryId}";
    }

}
