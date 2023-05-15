package com.github.fnunezzz.kafkaparallelprocessingjava.repository;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.github.fnunezzz.kafkaparallelprocessingjava.model.Book;

import com.github.fnunezzz.kafkaparallelprocessingjava.interfaces.IBookRepository;

@Repository
public class BookRepository {

    @Autowired
    private IBookRepository repository;


    public Book save(com.github.fnunezzz.kafkaparallelprocessingjava.classes.Book book) throws Exception {
        Book model = new Book();
        model.setTitle(book.getTitle());
        model.setIsbn(book.getIsbn());
        model.setPageCount(book.getPageCount());
        model.setPublishedDate(book.getPublishedDate());
        model.setCover(book.getCover());
        model.setShortDescription(book.getShortDescription());
        model.setLongDescription(book.getLongDescription());
        model.setStatus(book.getStatus());
        model.setCreatedAt(new Date());
        return this.repository.save(model);
    }


    public Book findBook(String isbn) throws Exception {
        return this.repository.findBook(isbn);



    }


}
