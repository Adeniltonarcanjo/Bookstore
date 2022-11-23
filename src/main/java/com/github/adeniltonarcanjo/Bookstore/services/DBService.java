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
        Category cat3 = new Category(null, "Biografia", "livros que relatam todo o percurso de vida do biografado, muitas vezes já falecido ");

        Book b1 = new Book(null, "Clean code", "Robert Martin", "Clean Code ou código limpo se refere a um conjunto de boas práticas na escrita de software que você pode aplicar para obter uma maior legibilidade e manutenabilidade do seu código.", cat1);
        Book b2 = new Book(null, "Lula", "Lula", "Biografia do presidente lula", cat3);
        Book b3 = new Book(null, "Rita Lee", "Rita lee", "Levava uma vida sosegada...", cat3);
        Book b4 = new Book(null, "harry potter ", "Joanne Rowling", "Harry Potter é uma série de sete romances de fantasia escrita pela autora britânica J. K. Rowling. A série narra as aventuras de um jovem chamado Harry James Potter, que descobre aos 11 anos de idade que é um bruxo ao ser convidado para estudar na Escola de Magia e Bruxaria de Hogwarts", cat2);

        cat1.getBooks().addAll(Arrays.asList(b1));
        cat2.getBooks().addAll(Arrays.asList(b4));
        cat3.getBooks().addAll(Arrays.asList(b2, b3));

        this.categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        this.bookRepository.saveAll(Arrays.asList(b1, b2, b3, b4));


    }


}
