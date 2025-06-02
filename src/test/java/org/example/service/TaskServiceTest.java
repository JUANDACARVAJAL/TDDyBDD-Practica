package org.example.service;

import org.example.model.Task;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    private TaskService service;


    @Test
    void testGuardaTareaConParametros() {
        service = new TaskService();
        Task task = new Task("Titulo","Descripcion");
        Task saved = service.addTask(task);

        service.getTasks();
        assertNotNull(saved.getId());
        assertEquals("Titulo", saved.getTitle());
        assertEquals("Descripcion", saved.getDescription());
        assertFalse(saved.isCompleted());
    }

}
