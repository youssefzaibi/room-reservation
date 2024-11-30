package com.example.roomreservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.roomreservation.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    void deleteCategoryById(Long id);
    Category findCategoryById(Long id);
}

