package gamestock.service;

import gamestock.DAO.JogoDAO;
import gamestock.model.Jogo;
import java.util.List;

public class JogoService {

    private final JogoDAO jogoDAO;

    public JogoService() {
        this.jogoDAO = new JogoDAO();
    }

    public void cadastrarJogo(Jogo jogo) {
        if (jogo == null) {
            throw new IllegalArgumentException("Jogo inválido");
        }
        if (jogo.getNome() == null || jogo.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do jogo obrigatório");
        }
        if (jogo.getCategoria() == null || jogo.getCategoria().trim().isEmpty()) {
            throw new IllegalArgumentException("Categoria obrigatória");
        }
        if (jogo.getPlataforma() == null || jogo.getPlataforma().trim().isEmpty()) {
            throw new IllegalArgumentException("Plataforma obrigatória");
        }
        if (jogo.getPreco() <= 0) {
            throw new IllegalArgumentException("Preço deve ser maior que zero");
        }
        if (jogo.getQuantidade() < 0) {
            throw new IllegalArgumentException("Quantidade inválida");
        }

        jogoDAO.cadastrar(jogo);
    }

    public List<Jogo> listarJogos() {
        return jogoDAO.listar();
    }

    public List<Jogo> buscarPorNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return jogoDAO.listar();
        }
        return jogoDAO.buscarPorNome(nome);
    }

    public boolean excluirPorNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do jogo é obrigatório");
        }

        return jogoDAO.excluirPorNome(nome);
    }

    public boolean atualizar(Jogo jogo) {
        if (jogo == null) {
            throw new IllegalArgumentException("Jogo não pode ser nulo");
        }

        if (jogo.getId() <= 0) {
            throw new IllegalArgumentException("ID inválido");
        }

        if (jogo.getNome() == null || jogo.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }

        return jogoDAO.atualizar(jogo);
    }

    public void excluirJogo(int id) {

        if (id <= 0) {
            throw new IllegalArgumentException("ID do jogo inválido.");
        }

        boolean excluido = jogoDAO.excluirPorId(id);

        if (!excluido) {
            throw new IllegalStateException("Nenhum jogo foi excluído.");
        }
    }

    public void diminuirEstoque(String nomeJogo, int quantidade) {
        List<Jogo> jogos = buscarPorNome(nomeJogo);
        if (jogos.isEmpty()) {
            throw new IllegalArgumentException("Jogo não encontrado.");
        }

        // Pega o primeiro jogo da lista
        Jogo jogo = jogos.get(0);

        int novaQuantidade = jogo.getQuantidade() - quantidade;
        if (novaQuantidade < 0) {
            throw new IllegalArgumentException("Estoque insuficiente");
        }

        jogo.setQuantidade(novaQuantidade);
        atualizar(jogo);
    }

}
