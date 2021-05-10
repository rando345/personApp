package com.example.personapp.controllers;

import com.example.personapp.models.PersonEntry;
import com.example.personapp.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8888")
@Controller
@RestController
public class PersonEntryController {
    @Autowired
    PersonService personService;

    //POST - to create a person in the DB
    @PostMapping(value = "/person")
    public ResponseEntity<PersonEntry> createPerson(@RequestBody PersonEntry person, BindingResult result) {
        return personService.registerPerson(person, result);
    }

    //GET - to get all the entries from the DB
    @GetMapping(value = "/person/all")
    public ResponseEntity<List<PersonEntry>> getAllPersons() {
        List<PersonEntry> allPersons = personService.getAllPersons();
        return new ResponseEntity<>(allPersons, new HttpHeaders(), HttpStatus.OK);
    }

    //GET - to get all the entries with provided search term
    @GetMapping(value = "/person")
    @ResponseBody
    public ResponseEntity<List<PersonEntry>> getAllSearchResults(@RequestParam(name = "search") String term) {
        List<PersonEntry> allResults = personService.getAllSearchResults(term);
        return new ResponseEntity<>(allResults, new HttpHeaders(), HttpStatus.OK);
    }
}
