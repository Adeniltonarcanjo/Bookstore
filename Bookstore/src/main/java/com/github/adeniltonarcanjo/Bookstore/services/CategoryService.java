package com.github.adeniltonarcanjo.Bookstore.services;

import com.github.adeniltonarcanjo.Bookstore.domain.Category;
import com.github.adeniltonarcanjo.Bookstore.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;



    public Category findById(Integer id) {
       Optional<Category> obj=repository.findById(id);
       return obj.orElse(null);

    }




}
