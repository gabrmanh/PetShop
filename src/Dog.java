import java.util.Objects;

public class Dog {
    private final String name;
    private final String race;
    private boolean vacinado = false;

    public Dog(String name, String race) {
        this.name = name;
        this.race = race;
    }

    public void takeVaccine(){
        vacinado = true;
    }
    public void expireVax(){
        vacinado = false;
    }

    public boolean isVacinado() {
        return vacinado;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s da raça %s: %s", name, race, vacinado ? "Vacinado" : "Sem vacina");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(name, dog.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
