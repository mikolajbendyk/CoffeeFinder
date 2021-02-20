package pl.bendyk.controllers.admin;

import org.hibernate.cfg.FkSecondPass;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.bendyk.model.coffee.Flavour;
import pl.bendyk.model.others.Country;
import pl.bendyk.repository.CountryRepository;
import pl.bendyk.repository.FlavourRepository;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin/flavours")
public class FlavourController {

    private final FlavourRepository flavourRepository;

    public FlavourController(FlavourRepository flavourRepository) {
        this.flavourRepository = flavourRepository;
    }

    @RequestMapping("/all")
    public String all(Model model) {
        List<Flavour> flavours = flavourRepository.findAllByOrderByName();
        model.addAttribute("flavours", flavours);
        return "admin/flavours/showAll";
    }

    @GetMapping("/add")
    public String getAddForm(Flavour flavour) {
        return "admin/flavours/add";
    }

    @PostMapping("/add")
    public String postAddForm(Flavour flavour) {
        flavourRepository.save(flavour);
        return "redirect:/admin/flavours/all";
    }

    @GetMapping("/edit/{id}")
    public String getEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("flavour", flavourRepository.findById(id));
        return "admin/flavours/edit";
    }

    @PostMapping("edit/{id}")
    public String postEditForm(Flavour flavour) {
        flavourRepository.save(flavour);
        return "redirect:/admin/flavours/all";
    }

    @RequestMapping("/confirm")
    public String confirm() {
        return "admin/flavours/confirm";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        flavourRepository.deleteById(id);
        return "redirect:/admin/flavours/all";
    }

}
