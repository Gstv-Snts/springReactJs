package com.example.demo.TODO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
public class todoController {
    private final todoServices todoServices;

    @Autowired
    public todoController(todoServices todoServices) {
        this.todoServices = todoServices;
    }

    @GetMapping
    public List<TODO> getTODO(){
        return todoServices.getTODOS();
    }
    @PostMapping
    public void postTODO(@RequestBody TODO todo){
        todoServices.postTODO(todo);
    }
    @DeleteMapping(path = "{todoID}")
    public void deleteTODO(@PathVariable("todoID") Long todoID){
        todoServices.deleteTODO(todoID);
    }
    @PutMapping(path = "{todoID}")
    public void putTODO(@PathVariable("todoID") Long todoID, @RequestBody TODO todo){
        todoServices.putTODO(todoID, todo);
    }
}
