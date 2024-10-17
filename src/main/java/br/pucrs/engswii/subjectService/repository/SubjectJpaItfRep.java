package br.pucrs.engswii.subjectService.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import br.pucrs.engswii.subjectService.entity.Subject;

public interface SubjectJpaItfRep extends CrudRepository<Subject,String> {
    List<Subject> findAll();
}