import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pessoa {
    private String nome;
    private String cpf;
    private List<Cachorro> cachorros = new ArrayList<>();

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public void adopt(Cachorro cachorro){
        cachorros.add(cachorro);
    }

    public void adopt(String nomeCachorro, String raca){
        cachorros.add(new Cachorro(nomeCachorro, raca));
    }

    public void giveAway(Cachorro cachorro){
        cachorros.remove(cachorro);
    }

    public void giveAway(String nomeCachorro){
        cachorros.removeIf(cachorro -> cachorro.getNome().equals(nomeCachorro));
    }

    public void vaccinate(String nomeCachorro){
        cachorros.stream().
                filter(cachorro -> nomeCachorro.equals(cachorro.getNome())).
                findFirst().ifPresent(Cachorro::takeVaccine);
    }

    public void listCachorros(){
        cachorros.forEach(System.out::println);
    }

    public void listVacinados(boolean vaccinated){
        cachorros.stream().filter(cachorro -> cachorro.isVacinado() == vaccinated)
                .forEach(System.out::println);
    }

    public boolean containsCachorro(String nomeCachorro){
        return cachorros.stream().
                anyMatch(cachorro -> nomeCachorro.equals(cachorro.getNome()));
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(cpf, pessoa.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}
