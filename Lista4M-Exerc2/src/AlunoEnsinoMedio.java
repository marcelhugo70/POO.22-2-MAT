import java.time.LocalDate;
public class AlunoEnsinoMedio extends Aluno  {
    private int ano;
    
    public AlunoEnsinoMedio(String nome, LocalDate dataNascimento, int ano) {
        super(nome, dataNascimento);
        this.setAno(ano);
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        if (ano >= 1 || ano <= 3) {
            this.ano = ano;
        }
        else {
            throw new IllegalArgumentException("Ano inv�lido, tente novamente...");
        }
    }
    public String mostra() {
        return this.getNome() + " est� cursando o " + this.getAno() + " ano do ensino m�dio e tem "
                + this.getIdade()+" anos.";
    }
    protected void finalize() throws Throwable {
        System.out.println("FIM do Aluno Ensino M�dio "+this.getNome());
        super.finalize();
    }
}