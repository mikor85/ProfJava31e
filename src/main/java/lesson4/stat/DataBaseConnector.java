package lesson4.stat;

// шаблон Singleton - Одиночка
// иногда бывает нужно сделать так, чтобы можно было создать только один экземпляр класса
public class DataBaseConnector {
    public static String conn;  // static означает, что это поле создается для класса

    public DataBaseConnector(String connection) {
        conn = connection;
    }

    public String getConnection() {
        return conn;
    }
}

class Logger {
    private static Logger instance;  // для хранения единственного экземпляра

    private Logger() {
    }

    ;  // приватный конструктор, чтобы нельзя было создать

    public static Logger getInstance() {  // статический инициализатор
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
}

class Tester {
    public static void main(String[] args) {

        Logger l = Logger.getInstance();

        DataBaseConnector con1 = new DataBaseConnector("mysql://mydb:34/mybase");
        DataBaseConnector con2 = new DataBaseConnector("oracle://server34:5001/enterprise");

        System.out.println(con1.conn);
        System.out.println(con2.conn);

        System.out.println(DataBaseConnector.conn);

        System.out.println(Constants.login);
        // Constants.login = "aaa";

    }
}

/*final*/ class Constants {  // final для класса означает, что от него нельзя пронаследоваться
    public static final String login = "odyssey";  // нельзя изменить значение этой переменной

    final public String getLogin(){  // нельзя переопределять final функцию
        return login;
    }
}

class MyConstants extends Constants{
//    @Override
//    public String getLogin(){
//        return "Agamemnon";
//    }
}

