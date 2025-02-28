package com.mockito.spring_boot_mockito.model;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class User {
    @Id
    private Integer id;
    private String name;
    private int age;
    private String address;
}
