package myAcademy.learning.service;

import lombok.Getter;
import myAcademy.learning.model.ToDoItem;
import myAcademy.learning.model.TodoData;
import org.springframework.stereotype.Service;

@Service
public class TodoItemServiceImpl implements TodoItemService{

    @Getter
    private final TodoData data =new TodoData();


    @Override
    public void addItem(ToDoItem toAdd) {
        data.addItem(toAdd);
    }

    @Override
    public void removeItem(int id) {
        data.removeItem(id);
    }

    @Override
    public ToDoItem getItem(int id) {
        return data.getItem(id);
    }

    @Override
    public void updateItem(ToDoItem toUpdate) {
        data.updateItem(toUpdate);
    }

}
