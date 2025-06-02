package org.example.model;

import org.example.repository.TaskRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TaskTest {

    private TaskRepository repository;

    @Test
    public void testValidaModelo(){
        Task task = new Task("Titulo","Descripcion");
        assertNotNull(task);
    }

    @Test
    void testnNoGuardaConTituloNulo() {
        Task task = new Task(null,"xyz");
        assertThrows(Exception.class, () -> {
            repository.saveAndFlush(task);
        });
    }

    @Test
    void testnNoGuardaConDescripcionNula() {
        Task task = new Task("Titulo",null);
        assertThrows(Exception.class, () -> {
            repository.saveAndFlush(task);
        });
    }


}
