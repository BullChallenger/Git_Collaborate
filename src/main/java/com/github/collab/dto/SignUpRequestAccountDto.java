package com.github.collab.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.github.collab.domain.Account;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignUpRequestAccountDto {

    private String email;

    private String password;

    private String checkPassword;

    private String name;

    @Builder
    public SignUpRequestAccountDto(String email, String password, String checkPassword, String name) {
        this.email = email;
        this.password = password;
        this.checkPassword = checkPassword;
        this.name = name;
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class SignUpRequestAccountDtoBuilder {
    }

    public Account toEntity(SignUpRequestAccountDto accountDto) {

        return Account.builder()
                        .email(accountDto.email)
                        .password(accountDto.password)
                        .name(accountDto.name)
                .build();
    }
}
