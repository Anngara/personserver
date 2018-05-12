package telran.persons.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.persons.crud.PersonCrud;
import telran.persons.dto.Person;
import telran.persons.mongo.repo.PersonsMongoRepository;

@Service
public class PersonMongoDao implements IpersonsDao {
	@Autowired
	PersonsMongoRepository  repository;
	
	@Override
	public boolean addPerson(Person person) {
		if (repository.existsById(person.getId())) {
		return false;
		}else {
			repository.save(new PersonCrud(person));
		return true;
		}
		
	}

	@Override
	public Person getPerson(int id) {
		return repository.findById(id).get().getPerson();
	}

	//re-write
	@Override
	 public boolean updateName(int id, String newName) {
		
		
		
	  PersonCrud person = repository.findById(id).orElse(null);
	  if (person == null)
	   return false;
	  person.setName(newName);
	  repository.save(person);
	  return true;
	 }
	//re-write
	 @Override
	 public boolean removePerson(int id) {
	  if (!repository.existsById(id))
	   return false;
	  repository.deleteById(id);
	  return true;
	 }

}
