package com.ibm.demo.restgraphqlapp.servlets;

import com.ibm.demo.restgraphqlapp.dao.BooksRepository;
import com.ibm.demo.restgraphqlapp.dto.Book;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/books")
public class BooksRepositoryEntrypoint {

    @Resource
    private BooksRepository booksRepository;

    @GetMapping("/read")
    @Transactional
    public Book getBook(@RequestParam final Integer id) {
        return booksRepository.findById(id).get();
    }

    @GetMapping("/add")
    @Transactional
    public Book addBook(@RequestParam final Integer id, @RequestParam final String name,
                        @RequestParam final String isbn) {
        Book student = new Book(id, name, isbn);
        return booksRepository.save(student);
    }
}
