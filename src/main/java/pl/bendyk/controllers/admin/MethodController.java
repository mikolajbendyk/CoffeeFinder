package pl.bendyk.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.bendyk.model.coffee.Method;
import pl.bendyk.repository.MethodRepository;

import java.util.List;

@Controller
@RequestMapping("/admin/methods")
public class MethodController {

    private final MethodRepository methodRepository;

    public MethodController(MethodRepository methodRepository) {
        this.methodRepository = methodRepository;
    }

    @RequestMapping("/all")
    public String all(Model model) {
        List<Method> methods = methodRepository.findAll();
        model.addAttribute("methods", methods);
        return "admin/methods/showAll";
    }

    @GetMapping("/add")
    public String getAddForm(Method method) {
        return "admin/methods/add";
    }

    @PostMapping("/add")
    public String postAddForm(Method method) {
        methodRepository.save(method);
        return "redirect:/admin/methods/all";
    }

    @GetMapping("/edit/{id}")
    public String getEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("method", methodRepository.findById(id));
        return "admin/methods/edit";
    }

    @PostMapping("edit/{id}")
    public String postEditForm(Method method) {
        methodRepository.save(method);
        return "redirect:/admin/methods/all";
    }

    @RequestMapping("/confirm")
    public String confirm() {
        return "admin/methods/confirm";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        methodRepository.deleteById(id);
        return "redirect:/admin/methods/all";
    }

}
