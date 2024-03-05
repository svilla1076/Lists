class AList {
    private Book[] array;
    private int size;
    private static final int INITIAL_MAX_SIZE = 10;

    public AList() {
        array = new Book[INITIAL_MAX_SIZE];
        size = 0;
    }

    public void listAdd(Book p) {
        if (size >= array.length) {
            // Resize the array
            Book[] newArray = new Book[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[size++] = p;
    }

    public void listRemove(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        for (int i = pos; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }
    public String toString() {
        if (size == 0) {
            return "Empty List";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            result.append(array[i]).append("\n");
        }
        return result.toString();
    }
}