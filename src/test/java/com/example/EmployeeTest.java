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

    @Test
    void adding100ToSalaryShouldReturn200() {
        employee.setSalary(employee.getSalary() + 100);
        var result = employee.getSalary();
        assertThat(result).isEqualTo(200);
    }

    @Test
    void changingIdToTwoShouldReturn2() {
        employee.setId("2");
        var result = employee.getId();
        assertThat(result).isEqualTo("2");
    }

    @Test
    void settingIsPaidToTrueShouldReturnTrue() {
        employee.setPaid(true);
        var result = employee.isPaid();
        assertThat(result).isTrue();
    }

}
