package com.github.fnunezzz.kafkaparallelprocessingjava.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.fnunezzz.kafkaparallelprocessingjava.classes.Book;
import com.github.fnunezzz.kafkaparallelprocessingjava.dto.BookDto;
import com.github.fnunezzz.kafkaparallelprocessingjava.dto.ProcessBooksDto;
import com.github.fnunezzz.kafkaparallelprocessingjava.kafka.producer.BookProducer;
import com.github.fnunezzz.kafkaparallelprocessingjava.kafka.schema.BookMessage;
import com.github.fnunezzz.kafkaparallelprocessingjava.repository.BookRepository;

@Service
public class BookService {
    
    @Autowired
    private BookProducer bookProducer;

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

    public com.github.fnunezzz.kafkaparallelprocessingjava.model.Book createBook(BookMessage message) throws Exception {
        Book book = new Book();    
       


        book.setCategories( (message.getCategories() == null) ? null : message.getCategories() );
        book.setTitle( (message.getTitle() == null) ? null : message.getTitle().toString() );

        book.setIsbn( (message.getIsbn() == null) ? null : message.getIsbn().toString() );

        book.setPageCount( (message.getPageCount() == null) ? null : message.getPageCount() );
        book.setPublishedDate( (message.getPublishedDate() == null) ? null : message.getPublishedDate().toString() );

        book.setCover( (message.getCover() == null) ? null : message.getCover().toString() );

        book.setShortDescription( (message.getShortDescription() == null) ? null : message.getShortDescription().toString() );
        book.setLongDescription( (message.getLongDescription() == null) ? null : message.getLongDescription().toString() );
        book.setStatus( (message.getStatus() == null) ? null : message.getStatus().toString() );

        return bookRepository.save(book);


        

    }








}
