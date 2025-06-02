package Jibun.CRUD.services;

import Jibun.CRUD.models.Person;
import java.util.List;

public interface PersonService {
    List<Person> findAll();
    Person findById(int id);
    void save(Person person);
    void update(int id, Person person);
    void delete(int id);
}