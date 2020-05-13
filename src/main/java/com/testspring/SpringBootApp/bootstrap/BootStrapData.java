package com.testspring.SpringBootApp.bootstrap;

import com.testspring.SpringBootApp.domain.Author;
import com.testspring.SpringBootApp.domain.Book;
import com.testspring.SpringBootApp.domain.Publisher;
import com.testspring.SpringBootApp.repositories.AuthorRepository;
import com.testspring.SpringBootApp.repositories.BookRepository;
import com.testspring.SpringBootApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //Publisher
        Publisher publisher = new Publisher();
        publisher.setName("MicroSoft");
        publisher.setCity("Salem");
        publisherRepository.save(publisher);

        Author Deepak = new Author();
        Deepak.setFirstname("Deepak");
        Deepak.setLastname("Raj");
        Book Java = new Book();
        Java.setTitle("Java");
        Java.setIsbn("12345");


        Deepak.getBooks().add(Java);
        Java.getAuthors().add(Deepak);
        Java.setPublisher(publisher);
        publisher.getBooks().add(Java);

        authorRepository.save(Deepak);
        bookRepository.save(Java);
        publisherRepository.save(publisher);

        Author Kannan = new Author();
        Kannan.setFirstname("Kannan");
        Kannan.setLastname("World");
        Book C = new Book();
        C.setTitle("C");
        C.setIsbn("123456");

        Kannan.getBooks().add(C);
        C.getAuthors().add(Kannan);
        C.setPublisher(publisher);
        publisher.getBooks().add(C);

        authorRepository.save(Kannan);
        bookRepository.save(C);
        publisherRepository.save(publisher);

        System.out.println("Started In BootStrapData");
        System.out.println("Number Of Books : "+bookRepository.count());
        System.out.println("Number Of Authors : "+authorRepository.count());
        System.out.println("Number of Publisher : "+publisherRepository.count());
        System.out.println("Number Of Books Published by Publisher : "+publisher.getBooks().size());

    }
}
