package br.pucrs.engswii.studentService.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import br.pucrs.engswii.studentService.entity.Student;
public interface StudentJpaItfRep extends CrudRepository<Student,String> {
    List<Student> findAll();
}