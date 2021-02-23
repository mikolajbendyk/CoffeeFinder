package pl.bendyk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.bendyk.model.coffee.Composition;
import pl.bendyk.model.coffee.Roast;
import pl.bendyk.repository.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private final CoffeeRepository coffeeRepository;
    private final RoasteryRepository roasteryRepository;
    private final CountryRepository countryRepository;
    private final MethodRepository methodRepository;
    private final DepulpingProcessRepository depulpingProcessRepository;
    private final SpeciesRepository speciesRepository;
    private final VolumeRepository volumeRepository;
    private final ShipmentTypeRepository shipmentTypeRepository;

    public HomeController(CoffeeRepository coffeeRepository,
                          RoasteryRepository roasteryRepository,
                          CountryRepository countryRepository,
                          MethodRepository methodRepository,
                          DepulpingProcessRepository depulpingProcessRepository,
                          SpeciesRepository speciesRepository,
                          VolumeRepository volumeRepository,
                          ShipmentTypeRepository shipmentTypeRepository) {
        this.coffeeRepository = coffeeRepository;
        this.roasteryRepository = roasteryRepository;
        this.countryRepository = countryRepository;
        this.methodRepository = methodRepository;
        this.depulpingProcessRepository = depulpingProcessRepository;
        this.speciesRepository = speciesRepository;
        this.volumeRepository = volumeRepository;
        this.shipmentTypeRepository = shipmentTypeRepository;
    }

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("coffees", coffeeRepository.findAllByActiveTrue());
        model.addAttribute("roasteries", roasteryRepository.findAllByOrderByName());
        model.addAttribute("countries", countryRepository.findAllByOrderByName());
        model.addAttribute("methods", methodRepository.findAllByOrderByName());
        model.addAttribute("roasts", Roast.values());
        model.addAttribute("depulpingProcesses", depulpingProcessRepository.findAllByOrderByName());
        model.addAttribute("compositions", Composition.values());
        model.addAttribute("species", speciesRepository.findAllByOrderByName());
        model.addAttribute("volumes", volumeRepository.findAllByOrderByGrams());
        model.addAttribute("shipmentTypes", shipmentTypeRepository.findAllByOrderByName());
        model.addAttribute("cities", roasteryRepository.findAllCitiesOrderByName());
        return "home/coffees/showAll";
    }

    @PostMapping("/")
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
        model.addAttribute("roasteries", roasteryRepository.findAllByOrderByName());
        model.addAttribute("countries", countryRepository.findAllByOrderByName());
        model.addAttribute("methods", methodRepository.findAllByOrderByName());
        model.addAttribute("roasts", Roast.values());
        model.addAttribute("depulpingProcesses", depulpingProcessRepository.findAllByOrderByName());
        model.addAttribute("compositions", Composition.values());
        model.addAttribute("species", speciesRepository.findAllByOrderByName());
        model.addAttribute("volumes", volumeRepository.findAllByOrderByGrams());
        model.addAttribute("shipmentTypes", shipmentTypeRepository.findAllByOrderByName());
        model.addAttribute("cities", roasteryRepository.findAllCitiesOrderByName());

        if (sort != null) {
            if (sort.equals("priceAsc")) {
                model.addAttribute("coffees", coffeeRepository.findFilteredSortedAsc(
                        roasteriesCheck(roasteriesIds),
                        countriesCheck(countriesIds),
                        methodsCheck(methodsIds),
                        roastsCheck(roasts),
                        depulpingProcessesCheck(depulpingProcessesIds),
                        compositionsCheck(compositions),
                        speciesCheck(speciesIds),
                        volumesCheck(volumesIds),
                        shipmentTypesCheck(shipmentTypesIds),
                        citiesCheck(cities)
                ));
            } else if (sort.equals("priceDesc")){
                model.addAttribute("coffees", coffeeRepository.findFilteredSortedDesc(
                        roasteriesCheck(roasteriesIds),
                        countriesCheck(countriesIds),
                        methodsCheck(methodsIds),
                        roastsCheck(roasts),
                        depulpingProcessesCheck(depulpingProcessesIds),
                        compositionsCheck(compositions),
                        speciesCheck(speciesIds),
                        volumesCheck(volumesIds),
                        shipmentTypesCheck(shipmentTypesIds),
                        citiesCheck(cities)
                ));
            }
        } else {
            model.addAttribute("coffees", coffeeRepository.findFiltered(
                    roasteriesCheck(roasteriesIds),
                    countriesCheck(countriesIds),
                    methodsCheck(methodsIds),
                    roastsCheck(roasts),
                    depulpingProcessesCheck(depulpingProcessesIds),
                    compositionsCheck(compositions),
                    speciesCheck(speciesIds),
                    volumesCheck(volumesIds),
                    shipmentTypesCheck(shipmentTypesIds),
                    citiesCheck(cities)
            ));
        }

        return "home/coffees/showFiltered";
    }


    private List<Long> roasteriesCheck(List<Long> ids) {
        if (ids == null) {
            return coffeeRepository.findRoasteriesIds();
        }
        return ids;
    }

    private List<Long> countriesCheck(List<Long> ids) {
        if (ids == null) {
            return coffeeRepository.findCountriesIds();
        }
        return ids;
    }

    private List<Long> methodsCheck(List<Long> ids) {
        if (ids == null) {
            return coffeeRepository.findMethodsIds();
        }
        return ids;
    }

    private List<Integer> roastsCheck(List<Integer> roasts) {
        if (roasts == null) {
            List<Integer> ordinals = new ArrayList<>();
            for (Roast r : Roast.values()) {
                ordinals.add(r.ordinal());
            }
            return ordinals;
        }
        return roasts;
    }

    private List<Long> depulpingProcessesCheck(List<Long> ids) {
        if (ids == null) {
            return coffeeRepository.findDepulpingProcessesIds();
        }
        return ids;
    }

    private List<Integer> compositionsCheck(List<Integer> compositions) {
        if (compositions == null) {
            List<Integer> ordinals = new ArrayList<>();
            for (Composition c : Composition.values()) {
                ordinals.add(c.ordinal());
            }
            return ordinals;
        }
        return compositions;
    }

    private List<Long> speciesCheck(List<Long> ids) {
        if (ids == null) {
            return coffeeRepository.findSpeciesIds();
        }
        return ids;
    }

    private List<Long> volumesCheck(List<Long> ids) {
        if (ids == null) {
            return coffeeRepository.findVolumesIds();
        }
        return ids;
    }

    private List<Long> shipmentTypesCheck(List<Long> ids) {
        if (ids == null) {
            return coffeeRepository.findShipmentTypesIds();
        }
        return ids;
    }

    private List<String> citiesCheck(List<String> cities) {
        if (cities == null) {
            return roasteryRepository.findAllCitiesOrderByName();
        }
        return cities;
    }





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