package Jibun.CRUD.services;

import Jibun.CRUD.dao.PersonDAO;
import Jibun.CRUD.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class PersonServiceImpl implements PersonService {

    private final PersonDAO personDAO;

    @Autowired
    public PersonServiceImpl(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public List<Person> findAll() {
        return personDAO.index();
    }

    @Override
    public Person findById(int id) {
        return personDAO.show(id);
    }

    @Override
    @Transactional
    public void save(Person person) {
        personDAO.save(person);
    }

    @Override
    @Transactional
    public void update(int id, Person person) {
        personDAO.update(id, person);
    }

    @Override
    @Transactional
    public void delete(int id) {
        personDAO.delete(id);
    }
}