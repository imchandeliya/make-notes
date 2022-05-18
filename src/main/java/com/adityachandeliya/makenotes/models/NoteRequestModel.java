package com.adityachandeliya.makenotes.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class NoteRequestModel {
    private String title;
    private String body;
}
