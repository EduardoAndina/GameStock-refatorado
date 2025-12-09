package gamestock.DAO;

import gamestock.model.Funcionario;
import gamestock.util.ConexaoJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    private ConexaoJDBC conexao = new ConexaoJDBC();

    public void cadastrar(Funcionario f) {
        String sql = "INSERT INTO funcionarios (nome, usuario, senha) VALUES (?, ?, ?)";

        try ( Connection con = conexao.conectar();  PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getUsuario());
            stmt.setString(3, f.getSenha());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar funcionário", e);
        }
    }

    public List<Funcionario> listar() {
        List<Funcionario> lista = new ArrayList<>();
        String sql = "SELECT * FROM funcionarios";

        try ( Connection con = conexao.conectar();  PreparedStatement stmt = con.prepareStatement(sql);  ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Funcionario f = new Funcionario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("usuario"),
                        rs.getString("senha")
                );
                lista.add(f);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar funcionários", e);
        }

        return lista;
    }

    public boolean excluirPorId(int id) {
        String sql = "DELETE FROM funcionarios WHERE id = ?";

        try ( Connection con = conexao.conectar();  PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir funcionário", e);
        }
    }

    public boolean atualizar(Funcionario f) {
        String sql = "UPDATE funcionarios SET nome=?, usuario=?, senha=? WHERE id=?";

        try ( Connection con = conexao.conectar();  PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getUsuario());
            stmt.setString(3, f.getSenha());
            stmt.setInt(4, f.getId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar funcionário", e);
        }
    }

    public List<Funcionario> buscar(String filtro) {
        List<Funcionario> lista = new ArrayList<>();
        String sql = "SELECT * FROM funcionarios WHERE nome LIKE ? OR usuario LIKE ?";

        try ( Connection con = conexao.conectar();  PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, "%" + filtro + "%");
            stmt.setString(2, "%" + filtro + "%");

            try ( ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    lista.add(new Funcionario(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("usuario"),
                            rs.getString("senha")
                    ));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar funcionário", e);
        }

        return lista;
    }
}
