package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Task;
import org.example.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TaskControllerService.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCrearTareaPorServicio_Retorna201() throws Exception {
        Task input = new Task( "Tarea de prueba", "Descripción de prueba");
        Task saved = new Task( "Tarea de prueba", "Descripción de prueba");

        given(repository.save(any(Task.class))).willReturn(saved);

        mockMvc.perform(post("/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title").value("Tarea de prueba"))
                .andExpect(jsonPath("$.description").value("Descripción de prueba"))
                .andExpect(jsonPath("$.completed").value(false));
    }
}
