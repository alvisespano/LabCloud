import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyRemote extends Remote {

    // this is the shared method
    double calculateSquareRoot(double x) throws RemoteException;

    void store(String s) throws RemoteException;
    String retrieve() throws RemoteException;

    void makeEat(Animal a, Animal b) throws RemoteException;

}