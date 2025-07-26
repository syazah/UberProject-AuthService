package org.syazah.authservice.services;

import org.springframework.data.repository.Repository;
import org.syazah.authservice.models.Passenger;

import java.util.Optional;

interface PassengerRepository extends Repository<Passenger, Long> {
    Optional<Passenger> findPassengerByEmail(String email);
}
