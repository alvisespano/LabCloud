import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyRemote extends Remote {

    // this is the shared method
    double calculateSquareRoot(double x) throws RemoteException;
}