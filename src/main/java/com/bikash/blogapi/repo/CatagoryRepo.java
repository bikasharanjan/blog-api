package com.bikash.blogapi.repo;

import com.bikash.blogapi.entity.CatagoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatagoryRepo extends JpaRepository<CatagoryEntity, Long> {
}
