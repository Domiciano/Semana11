package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection {

    private Connection connection;

    public MySQLConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//Importacion
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    private void connect(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://200.3.193.22:3306/P09728_1_11","P09728_1_11","ZCSaQGZU");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertTest() {
        try {
            connect();
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO materias(id, nombre, NRC) VALUES ('omega','Programacion en red','A8924')");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            disconnect();
        }
    }
}
