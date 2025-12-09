package gamestock.service;

import gamestock.DAO.FuncionarioDAO;
import gamestock.model.Funcionario;
import java.util.List;

public class FuncionarioService {

    private FuncionarioDAO dao = new FuncionarioDAO();

    public void cadastrar(Funcionario f) {
        if (f.getNome().isEmpty() || f.getUsuario().isEmpty() || f.getSenha().isEmpty()) {
            throw new IllegalArgumentException("Campos obrigatórios não preenchidos.");
        }
        dao.cadastrar(f);
    }

    public List<Funcionario> listar() {
        return dao.listar();
    }

    public List<Funcionario> buscar(String filtro) {
        return dao.buscar(filtro);
    }

    public void excluir(int id) {
        boolean excluido = dao.excluirPorId(id);
        if (!excluido) {
            throw new IllegalStateException("Erro ao excluir funcionário.");
        }
    }

    public void atualizar(Funcionario f) {
        boolean ok = dao.atualizar(f);
        if (!ok) {
            throw new IllegalStateException("Erro ao atualizar funcionário.");
        }
    }

    public Funcionario autenticar(String usuario, String senha) {
        for (Funcionario f : dao.listar()) {
            if (f.getUsuario().equals(usuario) && f.getSenha().equals(senha)) {
                return f;
            }
        }
        return null;
    }
}
