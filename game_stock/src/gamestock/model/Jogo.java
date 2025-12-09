package gamestock.model;

public class Jogo {

    private int id;
    private String nome;
    private String categoria;
    private String plataforma;
    private double preco;
    private int quantidade;

    public Jogo() {
    }

    public Jogo(int id, String nome, String categoria, String plataforma, double preco, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.plataforma = plataforma;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
