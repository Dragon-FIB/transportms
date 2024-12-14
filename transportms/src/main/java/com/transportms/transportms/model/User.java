package com.transportms.transportms.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    private Long id;

    @Column(nullable = false, unique = true) // Email must be unique and not null
    private String email;

    @Column(nullable = false) // Name cannot be null
    private String name;

    @Column(nullable = false) // Password cannot be null
    private String password;
}
