package com.example.maping.entity;

import com.example.maping.enumPackage.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    private String description;

    @Version
    private Long version;

    @JsonIgnore
    @Enumerated(EnumType.STRING)
    private Status status = Status.IN_PROCESS;

    @OneToMany(mappedBy = "application", cascade = CascadeType.ALL)
    List<Review> reviews = new ArrayList<>();

    public Application(String firstName, String lastName, String email, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.description = description;
    }
}
