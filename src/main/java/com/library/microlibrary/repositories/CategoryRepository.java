package com.library.microlibrary.repositories;

import com.library.microlibrary.entities.CategoryEntity;
import com.library.microlibrary.entities.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
    List<CategoryEntity> findAll();

    CategoryEntity findCategoryNameByCategoryId(Integer categoryId);

    CategoryEntity findByCategoryId(Integer categoryId);

    CategoryEntity save(CategoryEntity category);

}
