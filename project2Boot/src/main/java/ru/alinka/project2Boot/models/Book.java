package ru.alinka.project2Boot.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;


import java.util.Date;

@Entity
@Table(name = "Book")
public class Book {
    @Id
    @Column(name = "id_book")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min = 2, max = 40, message = "Title should be between 2 and 40 characters")
    @Column(name = "title")
    private String title;
    @Column(name = "name_author")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String nameAuthor;
    @Column(name = "year_realise")
    private int yearRealise;
    @ManyToOne
    @JoinColumn(name = "id_human", referencedColumnName = "id_human")
    private Person person;
    @Column(name = "taken_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date takenAt;
    @Transient
    private boolean expired;

    public Book(String title, String nameAuthor, int yearRealise) {
        this.title = title;
        this.nameAuthor = nameAuthor;
        this.yearRealise = yearRealise;
    }

    public Book() {
    }

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

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public int getYearRealise() {
        return yearRealise;
    }

    public void setYearRealise(int yearRealise) {
        this.yearRealise = yearRealise;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Date getTakenAt() {
        return takenAt;
    }

    public void setTakenAt(Date takenAt) {
        this.takenAt = takenAt;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", nameAuthor='" + nameAuthor + '\'' +
                ", yearRealise=" + yearRealise +
                ", person=" + person +
                '}';
    }
}
