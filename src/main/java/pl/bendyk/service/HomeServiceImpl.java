package pl.bendyk.service;

import org.springframework.stereotype.Service;
import pl.bendyk.model.coffee.Composition;
import pl.bendyk.model.coffee.Roast;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

    private final RoasteryService roasteryService;
    private final CountryService countryService;
    private final MethodService methodService;
    private final DepulpingProcessService depulpingProcessService;
    private final SpeciesService speciesService;
    private final VolumeService volumeService;
    private final ShipmentTypeService shipmentTypeService;

    public HomeServiceImpl(CoffeeService coffeeService, RoasteryService roasteryService, CountryService countryService,
                          MethodService methodService, DepulpingProcessService depulpingProcessService,
                          SpeciesService speciesService, VolumeService volumeService,
                          ShipmentTypeService shipmentTypeService) {
        this.roasteryService = roasteryService;
        this.countryService = countryService;
        this.methodService = methodService;
        this.depulpingProcessService = depulpingProcessService;
        this.speciesService = speciesService;
        this.volumeService = volumeService;
        this.shipmentTypeService = shipmentTypeService;
    }


    @Override
    public List<Long> roasteriesCheck(List<Long> ids) {
        if (ids == null) {
            return roasteryService.findRoasteriesIds();
        }
        return ids;
    }

    @Override
    public List<Long> countriesCheck(List<Long> ids) {
        if (ids == null) {
            return countryService.findCountriesIds();
        }
        return ids;
    }

    @Override
    public List<Long> methodsCheck(List<Long> ids) {
        if (ids == null) {
            return methodService.findMethodsIds();
        }
        return ids;
    }

    @Override
    public List<Integer> roastsCheck(List<Integer> roasts) {
        if (roasts == null) {
            List<Integer> ordinals = new ArrayList<>();
            for (Roast r : Roast.values()) {
                ordinals.add(r.ordinal());
            }
            return ordinals;
        }
        return roasts;
    }

    @Override
    public List<Long> depulpingProcessesCheck(List<Long> ids) {
        if (ids == null) {
            return depulpingProcessService.findDepulpingProcessesIds();
        }
        return ids;
    }

    @Override
    public List<Integer> compositionsCheck(List<Integer> compositions) {
        if (compositions == null) {
            List<Integer> ordinals = new ArrayList<>();
            for (Composition c : Composition.values()) {
                ordinals.add(c.ordinal());
            }
            return ordinals;
        }
        return compositions;
    }

    @Override
    public List<Long> speciesCheck(List<Long> ids) {
        if (ids == null) {
            return speciesService.findSpeciesIds();
        }
        return ids;
    }

    @Override
    public List<Long> volumesCheck(List<Long> ids) {
        if (ids == null) {
            return volumeService.findVolumesIds();
        }
        return ids;
    }

    @Override
    public List<Long> shipmentTypesCheck(List<Long> ids) {
        if (ids == null) {
            return shipmentTypeService.findShipmentTypesIds();
        }
        return ids;
    }

    @Override
    public List<String> citiesCheck(List<String> cities) {
        if (cities == null) {
            return roasteryService.findAllCities();
        }
        return cities;
    }
}
