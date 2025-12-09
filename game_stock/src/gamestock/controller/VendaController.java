package gamestock.controller;

import gamestock.model.Venda;
import gamestock.model.Jogo;
import gamestock.service.VendaService;
import gamestock.service.JogoService;

import java.util.List;
import java.util.stream.Collectors;

public class VendaController {

    private VendaService vendaService;
    private JogoService jogoService;

    public VendaController(VendaService vendaService, JogoService jogoService) {
        this.vendaService = vendaService;
        this.jogoService = jogoService;
    }

    public void registrarVenda(Venda venda) {
        if (venda == null) {
            throw new IllegalArgumentException("Venda não pode ser nula.");
        }
        if (venda.getQuantidadeVendida() <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
        }
        if (venda.getValorPago() <= 0) {
            throw new IllegalArgumentException("Valor pago deve ser maior que zero.");
        }
        List<Jogo> jogos = jogoService.buscarPorNome(venda.getNomeJogo());
        if (jogos.isEmpty()) {
            throw new IllegalArgumentException("Jogo não encontrado.");
        }
        Jogo jogo = jogos.get(0);
        int novaQuantidade = jogo.getQuantidade() - venda.getQuantidadeVendida();
        if (novaQuantidade < 0) {
            throw new IllegalArgumentException("Quantidade em estoque insuficiente!");
        }
        jogo.setQuantidade(novaQuantidade);
        jogoService.atualizar(jogo);
        vendaService.cadastrar(venda);
    }

    public void atualizarVenda(Venda venda) {
        if (venda == null) {
            throw new IllegalArgumentException("Venda não pode ser nula.");
        }
        if (venda.getQuantidadeVendida() <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
        }
        if (venda.getValorPago() <= 0) {
            throw new IllegalArgumentException("Valor pago deve ser maior que zero.");
        }
        vendaService.atualizar(venda);
    }

    public List<Venda> listarVendas() {
        return vendaService.listar();
    }

    public List<Venda> buscarPorJogoOuCliente(String busca) {
        String termo = busca.toLowerCase();
        return listarVendas().stream()
                .filter(v -> v.getNomeJogo().toLowerCase().contains(termo)
                || v.getNomeCliente().toLowerCase().contains(termo))
                .collect(Collectors.toList());
    }
}
