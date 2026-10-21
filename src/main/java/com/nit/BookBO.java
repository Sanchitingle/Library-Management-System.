package com.nit;

public class BookBO {

    private int bookId;
    private String bookName;
    private String author;
    private double price;

    public BookBO() {
        super();
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookBO [bookId=" + bookId
                + ", bookName=" + bookName
                + ", author=" + author
                + ", price=" + price + "]";
    }
}