package ru.netology;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class TodoListTest {

    @Test
    void testAdd() {
        TodoList list = new TodoList();
        assertTrue(list.add("Почитать книгу"));
        assertFalse(list.add("Почитать книгу")); // повтор
        assertEquals(List.of("Почитать книгу"), list.getTodos());
    }

    @Test
    void testRemoveByIndex() {
        TodoList list = new TodoList();
        list.add("Сделать уроки");
        list.add("Помыть посуду");
        assertTrue(list.remove(2)); // удаляет "Помыть посуду"
        assertEquals(List.of("Сделать уроки"), list.getTodos());

        assertFalse(list.remove(5)); // некорректный индекс
    }

    @Test
    void testRemoveByName() {
        TodoList list = new TodoList();
        list.add("Позвонить бабушке");
        assertTrue(list.remove("Позвонить бабушке"));
        assertFalse(list.remove("Не существует"));
    }

    @Test
    void testRemoveByKeyword() {
        TodoList list = new TodoList();
        list.add("Купить молоко");
        list.add("Купить хлеб");
        list.add("Сделать дз");

        assertTrue(list.removeByKeyword("Купить"));
        assertEquals(List.of("Сделать дз"), list.getTodos());

        assertFalse(list.removeByKeyword("Нет такого"));
    }

    @Test
    void testIsEmpty() {
        TodoList list = new TodoList();
        assertTrue(list.isEmpty());
        list.add("Что-то сделать");
        assertFalse(list.isEmpty());
    }
}
