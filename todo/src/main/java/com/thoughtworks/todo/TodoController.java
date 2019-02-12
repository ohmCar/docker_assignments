package com.thoughtworks.todo;

import org.json.JSONArray;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.nio.file.*;
import java.util.*;

@RestController
public class TodoController {
    @GetMapping("/todos")
    public String getTodos() throws IOException {
        return getTodoContent();
    }

    @PostMapping("/todos")
    public String saveTodo(@RequestBody Object todo) throws IOException {
        JSONArray todoContent = new JSONArray(getTodoContent());
        todoContent.put(todo);
        Files.write(getTodosFilePath(), Collections.singleton(todoContent.toString()));
        return todo.toString();
    }

    private Path getTodosFilePath() {
        String pwd = System.getProperty("user.dir");
        String filePath = pwd + "/todos.json";
        return Paths.get(filePath);
    }

    private String getTodoContent() throws IOException {
        List<String> content = Files.readAllLines(getTodosFilePath());
        return String.join(" ", content);
    }
}
