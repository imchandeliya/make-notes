package com.adityachandeliya.makenotes.controllers;

import com.adityachandeliya.makenotes.models.NoteRequestModel;
import com.adityachandeliya.makenotes.models.NoteResponseModel;
import com.adityachandeliya.makenotes.services.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "/")
public class NotesController {

    @Autowired
    NotesService notesService;

    @PostMapping("create-note")
    public NoteResponseModel createNote(@RequestBody NoteRequestModel noteRequest) {
        return notesService.createNote(noteRequest.getTitle(), noteRequest.getBody());
    }

    @GetMapping("get-note/{noteId}")
    public NoteResponseModel getNote(@PathVariable(required = true, name = "noteId") long noteId) {
        return notesService.getNote(noteId);
    }

    @GetMapping("get-all-notes")
    public List<NoteResponseModel> getAllNote() {
        return notesService.getAllNotes();
    }

    @DeleteMapping("delete-note")
    public String deleteNotes(@RequestBody List<Long> noteIds) {
        notesService.deleteNotes(noteIds);
        return "Note(/s) deleted successfully";
    }


}
