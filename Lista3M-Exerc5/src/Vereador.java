
public class Vereador { // contribuição do Nicolas
    private String nome;
    private Partido partido;
    private int qtdProjApres;
    private int qtdProjAprov;
    
    public Vereador(String nome, Partido partido) {
        this.setNome(nome);
        this.setPartido(partido);
    }
    
    public void setNome(String nome) {
        if (nome != null && !nome.isBlank()) {
            this.nome = nome;
        }
    }
    
    public void setPartido(Partido partido) {
        if (partido != null) {
            this.partido = partido;
            partido.addVereador(this); // em razão da navegabilidade bidirecional
        }
    }
    
    public void addProjApres() {
        this.qtdProjApres++;
    }

    public void setQtdProjApres(int qtde) {
    	if (qtde >= 0) {
    		this.qtdProjApres = qtde;
    	}
    }

    public void addProjAprov() {
        this.qtdProjAprov++;
    }
    
    public void setQtdProjAprov(int qtde) {
    	if (qtde >= 0) {
    		this.qtdProjAprov = qtde;
    	}
    }
    
    public String getNome() {
        return nome;
    }
    
    public Partido getPartido() {
        return partido;
    }
    
    public int getQtdProjApres() {
        return qtdProjApres;
    }
    
    public int getQtdProjAprov() {
        return qtdProjAprov;
    }
    
    public double getIndiceTrabalho() {
        if (qtdProjApres > 17) {
            return 1.22d;
        } else if (qtdProjApres > 10) {
            return 1.08d;
        } else if (qtdProjApres > 5) {
            return 1d;
        } else if (qtdProjApres > 0) {
            return 0.8d;
        }
        return 0;
    }
    
    public double getDesempenho() {
    	if (qtdProjApres == 0) {
    		return 0;
    	}
        return (qtdProjAprov/qtdProjApres)*getIndiceTrabalho();
    }
    
}