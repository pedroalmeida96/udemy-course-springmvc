package academy.learnprogramming.controller;

import academy.learnprogramming.model.TodoData;
import academy.learnprogramming.utils.Mappings;
import academy.learnprogramming.utils.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ToDoItemController {

    @ModelAttribute
    public TodoData todoData() {
        return new TodoData();
    }

    /*
    The Objective is to display the todoItems in a html table in a jsp file.

    http://localhost:8080/todo-list/items

    Typing strings all over the code is a recipe for errors. So, creating a class for MAPPING is easier. Maybe even an ENUM;
     */

    @GetMapping(Mappings.ITEMS)
    public String welcome() {
        return ViewNames.ITEMS_LIST;
    }


}
