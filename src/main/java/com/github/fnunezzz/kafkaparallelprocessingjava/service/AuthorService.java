package com.github.fnunezzz.kafkaparallelprocessingjava.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.fnunezzz.kafkaparallelprocessingjava.classes.Author;
import com.github.fnunezzz.kafkaparallelprocessingjava.repository.AuthorRepository;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;



    public ArrayList<Author> buildAuthors(List<CharSequence> authors) throws Exception {

        ArrayList<Author> authorList = new ArrayList<Author>();
        for (CharSequence a : authors) {
            if (a == null) continue;
            Author temp = new Author();
            temp.setName(a.toString());
            authorList.add(temp);
        }

        return authorList;

    }


    public void createAuthors(ArrayList<Author> authors, com.github.fnunezzz.kafkaparallelprocessingjava.model.Book book) throws Exception {
        List<com.github.fnunezzz.kafkaparallelprocessingjava.model.Book> books = new ArrayList<com.github.fnunezzz.kafkaparallelprocessingjava.model.Book>();
        books.add(book);
        for (Author a : authors) {
            com.github.fnunezzz.kafkaparallelprocessingjava.model.Author modelAuthor = this.authorRepository.findByName(a.getName());
            if (modelAuthor == null) {
                com.github.fnunezzz.kafkaparallelprocessingjava.model.Author temp = new com.github.fnunezzz.kafkaparallelprocessingjava.model.Author();
                temp.setName(a.getName());
                temp.setBooks(books);
                temp.setCreatedAt(new Date());
                modelAuthor = temp;
            }
            this.authorRepository.save(modelAuthor, books);
        }

    }



}
