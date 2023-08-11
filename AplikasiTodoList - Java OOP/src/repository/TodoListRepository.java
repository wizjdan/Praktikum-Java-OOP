package repository;

import entity.TodoList;

public interface TodoListRepository {

    // Untuk menampilkan TodoList
    TodoList[] getAll();

    // Untuk menambahkan TodoList
    void add(TodoList todoList);

    // Untuk menghapus TodoList
    boolean remove(Integer number);


}
