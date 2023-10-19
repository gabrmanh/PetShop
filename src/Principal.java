import java.util.NoSuchElementException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        PetShop petshop = new PetShop();

        petshop.addPessoa("505", "Kanpaku");
        petshop.addPessoa("666", "Toutetsu");
        petshop.addCachorro("505", "Bah", "Vei");
        petshop.addCachorro("505", "Geh", "No");
        petshop.addCachorro("666", "Pick", "Choose");
        petshop.addCachorro("666", "Vers", "Switch");

        System.out.println("Petshop");

        Scanner scanner = new Scanner(System.in);
        int option;

        while(true) {
            System.out.println("Selecione uma operação:");
            System.out.println("1. Adicionar pessoa");
            System.out.println("2. Adicionar cachorro");
            System.out.println("3. Remover pessoa");
            System.out.println("4. Remover cachorro");
            System.out.println("5. Listar pessoas");
            System.out.println("6. Listar cachorros de uma pessoa");
            System.out.println("7. Sair");
            option = scanner.nextInt();

            switch (option) {
                case 1 -> addPessoa(scanner, petshop);
                case 2 -> addCachorro(scanner, petshop);
                case 3 -> removePessoa(scanner, petshop);
                case 4 -> removeCachorro(scanner, petshop);
                case 5 -> petshop.listPessoas();
                case 6 -> listCachorros(scanner, petshop);
                case 7 -> {
                    System.out.println("Saindo.");
                    return;
                }
                default -> System.out.println("Entrada inválida. Digite novamente:");
            }

            System.out.println("----------");
        }

    }

    private static void listCachorros(Scanner scanner, PetShop petshop) {
        System.out.println("Digite o cpf do dono:");
        while(true) {
            try {
                String cpf = scanner.next();

                petshop.listCachorros(cpf);
                break;
            } catch (NoSuchElementException e){
                System.out.println("Cpf inválido. Digite um novo cpf:");
            }
        }
    }

    private static void removeCachorro(Scanner scanner, PetShop petshop) {
        System.out.println("Digite o cpf do dono:");
        while(true) {
            try {
                String cpf = scanner.next();
                System.out.println("Digite o nome do cachorro:");
                String nomeCachorro = scanner.next();

                petshop.removeCachorro(cpf, nomeCachorro);
                break;
            } catch(NoSuchElementException e){
                System.out.println("Cpf e/ou nome do cachorro são inválidos. Digite o cpf novamente:");
            }
        }
    }

    private static void removePessoa(Scanner scanner, PetShop petshop) {
        System.out.println("Digite o cpf:");
        while(true) {
            try {
                String cpf = scanner.next();

                petshop.removePessoa(cpf);
                break;
            } catch(NoSuchElementException e){
                System.out.println("Cpf inválido. Digite um novo cpf:");
            }
        }
    }

    private static void addCachorro(Scanner scanner, PetShop petshop) {
        System.out.println("Digite o cpf do dono:");
        while(true) {
            try {
                String cpf = scanner.next();
                System.out.println("Digite o nome do cachorro:");
                String nomeCachorro = scanner.next();
                System.out.println("Digite a raça do cachorro:");
                String raca = scanner.next();

                petshop.addCachorro(cpf, nomeCachorro, raca);
                break;
            } catch (NoSuchElementException e) {
                System.out.println("Cpf inválido. Digite um novo cpf:");
            }
        }
    }

    private static void addPessoa(Scanner scanner, PetShop petshop) {
        System.out.println("Digite o cpf:");
        String cpf = scanner.next();
        System.out.println("Digite o nome:");
        String nome = scanner.next();

        petshop.addPessoa(cpf, nome);
    }
}
