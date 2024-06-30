package Business;

import org.junit.jupiter.api.Test;
import todotask.TodoService;
import todotask.TodoServiceStub;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TodoBusinessImplStubsTest {

    @Test
    void testRetrieveTodosUsingStubs() {
        TodoService todoServiceStub = new TodoServiceStub();
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceStub);
        List<String> filteredTodos = todoBusiness.retrieveTodos("Tushar");
        assertEquals(4,filteredTodos.size());
    }
}