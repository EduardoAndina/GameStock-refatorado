package gamestock.model;

public class Venda {

    private int id;
    private int idJogo;
    private String nomeJogo;
    private String categoria;
    private int quantidadeVendida;
    private double valorPago;
    private String nomeCliente;
    private String telefoneCliente;

    public Venda() {
    }

    public Venda(int id, int idJogo, String nomeJogo, String categoria, int quantidadeVendida,
            double valorPago, String nomeCliente, String telefoneCliente) {
        this.id = id;
        this.idJogo = idJogo;
        this.nomeJogo = nomeJogo;
        this.categoria = categoria;
        this.quantidadeVendida = quantidadeVendida;
        this.valorPago = valorPago;
        this.nomeCliente = nomeCliente;
        this.telefoneCliente = telefoneCliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }

    public String getNomeJogo() {
        return nomeJogo;
    }

    public void setNomeJogo(String nomeJogo) {
        this.nomeJogo = nomeJogo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }
}
