package org.example.services;

import org.example.dto.AuthResponse;
import org.example.dto.SignInRequest;
import org.example.dto.SignUpRequest;
import org.example.model.UserEntity;

public interface UserService {

    UserEntity findUserById(Long id);

    boolean isTokenValid(String token);

    UserEntity findUserByEmail(String email);

    UserEntity findUserByNickname(String nickname);

    AuthResponse signUp(SignUpRequest request);

    AuthResponse signIn(SignInRequest request);

    AuthResponse signInByToken(String token);

}
