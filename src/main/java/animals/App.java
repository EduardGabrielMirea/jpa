package animals;

import animals.entity.Animal;
import animals.repository.TypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import animals.repository.AnimalRepository;

@SpringBootApplication
public class App implements CommandLineRunner {
    private final AnimalRepository animalRepository;
    private final TypeRepository typeRepository;
    public App(AnimalRepository animalRepository, TypeRepository typeRepository){
        this.animalRepository = animalRepository;
        this.typeRepository = typeRepository;
    }
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) {
        animalRepository.findAnimalsByNameAndColor("Perro", "Blanco").forEach(System.out::println);

        /*Animal animal = new Animal("Pájaro", "Verde");
        animalRepository.save(animal);
*/
        Animal p = animalRepository.findById(2L).get();
        System.out.println("*********************************");
        System.out.println(p.getType().getName());


        typeRepository.findById(2L).get().getAnimals().forEach(System.out::println);

        System.out.println("*********************************");

    }
}

