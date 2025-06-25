package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private final ArrayList<String> todoList = new ArrayList<>();

    public boolean add(String todo) {
        if (!todoList.contains(todo)) {
            todoList.add(todo);
            return true; // добавлено
        }
        return false; // уже существует
    }

    public boolean remove(int index) {
        if (index >= 1 && index <= todoList.size()) {
            todoList.remove(index - 1);
            return true; // успешно удалено
        }
        return false; // некорректный номер
    }

    public boolean remove(String todo) {
        return todoList.removeIf(task -> task.equals(todo));
    }

    public boolean removeByKeyword(String keyword) {
        return todoList.removeIf(task -> task.contains(keyword));
    }

    public List<String> getTodos() {
        return new ArrayList<>(todoList); // копия, чтобы не изменяли напрямую
    }

    public boolean isEmpty() {
        return todoList.isEmpty();
    }
}

