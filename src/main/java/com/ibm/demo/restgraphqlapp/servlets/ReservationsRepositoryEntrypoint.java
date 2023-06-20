package com.ibm.demo.restgraphqlapp.servlets;


import com.ibm.demo.restgraphqlapp.dao.BooksRepository;
import com.ibm.demo.restgraphqlapp.dao.ReservationRepository;
import com.ibm.demo.restgraphqlapp.dao.StudentRepository;
import com.ibm.demo.restgraphqlapp.dto.Book;
import com.ibm.demo.restgraphqlapp.dto.Reservation;
import com.ibm.demo.restgraphqlapp.dto.Student;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/reservations")
public class ReservationsRepositoryEntrypoint {

    @Resource
    private StudentRepository studentRepository;

    @Resource
    private BooksRepository booksRepository;

    @Resource
    private ReservationRepository reservationRepository;

    Logger logger = LoggerFactory.getLogger(ReservationsRepositoryEntrypoint.class);

    @GetMapping("/read")
    @Transactional
    public Reservation getReservation(@RequestParam final Integer id) {
        return reservationRepository.findById(id).get();
    }

    @GetMapping("/add")
    @Transactional
    public Reservation addReservation(@RequestParam final Integer studentId, @RequestParam final Integer bookId,
                                      @RequestParam final Integer reservationId) {

        Student student = studentRepository.getOne(studentId);
        logger.debug("found student " + student);

        Book book = booksRepository.getOne(bookId);
        logger.debug("found book " + book);

        return reservationRepository.save(new Reservation(book, student, reservationId));
    }


}
