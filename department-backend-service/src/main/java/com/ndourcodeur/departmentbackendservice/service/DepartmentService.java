package com.ndourcodeur.departmentbackendservice.service;

import com.ndourcodeur.departmentbackendservice.entity.Department;

import java.util.List;

/**
 * @author NdourCodeur
 * @since 23/02/2023
 * @version v1.0.0
 */
public interface DepartmentService {
    List<Department> findAllDepartments();
    Department findDepartmentById(Integer id);
    Department findDepartmentByName(String name);
    Department addDepartment(Department department);
    void deleteDepartment(Integer id);
    boolean existsById(Integer id);
    boolean existsByName(String name);

}
