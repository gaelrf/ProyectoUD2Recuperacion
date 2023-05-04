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

                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 0:

                    break;

                default:

                    break;

            }

        }

    }

}
