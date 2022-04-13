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
        System.out.println("Criando task: "+todo);
        todoRepository.save(todo);
        System.out.println(todoRepository.findAll());
    }else{
        throw new IllegalStateException("Task already exist or it is null!");
    }

    }
    public void deleteTODO(Long todoID){
        if(todoRepository.findById(todoID).isEmpty()) {
            throw new IllegalStateException("TODO doesnt exists");
        }
        System.out.println("Deletando ID: "+todoID);
        todoRepository.deleteById(todoID);
    }
    @Transactional
    public void putTODO(Long todoID, TODO newTask){
        System.out.println(todoID);
        System.out.println(newTask);
        todoRepository.getById(todoID).setTask(newTask.getTask());
    }
}
