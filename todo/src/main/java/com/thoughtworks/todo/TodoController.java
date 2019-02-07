package com.thoughtworks.todo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
    @RequestMapping("/todos")
    public String getTodos() {
     return "[{'Title: Buy', 'Description': 'Buy clothes this weekend'}, {'Title: Eat', 'Description: Eat pizza tonight}]";
    }
}
