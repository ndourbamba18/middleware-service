package com.ndourcodeur.employeebackendservice.service.impl;

import com.ndourcodeur.employeebackendservice.entity.Employee;
import com.ndourcodeur.employeebackendservice.repository.EmployeeRepository;
import com.ndourcodeur.employeebackendservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author NdourCodeur
 * @since 23/02/2023
 * @version v1.0.0
 */
@Service("departmentService")
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAllEmployees() {
        log.info("Finding all Employees Inside Employee Service");
        var employeeList = this.employeeRepository.findAll();
        return employeeList;
    }

    @Override
    public List<Employee> findEmployeesByDepartmentName(String departmentName) {
        log.info("Checking and Finding Department's Name Inside Employee Service");
        var list = this.employeeRepository.findEmployeesByDepartmentName(departmentName);
        return list;
    }

    @Override
    public Employee findEmployeeById(Integer id) {
        log.info("Checking and Finding Employee's ID Inside Employee Service");
        var findEmployee = this.employeeRepository.findById(id);
        return findEmployee;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        log.info("Saving new Employee Inside Employee Service");
        this.employeeRepository.save(employee);
        return employee;
    }

    @Override
    public void deleteEmployee(Integer id) {
        log.info("Checking and Deleting Employee by ID Inside Employee Service");
        this.employeeRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        log.info("Checking Employee's ID Inside Employee Service");
        return this.employeeRepository.existsById(id);
    }

    @Override
    public boolean existsByEmail(String email) {
        log.info("Checking Employee's Email Inside Employee Service");
        return this.employeeRepository.existsByEmail(email);
    }
}
