package myAcademy.learning.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = "id")
public class ToDoItem {
    private int id;
    private String title;
    private String details;
    private LocalDate deadLine;

    public ToDoItem(String title, String details, LocalDate deadLine) {
        this.title = title;
        this.details = details;
        this.deadLine = deadLine;
    }




}
