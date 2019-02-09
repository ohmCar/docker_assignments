package com.thoughtworks.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class TodoController {
    @GetMapping("/todos")
    public String getTodos() throws IOException {
        return getTodoContent();
    }

    private String getTodoContent() throws IOException {
        String pwd = System.getProperty("user.dir");
        String filePath = pwd + "/todos.json";
        List<String> content = Files.readAllLines(Paths.get(filePath));
        return String.join(" ", content);
    }

    @PostMapping("/todos")
    public String saveTodo(@RequestBody Object todo) {
        return todo.toString();
    }
}
