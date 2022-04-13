package com.example.demo.TODO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TODOTest {

    @BeforeEach
    void setUp() {
        final TODO todo;
    }

    @Test
    void testToString() {
        //given
        TODO todo = new TODO();
        todo.setTask("Test");
        //then
        assertThat(todo.toString()).isEqualTo("TODO{id="+todo.getId()+", task='"+todo.getTask()+"', created="+todo.getCreated()+"}");
    }

    @Test
    void getId() {
        //given
        TODO todo = new TODO();
        todo.setId(30L);
        todo.setTask("Test");
        //then
        assertThat(todo.getId()).isEqualTo(30L);
    }

    @Test
    void setId() {
        //given
        TODO todo = new TODO();
        todo.setId(30L);
        todo.setTask("Test");
        //then
        assertThat(todo.getId()).isEqualTo(30L);
    }

    @Test
    void getTask() {
        //given
        TODO todo = new TODO();
        todo.setTask("Test");
        //then
        assertThat(todo.getTask()).isEqualTo("Test");
    }

    @Test
    void setTask() {
        //given
        TODO todo = new TODO();
        todo.setTask("Test");
        //then
        assertThat(todo.getTask()).isEqualTo("Test");
    }

    @Test
    void getCreated() {
        //given
        TODO todo = new TODO(1L, "Test", null);
        //then
        assertThat(todo.getCreated()).isNull();
    }

    @Test
    void setCreated() {
        //given
        TODO todo = new TODO(1L, "Test",null);
        todo.setCreated(LocalDateTime.now());
        //then
        assertThat(todo.getId()).isNotNull();
    }
}