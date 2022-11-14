package mmmbop.todoDB.repository;

import mmmbop.todoDB.model.ToDo;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
public interface JpaToDoRepository extends CrudRepository<ToDo, String> {

    ToDo save(ToDo toDo);

    List<ToDo> findAll();
    ToDo findById(Long id);

    void deleteById(Long id);

    void deleteAll();

}
