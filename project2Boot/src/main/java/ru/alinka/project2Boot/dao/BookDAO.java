package ru.alinka.project2Boot.dao;

import org.springframework.stereotype.Component;

@Component
public class BookDAO {

    /*
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM Book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE id_book=?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny().orElse(null);
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO Book(title, name_author, year_realise) VALUES(?, ?, ?)", book.getTitle(),
                book.getNameAuthor(), book.getYearRealise());
    }

    public void update(int id, Book updatedBook) {
        jdbcTemplate.update("UPDATE Book SET title=?, name_author=?, year_realise=? WHERE id=?", updatedBook.getTitle(),
                updatedBook.getNameAuthor(), updatedBook.getYearRealise(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Book WHERE id_book=?", id);
    }

    // Join'им таблицы Book и Person и получаем человека, которому принадлежит книга с указанным id
    public Optional<Person> getBookOwner(int id) {
        // Выбираем все колонки таблицы Person из объединенной таблицы
        return jdbcTemplate.query("SELECT Person.* FROM Book JOIN Person ON Book.id_human = Person.id_human " +
                        "WHERE Book.id_book = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny();
    }

    // Освбождает книгу (этот метод вызывается, когда человек возвращает книгу в библиотеку)
    public void release(int id) {
        jdbcTemplate.update("UPDATE Book SET id_human=NULL WHERE id_human=?", id);
    }

    // Назначает книгу человеку (этот метод вызывается, когда человек забирает книгу из библиотеки)
    public void assign(int id, Person selectedPerson) {
        jdbcTemplate.update("UPDATE Book SET id_human=? WHERE id_human=?", selectedPerson.getId(), id);
    }

     */
}
