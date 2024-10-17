package com.adityachandeliya.makenotes.services;

import com.adityachandeliya.makenotes.exception.NoNoteFoundException;
import com.adityachandeliya.makenotes.models.NoteModel;
import com.adityachandeliya.makenotes.models.NoteResponseModel;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class NotesService {

    public static List<NoteModel> allNotes = new ArrayList<>();

    public NoteResponseModel createNote(String title, String body) {
        NoteModel newNote = NoteModel.createModel(title, body);

        allNotes.add(newNote);
        return NoteResponseModel.createMetaResponse(newNote);
    }

    public NoteResponseModel getNote(String noteId) {
        return allNotes.stream().filter(note -> note.id().toString().equals(noteId))
                .filter(note -> !note.isDeleted())
                .findFirst()
                .map(NoteResponseModel::createFullResponse)
                .orElseThrow(() -> new NoNoteFoundException("No note found with the given id"));
    }

    public List<NoteResponseModel> getAllNotes() {
        return NotesService.allNotes.stream()
                .filter(note -> !note.isDeleted())
                .map(NoteResponseModel::createFullResponse).collect(Collectors.toList());
    }

    public void deleteNotes(@NonNull() List<String> noteIds) {
        Set<String> noteIdSet = new HashSet<>(noteIds);

        allNotes = allNotes.stream()
                .filter(note -> !note.isDeleted())
                .filter(note -> noteIdSet.contains(note.id().toString()))
                .map(NoteModel::markDeleted)
                .toList();
    }
}
