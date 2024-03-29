package org.codewithcaleb.spring_boot_tdd_002.todo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//WebMvTest is the recommended test.It is a slice test
//WebMvc does not bring on components into the testContext.It only brings components associated
//With the WebLayer // with therefore mock things like the repositories that the web layer depend on
@WebMvcTest(TodoController.class)
class TodoControllerTest {

    //Used to make mockedRequests
    @Autowired
    MockMvc mockMvc;

    //a successful result should result to something else
    //That is what i am intresed in //i will mock out the repository//
    // things that are external eg database calls,(for these i can write necessary intrgration tests)
    @MockBean
    TodoRepository todoRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void shouldFindAllTodos() throws Exception {

        //if i mock what a working repo would give then after that get the right results in regard to what i am testing,
        //My Testcase has passed

        //mostly after fetching data there is something else, if i get the right expected result after that. Then my test has
        //passed

        //we take the repository out of the equation
        //When the todoRepo is called we are taking it out of the equation by mockingIt.
        //We test the inputs and outputs of the Web,not integrations to the database

        List<Todo> todos = List.of(new Todo("test 1", true), new Todo("test2", true));
        Mockito.when(todoRepository.findAll()).thenReturn(todos);


        //Simple mock MVC Example

        /**
        MvcResult mvcResult = mockMvc.perform(get("/api/todos")).andReturn();
        assertEquals(200,mvcResult.getResponse().getStatus());

         **/


        //More result matchers from MockMvc

        //**Example Two**/
        /**
        mockMvc.perform(get("/api/todos"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(todos)));
         **/

        //We can be able to chain matcher methods as well
        mockMvc.perform(get("/api/todos"))
                .andExpectAll(
                        status().isOk(),
                        content().json(objectMapper.writeValueAsString(todos))
                        );

    }
}