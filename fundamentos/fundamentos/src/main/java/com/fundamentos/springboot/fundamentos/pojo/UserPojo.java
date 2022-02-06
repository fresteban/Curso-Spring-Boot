package com.fundamentos.springboot.fundamentos.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties(prefix = "user")
@ConstructorBinding
@Getter
@Setter
@AllArgsConstructor

public class UserPojo {
    private String email;
    private String password;
    private int age;
}
