package com.example.hibernate.repository;

import com.example.hibernate.model.Animal;
import com.example.hibernate.model.Cat;
import com.example.hibernate.model.Dog;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackageClasses = AnimalRepository.class)
@EntityScan(basePackageClasses = { Animal.class, Cat.class, Dog.class })
public class AnimalRepositoryTestConfiguration {

}
