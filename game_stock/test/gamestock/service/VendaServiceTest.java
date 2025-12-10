package gamestock.service;

import gamestock.model.Venda;
import org.junit.Test;
import static org.junit.Assert.*;

public class VendaServiceTest {

    @Test
    public void deveAceitarVendaComDadosValidos() {
        Venda venda = new Venda();
        venda.setNomeJogo("FIFA 24");
        venda.setNomeCliente("Carlos");
        venda.setQuantidadeVendida(2);

        VendaService service = new VendaService();

        boolean resultado = service.vendaValida(venda);

        assertTrue(resultado);
    }

    @Test
    public void naoDeveAceitarVendaComQuantidadeInvalida() {
        Venda venda = new Venda();
        venda.setNomeJogo("FIFA 24");
        venda.setNomeCliente("Carlos");
        venda.setQuantidadeVendida(0);

        VendaService service = new VendaService();

        boolean resultado = service.vendaValida(venda);

        assertFalse(resultado);
    }

    @Test
    public void naoDeveAceitarVendaComNomeDoClienteVazio() {
        Venda venda = new Venda();
        venda.setNomeJogo("FIFA 24");
        venda.setNomeCliente("");
        venda.setQuantidadeVendida(1);

        VendaService service = new VendaService();

        boolean resultado = service.vendaValida(venda);

        assertFalse(resultado);
    }
}
