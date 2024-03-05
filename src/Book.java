class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String toString() {
        return "{title: " + title + ", author: " + author + ", price: " + price + "}";
    }
}