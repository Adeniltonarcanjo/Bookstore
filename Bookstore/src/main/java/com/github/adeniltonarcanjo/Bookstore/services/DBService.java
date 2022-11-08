package com.github.adeniltonarcanjo.Bookstore.services;

import com.github.adeniltonarcanjo.Bookstore.domain.Book;
import com.github.adeniltonarcanjo.Bookstore.domain.Category;
import com.github.adeniltonarcanjo.Bookstore.repositories.BookRepository;
import com.github.adeniltonarcanjo.Bookstore.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;



    public void dataBaseInstance() {
        Category cat1 = new Category(null, "Informatica", "livro de informatica ");
        Category cat2 = new Category(null, "Ficção Cientifica", "Ficção cientifica");
        Category cat3 = new Category(null, "Biografia", "livro de Biografia ");

        Book b1 = new Book(null, "Clean code", "Robert Martin", "Lorem ipsum", cat1);
        Book b2 = new Book(null, "Lula", "Lula", "Biografia do presidente lula", cat3);
        Book b3 = new Book(null, "Rita Lee", "Rita lee", "Levava uma vida sosegada...", cat3);
        Book b4 = new Book(null, "harry potter ", "don't know", "Lorem ipsum", cat2);

        cat1.getBooks().addAll(Arrays.asList(b1));
        cat2.getBooks().addAll(Arrays.asList(b4));
        cat3.getBooks().addAll(Arrays.asList(b2, b3));

        this.categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        this.bookRepository.saveAll(Arrays.asList(b1, b2, b3, b4));


    }


}
