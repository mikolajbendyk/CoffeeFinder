package pl.bendyk.service;

import java.util.List;

public interface HomeService {

    List<Long> roasteriesCheck(List<Long> ids);
    List<Long> countriesCheck(List<Long> ids);
    List<Long> methodsCheck(List<Long> ids);
    List<Integer> roastsCheck(List<Integer> roasts);
    List<Long> depulpingProcessesCheck(List<Long> ids);
    List<Integer> compositionsCheck(List<Integer> compositions);
    List<Long> speciesCheck(List<Long> ids);
    List<Long> volumesCheck(List<Long> ids);
    List<Long> shipmentTypesCheck(List<Long> ids);
    List<String> citiesCheck(List<String> cities);

}
