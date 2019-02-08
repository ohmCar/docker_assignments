package com.thoughtworks.todo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    public String getTodos() {
        System.out.println("Aa gaya yaha pe bhi");
        return "[{'Title: Buy', 'Description': 'Buy clothes this weekend'}, {'Title: Eat', 'Description: Eat pizza tonight}]";
    }
}
