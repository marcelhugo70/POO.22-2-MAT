
public class Produto { // contribuição da Maria Julia
    private String nome;
    private String descricao;
    private double precoUnitario;
    private int desconto;
 
    public Produto(String nome, String descricao, double precoUnitario, int desconto) {
        setNome(nome);
        setDescricao(descricao);
        setPrecoUnitario(precoUnitario);
        setDesconto(desconto);
    }
 
    public void setNome(String nome) {
        this.nome = nome;
    }
 
    public String getNome() {
        return nome;
    }
 
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
 
    public String getDescricao() {
        return descricao;
    }
 
    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
 
    public double getPrecoUnitario() {
        return precoUnitario;
    }
 
    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }
 
    public int getDesconto() {
        return desconto;
    }
}
