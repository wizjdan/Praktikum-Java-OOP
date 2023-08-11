package entity;

/*
Class yang representasi dari data biasakan untuk membuat Getter dan Setternya
 */
public class TodoList {

    // Di Private ( Enkapsulasi )
    private String todo;

    // Constructur tanpa parameter
    public TodoList() {
    }

    //Constructur dengan parameter
    public TodoList(String todo) {
        this.todo = todo;
    }

    //Getter untuk mengambil data
    public String getTodo() {
        return todo;
    }

    //Setter untuk mengubah data
    public void setTodo(String todo) {
        this.todo = todo;
    }
}
