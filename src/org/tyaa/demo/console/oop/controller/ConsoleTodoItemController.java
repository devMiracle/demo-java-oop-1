package org.tyaa.demo.console.oop.controller;

import org.tyaa.demo.console.oop.model.TodoItem;
import org.tyaa.demo.console.oop.repository.TodoItemRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public final class ConsoleTodoItemController extends AbstractTodoItemController {

    private Scanner scanner;

    private static class Constants {
        public final static String PLACEHOLDER_SYMBOLS = "***";
    }

    public class UserDialog {

        public void create() {
            System.out.println("Input title then press Enter");
            String title = scanner.nextLine();
            System.out.println("Input description then press Enter");
            String description = scanner.nextLine();
            System.out.println("Input date (YYYY.MM.DD) then press Enter");
            String dateString = scanner.nextLine();
            String[] words = dateString.split("\\s|,|:|\\.");
            Date date = new Date(Integer.parseInt(words[0]) - 1900, Integer.parseInt(words[1]) - 1, Integer.parseInt((words[2])));
            System.out.println(date.toString());
            TodoItem item = new TodoItem(title, description, date);
            todoItemRepository.add(item);
            System.out.println(Constants.PLACEHOLDER_SYMBOLS);
        }

        public void printAll() {
            for (TodoItem item : todoItemRepository.getAll()) {
                System.out.println(item);
            }
            System.out.println(Constants.PLACEHOLDER_SYMBOLS);
        }
    }

    public ConsoleTodoItemController(TodoItemRepository todoItemRepository) {
        super(todoItemRepository);
        scanner = new Scanner(System.in);
    }

    @Override
    public void create(TodoItem item) {
        this.todoItemRepository.add(item);
    }

    @Override
    public List<TodoItem> getAll() {
        return this.todoItemRepository.getAll();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        scanner.close();
        System.out.println("ConsoleTodoItemController finalize");
    }
}
