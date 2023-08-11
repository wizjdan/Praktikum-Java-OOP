public class Main {
    /*
    Jumlah data Todo List yang dapat di simpan maksimal 10
     */
    public static String[] data = new String[10];
    /*
    Untuk Menerima Input daru user
     */
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();

    }
    /*
    Menampilkan Todo List
     */
    public static void showTodoList(){
        System.out.println("ToDo List");
        for (var i = 0; i < data.length ; i++) {
            var todo = data[i];
            var nomor = i + 1;

            if (todo != null){
                System.out.println(nomor + ". " + todo );
            }
        }
    }
    public static void testShowTodoList(){
        data[0] = "Belajar Java Dasar";
        data[1] = "Belajar Java OOP";
        showTodoList();
    }
    /*
    Tampilan ketika Todo List di tambahkan
     */
    public static void addTodoList(String todo){

        // cek apakah data penuh?
        var full = true;
        for (var i = 0; i < data.length ; i++) {
            if (data[i] == null){
                // data masih ada yang kosong
                full = false;
                break;
            }
        }
        // Jika data penuh maka Jumlah data array akan di kalikan 2 dari jumlah default sebelumnya 10
        if (full){
            var temp = data;
            data = new String[data.length * 2];

            for (int i = 0; i < temp.length ; i++) {
                data[i] = temp[i];
            }
        }
        // tambahkan ke posisi yang data array nya Null
        for (var i = 0; i < data.length ; i++) {
            if (data[i] == null) {
                data[i] = todo;
                break;
            }
        }
    }
    /*
    Tampilan ketika Todo List akan di hapus
     */
    public static boolean removeTodoList(Integer nomor){
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
    public static String input( String info){
        System.out.println(info + " : ");
        String dataa = scanner.nextLine();
        return dataa;
    }

    /*
    Menampilan Todo List
     */
    public static void viewShowTodoList(){
        while (true){
            showTodoList();

            System.out.println("MENU");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Pilih");
            if (input.equals("1")){
                viewAddTodoList();
            } else if (input.equals("2")){
                viewRemoveTodoList();
            } else if (input.equals("x")){
                break;
            }else {
                System.out.println("Pilihan tidak di mengerti");
            }
        }
    }
    /*
    Menampilkan Menu Todo List ketika di tambah
     */
    public static void  viewAddTodoList(){
        System.out.println("Menambah Todo List");
        var todo = input("Todo (x Jika Batal)");
        if (todo.equals("x")){
            //Batal
        } else {
            addTodoList(todo);
        }
    }
    /*
    Menampilkan Menu Todo List ketika di hapus
     */
    public static void viewRemoveTodoList(){
        System.out.println("Menghapus Todo List");
        var nomor = input("Nomor yang akan di hapus (x Jika Batal)");
        if (nomor.equals("x")){
            //Batal
        } else {
            boolean sukses = removeTodoList(Integer.valueOf(nomor));
            if (!sukses){
                System.out.println("Gagal Menghapus Todo List : " + nomor);
            }
        }
    }
}