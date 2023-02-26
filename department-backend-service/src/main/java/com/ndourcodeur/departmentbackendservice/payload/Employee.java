package com.ndourcodeur.departmentbackendservice.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String jobTitle;
    private String departmentName;
}
