package ru.alinka.project2Boot.service;

import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alinka.project2Boot.models.Book;
import ru.alinka.project2Boot.models.Person;
import ru.alinka.project2Boot.repositories.BookRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BookService {


    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll(boolean sortByYear){
        if (sortByYear)
            return bookRepository.findAll(Sort.by("year"));
        else
            return bookRepository.findAll();
    }

    public Book findOne(int id){
        Optional<Book> book = bookRepository.findById(id);
        return book.orElse(null);
    }

    @Transactional
    public void save(@Valid Book book) {
        bookRepository.save(book);
    }

    @Transactional
    public void update(int id, Book updateBook){
        Book bookToBeUpdated = bookRepository.findById(id).get();

        // добавляем по сути новую книгу (которая не находится в Persistence context), поэтому нужен save()
        updateBook.setId(id);
        updateBook.setPerson(bookToBeUpdated.getPerson()); // чтобы не терялась связь при обновлении

        bookRepository.save(updateBook);
    }

    @Transactional
    public void delete(int id){
        bookRepository.deleteById(id);
    }

    public Person getPerson(int id){
        return bookRepository.findById(id).map(book -> book.getPerson()).orElse(null);
    }

    // Освбождает книгу (этот метод вызывается, когда человек возвращает книгу в библиотеку)
    @Transactional
    public void release(int id) {
        bookRepository.findById(id).ifPresent(
                book -> {
                    book.setPerson(null);
                    book.setTakenAt(null);
                });
    }

    // Назначает книгу человеку (этот метод вызывается, когда человек забирает книгу из библиотеки)
    @Transactional
    public void assign(int id, Person selectPerson){
        bookRepository.findById(id).ifPresent(book -> {
            book.setPerson(selectPerson);
            book.setTakenAt(new Date());
        });
    }

    public List<Book> searchByTitle(String title){
        return bookRepository.findByTitleStartingWith(title);
    }

    //Метод преднозначен для поиска книг
    public List<Book> findWithPagination(Integer page, Integer booksPerPage, boolean sortByYear) {
        if (sortByYear)
            return bookRepository.findAll(PageRequest.of(page, booksPerPage, Sort.by("year"))).getContent();
        else
            return bookRepository.findAll(PageRequest.of(page, booksPerPage)).getContent();
    }


}
