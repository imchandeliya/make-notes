package com.adityachandeliya.makenotes.models;

import com.adityachandeliya.makenotes.services.NotesService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NoteModel {
    private long id;
    private LocalDateTime createdAt;
    private String title;
    private String body;

    private boolean isDeleted = false;

    public static NoteModel createNote(String title, String body) {
        long index = NotesService.allNotes.isEmpty() ? 1 : (
                        Objects.nonNull(NotesService.allNotes.get(NotesService.allNotes.size() - 1)) ?
                        NotesService.allNotes.get(NotesService.allNotes.size() - 1).getId() + 1 : 1
        );
        return new NoteModel(index, LocalDateTime.now(), title, body, false);
    }

    public void deleteNote() {
        this.isDeleted = true;
    }
}
