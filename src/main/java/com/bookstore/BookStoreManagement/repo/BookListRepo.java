package com.bookstore.BookStoreManagement.repo;


import com.bookstore.BookStoreManagement.entity.BookList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookListRepo extends JpaRepository<BookList,Integer> {
}
