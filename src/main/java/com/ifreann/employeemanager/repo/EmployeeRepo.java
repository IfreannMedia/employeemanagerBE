package com.ifreann.employeemanager.repo;

import com.ifreann.employeemanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// our extension of the JpaRepo, of type Employee with primary key type Long (id property from Employee.java class)
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
//    our "custom" method to delete by id, spring will interpret the method name + signature
//    and automaticallly generate the appropriate query for us
    void deleteEmployeeById(Long id);

//    another query method for finding
    Optional<Employee> findEmployeeById(Long id);
}
