package org.codewithcaleb.spring_boot_tdd_002.todo;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TodoHamcrestTest {

    @Test
    void shouldCreateNewTodo(){
        Todo test1 = new Todo("Test", true);
        Todo test2 = new Todo("Test", true);

        assertThat(test1,equalTo(test2));

    }
}
