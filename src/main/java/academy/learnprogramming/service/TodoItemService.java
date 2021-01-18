package academy.learnprogramming.service;

import academy.learnprogramming.model.ToDoItem;
import academy.learnprogramming.model.TodoData;

public interface TodoItemService {

    void addItem(ToDoItem toDoItem);

    void removeItem(int itemId);

    ToDoItem getItem(int itemId);

    void updateItem(ToDoItem toDoItem);

    TodoData getData();

}
