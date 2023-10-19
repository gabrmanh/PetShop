import java.util.Objects;

public class Cachorro {
    private final String nome;
    private final String raca;
    private boolean vacinado = false;

    public Cachorro(String nome, String raca) {
        this.nome = nome;
        this.raca = raca;
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

    public String getNome() {
        return nome;
    }

    private String vacinadoToString(){
        if(vacinado) return "Vacinado";
        return "Sem vacina";
    }

    @Override
    public String toString() {
        return String.format("%s da raça %s: %s", nome, raca, vacinado ? "Vacinado" : "Sem vacina");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cachorro cachorro = (Cachorro) o;
        return Objects.equals(nome, cachorro.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
