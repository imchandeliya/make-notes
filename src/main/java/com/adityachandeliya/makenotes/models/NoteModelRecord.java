package com.adityachandeliya.makenotes.models;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record NoteModelRecord(
        long id,
        LocalDateTime createdAt,
        String title,
        String body
) {
}
