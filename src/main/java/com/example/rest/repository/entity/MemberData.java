package com.example.rest.repository.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MemberData {
    private final String name;
    private final int age;
}
