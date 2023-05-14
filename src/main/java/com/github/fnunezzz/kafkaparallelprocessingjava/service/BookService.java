package com.github.fnunezzz.kafkaparallelprocessingjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.fnunezzz.kafkaparallelprocessingjava.classes.Book;
import com.github.fnunezzz.kafkaparallelprocessingjava.dto.ProcessBooksDto;
import com.github.fnunezzz.kafkaparallelprocessingjava.kafka.producer.BookProducer;

@Service
public class BookService {
    
    @Autowired
    private BookProducer bookProducer;



    public void processBooks(ProcessBooksDto dto) throws Exception {
        if (dto.getBooks() == null) {
            throw new Exception("No books informed");
        }

        if (dto.getBooks().size() <= 0) {
            throw new Exception("Empty books list");
        }
        

        for (Book book : dto.getBooks()) {
            this.bookProducer.send(book);
        }

    }








}
