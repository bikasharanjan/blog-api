package com.bikash.blogapi.repo;

import com.bikash.blogapi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity ,Long> {
}
