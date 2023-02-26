package com.ndourcodeur.employeebackendservice.web;

import com.ndourcodeur.employeebackendservice.entity.Employee;
import com.ndourcodeur.employeebackendservice.message.Message;
import com.ndourcodeur.employeebackendservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * @author NdourCodeur
 * @since 23/02/2023
 * @version v1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    /**
     * @url ===> localhost:8082/api/v1/employees/byDepartmentName/{departmentName}
     *
     * @doc ===> Fetching all employees by department name
     */
    @GetMapping(path = "/byDepartmentName/{departmentName}")
    public ResponseEntity<?> findEmployeesByDepartmentName(@PathVariable("departmentName") String departmentName){
        var employeeList = this.employeeService.findEmployeesByDepartmentName(departmentName);
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }


    /**
     * @url ===> localhost:8082/api/v1/employees
     *
     * @doc ===> Fetching all employees
     */
    @GetMapping()
    public ResponseEntity<?> getAllEmployees(){
        var list = this.employeeService.findAllEmployees();
        list = list.stream()
                .sorted(Comparator.comparing(Employee::getId).reversed())
                .limit(10)
                .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    /**
     * @url ===> localhost:8082/api/v1/employees/{id}
     *
     * @doc ===> Fetching employee by id
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable("id") Integer id){
        if (!this.employeeService.existsById(id))
            return new ResponseEntity<>(new Message("Employee 'id = "+id+"' does not exist!"), HttpStatus.BAD_REQUEST);
        var employee = this.employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    /**
     * @url ===> localhost:8082/api/v1/employees
     *
     * @doc ===> Adding new employee
     */
    @PostMapping()
    public ResponseEntity<?> saveNewEmployee(@RequestBody Employee employee){
        if (employeeService.existsByEmail(employee.getEmail())){
            return new ResponseEntity<>(new Message("EMPLOYEE EMAIL IS ALREADY IN USE!"), HttpStatus.BAD_REQUEST);
        }
        var addEmployee = this.employeeService.addEmployee(employee);
        return new ResponseEntity<>(addEmployee, HttpStatus.OK);
    }

    /**
     * @url ===> localhost:8082/api/v1/employees/{id}
     *
     * @doc ===> Deleting employee by id
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable("id") Integer id){
        if (!employeeService.existsById(id)){
            return new ResponseEntity<>(new Message("Employee 'id = "+id+"' does not exist!"), HttpStatus.BAD_REQUEST);
        }
        this.employeeService.deleteEmployee(id);
        return new ResponseEntity<>(new Message("Employee 'id = "+id+"' deleted successfully!"), HttpStatus.OK);
    }

}
