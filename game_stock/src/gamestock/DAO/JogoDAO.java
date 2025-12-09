package gamestock.DAO;

import gamestock.model.Jogo;
import gamestock.util.ConexaoJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JogoDAO {

    private final ConexaoJDBC conexao;

    public JogoDAO() {
        this.conexao = new ConexaoJDBC();
    }

    public void cadastrar(Jogo jogo) {
        String sql = "INSERT INTO jogo (nome, categoria, plataforma, preco, quantidade) VALUES (?, ?, ?, ?, ?)";

        try ( Connection con = conexao.conectar();  PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, jogo.getNome());
            stmt.setString(2, jogo.getCategoria());
            stmt.setString(3, jogo.getPlataforma());
            stmt.setDouble(4, jogo.getPreco());
            stmt.setInt(5, jogo.getQuantidade());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar jogo", e);
        }
    }

    public List<Jogo> listar() {
        List<Jogo> lista = new ArrayList<>();
        String sql = "SELECT * FROM jogo";

        try ( Connection con = conexao.conectar();  PreparedStatement ps = con.prepareStatement(sql);  ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Jogo jogo = new Jogo();
                jogo.setId(rs.getInt("id"));
                jogo.setNome(rs.getString("nome"));
                jogo.setCategoria(rs.getString("categoria"));
                jogo.setPlataforma(rs.getString("plataforma"));
                jogo.setPreco(rs.getDouble("preco"));
                jogo.setQuantidade(rs.getInt("quantidade"));
                lista.add(jogo);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar jogos", e);
        }

        return lista;
    }

    public List<Jogo> buscarPorNome(String nome) {
        List<Jogo> lista = new ArrayList<>();
        String sql = "SELECT * FROM jogo WHERE nome LIKE ?";

        try ( Connection con = conexao.conectar();  PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + nome + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Jogo jogo = new Jogo();
                jogo.setId(rs.getInt("id"));
                jogo.setNome(rs.getString("nome"));
                jogo.setCategoria(rs.getString("categoria"));
                jogo.setPlataforma(rs.getString("plataforma"));
                jogo.setPreco(rs.getDouble("preco"));
                jogo.setQuantidade(rs.getInt("quantidade"));
                lista.add(jogo);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar jogo", e);
        }

        return lista;
    }

    public boolean excluirPorNome(String nome) {
        String sql = "DELETE FROM jogo WHERE nome = ?";

        try ( Connection con = conexao.conectar();  PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nome);
            int linhas = ps.executeUpdate();
            return linhas > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir jogo", e);
        }
    }

    public boolean atualizar(Jogo jogo) {
        String sql = "UPDATE jogo SET nome = ?, categoria = ?, plataforma = ?, preco = ?, quantidade = ? WHERE id = ?";

        try ( Connection con = conexao.conectar();  PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, jogo.getNome());
            ps.setString(2, jogo.getCategoria());
            ps.setString(3, jogo.getPlataforma());
            ps.setDouble(4, jogo.getPreco());
            ps.setInt(5, jogo.getQuantidade());
            ps.setInt(6, jogo.getId());

            int linhas = ps.executeUpdate();
            return linhas > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar jogo", e);
        }
    }

    public boolean excluirPorId(int id) {
        String sql = "DELETE FROM jogo WHERE id = ?";

        try ( Connection conn = new ConexaoJDBC().conectar();  PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir jogo", e);
        }
    }
}
