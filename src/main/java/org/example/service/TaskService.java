package org.example.service;

import org.example.model.Task;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.*;
import java.util.*;

public class TaskService {

    private Connection conn;
    private JdbcTemplate jdbcTemplate;

    public TaskService() {
        try {
            conn = DriverManager.getConnection("jdbc:h2:mem:tasks;DB_CLOSE_DELAY=-1");
            conn.createStatement().executeUpdate(
                    "CREATE TABLE tasks (id IDENTITY PRIMARY KEY, title VARCHAR, description VARCHAR, completed BOOLEAN)"
            );
        } catch (SQLException e) {
           // throw new RuntimeException(e);
        }
    }

    public Task addTask(Task task) {
        try {
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO tasks (title, description, completed) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS
            );
            stmt.setString(1, task.getTitle());
            stmt.setString(2, task.getDescription());
            stmt.setBoolean(3, false);
            stmt.executeUpdate();

            ResultSet keys = stmt.getGeneratedKeys();
            if (keys.next()) {
                task.setId(keys.getInt(1));
            }
            return task;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Task> getTasks() {
        List<Task> tasks = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM tasks");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Task task = new Task("dd","");
                task.setId(rs.getInt("id"));
                task.setTitle(rs.getString("title"));
                task.setDescription(rs.getString("description"));
                tasks.add(task);
            }

            return tasks;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}