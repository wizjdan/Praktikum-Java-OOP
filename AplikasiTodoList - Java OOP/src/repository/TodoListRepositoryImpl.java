package repository;

import entity.TodoList;

public class TodoListRepositoryImpl implements TodoListRepository{

    //Default 10
    public TodoList[] data = new TodoList[10];

    @Override
    public TodoList[] getAll() {
        return data;

    }

    public boolean isFull(){
        // cek apakah data penuh?
        var isFull = true;
        for (var i = 0; i < data.length ; i++) {
            if (data[i] == null){
                // data masih ada yang kosong
                isFull = false;
                break;
            }
        } return isFull;
    }

    public void resizeIsFUll(){
        // Jika data penuh maka Jumlah data array akan di kalikan 2 dari jumlah default sebelumnya 10
        if (isFull()){
            var temp = data;
            data = new TodoList[data.length * 2];

            for (int i = 0; i < temp.length ; i++) {
                data[i] = temp[i];
            }
        }
    }

    @Override
    public void add(TodoList todoList) {
        resizeIsFUll();

        // tambahkan ke posisi yang data array nya Null
        for (var i = 0; i < data.length ; i++) {
            if (data[i] == null) {
                data[i] = todoList;
                break;
            }
        }

    }

    @Override
    public boolean remove(Integer nomor) {
        if((nomor - 1) >= data.length){
            return false;
        }else if(data[nomor - 1] == null){
            return false;
        } else {
            for (int i = (nomor - 1); i < data.length; i++) {
                if (i == (data.length - 1)){
                    data[i] = null;
                } else {
                    data[i] = data[i +1];}
            }
            return true;
        }

    }
}
