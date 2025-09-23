package ru.test.project.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    public long id;

    @Column(nullable = false)
    public String role = "user";

    @Column(nullable = false, unique = true)
    public String username;

    @Column(nullable = false)
    public String password;

    @Column(nullable = true, unique = true)
    public String telegramId;

    @Column(nullable = false)
    public String email;

    @Lob
    @Column(nullable = true)
    public byte[] profilePicture;

    public Users() {
    }
}
