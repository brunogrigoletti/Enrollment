package br.pucrs.engswii.persistance.subjects;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import br.pucrs.engswii.beans.Subject;

public interface SubjectJpaItfRep extends CrudRepository<Subject,String> {
    List<Subject> findAll();
}