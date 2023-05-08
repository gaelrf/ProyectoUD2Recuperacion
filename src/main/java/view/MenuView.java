package view;

public class MenuView {

    public int mainMenu(){

        System.out.println("1. Libro.");
        System.out.println("0. Salir.");

        int op = Inputs.inputInt("Seleccione entidad con la que trabajar: ");

        return op;

    }

    public int menuLibro(){

        System.out.println("1. Crear.");
        System.out.println("2. Buscar.");
        System.out.println("3. Modificar.");
        System.out.println("4. Borrar.");
        System.out.println("0. Salir.");

        int op = Inputs.inputInt("Seleccione opción: ");

        return op;

    }

    public int optionBuscar() {

        System.out.println("1. Listar.");
        System.out.println("2. Buscar.");
        System.out.println("0. Cancelar.");

        int op = Inputs.inputInt("Seleccione opción de busqueda");

        return op;

    }
}
