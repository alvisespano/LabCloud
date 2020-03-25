import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SquareRoot extends Remote {
    String name = "//localhost/MyServer";

    double calculateSquareRoot(double aNumber) throws RemoteException;

    int getPersonAge(Person p) throws RemoteException;

    Person makeOlder(Person p, int amount) throws RemoteException;

}