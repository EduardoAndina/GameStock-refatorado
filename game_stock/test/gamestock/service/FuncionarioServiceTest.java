package gamestock.service;

import org.junit.Test;
import static org.junit.Assert.*;

public class FuncionarioServiceTest {

    @Test
    public void deveValidarCredenciaisQuandoCamposPreenchidos() {
        FuncionarioService service = new FuncionarioService();

        boolean resultado = service.validarCredenciais("admin", "123");

        assertTrue(resultado);
    }

    @Test
    public void naoDeveValidarCredenciaisQuandoUsuarioVazio() {
        FuncionarioService service = new FuncionarioService();

        boolean resultado = service.validarCredenciais("", "123");

        assertFalse(resultado);
    }

    @Test
    public void naoDeveValidarCredenciaisQuandoSenhaNula() {
        FuncionarioService service = new FuncionarioService();

        boolean resultado = service.validarCredenciais("admin", null);

        assertFalse(resultado);
    }
}
