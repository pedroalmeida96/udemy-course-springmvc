package academy.learnprogramming.controller;

import academy.learnprogramming.model.ToDoItem;
import academy.learnprogramming.model.TodoData;
import academy.learnprogramming.service.TodoItemService;
import academy.learnprogramming.service.TodoItemServiceImpl;
import academy.learnprogramming.utils.AttributeNames;
import academy.learnprogramming.utils.Mappings;
import academy.learnprogramming.utils.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Slf4j
@Controller
public class ToDoItemController {

    private TodoItemService todoItemService;

    @Autowired
    public ToDoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    @ModelAttribute
    public TodoData todoData() {
        return todoItemService.getData();
    }

    /*
    The Objective is to display the todoItems in a html table in a jsp file.

    http://localhost:8080/todo-list/items

    Typing strings all over the code is a recipe for errors. So, creating a class for MAPPING is easier. Maybe even an ENUM;
     */

    @GetMapping(Mappings.ITEMS)
    public String items() {
        return ViewNames.ITEMS_LIST;
    }

    /*
    GetMapping + PostMapping has to do with POST,GET, etc http requests.

    http://localhost:8080/todo-list/add_items
     */

    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(Model model) {
        ToDoItem todoItem = new ToDoItem("", "", LocalDate.now());
        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.ADD_ITEMS;
    }

    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) ToDoItem toDoItem) {
        log.info("TodoItem info: {}", toDoItem);
        todoItemService.addItem(toDoItem);
        return "redirect:/" + Mappings.ITEMS;


    }


}
