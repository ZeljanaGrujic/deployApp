package fon.bg.ac.rs.masterApp.dtos;


import fon.bg.ac.rs.masterApp.models.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import jakarta.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class LocationDto {


    private Integer id;
    private String city;
    private String address;
    private String details;

    private Country country;
    private Integer countryid;
}
