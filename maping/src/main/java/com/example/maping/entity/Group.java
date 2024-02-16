package com.example.maping.entity;

import com.example.maping.enumPackage.DepartmentRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "groups")
@NoArgsConstructor
@Getter
@Setter
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    @Enumerated(EnumType.STRING)
    private DepartmentRole role;

    public Group(String email, DepartmentRole role) {
        this.email = email;
        this.role = role;
    }
}
