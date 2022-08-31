
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
        long fat = 1;

        for (int i=this.x; i > 1; i--){
            fat = fat * i;
        }

        return fat;
    }

    // item d
    public String identificarDivisores(){
        String resultado = "Os divisores inteiros são ";
        int contador = 0;
        for (int den = 1; den <= this.x; den++){
            if (this.x % den == 0){
                resultado = resultado + den +", ";
                contador++;
            }
        }
        resultado = resultado.substring(0,resultado.length()-2);
        resultado = resultado + " e a quantidade de divisores é "+contador;
        return resultado;
    }

    // item e
    public int[] fibonacci(){
        int[] vetor = new int[this.x];
        // testes para evitar ArrayIndexOutOfBoundsException
        if (vetor.length > 0){
            vetor[0] = 1;
            if (vetor.length > 1){
                vetor[1] = 1;
            }
        }
        for (int pos = 2; pos < this.x; pos++){
            vetor[pos] = vetor[pos-1] + vetor[pos-2];
        }
        return vetor;
    }
}
