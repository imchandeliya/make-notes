package com.adityachandeliya.makenotes.models;

import lombok.Builder;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record NoteModel(
        UUID id,
        LocalDateTime createdAt,
        String title,
        String body,
        @Setter boolean isDeleted
) {

    public static NoteModel createModel(String title, String body) {
        return new NoteModel(UUID.randomUUID(), LocalDateTime.now(), title.trim(), body.trim(), false);
    }

    public NoteModel markDeleted() {
        return new NoteModel(this.id(), this.createdAt(), this.title(), this.body(), true);
    }
}