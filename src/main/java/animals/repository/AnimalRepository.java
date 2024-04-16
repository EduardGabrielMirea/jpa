package animals.repository;

import org.springframework.data.repository.CrudRepository;
import animals.entity.Animal;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AnimalRepository extends CrudRepository<Animal, Long> {
    List<Animal> findAnimalsByNameContains(String name);
    List<Animal> findAnimalsByNameStartingWith(String name);

    List<Animal> findAnimalsByNameAndColor(String name, String c);

    List<Animal> findAnimalsByNameStartingWithAndColorContains(String name, String c);
}