
public class Curso {
    private String sigla;
    private String nomeCurso;
    
    public Curso(String sigla, String nomeCurso) {
        this.setSigla(sigla);
        this.setNomeCurso(nomeCurso);
    }
    public String getSigla() {
        return sigla;
    }
    public void setSigla(String sigla) {
        if (sigla.length() == 3) {
            this.sigla = sigla.toUpperCase();
        } else {
            throw new IllegalArgumentException("Sigla deve conter 3 letras");
        }
    }
    public String getNomeCurso() {
        return nomeCurso;
    }
    public void setNomeCurso(String nomeCurso) {
        if (nomeCurso != null && !nomeCurso.isBlank() && nomeCurso.length() >= 5) {         
            this.nomeCurso = nomeCurso;
        } else {
            throw new IllegalArgumentException("Nome inválido do Curso.");
        }
    }
    
    protected void finalize() throws Throwable {
        System.out.println("FIM do curso"+this.sigla);
    }
    
    public String toString() {
    	return this.sigla;
    }
}