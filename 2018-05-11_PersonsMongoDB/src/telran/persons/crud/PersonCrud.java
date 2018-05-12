package telran.persons.crud;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import telran.persons.dto.Person;

@Document (collection = "persons")
public class PersonCrud {
	

	@Id
	private int id;
	private String name;
	private LocalDate birthdate;
	
	public PersonCrud(Person person) {
		id = person.getId();
		name = person.getName();
		birthdate = person.getBirthdate();
	}
	
	public PersonCrud() {
	}

	public int getId() {
		return id;
	}

	public PersonCrud(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}
	
	public Person getPerson () {
		return new Person(id, name, birthdate);
	}

	public void setName(String name) {
		this.name = name;
	}
}
