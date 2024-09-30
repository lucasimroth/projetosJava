package br.com.Major.Services;

import br.com.Major.Daos.UsuarioDao;
import br.com.Major.Models.Usuario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UsuarioService {
    private static final Logger logger = LogManager.getLogger(UsuarioService.class);
    private static final UsuarioDao usuarioDao = new UsuarioDao();

    /**
     * o metodo deletarUsuario() recebe um objeto usuario e chama o metodo deletarUsuario() da classe UsuarioDao
     * @param usuario recebe o objeto usuario a ser deletado
     */
    public static void deletarUsuario(Usuario usuario){
        usuarioDao.deletarUsuario(usuario.getId());
    }

    /**
     * o metodo editarUsuario() recebe um objeto usuario e chama o metodo atualizarUsuario() da classe UsuarioDao
     * @param usuario recebe o objeto usuario a ser editado
     */
    public static void editarUsuario(Usuario usuario){
        usuarioDao.atualizarUsuario(usuario);
    }

    /**
     * o metodo buscarUsuarioPorEmail() recebe um email e chama o metodo buscarUsuarioPorEmail() da classe UsuarioDao
     * @param email recebe o email do usuario a ser buscado
     * @return retorna o objeto usuario encontrado e null se nao encontrar
     */
    public static Usuario buscarUsuarioPorEmail(String email){
        return usuarioDao.buscarUsuarioPorEmail(email);
    }

    /**
     * o metodo cadastrarUsuario() recebe um objeto usuario e chama o metodo inserirUsuario() da classe UsuarioDao
     * @param usuario recebe o objeto usuario a ser cadastrado
     */
    public static void cadastrarUsuario(Usuario usuario){
        usuarioDao.inserirUsuario(usuario);
    }

    /**
     * o metodo validaNome() verifica se o nome é valido
     * retornando true caso seja valido ou false caso não seja
     * @param nome recebe o nome a ser validado
     * nome é valido se tiver mais de 3 caracteres e for composto apenas por letras e espaços
     */
    public static boolean validaNome(String nome)
    {
        return nome.matches("[a-zA-Z\\s]{3,}+");
    }

    /**
     * o metodo validaEmail() verifica se o email é valido
     * retornando true caso seja valido ou false caso não seja
     * @param email recebe o email a ser validado
     * email é valido se for composto por letras, numeros, pontos, underline e hifen
     * seguido de @ e letras, numeros, pontos e hifen seguido de ponto e letras
     * e se o email não estiver cadastrado no banco de dados
     */
    public static boolean validaEmail(String email)
    {
        return  (email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"));
    }

    /**
     * o metodo validaTelefone() verifica se o telefone é valido
     * retornando true caso seja valido ou false caso não seja
     * @param telefone recebe o telefone a ser validado
     * telefone é valido se for composto apenas por numeros e tiver entre 8 e 11 caracteres
     * e se o telefone não for composto apenas por um mesmo numero
     */
    public static boolean validaTelefone(String telefone)
    {
        return  (telefone.matches("\\d+") &&
                (telefone.length() < 8 || telefone.length() > 11) &&
                !(telefone.matches("(\\d)\\1*")));
    }

    /**
     * o metodo validaSenha() verifica se a senha é valida
     * retornando true caso seja valida ou false caso não seja
     * @param senha recebe a senha a ser validada
     * senha é valida se tiver mais de 7 caracteres e conter pelo menos uma letra maiuscula,
     * uma letra minuscula, um numero e um caracter especial entre !@#$%^&*+
     */
    public static boolean validaSenha(String senha)
    {
        return  ((senha.length() < 7) &&
                (senha.matches(".*[A-Z].*") &&
                (senha.matches(".*[a-z].*")) &&
                (senha.matches(".*[0-9].*")) &&
                (senha.matches(".*[!@#$%^&*+].*"))));
    }
}

