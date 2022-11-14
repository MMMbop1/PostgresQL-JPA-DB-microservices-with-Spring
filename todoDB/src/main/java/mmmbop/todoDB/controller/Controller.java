package mmmbop.todoDB.controller;

import mmmbop.todoDB.model.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class Controller {

    ToDoService toDoService;

    @Autowired
    public Controller(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ToDo> saveToDo(@RequestBody ToDoDTO toDoDTO) {

        ToDo toDo = toDoService.saveToDo(new ToDo(toDoDTO.id(), toDoDTO.title(), toDoDTO.description()));

        return ResponseEntity.accepted().body(toDo);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ToDo>> getAll() {
        List<ToDo> listToDo = toDoService.getAll();

        return ResponseEntity.ok().body(listToDo);
    }

    @GetMapping(value = "/:{todoid}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ToDo> getToDoByID(@PathVariable(value = "todoid") Long id) {

        ToDo toDo = toDoService.findById(id);

        if (toDo == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.accepted().body(toDo);
    }

    @DeleteMapping(value = "/:{todoid}")
    ResponseEntity<?> deleteById(@PathVariable(value = "todoid") Long id) {

        toDoService.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping()
    ResponseEntity<?> deleteAll() {

        toDoService.deleteAll();

        return ResponseEntity.noContent().build();
    }
}
