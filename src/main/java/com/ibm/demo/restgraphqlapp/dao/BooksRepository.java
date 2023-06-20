package com.ibm.demo.restgraphqlapp.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import com.ibm.demo.restgraphqlapp.dto.Book;

public interface BooksRepository extends JpaRepository<Book, Integer> {
}