package br.pucrs.engswii.persistance.students;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import br.pucrs.engswii.beans.Student;

public interface StudentJpaItfRep extends CrudRepository<Student,String> {
    List<Student> findAll();
    //Student findById(String id);
    void delete(Student std);
    void deleteById(String id);
    boolean existsById(String id);
}