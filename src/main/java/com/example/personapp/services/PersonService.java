package com.example.personapp.services;

import com.example.personapp.models.PersonEntry;
import com.example.personapp.models.PersonEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonEntryRepository personEntryRepository;

    //service to create DB entry for Person
    public ResponseEntity<PersonEntry> registerPerson(PersonEntry person, BindingResult result) {
        if (result.hasErrors()) {
            return  ResponseEntity.badRequest().build();
        }
        personEntryRepository.save(person);
        return new ResponseEntity (person, new HttpHeaders(), HttpStatus.CREATED);
    }

    //service to get all persons from DB
    public List<PersonEntry> getAllPersons() {
        List<PersonEntry> persons = personEntryRepository.findAll();
        //basic check to see if there were any results
        if (persons == null) {
            return Collections.emptyList();
        }
        return persons;
    }

    public List<PersonEntry> getAllSearchResults(String term) {
        List<PersonEntry> persons = personEntryRepository.findAll();
        List<PersonEntry> results = new ArrayList<>();
        //basic check to see if there were any results
        if (persons == null) {
            return Collections.emptyList();
        }
        //FOR-loop to go though all DB entries and filter based on the term
        for (PersonEntry person : persons){
            //make all lower case while comparing entry with term
            if (person.getPerson().toLowerCase().contains(term.toLowerCase())){
                results.add(person);
            }
        }
        return results;
    }
}
