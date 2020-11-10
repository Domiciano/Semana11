package db;

import java.sql.*;

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

    public void disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean createDatabase(){
        boolean success = false;
        try {
            connect();
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS profesores(id INT PRIMARY KEY AUTO_INCREMENT, nombre VARCHAR(100), facultad VARCHAR(100))");
            statement.execute("CREATE TABLE IF NOT EXISTS cursos(id INT PRIMARY KEY AUTO_INCREMENT, nombre VARCHAR(100), programa VARCHAR(100), profesorID INT, " +
                                                            "FOREIGN KEY (profesorID) REFERENCES profesores(id))");
            statement.execute("CREATE TABLE IF NOT EXISTS estudiantes(id INT PRIMARY KEY AUTO_INCREMENT, nombre VARCHAR(100), codigo VARCHAR(100))");
            statement.execute("CREATE TABLE IF NOT EXISTS estudiantes_cursos(id INT PRIMARY KEY AUTO_INCREMENT, estudianteID INT, cursoID INT, " +
                                                                    "FOREIGN KEY (estudianteID) REFERENCES estudiantes(id), " +
                                                                    "FOREIGN KEY (cursoID) REFERENCES cursos(id))");
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
            success = false;
        }finally {
            disconnect();
        }
        return success;
    }

    //Ordenes
    public boolean executeSQL(String sql){
        boolean success = false;
        try {
            connect();
            Statement statement = connection.createStatement();
            statement.execute(sql);
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
            success = false;
        }finally {
            disconnect();
        }
        return success;
    }

    //Query
    public ResultSet query(String sql) {
        ResultSet output = null;
        try {
            connect();
            Statement statement = connection.createStatement();
            output = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return output;
    }
}
