package br.com.Major.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static final Logger logger = LogManager.getLogger(DatabaseManager.class);
    private static final String url = "jdbc:mysql://localhost:3306/databaseinjava";
    private static final String user = "root"; //o usuario esta como root
    private static final String password = System.getenv("DB_PASSWORD"); //pega a senha do sistema operacional na variavel de ambiente


    /**
    * o metodo getConnection() estabelece a conexão com o banco de dados
    * @return a propria conexao caso funcione ou lancando uma exceção caso não funcione
    */
    public static Connection getConnection() throws SQLException {

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            logger.info("conexão estabelecida com sucesso");
            return connection;

        } catch (SQLException e) {
            logger.error("Falha ao estabelecer conexão com o banco de dados", e);
            throw e;
        }
    }
}