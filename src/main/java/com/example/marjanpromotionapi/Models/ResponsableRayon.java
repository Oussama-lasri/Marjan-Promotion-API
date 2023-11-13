package com.example.marjanpromotionapi.Models;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
//@Table(name = "")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Transactional
public class ResponsableRayon  {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;
    private String username;
    private String email;
    private String password;
    @ManyToOne
    private Centre centre ;
    @OneToOne
    private Rayon rayon ;

    @Transient
    private Long centreId;
    @Transient
    private Long rayonId;

}
