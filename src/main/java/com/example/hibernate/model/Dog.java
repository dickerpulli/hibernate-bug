package com.example.hibernate.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Getter
@Setter
public class Dog extends Animal {

    private boolean barks;

    @JdbcTypeCode(SqlTypes.JSON)
    private DogToys toys;

}
