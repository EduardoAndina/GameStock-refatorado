package gamestock.service;

import org.junit.Test;
import static org.junit.Assert.*;

public class JogoServiceTest {

    @Test
    public void devePermitirVendaQuandoEstoqueSuficiente() {
        JogoService service = new JogoService();

        boolean resultado = service.estoqueSuficiente(10, 3);

        assertTrue(resultado);
    }

    @Test
    public void naoDevePermitirVendaQuandoEstoqueInsuficiente() {
        JogoService service = new JogoService();

        boolean resultado = service.estoqueSuficiente(2, 5);

        assertFalse(resultado);
    }

    @Test
    public void naoDevePermitirVendaComQuantidadeInvalida() {
        JogoService service = new JogoService();

        boolean resultado = service.estoqueSuficiente(10, 0);

        assertFalse(resultado);
    }
}
