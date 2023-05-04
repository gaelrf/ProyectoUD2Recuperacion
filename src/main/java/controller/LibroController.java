package controller;

import model.Libro;
import model.LibroDAO;
import view.LibroView;

public class LibroController {

    LibroDAO libroDAO = new LibroDAO();
    LibroView libroView = new LibroView();

    public void insert(){

        Libro libro = libroView.insertData();

        if (libro != null){

            libroDAO.insert(libro);

        }

    }

}
