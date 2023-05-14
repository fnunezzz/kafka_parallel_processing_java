package com.github.fnunezzz.kafkaparallelprocessingjava.classes;

public class Book {
    private String title;
    private String author;
    private String authorFirstName;
    private String authorLastName;
    private String authorMiddleName;
    private String categories;
    private String volume;
    private String year;
    private String edition;
    private String language;
    private String pages;
    private String filesize;
    private String series;
    private Boolean periodical;
    private String description;
    private String cover;
   
   
    // Getter Methods 
   
    public String getTitle() {
     return title;
    }
   
    public String getAuthor() {
     return author;
    }
   
    public String getAuthorFirstName() {
     return authorFirstName;
    }
   
    public String getAuthorLastName() {
     return authorLastName;
    }
   
    public String getAuthorMiddleName() {
     return authorMiddleName;
    }
   
    public String getCategories() {
     return categories;
    }
   
    public String getVolume() {
     return volume;
    }
   
    public String getYear() {
     return year;
    }
   
    public String getEdition() {
     return edition;
    }
   
    public String getLanguage() {
     return language;
    }
   
    public String getPages() {
     return pages;
    }
   
    public String getFilesize() {
     return filesize;
    }
   
    public String getSeries() {
     return series;
    }
   
    public Boolean getPeriodical() {
     return periodical;
    }
   
    public String getDescription() {
     return description;
    }
   
    public String getCover() {
     return cover;
    }
   
    // Setter Methods 
   
    public void setTitle(String title) {
     this.title = title;
    }
   
    public void setAuthor(String author) {
     this.author = author;
    }
   
    public void setAuthorFirstName(String authorFirstName) {
     this.authorFirstName = authorFirstName;
    }
   
    public void setAuthorLastName(String authorLastName) {
     this.authorLastName = authorLastName;
    }
   
    public void setAuthorMiddleName(String authorMiddleName) {
     this.authorMiddleName = authorMiddleName;
    }
   
    public void setCategories(String categories) {
     this.categories = categories;
    }
   
    public void setVolume(String volume) {
     this.volume = volume;
    }
   
    public void setYear(String year) {
     this.year = year;
    }
   
    public void setEdition(String edition) {
     this.edition = edition;
    }
   
    public void setLanguage(String language) {
     this.language = language;
    }
   
    public void setPages(String pages) {
     this.pages = pages;
    }
   
    public void setFilesize(String filesize) {
     this.filesize = filesize;
    }
   
    public void setSeries(String series) {
     this.series = series;
    }
   
    public void setPeriodical(Boolean periodical) {
     if (periodical == null) periodical = false;
     
     this.periodical = periodical;
    }
   
    public void setDescription(String description) {
     this.description = description;
    }
   
    public void setCover(String cover) {
     this.cover = cover;
    }
   }