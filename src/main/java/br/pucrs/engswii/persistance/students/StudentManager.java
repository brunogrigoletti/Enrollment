package br.pucrs.engswii.persistance.students;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import br.pucrs.engswii.beans.Student;

@Repository
@Primary
public class StudentManager implements StudentRepository {
	private static StudentJpaItfRep repository;

    @Autowired
    public StudentManager(StudentJpaItfRep repository) {
        this.repository = repository;
    }

	@Override
	public void add(Student std) {
		Random random = new Random();
        int regNum = 10000 + random.nextInt(90000);
		std.setRegistrationNumber(String.valueOf(regNum));
		repository.save(std);
	}

	@Override
	public String updateStudent(Student std) {
		List<Student> stds = repository.findAll();
		for(int i=0; i<stds.size(); i++)
		{
			Student stdn = stds.get(i);
			if(stdn.getRegistrationNumber().equals(std.getRegistrationNumber())) {
				stds.set(i, std);
				return "Update successful";
			}
		}
		return "Update un-successful";
	}

	@Override
	public String deleteStudent(String registrationNumber) {
		List<Student> stds = repository.findAll();
		for(int i=0; i<stds.size(); i++)
		{
			Student stdn = stds.get(i);
			if(stdn.getRegistrationNumber().equals(registrationNumber)){
				stds.remove(i);
				return "Delete successful";
			}
		}
		return "Delete un-successful";
	}

	@Override
	public List<Student> getStudents() {
		List<Student> stds = repository.findAll();
        if (stds.size() == 0) {
            return new ArrayList<Student>();
        }
        else {
            return stds.stream().toList();
        }
	}

	@Override
	public Student getStudentId(String regNum) {
		List<Student> stds = repository.findAll();
		for (Student s : stds) {
			if (s.getRegistrationNumber().equalsIgnoreCase(regNum)) {
				return s;
			}
		}
		return null;
	}

	@Override
	public List<Student> getStudentNamePart(String namePart) {
		List<Student> stds = repository.findAll();
		List<Student> matchingStudents = new ArrayList<>();
		for (Student s : stds) {
			if (s.getName().toLowerCase().contains(namePart)) {
				matchingStudents.add(s);
			}
		}
		return matchingStudents;
	}
}