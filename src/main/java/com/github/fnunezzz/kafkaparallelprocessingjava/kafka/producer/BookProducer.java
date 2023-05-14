package com.github.fnunezzz.kafkaparallelprocessingjava.kafka.producer;

import org.springframework.stereotype.Service;

import com.github.fnunezzz.kafkaparallelprocessingjava.classes.Book;
import com.github.fnunezzz.kafkaparallelprocessingjava.kafka.AbstractProducer;
import com.github.fnunezzz.kafkaparallelprocessingjava.kafka.schema.BookMessage;

@Service
public class BookProducer extends AbstractProducer<BookMessage, Book> {

    private String TOPIC_NAME = "books";
    



    @Override
    public void send(Book book) throws Exception {
        BookMessage message = new BookMessage();
        message.setTitle(book.getTitle());
        message.setAuthor(book.getAuthor());
        message.setAuthorFirstName(book.getAuthorFirstName());
        message.setAuthorLastName(book.getAuthorLastName());
        message.setAuthorMiddleName(book.getAuthorMiddleName());
        message.setCategories(book.getCategories());
        message.setVolume(book.getVolume());
        message.setYear(book.getYear());
        message.setEdition(book.getEdition());
        message.setLanguage(book.getLanguage());
        message.setPages(book.getPages());
        message.setFilesize(book.getFilesize());
        message.setSeries(book.getSeries());
        message.setPeriodical(book.getPeriodical());
        message.setDescription(book.getDescription());
        message.setCover(book.getCover());
        
        send(message, TOPIC_NAME);
    }
}
