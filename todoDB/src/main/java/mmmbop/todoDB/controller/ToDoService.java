package mmmbop.todoDB.controller;

import mmmbop.todoDB.model.ToDo;
import mmmbop.todoDB.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    ToDoRepository repo;

    @Autowired
    public ToDoService(ToDoRepository repo) {
        this.repo = repo;
    }

    public ToDo saveToDo(ToDo toDo) {
        return repo.saveToDo(toDo);
    }

    public List<ToDo> getAll() {
        return repo.getAll();
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
