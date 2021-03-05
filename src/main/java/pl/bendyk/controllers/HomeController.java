package pl.bendyk.controllers;

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
    public String home(Model model) {
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
            } else if (sort.equals("priceDesc")){
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


//    private List<Long> roasteriesCheck(List<Long> ids) {
//        if (ids == null) {
//            return coffeeRepository.findRoasteriesIds();
//        }
//        return ids;
//    }
//
//    private List<Long> countriesCheck(List<Long> ids) {
//        if (ids == null) {
//            return coffeeRepository.findCountriesIds();
//        }
//        return ids;
//    }
//
//    private List<Long> methodsCheck(List<Long> ids) {
//        if (ids == null) {
//            return coffeeRepository.findMethodsIds();
//        }
//        return ids;
//    }
//
//    private List<Integer> roastsCheck(List<Integer> roasts) {
//        if (roasts == null) {
//            List<Integer> ordinals = new ArrayList<>();
//            for (Roast r : Roast.values()) {
//                ordinals.add(r.ordinal());
//            }
//            return ordinals;
//        }
//        return roasts;
//    }
//
//    private List<Long> depulpingProcessesCheck(List<Long> ids) {
//        if (ids == null) {
//            return coffeeRepository.findDepulpingProcessesIds();
//        }
//        return ids;
//    }
//
//    private List<Integer> compositionsCheck(List<Integer> compositions) {
//        if (compositions == null) {
//            List<Integer> ordinals = new ArrayList<>();
//            for (Composition c : Composition.values()) {
//                ordinals.add(c.ordinal());
//            }
//            return ordinals;
//        }
//        return compositions;
//    }
//
//    private List<Long> speciesCheck(List<Long> ids) {
//        if (ids == null) {
//            return coffeeRepository.findSpeciesIds();
//        }
//        return ids;
//    }
//
//    private List<Long> volumesCheck(List<Long> ids) {
//        if (ids == null) {
//            return coffeeRepository.findVolumesIds();
//        }
//        return ids;
//    }
//
//    private List<Long> shipmentTypesCheck(List<Long> ids) {
//        if (ids == null) {
//            return coffeeRepository.findShipmentTypesIds();
//        }
//        return ids;
//    }
//
//    private List<String> citiesCheck(List<String> cities) {
//        if (cities == null) {
//            return roasteryRepository.findAllCitiesOrderByName();
//        }
//        return cities;
//    }





}



//model.addAttribute("coffees", testSortFilter(sort));
//        model.addAttribute("coffees", testRoasteryFilter(roasteriesIds));
//        model.addAttribute("coffees", testCountryFilter(countriesIds));
//        model.addAttribute("coffees", testMethodFilter(methodsIds));
//        model.addAttribute("coffees", testRoastFilter(roasts));
//        model.addAttribute("coffees", testDepulpingProcessFilter(depulpingProcessesIds));
//        model.addAttribute("coffees", testCompositionFilter(compositions));
//        model.addAttribute("coffees", testSpeciesFilter(speciesIds));
//        model.addAttribute("coffees", testVolumeFilter(volumesIds));
//        model.addAttribute("coffees", testShipmentTypeFilter(shipmentTypesIds));
//        model.addAttribute("coffees", testCityFilter(cities));
//
//    private List<Coffee> testSortFilter(String sort) {
//        if (sort != null) {
//            if (sort.equals("priceAsc")) {
//                return coffeeRepository.findAllByOrderByPriceAsc();
//            } else if (sort.equals("priceDesc")) {
//                return coffeeRepository.findAllByOrderByPriceDesc();
//            }
//        }
//        return coffeeRepository.findAll();
//    }
//
//    private List<Coffee> testRoasteryFilter(List<Long> roasteriesIds) {
//        if (roasteriesIds != null) {
//            return coffeeRepository.findAllByRoasteries(roasteriesIds);
//        }
//        return coffeeRepository.findAll();
//    }
//
//    private List<Coffee> testCountryFilter(List<Long> countriesIds) {
//        if (countriesIds != null) {
//            return coffeeRepository.findAllByCountries(countriesIds);
//        }
//        return coffeeRepository.findAll();
//    }
//
//    private List<Coffee> testMethodFilter(List<Long> methodsIds) {
//        if (methodsIds != null) {
//            return coffeeRepository.findAllByMethods(methodsIds);
//        }
//        return coffeeRepository.findAll();
//    }
//
//    private List<Coffee> testRoastFilter(List<Integer> roasts) {
//        if (roasts != null) {
//            return coffeeRepository.findAllByRoasts(roasts);
//        }
//        return coffeeRepository.findAll();
//    }
//
//    private List<Coffee> testDepulpingProcessFilter(List<Long> depulpingProcessesIds) {
//        if (depulpingProcessesIds != null) {
//            return coffeeRepository.findAllByDepulpingProcess(depulpingProcessesIds);
//        }
//        return coffeeRepository.findAll();
//    }
//
//    private List<Coffee> testCompositionFilter(List<Integer> compositions) {
//        if (compositions != null) {
//            return coffeeRepository.findAllByCompositions(compositions);
//        }
//        return coffeeRepository.findAll();
//    }
//
//    private List<Coffee> testSpeciesFilter(List<Long> speciesIds) {
//        if (speciesIds != null) {
//            return coffeeRepository.findAllBySpecies(speciesIds);
//        }
//        return coffeeRepository.findAll();
//    }
//
//    private List<Coffee> testVolumeFilter(List<Long> volumesIds) {
//        if (volumesIds != null) {
//            return coffeeRepository.findAllByVolumes(volumesIds);
//        }
//        return coffeeRepository.findAll();
//    }
//
//    private List<Coffee> testShipmentTypeFilter(List<Long> shipmentTypesIds) {
//        if (shipmentTypesIds != null) {
//            return coffeeRepository.findAllByShipmentType(shipmentTypesIds);
//        }
//        return coffeeRepository.findAll();
//    }
//
//    private List<Coffee> testCityFilter(List<String> cities) {
//        if (cities != null) {
//            return coffeeRepository.findAllByCity(cities);
//        }
//        return coffeeRepository.findAll();
//    }