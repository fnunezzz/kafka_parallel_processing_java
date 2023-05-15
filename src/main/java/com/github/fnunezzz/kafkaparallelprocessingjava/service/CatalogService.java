package com.github.fnunezzz.kafkaparallelprocessingjava.service;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.fnunezzz.kafkaparallelprocessingjava.classes.Author;
import com.github.fnunezzz.kafkaparallelprocessingjava.dto.BookDto;
import com.github.fnunezzz.kafkaparallelprocessingjava.dto.ProcessBooksDto;
import com.github.fnunezzz.kafkaparallelprocessingjava.kafka.producer.BookProducer;
import com.github.fnunezzz.kafkaparallelprocessingjava.kafka.schema.BookMessage;
import com.github.fnunezzz.kafkaparallelprocessingjava.repository.BookRepository;

@Service
public class CatalogService {
    
    @Autowired
    private BookProducer bookProducer;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;



    public void processBooks(ProcessBooksDto dto) throws Exception {
        if (dto.getBooks() == null) {
            throw new Exception("No books informed");
        }

        if (dto.getBooks().size() <= 0) {
            throw new Exception("Empty books list");
        }
        

        for (BookDto book : dto.getBooks()) {
            this.bookProducer.send(book);
        }

    }

    public void createCatalog(BookMessage message) throws Exception {
        ArrayList<Author> authors = new ArrayList<Author>();

        String isbn = null;

        if (message.getTitle() == null) {
            return;
        }

        if (message.getIsbn() == null) {
            return;
        }

        isbn = message.getIsbn().toString();

        if (message.getAuthors() != null) {
            authors = this.authorService.buildAuthors(message.getAuthors());
        }
        
        com.github.fnunezzz.kafkaparallelprocessingjava.model.Book bookModel = this.bookRepository.findBook(isbn);

        if (bookModel == null) {
            bookModel = bookService.createBook(message);
        }

        authorService.createAuthors(authors, bookModel);
        

    }








}
