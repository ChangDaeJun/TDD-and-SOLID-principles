package com.boot.boardbootproject.domain;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
public class User {
    @Id
    private Long id;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    @CreatedDate
    private Date joinDate;
}
