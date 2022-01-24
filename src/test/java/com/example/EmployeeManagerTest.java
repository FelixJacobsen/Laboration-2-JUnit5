package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
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

    @Test
    void throwingARuntimeExceptionShouldSetIsPaidToFalse() {
        doThrow(RuntimeException.class).when(bankService).pay(anyString(), anyDouble());
        employeeManager.payEmployees();
        assertThat(employeeRepositoryMock.findAll().get(0).isPaid()).isFalse();
    }

}