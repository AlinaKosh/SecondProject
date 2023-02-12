package ru.alinka.project2Boot.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name = "human")
public class Person {
    @Id
    @Column(name = "id_human")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    @Size(min = 3, max = 30, message = "Name should be between 3 and 30")
    private String name;
    @Column(name = "year_of_birth")
    @Min(value = 1900, message = "Year of birth must be indicated")
    private int yearOfBirth;
    @OneToMany(mappedBy = "person")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Book> books;

    public Person(String name, int year_of_birth) {
        this.name = name;
        this.yearOfBirth = year_of_birth;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }
}
