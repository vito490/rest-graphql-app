package com.ibm.demo.restgraphqlapp.servlets;

import com.ibm.demo.restgraphqlapp.dao.BooksRepository;
import com.ibm.demo.restgraphqlapp.dao.ReservationRepository;
import com.ibm.demo.restgraphqlapp.dao.StudentRepository;
import com.ibm.demo.restgraphqlapp.dto.Book;
import com.ibm.demo.restgraphqlapp.dto.Reservation;
import com.ibm.demo.restgraphqlapp.dto.Student;
import jakarta.annotation.Resource;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;


@Controller
public class GraphQLEntrypoint {

    @Resource
    private BooksRepository booksRepository;
    @Resource
    private StudentRepository studentRepository;
    @Resource
    private ReservationRepository reservationRepository;

    @QueryMapping
    public Book bookById(@Argument String id) {
        return booksRepository.findById(Integer.valueOf(id)).get();
    }

    @QueryMapping
    public Student studentById(@Argument String id) {
        return studentRepository.findById(Integer.valueOf(id)).get();
    }

    @QueryMapping
    public Reservation reservationById(@Argument String id) {
        return reservationRepository.findById(Integer.valueOf(id)).get();
    }


    @SchemaMapping
    public Book book(Reservation reservation) {
        return booksRepository.findById(reservation.getBook().getId()).get();
    }
    @SchemaMapping
    public Student student(Reservation reservation) {
        return studentRepository.findById(reservation.getStudent().getId()).get();
    }
}