package com.ndourcodeur.departmentbackendservice.service.impl;

import com.ndourcodeur.departmentbackendservice.entity.Department;
import com.ndourcodeur.departmentbackendservice.repository.DepartmentRepository;
import com.ndourcodeur.departmentbackendservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author NdourCodeur
 * @since 23/02/2023
 * @version v1.0.0
 */
@Service("departmentService")
@RequiredArgsConstructor
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public List<Department> findAllDepartments() {
        var departmentList = this.departmentRepository.findAll();
        log.info("Finding all Departments Inside Department Service");
        return departmentList;
    }

    @Override
    public Department findDepartmentById(Integer id) {
        var findDepartment = this.departmentRepository.findById(id);
        log.info("Checking and Finding Department's ID Inside Department Service");
        return findDepartment;
    }

    @Override
    public Department findDepartmentByName(String name) {
        var findDepartmentByName = this.departmentRepository.findDepartmentByName(name);
        log.info("Checking and Finding Department's Name Inside Department Service");
        return findDepartmentByName;
    }

    @Override
    public Department addDepartment(Department department) {
        this.departmentRepository.save(department);
        log.info("Saving new Department Inside Department Service");
        return department;
    }

    @Override
    public void deleteDepartment(Integer id) {
        log.info("Checking and Deleting Department by ID Inside Department Service");
        this.departmentRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        log.info("Checking Department's ID Inside Department Service");
        return this.departmentRepository.existsById(id);
    }

    @Override
    public boolean existsByName(String name) {
        log.info("Checking Department's Name Inside Department Service");
        return this.departmentRepository.existsByName(name);
    }

}
