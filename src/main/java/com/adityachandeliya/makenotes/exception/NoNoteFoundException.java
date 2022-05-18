package com.adityachandeliya.makenotes.exception;

public class NoNoteFoundException extends RuntimeException{
    public NoNoteFoundException(String message) {
        super(message);
    }
}
