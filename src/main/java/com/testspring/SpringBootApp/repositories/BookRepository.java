package com.testspring.SpringBootApp.repositories;

import com.testspring.SpringBootApp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
