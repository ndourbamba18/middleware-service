package com.ndourcodeur.departmentbackendservice.service;

import com.ndourcodeur.departmentbackendservice.payload.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    public Map<String, Object> findDepartmentWithEmployees(String departmentName);
    List<Employee> findAllEmployees();
    Employee findEmployeeById(Integer id);
    Employee addEmployee(Employee employee);
    void deleteEmployee(Integer id);
}
