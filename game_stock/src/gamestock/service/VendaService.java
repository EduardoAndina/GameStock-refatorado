package gamestock.service;

import gamestock.DAO.VendaDAO;
import gamestock.model.Venda;

import java.util.List;

public class VendaService {

    private VendaDAO dao = new VendaDAO();

    public void cadastrar(Venda venda) {
        if (venda.getNomeJogo().isEmpty() || venda.getNomeCliente().isEmpty() || venda.getQuantidadeVendida() <= 0) {
            throw new IllegalArgumentException("Campos obrigatórios não preenchidos ou quantidade inválida.");
        }
        dao.salvar(venda);
    }

    public List<Venda> listar() {
        return dao.listar();
    }

    public void atualizar(Venda venda) {
        boolean ok = dao.atualizar(venda);
        if (!ok) {
            throw new IllegalStateException("Erro ao atualizar venda.");
        }
    }

    public void excluir(int id) {
        boolean ok = dao.excluir(id);
        if (!ok) {
            throw new IllegalStateException("Erro ao excluir venda.");
        }
    }

    public List<Venda> buscar(String filtro) {
        return dao.buscar(filtro);
    }
}
