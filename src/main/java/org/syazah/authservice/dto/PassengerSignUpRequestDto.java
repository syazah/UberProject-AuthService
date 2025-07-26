package org.syazah.authservice.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassengerSignUpRequestDto  {
    String email;

    String password;

    String phoneNumber;

    String name;

}
