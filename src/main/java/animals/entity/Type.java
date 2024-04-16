package animals.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Type {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Type(){

    }
    @OneToMany(mappedBy = "type", fetch=FetchType.EAGER)
    private List<Animal> animals;
    public Type(Long id, String name) {
        this.id = id;
        this.name = name;
        this.animals = new ArrayList<>();
    }

    public Type(String name) {
        this.name = name;
        this.animals = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
