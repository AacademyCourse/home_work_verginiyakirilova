package com.example.home_work_module14.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@ToString
@Entity(name = "users_name")
public class User {
       @Id
       @GeneratedValue(strategy = GenerationType.SEQUENCE)
       @Column(name = "id", nullable = false)
       private Long id;

       @Column(name = "First_Name", length = 50)
       private String first_name;

       @Column(name = "Last_Name", length = 100)
       private String last_name;

       @Column(name = "Phone_number", length = 10)
       private String phone_number;

       @Column(name = "email")
       private String email;

       @Column(name = "time")
       private Instant createdAt = Instant.now();

       @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
       @JsonManagedReference
       private Set<Address> addresses = new HashSet<>();

       @ManyToMany
       @JoinTable(
               name = "user_roles",
               joinColumns = {@JoinColumn(name = "user_id")},
               inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles = new HashSet<>();

}
