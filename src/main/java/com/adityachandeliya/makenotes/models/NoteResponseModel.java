package com.adityachandeliya.makenotes.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class NoteResponseModel {
    @JsonProperty("noteId")
    private long id;
    private String title;
    private String body;
    private String createdAt;

    public NoteResponseModel(NoteModel noteModel) {
        this.id = noteModel.getId();
        this.title = noteModel.getTitle();
        this.body = noteModel.getBody();
        this.createdAt = noteModel.getCreatedAt().toString();
    }
}
