package org.codewithcaleb.spring_boot_tdd_002.todo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TodoAssertJTest {

    @Test
    void shouldCreateNewTodo(){
        Todo test = new Todo("Test", true);

        //asertj gives us a more cleaner and fluent API and we can chain more easily readable asserts
        assertThat(test.name())
                .startsWith("T")
                .endsWith("t")
                .contains("es")
                .isEqualTo("Test");
    }
}
