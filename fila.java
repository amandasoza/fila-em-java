// Classe que representa um nó da fila
class Node {
    int data;
    Node next;
}

// Classe principal com a lógica da fila
public class fila {
    Node front;
    Node rear;

    // Inicializa a fila
    public void create() {
        front = null;
        rear = null;
    }

    // Adiciona um elemento ao final da fila
    public void enqueue(int value) {
        Node newNode = new Node();
        newNode.data = value;
        newNode.next = null;

        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    // Remove o primeiro elemento da fila
    public int dequeue() {
        if (front == null) {
            System.out.println("Fila Vazia!!!");
            return -1;
        }

        int value = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return value;
    }

    // Verifica se a fila está vazia
    public boolean isEmpty() {
        return front == null;
    }

    // Remove todos os elementos da fila
    public void destroy() {
        while (!isEmpty()) {
            dequeue();
        }
    }

    // Exibe os elementos da fila
    public int display() {
        if (isEmpty()) {
            System.out.println("Fila Vazia!!!");
            return -1;
        }

        Node temp = front;
        System.out.print("Elementos da Fila: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
        return 0;
    }

    // Método main para testar a fila
    public static void main(String[] args) {
        fila fila = new fila();
        fila.create();

        // Inserir elementos
        fila.enqueue(10);
        fila.enqueue(20);
        fila.enqueue(30);

        fila.display();

        System.out.println("Elemento removido (dequeue): " + fila.dequeue());
        fila.display();

        System.out.println("Elemento removido (dequeue): " + fila.dequeue());
        fila.display();

        fila.destroy();

        if (fila.isEmpty()) {
            System.out.println("Fila destruída com sucesso");
        }

        fila.display();
    }
}
