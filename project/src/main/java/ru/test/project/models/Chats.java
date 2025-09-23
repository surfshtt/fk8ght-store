package ru.test.project.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Chats")
public class Chats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    public long id;

    @Column(nullable = false)
    public String userId1;

    @Column(nullable = false)
    public String userId2;

    @Column(nullable = false)
    public boolean state;
}
