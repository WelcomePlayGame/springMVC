package ua.vadym.course.dao;

import org.springframework.stereotype.Component;
import ua.vadym.course.models.Persone;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersoneDAO {

    private static  int PEOPLE_COUNT;
    private List<Persone> people;

    {
        people = new ArrayList<>();
        people.add(new Persone(++PEOPLE_COUNT, "Ivan"));
        people.add(new Persone(++PEOPLE_COUNT, "bob"));
        people.add(new Persone(++PEOPLE_COUNT, "Tom"));
        people.add(new Persone(++PEOPLE_COUNT,  "Mike"));
    }


    public List<Persone> getPeople() {
        return people;
    }

    public Persone getPersone(int id) {

        return people.stream()
                .filter(persone -> persone.getId() == id)
                .findAny()
                .orElse(null);
    }
}
