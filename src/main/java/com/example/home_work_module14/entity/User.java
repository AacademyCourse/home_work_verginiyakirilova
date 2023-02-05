package com.example.home_work_module14.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Entity(name = "users_name")
public class User {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long Id;

       @Column(name = "First_Name")
       private String first_name;

       @Column(name = "Last_Name")
       private String last_name;

       @Column(name = "Phone_number")
       private String phone_number;

       @Column(name = "email")
       private String email;

       @Column(name = "time")
       private Instant createdAt = Instant.now();

    }
