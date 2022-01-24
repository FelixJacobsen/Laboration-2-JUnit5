package com.example;

import java.util.List;

public class EmployeeRepositoryMock implements  EmployeeRepository{

    @Override
    public List<Employee> findAll() {
        return List.of(new Employee("1",50000),new Employee("2",25000));
    }

    @Override
    public Employee save(Employee e) {
        return null;
    }
}
