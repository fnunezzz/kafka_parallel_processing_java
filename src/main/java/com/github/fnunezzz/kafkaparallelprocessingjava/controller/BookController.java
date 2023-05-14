package com.github.fnunezzz.kafkaparallelprocessingjava.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.fnunezzz.kafkaparallelprocessingjava.dto.ProcessBooksDto;
import com.github.fnunezzz.kafkaparallelprocessingjava.service.BookService;

@RestController()
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;
    
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
    
    
    @PutMapping("/process-books")
    public ResponseEntity<String> processBooks(@RequestBody ProcessBooksDto body) throws Exception {
        this.bookService.processBooks(body);
        return new ResponseEntity<String>("Processing", HttpStatus.OK);

    }

}
