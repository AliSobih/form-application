package com.example.maping.entity;

import com.example.maping.enumPackage.DepartmentRole;
import com.example.maping.enumPackage.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "review")
@Getter
@Setter
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DepartmentRole role;

    @ManyToOne
    @JoinColumn(name = "application_id")
    private Application application;

    @Enumerated(EnumType.STRING)
    private Status status = Status.IN_PROCESS;

    @Version
    private Long version;

    public Review(DepartmentRole role, Application application) {
        this.role = role;
        this.application = application;
    }
}
