package com.github.adeniltonarcanjo.Bookstore.repositories;

import com.github.adeniltonarcanjo.Bookstore.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
}
