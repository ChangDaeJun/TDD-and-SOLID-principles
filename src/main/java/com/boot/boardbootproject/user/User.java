package com.boot.boardbootproject.user;

import com.boot.boardbootproject.Util.DateFormat;
import com.boot.boardbootproject.user.dto.UserJoinForm;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CurrentTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Entity
@Getter
@Setter
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private Date joinDate;

    public User(UserJoinForm form) {
        this.email = form.getEmail();
        this.password = form.getPassword();
        this.name = form.getName();
        this.joinDate = DateFormat.now();
    }

    public User() {
    }
}
