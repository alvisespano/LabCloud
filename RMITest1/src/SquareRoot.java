import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SquareRoot extends Remote {
    double calculateSquareRoot(double aNumber) throws RemoteException;
}