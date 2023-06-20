package com.ibm.demo.restgraphqlapp.dao;


import com.ibm.demo.restgraphqlapp.dto.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}