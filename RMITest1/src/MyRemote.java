import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyRemote extends Remote {
    // the shared method
    double calculateSquareRoot(double x) throws RemoteException;

    <P extends Person> P makeOlder(P p) throws RemoteException;
}