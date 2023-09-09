package fon.bg.ac.rs.masterApp.controllers;

import fon.bg.ac.rs.masterApp.dtos.EmployeeTypeDto;
import fon.bg.ac.rs.masterApp.servicesImpl.EmployeeTypeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class EmployeeTypeControllerTests {

    @Mock
    private EmployeeTypeServiceImpl employeeTypeService;

    @Mock
    private Model model;

    @InjectMocks
    private EmployeeTypeController employeeTypeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetEmployeeTypes() {
        List<EmployeeTypeDto> employeeTypes = new ArrayList<>();
        EmployeeTypeDto employeeTypeDto= new EmployeeTypeDto();
        employeeTypeDto.setId(1);
        employeeTypeDto.setDetails("Detalji 1");
        employeeTypeDto.setDescription("Opis 1");
        employeeTypes.add(employeeTypeDto);
        when(employeeTypeService.getEmployeeTypes()).thenReturn(employeeTypes);

        String viewName = employeeTypeController.getEmployeeTypes(model);
        assertEquals("EmployeeType", viewName);
        verify(model, times(2)).addAttribute(eq("employeeTypes"), eq(employeeTypes));
    }

    @Test
    void testAddNew() {
        EmployeeTypeDto employeeType = new EmployeeTypeDto();
        when(employeeTypeService.saveEmployeeType(employeeType)).thenReturn(employeeType);

        String viewName = employeeTypeController.addBew(employeeType);
        assertEquals("redirect:/employeeTypes", viewName);
        verify(employeeTypeService, times(1)).saveEmployeeType(employeeType);
    }

    @Test
    void testFindById() {
        int id = 1;
        EmployeeTypeDto employeeType = new EmployeeTypeDto();
        when(employeeTypeService.findById(id)).thenReturn(employeeType);

        EmployeeTypeDto result = employeeTypeController.findById(id);
        assertEquals(employeeType, result);
        verify(employeeTypeService, times(2)).findById(id);
    }

    @Test
    void testUpdate() {
        EmployeeTypeDto employeeType = new EmployeeTypeDto();
        when(employeeTypeService.saveEmployeeType(employeeType)).thenReturn(employeeType);

        String viewName = employeeTypeController.update(employeeType);
        assertEquals("redirect:/employeeTypes", viewName);
        verify(employeeTypeService, times(1)).saveEmployeeType(employeeType);
    }

    @Test
    void testDeleteById() {
        int id = 1;

        String viewName = employeeTypeController.deleteById(id);
        assertEquals("EmployeeTypeDeleteError", viewName);
        verify(employeeTypeService, times(0)).deleteById(id);
    }
}