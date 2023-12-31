package fon.bg.ac.rs.masterApp.dtos;

import fon.bg.ac.rs.masterApp.models.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class ClientDto {


    private int id;

    private String fullName;
//    private String surname;
    private String phone;
    private String email;
//    private String city;
//    private String address;
    private String details; //if someone owes something or similar...


//    @ManyToOne
//    @JoinColumn(name = "countryid", insertable = false, updatable = false)
//    private Country country;
//    private Integer countryid;


    private Location location;
    private Integer locationid;

    //maybe I won't need country for client, I am saving city and address for him
    //maybe country is too much

}
