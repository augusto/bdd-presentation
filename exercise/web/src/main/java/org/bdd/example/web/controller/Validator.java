package org.bdd.example.web.controller;

public class Validator {
    private Validator() {}

    public static boolean isInteger(String string) {
        return string.matches("^[+-]?\\d+$");
    }
}
