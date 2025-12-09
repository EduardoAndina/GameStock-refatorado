package gamestock.DAO;

import gamestock.model.Venda;
import gamestock.util.ConexaoJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {

    private ConexaoJDBC conexao = new ConexaoJDBC();

    public boolean salvar(Venda venda) {
        String sql = "INSERT INTO vendas (idJogo, nome_jogo, categoria, quantidadeVendida, valorPago, nomeCliente, telefoneCliente) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try ( Connection con = conexao.conectar();  PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, venda.getIdJogo());
            stmt.setString(2, venda.getNomeJogo());
            stmt.setString(3, venda.getCategoria());
            stmt.setInt(4, venda.getQuantidadeVendida());
            stmt.setDouble(5, venda.getValorPago());
            stmt.setString(6, venda.getNomeCliente());
            stmt.setString(7, venda.getTelefoneCliente());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar venda", e);
        }
    }

    public List<Venda> listar() {
        List<Venda> lista = new ArrayList<>();
        String sql = "SELECT * FROM vendas";

        try ( Connection con = conexao.conectar();  PreparedStatement stmt = con.prepareStatement(sql);  ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Venda v = new Venda(
                        rs.getInt("id"),
                        rs.getInt("idJogo"),
                        rs.getString("nome_jogo"),
                        rs.getString("categoria"),
                        rs.getInt("quantidadeVendida"),
                        rs.getDouble("valorPago"),
                        rs.getString("nomeCliente"),
                        rs.getString("telefoneCliente")
                );
                lista.add(v);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar vendas", e);
        }
        return lista;
    }

    public boolean atualizar(Venda venda) {
        String sql = "UPDATE vendas SET idJogo=?, nome_jogo=?, categoria=?, quantidadeVendida=?, valorPago=?, nomeCliente=?, telefoneCliente=? WHERE id=?";
        try ( Connection con = conexao.conectar();  PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, venda.getIdJogo());
            stmt.setString(2, venda.getNomeJogo());
            stmt.setString(3, venda.getCategoria());
            stmt.setInt(4, venda.getQuantidadeVendida());
            stmt.setDouble(5, venda.getValorPago());
            stmt.setString(6, venda.getNomeCliente());
            stmt.setString(7, venda.getTelefoneCliente());
            stmt.setInt(8, venda.getId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar venda", e);
        }
    }

    public boolean excluir(int idVenda) {
        String sql = "DELETE FROM vendas WHERE id = ?";
        try ( Connection con = conexao.conectar();  PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, idVenda);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir venda", e);
        }
    }

    public List<Venda> buscar(String filtro) {
        List<Venda> lista = new ArrayList<>();
        String sql = "SELECT * FROM vendas WHERE nome_jogo LIKE ? OR nomeCliente LIKE ?";

        try ( Connection con = conexao.conectar();  PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, "%" + filtro + "%");
            stmt.setString(2, "%" + filtro + "%");

            try ( ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    lista.add(new Venda(
                            rs.getInt("id"),
                            rs.getInt("idJogo"),
                            rs.getString("nome_jogo"),
                            rs.getString("categoria"),
                            rs.getInt("quantidadeVendida"),
                            rs.getDouble("valorPago"),
                            rs.getString("nomeCliente"),
                            rs.getString("telefoneCliente")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar vendas", e);
        }

        return lista;
    }
}
