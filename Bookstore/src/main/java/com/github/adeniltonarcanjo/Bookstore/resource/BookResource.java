package com.github.adeniltonarcanjo.Bookstore.resource;


import com.github.adeniltonarcanjo.Bookstore.domain.Book;
import com.github.adeniltonarcanjo.Bookstore.dtos.BookDTO;
import com.github.adeniltonarcanjo.Bookstore.dtos.CategoryDTO;
import com.github.adeniltonarcanjo.Bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
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
    public ResponseEntity<Book> update( @PathVariable Integer id,@Valid @RequestBody Book obj){
        Book newObj= service.book_update(id, obj);
        return ResponseEntity.ok().body(newObj);

    }

    @PatchMapping (value="/{id}")
    public ResponseEntity<Book> update_patch( @PathVariable Integer id,@Valid @RequestBody Book obj){
        Book newObj= service.book_update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestParam(value = "category", defaultValue="0") Integer id_cat,
                                       @Valid @RequestBody Book obj){
        Book newBook =service.create(id_cat, obj);
        URI uri= ServletUriComponentsBuilder.fromCurrentContextPath().path("/books/{id}").buildAndExpand(newBook.getId()).toUri();
        return  ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();

    }



}
