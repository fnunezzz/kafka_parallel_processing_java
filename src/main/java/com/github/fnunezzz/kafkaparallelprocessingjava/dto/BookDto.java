package com.github.fnunezzz.kafkaparallelprocessingjava.dto;

import java.util.ArrayList;

public class BookDto {
    private String title;
    private String isbn;
    private int pageCount;
    private String publishedDate;
    private String cover;
    private String shortDescription;
    private String longDescription;
    private String status;
    ArrayList < String > authors = new ArrayList < String > ();
    ArrayList < String > categories = new ArrayList < String > ();
   
   
    // Getter Methods 
   
    public String getTitle() {
     return title;
    }
   
    public String getIsbn() {
     return isbn;
    }
   
    public int getPageCount() {
     return pageCount;
    }
   
    public String getPublishedDate() {
     return publishedDate;
    }
   
    public String getCover() {
     return cover;
    }
   
    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
    }

    public String getShortDescription() {
     return shortDescription;
    }
   
    public String getLongDescription() {
     return longDescription;
    }
   
    public String getStatus() {
     return status;
    }
   
    // Setter Methods 
   
    public void setTitle(String title) {
     this.title = title;
    }
   
    public void setIsbn(String isbn) {
     this.isbn = isbn;
    }
   
    public void setPageCount(int pageCount) {
     this.pageCount = pageCount;
    }
   
    public void setPublishedDate(String publishedDate) {
     this.publishedDate = publishedDate;
    }
   
    public void setCover(String cover) {
     this.cover = cover;
    }
   
    public void setShortDescription(String shortDescription) {
     this.shortDescription = shortDescription;
    }
   
    public void setLongDescription(String longDescription) {
     this.longDescription = longDescription;
    }
   
    public void setStatus(String status) {
     this.status = status;
    }
   }