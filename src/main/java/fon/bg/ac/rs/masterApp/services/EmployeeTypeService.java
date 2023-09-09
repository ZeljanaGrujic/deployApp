package fon.bg.ac.rs.masterApp.services;

import fon.bg.ac.rs.masterApp.dtos.EmployeeTypeDto;

import java.util.List;

public interface EmployeeTypeService {
    List<EmployeeTypeDto> getEmployeeTypes();

    EmployeeTypeDto saveEmployeeType(EmployeeTypeDto employeeType);

    EmployeeTypeDto findById(int id);

    void deleteById(int id);
}
