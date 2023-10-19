import java.util.HashMap;
import java.util.NoSuchElementException;

public class PetShop {
    private HashMap<String, Pessoa> clientes= new HashMap<>();

    public void addPessoa(String cpf, String nome){
        clientes.put(cpf, new Pessoa(nome, cpf));
    }

    public void addCachorro(String cpf, String nomeCachorro, String raca){
        final Pessoa pessoa = clientes.get(cpf);
        if (containsPessoa(cpf))
            pessoa.adopt(nomeCachorro, raca);
        else throw new NoSuchElementException();
    }

    public void removePessoa(String cpf){
        if (containsPessoa(cpf))
            clientes.remove(cpf);
        else throw new NoSuchElementException();
    }

    public void removeCachorro(String cpf, String nomeCachorro){
        if (containsPessoa(cpf) && pessoaContainsCachorro(cpf, nomeCachorro))
            clientes.get(cpf).giveAway(nomeCachorro);
        else throw new NoSuchElementException();
    }

    public boolean containsPessoa(String cpf){
        return clientes.containsKey(cpf);
    }

    public boolean pessoaContainsCachorro(String cpf, String nomeCachorro){
        return clientes.get(cpf).containsCachorro(nomeCachorro);
    }

    public void listPessoas(){
        System.out.println("Lista de clientes:");
        clientes.values().forEach(System.out::println);
    }

    public void listCachorros(String cpf){
        if (containsPessoa(cpf))
            clientes.get(cpf).listCachorros();
        else throw new NoSuchElementException();
    }

    public void listVacinados(Boolean vaccinated, String cpf){
        if(containsPessoa(cpf))
            clientes.get(cpf).listVacinados(vaccinated);
        else throw new NoSuchElementException();
    }
}
