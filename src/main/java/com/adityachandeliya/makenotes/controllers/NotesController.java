package com.adityachandeliya.makenotes.controllers;

import com.adityachandeliya.makenotes.models.NoteRequestModel;
import com.adityachandeliya.makenotes.models.NoteResponseModel;
import com.adityachandeliya.makenotes.services.NotesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "/")
@RequiredArgsConstructor
public class NotesController {

    private NotesService notesService;

    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

    @PostMapping("create-note")
    public NoteResponseModel createNote(@RequestBody NoteRequestModel noteRequest) {
        return notesService.createNote(noteRequest.title(), noteRequest.body());
    }

    @GetMapping("get-note/{noteId}")
    public NoteResponseModel getNote(@PathVariable(name = "noteId") String noteId) {
        return notesService.getNote(noteId);
    }

    @GetMapping("get-all-notes")
    public List<NoteResponseModel> getAllNote() {
        return notesService.getAllNotes();
    }

    @DeleteMapping("delete-note")
    public String deleteNotes(@RequestBody List<String> noteIds) {
        notesService.deleteNotes(noteIds);
        return "Note(/s) deleted successfully";
    }


}
