package org.syazah.authservice.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.syazah.authservice.helpers.AuthPassengerDetails;
import org.syazah.authservice.models.Passenger;

import java.util.Optional;

/**
 * this service is responsible to load the user in form of UserDetails Object
 */

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final PassengerRepository passengerRepository;

    public UserDetailServiceImpl(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Passenger> passenger = passengerRepository.findPassengerByEmail(email);
        if (passenger.isPresent()) {
            return new AuthPassengerDetails(passenger.get());
        } else {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
    }
}
