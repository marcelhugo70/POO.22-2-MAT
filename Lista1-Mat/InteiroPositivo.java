
/**
 * Escreva uma descrição da classe InteiroPositivo aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class InteiroPositivo
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private int x;

    // item a
    public void setValor(int valor){
        if (valor >= 0){
            this.x = valor;
        }
    }
    
    public int getValor(){
        return this.x;
    }
    
    // item b
    public long multiplicar(InteiroPositivo outro){
        return this.x * outro.getValor();
    }
    
    // item c
    public long fatorial(){
        return 0;
    }
}
