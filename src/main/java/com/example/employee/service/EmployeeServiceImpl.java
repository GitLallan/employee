package com.example.employee.service;

import com.example.employee.entites.EmployeeEntity;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements  EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeEntity> getEmployeeByAll() {
        List<EmployeeEntity> employeeEntityList=employeeRepository.findAll();
        if(employeeEntityList.size()>0){
            return employeeEntityList;
        }
        return new ArrayList<EmployeeEntity>();
    }

    @Override
    public EmployeeEntity getEmployeeById(Long id) {
        Optional<EmployeeEntity> employeeEntity=employeeRepository.findById(id);
        if (employeeEntity.isPresent()){
            return employeeEntity.get();
        }
        return null;
    }

    @Override
    public EmployeeEntity createOrUpdateEmployee(EmployeeEntity entity) {
      Optional<EmployeeEntity> optionalEmployeeEntity=employeeRepository.findById(entity.getId());
        if (optionalEmployeeEntity.isPresent()){
            EmployeeEntity newemployeeEntity= optionalEmployeeEntity.get();
            newemployeeEntity.setName(entity.getName());
            newemployeeEntity.setDepartment(entity.getDepartment());
            newemployeeEntity.setSalary(entity.getSalary());
            newemployeeEntity=employeeRepository.save(newemployeeEntity);

            return newemployeeEntity;
        }else
            entity=employeeRepository.save(entity);
        return  entity;
    }

    @Override
    public void deleteEmployeeById(Long id) {
        Optional<EmployeeEntity> employeeEntity=employeeRepository.findById(id);
        if (employeeEntity.isPresent()){
            employeeRepository.deleteById(id);
        }
    }
}
