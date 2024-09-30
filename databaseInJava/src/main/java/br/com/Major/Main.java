package br.com.Major;

import br.com.Major.Controllers.UsuarioController;
import br.com.Major.Views.UsuarioView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("iniciando a aplicação...");

        while(true){
            UsuarioView.menuView();
            int opcao = UsuarioView.getOpcao();

            switch(opcao){
                case 1:
                    UsuarioController.cadastrandoUsuario();
                    break;
                case 2:
                    UsuarioController.editandoUsuario();
                    break;
                case 3:
                    UsuarioController.deletandoUsuario();
                    break;
                case 4:
                    break;
                case 5:
                    logger.info("finalizando a aplicação...");
                    System.exit(0);
                    break;
                default:
                    UsuarioView.opcaoInvalida();
            }
        }
    }
}