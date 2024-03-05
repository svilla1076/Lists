class SLNode {
    Book book;
    SLNode next;

    public SLNode(Book book) {
        this.book = book;
        this.next = null;
    }
}

class SLList {
    private SLNode head;

    public SLList() {
        head = null;
    }

    public void listAdd(Book p) {
        SLNode newNode = new SLNode(p);
        if (head == null) {
            head = newNode;
            return;
        }
        SLNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void listRemove(int pos) {
        if (pos < 0 || head == null) {
            throw new IndexOutOfBoundsException("Invalid position or empty list");
        }
        if (pos == 0) {
            head = head.next;
            return;
        }
        SLNode current = head;
        for (int i = 0; i < pos - 1; i++) {
            if (current == null) {
                throw new IndexOutOfBoundsException("Invalid position");
            }
            current = current.next;
        }
        if (current == null || current.next == null) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        current.next = current.next.next;
    }

    public String toString() {
        if (head == null) {
            return "Empty List";
        }
        StringBuilder result = new StringBuilder();
        SLNode current = head;
        while (current != null) {
            result.append(current.book).append("\n");
            current = current.next;
        }
        return result.toString();
    }
}