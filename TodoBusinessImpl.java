package Business;

import todotask.TodoService;

import java.util.ArrayList;
import java.util.List;

public class TodoBusinessImpl {

    private TodoService todoService;

    public TodoBusinessImpl(TodoService todoService) {
        this.todoService = todoService;
    }

    public List<String> retrieveTodos(String user){
        List<String> filterTodos = new ArrayList<>();
        List<String> todos = todoService.retrieveTodos(user);

        for (String todo : todos){
            if(todo.contains("Mumbai")){
                filterTodos.add(todo);
            }
        }
        return filterTodos;
    }

    public void deleteTodosNotRelatedToSpring(String user) {
        List<String> todos = todoService.retrieveTodos(user);
        for (String todo : todos) {
            if (!todo.contains("Mumbai")) {
                todoService.deleteTodo(todo);
            }
        }
    }
}
