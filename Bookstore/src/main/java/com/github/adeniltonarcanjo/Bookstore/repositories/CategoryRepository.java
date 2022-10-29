package com.github.adeniltonarcanjo.Bookstore.repositories;

import com.github.adeniltonarcanjo.Bookstore.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository <Category, Integer> {
}
