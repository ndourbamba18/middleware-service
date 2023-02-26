package com.ndourcodeur.employeebackendservice.entity;

import lombok.*;

/**
 * @author NdourCodeur
 * @since 23/02/2023
 * @version v1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Employee {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String jobTitle;
    private String departmentName;
}
