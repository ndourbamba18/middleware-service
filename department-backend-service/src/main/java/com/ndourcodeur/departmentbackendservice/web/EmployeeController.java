package com.ndourcodeur.departmentbackendservice.web;

import com.ndourcodeur.departmentbackendservice.message.Message;
import com.ndourcodeur.departmentbackendservice.payload.Employee;
import com.ndourcodeur.departmentbackendservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/v1/departments/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    /**
     * @url ===> localhost:8081/api/v1/departments/employees/findAllEmployees
     *
     * @doc ===> Fetching all employees via department-service rest api
     */
    @GetMapping(path = "/findAllEmployees")
    public ResponseEntity<?> findAllEmployeesViaDepartmentServiceRestApi(){
        List<Employee> list = this.employeeService.findAllEmployees();
        if (list.isEmpty()){
            return new ResponseEntity<>(new Message("No content!"), HttpStatus.OK);
        }
        list = list.stream()
                .sorted(Comparator.comparing(Employee::getId).reversed())
                .limit(10)
                .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /**
     * @url localhost:8081/api/v1/departments/employees/findAllEmployeesByDepartmentName/{departmentName}
     *
     * @doc ===> Fetching all employees by department name via department-service rest api
     */
    @GetMapping(path = "/findAllEmployeesByDepartmentName/{departmentName}")
    public ResponseEntity<?> findAllEmployeesByDepartmentNameViaDepartmentServiceRestApi(@PathVariable("departmentName") String departmentName){
        return new ResponseEntity<>(this.employeeService.findDepartmentWithEmployees(departmentName), HttpStatus.OK);
    }

    /**
     * @url ===> localhost:8081/api/v1/departments/employees/findEmployee/{id}
     *
     * @doc ===> Fetching employee by id via department-service rest api
     */
    @GetMapping(path = "/findEmployee/{id}")
    public ResponseEntity<?> getEmployeeByIdViaDepartmentServiceRestApi(@PathVariable("id") Integer id){
        Employee employee = this.employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    /**
     * @url ===> localhost:8081/api/v1/departments/employees/addEmployee
     *
     * @doc ===> Adding new employee via department-service rest api
     */
    @PostMapping(path = "/addEmployee")
    public ResponseEntity<?> saveNewEmployeeViaDepartmentServiceRestApi(@RequestBody Employee employee){
        Employee addEmployee = this.employeeService.addEmployee(employee);
        return new ResponseEntity<>(addEmployee, HttpStatus.OK);
    }

    /**
     * @url ===> localhost:8081/api/v1/departments/employees/deleteEmployee/{id}
     *
     * @doc ===> Deleting employee by id via department-service rest api
     */
    @DeleteMapping(path = "/deleteEmployee/{id}")
    public ResponseEntity<?> deleteEmployeeByIdViaDepartmentServiceRestApi(@PathVariable("id") Integer id){
        this.employeeService.deleteEmployee(id);
        return new ResponseEntity<>(new Message("Employee 'id="+id+"' deleted successfully!"), HttpStatus.OK);
    }
}
