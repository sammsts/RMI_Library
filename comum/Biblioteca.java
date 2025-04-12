package comum;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Biblioteca extends Remote {
    List<String> listarLivros() throws RemoteException;
    String emprestarLivro(String titulo) throws RemoteException;
    String devolverLivro(String titulo) throws RemoteException;
}
