package Jibun.CRUD.dao;

import Jibun.CRUD.models.Person;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PersonDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> index() {
        return entityManager.createQuery("SELECT p FROM Person p", Person.class).getResultList();
    }

    public Person show(int id) {
        return entityManager.find(Person.class, id);
    }

    public void save(Person person) {
        entityManager.persist(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToUpdate = show(id);
        if (personToUpdate != null) {
            personToUpdate.setName(updatedPerson.getName());
            entityManager.merge(personToUpdate);
        }
    }

    public void delete(int id) {
        Person person = show(id);
        if (person != null) {
            entityManager.remove(person);
        }
    }
}