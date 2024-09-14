package com.example.server5.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserRequest {
    private String id;
    private String email;
    private String password;
}

