package mmmbop.todoDB.repository;

import mmmbop.todoDB.model.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ToDoRepository {

    private JpaToDoRepository repo;

    @Autowired
    public ToDoRepository(JpaToDoRepository repo) {
        this.repo = repo;
    }

    public ToDo saveToDo(ToDo toDo) {
        return repo.save(toDo);
    }

    public List<ToDo> getAll() {
        return repo.findAll();
    }

    public ToDo findById(Long id) {
        return repo.findById(id);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    public void deleteAll() {
        repo.deleteAll();
    }
}
