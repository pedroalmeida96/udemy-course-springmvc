package academy.learnprogramming.controller;

import academy.learnprogramming.model.ToDoItem;
import academy.learnprogramming.model.TodoData;
import academy.learnprogramming.service.TodoItemService;
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
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Slf4j
@Controller
public class ToDoItemController {

    // == fields ==
    private final TodoItemService todoItemService;

    // == constructors ==
    @Autowired
    public ToDoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    // == model attributes ==
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
    public String addEditItem(@RequestParam(required = false, defaultValue = "-1") int id, Model model) {

        log.info("editing id = {}", id);
        ToDoItem todoItem = todoItemService.getItem(id);

        if (todoItem == null) {
            todoItem = new ToDoItem("", "", LocalDate.now());
        }

        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.ADD_ITEMS;
    }

        /*
    Adds a new item from the page to add items.
     */


    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) ToDoItem todoItem) {
        log.info("todoItem from from = {}", todoItem);

        if (todoItem.getId() == 0) {
            todoItemService.addItem(todoItem);
        } else {
            todoItemService.updateItem(todoItem);
        }

        return "redirect:/" + Mappings.ITEMS;
    }
    /*
    Based on the id an item is deleted. The request is send when the delete button is processed to the jsp.
     */

    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam int id) {
        log.info("Deleting item with id= {}", id);
        todoItemService.removeItem(id);
        return "redirect:/" + Mappings.ITEMS;
    }
}
