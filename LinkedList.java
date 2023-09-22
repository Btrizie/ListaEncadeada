package TrabalhoListas;

public class LinkedList {
    // Classe inicial de um nodo
    private class Node {
        public Integer element;
        public Node next;

        public Node(Integer element) {
            this.element = element;
            next = null;
        }
        
        public Node(Integer element, Node next, Node prev) {
            this.element = element;
            this.next = next;
        }        
    }

    private Node head;
    private Node tail;
    private int count;
    private Node aux;

    private int position1; 
    private int position2;
    private int auxl;

    //construtor inicial da lista
    public LinkedList() {
        head = null;
        tail = null;
        count = 0;
        position1 = 0;
        position2 = 0;
    }
    
    //retorno caso a lista esteja vazia
    public boolean isEmpty() {
        return (head == null);
    }

    //retorno n° elementos
    public int size() {
        return count;
    }

    //limpa a lista
    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }    

    //adiciona ao final
    public void add( Integer element)  {
        if (isEmpty()) {
            addFront(element);
            return;
        }

        aux = new Node(element);
        tail.next = aux;
        tail = aux;
        count++;
        return;
    }

    //adiciona ao inicio
    public void addFront(Integer element)  { 
        if (isEmpty()) {
            head = new Node(element);
            tail = head;
            count++;
            return;
        }
        aux = new Node(element);
        position1++;
        position2++;
        count++;
        aux.next = head;
        head = aux;
    }
    
    public void addMiddle(int index, Integer element){
        if(index == 0){
            addFront(element);
            return;
        }
        if(index == count-1){
            add(element);
            return;
        }

        Node middle = new Node(element);
        Node counting = head;
        //contagem para chegar no indice desejado
        for(int i = 0; i < index-1 && counting.next != null; i++){
            counting = counting.next;
        }

        middle.next = counting.next;
        counting.next = middle;
        count++;
        if(middle.next == null){
            tail = middle;
        }
    }

    public void remove(Integer nodo){
        Node current = head;

        if (current != null && current.element == nodo) {
            head = current.next;
            return;
        }
        Node prev = null;
        while (current != tail && current.element != nodo) {
            prev = current;
            current = current.next;
        }
        if (current == null) {
            System.out.println("Nodo não encontrado");
            return;
        }
        prev.next = current.next;
        count--;
    }

    public void removeN(String cursor){
        Node current = head;
        if(cursor.equals("C1")){
            if (current != null && current.element == get(position1)) {
            head = current.next;
            return;
            }
            Node prev = null;
            while (current != null && current.element != get(position1)) {
                prev = current;
                current = current.next;
            }
            if (current == null) {
                System.out.println("Nodo não encontrado");
                return;
            }
            prev.next = current.next;
            count--;
            return;
        }

        if(cursor.equals("C2")){
            if (current != null && current.element == get(position2)) {
            head = current.next;
            return;
            }
            Node prev = null;
            while (current != null && current.element != get(position2)) {
                prev = current;
                current = current.next;
            }
            if (current == null) {
                System.out.println("Nodo não encontrado");
                return;
            }
            prev.next = current.next;
            count--;
            return;
        }

        
    }

    public Integer get(int index)  { 
        if (index == size()-1){
            return tail.element;
        }
            
        Node aux = head;
        int c = 0;
        while (c < index && aux.next!=null) {
            aux = aux.next;
            c++;
        }
        return (aux.element);
    }

    //movimenta o cursor para a direita
    public void pRight(String c, int mov){
        int auxx = 0;
        if(c.equals("C1")){
            //caso exceda o tamanho da lista
            if(position1 + mov >= count){
                position1 = count-1;
                System.out.println("O numero excede o tamanho da lista!");
            }
            //caso c2 esteja antes da posição
            else if(position2 < position1 + mov && position1 < position2){
                position1 = position2;
                auxx = position1 + mov - position2;
                position1 = position1 + auxx;
                System.out.println("O cursor foi movido pra a posição C2...| Movimentação concluida!");
            }
            //caso c2 seja mais rapido (volta)
            else if((position2/2) < position1 + mov && position1 < position2){
                position1 = position2;
                auxx = position2 - position1 - mov;
                position1 = position1 - auxx;
                System.out.println("O cursor foi movido pra a posição C2...| Movimentação concluida!");
            }
            else{
                position1 = position1 + mov;
                System.out.println("Movimentação concluida!");
            }
        }

        if(c.equals("C2")){
            //caso exceda o tamanho da lista
            if(position2 + mov >= count){
                position2 = count-1;
                System.out.println("O numero excede o tamanho da lista!");
            }
            //caso c1 esteja antes da posição
            else if(position1 < position2 + mov && position2 < position1){
                position2 = position1;
                auxx = position2 + mov - position1;
                position2 = position2 + auxx;
                System.out.println("O cursor foi movido pra a posição C1...| Movimentação concluida!");
            }
            //caso c1 seja mais rapido (volta)
            else if((position1/2) < position2 + mov && position2 < position1){
                position2 = position1;
                auxx = position2 - position1 - mov;
                position2 = position2 - auxx;
                System.out.println("O cursor foi movido pra a posição C1...| Movimentação concluida!");
            }
            else{
                position2 = position2 + mov;
                System.out.println("Movimentação concluida!");
            }
        }
    }

    //movimenta o cursor para a esquerda
    public void pLeft(String cursor, int mov){
        int position1E = 0;
        int position2E = 0;
        int auxiliar = 0;
        if(cursor.equals("C1")){
            //caso exceda o tamanho da lista
            if(position1 - mov < 0){
                position1 = 0;
                System.out.println("O numero excede o tamanho da lista!| O cursor foi movido pra a posição HEAD...| Movimentação concluida!");
            }
            //caso c2 esteja depois da posição
            else if(position2 > position1-mov && position1 > position2){
                position1E = position1;
                position1 = position2;
                auxiliar = position1 + mov - position2E;
                position1 = position1 + auxiliar;
                System.out.println("O cursor foi movido pra a posição C2...| Movimentação concluida!");
            }
            //caso c2 seja mais rapido (ida)
            else if((position2*2) > position1 - mov && position2 < position1){
                position1E = position1;
                position1 = position2;
                auxiliar = position1E - position2 - mov;
                position1 = position1 + auxiliar;
                System.out.println("O cursor foi movido pra a posição C2...| Movimentação concluida!");

            }
            else{
                position1 = position1 - mov;
                System.out.println("Movimentação concluida!");
            }
        }

        if(cursor.equals("C2")){
            
            //caso exceda o tamanho da lista
            if(position2 - mov < 0){
                position2 = 0;
                System.out.println("O numero excede o tamanho da lista!| O cursor foi movido pra a posição HEAD...| Movimentação concluida!");
            }
            //caso c1 esteja depois da posição
            else if(position1 > position2-mov && position2 > position1){
                position2E = position2;
                position2 = position1;
                auxiliar = position2 + mov - position2E;
                position2 = position2 + auxiliar;
                System.out.println("O cursor foi movido pra a posição C1...| Movimentação concluida!");
            }
            //caso c2 seja mais rapido (ida)
            else if((position1*2) > position2 - mov && position1 < position2){
                position2E = position2;
                position2 = position1;
                auxiliar = position2E - position1 - mov;
                position2 = position2 + auxiliar;
                System.out.println("O cursor foi movido pra a posição C1...| Movimentação concluida!");
            }
            else{
                position2 = position2 - mov;
                System.out.println("Movimentação concluida!");
            }
        }
    }
    
    public int getPosition1(){
        return position1;
    }

    public int getPosition2(){
        return position2;
    }
    
    public int elementC1(){
        return get(position1);
    }

    public int elementC2(){
        return get(position2);
    }

    public void insertCursor(String c, Integer element){
        if(c.equals("C1")){
            addMiddle(position1, element);
            return;
        }
        if(c.equals("C2")){
            addMiddle(position2, element);
        }
    }

    //insere um nodo depois do cursor
    public void insertRight(String c, Integer element){
        if(c.equals("C1")){
            if(position1 == count - 1){
                add(element);
                return;
            }
            addMiddle(position1+1, element);
            if(position1 < position2){
                position2++;
            }
            return;
        }

        if(c.equals("C2")){
            if(position2 == count - 1){
                add(element);
                return;
            }
            addMiddle(position2+1, element);
            if(position2 < position1){
                position1++;
            }
            return;
        }
    }

    //insere um nodo antes do cursor
    public void insertLeft(String c, Integer element){
        if(c.equals("C1")){
            if(position1 == 0){
                addFront(element);
                position2++;
                return;
            }
            if(position1 < position2){
                position2++;
                count++;
            }
            addMiddle(position1-1, element);
            position1++;
            return;
        }

        if(c.equals("C2")){
            if(position2 == 0){
                addFront(element);
                position2++;
                return;
            }
            if(position2 < position1){
                position1++;
                count++;
            }
            addMiddle(position2-1, element);
            position2++;
            return;
        }
    }

    //inverte os cursores
    public void switchC(){
        auxl = position1;
        position1 = position2;
        position2 = auxl;
    }

    //inverte os nodos apontados pelos cursores
    public void switchNodos(){
        Integer aux1 = get(position1);
        Integer aux2 = get(position2);
        Integer aux3 = -2;
        remove(aux1);
        addMiddle(position1, aux3);
        remove(aux2);
        addMiddle(position2,aux1);
        remove(aux3);
        addMiddle(position1, aux2);
    }

    public void switchN(int index1, int index2) {
        Integer aux1 = get(index1);
        Integer aux2 = get(index2);
        Integer aux3 = -2;
        remove(aux1);
        addMiddle(index1, aux3);
        remove(aux2);
        addMiddle(index2,aux1);
        remove(aux3);
        addMiddle(index1, aux2);
    }


    
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
    
        Node aux = head;
        if (count == 0) {
            s.append("Lista Vazia");
            return s.toString();
        }
    
        while (aux != null) {
            if (get(position1) == get(position2) && get(position1) == aux.element) {
                s.append(aux.element.toString());
                s.append(" -> C1 -> C2");
                s.append("\n");
            } else if (get(position1) == aux.element) {
                s.append(aux.element.toString());
                s.append(" -> C1");
                s.append("\n");
            } else if (get(position2) == aux.element) {
                s.append(aux.element.toString());
                s.append(" -> C2");
                s.append("\n");
            } else {
                s.append(aux.element.toString());
                s.append("\n");
            }
            aux = aux.next;
        }
    
        return s.toString();
    }

    public void ordenaLista(){
        int n = size();
        add(-2);
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < n; i++) {
                if (get(i) > get(i+1)) {
                    switchN(i, i+1);
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
        remove(-2);
    }

}