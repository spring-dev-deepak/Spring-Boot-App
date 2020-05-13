package com.testspring.SpringBootApp.repositories;

import com.testspring.SpringBootApp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
