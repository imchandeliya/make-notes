package com.adityachandeliya.makenotes.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record NoteResponseModel(
        @JsonProperty("noteId")
        String id,
        String title,
        String body,
        String createdAt
) {

    public static NoteResponseModel createMetaResponse(NoteModel model) {
        return new NoteResponseModel(model.id().toString(), model.title(), null, model.createdAt().toString());
    }

    public static NoteResponseModel createFullResponse(NoteModel model) {
        return new NoteResponseModel(model.id().toString(), model.title(), model.body(), model.createdAt().toString());
    }
}
