/**
 * clasa implementeaza o lista inlantuita circulara
 **/
public class CircularLinkedList {
    private Node head = null;
    private Node tail = null;

    /**
     * Metoda adauga un nod nou cu valoare value la sfarsitul listei
     * @param value valoare noului element din lista
     */
    public void addNode(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            tail.nextNode = newNode;
        }

        tail = newNode;
        tail.nextNode = head;
    }

    /**
     * metoda verifica daca o valoare se afla in lista
     * @param searchValue valoarea cautata
     * @return true daca valoare este gasita, altfel false
     */
    public boolean containsNode(int searchValue) {
        Node currentNode = head;

        if (head == null) {
            return false;
        } else {
            do {
                if (currentNode.value == searchValue) {
                    return true;
                }
                currentNode = currentNode.nextNode;
            } while (currentNode != head);
            return false;
        }
    }

    /**
     * Metoda sterge toate elementele cu o valoare anume din lista
     * @param valueToDelete valoarea care trebuie stearsa
     */
    public void deleteNode(int valueToDelete) {
        Node currentNode = head;
        if (head == null) {
            return;
        }
        do {
            Node nextNode = currentNode.nextNode;
            if (nextNode.value == valueToDelete) {
                if (tail == head) {
                    head = null;
                    tail = null;
                } else {
                    currentNode.nextNode = nextNode.nextNode;
                    if (head == nextNode) {
                        head = head.nextNode;
                    }
                    if (tail == nextNode) {
                        tail = currentNode;
                    }
                }
                break;
            }
            currentNode = nextNode;
        } while (currentNode != head);
    }

    /**
     * method that returns next node, given a current node
     * @param currentNode the current node
     * @return next node
     */
    public Node getNextNode(Node currentNode) {
        return currentNode != null ? currentNode.nextNode : null;
    }

}