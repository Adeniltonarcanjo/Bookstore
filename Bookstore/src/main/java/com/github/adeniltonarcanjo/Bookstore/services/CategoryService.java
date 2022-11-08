package com.github.adeniltonarcanjo.Bookstore.services;

import com.github.adeniltonarcanjo.Bookstore.domain.Category;
import com.github.adeniltonarcanjo.Bookstore.dtos.CategoryDTO;
import com.github.adeniltonarcanjo.Bookstore.repositories.CategoryRepository;
import com.github.adeniltonarcanjo.Bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;


    public Category findById(Integer id) {
        Optional<Category> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found" +
                id + ", Type"+ Category.class.getName()));
    }

    public List<Category> findAll(){
        return repository.findAll();
    }


}
