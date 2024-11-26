package org.example.dto;

import lombok.*;
import org.example.model.UserEntity;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {

    private int status;

    private String statusDesc;

    private UserEntity user;

}
