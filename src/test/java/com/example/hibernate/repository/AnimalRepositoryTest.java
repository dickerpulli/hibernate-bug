package com.example.hibernate.repository;

import com.example.hibernate.model.Animal;
import com.example.hibernate.model.Cat;
import com.example.hibernate.model.CatToys;
import com.example.hibernate.model.Dog;
import com.example.hibernate.model.DogToys;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

@DataJpaTest
@ContextConfiguration(classes = AnimalRepositoryTestConfiguration.class)
class AnimalRepositoryTest implements WithAssertions {

    @Autowired
    private AnimalRepository repository;

    @Test
    void shouldReadOnlyACat() {
        var cat = new Cat();
        var catToys = new CatToys();
        catToys.setCountOfBallsOfWool(12);
        catToys.setIncludesLaserPointer(true);
        cat.setToys(catToys);
        cat = repository.save(cat);

        var all = repository.findAll();

        assertThat(all).hasSize(1);
        assertThat(all).extracting(Animal::getId).contains(cat.getId());
    }

    @Test
    void shouldReadOnlyADog() {
        var dog = new Dog();
        var dogToys = new DogToys();
        dogToys.setIncludesRubberDuck(true);
        dogToys.setCountOfBones(7);
        dog.setToys(dogToys);
        dog = repository.save(dog);

        var all = repository.findAll();

        assertThat(all).hasSize(1);
        assertThat(all).extracting(Animal::getId).contains(dog.getId());
    }

}