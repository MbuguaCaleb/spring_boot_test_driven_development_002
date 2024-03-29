package org.codewithcaleb.spring_boot_tdd_002.todo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoRepository {

    private static final Logger log = LoggerFactory.getLogger(TodoRepository.class);

    List<Todo> todos;

    public TodoRepository() {
        todos = List.of(new Todo("test 1", true),new Todo("test2",true));
    }

    List<Todo> findAll(){
        log.info("TodoRepository findAll() called..");
        return todos;
    }
}
