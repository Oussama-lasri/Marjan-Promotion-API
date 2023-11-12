package com.example.marjanpromotionapi.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Entity
//@Table(name = "")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class AdminCentre {
    @Id
    @GeneratedValue
    private Long id ;
    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Please provide a valid email address")
    private String email ;
    @NotEmpty
    private String password ;
    @CreationTimestamp
    private LocalDateTime createdOn ;
    @UpdateTimestamp
    private LocalDateTime updatedOn ;
    @OneToMany(mappedBy = "adminCentre", cascade = CascadeType.ALL)
    private List<Centre> centreList ;


}
