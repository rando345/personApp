package com.example.personapp.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonEntryRepository extends JpaRepository<PersonEntry, Long> {}

