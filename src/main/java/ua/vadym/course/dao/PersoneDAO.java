package ua.vadym.course.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ua.vadym.course.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class PersoneDAO {

    JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public PersoneDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Person> getPeople() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person getPersone(int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[] {id}, new BeanPropertyRowMapper<>(Person.class))
                .stream()
                .findAny()
                .orElse(null);
    }


    public void save(Person person) {
    jdbcTemplate.update("INSERT INTO Person VALUES (1, ?, ?, ?)", person.getName(), person.getAge(), person.getEmail());
    }
}
