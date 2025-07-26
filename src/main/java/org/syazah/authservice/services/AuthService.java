package org.syazah.authservice.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.syazah.authservice.dto.PassengerDto;
import org.syazah.authservice.dto.PassengerSignUpRequestDto;
import org.syazah.authservice.models.Passenger;
import org.syazah.authservice.repositories.PassengerRepository;

@Service
public class AuthService {
    private final PassengerRepository passengerRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthService(PassengerRepository passengerRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.passengerRepository = passengerRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public PassengerDto signupPassenger(PassengerSignUpRequestDto passengerSignUpRequestDto) {
        Passenger passenger = Passenger.builder()
                .email(passengerSignUpRequestDto
                        .getEmail())
                .name(passengerSignUpRequestDto.getName())
                .phoneNumber(passengerSignUpRequestDto.getPhoneNumber())
                .password(bCryptPasswordEncoder.encode(passengerSignUpRequestDto.getPassword()))
                .build();
        Passenger newPassenger = passengerRepository.save(passenger);
        return PassengerDto.from(newPassenger);
    }
}
