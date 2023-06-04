public class Queue<T extends Comparable<T>> implements MyQueue<T>{

    public Node <T> tail_rear;
    public Node <T> head_front;

    @Override
    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element, 0); 

        if (head_front == null && tail_rear == null) {
            head_front = tail_rear = newNode;
            return;
        }

        tail_rear.next = newNode;
        tail_rear = newNode;
    }



    @Override
    public T dequeue() {
        if (head_front == null) return null; // Si la cola está vacía, devolvemos null

        T value = head_front.data; // Guardamos el valor que vamos a devolver

        if(head_front == tail_rear){ // Si solo hay un elemento
            head_front = tail_rear = null;
        } else {
            head_front = head_front.next;
        }

        return value; // Devolvemos el valor
    }


    @Override
    public boolean isEmpty() {
        return (head_front == null && tail_rear == null);
    }


    @Override
    public void imprimir() {
        Node<T> temporaryNode = head_front;

        while (temporaryNode.next != null){
            System.out.print(temporaryNode.data + " --> ");
            temporaryNode = temporaryNode.next;
        }
        System.out.println(temporaryNode.data);
    }

    @Override
    public void enqueueWithPriority(T element, int priority) {
        Node<T> newNode = new Node<>(element, priority);

        // Si la cola está vacía, el nuevo nodo es tanto la cabeza como la cola
        if (isEmpty()) {
            head_front = tail_rear = newNode;
            return;
        }

        // Si la prioridad del nuevo nodo es mayor que la cabeza, se convierte en la nueva cabeza
        if (head_front.priority < priority) {
            newNode.next = head_front;
            head_front = newNode;
        } else {
            Node<T> current = head_front;

            // Busca el lugar correcto en la cola y añade el nodo
            while (current.next != null && current.next.priority >= priority) {
                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;

            // Si el nodo se añade al final de la cola, actualizar la cola
            if (current == tail_rear) {
                tail_rear = newNode;
            }
        }
    }


    // -----  ------  -----  ------  -----  ------  -----  ------  -----  ------  -----  ------
    //aca arranca el main

    public static void main(String[] args){
        Queue<Integer> cola = new Queue<>();

        System.out.println("mi cola esta vacia? "+cola.isEmpty());

        cola.enqueue(1);
        cola.enqueue(2);
        cola.enqueue(3);
        cola.imprimir();
        System.out.println();
        //comentario aver si se sube al repo


        cola.dequeue();
        System.out.print("dsp de hacer dequeue: ");
        cola.imprimir();


        System.out.println("mi cola esta vacia? "+cola.isEmpty());


    }
}

