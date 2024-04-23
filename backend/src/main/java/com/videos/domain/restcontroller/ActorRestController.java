package com.videos.domain.restcontroller;

import com.videos.domain.Entity.Actor;
import com.videos.domain.dao.ActorDAO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/actors")
public class ActorRestController {

    private final ActorDAO actorDAO;

    @GetMapping
    public ResponseEntity<List<Actor>> getAllActors(){
        List<Actor> allActors = actorDAO.findAll();
        return ResponseEntity.ok(allActors);
    }
    @GetMapping("/{id")
    public ResponseEntity<Optional<Actor>> getActorsById(@PathVariable int id){
        Optional<Actor> actor = actorDAO.findById(id);
        return ResponseEntity.ok(actor);
    }
    @PostMapping
    public ResponseEntity<Actor> addNewActor(@RequestBody Actor actor){
        Actor newActor = actorDAO.save(actor);
        return ResponseEntity.status(HttpStatus.CREATED).body(newActor);
    }
}
