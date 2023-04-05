import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyRemote extends Remote {
    // the shared method
    double calculateSquareRoot(double x) throws RemoteException;

    Person makeOlder(Person p) throws RemoteException;
}