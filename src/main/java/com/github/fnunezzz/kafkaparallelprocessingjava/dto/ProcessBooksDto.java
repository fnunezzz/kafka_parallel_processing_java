package com.github.fnunezzz.kafkaparallelprocessingjava.dto;

import java.util.ArrayList;

public class ProcessBooksDto {
    private ArrayList<BookDto> books;

    public ArrayList<BookDto> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<BookDto> books) {
        this.books = books;
    } 
}