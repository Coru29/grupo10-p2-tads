public class Queue<T extends Comparable<T>> implements MyQueue<T>{

    public Node <T> tail_rear;
    public Node <T> head_front;

    @Override
    public void enqueue(T element) {
        Node<T> nuevoNodeo = new Node<>();
        nuevoNodeo.data = element;
        nuevoNodeo.next = null;

        if(head_front == null & tail_rear == null){
            head_front = tail_rear = nuevoNodeo;
            return;
        }

        tail_rear.next = nuevoNodeo;
        tail_rear= nuevoNodeo;

    }

    @Override
    public void dequeue() {

        if (head_front == null) return; //en el caso de q la cola este vacia

        if(head_front == tail_rear){ //en el caso que solo haya un elemento
            head_front = tail_rear = null;

        }else head_front = head_front.next;


    }

    @Override
    public boolean isEmpty() {
        return (head_front == null || tail_rear == null);
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

