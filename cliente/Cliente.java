package cliente;

import comum.Biblioteca;

import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            Biblioteca biblioteca = (Biblioteca) Naming.lookup("rmi://localhost/BibliotecaService");
            Scanner scanner = new Scanner(System.in);
            int opcao;

            do {
                System.out.println("\n--- Sistema de Biblioteca ---");
                System.out.println("1. Listar livros disponíveis");
                System.out.println("2. Emprestar livro");
                System.out.println("3. Devolver livro");
                System.out.println("0. Sair");
                System.out.print("Escolha: ");
                opcao = scanner.nextInt();
                scanner.nextLine(); // limpar buffer

                switch (opcao) {
                    case 1:
                        List<String> livros = biblioteca.listarLivros();
                        System.out.println("Livros disponíveis:");
                        livros.forEach(System.out::println);
                        break;
                    case 2:
                        System.out.print("Título do livro: ");
                        String emprestar = scanner.nextLine();
                        System.out.println(biblioteca.emprestarLivro(emprestar));
                        break;
                    case 3:
                        System.out.print("Título do livro: ");
                        String devolver = scanner.nextLine();
                        System.out.println(biblioteca.devolverLivro(devolver));
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } while (opcao != 0);
        scanner.close();
        } catch (Exception e) {
            System.err.println("Erro no cliente: " + e.getMessage());
        }
    }
}
