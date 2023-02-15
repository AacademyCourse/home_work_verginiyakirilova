package com.example.home_work_module14.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Country")
    private String country;

    @Column(name = "City")
    private String city;

    @Column(name = "Street")
    private String street;

    @Column(name = "Street_number")
    private String street_number;

    @ManyToOne
    @JsonBackReference
    private User user;

}
