package fon.bg.ac.rs.masterApp.dtos;

import fon.bg.ac.rs.masterApp.models.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class SupplierDto {


    private Integer id;

    private String fullName;
    private String phone;
    private String email;
    private String companyName;
    private String details;


//    @ManyToOne
//    @JoinColumn(name = "countryid", insertable = false, updatable = false)
//    private Country country;
//    private Integer countryid;


    private Location location;
    private Integer locationid;


}