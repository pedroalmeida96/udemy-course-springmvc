package academy.learnprogramming.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = "id") //assures that the equals and hashCode are only compared based on id.
public class ToDoItem {

    private int id;
    private String title;
    private String details;
    private LocalDate deadline;

    public ToDoItem(String title, String details, LocalDate deadline) {
        this.title = title;
        this.details = details;
        this.deadline = deadline;
    }
}
