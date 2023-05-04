package view;

import model.Libro;

public class LibroView {

    public Libro insertData(){

        String title = Inputs.inputString("Introduzca el titulo del libro: ");
        String author = Inputs.inputString("Introduzca el autor del libro: ");
        int firstEdition = Inputs.inputInt("Introduzca el año de publicación de la primera edición: ");

        Libro libro = new Libro(title, author,firstEdition);

        System.out.println("Libro a insertar:");
        System.out.println(libro);
        char confirmation = Inputs.inputChar("¿Desea importar este libro? (S/N)");

        if (confirmation != 'S' && confirmation != 's'){

            libro=null;

        }

        return libro;

    }

}
