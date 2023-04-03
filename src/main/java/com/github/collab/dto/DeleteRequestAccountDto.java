package com.github.collab.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DeleteRequestAccountDto {

    private String email;

    private String password;

    @Builder
    public DeleteRequestAccountDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
