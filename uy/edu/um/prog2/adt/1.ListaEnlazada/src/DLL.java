public class DLL<T extends  Comparable<T>> implements Lista<T> {

    NodeLinkedList<T> head;


    @Override
    public void add(T value) {
        NodeLinkedList<T> nuevoNodo = new NodeLinkedList<>();
        nuevoNodo.value = value;

        NodeLinkedList<T> last = head;
        nuevoNodo.next = null; //xq lo voy a agregar al final

        if(head == null){ //en caso q la lista este vacia
            nuevoNodo.prev = null;
            head = nuevoNodo;
            return;
        }

        while (last.next != null){
            last = last.next;
        }
        last.next = nuevoNodo;
        nuevoNodo.prev = last;
    }

    @Override
    public void remove(int position) {
        NodeLinkedList<T> tempNodeLinkedList = head;

        for (int i = 0; i < position; i++) {
            tempNodeLinkedList = tempNodeLinkedList.next;
        }
        tempNodeLinkedList.next.prev = tempNodeLinkedList.prev;

        tempNodeLinkedList.prev.next = tempNodeLinkedList.next;

    }

    @Override
    public void get(int position) {

    }

    @Override
    public void find(T value) {

    }

    @Override
    public void addFirst(T value) {
        NodeLinkedList<T> nuevoNodo = new NodeLinkedList<>();
        nuevoNodo.value = value;

        // el prev es null xq este va a ser el primero
        nuevoNodo.next = head;
        nuevoNodo.prev = null;

        if (head != null){
            head.prev = nuevoNodo;
        }
        //el primero (head) pasa a ser el nuevoNodo
        head = nuevoNodo;

    }

    @Override
    public void addAt(T value, int position) {
        NodeLinkedList<T> nuevoNodo = new NodeLinkedList<>();
        nuevoNodo.value = value;
        nuevoNodo.next = null;

        NodeLinkedList tempNodeLinkedList = head;

        //en caso de q la poscicion sea 0
        if(position == 0){
            addFirst(value);

        }else {
            for (int i = 0; i < position - 1; i++) {
                tempNodeLinkedList = tempNodeLinkedList.next;
            }
            nuevoNodo.next = tempNodeLinkedList.next;
            tempNodeLinkedList.next = nuevoNodo;

            nuevoNodo.prev = tempNodeLinkedList;
            nuevoNodo.next.prev = nuevoNodo;
        }
    }

    @Override
    public void addInOrder(T value) {

    }

    @Override
    public void imprimir() {
        NodeLinkedList<T> tempNodeLinkedList = head;
        NodeLinkedList<T> last = null;

        while (tempNodeLinkedList != null){
            System.out.print(tempNodeLinkedList.value + " --> ");
            last = tempNodeLinkedList;
            tempNodeLinkedList = tempNodeLinkedList.next;
        }
        System.out.print("final NULL");

        System.out.println();
        // para imprimir la DLL al reves
        while (last != null){
            System.out.print(last.value + " <-- ");
            last = last.prev;
        }
        System.out.print("empieza NULL");

    }



    // -----  ------  -----  ------  -----  ------  -----  ------  -----  ------  -----  ------
    //aca arranca el main

    public static void main(String[] args){
        DLL<Integer> listorti = new DLL<>();

        //pruebo el addFirst
        listorti.addFirst(3);
//        listorti.addFirst("2");
        listorti.addFirst(1);
//        listorti.addFirst("0");

        // pruebo el Add (que añade al final)
        listorti.add(5);

        //pruebo el addAt
        listorti.addAt(4, 4);

        //pruebo el Remove
        listorti.remove(2);

        //el coso para imprimir
        listorti.imprimir();

    }

}
