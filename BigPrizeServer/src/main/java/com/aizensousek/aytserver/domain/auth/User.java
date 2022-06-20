package com.aizensousek.aytserver.domain.auth;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Size;


@Builder
@Data
public class User {
    @Size(min = 2, max = 20)
    private String name;
    @Size(min = 2, max = 20)
    private String password;
}