package service;

import entity.TodoList;
import repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService{

    //Semua data di akses melalui repository
    private TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void ShowTodoList() {
        TodoList[] model = todoListRepository.getAll();

        System.out.println("ToDo List");
        for (var i = 0; i < model.length ; i++) {
            var todolist = model[i];
            var nomor = i + 1;

            if (todolist != null){
                System.out.println(nomor + ". " + todolist.getTodo() );
            }
        }
    }

    @Override
    public void addTodoList(String todo) {
        TodoList todoList = new TodoList(todo);
        todoListRepository.add(todoList);

        System.out.println("Sukses menambahkan TodoList : " + todo);

    }

    @Override
    public void removeTodoList(Integer nomor) {
        boolean success = todoListRepository.remove(nomor);
        if (success){
            System.out.println("TodoList : " + nomor + " " + "Berhasil di Hapus");
        } else {
            System.out.println("TodoList : " + nomor + " " + "Gagal di Hapus");
        }

    }
}
