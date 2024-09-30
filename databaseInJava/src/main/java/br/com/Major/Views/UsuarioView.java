package br.com.Major.Views;

import br.com.Major.Models.Usuario;
import br.com.Major.util.ScannerUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class UsuarioView {
    private static final Logger logger = LogManager.getLogger(UsuarioView.class);

    /**metodo que mostra o menu do usuario*/
    public static void menuView(){
        System.out.println("\n1 - Cadastrar usuário");
        System.out.println("2 - Editar usuário");
        System.out.println("3 - Deletar usuário");
        System.out.println("4 - Listar usuários(off)");
        System.out.println("5 - Sair");
    }

    /**metodo que pega a opcao do usuario
     * @return int id*/
    public static int getOpcao(){
        System.out.println("\nDigite a opção desejada: ");
        return ScannerUtil.getScanner().nextInt();
    }

    /**metodo que informa que a opcao é invalida*/
    public static void opcaoInvalida(){
        System.out.println("\nOpção inválida, digite novamente. ");
    }

    /**metodo que mostra o menu do usuario*/
    public static void usuarioNaoEncontrado(){
        System.out.println("\nUsuário não encontrado");
    }

    /**metodo que pega o nome do usuario*/
    public static String getNome(){
        System.out.println("\nDigite o nome: ");
        return ScannerUtil.getScanner().nextLine();
    }

    /**metodo que informa que o nome é invalido*/
    public static void nomeInvalido(){
        System.out.println("\nNome inválido, digite novamente. ");
    }

    /**metodo que pega o email do usuario*/
    public static String getEmail(){
        System.out.println("Digite o email: ");
        return ScannerUtil.getScanner().nextLine();
    }

    /**metodo que informa que o email é invalido*/
    public static void emailInvalido(){
        System.out.println("Email inválido, digite novamente. ");
    }

    /**metodo que pega o telefone do usuario*/
    public static String getTelefone(){
        System.out.println("Digite o telefone: ");
        return ScannerUtil.getScanner().nextLine();
    }

    /**metodo que informa que o telefone é invalido*/
    public static void telefoneInvalido(){
        System.out.println("Telefone inválido, digite novamente. ");
    }

    /**metodo que pega a senha do usuario*/
    public static String getSenha(){
        System.out.println("Digite a senha: ");
        return ScannerUtil.getScanner().nextLine();
    }

    /**metodo que informa que a senha é invalida*/
    public static void senhaInvalida(){
        System.out.println("Senha inválida, digite novamente. ");
    }
}
