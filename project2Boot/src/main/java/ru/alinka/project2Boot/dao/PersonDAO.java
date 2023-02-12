package ru.alinka.project2Boot.dao;

import org.springframework.stereotype.Component;

@Component
public class PersonDAO {
    /*
    private final SessionFactory sessionFactory;

    @Autowired
    public PersonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Person> index() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select p from Person p", Person.class)
                .getResultList();

    }

    @Transactional(readOnly = true)
    public Person show(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Person.class, id);
    }

    @Transactional
    public void save(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.save(person);
    }

    @Transactional
    public void update(int id, Person updatePerson) {
        Session session = sessionFactory.getCurrentSession();

        Person person = session.get(Person.class, id);

        person.setName(updatePerson.getName());
        person.setYearOfBirth(updatePerson.getYearOfBirth());
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Person person = session.get(Person.class, id);
        session.remove(person);
    }

    /*
    // Для валидации уникальности ФИО
    public Optional<Person> getPersonByFullName(String fullName) {
        return jdbcTemplate.query("SELECT * FROM Human WHERE name=?", new Object[]{fullName},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    // Здесь Join не нужен. И так уже получили человека с помощью отдельного метода
    public List<Book> getBooksByPersonId(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE id_human = ?", new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class));
    }

     */
}
