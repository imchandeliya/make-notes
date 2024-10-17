package com.adityachandeliya.makenotes.controllers;

import com.adityachandeliya.makenotes.models.NoteRequestModel;
import com.adityachandeliya.makenotes.models.NoteResponseModel;
import com.adityachandeliya.makenotes.services.NotesService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.UUID;

class NotesControllerTest {


    private NotesController controller;
    private NotesService service = Mockito.mock(NotesService.class);


    @BeforeEach
    void setUp() {
        controller = new NotesController(service);
    }

    @Test
    void createNote() {
        NoteRequestModel noteRequestModel = new NoteRequestModel("some title", "lorem ipsum dolar sit amet");
        NoteResponseModel expectedResponse = NoteResponseModel.builder()
                .title(noteRequestModel.title())
                .createdAt(LocalDateTime.now().toString())
                .id(UUID.randomUUID().toString())
                .body(noteRequestModel.body())
                .build();

        Mockito.when(service.createNote(noteRequestModel.title(), noteRequestModel.body())).thenReturn(expectedResponse);

        NoteResponseModel response = controller.createNote(noteRequestModel);
        Assertions.assertThat(response)
                .usingRecursiveComparison()
                .ignoringFields("id", "body", "createdAt")
                .isEqualTo(expectedResponse);
    }

    @Test
    void getNote() {
    }

    @Test
    void getAllNote() {
    }

    @Test
    void deleteNotes() {
    }
}