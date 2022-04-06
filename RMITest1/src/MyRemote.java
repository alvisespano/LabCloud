import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.function.Function;

public interface MyRemote extends Remote {
    // static nested constants
    String serviceName = "sqrt";
    String address = "localhost";
    int port = 5000;
    String rmiURI = String.format("rmi://%s:%d/%s", address, port, serviceName);

    // example 1
    double calculateSquareRoot(double x) throws RemoteException;


}