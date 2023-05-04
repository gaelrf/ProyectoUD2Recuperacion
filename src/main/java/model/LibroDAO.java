package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class LibroDAO {

    Connection connection;
    private static final String SQL_INSERT = "insert into libros (title, author, first_edition) values (?, ?, ?)";

    public void connect(){

        String stringConection = "jdbc:mysql://localhost:3306/libros";
        Properties propertiesConection = new Properties();
        propertiesConection.setProperty("user","root");
        propertiesConection.setProperty("password", "root");
        try {
            connection = DriverManager.getConnection(stringConection,propertiesConection);
        } catch (SQLException e) {
            throw new RuntimeException("Problema al conectarse a la base de datos " + e);
        }

    }

    public void insert(Libro libro){

        connect();

        try {



            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, libro.getAuthor());
            preparedStatement.setString(2, libro.getTitle());
            preparedStatement.setInt(3, libro.getFirstEdition());

            preparedStatement.executeUpdate();

            connection.close();

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }

    }

}
