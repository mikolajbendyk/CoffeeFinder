package pl.bendyk.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.bendyk.model.coffee.Volume;
import pl.bendyk.repository.VolumeRepository;

import java.util.List;

@Controller
@RequestMapping("/admin/volumes")
public class VolumeController {

    private final VolumeRepository volumeRepository;

    public VolumeController(VolumeRepository volumeRepository) {
        this.volumeRepository = volumeRepository;
    }

    @RequestMapping("/all")
    public String all(Model model) {
        List<Volume> volumes = volumeRepository.findAll();
        model.addAttribute("volumes", volumes);
        return "admin/volumes/showAll";
    }

    @GetMapping("/add")
    public String getAddForm(Volume volume) {
        return "admin/volumes/add";
    }

    @PostMapping("/add")
    public String postAddForm(Volume volume) {
        volumeRepository.save(volume);
        return "redirect:/admin/volumes/all";
    }

    @GetMapping("/edit/{id}")
    public String getEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("volumes", volumeRepository.findById(id));
        return "admin/volumes/edit";
    }

    @PostMapping("edit/{id}")
    public String postEditForm(Volume volume) {
        volumeRepository.save(volume);
        return "redirect:/admin/volumes/all";
    }

    @RequestMapping("/confirm")
    public String confirm() {
        return "admin/volumes/confirm";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        volumeRepository.deleteById(id);
        return "redirect:/admin/volumes/all";
    }

}
