public class List<E extends Comparable<E>> implements ListInterface<E> {

    private Node head;
    private Node tail;
    private Node current;
    private int size;

    private class Node {

        E data;
        Node prior, next;

        public Node(E d) {
            this(d, null, null);
        }

        public Node(E data, Node prior, Node next) {
            this.data = data == null ? null : data;
            this.prior = prior;
            this.next = next;
        }

    }

    public boolean isEmpty() {
        return head == null;
    }

    public ListInterface<E> init() {
        head = null;
        tail = null;
        current = null;
        size = 0;

        return copy();
    }

    public int size() {
        return size;
    }

    public ListInterface<E> insert(E d) {
        Node newNode = new Node(d);

        if (isEmpty()) {                             //first element
          head = newNode;
          tail = newNode;
          current = newNode;
        } else if (d.compareTo(head.data) < 0) {     //insert before first element (new head)
          head.prior = newNode;
          newNode.next = head;
          head = newNode;
          current = newNode;
        } else if (d.compareTo(tail.data) > 0) {     //insert after last element (new tail)
          tail.next = newNode;
          newNode.prior = tail;
          tail = newNode;
          current = newNode;
        } else {                                      //insert somewhere in the middle
          Node after = head;
          Node before;

          while (after != null) {                     //find position
            if (d.compareTo(after.data) < 0) {
              before = after.prior;

              before.next = newNode;
              after.prior =newNode;

              newNode.prior = before;
              newNode.next = after;

              current = newNode;

              break;
            }
            after = after.next;
          }
        }
        size++;
        return copy();
    }

    public E retrieve() /*throws APException*/ {
        // if (isEmpty()) {
        //   throw new APException("Data cannot be retrieved, list is empty");
        // }
        return current.data;
    }

    public ListInterface<E> remove() /*throws APException*/ {
        // if (isEmpty()) {
        //   throw new APException("Element cannot be removed, list is empty");
        // }

        if (head.next == null) {                     //last element
          current = null;
          head = null;
          tail = null;
        } else if (current == head) {                //head
          current = current.next;
          current.prior = null;
          head = current;
        } else if (current == tail) {                //tail
          current = current.prior;
          current.next = null;
          tail = current;
        } else {                                     //in the middle
          Node before = current.prior;
          Node after = current.next;

          before.next = after;
          after.prior = before;
          current = after;
        }
        size--;

        return copy();
    }

    public boolean find(E d) {
        Node element = new Node(d);
        Node find = head;

        while (find != null) {
          if (d.compareTo(find.data) == 0) {
            current = find;
            return true;
          }
          find = find.next;
        }
        if (isEmpty()) {
          current = null;
        } else if (d.compareTo(head.data) < 0) {
          current = head;
        } else {
          find = head;
          while(find != null) {
            if (d.compareTo(find.data) > 0) {
              current = find;
            }
            find = find.next;
          }
        }
        return false;
    }

    public boolean goToFirst() {
        if(isEmpty()) {
          return false;
        }
        current = head;
        return true;
    }

    public boolean goToLast() {
        if (isEmpty()) {
          return false;
        }
        current = tail;
        return true;
    }

    public boolean goToNext() {
        if (isEmpty() || current.next == null) {
          return false;
        }
        current = current.next;
        return true;
    }

    public boolean goToPrevious() {
        if (isEmpty() || current.prior == null){
          return false;
        }
        current = current.prior;
        return true;
    }

    public ListInterface<E> copy() {
        List<E> tmp = new List<E>();

        tmp.head = head;
        tmp.current = current;
        tmp.tail = tail;
        tmp.size = size;

        return tmp;
    }
}
