package gamestock.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoJDBC {

    private static final String URL = "jdbc:mysql://localhost:3306/gamestock";
    private static final String USUARIO = "root";
    private static final String SENHA = "Edu31508280";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver JDBC não encontrado", e);
        }
    }

    public Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
