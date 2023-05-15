package com.github.fnunezzz.kafkaparallelprocessingjava.interfaces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.github.fnunezzz.kafkaparallelprocessingjava.model.Book;

public interface IBookRepository extends JpaRepository<Book, Long> {


    @Query("select b from Book b where b.isbn = :isbn")
    public Book findBook(@Param("isbn") String isbn);
}
