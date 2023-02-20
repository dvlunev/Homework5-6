package hw56.dao;

import hw56.model.City;

import java.util.List;
import java.util.Optional;

public interface CityDao {
    void createOrUpdateCity(City city);
    Optional<City> getCityById(long id);
    List<City> getAllCityList();
    void deleteCity(City city);
    Optional<City> findById(long id);
}
