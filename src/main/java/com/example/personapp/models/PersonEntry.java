package com.example.personapp.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class PersonEntry {
    @Id
    @GeneratedValue
    Long id;

    String person;
}