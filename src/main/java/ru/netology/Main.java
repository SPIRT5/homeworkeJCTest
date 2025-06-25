package ru.netology;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TodoList todoList = new TodoList();

        System.out.println("Добавление задач:");
        printResult(todoList.add("Купить хлеб"), "Купить хлеб");
        printResult(todoList.add("Сделать домашку"), "Сделать домашку");
        printResult(todoList.add("Купить хлеб"), "Купить хлеб (повтор)");

        System.out.println("\nТекущий список дел:");
        printTodos(todoList);

        System.out.println("\nУдаление задачи по номеру (2):");
        boolean removedByIndex = todoList.remove(2);
        System.out.println(removedByIndex ? "Удалено!" : "Ошибка при удалении.");
        printTodos(todoList);

        System.out.println("\nУдаление задачи по названию (\"Купить хлеб\"):");
        boolean removedByName = todoList.remove("Купить хлеб");
        System.out.println(removedByName ? "Удалено!" : "Не найдено.");
        printTodos(todoList);

        System.out.println("\nДобавим ещё задач:");
        todoList.add("Купить молоко");
        todoList.add("Купить сыр");
        todoList.add("Сходить на тренировку");
        printTodos(todoList);

        System.out.println("\nУдаление по ключевому слову (\"Купить\"):");
        boolean removedByKeyword = todoList.removeByKeyword("Купить");
        System.out.println(removedByKeyword ? "Удалены задачи с ключевым словом." : "Ничего не найдено.");
        printTodos(todoList);
    }

    private static void printResult(boolean success, String task) {
        System.out.println(success ? "Добавлено: " + task : "Уже существует: " + task);
    }

    private static void printTodos(TodoList todoList) {
        List<String> todos = todoList.getTodos();
        if (todos.isEmpty()) {
            System.out.println("Список дел пуст.");
        } else {
            for (int i = 0; i < todos.size(); i++) {
                System.out.println((i + 1) + ". " + todos.get(i));
            }
        }
    }
}