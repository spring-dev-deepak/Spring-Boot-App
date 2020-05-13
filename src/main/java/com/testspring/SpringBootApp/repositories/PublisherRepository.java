package com.testspring.SpringBootApp.repositories;

import com.testspring.SpringBootApp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
