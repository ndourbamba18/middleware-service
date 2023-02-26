package com.ndourcodeur.departmentbackendservice.service.impl;

import com.ndourcodeur.departmentbackendservice.entity.Department;
import com.ndourcodeur.departmentbackendservice.openfeign.EmployeeMiddlewareService;
import com.ndourcodeur.departmentbackendservice.payload.Employee;
import com.ndourcodeur.departmentbackendservice.repository.DepartmentRepository;
import com.ndourcodeur.departmentbackendservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("employeeService")
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMiddlewareService employeeMiddlewareService;
    private final DepartmentRepository departmentRepository;

    @Override
    public Map<String, Object> findDepartmentWithEmployees(String departmentName) {
        Map<String, Object> response = new HashMap<>();
        Department department = this.departmentRepository.findDepartmentByName(departmentName);
        if (department==null) {
            response.put("message", "Department does not exits with name:" + departmentName);
            return response;
        }
        response.put("Department", department);
        List<Employee> employees = this.employeeMiddlewareService.findEmployeesByDepartment(departmentName);
        if (employees.isEmpty())
            response.put("Employee", "Sorry, No Almost Content!");
        else
            response.put("Employee", employees);
        return response;
    }

    @Override
    public List<Employee> findAllEmployees() {
        //
        return this.employeeMiddlewareService.getAllEmployees();
    }

    @Override
    public Employee findEmployeeById(Integer id) {
        var employee = this.employeeMiddlewareService.getEmployeeById(id);
        return employee;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        var addEmployee = this.employeeMiddlewareService.saveNewEmployee(employee);
        return addEmployee;
    }

    @Override
    public void deleteEmployee(Integer id) {
        //
        this.employeeMiddlewareService.deleteEmployeeById(id);
    }
}
