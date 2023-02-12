package ru.alinka.project2Boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alinka.project2Boot.models.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByTitleStartingWith(String titleBook);

}
