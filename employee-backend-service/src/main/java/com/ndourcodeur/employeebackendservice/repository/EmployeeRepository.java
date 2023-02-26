package com.ndourcodeur.employeebackendservice.repository;

import com.ndourcodeur.employeebackendservice.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author NdourCodeur
 * @since 23/02/2023
 * @version v1.0.0
 */
@Repository
@Slf4j
public class EmployeeRepository {
    private static List<Employee> employees = new ArrayList<>();
    private static int count = 6;

    static  {
        Employee e1 = new Employee(1, "Bamba", "Ndour", "bamba.ndour@employee-service.net", "Backend Developer", "Development");
        Employee e2 = new Employee(2, "Ndour", "Coder", "ndour.coder@employee-service.net", "Java Architect", "Development");
        Employee e3 = new Employee(3, "Mouhamed", "Ndiaye", "mouhamed.ndiaye@employee-service.net", "Senior Recruiter", "Human Resources");
        Employee e4 = new Employee(4, "Rama", "Seck", "rama.seck@employee-service.net", "Red Had Architect", "Production");
        Employee e5 = new Employee(5, "Bintou", "Ndoye", "bintou.ndoye@employee-service.net", "Senior Manager", "Quality Management");;
        employees.addAll(List.of(e1, e2, e3, e4, e5));
    }

    public List<Employee> findAll(){
        return employees;
    }

    public List<Employee> findEmployeesByDepartmentName(String departmentName){
        List<Employee> employeeList = employees.stream()
                .filter(employee -> employee.getDepartmentName().equals(departmentName))
                .collect(Collectors.toList());
        return employeeList;
    }

    public Employee findById(Integer id){
        for(Employee employee : employees) {
            if(employee.getId()==id) {
                return employee;
            }
        }
        return null;
    }

    public boolean existsById(Integer id){
        for(Employee employee : employees) {
            if(employee.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean existsByEmail(String email){
        for(Employee employee : employees) {
            if(employee.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public void save(Employee request){
        Employee employee = new Employee(count++, request.getFirstName(), request.getLastName(),
                request.getEmail(), request.getJobTitle(), request.getDepartmentName());
        employees.add(employee);
    }

    public void deleteById(Integer id){
        Iterator<Employee> iterator = employees.iterator();
        while(iterator.hasNext()) {
            Employee employee = iterator.next();
            if(employee.getId()==id) {
                iterator.remove();
            }
        }
    }

}
