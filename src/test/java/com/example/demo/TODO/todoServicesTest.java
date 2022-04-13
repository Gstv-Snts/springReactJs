package com.example.demo.TODO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.*;
@DataJpaTest
@ExtendWith(MockitoExtension.class)
class todoServicesTest {
    @Autowired
    private todoRepository todoRepository;
    private todoServices todoServices;

    @BeforeEach
    void setUp() {
        todoServices = new todoServices(todoRepository);
    }

    @AfterEach
    void tearDown() {
        todoRepository.deleteAllInBatch();
    }

    @Test
    void getTODOS() {
        //given
        TODO todo = new TODO();
        todo.setTask("Test");
        todoRepository.save(todo);
        //then
        assertThat(todoServices.getTODOS()).isNotNull();
    }

    @Test
    void postTODOShouldWork() {
        //given
        TODO todo = new TODO();
        todo.setTask("Test");
        todoServices.postTODO(todo);
        //then
        assertThat(todoRepository.findAll()).isNotNull();
    }
    @Test
    void postTODOShouldNotWork() {
        assertThatThrownBy(() ->{
            todoServices.postTODO(new TODO());
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void shouldDeleteTODO() {
        //given

        TODO todo = new TODO();
        todo.setTask("Test");
        todoRepository.save(todo);

        //then

        System.out.println(todoRepository.findAll());
        todoServices.deleteTODO(2L);
        assertThat(todoRepository.findAll().toString()).isEqualTo("[]");
    }
    @Test
    void shouldNotDeleteTODO() {
        assertThatThrownBy(()->todoServices.deleteTODO(2L)).isInstanceOf(IllegalStateException.class);
    }
    @Test
    void putTODO() {
        //given
        TODO firstTodo = new TODO();
        firstTodo.setTask("Test");
        todoRepository.save(firstTodo);

        TODO secondTodo = new TODO();
        secondTodo.setTask("Test2");
        todoServices.putTODO(1L,secondTodo);
        //then

        assertThat(todoRepository.getById(1L).getTask()).isEqualTo("Test2");
    }
}