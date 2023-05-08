package controller;

import model.Libro;
import model.LibroDAO;
import view.LibroView;

import java.util.ArrayList;

public class LibroController {

    LibroDAO libroDAO = new LibroDAO();
    LibroView libroView = new LibroView();

    public void insert(){

        Libro libro = libroView.insertData();

        if (libro != null){

            libroDAO.insert(libro);

        }

    }

    public void list() {

        ArrayList<Libro> libros = libroDAO.list();

        libroView.list(libros);

    }

    public void search(){

        String search = libroView.getTitle();

        ArrayList<Libro> libros = libroDAO.search(search);

        libroView.list(libros);

    }

    public void update() {

        String search = libroView.getTitle();

        ArrayList<Libro> libros = libroDAO.search(search);

        Libro libroUpdate = libroView.select("Modificar", libros);

        if (libroUpdate != null){

            libroView.updateData(libroUpdate);
            libroDAO.update(libroUpdate);

        }

    }

    public void delete() {

        String search = libroView.getTitle();

        ArrayList<Libro> libros = libroDAO.search(search);

        Libro libroDelete = libroView.select("Borrar", libros);

        if (libroDelete != null){

            libroDAO.delete(libroDelete);

        }

    }

}
