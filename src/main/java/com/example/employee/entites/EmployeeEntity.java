package com.example.employee.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@Getter
@AllArgsConstructor
@ToString
@Entity

public class EmployeeEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String department;
    private Integer salary;

    EmployeeEntity(){
    }
}
