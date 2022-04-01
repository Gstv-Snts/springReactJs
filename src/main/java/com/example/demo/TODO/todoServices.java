package com.example.demo.TODO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class todoServices {
    private final todoRepository todoRepository;
    @Autowired
    public todoServices(todoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TODO> getTODOS(){
        return todoRepository.findAll();
    }
    public void postTODO(TODO todo){
    if(todoRepository.findTodoByTask(todo.getTask()).isEmpty() && todo.getTask() != null) {
        System.out.println(todo);
        todoRepository.save(todo);
    }else{
        throw new IllegalStateException("Task already exist or it is null!");
    }

    }
    public void deleteTODO(Long todoID){
        todoRepository.deleteById(todoID);
    }
    @Transactional
    public void putTODO(Long todoID, TODO todo){
        System.out.println(todoRepository.findById(todoID));
        System.out.println(todo);
        TODO a = todoRepository.getById(todoID);
        a.setTask(todo.getTask());
    }


}
