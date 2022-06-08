package myAcademy.learning.controller;

import lombok.extern.slf4j.Slf4j;
import myAcademy.learning.model.ToDoItem;
import myAcademy.learning.model.TodoData;
import myAcademy.learning.service.TodoItemService;
import myAcademy.learning.util.AttributeNames;
import myAcademy.learning.util.Mappings;
import myAcademy.learning.util.ViesNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Slf4j
@Controller
public class TodoItemController {
    //http://localhost:9980/todo-list/items
    private final TodoItemService todoItemService;

    @Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    @ModelAttribute
    public TodoData todoData(){
        return todoItemService.getData();
    }


    @GetMapping(Mappings.ITEMS)
    public String items(){
        return ViesNames.ITEMS_LIST;
    }

    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(@RequestParam(required = false,defaultValue = "-1") int id
            , Model model){
        ToDoItem toDoItem=todoItemService.getItem(id);
        if (toDoItem==null){
             toDoItem = new ToDoItem("","", LocalDate.now());
        }
        model.addAttribute(AttributeNames.TODO_ITEM,toDoItem);
        return ViesNames.ADD_ITEM;
    }


    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) ToDoItem toDoItem){
        log.info("todoItem from()= {}",toDoItem);
        if (toDoItem.getId()==0){
            todoItemService.addItem(toDoItem);
        }  else {
        todoItemService.updateItem(toDoItem);
        }
         return "redirect:/"+Mappings.ITEMS;
    }

    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam int id){
        log.info("Deleting item with id= {}",id);
        todoItemService.removeItem(id);
        return "redirect:/"+Mappings.ITEMS;
    }

    @GetMapping(Mappings.VIEW_ITEM)
    public String viewItem(@RequestParam int id,Model model){
        ToDoItem toDoItem = todoItemService.getItem(id);
        model.addAttribute(AttributeNames.TODO_ITEM,toDoItem);
        return ViesNames.VIEW_ITEM;
    }


}

