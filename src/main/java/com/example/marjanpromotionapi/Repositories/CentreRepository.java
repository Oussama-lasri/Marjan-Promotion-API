package com.example.marjanpromotionapi.Repositories;

import com.example.marjanpromotionapi.Models.Centre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CentreRepository extends JpaRepository<Centre,Long> {
    public Optional<Centre> findCentreById(Long id);
    public List<Centre> findAllByIdIn(List<Long> ids);

}
