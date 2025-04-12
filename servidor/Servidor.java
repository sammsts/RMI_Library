package servidor;

import comum.Biblioteca;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Servidor {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1098);
            Biblioteca biblioteca = new BibliotecaImpl();
            Naming.rebind("rmi://localhost/BibliotecaService", biblioteca);
            System.out.println("Servidor RMI da Biblioteca está pronto!");
        } catch (Exception e) {
            System.err.println("Erro no servidor: " + e.getMessage());
        }
    }
}
