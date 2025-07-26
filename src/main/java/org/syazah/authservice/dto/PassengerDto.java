package org.syazah.authservice.dto;

import lombok.*;
import org.syazah.authservice.models.Passenger;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDto {
    private String id;

    private String email;

    private String password; // encrypted

    private String name;

    private String phoneNumber;

    private Date createdAt;

    public static PassengerDto from(Passenger p) {
        PassengerDto result = PassengerDto.builder()
                .id(p.getId().toString())
                .createdAt(p.getCreatedAt())
                .email(p.getEmail())
                .password(p.getPassword())
                .phoneNumber(p.getPhoneNumber())
                .name(p.getName())
                .build();
        return result;
    }
}
