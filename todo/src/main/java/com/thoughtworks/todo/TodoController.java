package com.thoughtworks.todo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class TodoController {
    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    public String getTodos() throws IOException {
        return getTodoContent();
    }

    private String getTodoContent() throws IOException {
        String pwd = System.getProperty("user.dir");
        String filePath = pwd + "/todos.json";
        List<String> content = Files.readAllLines(Paths.get(filePath));
        return String.join(" ", content);
    }
}
