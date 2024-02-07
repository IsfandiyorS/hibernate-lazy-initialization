package com.example.hibernatelazyinitialization.repository;

import com.example.hibernatelazyinitialization.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
