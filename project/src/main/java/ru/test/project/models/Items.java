package ru.test.project.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Items")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    public long id;

    @Column(nullable = false)
    public String ownerId;

    @Column(nullable = false)
    public String itemName;

    @Column(nullable = false)
    public String itemDescription;

    @Column(nullable = false)
    public String type;

    @Column(nullable = false)
    public int itemPrice;

    @Column(nullable = false)
    public LocalDate date;

    @Lob
    @Column(nullable = true, columnDefinition = "MEDIUMBLOB")
    public byte[] picture;
}
