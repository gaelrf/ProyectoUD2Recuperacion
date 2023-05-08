package view;

import model.Libro;

import java.util.ArrayList;

public class LibroView {

    public Libro insertData(){

        String title = Inputs.inputString("Introduzca el titulo del libro: ");
        String author = Inputs.inputString("Introduzca el autor del libro: ");
        int firstEdition = Inputs.inputInt("Introduzca el año de publicación: ");

        Libro libro = new Libro(title, author,firstEdition);

        System.out.println("Libro a insertar:");
        System.out.println(libro);
        char confirmation = Inputs.inputChar("¿Desea importar este libro? (S/N)");

        if (confirmation != 'S' && confirmation != 's'){

            libro=null;

        }

        return libro;

    }

    public void list(ArrayList<Libro> libros){

        for (Libro libro : libros){

            System.out.println(libro);

        }

    }

    public String getTitle() {

        String title = Inputs.inputString("Introduzca el titulo del libro: ");

        return title;

    }

    public Libro select(String operation, ArrayList<Libro> libros) {

        char confirmar = 'N';
        Libro libro = null;
        int aux = 0;
        while (libros.size()<aux && (confirmar != 'S' || confirmar != 's')){

            System.out.println(libros.get(aux));
            confirmar = Inputs.inputChar("Es este el libro que deseas " + operation + "?");

            if (confirmar == 'S' || confirmar == 's'){

                libro = libros.get(aux);

            }

            aux++;

        }

        return libro;

    }

    public void updateData(Libro libroUpdate) {

        System.out.println("El titulo actual del libro es: " + libroUpdate.getTitle());
        String title = Inputs.inputString("Introduzca el nuevo titulo del libro: ");
        System.out.println("El autor actual del libro es: " + libroUpdate.getAuthor());
        String author = Inputs.inputString("Introduzca el nuevo autor del libro: ");
        System.out.println("El año de publicación actual del libro es: " + libroUpdate.getFirstEdition());
        int firstEdition = Inputs.inputInt("Introduzca el nuevo año de publicación: ");


    }

}
