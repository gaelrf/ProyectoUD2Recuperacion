package controller;

import view.MenuView;

public class MenuController {

    MenuView menuView = new MenuView();
    LibroController libroController = new LibroController();

    public void mainMenu(){

        int op = -1;

        while (op!=0){

            op = menuView.mainMenu();

            switch (op){

                case 1:

                    menuLibro();

                    break;

                case 0:

                    break;

                default:

                    break;

            }

        }

    }

    public void menuLibro(){

        int op = -1;

        while (op!=0){

            op = menuView.menuLibro();

            switch (op){

                case 1:

                    libroController.insert();
                    break;

                case 2:

                    menuBuscarLibro();
                    break;

                case 3:

                    libroController.update();
                    break;

                case 4:

                    libroController.delete();
                    break;

                case 0:

                    break;

                default:

                    break;

            }

        }

    }

    private void menuBuscarLibro() {

        int op = -1;

        op = menuView.optionBuscar();

        switch (op){

            case 1:

                libroController.list();
                break;

            case 2:

                libroController.search();
                break;

            case 0:

                break;

        }

    }

}
