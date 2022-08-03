
/**
 * Escreva uma descrição da classe Desenhista aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Desenhista
{

    /**
     * Um exemplo de um método - substitua este comentário pelo seu próprio
     * 
     * @param  y   um exemplo de um parâmetro de método
     * @return     a soma de x e y 
     */
public void desenharRosto() // contribuição do Felipe
    {
        Circle rosto = new Circle();
        rosto.changeSize(180);
        rosto.makeVisible();
       
        Circle eyeOne = new Circle();
        Circle eyeTwo = new Circle();
        eyeOne.makeVisible();
        eyeTwo.makeVisible();
        eyeOne.changeColor("green");
        eyeTwo.changeColor("green");
       
        eyeOne.moveHorizontal(130);
        eyeTwo.moveRight();
        eyeOne.moveDown();
        eyeOne.moveDown();
        eyeTwo.moveDown();
        eyeTwo.moveDown();
       
        Square mouth = new Square();
        mouth.makeVisible();
        mouth.moveRight();
        //mouth.moveRight();
        mouth.moveHorizontal(15);
        mouth.moveVertical(130);
       
        Triangle nose = new Triangle();
        nose.changeColor("black");
        nose.makeVisible();
        nose.moveRight();
        nose.moveRight();
        nose.moveHorizontal(20);
        nose.moveVertical(130);
       
        Triangle hat = new Triangle();
        hat.changeColor("magenta");
        hat.makeVisible();
        hat.changeSize(80,80);
        hat.moveRight();
        hat.moveRight();
        hat.moveRight();
        hat.moveUp();
        hat.moveUp();
        hat.moveVertical(20);
       
    }
}
