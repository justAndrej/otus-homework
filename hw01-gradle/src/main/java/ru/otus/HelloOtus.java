package ru.otus;

import com.google.common.base.Optional;

public class HelloOtus {
    public static void main(String... args) {
        Optional<String> greeting = Optional.of("Hello Otus!");
        System.out.println(greeting);
    }
}
