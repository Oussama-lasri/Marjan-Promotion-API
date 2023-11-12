package com.example.marjanpromotionapi.Repositories;

import com.example.marjanpromotionapi.Models.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion,Long> {
}
