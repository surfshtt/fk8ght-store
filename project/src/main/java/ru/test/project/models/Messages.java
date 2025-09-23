package ru.test.project.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Messages")
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    public long id;

    @Column(nullable = false)
    public String chatId;

    @Column(nullable = false)
    public String userId;

    @Column(nullable = false)
    public String message;

    @Lob
    @Column(nullable = true, columnDefinition = "MEDIUMBLOB")
    public byte[] picture;

    @Column(nullable = false)
    public LocalDate date;
}
