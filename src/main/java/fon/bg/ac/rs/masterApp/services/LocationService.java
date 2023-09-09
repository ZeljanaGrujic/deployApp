package fon.bg.ac.rs.masterApp.services;

import fon.bg.ac.rs.masterApp.dtos.LocationDto;

import java.util.List;

public interface LocationService {
    List<LocationDto> getLocations();

    LocationDto saveLocation(LocationDto location);

    LocationDto findById(int id);

    void deleteById(int id);

   List<LocationDto> findByCountryid(int id);
}
