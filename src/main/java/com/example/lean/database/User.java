package com.example.lean.database;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String userId;

    private String userName;
    private String sex;
    private int age;
}
