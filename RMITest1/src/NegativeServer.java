import java.rmi.RemoteException;

public class NegativeServer extends Server {

    public NegativeServer() throws RemoteException {
    }

    @Override
    public double calculateSquareRoot(double x) {
        return -Math.sqrt(x);
    }
}
