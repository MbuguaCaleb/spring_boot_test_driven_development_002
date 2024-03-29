package org.codewithcaleb.spring_boot_tdd_002.todo;

import com.jayway.jsonpath.JsonPath;
import org.json.JSONException;
import org.junit.jupiter.api.Test;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TodoJsonTest {

    @Test
    void shouldCompareJson() throws JSONException {
        String data = getRestData();

        var expected = """
                {
                    "todos" : [
                        {
                            "name": "TEST 1",
                            "completed": true
                        },
                        {
                            "name": "TEST 2",
                            "completed": true
                        }
                    ]
                }
                """;

        //i am not just comparing strings but JSON Data
        //wow, that is why we need libralies
        //when strict is set to true, it forgives reordering of the keys
        assertEquals(expected,data,false);

    }


    @Test
    void shouldCompareJsonPath(){

        var json = """
                {
                    "todos" : [
                        {
                            "name": "TEST 1",
                            "completed": true
                        },
                        {
                            "name": "TEST 2",
                            "completed": true
                        }
                    ]
                }
                """;

        //JSON Path helps me get partucular properties of a JSON i am working with
        Integer length = JsonPath.read(json, "$.todos.length()");
        String name = JsonPath.read(json, "$.todos[1].name");

        assertEquals(2,length);
        assertEquals("TEST 2",name);

    }
    private String getRestData() {
        return """
                {
                    "todos" : [
                        {
                            "completed": true,
                            "name": "TEST 1"
                        },
                        {
                            "completed": true,
                            "name": "TEST 2"
                        }
                    ]
                }
                """;
    }
}
