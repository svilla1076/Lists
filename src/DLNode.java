class DLNode {
    Book book;
    DLNode next;
    DLNode prev;

    public DLNode(Book book) {
        this.book = book;
        this.next = null;
        this.prev = null;
    }
}

class DLList {
    private DLNode head;

    public DLList() {
        head = null;
    }

    public void listAdd(Book p) {
        DLNode newNode = new DLNode(p);
        if (head == null) {
            head = newNode;
            return;
        }
        DLNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        newNode.prev = current;
    }

    public void listRemove(int pos) {
        if (pos < 0 || head == null) {
            throw new IndexOutOfBoundsException("Invalid position or empty list");
        }
        if (pos == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }
        DLNode current = head;
        for (int i = 0; i < pos; i++) {
            if (current == null) {
                throw new IndexOutOfBoundsException("Invalid position");
            }
            current = current.next;
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        }
        current.prev.next = current.next;
    }

    public String toString() {
        if (head == null) {
            return "Empty List";
        }
        StringBuilder result = new StringBuilder();
        DLNode current = head;
        while (current != null) {
            result.append(current.book).append("\n");
            current = current.next;
        }
        return result.toString();
    }
}