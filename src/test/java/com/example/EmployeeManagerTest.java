package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;

class EmployeeManagerTest {
    BankService bankService = mock(BankService.class);
    EmployeeRepositoryMock employeeRepositoryMock = new EmployeeRepositoryMock();
    EmployeeManager employeeManager = new EmployeeManager(employeeRepositoryMock, bankService);


    @Test
    void payingEmployeesShouldReturnTwoEmployees() {
        var result = employeeManager.payEmployees();
        assertThat(result).isEqualTo(2);
    }


}