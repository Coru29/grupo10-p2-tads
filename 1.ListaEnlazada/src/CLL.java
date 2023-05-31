public class CLL<T extends  Comparable<T>> implements Lista<T> {

    private NodeLinkedList<T> head;
    private NodeLinkedList<T> tail;

    @Override
    public void add(T value) {
        NodeLinkedList<T> nuevoNodo = new NodeLinkedList<>();
        nuevoNodo.value = value;

        if(head == null){
            head = nuevoNodo;
            tail = nuevoNodo;
            return;
        }
        tail.next = nuevoNodo; // para añadir el valor al final, el q viene a tail va a ser el nuevo
        nuevoNodo.next = head; // el q viene al nuevo va a ser head, para que quede entre tail y head
        tail = nuevoNodo; //el nuevo pasa a ser el ultimo
    }

    @Override
    public void remove(int position) {
        NodeLinkedList<T> tempNodeLinkedList = head;

        if (position == 0){
            head = head.next;
            tail.next = head;
            return;
        }

        for(int i = 0; i < position-1; i++){
            tempNodeLinkedList = tempNodeLinkedList.next;
        }
        tempNodeLinkedList.next = tempNodeLinkedList.next.next;


    }

    @Override
    public void get(int position) {

    }

    @Override
    public void find(T value) {
        NodeLinkedList<T> tempNodeLinkedList = new NodeLinkedList<>();
        tempNodeLinkedList.value = value;


    }

    @Override
    public void addFirst(T value) {
        NodeLinkedList<T> nuevoNodo = new NodeLinkedList<>();
        nuevoNodo.value = value;

        tail.next = nuevoNodo;
        nuevoNodo.next = head;
        head = nuevoNodo;
    }

    @Override
    public void addAt(T value, int position) {
        
    }

    @Override
    public void addInOrder(T value) {

    }

    @Override
    public void imprimir() {

        NodeLinkedList<T> tempNodeLinkedList = head;

        if (head != null){
            do{
                System.out.print(tempNodeLinkedList.value + " --> ");
                tempNodeLinkedList = tempNodeLinkedList.next;
            }while (tempNodeLinkedList != head);
        }
        System.out.print("head");
    }

    // -----  ------  -----  ------  -----  ------  -----  ------  -----  ------  -----  ------
    //aca arranca el main

    public static void main(String[] args){
        CLL<String> listorta = new CLL<>();

        //pruebo el add
        listorta.add("cero");
        listorta.add("dos");
        listorta.add("cuatro");

        //pruebo el addFirst
        listorta.addFirst("papafrita");
        listorta.addFirst("huevofrit0");


        //pruebo el remove
        listorta.remove(2);

        //pruebo el find
        listorta.find("cuatro");

        listorta.imprimir();


    }
}