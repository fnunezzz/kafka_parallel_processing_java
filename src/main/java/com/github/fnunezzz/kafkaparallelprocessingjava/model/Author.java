package com.github.fnunezzz.kafkaparallelprocessingjava.model;

import java.util.Date;
import java.util.List;
import javax.persistence.*;



@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany()
    @JoinTable(name="book_catalog", joinColumns=
    {@JoinColumn(name="author_id")}, inverseJoinColumns={@JoinColumn(name="book_id")})
    private List<Book> books;

    @Column(name = "created_at", columnDefinition = "timestamp")
    private Date createdAt;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    

    
}
