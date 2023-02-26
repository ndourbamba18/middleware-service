package com.ndourcodeur.departmentbackendservice.repository;

import com.ndourcodeur.departmentbackendservice.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * @author NdourCodeur
 * @since 23/02/2023
 * @version v1.0.0
 */
@Repository
public class DepartmentRepository {
    private static List<Department> departments = new ArrayList<>();
    private static int count = 10;

    static  {
        Department d1 = new Department(1, "Finance", "dd01", UUID.randomUUID().toString());
        Department d2 = new Department(2, "Human Resources", "dd02", UUID.randomUUID().toString());
        Department d3 = new Department(3, "Production", "dd03", UUID.randomUUID().toString());
        Department d4 = new Department(4, "Development", "dd04", UUID.randomUUID().toString());
        Department d5 = new Department(5, "Quality Management", "dd05", UUID.randomUUID().toString());
        Department d6 = new Department(6, "Sales", "dd06", UUID.randomUUID().toString());
        Department d7 = new Department(7, "Customer Service", "dd07", UUID.randomUUID().toString());
        Department d8 = new Department(8, "Unset", "dd08", UUID.randomUUID().toString());
        Department d9 = new Department(9, "Research", "dd09", UUID.randomUUID().toString());
        departments.addAll(List.of(d1, d2, d3, d4, d5, d6, d7, d8, d9));
    }

    public List<Department> findAll(){
        return departments;
    }

    public Department findById(Integer id){
        Department department = departments.get((id-1));
        return department;
    }

    public boolean existsById(Integer id){
        for(Department department : departments) {
            if(department.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean existsByName(String name){
        for(Department department : departments) {
            if(department.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Department findDepartmentByName(String departmentName){
        for(Department department : departments) {
            if(department.getName().equals(departmentName)) {
                return department;
            }
        }
        return null;
    }

    public void save(Department department){
        Department newDepartment = new Department(count++, department.getName(), department.getNo(), department.getDescription());
        newDepartment.setDescription(UUID.randomUUID().toString());
        departments.add(department);
    }

    public void update(Department department) {
        departments.remove(department);
        departments.add(department);
    }

    public void deleteById(Integer id){
        Iterator<Department> iterator = departments.iterator();
        while(iterator.hasNext()) {
            Department department = iterator.next();
            if(department.getId()==id) {
                iterator.remove();
            }
        }
    }

}
