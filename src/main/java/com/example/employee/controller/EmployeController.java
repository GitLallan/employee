package com.example.employee.controller;

import com.example.employee.entites.EmployeeEntity;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employees/e1")
public class EmployeController {
    @Autowired
    EmployeeService service;

    @GetMapping("/employee")
    public ResponseEntity<List<EmployeeEntity>> getByAllEmployeesRecords(){
      List<EmployeeEntity>employeeEntityList=service.getEmployeeByAll();
      return  new ResponseEntity<List<EmployeeEntity>>(employeeEntityList, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("id") Long id){
        EmployeeEntity employeeEntity=service.getEmployeeById(id);
        return new ResponseEntity<EmployeeEntity>(employeeEntity,new HttpHeaders(),HttpStatus.OK);

    }

    @PostMapping("/employee")
    public  ResponseEntity<EmployeeEntity> createByEmployees(@RequestBody EmployeeEntity entity){
        EmployeeEntity employeeEntity=service.createOrUpdateEmployee(entity);
        return new ResponseEntity<EmployeeEntity>(employeeEntity,new HttpHeaders(),HttpStatus.OK);
    }

    @DeleteMapping("/employee/{id}")
    public void deletesEmployeeById(@PathVariable("id") Long id ){
        service.deleteEmployeeById(id);
    }
}
