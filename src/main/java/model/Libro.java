package model;

public class Libro {

    int id;

    String title;

    String author;

    int firstEdition;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getFirstEdition() {
        return firstEdition;
    }

    public void setFirstEdition(int firstEdition) {
        this.firstEdition = firstEdition;
    }

    public Libro() {
    }

    public Libro(String title, String author, int firstEdition) {
        this.title = title;
        this.author = author;
        this.firstEdition = firstEdition;
    }

    @Override
    public String toString() {

        return "Libro{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", firstEdition=" + firstEdition +
                '}';

    }

}
