public class Cidade // colaboração do Arthur
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private String nome;
    private int populacaoM;
    private int populacaoF;
    private String uf;
    private boolean calculado;
    
    public Cidade(){
    }
    
    public Cidade(String nome, int populacaoM, int populacaoF)
    {
        this.setNome(nome);
        this.setPopulacaoM(populacaoM);
        this.setPopulacaoF(populacaoF);
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    public String getNome()
    {
        return nome;
    }
    
    public void setUf(String uf)
    {
        this.uf = uf;
    }
    
    public String getUf()
    {
        return uf;
    }
    
    public void setPopulacaoM(int populacaoM)
    {
        this.populacaoM = populacaoM;
    }
    
    public int getPopulacaoM()
    {
        return populacaoM;
    }
    
    public void setPopulacaoF(int populacaoF)
    {
        this.populacaoF = populacaoF;
    }
    
    public int getPopulacaoF()
    {
        return populacaoF;
    }
    
    public void setCalculado(boolean calculado)
    {
        this.calculado = calculado;
    }
    
    public boolean getCalculado()
    {
        return calculado;
    }
}