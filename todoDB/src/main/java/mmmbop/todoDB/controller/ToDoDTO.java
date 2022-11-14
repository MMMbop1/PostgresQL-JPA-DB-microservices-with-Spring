package mmmbop.todoDB.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record ToDoDTO(@JsonProperty Long id, @JsonProperty String title, @JsonProperty String description) {
}
