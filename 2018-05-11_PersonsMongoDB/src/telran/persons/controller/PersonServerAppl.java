package telran.persons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.*;

import telran.persons.dao.*;
import telran.persons.dto.*;

@SpringBootApplication // work with
@ComponentScan(basePackages = "telran.persons.dao") // where service
@EnableMongoRepositories("telran.persons.mongo.repo")
@RestController
public class PersonServerAppl {
	@Autowired //it's - don't need do NEW
	IpersonsDao persons;

	
		@PostMapping (value = PersonsApiConstants.ADD_PERSON)
	boolean addPerson (@RequestBody Person person) {
		return persons.addPerson(person);
	}
	
	@PostMapping (value = PersonsApiConstants.REMOVE_PERSON)
	boolean removePerson (@RequestBody int id) {
		return persons.removePerson(id);
	}

	@PostMapping (value = PersonsApiConstants.GET_PERSON)
	Person getPersons (@RequestBody int id) {
		return persons.getPerson(id);
	}
	
	@PostMapping (value = PersonsApiConstants.UPDATE_NAME)
	boolean updateName (@RequestBody Person person) {
		return persons.updateName(person.getId(), person.getName());
	}
	
	public static void main(String[] args) {
		
		SpringApplication.run(PersonServerAppl.class, args);
		
	}

	
	

}
