package fon.bg.ac.rs.masterApp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class ContactDto {


    private int id;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
//    private String mobile;
    private String remarks;
}
