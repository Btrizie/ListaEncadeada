package TrabalhoListas;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkedList lista = new LinkedList();

        //lista encadeada
        lista.addFront(2);
        lista.add(4);
        lista.add(6);
        lista.add(8);
        lista.add(10);
        lista.add(12);
        System.out.println(lista);

        //movimenta o cursor para o lado direito
        lista.pRight("C2",2);
        lista.pRight("C1",11);
        System.out.println(lista);

        //movimenta o cursor para o lado esquerdo
        lista.pLeft("C2",2);

        //insere um elemento no cursor
        lista.insertCursor("C1", 5);
        
        //insere um elemento a direita do cursor
        lista.insertRight("C1",21);
        lista.insertRight("C2",3);
        System.out.println(lista);

        //insere um elemento a esquerda do cursor
        lista.insertLeft("C1",9);
        lista.insertLeft("C2",0);
        System.out.println(lista);
        
        //trocar os nodos apontados pelos cursores entre si
        //lista.switchN(); --> troca os nodos entre si

        System.out.printf("C1- posição: %d | elemento: %d",lista.getPosition1(),lista.elementC1());
        System.out.printf("\nC2- posição: %d | elemento: %d",lista.getPosition2(),lista.elementC2());

        in.close();
    }
    
}
