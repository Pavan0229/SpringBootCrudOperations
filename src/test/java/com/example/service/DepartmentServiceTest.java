package com.example.service;

import com.example.entity.Department;
import com.example.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departementName("IT")
                        .departmentAddress("Hyderabad")
                        .departmentCode("IT-06")
                        .departmentId(1L)
                        .build();

        Mockito.when(departmentRepository.findByDepartementNameIgnoreCase("IT"))
                .thenReturn(department);
    }

    @Test
    @DisplayName("Get Data based on valid Dapartment Name")
    public void whenValidDepartmentName_ThenDepartmentShouldFound(){
        String departName = "IT";
         Department found = departmentService.getByName(departName);

         assertEquals(departName,found.getDepartementName());
    }
}