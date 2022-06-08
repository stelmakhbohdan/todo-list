package myAcademy.learning.service;

import myAcademy.learning.model.ToDoItem;
import myAcademy.learning.model.TodoData;

public interface TodoItemService {
    void addItem(ToDoItem toAdd);
    void removeItem(int id);
    ToDoItem getItem(int id);
    void updateItem(ToDoItem toUpdate);
    TodoData getData();
}
