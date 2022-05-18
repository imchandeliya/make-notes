package com.adityachandeliya.makenotes.services;

import com.adityachandeliya.makenotes.exception.NoNoteFoundException;
import com.adityachandeliya.makenotes.models.NoteModel;
import com.adityachandeliya.makenotes.models.NoteResponseModel;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class NotesService {

    public static List<NoteModel> allNotes = new ArrayList<>();

    public NoteResponseModel createNote(String title, String body) {
        NoteModel newNote = NoteModel.createNote(title, body);
        allNotes.add(newNote);
        return new NoteResponseModel(newNote);
    }

    public NoteResponseModel getNote(long noteId) {
        Optional<NoteModel> note = allNotes.stream().filter(n -> Objects.equals(n.getId(), noteId) && !n.isDeleted()).findFirst();

        if (note.isPresent())
            return new NoteResponseModel(note.get());

        throw new NoNoteFoundException("No note found with the given id");
    }

    public List<NoteResponseModel> getAllNotes() {
        return NotesService.allNotes.stream().filter(n -> !n.isDeleted()).map(NoteResponseModel::new).collect(Collectors.toList());
    }

    public void deleteNotes(@NotNull(message = "Please provide note id(/s) to delete note") List<Long> noteIds) {
        HashSet noteIdSet = new HashSet(noteIds);

        for (NoteModel note : allNotes.stream().filter(n -> !n.isDeleted()).collect(Collectors.toList())) {
           if (noteIdSet.contains(note.getId()))
               note.deleteNote();
        }
    }
}
