package org.example.dto;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SignInRequest {

    private String email;

    private String password;

}
