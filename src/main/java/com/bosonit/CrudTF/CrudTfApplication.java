package com.bosonit.CrudTF;

import com.bosonit.CrudTF.domain.Student;
import com.bosonit.CrudTF.repository.StudentRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudTfApplication implements CommandLineRunner {
	@Autowired
	Faker faker;
	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(CrudTfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for(int i = 0; i < 3; i++) {
			Student student = new Student();
			student.setFirstName(faker.name().firstName());
			student.setLastName(faker.name().lastName());
			student.setEmail(faker.internet().emailAddress());
			studentRepository.save(student);
		}
	}
}
