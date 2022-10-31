package com.github.adeniltonarcanjo.Bookstore;

import com.github.adeniltonarcanjo.Bookstore.domain.Book;
import com.github.adeniltonarcanjo.Bookstore.domain.Category;
import com.github.adeniltonarcanjo.Bookstore.repositories.BookRepository;
import com.github.adeniltonarcanjo.Bookstore.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Informatica", "livro de informatica ");
		Book b1 = new Book(null, "Clean code","Robert Martin","Lorem ipsum",cat1);
		cat1.getLivros().addAll(Arrays.asList(b1));

		this.categoryRepository.saveAll(Arrays.asList(cat1));
		this.bookRepository.saveAll(Arrays.asList(b1));


	}
}
