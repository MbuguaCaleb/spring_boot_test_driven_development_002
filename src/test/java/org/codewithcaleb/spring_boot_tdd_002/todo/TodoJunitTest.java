package org.codewithcaleb.spring_boot_tdd_002.todo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TodoJunitTest {

    @Test
    void shouldCreateNewTodo(){
        Todo test = new Todo("Test", false);

        //Testing assertion on It
        //i check What i expected  vs what i got
        assertEquals("Test",test.name(),"TODO Name was Not Equal to Test");
        assertFalse(test.completed());
    }
}
