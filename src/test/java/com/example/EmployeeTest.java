package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class EmployeeTest {

    Employee employee = new Employee("1", 100);

    @Test
    void ensureToStringIsEquivalent() {
        var result = employee.toString();
        assertThat(result).isEqualTo("Employee [id=" + employee.getId() + ", salary=" + employee.getSalary() + "]");
    }


}
