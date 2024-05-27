package Principal;

import Aux_arq.MenuUsuario;

import java.io.IOException;

public class Aplicativo {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("****** Aplicativo Conversor de Moedas ******\n");

        MenuUsuario menu = new MenuUsuario();
        menu.menu();
    }
}