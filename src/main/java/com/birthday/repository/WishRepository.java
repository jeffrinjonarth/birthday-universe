package com.birthday.repository;
import com.birthday.model.Wish;
import org.springframework.data.jpa.repository.JpaRepository;
public interface WishRepository extends JpaRepository<Wish, Long> {}
