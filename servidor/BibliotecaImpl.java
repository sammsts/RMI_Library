package servidor;

import comum.Biblioteca;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BibliotecaImpl extends UnicastRemoteObject implements Biblioteca {

    private List<String> livrosDisponiveis;
    private List<String> livrosEmprestados;

    public BibliotecaImpl() throws RemoteException {
        super();
        livrosDisponiveis = new ArrayList<>();
        Collections.addAll(livrosDisponiveis, "1984", "Dom Casmurro", "O Hobbit", "Clean Code");
        livrosEmprestados = new ArrayList<>();
    }

    public synchronized List<String> listarLivros() {
        return new ArrayList<>(livrosDisponiveis);
    }

    public synchronized String emprestarLivro(String titulo) {
        if (livrosDisponiveis.contains(titulo)) {
            livrosDisponiveis.remove(titulo);
            livrosEmprestados.add(titulo);
            return "Livro \"" + titulo + "\" emprestado com sucesso!";
        }
        return "Livro não disponível.";
    }

    public synchronized String devolverLivro(String titulo) {
        if (livrosEmprestados.contains(titulo)) {
            livrosEmprestados.remove(titulo);
            livrosDisponiveis.add(titulo);
            return "Livro \"" + titulo + "\" devolvido com sucesso!";
        }
        return "Esse livro não está emprestado.";
    }
}
