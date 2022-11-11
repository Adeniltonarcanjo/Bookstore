package com.github.adeniltonarcanjo.Bookstore.resource;


import com.github.adeniltonarcanjo.Bookstore.domain.Book;
import com.github.adeniltonarcanjo.Bookstore.dtos.BookDTO;
import com.github.adeniltonarcanjo.Bookstore.dtos.CategoryDTO;
import com.github.adeniltonarcanjo.Bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/books")
public class BookResource {

    @Autowired
    private BookService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> findById(@PathVariable Integer id) {
        Book obj = service.findById(id);
        return ResponseEntity.ok().body(obj);

    }

    @GetMapping()
    public ResponseEntity<List<BookDTO>> findAll(@RequestParam(value = "category",defaultValue ="0") Integer id_cat){
        List<Book> listBook = service.findAll(id_cat);
        List<BookDTO> listBookDTO = listBook.stream().map(obj -> new BookDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listBookDTO);

    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Book> update(@PathVariable Integer id, @RequestBody Book obj){
        Book newObj= service.book_update(id, obj);
        return ResponseEntity.ok().body(newObj);

    }

    @PatchMapping (value="/{id}")
    public ResponseEntity<Book> update_patch(@PathVariable Integer id, @RequestBody Book obj){
        Book newObj= service.book_update(id, obj);
        return ResponseEntity.ok().body(newObj);

    }


}
