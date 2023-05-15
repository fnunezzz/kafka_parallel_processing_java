package com.github.fnunezzz.kafkaparallelprocessingjava.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.github.fnunezzz.kafkaparallelprocessingjava.model.Author;
import com.github.fnunezzz.kafkaparallelprocessingjava.model.Book;
import com.github.fnunezzz.kafkaparallelprocessingjava.interfaces.IAuthorRepository;

@Repository
public class AuthorRepository {

    @Autowired
    private IAuthorRepository repository;


    public Author save(Author author, List<Book> books) throws Exception {
        return this.repository.save(author);
    }


    public Author findByName(String name) throws Exception {
        return this.repository.findAuthor(name);
    }


}
