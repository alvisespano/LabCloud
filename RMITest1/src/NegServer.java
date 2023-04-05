import java.rmi.RemoteException;

public class NegServer extends Server {
    public NegServer() throws RemoteException {
    }

    @Override
        public double calculateSquareRoot(double x) {
            return -Math.sqrt(x);
        }
    }

