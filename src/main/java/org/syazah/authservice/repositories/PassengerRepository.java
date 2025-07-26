package org.syazah.authservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.syazah.authservice.models.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
