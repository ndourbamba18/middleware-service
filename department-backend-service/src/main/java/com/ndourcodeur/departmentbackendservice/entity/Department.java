package com.ndourcodeur.departmentbackendservice.entity;

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
public class Department {
    private Integer id;
    private String name;
    private String no;
    private String description;
}
