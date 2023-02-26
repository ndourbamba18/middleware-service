package com.ndourcodeur.employeebackendservice.service;

import com.ndourcodeur.employeebackendservice.entity.Employee;

import java.util.List;

/**
 * @author NdourCodeur
 * @since 23/02/2023
 * @version v1.0.0
 */
public interface EmployeeService {
    List<Employee> findAllEmployees();
    List<Employee> findEmployeesByDepartmentName(String departmentName);
    Employee findEmployeeById(Integer id);
    Employee addEmployee(Employee employee);
    void deleteEmployee(Integer id);
    public boolean existsById(Integer id);
    public boolean existsByEmail(String email);
}
