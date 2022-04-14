package com.example.pokemon;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PokemonController {

    @Autowired
    PokemonRepository repository;

    @GetMapping("/pokemon/welcome")
    public String welcome() {
        return "Welcome to the World of Pokemon! ";
    }

    @GetMapping("/pokemon")
    public ResponseEntity<List<Pokemon>> getPokemons() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @PostMapping("/pokemon")
    public ResponseEntity<String> createPokemon(@RequestBody Pokemon pokemon) {
        repository.save(pokemon);
        return ResponseEntity.status(HttpStatus.CREATED).body("Pokemon added");
    }

    @DeleteMapping("/pokemon/{id}")
    public ResponseEntity <String> deletePokemon(@PathVariable int id) {
        try {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Greeting with id of: " + id + " was deleted");
        } catch (
                EmptyResultDataAccessException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Greeting with the id of :" + id + "doesn't exist, can't delete!");
        }
    }
}

//        boolean isDeleted = pokemons.removeIf(pokemon -> pokemon.getId() == id);
//        if(isDeleted){
//            return "Pokemon with id " + id + " was deleted";
//        }
//        return "Pokemon not found, can't delete";

