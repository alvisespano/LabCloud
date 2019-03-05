import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SquareRoot extends Remote {

    String name = "SquareRoot";

    double calculateSquareRoot(double aNumber) throws RemoteException;
}