package br.com.Major.Controllers;

import br.com.Major.Models.Usuario;
import br.com.Major.Services.UsuarioService;
import br.com.Major.Views.UsuarioView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UsuarioController {
    private static final Logger logger = LogManager.getLogger(UsuarioController.class);

    public static void deletandoUsuario(){
        Usuario usuario = UsuarioService.buscarUsuarioPorEmail(getEmailValido());
        if(usuario != null){
            UsuarioService.deletarUsuario(usuario);
        }else{
            UsuarioView.usuarioNaoEncontrado();
        }
    }

    public static void editandoUsuario(){
        Usuario usuario = UsuarioService.buscarUsuarioPorEmail(getEmailValido());
        if(usuario != null){
            usuario.setNome(getNomeValido());
            usuario.setTelefone(getTelefoneValido());
            usuario.setSenha(getSenhaValida());
            UsuarioService.editarUsuario(usuario);
        }else{
            UsuarioView.usuarioNaoEncontrado();
        }
    }

    public static void cadastrandoUsuario(){
        String nome = getNomeValido();
        String email = getEmailValido();
        String telefone = getTelefoneValido();
        String senha = getSenhaValida();

        Usuario usuario = new Usuario(nome, email, telefone, senha);
        UsuarioService.cadastrarUsuario(usuario);
    }

    private static String getNomeValido(){
        String nome;
        while(true){
            nome = UsuarioView.getNome();
            if(UsuarioService.validaNome(nome)){
                return nome;
            }
            UsuarioView.nomeInvalido();
        }
    }

    private static String emailJaCadastrado(String email){
        if(UsuarioService.buscarUsuarioPorEmail(email) != null){
            return email;
        }
        return null;
    }

    private static String getEmailValido(){
        String email;
        while(true){
            email = UsuarioView.getEmail();
            if(UsuarioService.validaEmail(email) && emailJaCadastrado(email) == null){
                return email;
            }
            UsuarioView.emailInvalido();
        }
    }

    private static String getTelefoneValido(){
        String telefone;
        while(true){
            telefone = UsuarioView.getTelefone();
            if(UsuarioService.validaTelefone(telefone)){
                return telefone;
            }
            UsuarioView.telefoneInvalido();
        }
    }

    private static String getSenhaValida(){
        String senha;
        while(true){
            senha = UsuarioView.getSenha();
            if(UsuarioService.validaSenha(senha)){
                return senha;
            }
            UsuarioView.senhaInvalida();
        }
    }
}
