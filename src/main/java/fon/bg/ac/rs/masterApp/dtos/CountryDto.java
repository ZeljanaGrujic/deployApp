package fon.bg.ac.rs.masterApp.dtos;

import fon.bg.ac.rs.masterApp.models.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class CountryDto {


    private Integer id;
    private String code;
    private String name;
    private String capital;

    private List<Location> locations;


    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                '}';
    }
}
