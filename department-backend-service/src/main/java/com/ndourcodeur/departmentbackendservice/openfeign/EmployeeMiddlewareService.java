package com.ndourcodeur.departmentbackendservice.openfeign;

import com.ndourcodeur.departmentbackendservice.payload.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
        name = "employee-service",
        url = "http://localhost:8082",
        path = "/api/v1/employees"
)
public interface EmployeeMiddlewareService {

    @GetMapping()
    public List<Employee> getAllEmployees();

    @GetMapping(path = "/{id}")
    public Employee getEmployeeById(@PathVariable("id") Integer id);

    @PostMapping()
    public Employee saveNewEmployee(@RequestBody Employee employee);

    @DeleteMapping(path = "/{id}")
    public Employee deleteEmployeeById(@PathVariable("id") Integer id);

    @GetMapping(path = "/byDepartmentName/{departmentName}")
    public List<Employee> findEmployeesByDepartment(@PathVariable("departmentName") String departmentName);

}
