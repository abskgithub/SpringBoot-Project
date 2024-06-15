package com.SpringProject.P1.SBProject.services;


import com.SpringProject.P1.SBProject.dto.EmployeeDTO;
import com.SpringProject.P1.SBProject.entities.EmployeeEntity;
import com.SpringProject.P1.SBProject.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class EmployeeService {


        final EmployeeRepository employeeRepository;
        final ModelMapper modelMapper;

        public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper){

            this.employeeRepository = employeeRepository;
            this.modelMapper = modelMapper;

        }

        public EmployeeDTO getEmployeeById(Long id){
            EmployeeEntity employeeEntity = employeeRepository.getById(id);
            return modelMapper.map(employeeEntity , EmployeeDTO.class);
            }

        public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO){
            EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
            return modelMapper.map( employeeRepository.save(employeeEntity), EmployeeDTO.class);
        }


    public List<EmployeeDTO> getAllEmployees() {

        List<EmployeeDTO> list =  new ArrayList<>();
        for(EmployeeEntity employeeEntity : employeeRepository.findAll())
        {
            EmployeeDTO map = modelMapper.map(employeeEntity, EmployeeDTO.class);
            list.add(map);
        }
        return list;
//         return employeeRepository.
//         findAll().stream().map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class))
//         .collect(Collectors.toList());
    }

    public boolean deleteEmployeeById(Long employeeId) {

            boolean isPresent = employeeRepository.existsById(employeeId);
            if(!isPresent) return false;
            employeeRepository.deleteById(employeeId);
            return true;
    }
}
