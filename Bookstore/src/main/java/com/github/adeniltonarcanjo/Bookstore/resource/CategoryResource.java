package com.github.adeniltonarcanjo.Bookstore.resource;


import com.github.adeniltonarcanjo.Bookstore.domain.Category;
import com.github.adeniltonarcanjo.Bookstore.dtos.CategoryDTO;
import com.github.adeniltonarcanjo.Bookstore.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource {

    @Autowired
    private CategoryService service;

    @GetMapping(value="/{id}")
    public ResponseEntity<Category> findById(@PathVariable Integer id){
        Category obj =service.findById(id);
        return ResponseEntity.ok().body(obj);

    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll(){
        List<Category> list = service.findAll();
        List<CategoryDTO> listDTO= list.stream().map(obj-> new CategoryDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }






}
