package com.github.fnunezzz.kafkaparallelprocessingjava.kafka.producer;


import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.github.fnunezzz.kafkaparallelprocessingjava.dto.BookDto;
import com.github.fnunezzz.kafkaparallelprocessingjava.kafka.AbstractProducer;
import com.github.fnunezzz.kafkaparallelprocessingjava.kafka.schema.BookMessage;

@Service
public class BookProducer extends AbstractProducer<BookMessage, BookDto> {

    private String TOPIC_NAME = "books";
    



    @Override
    public void send(BookDto book) throws Exception {
        BookMessage message = new BookMessage();
        message.setTitle(book.getTitle());
        if (book.getAuthors() != null) {
            CharSequence[] cs = book.getAuthors().toArray(new CharSequence[book.getAuthors().size()]);
            message.setAuthors(Arrays.asList(cs));
        } else {
            message.setAuthors(null);
        }
        if (book.getCategories() == null) {
            CharSequence[] cs = book.getCategories().toArray(new CharSequence[book.getAuthors().size()]);
            message.setCategories(Arrays.asList(cs));
        } else {
            message.setCategories(null);
        }
        message.setTitle(book.getTitle());
        message.setIsbn(book.getIsbn());
        message.setPageCount(book.getPageCount());
        message.setPublishedDate(book.getPublishedDate());
        message.setCover(book.getCover());
        message.setShortDescription(book.getShortDescription());
        message.setLongDescription(book.getLongDescription());
        message.setStatus(book.getStatus());
        
        send(message, TOPIC_NAME);
    }
}
