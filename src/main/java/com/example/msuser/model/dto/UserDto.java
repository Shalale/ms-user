package com.example.msuser.dto;

import com.example.msuser.constants.Status;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {
    private String username;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Status status;
}
