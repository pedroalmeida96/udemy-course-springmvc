package academy.learnprogramming.service;

import academy.learnprogramming.model.ToDoItem;
import academy.learnprogramming.model.TodoData;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class TodoItemServiceImpl implements TodoItemService {

    @Getter
    private final TodoData data = new TodoData();

    @Override
    public void addItem(ToDoItem toDoItem) {
        data.addToDoItem(toDoItem);
    }

    @Override
    public void removeItem(int itemId) {
        data.removeToDoItem(itemId);
    }

    @Override
    public ToDoItem getItem(int itemId) {
        return data.getItem(itemId);
    }

    @Override
    public void updateItem(ToDoItem toDoItem) {
        data.updateToDoItem(toDoItem);
    }
}
