package com.github.fnunezzz.kafkaparallelprocessingjava.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.fnunezzz.kafkaparallelprocessingjava.dto.ProcessBooksDto;

@RestController()
@RequestMapping("/books")
public class BooksrController {
    
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
    
    
    @PutMapping("/process-books")
    public ResponseEntity<String> processBooks(@RequestBody ProcessBooksDto body) throws Exception {
        return new ResponseEntity<String>("Processing", HttpStatus.OK);

    }

}
