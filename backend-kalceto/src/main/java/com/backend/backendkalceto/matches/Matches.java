package com.backend.backendkalceto.matches;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Matches {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    public Matches() {}
}
