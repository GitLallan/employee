package com.example.employee.service;

import com.example.employee.entites.EmployeeEntity;

import java.util.List;

public interface EmployeeService {

    public List<EmployeeEntity> getEmployeeByAll();

    public  EmployeeEntity  getEmployeeById(Long id);

    public  EmployeeEntity  createOrUpdateEmployee(EmployeeEntity entity);

    public  void  deleteEmployeeById(Long id);
}
