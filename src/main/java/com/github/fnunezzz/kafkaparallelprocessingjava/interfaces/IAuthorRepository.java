package com.github.fnunezzz.kafkaparallelprocessingjava.interfaces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.github.fnunezzz.kafkaparallelprocessingjava.model.Author;

public interface IAuthorRepository extends JpaRepository<Author, Long> {


    @Query("select a from Author a where a.name = :name")
    public Author findAuthor(@Param("name") String name);
}

