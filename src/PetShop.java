import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Objects;

public class PetShop {
    private final HashMap<String, Person> clients= new HashMap<>();

    public void addPerson(String cpf, String nome){
        Objects.requireNonNull(cpf);
        Objects.requireNonNull(nome);
        if(clients.containsKey(cpf)) throw new IllegalArgumentException("Cpf already registered");
        clients.put(cpf, new Person(nome, cpf));
    }

    public void addDog(String cpf, String dogName, String race){
        final Person person = clients.get(cpf);
        if (containsPerson(cpf))
            person.adopt(dogName, race);
        else throw new NoSuchElementException();
    }

    public void removePerson(String cpf){
        if(!containsPerson(cpf)) throw new NoSuchElementException("No such person in database");
        clients.remove(cpf);
    }

    public void removeCachorro(String cpf, String dogName){
        if(!containsPerson(cpf)) throw new NoSuchElementException("No such person in database");
        if(!personContainsDog(cpf, dogName)) throw new NoSuchElementException("No such dog in this person");
        clients.get(cpf).giveAway(dogName);
    }

    public boolean containsPerson(String cpf){
        return clients.containsKey(cpf);
    }

    public boolean personContainsDog(String cpf, String dogName){
        return clients.get(cpf).containsDog(dogName);
    }

    public void listPersons(){
        System.out.println("Lista de clientes:");
        clients.values().forEach(System.out::println);
    } // replace with :
    public HashMap<String, Person> getClients(){
        return new HashMap<>(clients);
    }

    public void listDogs(String cpf){
        if (containsPerson(cpf))
            clients.get(cpf).listDogs();
        else throw new NoSuchElementException();
    }

    public void listVaccinated(Boolean vaccinated, String cpf){
        if(containsPerson(cpf))
            clients.get(cpf).listVaccinated(vaccinated);
        else throw new NoSuchElementException();
    }
}
