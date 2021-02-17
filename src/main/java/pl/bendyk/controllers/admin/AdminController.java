package pl.bendyk.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping
    public String admin() {
        return "admin/admin";
    }

    @RequestMapping("/coffees")
    public String coffees() {
        return "admin/coffees/showAll";
    }

    @RequestMapping("/roasteries")
    public String roasteries() {
        return "admin/roasteries/showAll";
    }

    @RequestMapping("/countries")
    public String countries() {
        return "admin/countries/showAll";
    }

    @RequestMapping("/species")
    public String species() {
        return "admin/species/showAll";
    }

    @RequestMapping("/methods")
    public String methods() {
        return "admin/methods/showAll";
    }

    @RequestMapping("/flavours")
    public String flavours() {
        return "admin/flavours/showAll";
    }

    @RequestMapping("/volumes")
    public String volumes() {
        return "admin/volumes/showAll";
    }

    @RequestMapping("/shipments")
    public String shipments() {
        return "admin/shipments/showAll";
    }
}
