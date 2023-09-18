package model;

public class BookLocation {
    private String shelf;
    private String hall;
    private String section;

    public BookLocation(String shelf, String hall, String section) {
        this.shelf = shelf;
        this.hall = hall;
        this.section = section;
    }

    public String getShelf() {
        return shelf;
    }

    public void setShelf(String shelf) {
        this.shelf = shelf;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
