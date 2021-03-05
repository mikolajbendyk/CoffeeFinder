package pl.bendyk.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.bendyk.model.coffee.Composition;
import pl.bendyk.model.coffee.Roast;
import pl.bendyk.repository.*;
import pl.bendyk.service.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private final HomeService homeService;
    private final CoffeeService coffeeService;
    private final RoasteryService roasteryService;
    private final CountryService countryService;
    private final MethodService methodService;
    private final DepulpingProcessService depulpingProcessService;
    private final SpeciesService speciesService;
    private final VolumeService volumeService;
    private final ShipmentTypeService shipmentTypeService;

    public HomeController(HomeService homeService, CoffeeService coffeeService, RoasteryService roasteryService,
                          CountryService countryService, MethodService methodService,
                          DepulpingProcessService depulpingProcessService, SpeciesService speciesService,
                          VolumeService volumeService, ShipmentTypeService shipmentTypeService) {
        this.homeService = homeService;
        this.coffeeService = coffeeService;
        this.roasteryService = roasteryService;
        this.countryService = countryService;
        this.methodService = methodService;
        this.depulpingProcessService = depulpingProcessService;
        this.speciesService = speciesService;
        this.volumeService = volumeService;
        this.shipmentTypeService = shipmentTypeService;
    }

    @RequestMapping("/")
    public String home(Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        model.addAttribute("coffees", coffeeService.findAllActive());
        model.addAttribute("roasteries", roasteryService.findAll());
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("methods", methodService.findAll());
        model.addAttribute("roasts", Roast.values());
        model.addAttribute("depulpingProcesses", depulpingProcessService.findAll());
        model.addAttribute("compositions", Composition.values());
        model.addAttribute("species", speciesService.findAll());
        model.addAttribute("volumes", volumeService.findAll());
        model.addAttribute("shipmentTypes", shipmentTypeService.findAll());
        model.addAttribute("cities", roasteryService.findAllCities());
//        model.addAttribute("user", currentUser.getUser().getUsername());
        return "home/coffees/showAll";
    }

    @GetMapping("/")
    public String getFilters(Model model,
                             @RequestParam(required = false) String sort,
                             @RequestParam(required = false) List<Long> roasteriesIds,
                             @RequestParam(required = false) List<Long> countriesIds,
                             @RequestParam(required = false) List<Long> methodsIds,
                             @RequestParam(required = false) List<Integer> roasts,
                             @RequestParam(required = false) List<Long> depulpingProcessesIds,
                             @RequestParam(required = false) List<Integer> compositions,
                             @RequestParam(required = false) List<Long> speciesIds,
                             @RequestParam(required = false) List<Long> volumesIds,
                             @RequestParam(required = false) List<Long> shipmentTypesIds,
                             @RequestParam(required = false) List<String> cities
    ) {
        model.addAttribute("roasteries", roasteryService.findAll());
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("methods", methodService.findAll());
        model.addAttribute("roasts", Roast.values());
        model.addAttribute("depulpingProcesses", depulpingProcessService.findAll());
        model.addAttribute("compositions", Composition.values());
        model.addAttribute("species", speciesService.findAll());
        model.addAttribute("volumes", volumeService.findAll());
        model.addAttribute("shipmentTypes", shipmentTypeService.findAll());
        model.addAttribute("cities", roasteryService.findAllCities());

        if (sort != null) {
            if (sort.equals("priceAsc")) {
                model.addAttribute("coffees", coffeeService.findFilteredSortedAsc(
                        homeService.roasteriesCheck(roasteriesIds),
                        homeService.countriesCheck(countriesIds),
                        homeService.methodsCheck(methodsIds),
                        homeService.roastsCheck(roasts),
                        homeService.depulpingProcessesCheck(depulpingProcessesIds),
                        homeService.compositionsCheck(compositions),
                        homeService.speciesCheck(speciesIds),
                        homeService.volumesCheck(volumesIds),
                        homeService.shipmentTypesCheck(shipmentTypesIds),
                        homeService.citiesCheck(cities)
                ));
            } else if (sort.equals("priceDesc")) {
                model.addAttribute("coffees", coffeeService.findFilteredSortedDesc(
                        homeService.roasteriesCheck(roasteriesIds),
                        homeService.countriesCheck(countriesIds),
                        homeService.methodsCheck(methodsIds),
                        homeService.roastsCheck(roasts),
                        homeService.depulpingProcessesCheck(depulpingProcessesIds),
                        homeService.compositionsCheck(compositions),
                        homeService.speciesCheck(speciesIds),
                        homeService.volumesCheck(volumesIds),
                        homeService.shipmentTypesCheck(shipmentTypesIds),
                        homeService.citiesCheck(cities)
                ));
            }
        } else {
            model.addAttribute("coffees", coffeeService.findFiltered(
                    homeService.roasteriesCheck(roasteriesIds),
                    homeService.countriesCheck(countriesIds),
                    homeService.methodsCheck(methodsIds),
                    homeService.roastsCheck(roasts),
                    homeService.depulpingProcessesCheck(depulpingProcessesIds),
                    homeService.compositionsCheck(compositions),
                    homeService.speciesCheck(speciesIds),
                    homeService.volumesCheck(volumesIds),
                    homeService.shipmentTypesCheck(shipmentTypesIds),
                    homeService.citiesCheck(cities)
            ));
        }
        return "home/coffees/showAll";
    }
}