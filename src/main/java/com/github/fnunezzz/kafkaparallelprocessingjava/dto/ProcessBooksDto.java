package com.github.fnunezzz.kafkaparallelprocessingjava.dto;

import java.util.ArrayList;

import com.github.fnunezzz.kafkaparallelprocessingjava.classes.Book;

public class ProcessBooksDto {
    private ArrayList<Book> books;

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    } 
}