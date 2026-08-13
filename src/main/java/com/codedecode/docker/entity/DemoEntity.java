package com.codedecode.docker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "demo_entity")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class DemoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String centerName;
    private String centerAddress;
}
