package com.ifreann.employeemanager.service;

import com.ifreann.employeemanager.exception.UserNotFoundException;
import com.ifreann.employeemanager.model.Employee;
import com.ifreann.employeemanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(final Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return this.employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return this.employeeRepo.findAll();
    }

    public Employee updateEmployee (final Employee employee){
        return this.employeeRepo.save(employee);
    }

    public void deleteEmployee (final Long id){
        this.employeeRepo.deleteEmployeeById(id);
    }

    public Employee findEmployeeById(final Long id) {
        return this.employeeRepo.findEmployeeById(id)
                .orElseThrow(()-> new UserNotFoundException("User by ID " + id + " was not found"));
    }

    public List<Long> addAllEmployees(final List<Employee> employees) {
        employees.forEach(employee -> employee.setEmployeeCode(UUID.randomUUID().toString()));
        return this.employeeRepo.saveAll(employees).stream().map(Employee::getId).collect(Collectors.toList());
    }
}
