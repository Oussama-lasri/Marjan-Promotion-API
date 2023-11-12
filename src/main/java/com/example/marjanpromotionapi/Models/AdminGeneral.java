package com.example.marjanpromotionapi.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor

public class AdminGeneral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Please provide a valid email address")
    private String email ;
    @NotEmpty(message = "Password cannot be empty")
    private String password ;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "adminGeneral", cascade = CascadeType.MERGE)
    List<AdminCentre> adminCentreList ;
}
