package com.bookstore.BookStoreManagement.service;


import com.bookstore.BookStoreManagement.entity.Book;
import com.bookstore.BookStoreManagement.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepo bookRepo;


    //    saving books
    public void saveBook(Book book){

        bookRepo.save(book);

    }

    //    Fetching all Books
    public List<Book> findAllBooks(){
        return bookRepo.findAll();
    }


    public Book getBookById(int id){
        return bookRepo.findById(id).get();

    }

    public void deleteById(int id){
        bookRepo.deleteById(id);
    }
}
