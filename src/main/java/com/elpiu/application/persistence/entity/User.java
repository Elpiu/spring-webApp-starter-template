package com.elpiu.application.persistence.entity;


import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.Date;
import static com.elpiu.application.form.dto.Regexp.*;


@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
@Data
public class User implements Serializable {

    public static final String ROLE_USER = "ROLE_USER";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    @Positive(message = "Id deve essere positivo")
    private Integer id;

    @Length(min = 8, max = 20)
    @Column(name = "username", nullable = false, unique = true)
    @Pattern(regexp = REG_USERNAME, message = REG_USERNAME_MESSAGE)
    private String username;

    @Length(min = 8, max = 20)
    @Column(name = "surname", nullable = false, unique = true)
    @Pattern(regexp = REG_NAME_SURNAME, message = REG_NAME_SURNAME_MESSAGE)
    private String surname;

    @Length(min = 8, max = 20)
    @Column(name = "name", nullable = false, unique = true)
    @Pattern(regexp = REG_NAME_SURNAME, message = REG_NAME_SURNAME_MESSAGE)
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "joined_date", nullable = false, unique = true)
    @CreatedDate
    private Date joinedDate = new Date();

    @Length(min = 8, max = 20, message = "La password deve essere lunga almeno 8 caratteri")
    @Column(name = "password")
    //@Pattern(regexp = REG_PASSWORD, message = REG_USERNAME_MESSAGE)
    private String password;

    @Column(name = "bio")
    private String bio;

    @Column(name = "email", nullable = false, unique = true)
    //@Email(regexp = REG_EMAIL, message = REG_EMAIL_MESSAGE)
    private String email;

    @Column(name = "role", nullable = false)
    private String role = ROLE_USER;

    @Column(name = "active")
    private Boolean active = true;

}