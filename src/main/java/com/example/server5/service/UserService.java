package com.example.server5.service;

import com.example.server5.dto.AddUserRequest;
import com.example.server5.entity.User;
import com.example.server5.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest dto) {
        // User 객체를 빌더 패턴으로 생성
        User user = User.builder()
                .email(dto.getEmail())
                .password(bCryptPasswordEncoder.encode(dto.getPassword())) // 패스워드 암호화
                .build();

        // 생성된 User 객체를 저장 후 ID 반환
        return userRepository.save(user).getId();
    }
}
