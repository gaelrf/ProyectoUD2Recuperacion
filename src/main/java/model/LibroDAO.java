package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class LibroDAO {

    Connection connection;
    private static final String SQL_INSERT = "insert into libros (title, author, first_edition) values (?, ?, ?)";
    private static final String SQL_LIST = "select * from libros";
    private static final String SQL_SEARCH = "select * from libros where title = ?";
    private static final String SQL_UPDATE = "update libros set title = ? author = ?, first_edition = ? where id = ?";
    private static final String SQL_DELETE = "delete from libros where id = ?";

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


        } catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {

            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }


    public ArrayList<Libro> list() {

        connect();

        ArrayList<Libro> libros = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_LIST);
            Libro libroAuxiliar = new Libro();

            while (resultSet.next()){

                libroAuxiliar.setTitle(resultSet.getString("title"));
                libroAuxiliar.setAuthor(resultSet.getString("author"));
                libroAuxiliar.setFirstEdition(resultSet.getInt("first_edition"));

                libros.add(libroAuxiliar);

            }


        } catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {

            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return libros;

    }

    public ArrayList<Libro> search(String search) {

        connect();
        ArrayList<Libro> libros = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SEARCH);
            preparedStatement.setString(1,search);
            ResultSet resultSet = preparedStatement.executeQuery();
            Libro libroAuxiliar = new Libro();

            while (resultSet.next()){

                libroAuxiliar.setId(resultSet.getInt("id"));
                libroAuxiliar.setTitle(resultSet.getString("title"));
                libroAuxiliar.setAuthor(resultSet.getString("author"));
                libroAuxiliar.setFirstEdition(resultSet.getInt("first_edition"));

                libros.add(libroAuxiliar);

            }


        } catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {

            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return libros;

    }

    public void update(Libro libroUpdate) {

        connect();

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1, libroUpdate.getTitle());
            preparedStatement.setString(2, libroUpdate.getAuthor());
            preparedStatement.setInt(3, libroUpdate.getFirstEdition());
            preparedStatement.setInt(4, libroUpdate.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {

            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


    }

    public void delete(Libro libroDelete) {

        connect();

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE);
            preparedStatement.setInt(1, libroDelete.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {

            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }


}
