package com.indiumsoftware.quizapp.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserResponse {
    private int id;
    private String userResponse;

    public UserResponse(int id, String userResponse) {
        this.id = id;
        this.userResponse = userResponse;
    }
}
