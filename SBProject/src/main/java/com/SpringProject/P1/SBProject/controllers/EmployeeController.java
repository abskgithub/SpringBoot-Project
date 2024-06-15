package com.SpringProject.P1.SBProject.controllers;


//Operations
//GET /employees
//POST /employees
//DELETE /employees {id}


import com.SpringProject.P1.SBProject.dto.EmployeeDTO;
import com.SpringProject.P1.SBProject.services.EmployeeService;
import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.time.LocalDate;

@RestController
@RequestMapping (path = "employees")

public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){

        this.employeeService = employeeService;

    }

    @GetMapping (path = "/{id}")

    public EmployeeDTO getEmployeeById(@PathVariable ("id") Long employeeId ){
        return employeeService.getEmployeeById(employeeId);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }


    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.createNewEmployee(employeeDTO);
    }

    @DeleteMapping (path = "/{id}")
    public boolean deleteEmployeeById(@PathVariable ("id")  Long employeeId){

        return employeeService.deleteEmployeeById(employeeId);

    }


}
