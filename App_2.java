package TrabalhoListas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App_2 {
    public static void main(String[] args) throws FileNotFoundException {
        LinkedList lista = new LinkedList();
        Scanner in = new Scanner(System.in);
        int escolha;

        //lista encadeada
        lista.add(2);
        lista.add(4);
        lista.add(6);
        lista.add(8);
        lista.add(10);
        lista.add(12);
        System.out.println(lista);

        File myObj = new File("interface.txt");
        Scanner myReader = new Scanner(myObj);
        String[] numeros = new String [14];
        int index = 0;
        while (myReader.hasNextLine()){
            String d = myReader.nextLine();
            numeros[index] = d;
            index++;
        }
        myReader.close();

        int i = 0;
        do {
            System.out.printf("C1- posição: %d | elemento: %d",lista.getPosition1(),lista.elementC1());
            System.out.printf("\nC2- posição: %d | elemento: %d\n",lista.getPosition2(),lista.elementC2());
            for(i = 0; i < 14; i++){
                System.out.println(numeros[i]);
            }
            i = 0;

            escolha = in.nextInt();
            in.nextLine();
            switch (escolha) {
                case 1: //adicionar um elemento ao final
                    System.out.println("Informe o elemento a ser adicionado ao final: ");
                    int element1 = in.nextInt();
                    in.nextLine();
                    lista.add(element1);
                    System.out.println(" ");
                    System.out.println(lista);
                    break;
                case 2: //adicionar um elemento ao inicio
                    System.out.println("Informe o elemento a ser adicionado ao início: ");
                    int element2 = in.nextInt();
                    in.nextLine();
                    lista.addFront(element2);
                    System.out.println(" ");
                    System.out.println(lista);
                    break;
                case 3: //adicionar um elemento na posição de um cursor
                    System.out.println("Informe o cursor a realizar a ação: ");
                    String cursor = in.nextLine();
                    if(cursor.equals("C1")){
                        System.out.println("Informe o elemento a ser adicionado no cursor C1: ");
                        int element3 = in.nextInt();
                        in.nextLine();
                        lista.insertCursor("C1", element3);
                        System.out.println(" ");
                        System.out.println(lista);
                        break;
                    }
                    if(cursor.equals("C2")){
                        System.out.println("Informe o elemento a ser adicionado no cursor C2: ");
                        int element3 = in.nextInt();
                        in.nextLine();
                        lista.insertCursor("C2", element3);
                        System.out.println(" ");
                        System.out.println(lista);
                        break;
                    }
                    else System.out.print("Cursor inválido!");
                    break;
                case 4: //adicionar um elemento depois de um cursor
                    System.out.println("Informe o cursor a realizar a ação: ");
                    cursor = in.nextLine();
                    if(cursor.equals("C1")){
                        System.out.println("Informe o elemento a ser adicionado depois do cursor C1: ");
                        int element3 = in.nextInt();
                        in.nextLine();
                        lista.insertRight("C1", element3);
                        System.out.println(" ");
                        System.out.println(lista);
                        break;
                    }
                    if(cursor.equals("C2")){
                        System.out.println("Informe o elemento a ser adicionado depois do cursor C2: ");
                        int element3 = in.nextInt();
                        in.nextLine();
                        lista.insertRight("C2", element3);
                        System.out.println(" ");
                        System.out.println(lista);
                        break;
                    }
                    else System.out.print("Cursor inválido!");
                    break;
                case 5: //adicionar um elemento antes do cursor
                    System.out.println("Informe o cursor a realizar a ação: ");
                    cursor = in.nextLine();
                    if(cursor.equals("C1")){
                        System.out.println("Informe o elemento a ser adicionado antes do cursor C1: ");
                        int element3 = in.nextInt();
                        lista.insertLeft("C1", element3);
                        System.out.println(" ");
                        System.out.println(lista);
                        break;
                    }
                    if(cursor.equals("C2")){
                        System.out.println("Informe o elemento a ser adicionado antes do cursor C2: ");
                        int element3 = in.nextInt();
                        lista.insertLeft("C2", element3);
                        System.out.println(" ");
                        System.out.println(lista);
                        break;
                    }
                    else System.out.println("Cursor inválido!");
                    break;
                case 6: //adicionar um nodo mantendo sua ordem
                    System.out.println("Informe o nodo a ser inserido: ");
                    int element7 = in.nextInt();
                    lista.add(element7);
                    lista.ordenaLista();
                case 7: //remover um nodo de um cursor
                    System.out.println("Informe o cursor a realizar a ação: ");
                    cursor = in.nextLine();
                    if(cursor.equals("C1")){
                        lista.removeN("C1");
                        System.out.println(" ");
                        System.out.println(lista);
                        break;
                    }
                    if(cursor.equals("C2")){
                        lista.removeN("C2");
                        System.out.println(" ");
                        System.out.println(lista);
                        break;
                    }

                case 8: //remover um nodo pelo seu valor
                    System.out.println("Informe o elemento a ser removido: ");
                    int element4 = in.nextInt(); 
                    lista.remove(element4);
                    System.out.println(lista);
                    break;
                case 9: //mover o cursor para frente
                    System.out.println("Informe o cursor a realizar a ação: ");
                    cursor = in.nextLine();
                    if(cursor.equals("C1")){
                        System.out.println("Informe o numero de posições a mover cursor C1: ");
                        int element3 = in.nextInt();
                        lista.pRight("C1", element3);
                        System.out.println(" ");
                        System.out.println(lista);
                        break;
                    }
                    if(cursor.equals("C2")){
                        System.out.println("Informe o numero de posições a mover cursor C2: ");
                        int element3 = in.nextInt();
                        lista.pRight("C2", element3);
                        System.out.println(" ");
                        System.out.println(lista);
                        break;
                    }
                    else System.out.println("Cursor inválido!");
                    break;
                case 10: //mover o cursor para trás
                    System.out.println("Informe o cursor a realizar a ação: ");
                    cursor = in.nextLine();
                    in.nextLine(); 
                    if(cursor.equals("C1")){
                        System.out.println("Informe o numero de posições a mover cursor C1: ");
                        int element3 = in.nextInt();
                        lista.pLeft("C1", element3);
                        System.out.println(" ");
                        System.out.println(lista);
                        break;
                    }
                    if(cursor.equals("C2")){
                        System.out.println("Informe o numero de posições a mover cursor C2: ");
                        int element3 = in.nextInt();
                        lista.pLeft("C2", element3);
                        System.out.println(" ");
                        System.out.println(lista);
                        break;
                    }
                    else System.out.println("Cursor inválido!");
                    break;
                case 11: //inverter os nodos apontados
                    lista.switchNodos();
                    System.out.println(" ");
                    System.out.println(lista);
                    break;
                case 12: //ordenar a lista
                    lista.ordenaLista();
                    System.out.println(" ");
                    System.out.println("Lista ordenada: ");
                    System.out.println(lista);
                    break;
                case 13: //exibir a lista
                    System.out.println(" ");
                    System.out.println("Lista com cursores C1 e C2:");
                    System.out.println(lista);
                    break;
                case 14: //sair
                    System.out.println(" ");
                    System.out.println("Saindo do menu.");
                    break;
                default:
                    System.out.println(" ");
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (escolha != 14);

        in.close();
    }
}

