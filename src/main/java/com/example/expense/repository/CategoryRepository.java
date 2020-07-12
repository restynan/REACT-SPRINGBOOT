package com.example.expense.repository;

import com.example.expense.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
 //   Category findByName(String name);
}
