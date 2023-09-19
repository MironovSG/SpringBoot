package ru.mironov.MySecondTestAppSpringBoot.exception;

public class UnsupportedCodeException extends Exception {
    public UnsupportedCodeException() {
        super("Code '123' notSupported");
    }
}
