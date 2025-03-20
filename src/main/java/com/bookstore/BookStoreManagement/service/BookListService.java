package com.bookstore.BookStoreManagement.service;

import com.bookstore.BookStoreManagement.entity.BookList;
import com.bookstore.BookStoreManagement.repo.BookListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookListService {

    @Autowired
    BookListRepo mybook;


    public void saveMyBook(BookList book){
        mybook.save(book);

    }

    public List<BookList> getMyBook(){
        return mybook.findAll();
    }

    public void deleteById(int id){
        mybook.deleteById(id);
    }
}
