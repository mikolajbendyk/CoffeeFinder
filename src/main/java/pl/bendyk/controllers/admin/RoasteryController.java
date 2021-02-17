package pl.bendyk.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.bendyk.model.others.Roastery;
import pl.bendyk.repository.RoasteryRepository;


import java.util.List;

@Controller
@RequestMapping("/roasteries")
public class RoasteryController {

    private final RoasteryRepository roasteryRepository;

    public RoasteryController(RoasteryRepository roasteryRepository) {
        this.roasteryRepository = roasteryRepository;
    }

    @GetMapping("/all")
    public String showAll(Model model) {
        List<Roastery> roasteries = roasteryRepository.findAll();
        model.addAttribute("roasteries", roasteries);
        return "/all";
    }

    @GetMapping("/add")
    public String getAddForm(Roastery roastery) {
        return "/add";
    }

    @PostMapping("/add")
    public String postAddForm(Roastery roastery) {
        roasteryRepository.save(roastery);
        return "showAll";
    }

    @GetMapping("/edit/{id")
    public String getEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("roastery", roasteryRepository.findById(id));
        return "/edit";
    }

    @PostMapping("edit/{id}")
    public String postEditForm(Roastery roastery) {
        roasteryRepository.save(roastery);
        return "showAll";
    }

    @RequestMapping("/confirm")
    public String confirm() {
        return "/confirm";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        roasteryRepository.deleteById(id);
        return "showAll";
    }
}
