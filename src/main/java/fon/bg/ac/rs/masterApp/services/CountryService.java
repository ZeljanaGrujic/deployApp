package fon.bg.ac.rs.masterApp.services;

import fon.bg.ac.rs.masterApp.dtos.CountryDto;

import java.util.List;

public interface CountryService {

    public List<CountryDto> getCountries();
    public CountryDto saveCountry(CountryDto country);

    public CountryDto findById(int id);

    public void deleteById(int id);
}
