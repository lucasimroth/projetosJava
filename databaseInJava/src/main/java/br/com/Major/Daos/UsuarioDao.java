package br.com.Major.Daos;

import br.com.Major.Models.Usuario;
import br.com.Major.util.DatabaseManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao {
    private static final Logger logger = LogManager.getLogger(UsuarioDao.class);

    /**
    * metodo para inserir o usuario novo no banco de dados
    * @param usuario recebe o objeto contendo o novo usuario
    */
    public void inserirUsuario(Usuario usuario) {
        String sql = "INSERT INTO Usuarios (nome, email, telefone, senha) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getTelefone());
            stmt.setString(4, usuario.getSenha());

            int rowsAffected = stmt.executeUpdate();
            logger.info("{} linha(s) inserida(s)", rowsAffected);

        } catch (SQLException e) {
            logger.error("Falha ao inserir usuário", e);
        }
    }

    /**
    * metodo para buscar o usuario no banco de dados pelo nome
    * @param nome recebe o nome do usuario a ser buscado
    * @return retorna o objeto usuario encontrado e null se nao encontrar
     */
    public static Usuario buscarUsuarioPorNome(String nome) throws SQLException {
        String sql = "SELECT * FROM Usuarios WHERE nome = ?";

        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");
                String senha = rs.getString("senha");
                return new Usuario(id, nome, email, telefone, senha);
            }

        } catch (SQLException e) {
            logger.error("Usuário não Encontrado ou Falha", e);
            throw new SQLException("Usuario não encontrado", e);
        }

        return null;
    }


    /**
    * metodo para buscar o usuario no banco de dados pelo email
    * @param email recebe o email do usuario a ser buscado
    * @return retorna o objeto usuario encontrado e null se nao encontrar
    */
    public Usuario buscarUsuarioPorEmail(String email){
        String sql = "SELECT * FROM Usuarios WHERE email = ?";

        //tenta fazer a busca no banco de dados e retorna o usuario encontrado
        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            //seta o email no statement para fazer a busca no banco
            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String telefone = rs.getString("telefone");
                String senha = rs.getString("senha");
                return new Usuario(id, nome, email, telefone, senha);
            }

        } catch (SQLException e) {
            logger.error("Email não Encontrado ou Falha", e);
            return null;
        }

        return null;
    }

    /**
    * metodo para atualizar os dados do usuario no banco de dados
    * @param usuario recebe o objeto usuario com os dados atualizados
    */
    public void atualizarUsuario(Usuario usuario) {
        String sql = "UPDATE Usuarios SET nome = ?, email = ?, telefone = ?, senha = ? WHERE id = ?";

        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getTelefone());
            stmt.setString(4, usuario.getSenha());
            stmt.setInt(5, usuario.getId());

            int rowsAffected = stmt.executeUpdate();
            logger.info("{} linha(s) Atualizada(s)", rowsAffected);
        } catch (SQLException e) {
            logger.error("Falha ao atualizar usuário", e);
        }
    }

    /**
    * metodo para deletar o usuario no banco de dados
    * @param id recebe o id do usuario a ser deletado
     */
    public void deletarUsuario(int id) {
        String sql = "DELETE FROM Usuarios WHERE id = ?";

        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();
            logger.info("{} linha(s) deletada(s)", rowsAffected);

        } catch (SQLException e) {
            logger.error("Falha ao deletar usuário", e);
        }
    }

}
