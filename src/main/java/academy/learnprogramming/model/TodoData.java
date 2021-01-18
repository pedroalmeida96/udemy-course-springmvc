package academy.learnprogramming.model;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class TodoData {

    //id of item todoItem. Usually this id would be managed by an incrementing column.
    private static int idValue = 1;

    private final List<ToDoItem> items = new ArrayList<>();

    public TodoData() {
        //add some dummy data
        addToDoItem(new ToDoItem("first", "first details", LocalDate.now()));
        addToDoItem(new ToDoItem("second", "second details", LocalDate.now()));
        addToDoItem(new ToDoItem("third", "third details", LocalDate.now()));
        addToDoItem(new ToDoItem("fourth", "fourth details", LocalDate.now()));
        addToDoItem(new ToDoItem("comer cona", "ate fartar", LocalDate.now()));
    }

    /*
    Collections.unmodifiableList so that if in other classes getItems is called those classes
    cant do getItems().add() ou getItems().remove(), etc. Imutable list. Only allowed to be modified with methods
    from this class.
    */
    public List<ToDoItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addToDoItem(@NonNull ToDoItem item) {
        item.setId(idValue);
        items.add(item);
        idValue++;
    }

    public void removeToDoItem(int id) {
        ListIterator<ToDoItem> itemListIterator = items.listIterator();
        while (itemListIterator.hasNext()) {
            ToDoItem toDoItem = itemListIterator.next();
            if (toDoItem.getId() == id) {
                items.remove(toDoItem);
                break;
            }
        }
    }

    public ToDoItem getItem(int id) {
        for (ToDoItem item : items) {
            if (id == item.getId()) {
                return item;
            }
        }
        return null;
    }

    public void updateToDoItem(ToDoItem toDoItemUpdate) {
        ListIterator<ToDoItem> itemListIterator = items.listIterator();
        while (itemListIterator.hasNext()) {
            ToDoItem toDoItem = itemListIterator.next();
            /*
            @EqualsAndHashCode(of = "id") were set in the class ToDoItem to only compare based on id.
            Here the only thing being compared is id. That is, we are never going to set a new id. When updating
            only will be altered the other fields. If the id is equal we set the id and the other fields will be different.
             */
            if (toDoItem.equals(toDoItemUpdate)) {
                itemListIterator.set(toDoItemUpdate);
                break;
            }
        }
    }
}
