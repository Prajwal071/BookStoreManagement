package com.bookstore.BookStoreManagement.controller;

import com.bookstore.BookStoreManagement.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookListController {

    @Autowired
    BookRepo myBook;

    @RequestMapping("/deleteMyList/{id}")
    public String deleteMyList(@PathVariable("id") int id){
        myBook.deleteById(id);
        return "redirect:/my_books";

    }
}
