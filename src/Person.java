import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Person {
    private String name;
    private String cpf;
    private List<Dog> dogs = new ArrayList<>();

    public Person(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public void adopt(Dog dog){
        Objects.requireNonNull(dog);
        dogs.add(dog);
    }

    public void adopt(String dogName, String race){
        if(containsDog(dogName))
            throw new IllegalArgumentException("Cannot have a dog with the same name");
        dogs.add(new Dog(dogName, race));
    }

    public void giveAway(Dog dog){
        Objects.requireNonNull(dog, "Dog may not be null.");
        giveAway(dog.getName());
    }

    public void giveAway(String dogName){
        final boolean removed = dogs.removeIf(dog -> dog.getName().equals(dogName));
        if(!removed)throw new NoSuchElementException("No such name.");
    }

    public void vaccinate(String dogName){
        dogs.stream().
                filter(dog -> dogName.equals(dog.getName())).
                findFirst().
                ifPresent(Dog::takeVaccine);
    }

    public void listDogs(){
        dogs.forEach(System.out::println);
    }

    public void listVaccinated(boolean vaccinated){
        dogs.stream().filter(dog -> dog.isVacinado() == vaccinated)
                .forEach(System.out::println);
    }

    public boolean containsDog(String dogName){
        return dogs.stream().
                anyMatch(dog -> dogName.equals(dog.getName()));
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(cpf, person.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}
