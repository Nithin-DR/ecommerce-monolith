package com.nithin.ecommerce.repository;

import com.nithin.ecommerce.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//This class is cared by Spring Data JPA since we are extending JpaRepository
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
