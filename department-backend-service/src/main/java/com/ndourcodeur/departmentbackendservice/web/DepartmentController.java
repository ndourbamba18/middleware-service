package com.ndourcodeur.departmentbackendservice.web;

import com.ndourcodeur.departmentbackendservice.entity.Department;
import com.ndourcodeur.departmentbackendservice.message.Message;
import com.ndourcodeur.departmentbackendservice.service.DepartmentService;
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
@RequestMapping(path = "/api/v1/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    /**
     * @url ===> localhost:8081/api/v1/departments/findAllDepartments
     *
     * @doc ===> Fetching all departments
     */
    @GetMapping(path = "/findAllDepartments")
    public ResponseEntity<?> getAllDepartments(){
        var list = this.departmentService.findAllDepartments();
        list = list.stream()
                .sorted(Comparator.comparing(Department::getId).reversed())
                .limit(10)
                .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /**
     * @url ===> localhost:8081/api/v1/departments/findDepartment/{id}
     *
     * @doc ===> Fetching department by id
     */
    @GetMapping(path = "/findDepartment/{id}")
    public ResponseEntity<?> getDepartmentById(@PathVariable("id") Integer id){
        if (!departmentService.existsById(id)){
            return new ResponseEntity<>(new Message("Department 'id = "+id+"' does not exist!"), HttpStatus.BAD_REQUEST);
        }
        var department = this.departmentService.findDepartmentById(id);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    /**
     * @url ===> localhost:8081/api/v1/departments/findByName/{name}
     *
     * @doc ===> Fetching department by name
     */
    @GetMapping(path = "/findByName/{name}")
    public ResponseEntity<?> getDepartmentByName(@PathVariable("name") String name){
        if (!departmentService.existsByName(name)){
            return new ResponseEntity<>(new Message("Department 'Name = "+name+"' does not exist!"), HttpStatus.BAD_REQUEST);
        }
        var department = this.departmentService.findDepartmentByName(name);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    /**
     * @url ===> localhost:8081/api/v1/departments/addDepartment
     *
     * @doc ===> Adding new department
     */
    @PostMapping(path = "/addDepartment")
    public ResponseEntity<?> saveNewDepartment(@RequestBody Department department){
        if (departmentService.existsByName(department.getName())){
            return new ResponseEntity<>(new Message("DEPARTMENT NAME IS ALREADY IN USE!"), HttpStatus.BAD_REQUEST);
        }
        var addDepartment = this.departmentService.addDepartment(department);
        return new ResponseEntity<>(addDepartment, HttpStatus.OK);
    }

    /**
     * @url ===> localhost:8081/api/v1/departments/deleteDepartment/{id}
     *
     * @doc ===> Deleting department by id
     */
    @DeleteMapping(path = "/deleteDepartment/{id}")
    public ResponseEntity<?> deleteDepartmentById(@PathVariable("id") Integer id){
        if (!departmentService.existsById(id)){
            return new ResponseEntity<>(new Message("Department 'id = "+id+"' does not exist!"), HttpStatus.BAD_REQUEST);
        }
        this.departmentService.deleteDepartment(id);
        return new ResponseEntity<>(new Message("Department 'id = "+id+"' deleted successfully!"), HttpStatus.OK);
    }

}
