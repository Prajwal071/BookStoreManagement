package com.bookstore.BookStoreManagement.controller;


import com.bookstore.BookStoreManagement.entity.Book;
import com.bookstore.BookStoreManagement.entity.BookList;
import com.bookstore.BookStoreManagement.service.BookListService;
import com.bookstore.BookStoreManagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    BookListService BookService;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister(){
        return "bookRegister";
    }


    @GetMapping("/available_books")
    public ModelAndView getAllBook(){

        List<Book> list = bookService.findAllBooks();
        return new ModelAndView("bookList","book",list);
    }


    @GetMapping("/my_books")
    public String myBook(Model model){
        List<BookList> myBook = BookService.getMyBook();
        model.addAttribute("book",myBook);
        return "myBooks";
    }



    @PostMapping("/save")

    public String saveBook(@ModelAttribute Book book){

        bookService.saveBook(book);

        return "redirect:/available_books";

    }


    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id){
        Book bookId = bookService.getBookById(id);
        BookList mybook = new BookList(bookId.getId(),bookId.getName(),bookId.getAuthor(),bookId.getPrice());
        BookService.saveMyBook(mybook);
        return "redirect:/my_books";
    }


    @RequestMapping("/deleteBook/{id}")

    public String deleteBook(@PathVariable ("id") int id){
        bookService.deleteById(id);
        return "redirect:/available_books";
    }



    @GetMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            throw new RuntimeException("Book not found with id: " + id);
        }
        model.addAttribute("book", book);
        return "bookEdit";
    }



}
